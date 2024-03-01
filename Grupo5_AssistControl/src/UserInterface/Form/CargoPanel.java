/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 26.feb.2k24
Metodo: CargoPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.CargoBL;
import DataAccess.DTO.CargoDTO;
import UserInterface.ACStyle;
import UserInterface.CustomerControl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CargoPanel extends JPanel implements ActionListener{
    private Integer idCargo = 0, idMaxCargo=0;
    private CargoBL cargoBL = null;
    private CargoDTO cargo = null;

    public CargoPanel(){
        try{
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
        } catch(Exception e){
            ACStyle.showMsg(e.getMessage());
        }

    }

    private void loadRow() throws Exception{
        idCargo     = 1;
        cargoBL     = new CargoBL();
        cargo       = cargoBL.getBy(idCargo);
        idMaxCargo  = cargoBL.getMaxRow();
    }

    private void showRow(){
        boolean cargoNull = (cargo == null);
        txtIdCargo.setText((cargoNull) ? "" : cargo.getIdCargo().toString());
        txtNombre.setText((cargoNull) ? "" : cargo.getNombre());
        txtIdEmpleadoHorario.setText((cargoNull) ? "" : cargo.getIdEmpleadoHorario().toString());
        lblTotalReg.setText(idCargo.toString() + " de " + idMaxCargo.toString());
    }

    private void btnNuevoClick(){
        cargo = null;
        showRow();
    }

    private void btnGuardarClick(){
        boolean cargoNull = (cargo == null);

        try {
            if (ACStyle.showConfirmYesNo("¿Seguro que desea " + ((cargoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (cargoNull) {
                    cargo = new CargoDTO(txtNombre.getText(), Integer.parseInt(txtIdEmpleadoHorario.getText()));
                } else {
                    cargo.setNombre(txtNombre.getText());
                    cargo.setIdEmpleadoHorario(Integer.parseInt(txtIdEmpleadoHorario.getText()));
                }
                if (!((cargoNull) ? cargoBL.create(cargo.getNombre(),0,cargo.getIdEmpleadoHorario()) : cargoBL.update(cargo.getIdCargo(), cargo.getNombre(), 0, 0))) // Use the correct methods with additional parameters
                    ACStyle.showMsgError("Error al guardar");

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

                if (!cargoBL.delete(cargo.getIdCargo()))
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
            if(cargo == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idCargo = 1;
        if (e.getSource() == btnRowAnt && (idCargo > 1))
            idCargo--;
        if (e.getSource() == btnRowSig && (idCargo < idMaxCargo))
            idCargo++;
        if (e.getSource() == btnRowFin)
            idCargo = idMaxCargo;
        try {
            cargo    = cargoBL.getBy(idCargo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "IdEmpleadoHorario", "Estado"};
        Object[][] data = new Object[cargoBL.getAll().size()][4];
        int index = 0;
        for (CargoDTO s : cargoBL.getAll()) {
            data[index][0] = s.getIdCargo();
            data[index][1] = s.getNombre();
            data[index][2] = s.getIdEmpleadoHorario();
            data[index][3] = s.getEstado();
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
        public void mouseClicked(MouseEvent e){
            int row = table.rowAtPoint(e.getPoint());
            int col = table.columnAtPoint(e.getPoint());
            if( row >= 0 && col >= 0){
                String strIdCargo = table.getModel().getValueAt(row, 0).toString();
                idCargo = Integer.parseInt(strIdCargo);
                try{
                    cargo = cargoBL.getBy(idCargo);
                    showRow();
                } catch (Exception ex) {
                }
                System.out.println("Tabla.Selected: " + strIdCargo);
            }

        }
    });

    }

    private ACLabel
            lblTitulo = new ACLabel("CARGO"),
            lblIdCargo = new ACLabel(" Codigo:   "),
            lblNombre = new ACLabel(" Descripcion:   "),
            lblIdEmpleadoHorario = new ACLabel(" Horario:   "),
            lblTotalReg = new ACLabel("0 de 0");
    private ACTextBox
            txtIdCargo = new ACTextBox(),
            txtNombre = new ACTextBox(),
            txtIdEmpleadoHorario = new ACTextBox();
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

    public void customizeComponent(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        txtIdCargo.setEnabled(false);
        txtIdCargo.setBorderLine();
        txtNombre.setBorderLine();
        txtIdEmpleadoHorario.setBorderLine();

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

        gbc.insets =new Insets(5, 5, 5, 5);

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
        add(lblIdCargo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdCargo, gbc);

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
        add(lblIdEmpleadoHorario, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdEmpleadoHorario, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
