package codigo;

import javax.swing.*;
//import src.model.Producto;
//import src.db.ProductoDAO;
public class VentanaAnadir extends JFrame  {
    private JTextField txtNombre;
    private JTextField txtCantidad;

    public VentanaAnadir() {
        setTitle("Añadir Producto");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        txtNombre = new JTextField();
        txtCantidad = new JTextField();
        JButton btnGuardar = new JButton("Guardar");

        add(new JLabel("Nombre del producto:"));
        add(txtNombre);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(new JLabel(""));
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarProducto());

        setVisible(true);
    }

    private void guardarProducto() {
        String nombre = txtNombre.getText();
        int cantidad;

        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
            Producto producto = new Producto(nombre, cantidad);
            ProductoDAO.insertarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida. Debe ser un número.");
        }
    }
}
