package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.CourseDTO;

import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface CourseBO extends SuperBO {
    boolean save(CourseDTO courseDTO) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(CourseDTO courseDTO) throws Exception;

    CourseDTO search(String is) throws Exception;

    List<CourseDTO> getAll() throws Exception;

    List<String>getCourseIds() throws Exception;

}
