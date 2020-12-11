package beans;

public class User {

    public enum Role{
        ADMIN,
        LIBRARIAN,
        READER
    }

    public final Integer id;
    public final String login;
    public final String firstName;
    public final String lastName;
    public final String age;
    public final Role role;
    public final String passwordHash;

    public User(Integer id, String login, String firstName, String lastName, String age, Role role, String passwordHash) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
        this.passwordHash = passwordHash;
    }

    public User(String login, String firstName, String lastName, String age, String passwordHash) {
        this.id = null;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = Role.READER;
        this.passwordHash = passwordHash;
    }
}