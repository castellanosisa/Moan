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
@Table(name = "users")
public class User implements java.io.Serializable {
    
    private int docNumber;
    private String email;
    private String number;
    private String name;
    private String docType;
    private Set<Report> myReports;

    public User() {
    }

    public User(int docNumber, String email, String number, String name, String docType) {
        this.docNumber = docNumber;
        this.email = email;
        this.number = number;
        this.name = name;
        this.docType = docType;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String phone) {
        this.number = phone;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "doc_type")
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Id
    @Column(name = "doc_number")
    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    @OneToMany(cascade =CascadeType.ALL)
    @PrePersist 
    @PreUpdate
    @JoinColumns({@JoinColumn(name="user_id", nullable=false)})
    public Set<Report> getMyReports() {
        return myReports;
    }

    public void setMyReports(Set<Report> myReports) {
        this.myReports = myReports;
    }
   
}
