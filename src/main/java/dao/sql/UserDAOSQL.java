package dao.sql;

import dao.UserDAO;
import beans.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOSQL implements UserDAO {
    @Override
    public User getUserByLogin (String login) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE login LIKE ?");
            query.setString(1,login);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _login = result.getString(2);
                String _passwordHash = result.getString(3);
                String _firstName = result.getString(4);
                String _lastName = result.getString(5);
                String _age = result.getString(6);
                User.Role _role = User.Role.valueOf(result.getString(7).toUpperCase());
                return new User(_id,_login,_firstName,_lastName,_age,_role,_passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByID (int id) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE id_user LIKE ?");
            query.setString(1,Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _login = result.getString(2);
                String _passwordHash = result.getString(3);
                String _firstName = result.getString(4);
                String _lastName = result.getString(5);
                String _age = result.getString(6);
                User.Role _role = User.Role.valueOf(result.getString(7).toUpperCase());
                return new User(_id,_login,_firstName,_lastName,_age,_role,_passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() throws Exception{
        Connection connection = DBConnection.connect();

        try {
            List<User> users = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM user");

            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _login = result.getString(2);
                String _passwordHash = result.getString(3);
                String _firstName = result.getString(4);
                String _lastName = result.getString(5);
                String _age = result.getString(6);
                User.Role _role = User.Role.valueOf(result.getString(7).toUpperCase());
                users.add(new User(_id,_login,_firstName,_lastName,_age,_role,_passwordHash));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser (User user) throws Exception {
        Connection connection = DBConnection.connect();

        try {
            PreparedStatement addUserQuery = connection.prepareStatement("INSERT INTO user (login, password_hash, first_name, last_name, age, role) VALUES (?, ?, ?, ?, ?, ?)");
            addUserQuery.setString(1,user.login);
            addUserQuery.setString(2,user.passwordHash);
            addUserQuery.setString(3,user.firstName);
            addUserQuery.setString(4,user.lastName);
            addUserQuery.setString(5,user.age);
            addUserQuery.setString(6,user.role.name().toLowerCase());
            addUserQuery.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isUserExists (String login) throws Exception {
        return getUserByLogin(login) != null;
    }
}
