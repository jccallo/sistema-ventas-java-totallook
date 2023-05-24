/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import modelos.ClienteDao;
import modelos.Store;

/**
 *
 * @author Jorge Ccallo M
 */
public class ClienteForm extends javax.swing.JInternalFrame {

    // creamos los modelos
    ClienteDao clienteDao;
    DefaultTableModel tablaModelo;

    /**
     * Creates new form ClienteForm
     */
    public ClienteForm() {
        initComponents();
        clienteDao = new ClienteDao();
        tablaModelo = new DefaultTableModel();

        nuevo();
        listar();
        lblClienteId.setVisible(false);
        lblSiExiste.setVisible(false);
    }

    // listar clientes
    private void listar() {
        List<Cliente> lista = clienteDao.listar();
        tablaModelo = (DefaultTableModel) tblTabla.getModel();

        // este objeto lo usaremos para cargar la tabla
        Object[] objeto = new Object[6];

        // recorremos la lista
        for (Cliente cliente : lista) {
            objeto[0] = cliente.getId();
            objeto[1] = cliente.getDni();
            objeto[2] = cliente.getNombre();
            objeto[3] = cliente.getTelefono();
            objeto[4] = cliente.getDireccion();
            objeto[5] = cliente.getEstado();
            tablaModelo.addRow(objeto);
            System.out.println(cliente.getId());
        }

        // seteamos el modelo con el modelo actualizao
        tblTabla.setModel(tablaModelo);

        // mostrar cantidad de clientes
        txtCantidadClientes.setText(lista.size() + " Clientes");
    }

