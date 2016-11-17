/**
 * @author Ardila Oscar
 * @author Castellaños Isabel
 * @author Hurtado Henry
 */
package moan.moan.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class User implements java.io.Serializable {


    private long numero;
    private long imei;
    private long simcard;
    private Set<Report> myReports;

    public User() {
    }
    
    @Id
    @Column(name = "NUMERO")
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Column(name = "IMEI")
    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    @Column(name = "SIMCARD")
    public long getSimcard() {
        return simcard;
    }

    public void setSimcard(long simcard) {
        this.simcard = simcard;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @PrePersist
    @PreUpdate
    @JoinColumns({
    @JoinColumn(name = "USUARIO_ID", nullable = false)})
    public Set<Report> getMyReports() {
        return myReports;
    }

    public void setMyReports(Set<Report> myReports) {
        this.myReports = myReports;
    }

}
