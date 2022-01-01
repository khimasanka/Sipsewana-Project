package lk.ijse.pos.hibernate.bo.custom.impl;

import lk.ijse.pos.hibernate.bo.custom.DetailsBO;
import lk.ijse.pos.hibernate.dao.DAOFactory;
import lk.ijse.pos.hibernate.dao.DAOType;
import lk.ijse.pos.hibernate.dao.custom.DetailsDAO;
import lk.ijse.pos.hibernate.dao.custom.QueryDAO;
import lk.ijse.pos.hibernate.dto.CourseDTO;
import lk.ijse.pos.hibernate.dto.CustomDTO;
import lk.ijse.pos.hibernate.dto.DetailsDTO;
import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Details;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DetailsBOImpl implements DetailsBO {
    DetailsDAO detailsDAO = DAOFactory.getInstance().getDAO(DAOType.DETAILS);
    /*QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERYDAO);*/
    @Override
    public boolean regDetails(DetailsDTO dto) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class,dto.getsId());
        Course course = session.get(Course.class, dto.getProgramId());

        Details register = new Details(dto.getRegId(), dto.getRegDate(), student, course);
        session.save(register);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public ArrayList<CustomDTO> getAllDetails() throws Exception {
       /* ArrayList<CustomDTO> allDetails = new ArrayList<>();
        ArrayList<CustomDTO> all = queryDAO.getAll();
        for (CustomDTO r : all) {
            allDetails.add(new CustomDTO(r.getRegId(),r.getsName(),r.getsId(),r.getpId(),r.getRegDate()));
        }
        return allDetails;*/return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return detailsDAO.generateRegID();
    }
}
