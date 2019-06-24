package ar.org.centro8.curso.java.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import ar.org.centro8.curso.java.entities.Almacen;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPUMV");
        EntityManager em=emf.createEntityManager();
        
       Almacen almacen=new Almacen("Almacen Deposito","Pasteur 277","15 de cada mes","Sin descripcion");
     
        em.getTransaction().begin();
        em.persist(almacen);
        em.getTransaction().commit();
        
        System.out.println("\b");
        System.out.println(almacen);
        
        em
                .createNamedQuery("Almacen.findAll")
                .getResultList()
                .forEach(System.out::println);
        
        em.close();
        emf.close();
    }
}