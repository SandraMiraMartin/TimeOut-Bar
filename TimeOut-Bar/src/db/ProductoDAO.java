package db;

import scr.model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public static void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, cantidad) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id"),
                                       rs.getString("nombre"),
                                       rs.getInt("cantidad")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void descontarProducto(int id) {
        String sql = "UPDATE productos SET cantidad = cantidad - 1 WHERE id = ? AND cantidad > 0";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
