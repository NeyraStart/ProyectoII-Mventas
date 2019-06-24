package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Usuario;
import java.util.List;

public interface I_UsuarioR {
    void save(Usuario usuario);
    void remove(Usuario usuario);
    void update(Usuario usuario);
    List<Usuario>getAll();
    Usuario getByCodigo(int codigo);
    List<Usuario>getLikeNombre(String nombre);
    List<Usuario>getLikeNombreApellido(String nombre,String apellido);

}
