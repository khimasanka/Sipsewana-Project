package lk.ijse.pos.hibernate.dto;

import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Student;

import java.time.LocalDate;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DetailsDTO {
    private String regId;
    private String sId;
    private String programId;
    private LocalDate regDate;



    public DetailsDTO(String regId, String sId, String programId, LocalDate regDate) {
        this.setRegId(regId);
        this.setsId(sId);
        this.setProgramId(programId);
        this.setRegDate(regDate);
    }

    public DetailsDTO(String regId, Course course, Student student, LocalDate regDate) {
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
