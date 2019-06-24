package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Producto;
import ar.org.centro8.curso.java.entities.Venta;
import java.util.List;

public interface I_VentaR {
    void save(Venta venta);
    void remove(Venta venta);
    void update(Venta venta);
    List<Venta>getAll();
    Venta getById(int id);

    List<Venta>getLikeVentaCliente(int idventa,Cliente idcliente);
    List<Venta>getByCliente(Cliente idcliente);
    

}
