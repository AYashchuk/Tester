package domain;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "ID")
    Long id;
    @Column(name = "FIRSTNAME")
    String firstName;
    @Column(name = "SECONDNAME")
    String secondName;
    @Column(name = "LOGIN")
    String login;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "ADMIN")
    Boolean isAdmin;


    public User() {
    }

    public User(String firstName, String secondName, String login, String password, boolean isAdmin) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.isAdmin = new Boolean(isAdmin);
    }

    public User(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.isAdmin = new Boolean(false);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFirstName() { return firstName;}

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.secondName + " " + this.login + " " + this.isAdmin;
    }
}
