package dao;

import domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao, AutoCloseable{
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

    @Override
    public User read(String login) {
        log.info("Method read: beginTransaction");
        User user  = null;
        user = (User) session.createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        log.info("Method create: Transaction commit!");
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean changes = false;
        log.info("Method update: beginTransaction");
        session.getTransaction().setTimeout(3);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        changes = true;
        log.info("Method update: Transaction commit!");
        return changes;
    }

    @Override
    public boolean delete(User user) {
        boolean delete = false;
        log.info("Method delete: beginTransaction");
        session.getTransaction().setTimeout(3);
        session.beginTransaction();
        session.delete(session.createCriteria(User.class).add(Restrictions.eq("login",user.getLogin())).uniqueResult());
        session.getTransaction().commit();
        delete = true;
        log.info("Method delete: Transaction commit!");
        return delete;
    }

    @Override
    public List<User> findAll() {
        return session.createCriteria(User.class).list();
    }


    @Override
    public void close() throws Exception {
        if(session != null){
            session.close();
        }
    }
}
