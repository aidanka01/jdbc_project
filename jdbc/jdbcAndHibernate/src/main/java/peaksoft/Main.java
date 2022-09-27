package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

        //CREATE TABLE
        userDaoJdbc.createUsersTable();

        // ADD USERS
        userDaoJdbc.saveUser("Azema", "Kadyrova", (byte) 26);
        userDaoJdbc.saveUser( "Aidana", "Kadyrova", (byte) 23);
        userDaoJdbc.saveUser( "Tariel", "Kadyrov", (byte) 21);
        userDaoJdbc.saveUser( "Avtandil", "Kadyrov", (byte) 19);

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
    }
}


