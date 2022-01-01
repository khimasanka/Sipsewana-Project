package lk.ijse.pos.hibernate.dao.custom.impl;

import lk.ijse.pos.hibernate.dao.custom.DetailsDAO;
import lk.ijse.pos.hibernate.dto.DetailsDTO;
import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Details;
import lk.ijse.pos.hibernate.entity.Student;
import lk.ijse.pos.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DetailsDAOImpl implements DetailsDAO {

    @Override
    public boolean save(Details dto) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.getTransaction();
        Student student = session.get(Student.class, dto.getStudent());
        Course course = session.get(Course.class, dto.getCourse());

        Details details = new Details(dto.getRegId(), dto.getRegDate(), student, course);
        session.save(details);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Details entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Details search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Details> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Details> list;

        Query details = session.createQuery("from Details");
        list = details.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String generateRegID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT regId FROM sipsewana.Details ORDER BY regId DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s != null) {
            int tempId = Integer.parseInt(s.split("-")[1]);
            tempId = tempId+1;
            if(tempId<=9){
                return "R-00"+tempId;
            }else if(tempId<=99){
                return "R-0"+tempId;
            }else {
                return "R-"+tempId;
            }
        }else{
            return "R-001";
        }
    }
}
