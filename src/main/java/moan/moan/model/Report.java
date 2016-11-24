/**
 * @author Ardila Oscar
 * @author Castellaños Isabel
 * @author Hurtado Henry
 */
package moan.moan.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORTES")
public class Report implements java.io.Serializable {

    private long id;
    private int llamada;
    private String numero;
    private String sexoVoz;
    private String acento;
    private String pertenece;
    private String exigencia;
    private String descripcion;
    
    public Report(String numero, String sexoVoz, String acento, String pertenece, String exigencia, String descripcion) {

        this.numero = numero;
        this.sexoVoz = sexoVoz;
        this.acento = acento;
        this.pertenece = pertenece;
        this.exigencia = exigencia;
        this.descripcion = descripcion;
    }
   
    

    public Report() {

    }  

    @Id
    @Column(name = "ID_REPORTE")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
         

    @Column(name = "NUMERO")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(name = "SEXO_VOZ")
    public String getSexoVoz() {
        return sexoVoz;
    }

    public void setSexoVoz(String sexoVoz) {
        this.sexoVoz = sexoVoz;
    }

    @Column(name = "ACENTO")
    public String getAcento() {
        return acento;
    }

    public void setAcento(String acento) {
        this.acento = acento;
    }

    @Column(name = "PERTENECE")
    public String getPertenece() {
        return pertenece;
    }

    public void setPertenece(String pertenece) {
        this.pertenece = pertenece;
    }

    @Column(name = "EXIGENCIA")
    public String getExigencia() {
        return exigencia;
    }

    public void setExigencia(String exigencia) {
        this.exigencia = exigencia;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "LLAMADA")
    public int getLlamada() {
        return llamada;
    }

    public void setLlamada(int llamada) {
        this.llamada = llamada;
    }


}
