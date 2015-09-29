package dao;

import domain.User;
import java.util.Map;

public interface UserDao {
    Long create(User user);
    User read(String login);
    boolean update(User user);
    boolean delete(User user);
    Map<String, User> findAll();
}
