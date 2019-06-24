package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Almacen;
import ar.org.centro8.curso.java.repositories.interfaces.I_AlmacenR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class AlmacenR implements I_AlmacenR{
    private I_GenericR<Almacen> gr;
    public AlmacenR(EntityManager em){ gr=new GenericR(em,new Almacen());    }
    @Override public void save(Almacen almacen)   { gr.save(almacen);          }
    @Override public void remove(Almacen almacen) { gr.remove(almacen);        }
    @Override public void update(Almacen almacen) { gr.update(almacen);        }
    @Override public List<Almacen> getAll()      { return gr.getAll();       }
    @Override public Almacen getByCodigo(int codigo) {
    List<Almacen> lista=getAll()
                .stream()
                .filter(a->a.getId()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Almacen> getLikeNombreDireccion(String nombre, String direccion) {
        return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase())
                    || a.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                .collect(Collectors.toList());
    }    

    @Override
    public List<Almacen> getByNombre(String nombre) {
    return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}