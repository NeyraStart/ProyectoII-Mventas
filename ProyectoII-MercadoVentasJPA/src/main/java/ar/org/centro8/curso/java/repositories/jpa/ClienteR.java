package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class ClienteR implements I_ClienteR{
    private I_GenericR<Cliente> gr;
    public ClienteR(EntityManager em){ gr=new GenericR(em,new Cliente());    }
    @Override public void save(Cliente cliente)   { gr.save(cliente);          }
    @Override public void remove(Cliente cliente) { gr.remove(cliente);        }
    @Override public void update(Cliente cliente) { gr.update(cliente);        }
    @Override public List<Cliente> getAll()      { return gr.getAll();       }
    @Override public Cliente getByCodigo(int codigo) {
    List<Cliente> lista=getAll()
                .stream()
                .filter(a->a.getId()==codigo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Cliente> getLikeDatosLocalidad(String datos, String localidad){
        return getAll()
                .stream()
                .filter(a->a.getDatos().toLowerCase().contains(datos.toLowerCase())
                    || a.getLocalidad().toLowerCase().contains(localidad.toLowerCase()))
                .collect(Collectors.toList());
    }    

}