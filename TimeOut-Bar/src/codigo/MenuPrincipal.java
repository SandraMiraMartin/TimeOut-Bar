package codigo;

import java.awt.*;
import javax.swing.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {

        setTitle("Gestión de Productos");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAnadir = new JButton("Añadir Producto");
        JButton btnVender = new JButton("Vender Producto");
        JButton btnListaCompra = new JButton("Lista de la Compra");

        btnAnadir.addActionListener(e -> new VentanaAnadir());
        btnVender.addActionListener(e -> new VentanaVender());
        btnListaCompra.addActionListener(e -> new VentanaListaCompra());

        add(btnAnadir);
        add(btnVender);
        add(btnListaCompra);

        setVisible(true);
    }
}
