package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Categoria;
import ar.org.centro8.curso.java.entities.Categoria;
import ar.org.centro8.curso.java.repositories.interfaces.I_CategoriaR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class CategoriaR implements I_CategoriaR{
    private I_GenericR<Categoria> gr;
    public CategoriaR(EntityManager em){ gr=new GenericR(em,new Categoria());    }
    @Override public void save(Categoria categoria)   { gr.save(categoria);          }
    @Override public void remove(Categoria categoria) { gr.remove(categoria);        }
    @Override public void update(Categoria categoria) { gr.update(categoria);        }
    @Override public List<Categoria> getAll()      { return gr.getAll();       }
    @Override public Categoria getByCodigo(int codigo) {
    List<Categoria> lista=getAll()
                .stream()
                .filter(a->a.getId()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Categoria> getLikeNombre(String nombre)  {
        return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }    

}