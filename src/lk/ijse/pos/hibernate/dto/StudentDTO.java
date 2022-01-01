package lk.ijse.pos.hibernate.dto;

import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class StudentDTO {
    private String sId;
    private String name;
    private String address;
    private String dob;
    private String nic;
    private String phone;
    private String regDate;
    private List<Course> courses = new ArrayList<>();

    public StudentDTO() {
    }

    public StudentDTO(String sId, String name, String address, String dob, String nic, String phone, String regDate, List<Course> courses) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.phone = phone;
        this.regDate = regDate;
        this.courses = courses;
    }

    public StudentDTO(String sId, String name, String address, String dob, String nic, String phone) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.phone = phone;
    }



    public StudentDTO(String sId, String name, String address, String dob, String nic, String phone, String regDate) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.phone = phone;
        this.regDate = regDate;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
