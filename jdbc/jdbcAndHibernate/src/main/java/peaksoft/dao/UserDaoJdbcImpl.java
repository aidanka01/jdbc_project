package peaksoft.dao;

import peaksoft.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.Util.connect;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS users(" +
                "id  SERIAL PRIMARY KEY," +
                "name VARCHAR(20)," +
                "lastname VARCHAR (30)," +
                "age SMALLINT);";
        try (Connection connection1 = connect();
             Statement statement1 = connection1.createStatement()){
            statement1.executeUpdate(sqlCreate);
            System.out.println("Table created successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void dropUsersTable() {
        String sqlDrop = "DROP TABLE users";
        try (Connection connection2 = connect();
             Statement statement2 = connection2.createStatement()) {
            statement2.executeUpdate(sqlDrop);
            System.out.println("Table dropped successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser( String name, String lastName, byte age) {
        String sqlSave = "INSERT INTO users( name, lastname, age) " +
                "VALUES (?, ?, ?) ";
        try (Connection connection3 = connect();
             PreparedStatement statement3 = connection3.prepareStatement(sqlSave)){
            statement3.setString(1, name);
            statement3.setString(2, lastName);
            statement3.setByte(3, age);
            statement3.executeUpdate();
            System.out.println("Added to user_base " + name);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String sqlRemove= "DELETE FROM users WHERE id = ? ";
        try(Connection connect4 = connect();
            PreparedStatement statement4 = connect4.prepareStatement(sqlRemove)){
            statement4.setInt(1,(int) id);
            statement4.executeUpdate();
            System.out.println("Remove by id: " + id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String sqlGetAll = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try(    Connection connect5 = connect();
                Statement statement5 = connect5.createStatement();
                ResultSet resultSet = statement5.executeQuery(sqlGetAll)){
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } return users;
    }



    public void cleanUsersTable() {
        String SQL_CLEAN = "TRUNCATE TABLE users";
        try(Connection connect = connect();
            Statement statement = connect.createStatement()){
            statement.executeUpdate(SQL_CLEAN);
            System.out.println("User TABLE cleaned successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}