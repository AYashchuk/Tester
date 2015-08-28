package dao;

import domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {
    private static Logger log = Logger.getLogger(UserDaoImpl.class);
    private Session session;
    private SessionFactory factory;



    public UserDaoImpl() {
        this.factory = HibernateUtil.getSessionFactory();
        this.session = factory.openSession();
    }

    @Override
    public Long create(User user){
        log.info("Method create: beginTransaction");
        Long id = new Long(-1);
        session.getTransaction().setTimeout(3);
        session.beginTransaction();
        id = (Long) session.save(user);
        session.getTransaction().commit();
        log.info("Method create: Transaction commit!");
        return id;
    }



}
