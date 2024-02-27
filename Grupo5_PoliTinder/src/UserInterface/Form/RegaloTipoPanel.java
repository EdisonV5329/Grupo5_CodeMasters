/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
Script: Creacion de la clase RegaloTipoPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.RegaloTipoBL;
import DataAccess.DTO.RegaloTipoDTO;
import UserInterface.CustomeControls.Button;
import UserInterface.CustomeControls.Label;
import UserInterface.CustomeControls.Style;
import UserInterface.CustomeControls.TextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegaloTipoPanel extends JPanel implements ActionListener {
    private Integer       idRegaloTipo    = 0,
                          idMaxRegaloTipo = 0;
    private RegaloTipoBL  regaloTipoBL;
    private RegaloTipoDTO regaloTipo;

    public RegaloTipoPanel(){
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
            Style.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idRegaloTipo = 1;
        regaloTipoBL       = new RegaloTipoBL();
        regaloTipo         = regaloTipoBL.getByIdRegaloTipo(idRegaloTipo);
        idMaxRegaloTipo    = regaloTipoBL.getMaxRow();
    }

    private void showRow() {
        boolean regaloTipoNull = (regaloTipo == null);
        txtIdRegaloTipo.setText((regaloTipoNull) ? " " : regaloTipo.getIdRegaloTipo().toString());
        txtNombre.setText((regaloTipoNull) ? " " : regaloTipo.getNombre());
        lblTotalReg.setText(idRegaloTipo.toString() + " de " + idMaxRegaloTipo.toString());
    }
    
    private void btnNuevoClick() {
        regaloTipo = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean regaloTipoNull = (regaloTipo == null);
        try {
            if (Style.showConfirmYesNo("¿Seguro que desea " + ((regaloTipoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (regaloTipoNull)
                    regaloTipo = new RegaloTipoDTO(txtNombre.getText());
                else
                    regaloTipo.setNombre(txtNombre.getText());
    
                if(!((regaloTipoNull) ? regaloTipoBL.create(regaloTipo) : regaloTipoBL.update(regaloTipo)))
                    Style.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            Style.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (Style.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!regaloTipoBL.delete(regaloTipo.getIdRegaloTipo()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            Style.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(regaloTipo == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idRegaloTipo = 1;
        if (e.getSource() == btnRowAnt && (idRegaloTipo > 1))
            idRegaloTipo--;
        if (e.getSource() == btnRowSig && (idRegaloTipo < idMaxRegaloTipo))
            idRegaloTipo++;
        if (e.getSource() == btnRowFin)
            idRegaloTipo = idMaxRegaloTipo;
        try {
            regaloTipo    = regaloTipoBL.getByIdRegaloTipo(idRegaloTipo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[regaloTipoBL.getAll().size()][3];
        int index = 0;
        for (RegaloTipoDTO s : regaloTipoBL.getAll()) {
            data[index][0] = s.getIdRegaloTipo();
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
                    idRegaloTipo = Integer.parseInt(strIdSexo);
                    try {
                        regaloTipo = regaloTipoBL.getByIdRegaloTipo(idRegaloTipo);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdSexo);
                }
            }
        });
    }
/***************************
 * FormDesing : mateitopro *
 ***************************/ 
    private Label 
            lblTitulo       = new Label("RegaloTipo"),
            lblIdRegaloTipo = new Label(" Codigo:      "),
            lblNombre       = new Label("*Descripción: "),
            lblTotalReg     = new Label(" 0 de 0 ");
    private TextBox 
            txtIdRegaloTipo = new TextBox(),
            txtNombre       = new TextBox();
    private Button 
            btnPageIni  = new Button(" |< "),
            btnPageAnt  = new Button(" << "),
            btnPageSig  = new Button(" >> "),
            btnPageFin  = new Button(" >| "),

            btnRowIni   = new Button(" |< "),
            btnRowAnt   = new Button(" << "),
            btnRowSig   = new Button(" >> "),
            btnRowFin   = new Button(" >| "),

            btnNuevo    = new Button("Nuevo"),
            btnGuardar  = new Button("Guardar"),
            btnCancelar = new Button("Cancelar"),
            btnEliminar = new Button("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdRegaloTipo.setEnabled(false);
        txtIdRegaloTipo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new Label(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new Label(" ) "));
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
        pnlBtnCRUD.setBorder(Style.createBorderRect());

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
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
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
        add(lblIdRegaloTipo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdRegaloTipo, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
