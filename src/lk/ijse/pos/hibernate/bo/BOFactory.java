package lk.ijse.pos.hibernate.bo;

import lk.ijse.pos.hibernate.bo.custom.impl.CourseBOImpl;
import lk.ijse.pos.hibernate.bo.custom.impl.DetailsBOImpl;
import lk.ijse.pos.hibernate.bo.custom.impl.StudentBOImpl;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case DETAILS:
                return (T) new DetailsBOImpl();
            default:
                return null;
        }
    }
}
