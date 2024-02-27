    /*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 27.feb.2k24
Script: Creacion de la clase EmpleadoPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.CargoBL;
import BusinessLogic.EmpleadoBL;
import DataAccess.DTO.EmpleadoDTO;
import UserInterface.ACStyle;
import UserInterface.CustomerControl.ACButton;
import UserInterface.CustomerControl.ACLabel;
import UserInterface.CustomerControl.ACTextBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpleadoPanel  extends JPanel implements ActionListener {
    private Integer idEmpleado = 0, idMaxEmpleado=0;
    private EmpleadoBL empleadoBL = null;
    private EmpleadoDTO empleadoDTO = null;
    private CargoBL cargoBL = new CargoBL();
    
    private boolean clicado = false;
    
    public boolean isClicado() {
            return clicado;
    }

    public EmpleadoPanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            // JOptionPane.showMessageDialog(null, "aqui");
            showTable(btnVerInactivos.getText());

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> {
                try {
                    btnNuevoClick();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
            btnVerInactivos.addActionListener(  e -> {
                try {
                    btnVerInactivos();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            // btnVerInactivos();
        } catch (Exception e) {
            ACStyle.showMsg(e.getMessage());
        }
    }

    private void btnVerInactivos() throws Exception {
        btnVerInactivos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clicado) {
                    btnVerInactivos.setText("X");
                    clicado = false;
                } else {
                    btnVerInactivos.setText("A");
                    clicado = true;
                }
            }
        });
        showTable(btnVerInactivos.getText());
    }

    private void loadRow() throws Exception {
        idEmpleado      = 1;
        empleadoBL      = new EmpleadoBL();
        empleadoDTO    = empleadoBL.getBy(idEmpleado);
        idMaxEmpleado   = empleadoBL.getMaxId();
    }

    private void showRow() throws Exception {
        boolean empleadoDTONull = (empleadoDTO == null);
        txtIdEmpleadoDTO.setText((empleadoDTONull) ? "" : empleadoDTO.getIdEmpleado().toString());
        txtIdCargo.setText((empleadoDTONull) ? "" : empleadoDTO.getIdCargo().toString());
        txtIdCargo.setText((empleadoDTONull) ? "" : cargoBL.getBy(empleadoDTO.getIdCargo()).getNombre()); // cambios
        txtNombre.setText((empleadoDTONull) ? "" : empleadoDTO.getNombre());
        txtApellido.setText((empleadoDTONull) ? "" : empleadoDTO.getApellido());
        txtCedula.setText((empleadoDTONull) ? "" : empleadoDTO.getCedula());
        txtCodigoBarra.setText((empleadoDTONull) ? "" : empleadoDTO.getCodigoBarras());
        lblTotalReg.setText(idEmpleado.toString() + " de " + idMaxEmpleado.toString());
    }

    private void btnNuevoClick() throws Exception {
        empleadoDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean personaRolDTONull = (empleadoDTO == null);
        try {
            if (ACStyle.showConfirmYesNo("¿Seguro que desea " + ((personaRolDTONull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                String idCargo = txtIdCargo.getText();
                if (personaRolDTONull)
                    empleadoDTO = new EmpleadoDTO(Integer.parseInt(idCargo), txtNombre.getText(), txtApellido.getText(),
                                    txtCedula.getText(), txtCodigoBarra.getText());
                else{
                    empleadoDTO.setIdCargo(Integer.parseInt(idCargo));
                    empleadoDTO.setNombre(txtNombre.getText());
                    empleadoDTO.setApellido(txtApellido.getText());
                    empleadoDTO.setCedula(txtCedula.getText());
                    empleadoDTO.setCodigoBarras(txtCodigoBarra.getText());
                }
    
                if(!((personaRolDTONull) ? empleadoBL.add(empleadoDTO.getNombre(), empleadoDTO.getApellido(),
                    empleadoDTO.getIdCargo(), empleadoDTO.getCedula(), empleadoDTO.getCodigoBarras()) 
                    : empleadoBL.update(empleadoDTO.getNombre(), empleadoDTO.getApellido(), empleadoDTO.getIdCargo(),
                      empleadoDTO.getIdEmpleado())))
                    ACStyle.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable(btnVerInactivos.getText());
            }
        } catch (Exception e) {
            ACStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (ACStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!empleadoBL.delete(empleadoDTO.getIdEmpleado()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable(btnVerInactivos.getText());
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
            idEmpleado = 1;
        if (e.getSource() == btnRowAnt && (idEmpleado > 1))
            idEmpleado--;
        if (e.getSource() == btnRowSig && (idEmpleado < idMaxEmpleado))
            idEmpleado++;
        if (e.getSource() == btnRowFin)
            idEmpleado = idMaxEmpleado;
        try {
            empleadoDTO    = empleadoBL.getBy(idEmpleado);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable(String activo) throws Exception {
        String[] header = {"Id", "Cargo", "Nombre", "Apellido", "Cedula"/*,  "Estado" */}; // cambio
        Object[][] data = new Object[empleadoBL.getAll().size()][5]; // cambio
        int index = 0;
        for (EmpleadoDTO s : empleadoBL.getAll()) {
            if(s.getEstado().equals(activo)){
                data[index][0] = s.getIdEmpleado(); 
                data[index][1] = cargoBL.getBy(s.getIdCargo()).getNombre(); // cambio
                data[index][2] = s.getNombre();
                data[index][3] = s.getApellido();
                data[index][4] = s.getCedula();
                index++;
            }
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
                    String strIdpersonaRolDTO = table.getModel().getValueAt(row, 0).toString();
                    idEmpleado = Integer.parseInt(strIdpersonaRolDTO);
                    try {
                        empleadoDTO = empleadoBL.getBy(idEmpleado);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdpersonaRolDTO);
                }
            }
        });
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private Label 
            lblTitulo           = new Label("Tabla de empleados de la AssistControl"),
            lblIdEmpleadoDTO    = new Label("Codigo:"),
            lblIdCargo          = new Label("Cargo:"),
            lblNombre           = new Label("Nombre:"),
            lblApellido         = new Label("Apellido:"),
            lblCedula           = new Label("Cedula:"),
            lblCodigoBarra      = new Label("Codigo Baras:"),
            lblTotalReg         = new Label(" 0 de 0 ");
    private ACTextBox 
            txtIdEmpleadoDTO     = new ACTextBox(),
            txtIdCargo           = new ACTextBox(), // cambio
            txtNombre            = new ACTextBox(),
            txtApellido          = new ACTextBox(),
            txtCedula            = new ACTextBox(),
            txtCodigoBarra       = new ACTextBox();
    private ACButton 
            btnPageIni  = new ACButton(" |< "),
            btnPageAnt  = new ACButton(" << "),
            btnPageSig  = new ACButton(" >> "),
            btnPageFin  = new ACButton(" >| "),

            btnRowIni   = new ACButton(" |< "),
            btnRowAnt   = new ACButton(" << "),
            btnRowSig   = new ACButton(" >> "),
            btnRowFin   = new ACButton(" >| "),

            btnNuevo        = new ACButton("Nuevo"),
            btnGuardar      = new ACButton("Guardar"),
            btnCancelar     = new ACButton("Cancelar"),
            btnEliminar     = new ACButton("Eliminar"),
            btnVerInactivos = new ACButton("A");

    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdEmpleadoDTO.setEnabled(false);
        txtIdEmpleadoDTO.setBorderLine();
        txtIdCargo.setBorderLine();
        txtNombre.setBorderLine();
        txtApellido.setBorderLine();
        txtCedula.setBorderLine();
        txtCodigoBarra.setBorderLine();
        
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
        pnlBtnCRUD.add(btnVerInactivos);
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
        add(lblIdEmpleadoDTO, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdEmpleadoDTO, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblIdCargo, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdCargo, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(lblApellido, gbc);
        gbc.gridy = 8;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtApellido, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(lblCedula, gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtCedula, gbc);
        
        gbc.gridy = 10;
        gbc.gridx = 0;
        add(lblCodigoBarra, gbc);
        gbc.gridy = 10;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtCodigoBarra, gbc);
        

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}