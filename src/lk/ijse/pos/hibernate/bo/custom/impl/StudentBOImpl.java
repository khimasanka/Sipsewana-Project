package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.StudentBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.StudentDAO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean save(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(
                studentDTO.getsId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getDob(),
                studentDTO.getNic(),
                studentDTO.getPhone(),
                studentDTO.getRegDate()
        ));
    }

    @Override
    public boolean update(StudentDTO s) throws Exception {
        return studentDAO.update(new Student(
                s.getsId(),
                s.getName(),
                s.getAddress(),
                s.getDob(),
                s.getNic(),
                s.getPhone(),
                s.getRegDate()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO search(String id) throws Exception {
        Student s1 = studentDAO.search(id);
        return new StudentDTO(s1.getsId(), s1.getName(), s1.getAddress(), s1.getDob(), s1.getNic(), s1.getPhone(), s1.getRegDate());
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> students = new ArrayList<>();
        for (Student s : all) {
            students.add(new StudentDTO(
                    s.getsId(),
                    s.getName(),
                    s.getAddress(),
                    s.getDob(),
                    s.getNic(),
                    s.getPhone(),
                    s.getRegDate()
            ));
        }
        return students;
    }

    @Override
    public String studentCount() throws Exception {
        return studentDAO.StudentCount();
    }

    @Override
    public String generateSId() throws Exception {
        return studentDAO.generateSId();
    }
}
