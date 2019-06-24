package ar.org.centro8.curso.java.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ar.org.centro8.curso.java.entities.Almacen;
import ar.org.centro8.curso.java.entities.Categoria;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Producto;
import ar.org.centro8.curso.java.entities.Proveedor;
import ar.org.centro8.curso.java.entities.Usuario;
import ar.org.centro8.curso.java.entities.Venta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ar.org.centro8.curso.java.repositories.jpa.AlmacenR;
import ar.org.centro8.curso.java.repositories.jpa.CategoriaR;
import ar.org.centro8.curso.java.repositories.jpa.ClienteR;
import ar.org.centro8.curso.java.repositories.jpa.ProductoR;
import ar.org.centro8.curso.java.repositories.jpa.ProveedorR;
import ar.org.centro8.curso.java.repositories.jpa.UsuarioR;
import ar.org.centro8.curso.java.repositories.jpa.VentaR;
import java.util.Date;
public class TestRepository {
    
     public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b1 : b) {
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPUMV");
        EntityManager em=emf.createEntityManager();
        
        /*USUARIO*/
        System.out.println("\b");
        UsuarioR us =new UsuarioR(em);
        Usuario usuario =new Usuario("Yoel","Neyra","yn_encargado@gmail.com",(encryptPassword("156")));
        us.save(usuario);
        us.getAll().forEach(System.out::println);
        
        us.getLikeNombre("Lau").forEach(System.out::println);;
        
        /*ALMACEN*/
        System.out.println("\b");
        AlmacenR al=new AlmacenR(em);
        Almacen almacen=new Almacen("Almacen Central - 2","Corrientes 770","30 de cada mes","Almacen de multimedia y Accesorios");
        al.save(almacen);
        al.getAll().forEach(System.out::println);

        al.getByNombre("ofi").forEach(System.out::println);
        
        
        /*PROVEEDOR*/
        System.out.println("\b");
        ProveedorR pr = new ProveedorR(em);
        Proveedor proveedor = new Proveedor("30-70212055-3","Import Tech","Jorque foong","1136914780");
        pr.save(proveedor);
        pr.getAll().forEach(System.out::println);
        
        /*CATEGORIA*/
        System.out.println("\b");
        CategoriaR ct = new CategoriaR(em);
        Categoria categoria =  new Categoria("Games");
        ct.save(categoria);
        ct.getAll().forEach(System.out::println);
     
        ct.getLikeNombre("Par").forEach(System.out::println);
            
        /*PRODUCTOS*/
        System.out.println("\b");
        ProductoR prod = new ProductoR(em);
        Producto producto = new Producto(50056, "Joystick PS3", "SONY", 100, 390, 500, "", al.getByCodigo(1), ct.getByCodigo(4), pr.getByCodigo(4));
        prod.save(producto);
        prod.getAll().forEach(System.out::println);      
        prod.remove(prod.getByCodigo(50056));
        
        /*CLIENTE*/
        System.out.println("\b");
        ClienteR cl = new ClienteR(em);
        Cliente cliente = new Cliente("Walter Rioja", "1135824780", "La plata");
        cl.save(cliente);
        cl.getAll().forEach(System.out::println);
        
        /*VENTA*/
        VentaR vta = new VentaR(em);
        System.out.println("\b");
        Venta venta = new Venta(new Date(),10, 0, 650, "Garantia 1 mes", cl.getByCodigo(2), us.getByCodigo(3), prod.getByCodigo(65090));
        vta.save(venta);
        vta.getAll().forEach(System.out::println);
        
        System.out.println("\b");
        vta.getByCliente(cl.getByCodigo(1)).forEach(System.out::println);
 
    }    
}
