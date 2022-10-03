package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //HIBERNATE users
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        // CREATE TABLE
       // userDaoHibernate.createUsersTable();

        // SAVE USER
        userDaoHibernate.saveUser("Ali", "Hamzaev", (byte) 31);
        userDaoHibernate.saveUser("Aisha", "Zunaeva", (byte) 30);
        userDaoHibernate.saveUser("Bakr", "Ashimov", (byte) 43);
        userDaoHibernate.saveUser("Mondi", "Longman", (byte) 27);
        userDaoHibernate.saveUser("Asman", "Aliev", (byte) 19);


        // CLEAN users TABLE
       /* userDaoHibernate.cleanUsersTable();

        // REMOVE users BY ID
        userDaoHibernate.removeUserById(2);*/

        // GET ALL users
       /* userDaoHibernate.getAllUsers();
        List<User> userHibernateList = userDaoHibernate.getAllUsers();
        System.out.println(userHibernateList);
*/
        //DROP TABLE users
    //    userDaoHibernate.dropUsersTable();




        // JDBC users
       /* UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

        //CREATE TABLE
        userDaoJdbc.createUsersTable();

        // ADD USERS
        userDaoJdbc.saveUser("Azema", "Kadyrova", (byte) 26);
        userDaoJdbc.saveUser("Aidana", "Kadyrova", (byte) 23);
        userDaoJdbc.saveUser("Tariel", "Kadyrov", (byte) 21);
        userDaoJdbc.saveUser("Avtandil", "Kadyrov", (byte) 19);

        // CLEAN users TABLE
        userDaoJdbc.cleanUsersTable();

        // REMOVE users BY ID
        userDaoJdbc.removeUserById(1);

        // GET ALL users
        userDaoJdbc.getAllUsers();
        List<User> userList = userDaoJdbc.getAllUsers();
        System.out.println(userList);

        // DROP TABLE users
        userDaoJdbc.dropUsersTable();
*/

    }
}


