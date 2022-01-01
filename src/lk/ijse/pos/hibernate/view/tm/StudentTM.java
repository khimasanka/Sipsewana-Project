package lk.ijse.pos.hibernate.view.tm;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class StudentTM {
    private String id;
    private String name;
    private String address;
    private String dob;
    private String nic;
    private String phone;
    private String regDate;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String address, String dob, String nic, String phone, String regDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.phone = phone;
        this.regDate = regDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
