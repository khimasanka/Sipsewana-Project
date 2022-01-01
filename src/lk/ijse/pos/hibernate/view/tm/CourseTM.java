package lk.ijse.pos.hibernate.view.tm;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class CourseTM {
    private String pid;
    private String name;
    private String duration;
    private String fee;

    public CourseTM() {
    }

    public CourseTM(String pid, String name, String duration, String fee) {
        this.setPid(pid);
        this.setName(name);
        this.setDuration(duration);
        this.setFee(fee);
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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
