package lk.ijse.pos.hibernate.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Details implements SuperEntity {
    @Id
    private
    String regId;
    private LocalDate regDate;
    @ManyToOne
    private
    Student student;
    @ManyToOne
    private
    Course course;

    public Details() {
    }

    public Details(String regId, LocalDate regDate, Student student, Course course) {
        this.regId = regId;
        this.regDate = regDate;
        this.student = student;
        this.course = course;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Details{" +
                "regId='" + regId + '\'' +
                ", regDate=" + regDate +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
