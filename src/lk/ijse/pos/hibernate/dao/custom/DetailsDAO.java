package lk.ijse.pos.hibernate.dao.custom;

import lk.ijse.pos.hibernate.dao.SuperDAO;
import lk.ijse.pos.hibernate.dto.CustomDTO;
import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.entity.Details;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface DetailsDAO extends SuperDAO<Details,String>{
    boolean save(Details dto) throws Exception;

    List<Details> getAll()throws Exception;

    String generateRegID() throws SQLException, ClassNotFoundException;
}
