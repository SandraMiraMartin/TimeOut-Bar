package codigo;

import javax.swing.*;
//import src.model.Producto;
//import src.db.ProductoDAO;

import java.awt.*;
import java.util.List;

public class VentanaVender extends JFrame {
    public VentanaVender() {
        setTitle("Vender Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10)); // Botones en forma de grid

        List<Producto> productos = ProductoDAO.obtenerProductos();

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos disponibles.");
            dispose();
            return;
        }

        for (Producto producto : productos) {
            JButton btnProducto = new JButton(producto.getNombre() + " (" + producto.getCantidad() + ")");
            btnProducto.addActionListener(e -> venderProducto(producto));
            add(btnProducto);
        }

        setVisible(true);
    }

    private void venderProducto(Producto producto) {
        ProductoDAO.descontarProducto(producto.getId());
        JOptionPane.showMessageDialog(this, "Vendiste 1 unidad de " + producto.getNombre());
        dispose();
        // Refrescar la ventana para actualizar cantidades
        new VentanaVender(); 
    }
}
