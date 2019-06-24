/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Venta.findByDescuento", query = "SELECT v FROM Venta v WHERE v.descuento = :descuento"),
    @NamedQuery(name = "Venta.findByTotal", query = "SELECT v FROM Venta v WHERE v.total = :total"),
    @NamedQuery(name = "Venta.findByDescripcion", query = "SELECT v FROM Venta v WHERE v.descripcion = :descripcion")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "descuento")
    private Integer descuento;
    @Basic(optional = false)
    @Column(name = "total")
    private long total;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idcliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "itemProducto", referencedColumnName = "item")
    @ManyToOne
    private Producto itemProducto;

    public Venta() {
    }

    public Venta(Integer id, Date fechaVenta, int cantidad, Integer descuento, long total, String descripcion, Cliente idcliente, Usuario idusuario, Producto itemProducto) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.descripcion = descripcion;
        this.idcliente = idcliente;
        this.idusuario = idusuario;
        this.itemProducto = itemProducto;
    }

    public Venta(Date fechaVenta, int cantidad, Integer descuento, long total, String descripcion, Cliente idcliente, Usuario idusuario, Producto itemProducto) {
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.descripcion = descripcion;
        this.idcliente = idcliente;
        this.idusuario = idusuario;
        this.itemProducto = itemProducto;
    }

    
    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, int cantidad, long total) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Producto getItemProducto() {
        return itemProducto;
    }

    public void setItemProducto(Producto itemProducto) {
        this.itemProducto = itemProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + ", " + fechaVenta + ", " + cantidad + ", " + descuento + ", " + total + ", " + descripcion + ", " + idcliente + ", " + idusuario + ", " + itemProducto ;
    }


    
    
}
