package org.krism.project;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_pass")
    private String password;
    @Column(name = "is_admin")
    private boolean is_admin;

    public User() {
    }

    public User(String username, String password, boolean is_admin) {
        this.username = username;
        this.password = password;
        this.is_admin = is_admin;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public static boolean isUserValid(User user) {
        List<User> users = DataBase.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                if (users.get(i).getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUserAdmin(User user) {
        List<User> users = DataBase.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                if (users.get(i).getPassword().equals(user.getPassword())) {
                    if (users.get(i).isIs_admin() == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", is_admin=" + is_admin + '}';
    }
}
