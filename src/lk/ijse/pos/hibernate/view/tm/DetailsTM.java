package lk.ijse.pos.hibernate.view.tm;

import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Student;

import java.time.LocalDate;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DetailsTM {
    private String regId;
    private String sName;
    private String sId;
    private String pId;
    private LocalDate regDate;

    public DetailsTM() {
    }

    public DetailsTM(String regId, String sName, String sId, String pId, LocalDate regDate) {
        this.regId = regId;
        this.sName = sName;
        this.sId = sId;
        this.pId = pId;
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
