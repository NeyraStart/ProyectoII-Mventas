package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Producto;
import ar.org.centro8.curso.java.repositories.interfaces.I_ProductoR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class ProductoR implements I_ProductoR{
    private I_GenericR<Producto> gr;
    public ProductoR(EntityManager em){ gr=new GenericR(em,new Producto());    }
    @Override public void save(Producto producto)   { gr.save(producto);          }
    @Override public void remove(Producto producto) { gr.remove(producto);        }
    @Override public void update(Producto producto) { gr.update(producto);        }
    @Override public List<Producto> getAll()      { return gr.getAll();       }
    @Override public Producto getByCodigo(int codigo) {
    List<Producto> lista=getAll()
                .stream()
                .filter(a->a.getItem()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Producto> getLikeNombreMarca(String nombre, String marca){
        return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase())
                    || a.getMarca().toLowerCase().contains(marca.toLowerCase()))
                .collect(Collectors.toList());
    }    

}