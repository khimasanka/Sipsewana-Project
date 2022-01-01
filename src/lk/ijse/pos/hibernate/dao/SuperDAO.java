package lk.ijse.pos.hibernate.dao;

import lk.ijse.pos.hibernate.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public interface SuperDAO <Entity extends SuperEntity, ID> {
    boolean save( Entity entity) throws Exception;

    boolean update(Entity entity) throws Exception;

    boolean delete(ID id) throws Exception;

    Entity search(ID id) throws Exception;

    List<Entity> getAll() throws Exception;
}
