package lk.ijse.pos.hibernate.bo.custom;

import lk.ijse.pos.hibernate.bo.SuperBO;
import lk.ijse.pos.hibernate.dto.CustomDTO;
import lk.ijse.pos.hibernate.dto.DetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface DetailsBO extends SuperBO {
    boolean regDetails(DetailsDTO dto) throws Exception;

    ArrayList<CustomDTO> getAllDetails() throws Exception;

    public String generateNewID() throws SQLException, ClassNotFoundException;
}
