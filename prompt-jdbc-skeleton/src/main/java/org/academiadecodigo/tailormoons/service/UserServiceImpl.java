package org.academiadecodigo.tailormoons.service;

import com.mysql.cj.protocol.Resultset;
import org.academiadecodigo.tailormoons.model.User;
import org.academiadecodigo.tailormoons.persistence.ConnectionManager;
import org.academiadecodigo.tailormoons.utils.Security;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private ConnectionManager connectionManager;
    private PreparedStatement preparedStatement;


    @Override
    public boolean authenticate(String username, String password) {

        String passwordValue = null;
        String query = "SELECT * FROM user WHERE username =?";
        preparedStatement = createStatement(query);

        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);

            System.out.println(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                passwordValue = resultSet.getString("password");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement();
        }

        return passwordValue.equals(Security.getHash(password));

    }

    @Override
    public void add(User user) {

        String query = "Insert INTO user(username, password, email, firstname, lastname, phone) VALUES ('" + user.getUsername() + "','" + user.getPassword()
                +  "','" + user.getEmail()  + "','" + user.getFirstName() +  "','" + user.getLastName() +  "','" +  user.getPhone()  + "');";

        preparedStatement = createStatement(query);

        try {
            preparedStatement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement();
        }
    }

    @Override
    public User findByName(String username) {

        User user = null;
        String query = "SELECT * FROM user WHERE username =?" + "\"" + username + "\"";

        preparedStatement = createStatement();

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");

                user =  new User(username, email, password, firstName, lastName, phone);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement();
        }

        return user;
    }

    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user;";
        preparedStatement = createStatement(query);

        try {
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {

                    String username = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastname");
                    String phone = resultSet.getString("phone");
                    userList.add(new User(username, email, password, firstName, lastName, phone));
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement();
        }

        return userList;
    }

        @Override
    public int count() {

        ResultSet resultSet;
            String query = "SELECT COUNT(*) from user";
            preparedStatement = createStatement(query);

        int result = 0;

        try {


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement();
        }

        return result;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public PreparedStatement createStatement(String query) {

        PreparedStatement statement = null;
        try {
            statement = connectionManager.getConnection().prepareStatement(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }


    public void closeStatement() {

        try {
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
