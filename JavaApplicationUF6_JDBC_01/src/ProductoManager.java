
import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;

public class ProductoManager {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAOImpl();

        // Crear nuevo producto
        Producto nuevo = new Producto(200, "Pollo", 10.0);
        dao.insert(nuevo);

        // Leer producto
        Producto p = dao.read(200);
        System.out.println("Producto leído: " + p);

        // Actualizar producto
        p.setNombre("Pollo asado");
        p.setPrecio(12.5);
        dao.update(p);

        // Leer producto actualizado
        Producto actualizado = dao.read(200);
        System.out.println("Producto actualizado: " + actualizado);


        // Comprobar que se ha eliminado
        Producto eliminado = dao.read(200);
        System.out.println("¿Producto eliminado? " + eliminado); // debería ser null
    }
}
