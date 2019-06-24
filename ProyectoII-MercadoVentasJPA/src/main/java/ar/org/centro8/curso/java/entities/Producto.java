/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByItem", query = "SELECT p FROM Producto p WHERE p.item = :item"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByPrecCompra", query = "SELECT p FROM Producto p WHERE p.precCompra = :precCompra"),
    @NamedQuery(name = "Producto.findByPrecVenta", query = "SELECT p FROM Producto p WHERE p.precVenta = :precVenta"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item")
    private Integer item;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "marca")
    private String marca;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "prec_compra")
    private Integer precCompra;
    @Column(name = "prec_venta")
    private Integer precVenta;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "itemProducto")
    private List<Venta> ventaList;
    @JoinColumn(name = "idalmacen", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Almacen idalmacen;
    @JoinColumn(name = "idcategoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @JoinColumn(name = "idproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedor idproveedor;

    public Producto() {
    }

    public Producto(Integer item, String nombre, String marca, Integer stock, Integer precCompra, Integer precVenta, String descripcion, Almacen idalmacen, Categoria idcategoria, Proveedor idproveedor) {
        this.item = item;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.precCompra = precCompra;
        this.precVenta = precVenta;
        this.descripcion = descripcion;
        this.idalmacen = idalmacen;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
    }

    public Producto(Integer item, String nombre, String marca, Integer stock, Integer precCompra, Integer precVenta, String descripcion, List<Venta> ventaList, Almacen idalmacen, Categoria idcategoria, Proveedor idproveedor) {
        this.item = item;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.precCompra = precCompra;
        this.precVenta = precVenta;
        this.descripcion = descripcion;
        this.ventaList = ventaList;
        this.idalmacen = idalmacen;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
    }


    

    
    public Producto(Integer item) {
        this.item = item;
    }

    public Producto(Integer item, String nombre) {
        this.item = item;
        this.nombre = nombre;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrecCompra() {
        return precCompra;
    }

    public void setPrecCompra(Integer precCompra) {
        this.precCompra = precCompra;
    }

    public Integer getPrecVenta() {
        return precVenta;
    }

    public void setPrecVenta(Integer precVenta) {
        this.precVenta = precVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Almacen getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Almacen idalmacen) {
        this.idalmacen = idalmacen;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return item + ", " + nombre + ", " + marca + ", " + stock + ", " + precCompra + ", " + precVenta + ", " + descripcion + ", " + idalmacen + ", " + idcategoria + ", " + idproveedor;
    }

 
}
