/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 29.feb.2k24
script: Creacion de la clase EmpleadoHorarioPanel 
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.EmpleadoHorarioBL;
import DataAccess.DTO.EmpleadoHorarioDTO;
import UserInterface.ACStyle;
import UserInterface.CustomerControl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpleadoHorarioPanel extends JPanel implements ActionListener {
    private Integer idEmpleadoHorario = 0, idMaxEmpleadoHorario=0;
    private EmpleadoHorarioBL empleadoHorarioBL = null;
    private EmpleadoHorarioDTO empleadoDTO = null;

    public EmpleadoHorarioPanel() {
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
        idEmpleadoHorario      = 1;
        empleadoHorarioBL      = new EmpleadoHorarioBL();
        empleadoDTO        = empleadoHorarioBL.getBy(idEmpleadoHorario);
        idMaxEmpleadoHorario   = empleadoHorarioBL.getMaxRow();
    }

    private void showRow() {
        boolean EmpleadoHorarioNull = (empleadoDTO == null);
        txtIdEmpleadoHorario.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdEmpleadoHorario().toString());
        txtIdDiaTrabajo.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdDiaTrabajo().toString());
        txtIdHoraAmEntrada.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdHoraAmEntrada().toString());
        txtIdHoraAmSalida.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdHoraAmSalida().toString());
        txtIdHoraPmEntrada.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdHoraPmEntrada().toString());
        txtIdHoraPmSalida.setText((EmpleadoHorarioNull) ? "" : empleadoDTO.getIdHoraPmSalida().toString());
        lblTotalReg.setText(idEmpleadoHorario.toString() + " de " + idMaxEmpleadoHorario.toString());
    }

    private void btnNuevoClick() {
        empleadoDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean EmpleadoHorarioNull = (empleadoDTO == null);
        try {
            if (ACStyle.showConfirmYesNo("¿Seguro que desea " + ((EmpleadoHorarioNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (EmpleadoHorarioNull)
                    empleadoDTO = new EmpleadoHorarioDTO(Integer.parseInt(txtIdDiaTrabajo.getText())
                                                        ,Integer.parseInt(txtIdHoraAmEntrada.getText())
                                                        ,Integer.parseInt(txtIdHoraAmSalida.getText())
                                                        ,Integer.parseInt(txtIdHoraPmEntrada.getText())
                                                        ,Integer.parseInt(txtIdHoraPmSalida.getText()));
                else
                    empleadoDTO.setIdDiaTrabajo(Integer.parseInt(txtIdDiaTrabajo.getText()));
                    empleadoDTO.setIdHoraAmEntrada(Integer.parseInt(txtIdHoraAmEntrada.getText()));
                    empleadoDTO.setIdHoraAmSalida(Integer.parseInt(txtIdHoraAmSalida.getText()));
                    empleadoDTO.setIdHoraPmEntrada(Integer.parseInt(txtIdHoraPmEntrada.getText()));
                    empleadoDTO.setIdHoraPmSalida(Integer.parseInt(txtIdHoraPmSalida.getText()));
    
                if(!((EmpleadoHorarioNull) ? empleadoHorarioBL.add(empleadoDTO) : empleadoHorarioBL.update(empleadoDTO)))
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

                if (!empleadoHorarioBL.delete(empleadoDTO.getIdEmpleadoHorario()))
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
            if(empleadoDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idEmpleadoHorario = 1;
        if (e.getSource() == btnRowAnt && (idEmpleadoHorario > 1))
            idEmpleadoHorario--;
        if (e.getSource() == btnRowSig && (idEmpleadoHorario < idMaxEmpleadoHorario))
            idEmpleadoHorario++;
        if (e.getSource() == btnRowFin)
            idEmpleadoHorario = idMaxEmpleadoHorario;
        try {
            empleadoDTO    = empleadoHorarioBL.getBy(idEmpleadoHorario);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "IdDiaTrabajo", "IdHoraAmEntrada", "IdHoraAmSalida", "IdHoraPmEntrada", "IdHoraPmSalida"};
        Object[][] data = new Object[empleadoHorarioBL.getAll().size()][6];
        int index = 0;
        for (EmpleadoHorarioDTO s : empleadoHorarioBL.getAll()) {
            data[index][0] = s.getIdEmpleadoHorario();
            data[index][1] = s.getIdDiaTrabajo();
            data[index][2] = s.getIdHoraAmEntrada();
            data[index][3] = s.getIdHoraAmSalida();
            data[index][4] = s.getIdHoraPmEntrada();
            data[index][5] = s.getIdHoraPmSalida();
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
                    String strIdEmpleadoHorario = table.getModel().getValueAt(row, 0).toString();
                    idEmpleadoHorario = Integer.parseInt(strIdEmpleadoHorario);
                    try {
                        empleadoDTO = empleadoHorarioBL.getBy(idEmpleadoHorario);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdEmpleadoHorario);
                }
            }
        });
    }

/**************************
 * FormDesing : mateitopro*
 **************************/ 
    private ACLabel 
            lblTitulo   = new ACLabel("EmpleadoHorario"),
            lblIdEmpleadoHorario   = new ACLabel(" Codigo:      "),
            lblIdDiaTrabajo   = new ACLabel("IdDiaTrabajo: "),
            lblIdHoraAmEntrada   = new ACLabel("IdHoraAmEntrada: "),
            lblIdHoraAmSalida   = new ACLabel("IdHoraAmSalida: "),
            lblIdHoraPmEntrada  = new ACLabel("IdHoraPmEntrada: "),
            lblIdHoraPmSalida  = new ACLabel("IdHoraPmSalida: "),
            lblTotalReg = new ACLabel(" 0 de 0 ");
    private ACTextBox 
            txtIdEmpleadoHorario   = new ACTextBox(),
            txtIdDiaTrabajo   = new ACTextBox(),
            txtIdHoraAmEntrada = new ACTextBox(),
            txtIdHoraAmSalida = new ACTextBox(),
            txtIdHoraPmEntrada = new ACTextBox(),
            txtIdHoraPmSalida = new ACTextBox();
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
        
        txtIdEmpleadoHorario.setEnabled(false);
        txtIdEmpleadoHorario.setBorderLine();
        txtIdDiaTrabajo.setBorderLine();

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
        add(lblIdEmpleadoHorario, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdEmpleadoHorario, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblIdDiaTrabajo, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdDiaTrabajo, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        add(lblIdHoraAmEntrada, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdHoraAmEntrada, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(lblIdHoraAmSalida, gbc);
        gbc.gridy = 8;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdHoraAmSalida, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(lblIdHoraPmEntrada, gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdHoraPmEntrada, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        add(lblIdHoraPmSalida, gbc);
        gbc.gridy = 10;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtIdHoraPmSalida, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }   
}
