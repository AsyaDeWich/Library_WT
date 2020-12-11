package service;

import dao.sql.UserDAOSQL;
import beans.User;

public class UserService {
    public static User register(String login, String firstName, String lastName, String age, String passwordHash) {
        if(!login.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !age.isEmpty() && !passwordHash.isEmpty()) {
            try {
                if(!(new UserDAOSQL().isUserExists(login))) {
                    User user = new User(login,firstName,lastName,age,passwordHash);
                    if (new UserDAOSQL().addUser(user)) {
                        return user;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static User authorization (String login, String passwordHash) {
        try {
            User user = new UserDAOSQL().getUserByLogin(login);
            if (user != null && user.passwordHash.equals(passwordHash)) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}