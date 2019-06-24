package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Cliente;
import java.util.List;

public interface I_ClienteR {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente>getAll();
    Cliente getByCodigo(int codigo);
    List<Cliente>getLikeDatosLocalidad(String datos,String localidad);

}
