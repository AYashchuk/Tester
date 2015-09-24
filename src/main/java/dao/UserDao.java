package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    Long create(User user);
    User read(String login);
    boolean update(User user);
    boolean delete(User user);
    List<User> findAll();
}
