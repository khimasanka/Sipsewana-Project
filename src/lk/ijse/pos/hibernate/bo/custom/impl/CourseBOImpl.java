package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.CourseBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.CourseDAO;
import lk.ijse.pos.hibernate.dto.CourseDTO;
import lk.ijse.pos.hibernate.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class CourseBOImpl implements CourseBO {
    CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public boolean save(CourseDTO courseDTO) throws Exception {
        return courseDAO.save(new Course(
                courseDTO.getProgramId(),
                courseDTO.getName(),
                courseDTO.getDuration(),
                Double.parseDouble(String.valueOf(courseDTO.getFee()))
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public boolean update(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(
                courseDTO.getProgramId(),
                courseDTO.getName(),
                courseDTO.getDuration(),
                Double.parseDouble(String.valueOf(courseDTO.getFee()))
        ));
    }

    @Override
    public CourseDTO search(String id) throws Exception {
        Course c1 = courseDAO.search(id);
        return new CourseDTO(c1.getpId(), c1.getName(), c1.getDuration(), c1.getFee());
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<Course> all = courseDAO.getAll();
        ArrayList<CourseDTO> courses = new ArrayList<>();
        for (Course course : all) {
            courses.add(new CourseDTO(
                    course.getpId(),
                    course.getName(),
                    course.getDuration(),
                    Double.parseDouble(String.valueOf(course.getFee()))
            ));
        }
        return courses;
    }

    @Override
    public List<String> getCourseIds() throws Exception {
        return courseDAO.getCourseIds();
    }
}
