/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author mscit
 */
@Entity
@Table(name = "garmentmaster")
@NamedQueries({
    @NamedQuery(name = "Garmentmaster.findAll", query = "SELECT g FROM Garmentmaster g"),
    @NamedQuery(name = "Garmentmaster.findByGid", query = "SELECT g FROM Garmentmaster g WHERE g.gid = :gid"),
    @NamedQuery(name = "Garmentmaster.findByGname", query = "SELECT g FROM Garmentmaster g WHERE g.gname = :gname"),
    @NamedQuery(name = "Garmentmaster.findBySize", query = "SELECT g FROM Garmentmaster g WHERE g.size = :size"),
    @NamedQuery(name = "Garmentmaster.findByDes", query = "SELECT g FROM Garmentmaster g WHERE g.des = :des"),
    @NamedQuery(name = "Garmentmaster.findByPrice", query = "SELECT g FROM Garmentmaster g WHERE g.price = :price"),
    @NamedQuery(name = "Garmentmaster.findByStock", query = "SELECT g FROM Garmentmaster g WHERE g.stock = :stock")})
public class Garmentmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "gname")
    private String gname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "des")
    private String des;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne
    private Category cid;

    public Garmentmaster() {
    }

    public Garmentmaster(Integer gid) {
        this.gid = gid;
    }

    public Garmentmaster(Integer gid, String gname, String size, String des, BigDecimal price, int stock) {
        this.gid = gid;
        this.gname = gname;
        this.size = size;
        this.des = des;
        this.price = price;
        this.stock = stock;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garmentmaster)) {
            return false;
        }
        Garmentmaster other = (Garmentmaster) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Garmentmaster[ gid=" + gid + " ]";
    }
    
}
