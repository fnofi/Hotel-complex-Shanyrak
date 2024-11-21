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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@WebServlet(name = "actionRoomServlet", value = "/actionRoom-servlet")
public class actionRoomServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    String lap="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        lap=request.getParameter("id");
        PrintWriter out = response.getWriter();
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
        out.println("<br><html lang='ru'><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='actionRoom-servlet' method='POST'>" +
                "<h2>Название:<input name='room_name' /><br><br>Цена:<input name='room_cost' /><br><br>Дата заезда:<input name='check_in' /><br><br>" +
                "Дата выезда:<input name='check_out' /><br><br>Статус:<input name='status' /><br><br><font size='24pt'><input type='submit' name='s1' value='Подтвердить' /></font>" +
                "</h2></form>");
        try {
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_ROOMS);
            out.println("<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
            out.println("<form action='actionRoom-servlet' method='POST'>");
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
                if(Objects.equals(status, "0")) out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Свободен</td><td><a href='actionRoom-servlet' name='id' value='"+id+"'>Изменить</a>|<a href='delete_Room.jsp name='id' value='"+id+"''>Удалить</a></td></tr>");
                else out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Забронирован</td></tr>");
            }
            resultSet.close();
            st.close();
            conn.close();
            out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cap=request.getParameter("s1");
        PrintWriter out = response.getWriter();
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
        if(cap.equals("Подтвердить")){
            String cin1 = request.getParameter("check_in");
            String cout1 = request.getParameter("check_out");
            String status1 = request.getParameter("status");
            String room_name1 = request.getParameter("room_name");
            String room_cost1 = request.getParameter("room_cost");
            String af =String.format("UPDATE public.rooms SET id='"+lap+"', check_in='"+cin1+"', check_out='"+cout1+"', status='"+status1+"', room_name='"+room_name1+"', room_cost='"+room_cost1+"' WHERE id='"+lap+"'");
            try {
                st.executeUpdate(af);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
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
                    if(Objects.equals(status, "0")) out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Свободен</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='delete_Room.jsp?id="+id+"'>Удалить</a></td></tr>");
                    else out.println("<tr><td>"+i+"</td><td>"+room_name+"</td><td>"+room_cost+"</td><td>"+start+"</td><td>"+end+"</td><td>Забронирован</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='delete_Room.jsp?id="+id+"'>Удалить</a></td></tr>");
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
}