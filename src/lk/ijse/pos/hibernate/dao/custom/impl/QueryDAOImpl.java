package lk.ijse.pos.hibernate.dao.custom.impl;

import lk.ijse.pos.hibernate.dao.custom.QueryDAO;
import lk.ijse.pos.hibernate.dto.CustomDTO;
import lk.ijse.pos.hibernate.entity.SuperEntity;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomDTO> getAll() {
        ArrayList<CustomDTO> allDetails = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT d.regId, s.name,d.student_sId,d.course_programId ,d.regDate from Details d INNER JOIN Student s on d.student_sId = s.sId");
        ArrayList<Object[]> details = (ArrayList<Object[]>) query.list();
        transaction.commit();
        session.close();
        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (String) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (LocalDate) temp[4]
            ));
        }
        return allDetails;    }

    @Override
    public List<CustomDTO> searchDetails(String value) {
        return null;
    }
}
