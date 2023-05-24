/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Store;
import modelos.Vendedor;
import modelos.VendedorDao;

/**
 *
 * @author Jorge Ccallo M
 */
public class VendedorForm extends javax.swing.JInternalFrame {

    VendedorDao vendedorDao;
    DefaultTableModel tableModel;

    /**
     * Creates new form VendedorForm
     */
    public VendedorForm() {
        initComponents();
        vendedorDao = new VendedorDao();
        tableModel = (DefaultTableModel) tblVendedores.getModel();
        
        txtId.setVisible(false);
        limpiarCampos();
        listar();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cbxEstado = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtWhatsapp = new javax.swing.JButton();
        lblCantidadVendedores = new javax.swing.JLabel();
        lblCheck = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendedores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Vendedor");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("DNI:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("TELEFONO:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("ESTADO:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("USUARIO");

        cbxEstado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seller.png"))); // NOI18N

        txtWhatsapp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtWhatsapp.setText("WHATSAPP");
        txtWhatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWhatsappActionPerformed(evt);
            }
        });

        lblCantidadVendedores.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblCantidadVendedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadVendedores.setText("0 Vendedores.");

        lblCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check-item-16x16.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtTelefono)
                    .addComponent(txtUsuario)
                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCheck)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWhatsapp)
                            .addComponent(jLabel7))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCantidadVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(lblCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar)
                            .addComponent(txtWhatsapp)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar)
                            .addComponent(lblCantidadVendedores)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblVendedores.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "TELEFONO", "USUARIO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVendedoresMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendedores);
        if (tblVendedores.getColumnModel().getColumnCount() > 0) {
            tblVendedores.getColumnModel().getColumn(0).setMinWidth(0);
            tblVendedores.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblVendedores.getColumnModel().getColumn(0).setMaxWidth(0);
            tblVendedores.getColumnModel().getColumn(1).setMinWidth(80);
            tblVendedores.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblVendedores.getColumnModel().getColumn(1).setMaxWidth(80);
            tblVendedores.getColumnModel().getColumn(3).setMinWidth(80);
            tblVendedores.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblVendedores.getColumnModel().getColumn(3).setMaxWidth(80);
            tblVendedores.getColumnModel().getColumn(5).setMinWidth(60);
            tblVendedores.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblVendedores.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // listar vendedores
    private void listar() {
        List<Vendedor> lista = vendedorDao.getAll();

        // este objeto lo usaremos para cargar la tabla
        Object[] objeto = new Object[6];

        // recorremos la lista
        for (Vendedor vendedor : lista) {
            objeto[0] = vendedor.getId();
            objeto[1] = vendedor.getDni();
            objeto[2] = vendedor.getNombre();
            objeto[3] = vendedor.getTelefono();
            objeto[4] = vendedor.getUsuario();
            objeto[5] = vendedor.getEstado();
            tableModel.addRow(objeto);
        }

        // seteamos el modelo con el modelo actualizao
        tblVendedores.setModel(tableModel);

        // mostrar cantidad de clientes
        lblCantidadVendedores.setText(lista.size() + " Vendedores");
    }

    // agregar vendedor
    private void agregar() {
        if (!validarCampos()) {
            return;
        }

        Vendedor vendedor = obtenerVendedorCampo();
        boolean respuesta = vendedorDao.insert(vendedor);

        // si ya existe el dni la respuesta sera false
        if (!respuesta) {
            JOptionPane.showMessageDialog(this, "No se puedo agregar. Ya existe un vendedor con ese DNI o Usuario", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        limpiarCampos();
        limpiarTabla();
        listar();
        JOptionPane.showMessageDialog(this, "Vendedor Agregado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    // actualizar
    private void actualizar() {
        Vendedor vendedorCampo = obtenerVendedorCampo();
        Vendedor vendedor = vendedorDao.getById(vendedorCampo.getId());

        if (vendedor == null) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado o buscado a ningun vendedor.");
            txtDni.requestFocus();
            return;
        }

        if (!validarCampos()) {
            return;
        }

        vendedor.setDni(vendedorCampo.getDni());
        vendedor.setNombre(vendedorCampo.getNombre());
        vendedor.setTelefono(vendedorCampo.getTelefono());
        vendedor.setUsuario(vendedorCampo.getUsuario());
        vendedor.setEstado(vendedorCampo.getEstado());

        boolean respuesta = vendedorDao.update(vendedor);

        if (!respuesta) {
            JOptionPane.showMessageDialog(this, "No se puedo Actualizar. Ya existe un vendedor con ese DNI o Usuario.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            txtDni.requestFocus();
            return;
        }

        limpiarTabla();
        listar();
        JOptionPane.showMessageDialog(this, "Vendedor Actualizado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void eliminar() {
        String dni = txtDni.getText().trim();

        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI.");
            txtDni.requestFocus();
            return;
        }

        Vendedor vendedor = vendedorDao.getByDni(dni);

        if (vendedor == null) {
            JOptionPane.showMessageDialog(this, "No existe el vendedor.");
            txtDni.requestFocus();
            return;
        }

        if (vendedor.getId() == 1) {
            JOptionPane.showMessageDialog(this, "No puede eliminar al administrador.");
            txtDni.requestFocus();
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar a este vendedor?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            vendedorDao.eliminar(vendedor.getId());
            limpiarCampos();
            limpiarTabla();
            listar();
            JOptionPane.showMessageDialog(this, "Vendedor Eliminado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void buscar() {
        String dni = txtDni.getText().trim();

        if (dni.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero de DNI.");
            txtDni.requestFocus();
            return;
        }

        Vendedor vendedor = vendedorDao.getByDni(dni);

        if (vendedor == null) {
            JOptionPane.showMessageDialog(this, "No existe el vendedor.");
            txtDni.requestFocus();
            return;
        }
        
        tblVendedores.clearSelection();
        llenarCampos(vendedor);
        JOptionPane.showMessageDialog(this, "Vendedor encontrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    // limpia las filas de la tabla
    private void limpiarTabla() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.removeRow(i);
            i = i - 1;
        }
    }

    // obtener datos del vendedor de los campos
    private Vendedor obtenerVendedorCampo() {
        int id = Integer.parseInt(txtId.getText());
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String usuario = txtUsuario.getText();
        String estado = (String) cbxEstado.getSelectedItem();

        Vendedor vendedor = new Vendedor();
        vendedor.setId(id);
        vendedor.setDni(dni);
        vendedor.setNombre(nombre);
        vendedor.setTelefono(telefono);
        vendedor.setUsuario(usuario);
        vendedor.setEstado(estado);

        return vendedor;
    }

    // validar vendedor a agregar
    private boolean validarCampos() {
        String dni = txtDni.getText().trim();
        String nombre = txtNombre.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (!Store.validarDNI(dni)) {
            JOptionPane.showMessageDialog(this, "Dni debe tener 8 numeros.");
            return false;
        }

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre no puede estar vacio.");
            return false;
        }

        if (usuario.equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario no puede estar vacio.");
            return false;
        }

        if (!telefono.equals("")) {
            if (!Store.validarTelefono(telefono)) {
                JOptionPane.showMessageDialog(this, "El telefono no es un numero valido.");
                return false;
            }
        }

        return true;
    }

    // llenar campos con el modelo
    private void llenarCampos(Vendedor vendedor) {
        txtId.setText(Integer.toString(vendedor.getId())); // usamos toString de Integer
        txtDni.setText(vendedor.getDni());
        txtNombre.setText(vendedor.getNombre());
        txtTelefono.setText(vendedor.getTelefono());
        txtUsuario.setText(vendedor.getUsuario());
        cbxEstado.setSelectedItem(vendedor.getEstado());
        lblCheck.setVisible(true);
    }

    private void limpiarCampos() {
        txtId.setText("0"); // usamos toString de Integer
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        cbxEstado.setSelectedItem(0);
        lblCheck.setVisible(false);
    }

    private Vendedor extraerVendedorTabla() {
        // obtenemos el numero de fila en el que clickeamos
        int fila = tblVendedores.getSelectedRow();

        // accedemos a cada dato de la fila que fue seleccionada
        String id = tblVendedores.getValueAt(fila, 0).toString();
        String dni = tblVendedores.getValueAt(fila, 1).toString();
        String nombre = tblVendedores.getValueAt(fila, 2).toString();
        String telefono = tblVendedores.getValueAt(fila, 3).toString();
        String usuario = tblVendedores.getValueAt(fila, 4).toString();
        String estado = tblVendedores.getValueAt(fila, 5).toString();

        Vendedor vendedor = new Vendedor(
                (int) tblVendedores.getValueAt(fila, 0),
                tblVendedores.getValueAt(fila, 1).toString(),
                tblVendedores.getValueAt(fila, 2).toString(),
                tblVendedores.getValueAt(fila, 3).toString(),
                tblVendedores.getValueAt(fila, 4).toString(),
                tblVendedores.getValueAt(fila, 5).toString()
        );

        return vendedor;
    }
    
    private void enviarMensajeWhatsapp() {
        String telefono = txtTelefono.getText();
        
        // validamos
        if (telefono.equals("") || !Store.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "El telefono debe ser un numero valido.");
            txtTelefono.requestFocus();
            return;
        }

        // enviamos mensaje por whatsapp (solo Peru)
        Store.sendWhatsappMessage("51", txtTelefono.getText());
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblVendedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendedoresMousePressed
        llenarCampos(extraerVendedorTabla());
    }//GEN-LAST:event_tblVendedoresMousePressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtWhatsappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWhatsappActionPerformed
        enviarMensajeWhatsapp();
    }//GEN-LAST:event_txtWhatsappActionPerformed

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
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadVendedores;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JTable tblVendedores;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JButton txtWhatsapp;
    // End of variables declaration//GEN-END:variables
}