package lk.ijse.pos.hibernate.dto;

import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class CourseDTO extends Course {
    private String programId;
    private String name;
    private String duration;
    private Double fee;
    private List<Student> studentList =new ArrayList<>();

    public CourseDTO() {
    }

    public CourseDTO(String programId, String name, String duration, Double fee, List<Student> studentList) {
        this.programId = programId;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.studentList = studentList;
    }

    public CourseDTO(String programId) {
        this.programId = programId;
    }

    public CourseDTO(String programId, String name, String duration, Double fee) {
        this.programId = programId;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "pId='" + getProgramId() + '\'' +
                ", name='" + getName() + '\'' +
                ", duration='" + getDuration() + '\'' +
                ", fee='" + getFee() + '\'' +
                ", studentList=" + getStudentList() +
                '}';
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
