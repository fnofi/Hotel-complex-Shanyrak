package com.example.demo6;

import javax.servlet.http.HttpServlet;
import java.sql.*;

public class addInClient extends HttpServlet {
    public void add(String first_name, String second_name, String phone_number, String email,String note) throws SQLException {
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = conn.createStatement();
        String af =String.format("INSERT INTO public.book (first_name,second_name,phone_number,email,note)" +
                "VALUES ('"+first_name+"','"+second_name+"','"+phone_number+"','"+email+"','"+note+"')");
        st.executeUpdate(af);
    }
}