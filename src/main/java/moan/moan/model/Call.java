/**
 * @author Ardila Oscar
 * @author Castellaños Isabel
 * @author Hurtado Henry
 */
package moan.moan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//AUDIO
//import javax.sound.sampled.*;
@Entity
@Table(name = "LLAMADAS")
public class Call implements java.io.Serializable {

    //private _____ rec;
    /*
    AudioFileFormat.Type aFF_T = AudioFileFormat.Type.WAVE;
    AudioFormat aF = new AudioFormat(8000.0F, 16, 1, true, false);
    buscar el tipo que necesitamos en: https://docs.oracle.com/javase/7/docs/api/javax/sound/sampled/AudioFileFormat.Type.html
     */
    private int id;
    //private AudioFileFormat.Type rec;
    //private Location location;
    private long numero;
    private Date fecha;
    private Report reporte;

    public Call(long numero, Date fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }
    
    public Call() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_LLAMADA")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NUMERO")
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * public AudioFileFormat.Type getRec() { return rec; }
     *
     * public void setRec(AudioFileFormat.Type rec) { this.rec = rec; }
     *
     * public Location getLocation() { return location; }
     *
     * public void setLocation(Location location) { this.location = location; }
     *
     */
   
    @OneToOne
    @JoinColumn(name = "REPORTE", nullable = false)
    @JsonIgnore
    public Report getReport() {
        return reporte;
    }

    public void setReport(Report reporte) {
        this.reporte = reporte;
    }
}
