package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface StudentDAO extends SuperDAO<Student, String> {
    String StudentCount() throws Exception;

    String generateSId() throws Exception;
}
