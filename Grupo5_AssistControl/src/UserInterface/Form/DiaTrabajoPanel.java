/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 29.feb.2k24
script: Creacion de la clase DiaTrabajoPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.DiaTrabajoBL;
import DataAccess.DTO.DiaTrabajoDTO;
import UserInterface.ACStyle;
import UserInterface.CustomerControl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiaTrabajoPanel extends JPanel implements ActionListener {
    private Integer idDiaTrabajo = 0, idMaxDia=0;
    private DiaTrabajoBL diaTrabajoBL = null;
    private DiaTrabajoDTO diaTrabajoDTO = null;

    public DiaTrabajoPanel() {
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
        idDiaTrabajo      = 1;
        diaTrabajoBL      = new DiaTrabajoBL();
        diaTrabajoDTO        = diaTrabajoBL.getBy(idDiaTrabajo);
        idMaxDia   = diaTrabajoBL.getMaxRow();
    }

    private void showRow() {
        boolean diaTrabajoNull = (diaTrabajoDTO == null);
        txtIdSexo.setText((diaTrabajoNull) ? " " : diaTrabajoDTO.getIdDiaTrabajo().toString());
        txtNombre.setText((diaTrabajoNull) ? " " : diaTrabajoDTO.getNombre());
        lblTotalReg.setText(idDiaTrabajo.toString() + " de " + idMaxDia.toString());
    }

    private void btnNuevoClick() {
        diaTrabajoDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean diaTrabajoNull = (diaTrabajoDTO == null);
        try {
            if (ACStyle.showConfirmYesNo("¿Seguro que desea " + ((diaTrabajoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (diaTrabajoNull)
                    diaTrabajoDTO = new DiaTrabajoDTO(txtNombre.getText());
                else
                    diaTrabajoDTO.setNombre(txtNombre.getText());
    
                if(!((diaTrabajoNull) ? diaTrabajoBL.add(diaTrabajoDTO) : diaTrabajoBL.update(diaTrabajoDTO)))
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

                if (!diaTrabajoBL.delete(diaTrabajoDTO.getIdDiaTrabajo()))
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
            if(diaTrabajoDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idDiaTrabajo = 1;
        if (e.getSource() == btnRowAnt && (idDiaTrabajo > 1))
            idDiaTrabajo--;
        if (e.getSource() == btnRowSig && (idDiaTrabajo < idMaxDia))
            idDiaTrabajo++;
        if (e.getSource() == btnRowFin)
            idDiaTrabajo = idMaxDia;
        try {
            diaTrabajoDTO    = diaTrabajoBL.getBy(idDiaTrabajo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "DiaTrabajo", "Estado"};
        Object[][] data = new Object[diaTrabajoBL.getAll().size()][3];
        int index = 0;
        for (DiaTrabajoDTO s : diaTrabajoBL.getAll()) {
            data[index][0] = s.getIdDiaTrabajo();
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
                    idDiaTrabajo = Integer.parseInt(strIdSexo);
                    try {
                        diaTrabajoDTO = diaTrabajoBL.getBy(idDiaTrabajo);
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
