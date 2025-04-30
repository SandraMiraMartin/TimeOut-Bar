package herramientas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

//import src.model.Producto;

import java.io.FileOutputStream;
import java.util.List;
public class PDFGenerator {
    public static void generarListaCompra(List<Producto> productos) {
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("ListaCompra.pdf"));
            documento.open();

            documento.add(new Paragraph("Lista de la Compra"));
            documento.add(new Paragraph(" ")); // Espacio en blanco

            for (Producto producto : productos) {
                documento.add(new Paragraph(producto.getNombre() + " - " + producto.getCantidad()));
            }

            documento.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
