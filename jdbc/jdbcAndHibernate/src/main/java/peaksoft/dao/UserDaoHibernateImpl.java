package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("TABLE created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void dropUsersTable() {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();

            session.createSQLQuery("drop table users_hibernate").executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("TABLE users dropped successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("users saved successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println(user + " successfully removed by id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            List<User> userList = session.createQuery("from User").list();
            session.getTransaction().commit();
            session.close();
            System.out.println("Found " + userList.size() + " users");

            return userList;
        } catch (Exception r) {
            System.out.println(r.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            session.createQuery("delete  User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("TABLE users cleaned successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
