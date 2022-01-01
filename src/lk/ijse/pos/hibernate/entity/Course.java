package lk.ijse.pos.hibernate.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Course implements SuperEntity {
    @Id
    private String programId;
    private String name;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Details> details = new ArrayList<>();

    public Course() {
    }

    public Course(String programId, String name, String duration, double fee, List<Details> details) {
        this.programId = programId;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.details = details;
    }

    public Course(String pId, String name, String duration, double fee) {
        this.setProgramId(pId);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public String getpId() {
        return getProgramId();
    }

    public void setpId(String pId) {
        this.setProgramId(pId);
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

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Course{" +
                "pId='" + getProgramId() + '\'' +
                ", name='" + getName() + '\'' +
                ", duration='" + getDuration() + '\'' +
                ", fee=" + getFee() +
                '}';
    }
}
