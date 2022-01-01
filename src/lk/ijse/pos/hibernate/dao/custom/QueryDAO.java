package lk.ijse.pos.hibernate.dao.custom;


import lk.ijse.pos.hibernate.dto.CustomDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface QueryDAO{
    ArrayList<CustomDTO> getAll();

    List<CustomDTO> searchDetails(String value);
}
