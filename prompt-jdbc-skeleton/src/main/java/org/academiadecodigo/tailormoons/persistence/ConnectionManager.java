package org.academiadecodigo.tailormoons.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class ConnectionManager {

        private String dbUrl = "jdbc:mysql://127.0.0.1:3306/ac";
        private String username;
        private String pw;


        private static Connection connection = null;

        public ConnectionManager(String username, String password) {
            this.username = username;
            this.pw = password;
        }

        public Connection getConnection() {

            try {
                if (connection == null) {
                    connection = DriverManager.getConnection(dbUrl, username, pw);
                }
            } catch (SQLException ex) {
                System.out.println("Failure to connect to database : " + ex.getMessage());
            }
            return connection;
        }

        public void close() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Failure to close database connections: " + ex.getMessage());
            }
        }
    }
