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
@Table(name = "calls")
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
    private String number;
    private Date callDate;
    private Report report;

    public Call() {
    }

    public Call(String number, Date callDate, Report report) {
        this.number = number;
        this.callDate = callDate;
        this.report = report;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_call")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "call_date")
    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    @OneToOne
    @JoinColumn(name = "report", nullable = false)
    @JsonIgnore
    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
