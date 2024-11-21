package com.example.demo6;

import javax.servlet.http.HttpServlet;
import java.sql.*;

public class updateRooms extends HttpServlet {
    private final String Url = "jdbc:postgresql://localhost/postgres";
    private final String userpostgres = "postgres";
    private final String passwordpostgres = "abzal";
    public void add(String start, String end, String room_id, String first_name) throws SQLException {
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = conn.createStatement();
        String af =String.format("UPDATE public.rooms " +
                "SET check_in='"+start+"',check_out='"+end+"',status='1', first_name='"+first_name+"' " +
                "WHERE id='"+room_id+"'");
        st.executeUpdate(af);
    }
}