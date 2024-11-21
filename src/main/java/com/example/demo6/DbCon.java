package com.example.demo6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
    private final String Url = "jdbc:postgresql://localhost:5432/postgres"; //ссылка на базу данных
    private final String userpostgres = "postgres"; //имя пользователя в базе данных
    private final String passwordpostgres = "abzal"; //пароль для доступа в базу данных

    public DbCon() {
    }

    public Connection getCon() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(Url, userpostgres, passwordpostgres); //попытка подключится к базе данных
        } catch (SQLException e) {
            throw new RuntimeException(e); //если мы не смогли подключиться к базе данных выдаётся ошибка
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
