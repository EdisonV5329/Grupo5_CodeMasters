/*
|------------------------------------------------|
| (Â©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
Fecha: 24.feb.2k24
script: Creacion de la clase RelacionTipoPanel
*/
package UserInterface.Form;

import javax.swing.*;
import BusinessLogic.RelacionTipoBL;
import DataAccess.DTO.RelacionTipoDTO;
import UserInterface.CustomeControls.Button;
import UserInterface.CustomeControls.Label;
import UserInterface.CustomeControls.Style;
import UserInterface.CustomeControls.TextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RelacionTipoPanel extends JPanel implements ActionListener {
    private Integer       idRelacionTipo    = 0,
                          idMaxRelacionTipo = 0;
    private RelacionTipoBL  relacionTipoBL;
    private RelacionTipoDTO relacionTipo;

    public RelacionTipoPanel(){
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
        idRelacionTipo = 1;
        relacionTipoBL       = new RelacionTipoBL();
        relacionTipo         = relacionTipoBL.getBy(idRelacionTipo);
        idMaxRelacionTipo    = relacionTipoBL.getMaxRow();
    }

    private void showRow() {
        boolean relacionTipoNull = (relacionTipo == null);
        txtIdRelacionTipo.setText((relacionTipoNull) ? " " : relacionTipo.getIdRelacionTipo().toString());
        txtNombre.setText((relacionTipoNull) ? " " : relacionTipo.getNombre());
        lblTotalReg.setText(idRelacionTipo.toString() + " de " + idMaxRelacionTipo.toString());
    }
    
    private void btnNuevoClick() {
        relacionTipo = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean relacionTipoNull = (relacionTipo == null);
        try {
            if (Style.showConfirmYesNo("¿Seguro que desea " + ((relacionTipoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (relacionTipoNull)
                    relacionTipo = new RelacionTipoDTO(txtNombre.getText());
                else
                    relacionTipo.setNombre(txtNombre.getText());
    
                if(!((relacionTipoNull) ? relacionTipoBL.add(relacionTipo) : relacionTipoBL.update(relacionTipo)))
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

                if (!relacionTipoBL.delete(relacionTipo.getIdRelacionTipo()))
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
            if(relacionTipo == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idRelacionTipo = 1;
        if (e.getSource() == btnRowAnt && (idRelacionTipo > 1))
            idRelacionTipo--;
        if (e.getSource() == btnRowSig && (idRelacionTipo < idMaxRelacionTipo))
            idRelacionTipo++;
        if (e.getSource() == btnRowFin)
            idRelacionTipo = idMaxRelacionTipo;
        try {
            relacionTipo    = relacionTipoBL.getBy(idRelacionTipo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado", "Fecha Crea", "Fecha Modifica"};
        Object[][] data = new Object[relacionTipoBL.getAll().size()][5];
        int index = 0;
        for (RelacionTipoDTO s : relacionTipoBL.getAll()) {
            data[index][0] = s.getIdRelacionTipo();
            data[index][1] = s.getNombre();
            data[index][2] = s.getEstado();
            data[index][3] = s.getFechaCrea();
            data[index][4] = s.getFechaModifica();
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
                    String strIdRelacionTipo = table.getModel().getValueAt(row, 0).toString();
                    idRelacionTipo = Integer.parseInt(strIdRelacionTipo);
                    try {
                        relacionTipo = relacionTipoBL.getBy(idRelacionTipo);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdRelacionTipo);
                }
            }
        });
    }

    private Label 
            lblTitulo       = new Label("RelacionTipo"),
            lblIdRelacionTipo = new Label(" Codigo:      "),
            lblNombre       = new Label("*Descripción: "),
            lblTotalReg     = new Label(" 0 de 0 ");
    private TextBox 
            txtIdRelacionTipo = new TextBox(),
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
        
        txtIdRelacionTipo.setEnabled(false);
        txtIdRelacionTipo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new Label(" Page:( "));
        pnlBtnPage.add(lblTotalReg);
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
        add(new JLabel(" Sección de datos: "), gbc);
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
        add(new JLabel(" Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdRelacionTipo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdRelacionTipo, gbc);

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