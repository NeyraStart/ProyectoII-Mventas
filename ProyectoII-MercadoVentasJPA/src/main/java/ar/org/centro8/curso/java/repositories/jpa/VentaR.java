package ar.org.centro8.curso.java.repositories.jpa;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Producto;
import ar.org.centro8.curso.java.entities.Venta;
import ar.org.centro8.curso.java.repositories.interfaces.I_VentaR;
import ar.org.centro8.curso.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class VentaR implements I_VentaR{
    private I_GenericR<Venta> gr; 
    public VentaR(EntityManager em){ gr=new GenericR(em,new Venta());    }
    @Override public void save(Venta venta)   { gr.save(venta);          }
    @Override public void remove(Venta venta) { gr.remove(venta);        }
    @Override public void update(Venta venta) { gr.update(venta);        }
    @Override public List<Venta> getAll()      { return gr.getAll();       }
    @Override public Venta getById(int ventaId) {
    List<Venta> lista=getAll()
                .stream()
                .filter(a->a.getId()==ventaId)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }

    @Override
    public List<Venta> getLikeVentaCliente(int idventa, Cliente idcliente) {
                return getAll()
                .stream()
                .filter(a->a.getId()==idventa
                 || a.getIdcliente()==idcliente)
                .collect(Collectors.toList());
    
    }

    @Override
    public List<Venta> getByCliente(Cliente idcliente) {
       return getAll()
                .stream()
                .filter(a->a.getIdcliente()==idcliente)
                .collect(Collectors.toList());
    }

  }