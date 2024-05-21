package org.krism.project;

import org.krism.hotel.Guest;
import org.krism.hotel.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBase {

    static String databaseHost = "localhost";
    static int databasePort = 5432;
    static String databaseName = "postgres";

    public static void CheckConnection() throws SQLException {
        String dataBaseName = databaseName;
        System.out.println("Test Connection DataBase : " + databaseName);
        String url = "jdbc:postgresql://" + databaseHost + ":" + databasePort + "/" + dataBaseName;
        Connection con = DriverManager.getConnection(url, "postgres", "123");
        System.out.println("connection success");
        con.close();
    }

    //=============================================
    //  Rooms

    public static List<Room> getrooms() {
        List<Room> rooms = null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Room.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            rooms = session.createQuery("from Room").list();
            displayList(rooms);
            session.getTransaction().commit();

            System.out.println("getRooms() Done!");
        } finally {
            factory.close();
        }

        return rooms;
    }

    public static List<Room> getAvailableRooms() {
        List<Room> rooms = null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Room.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            rooms = session.createQuery("from Room r where r.isEmpty=true").list();
            displayList(rooms);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

        return rooms;
    }

    //======================================
    // Users 
    public static boolean SaveUser(User user) {
        List<User> users = DataBase.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                return false;
            }
        }

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            factory.close();
        }
        return true;
    }

    public static boolean isUserNameValid(String username) {
        List<User> users = DataBase.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public static boolean DeleteUser(String username) {
        if (!isUserNameValid(username)) {
            return false;
        }
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Deleting User username = '" + username + "'");
            int executeUpdate = session.createQuery("delete from User where user_name = '" + username + "'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("deleteGuest() Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
        return true;
    }

    public static List<User> getUsers() {
        List<User> users = null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            users = session.createQuery("from User").list();

            displayList(users);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return users;
    }

    //=====================================
    // guests
    public static List<Guest> getGuests() {
        List<Guest> guests = null;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Guest.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            guests = session.createQuery("from Guest").list();

            displayList(guests);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
        return guests;
    }

    //======================================
    // print Data 
    public static <T> void displayList(List<T> list) {
        for (T tempUser : list) {
            System.out.println(tempUser);
        }
    }

}
