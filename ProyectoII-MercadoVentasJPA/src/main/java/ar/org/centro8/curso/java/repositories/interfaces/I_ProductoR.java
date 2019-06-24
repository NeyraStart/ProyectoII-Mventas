package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Producto;
import java.util.List;

public interface I_ProductoR {
    void save(Producto producto);
    void remove(Producto producto);
    void update(Producto producto);
    List<Producto>getAll();
    Producto getByCodigo(int codigo);
    List<Producto>getLikeNombreMarca(String nombre,String marca);

}
