package lk.ijse.pos.hibernate.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student implements SuperEntity {
    @Id
    private String sId;
    private String name;
    private String address;
    private String dob;
    private String nic;
    private String phone;
    private String regDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Details> details;

    public Student() {
    }

    public Student(String sId, String name, String address, String dob, String nic, String phone, String regDate, List<Details> details) {
        this.setsId(sId);
        this.setName(name);
        this.setAddress(address);
        this.setDob(dob);
        this.setNic(nic);
        this.setPhone(phone);
        this.setRegDate(regDate);
        this.setDetails(details);
    }

    public Student(String sId, String name, String address, String dob, String nic, String phone) {
        this.setsId(sId);
        this.setName(name);
        this.setAddress(address);
        this.setDob(dob);
        this.setNic(nic);
        this.setPhone(phone);
    }

    public Student(String sId, String name, String address, String dob, String nic, String phone, String regDate) {
        this.setsId(sId);
        this.setName(name);
        this.setAddress(address);
        this.setDob(dob);
        this.setNic(nic);
        this.setPhone(phone);
        this.setRegDate(regDate);
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }
}
