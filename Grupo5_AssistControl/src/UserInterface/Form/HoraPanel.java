/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 29.feb.2k24
script: Creacion de la clase MainFormAdmin 
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.HoraBL;
import DataAccess.DTO.HoraDTO;
import UserInterface.ACStyle;
import UserInterface.CustomerControl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoraPanel extends JPanel implements ActionListener {
    private Integer idHora = 0, idMaxHora=0;
    private HoraBL horaBL = null;
    private HoraDTO hora = null;

    public HoraPanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            ACStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idHora      = 1;
        horaBL      = new HoraBL();
        hora        = horaBL.getBy(idHora);
        idMaxHora   = horaBL.getMaxRow();
    }

    private void showRow() {
        boolean horaNull = (hora == null);
        txtIdSexo.setText((horaNull) ? " " : hora.getIdHora().toString());
        txtNombre.setText((horaNull) ? " " : hora.getNombre());
        lblTotalReg.setText(idHora.toString() + " de " + idMaxHora.toString());
    }

    private void btnNuevoClick() {
        hora = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean horaNull = (hora == null);
        try {
            if (ACStyle.showConfirmYesNo("¿Seguro que desea " + ((horaNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (horaNull)
                    hora = new HoraDTO(txtNombre.getText());
                else
                    hora.setNombre(txtNombre.getText());
    
                if(!((horaNull) ? horaBL.add(hora) : horaBL.update(hora)))
                    ACStyle.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            ACStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (ACStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!horaBL.delete(hora.getIdHora()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            ACStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(hora == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idHora = 1;
        if (e.getSource() == btnRowAnt && (idHora > 1))
            idHora--;
        if (e.getSource() == btnRowSig && (idHora < idMaxHora))
            idHora++;
        if (e.getSource() == btnRowFin)
            idHora = idMaxHora;
        try {
            hora    = horaBL.getBy(idHora);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Hora", "Estado"};
        Object[][] data = new Object[horaBL.getAll().size()][3];
        int index = 0;
        for (HoraDTO s : horaBL.getAll()) {
            data[index][0] = s.getIdHora();
            data[index][1] = s.getNombre();
            data[index][2] = s.getEstado();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdSexo = table.getModel().getValueAt(row, 0).toString();
                    idHora = Integer.parseInt(strIdSexo);
                    try {
                        hora = horaBL.getBy(idHora);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdSexo);
                }
            }
        });
    }

/**************************
 * FormDesing : mateitopro*
 **************************/ 
    private ACLabel 
            lblTitulo   = new ACLabel("Hora"),
            lblIdSexo   = new ACLabel(" Codigo:      "),
            lblNombre   = new ACLabel("*Descripción: "),
            lblTotalReg = new ACLabel(" 0 de 0 ");
    private ACTextBox 
            txtIdSexo   = new ACTextBox(),
            txtNombre   = new ACTextBox();
    private ACButton 
            btnPageIni  = new ACButton(" |< "),
            btnPageAnt  = new ACButton(" << "),
            btnPageSig  = new ACButton(" >> "),
            btnPageFin  = new ACButton(" >| "),

            btnRowIni   = new ACButton(" |< "),
            btnRowAnt   = new ACButton(" << "),
            btnRowSig   = new ACButton(" >> "),
            btnRowFin   = new ACButton(" >| "),

            btnNuevo    = new ACButton("Nuevo"),
            btnGuardar  = new ACButton("Guardar"),
            btnCancelar = new ACButton("Cancelar"),
            btnEliminar = new ACButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdSexo.setEnabled(false);
        txtIdSexo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new ACLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new ACLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(ACStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdSexo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdSexo, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtNombre, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
