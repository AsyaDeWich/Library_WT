package dao;

import beans.User;

import java.util.List;

public interface UserDAO {
    User getUserByLogin (String login) throws Exception;
    User getUserByID (int id) throws Exception;
    List<User> getUsers() throws Exception;
    boolean addUser (User user) throws Exception;
    boolean isUserExists (String login) throws Exception;
}