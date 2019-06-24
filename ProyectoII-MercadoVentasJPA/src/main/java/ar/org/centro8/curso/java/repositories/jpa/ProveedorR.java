package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Proveedor;
import ar.org.centro8.curso.java.repositories.interfaces.I_ProveedorR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class ProveedorR implements I_ProveedorR{
    private I_GenericR<Proveedor> gr;
    public ProveedorR(EntityManager em){ gr=new GenericR(em,new Proveedor());    }
    @Override public void save(Proveedor proveedor)   { gr.save(proveedor);          }
    @Override public void remove(Proveedor proveedor) { gr.remove(proveedor);        }
    @Override public void update(Proveedor proveedor) { gr.update(proveedor);        }
    @Override public List<Proveedor> getAll()      { return gr.getAll();       }
    @Override public Proveedor getByCodigo(int codigo) {
    List<Proveedor> lista=getAll()
                .stream()
                .filter(a->a.getId()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Proveedor> getLikeNombreRazonSocial(String nombre, String razonSocial){
        return getAll()
                .stream()
                .filter(a->a.getNombre().toLowerCase().contains(nombre.toLowerCase())
                    || a.getRazonSocial().toLowerCase().contains(razonSocial.toLowerCase()))
                .collect(Collectors.toList());
    }    

}