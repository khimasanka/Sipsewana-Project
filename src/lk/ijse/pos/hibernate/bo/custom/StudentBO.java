package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.StudentDTO;

import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface StudentBO extends SuperBO {
    boolean save(StudentDTO studentDTO) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    boolean delete(String id) throws Exception;

    StudentDTO search(String id) throws Exception;

    List<StudentDTO> getAll() throws Exception;

    String studentCount() throws Exception;

    String generateSId() throws Exception;
}
