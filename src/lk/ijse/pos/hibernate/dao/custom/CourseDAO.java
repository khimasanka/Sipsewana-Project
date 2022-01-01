package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.entity.Course;

import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface CourseDAO extends SuperDAO<Course,String>{
    List<String> getCourseIds();
}
