package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Usuario;
import ar.org.centro8.curso.java.repositories.interfaces.I_UsuarioR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class UsuarioR implements I_UsuarioR{
    private I_GenericR<Usuario> gr;   
    public UsuarioR(EntityManager em){ gr=new GenericR(em,new Usuario());    }
    @Override public void save(Usuario usuario)   { gr.save(usuario);          }
    @Override public void remove(Usuario usuario) { gr.remove(usuario);        }
    @Override public void update(Usuario usuario) { gr.update(usuario);        }
    @Override public List<Usuario> getAll()      { return gr.getAll();       }
    @Override public Usuario getByCodigo(int codigo) {
    List<Usuario> lista=getAll()
                .stream()
                .filter(a->a.getId()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Usuario> getLikeNombreApellido(String nombre, String apellido){
        return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase())
                    || a.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }    

    @Override
    public List<Usuario> getLikeNombre(String nombre) {
            return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

  }