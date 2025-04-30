package codigo;

import javax.swing.*;
//import src.model.Producto;
//import src.db.ProductoDAO;
//import src.utils.PDFGenerator;

import java.awt.*;
import java.util.List;

public class VentanaListaCompra extends JFrame{
    public VentanaListaCompra() {
        setTitle("Lista de la Compra");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        List<Producto> productos = ProductoDAO.obtenerProductos();

        JTextArea areaProductos = new JTextArea();
        productos.forEach(p -> areaProductos.append(p.getNombre() + " - " + p.getCantidad() + "\n"));
        areaProductos.setEditable(false);

        JButton btnGenerarPDF = new JButton("Generar PDF");
        btnGenerarPDF.addActionListener(e -> {
            PDFGenerator.generarListaCompra(productos);
            JOptionPane.showMessageDialog(this, "PDF generado correctamente.");
        });

        add(new JScrollPane(areaProductos), BorderLayout.CENTER);
        add(btnGenerarPDF, BorderLayout.SOUTH);

        setVisible(true);
    }
}
