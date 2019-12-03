package by.bsuir.wt_lab.service;

import by.bsuir.wt_lab.exception.DBException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    // singleton
    private static DBManager instance = null;
    private Connection connection;

    private boolean isReady;

    private final String url = "jdbc:mysql://localhost/?user=root&password=123456";
    private final String DBInitialFilePath = "C:\\Users\\Denni\\Documents\\GitHub\\wt.lab2\\Lab2\\src\\main\\resources\\db.sql";

    private DBManager() {
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() throws DBException {
        if (isReady) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url);
                initDB();
                isReady = true;
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                isReady = false;
                throw new DBException(e.getMessage());
            }
        }
    }

    private void initDB() throws DBException {

        try {
            Statement statement = connection.createStatement();

            FileReader reader = new FileReader(DBInitialFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String sqlCommand;
            StringBuilder buffer = new StringBuilder();
            while ((sqlCommand = bufferedReader.readLine()) != null) {
                buffer.append(sqlCommand);
                if (sqlCommand.contains(";")) {
                    statement.execute(buffer.toString());
                    buffer = new StringBuilder();
                }
            }
        } catch (SQLException | IOException e) {
            throw new DBException(e.getMessage());
        }
    }

}
