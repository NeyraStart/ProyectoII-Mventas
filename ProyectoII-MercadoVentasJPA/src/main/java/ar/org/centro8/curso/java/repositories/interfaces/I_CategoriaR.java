package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Categoria;
import java.util.List;

public interface I_CategoriaR {
    void save(Categoria categoria);
    void remove(Categoria categoria);
    void update(Categoria categoria);
    List<Categoria>getAll();
    Categoria getByCodigo(int codigo);
    List<Categoria>getLikeNombre(String nombre);

}
