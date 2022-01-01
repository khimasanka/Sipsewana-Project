package lk.ijse.pos.hibernate.dao;

import lk.ijse.pos.hibernate.dao.custom.impl.CourseDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.DetailsDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.QueryDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return(null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch(daoType){
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case DETAILS:
                return (T) new DetailsDAOImpl();
            /*case QUERYDAO:
                return(T) new QueryDAOImpl();*/
            default:
                return null;
        }
    }
}
