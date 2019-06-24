package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Almacen;
import java.util.List;

public interface I_AlmacenR {
    void save(Almacen almacen);
    void remove(Almacen almacen);
    void update(Almacen almacen);
    List<Almacen>getAll();
    Almacen getByCodigo(int codigo);
    List<Almacen>getByNombre(String nombre);
    List<Almacen>getLikeNombreDireccion(String nombre,String direccion);

}
