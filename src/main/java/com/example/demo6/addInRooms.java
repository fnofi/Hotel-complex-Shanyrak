package com.example.demo6;

import javax.servlet.http.HttpServlet;
import java.sql.*;

public class addInRooms extends HttpServlet {
    private final String Url = "jdbc:postgresql://localhost/postgres";
    private final String userpostgres = "postgres";
    private final String passwordpostgres = "abzal";
    public void add(String start, String end, String status, String room_name,String room_cost) throws SQLException {
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = conn.createStatement();
        String af =String.format("INSERT INTO public.rooms (check_in,check_out,status,room_name,room_cost) VALUES ('"+start+"','"+end+"','"+status+"','"+room_name+"','"+room_cost+"')");
        st.executeUpdate(af);
    }
}