package com.example.demo6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@WebServlet(name = "deleteRoomServlet", value = "/deleteRoom-servlet")
public class deleteRoomsServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String lap=request.getParameter("id");
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            String af =String.format("DELETE FROM public.rooms WHERE id='"+lap+"'");
            try {
                st.executeUpdate(af);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_ROOMS);
            out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                    "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
            out.println("<tr><td>Id</td><td>Название</td><td>Цена</td><td>Дата заезда</td><td>Дата выезда</td><td>Статус</td><td>Действие</td></tr>");
            int i=0;
            while(resultSet.next()){
                i++;
                String id=resultSet.getString(1);
                String start=resultSet.getString(2);
                String end=resultSet.getString(3);
                String status=resultSet.getString(4);
                String room_name=resultSet.getString(5);
                String room_cost=resultSet.getString(6);
                if(Objects.equals(status, "0")) out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Свободен</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='deleteRoom-servlet?id="+id+"'>Удалить</a></td></tr>");
                else out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Забронирован</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='deleteRoom-servlet?id="+id+"'>Удалить</a></td></tr>");
            }
            resultSet.close();
            st.close();
            conn.close();
            out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