    // agrega cliente
    private void agregar() {
        if (!verificado()) {
            return;
        };

        // obtenemos los campos del formulario
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String estado = (String) cbxEstado.getSelectedItem();

        // llenamos los datos del estudiantes
        Cliente cliente = new Cliente();
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setEstado(estado);

        // agregamos al estudiante
        boolean respuesta = clienteDao.agregar(cliente);

        // si ya existe el dni la respuesta sera false
        if (!respuesta) {
            JOptionPane.showMessageDialog(this, "No se puedo agregar. Ya existe un cliente con ese DNI.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        limpiarTabla();
        listar();
        nuevo();
        JOptionPane.showMessageDialog(this, "Cliente Agregado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    // actualizar
    private void actualizar() {
        // obtenemos los campos del formulario
        int id = Integer.parseInt(lblClienteId.getText());
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String estado = (String) cbxEstado.getSelectedItem();

        Cliente cliente = clienteDao.getById(id);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado o buscado a ningun cliente.");
            txtDni.requestFocus();
            return;
        }

        if (!verificado()) {
            return;
        };

        // llenamos los datos del estudiantes
        cliente.setId(cliente.getId());
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setEstado(estado);

        // actualizamos estudiante
        boolean respuesta = clienteDao.actualizar(cliente);

        if (!respuesta) {
            JOptionPane.showMessageDialog(this, "No se puedo Actualizar. Ya existe un cliente con ese DNI.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            nuevo();
            tblTabla.clearSelection();
            return;
        }

        limpiarTabla();
        listar();
        JOptionPane.showMessageDialog(this, "Cliente Actualizado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    private void eliminar() {
        String dni = txtDni.getText().trim();

        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI.");
            txtDni.requestFocus();
            return;
        }

        Cliente cliente = clienteDao.getByDni(dni);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No existe el usuario.");
            txtDni.requestFocus();
            return;
        }

        if (cliente.getId() == 1) {
            JOptionPane.showMessageDialog(this, "No puede eliminar al administrador.");
            txtDni.requestFocus();
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar a este cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            clienteDao.eliminar(cliente.getId());
            limpiarTabla();
            listar();
            nuevo();
            JOptionPane.showMessageDialog(this, "Cliente Eliminado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void buscar() {
        String dni = txtDni.getText().trim();

        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI.");
            txtDni.requestFocus();
            return;
        }

        Cliente cliente = clienteDao.getByDni(dni);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No existe el cliente.");
            nuevo();
            txtDni.setText(dni);
            tblTabla.clearSelection();
            return;
        }

        tblTabla.clearSelection();
        llenarCampos(cliente);
        JOptionPane.showMessageDialog(this, "Cliente encontrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    private void llenarCampos(Cliente cliente) {
        lblClienteId.setText(cliente.getId() + "");
        txtDni.setText(cliente.getDni());
        txtNombre.setText(cliente.getNombre());
        txtTelefono.setText(cliente.getTelefono());
        txtDireccion.setText(cliente.getDireccion());
        cbxEstado.setSelectedItem(cliente.getEstado());

        lblSiExiste.setVisible(true);
    }

    // limpiamos los campos del formulario
    private void nuevo() {
        lblClienteId.setText("0");
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        cbxEstado.setSelectedIndex(0);

        lblSiExiste.setVisible(false);
    }

    // limpia las filas de las tablas
    private void limpiarTabla() {
        for (int i = 0; i < tablaModelo.getRowCount(); i++) {
            tablaModelo.removeRow(i);
            i = i - 1;
        }
    }

    private boolean verificado() {
        // obtenemos los campos del formulario
        String dni = txtDni.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String estado = ((String) cbxEstado.getSelectedItem()).trim();

        if (!Store.validarDNI(dni)) {
            JOptionPane.showMessageDialog(this, "Dni debe tener 8 numeros.");
            return false;
        }

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre no puede estar vacio.");
            return false;
        }

        if (!telefono.equals("")) {
            if (!Store.validarTelefono(telefono)) {
                JOptionPane.showMessageDialog(this, "El telefono no es un numero valido.");
                return false;
            }
        }

        if (estado.equals("")) {
            JOptionPane.showMessageDialog(this, "Estado no puede estar vacio.");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnWhatsapp = new javax.swing.JButton();
        txtCantidadClientes = new javax.swing.JLabel();
        lblSiExiste = new javax.swing.JLabel();
        lblClienteId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("DNI:");

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("NOMBRE:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("DIRECCION:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("ESTADO:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("TELEFONO:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnWhatsapp.setText("WHATSAPP");
        btnWhatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhatsappActionPerformed(evt);
            }
        });

        txtCantidadClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCantidadClientes.setText("0 Clientes.");

        lblSiExiste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check-item-16x16.png"))); // NOI18N
        lblSiExiste.setText(" ");

        lblClienteId.setText("   ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addComponent(txtDireccion)
                        .addComponent(txtNombre))
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSiExiste))
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClienteId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnWhatsapp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSiExiste, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregar)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel5)
                    .addComponent(btnWhatsapp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo)
                        .addComponent(jLabel6)
                        .addComponent(txtCantidadClientes)))
                .addContainerGap())
        );

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "TELEFONO", "DIRECCION", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);
        if (tblTabla.getColumnModel().getColumnCount() > 0) {
            tblTabla.getColumnModel().getColumn(0).setMinWidth(0);
            tblTabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tblTabla.getColumnModel().getColumn(1).setMinWidth(80);
            tblTabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblTabla.getColumnModel().getColumn(1).setMaxWidth(80);
            tblTabla.getColumnModel().getColumn(3).setMinWidth(90);
            tblTabla.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblTabla.getColumnModel().getColumn(3).setMaxWidth(90);
            tblTabla.getColumnModel().getColumn(5).setMinWidth(60);
            tblTabla.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblTabla.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_txtNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        // obtenemos el numero de fila en el que clickeamos
        int fila = tblTabla.getSelectedRow();

        // accedemos a cada dato de la fila que fue seleccionada
        String id = tblTabla.getValueAt(fila, 0).toString();
        String dni = tblTabla.getValueAt(fila, 1).toString();
        String nombre = tblTabla.getValueAt(fila, 2).toString();
        String telefono = tblTabla.getValueAt(fila, 3).toString();
        String direccion = tblTabla.getValueAt(fila, 4).toString();
        String estado = tblTabla.getValueAt(fila, 5).toString();

        // establecemos los valores a los campos del formulario
        lblClienteId.setText(id); // label oculto
        txtDni.setText(dni);
        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtDireccion.setText(direccion);
        cbxEstado.setSelectedItem(estado);

        // visible icon
        lblSiExiste.setVisible(true);
    }//GEN-LAST:event_tblTablaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnWhatsappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhatsappActionPerformed
        String telefono = txtTelefono.getText();
        
        // validamos
        if (telefono.equals("") || !Store.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "El telefono debe ser un numero valido.");
            txtTelefono.requestFocus();
            return;
        }

        // enviamos mensaje por whatsapp
        Store.sendWhatsappMessage("51", txtTelefono.getText());
    }//GEN-LAST:event_btnWhatsappActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        Store.soloNumeros(evt);
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Store.soloCaracteres(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Store.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnWhatsapp;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblSiExiste;
    private javax.swing.JTable tblTabla;
    private javax.swing.JLabel txtCantidadClientes;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
