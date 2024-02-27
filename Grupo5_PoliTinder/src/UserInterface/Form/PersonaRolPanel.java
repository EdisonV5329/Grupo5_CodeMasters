/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 26.feb.2k24
Script: Creacion de la clase PersonaRolPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.PersonaRolBL;
import DataAccess.DTO.PersonaRolDTO;
import UserInterface.CustomeControls.Style;
import UserInterface.CustomeControls.Button;
import UserInterface.CustomeControls.Label;
import UserInterface.CustomeControls.TextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonaRolPanel  extends JPanel implements ActionListener {
    private Integer idPersonaRol = 0, idMaxPersonaRol=0;
    private PersonaRolBL personaRolBL = null;
    private PersonaRolDTO personaRolDTO = null;
    private boolean clicado = false;
    
    public boolean isClicado() {
            return clicado;
    }

    public PersonaRolPanel() {
        try {
            customizeComponent();
            loadRow();
            // JOptionPane.showMessageDialog(null, "aqui");
            showRow();
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
            Style.showMsg(e.getMessage());
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
        idPersonaRol      = 1;
        personaRolBL      = new PersonaRolBL();
        personaRolDTO        = personaRolBL.getBy(idPersonaRol);
        idMaxPersonaRol   = personaRolBL.getMaxId();
    }

    private void showRow() throws Exception {
        boolean personaRolDTONull = (personaRolDTO == null);
        txtIdpersonaRolDTO.setText((personaRolDTONull) ? "" : personaRolDTO.getIdPersonaRol().toString());
        // personaRolBL      = new PersonaRolBL();
        txtIdpersonaRolPadre.setText((personaRolDTONull) ? "" : personaRolBL.getBy(personaRolDTO.getIdPersonaRol_Padre()).getNombre()); // cambios

        // txtIdpersonaRolPadre.setText((personaRolDTONull) ? "" : personaRolDTO.getIdPersonaRol_Padre().toString()); // cambios
        txtNombre.setText((personaRolDTONull) ? "" : personaRolDTO.getNombre());
        lblTotalReg.setText(idPersonaRol.toString() + " de " + idMaxPersonaRol.toString());
    }

    private void btnNuevoClick() throws Exception {
        personaRolDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean personaRolDTONull = (personaRolDTO == null);
        try {
            if (Style.showConfirmYesNo("¿Seguro que desea " + ((personaRolDTONull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                String idPerRolPadre = txtIdpersonaRolPadre.getText();
                if (personaRolDTONull)
                    personaRolDTO = new PersonaRolDTO(Integer.parseInt(idPerRolPadre), txtNombre.getText());
                else{
                    personaRolDTO.setNombre(txtNombre.getText());
                    personaRolDTO.setIdPersonaRol_Padre(Integer.parseInt(idPerRolPadre));
                }
    
                if(!((personaRolDTONull) ? personaRolBL.add(personaRolDTO.getNombre(), 
                    personaRolDTO.getIdPersonaRol_Padre()) : personaRolBL.update(personaRolDTO.getIdPersonaRol(),
                     personaRolDTO.getNombre(), personaRolDTO.getIdPersonaRol_Padre())))
                    Style.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable(btnVerInactivos.getText());
            }
        } catch (Exception e) {
            Style.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (Style.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!personaRolBL.delete(personaRolDTO.getIdPersonaRol()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable(btnVerInactivos.getText());
            }
        } catch (Exception e) {
            Style.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(personaRolDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idPersonaRol = 1;
        if (e.getSource() == btnRowAnt && (idPersonaRol > 1))
            idPersonaRol--;
        if (e.getSource() == btnRowSig && (idPersonaRol < idMaxPersonaRol))
            idPersonaRol++;
        if (e.getSource() == btnRowFin)
            idPersonaRol = idMaxPersonaRol;
        try {
            personaRolDTO    = personaRolBL.getBy(idPersonaRol);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable(String activo) throws Exception {
        String[] header = {"Id", "Jefe", "Nombre"/*,  "Estado" */}; // cambio
        Object[][] data = new Object[personaRolBL.getAll().size()][3]; // cambio
        int index = 0;
        for (PersonaRolDTO s : personaRolBL.getAll()) {
            if(s.getEstado().equals(activo)){
                data[index][0] = s.getIdPersonaRol();
                // data[index][1] = s.getIdPersonaRol_Padre(); // cambio
                data[index][1] = personaRolBL.getBy(s.getIdPersonaRol_Padre()).getNombre(); // cambio
                data[index][2] = s.getNombre();
                // data[index][3] = s.getEstado();
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
                    idPersonaRol = Integer.parseInt(strIdpersonaRolDTO);
                    try {
                        personaRolDTO = personaRolBL.getBy(idPersonaRol);
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
            lblTitulo   = new Label("personaRolDTO"),
            lblIdpersonaRolDTO   = new Label(" Codigo:"),
            lblIdpersonaRolPadre   = new Label(" Codigo Padre:"),
            lblNombre   = new Label("Nombre:"),
            lblTotalReg = new Label(" 0 de 0 ");
    private TextBox 
            txtIdpersonaRolDTO   = new TextBox(),
            txtIdpersonaRolPadre = new TextBox(), // cambio
            txtNombre   = new TextBox();
    private Button 
            btnPageIni  = new Button(" |< "),
            btnPageAnt  = new Button(" << "),
            btnPageSig  = new Button(" >> "),
            btnPageFin  = new Button(" >| "),

            btnRowIni   = new Button(" |< "),
            btnRowAnt   = new Button(" << "),
            btnRowSig   = new Button(" >> "),
            btnRowFin   = new Button(" >| "),

            btnNuevo        = new Button("Nuevo"),
            btnGuardar      = new Button("Guardar"),
            btnCancelar     = new Button("Cancelar"),
            btnEliminar     = new Button("Eliminar"),
            btnVerInactivos = new Button("A");

    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdpersonaRolDTO.setEnabled(false);
        txtIdpersonaRolDTO.setBorderLine();
        txtIdpersonaRolPadre.setBorderLine();
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
        pnlBtnCRUD.add(btnVerInactivos);
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
        add(lblIdpersonaRolDTO, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdpersonaRolDTO, gbc);

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
        add(lblIdpersonaRolPadre, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdpersonaRolPadre, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}