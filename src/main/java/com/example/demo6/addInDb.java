package com.example.demo6;

import javax.servlet.http.HttpServlet;
import java.sql.*;

public class addInDb extends HttpServlet {
    private final String Url = "jdbc:postgresql://localhost/postgres";
    private final String userpostgres = "postgres";
    private final String passwordpostgres = "abzal";
    public void add(String name, String second_name, String patronymic, String age, String role) throws SQLException {
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = conn.createStatement();
        String af =String.format("INSERT INTO member (first_name,second_name,patronymic,age,role) VALUES ('"+name+"','"+second_name+"','"+patronymic+"','"+age +"','"+role+"')");
        st.executeUpdate(af);
    }
}