package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Proveedor;
import java.util.List;

public interface I_ProveedorR {
    void save(Proveedor proveedor);
    void remove(Proveedor proveedor);
    void update(Proveedor proveedor);
    List<Proveedor>getAll();
    Proveedor getByCodigo(int codigo);
    List<Proveedor>getLikeNombreRazonSocial(String nombre,String razonSocial);

}
