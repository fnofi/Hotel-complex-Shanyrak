package com.example.demo6;

import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_MEMBER = "SELECT * FROM public.member";
    static final String GET_ALL_RECORDS_BOOK = "SELECT * FROM public.book";
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cap=request.getParameter("s1");
        PrintWriter out = response.getWriter();
        if(cap.equals("Добавить работника в базу")){
            out.println("<br><html lang='ru'><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                    "<h2>Имя:<input name='name' /><br><br>Фамилия:<input name='second_name' /><br><br>Отчество:<input name='patronymic' /><br><br>" +
                    "Возраст:<input name='age' /><br><br><font size='24pt'><input type='submit' name='s1' value='Подтвердить' /></font>" +
                    "</h2></form></body></div></html>");
        }
        else if(cap.equals("Подтвердить")){
            String name = request.getParameter("name");
            String second_name = request.getParameter("second_name");
            String patronymic = request.getParameter("patronymic");
            String age = request.getParameter("age");
            String role = request.getParameter("role");
            try {
                addInDb wd=new addInDb();
                wd.add(name,second_name,patronymic,age,role);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_MEMBER);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<form action='hello-servlet' method='POST'>");
                out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Отчество</td><td>Возраст</td><td>Роль</td><td>Действие</td></tr>");
                int i=0;
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String name1=resultSet.getString(2);
                    String second_name1=resultSet.getString(3);
                    String patronymic1=resultSet.getString(4);
                    String age1=resultSet.getString(5);
                    String role1=resultSet.getString(6);
                    out.println("<tr><td>"+i+"</td><td>"+name1+"</td><td>"+second_name1+"</td><td>"+patronymic1+"</td><td>"+age1+"</td><td>"+role1+"</td><td><a href='actionMember-servlet?id="+id+"'>Изменить</a>|<a href='deleteMember-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cap.equals("Просмотреть базу работников")){
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
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_MEMBER);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<form action='hello-servlet' method='POST'>");
                out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Отчество</td><td>Возраст</td><td>Роль</td><td>Действие</td></tr>");
                int i=0;
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    String second_name=resultSet.getString(3);
                    String patronymic=resultSet.getString(4);
                    String age=resultSet.getString(5);
                    String role=resultSet.getString(6);
                    out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+second_name+"</td><td>"+patronymic+"</td><td>"+age+"</td><td>"+role+"</td><td><a href='actionMember-servlet?id="+id+"'>Изменить</a>|<a href='deleteMember-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cap.equals("Главное меню")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
            dispatcher.forward(request,response);
        }
        if(cap.equals("Добавить клиента в базу")){
            out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                    "<h2>Имя:<input name='name' /><br><br>Фамилия:<input name='second_name' /><br><br>Телефон:<input name='phone_number' /><br><br>" +
                    "E-mail:<input name='email' /><br><br>Примечание:<input name='note' /><br><br><font size='24pt'><input type='submit' name='s1' value='Ввести' /></font>" +
                    "</h2></form></body></div></html>");
        }
        else if(cap.equals("Ввести")){
            String name = request.getParameter("name");
            String second_name = request.getParameter("second_name");
            String phone_number = request.getParameter("phone_number");
            String email = request.getParameter("email");
            String note = request.getParameter("note");
            try {
                addInClient wd=new addInClient();
                wd.add(name,second_name,phone_number,email,note);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            int i=0;
            try {
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_BOOK);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Телефон</td><td>Почта</td><td>Примечание</td><td>Действие</td></tr>");
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String name1=resultSet.getString(2);
                    String second_name1=resultSet.getString(3);
                    String phone_number1=resultSet.getString(4);
                    String email1=resultSet.getString(5);
                    String note1=resultSet.getString(6);
                    out.println("<tr><td>"+i+"</td><td>"+name1+"</td><td>"+second_name1+"</td><td>"+phone_number1+"</td><td>"+email1+"</td><td>"+note1+"</td><td><a href='actionBook-servlet?id="+id+"'>Изменить</a>|<a href='deleteBook-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cap.equals("Просмотреть базу клиентов")){
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
            int i=0;
            try {
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_BOOK);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<tr><td>Id</td><td>Имя</td><td>Фамилия</td><td>Телефон</td><td>Почта</td><td>Примечание</td><td>Действие</td></tr>");
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    String second_name=resultSet.getString(3);
                    String phone_number=resultSet.getString(4);
                    String email=resultSet.getString(5);
                    String note=resultSet.getString(6);
                    out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+second_name+"</td><td>"+phone_number+"</td><td>"+email+"</td><td>"+note+"</td><td><a href='actionBook-servlet?id="+id+"'>Изменить</a>|<a href='deleteBook-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cap.equals("Добавить номер в базу")){
            out.println("<br><html lang='ru'><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                    "<h2>Название:<input name='room_name' /><br><br>Цена:<input name='room_cost' /><br><br>Дата заезда:<input name='start' /><br><br>Дата выезда:<input name='end' /><br>Статус:<input name='status' /><font size='24pt'><br><br><input type='submit' name='s1' value='Добавить номер' /></font>" +
                    "</h2></form></body></div></html>");
        }
        else if(cap.equals("Добавить номер")){
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            String status = request.getParameter("status");
            String room_name=request.getParameter("room_name");
            String room_cost=request.getParameter("room_cost");
            try {
                addInRooms rd=new addInRooms();
                rd.add(start,end,status,room_name,room_cost);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
                ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_ROOMS);
                out.println("<br><html><div style='text-align: center;'><head><title>Data base</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><form action='hello-servlet' method='POST'>" +
                        "<table id='messages' border='1' style = 'display: inline-block; font-size: 16pt'>");
                out.println("<tr><td>Id</td><td>Название</td><td>Цена</td><td>Дата заезда</td><td>Дата выезда</td><td>Статус</td><td>Действие</td></tr>");
                int i=0;
                while(resultSet.next()){
                    i++;
                    String id=resultSet.getString(1);
                    String start1=resultSet.getString(2);
                    String end1=resultSet.getString(3);
                    String status1=resultSet.getString(4);
                    String room_name1=resultSet.getString(5);
                    String room_cost1=resultSet.getString(6);
                    if(Objects.equals(status1, "0")) out.println("<tr><td>"+i+"</td><td>"+room_name1+"</td><td>"+room_cost1+"</td><td>"+start1+"</td><td>"+end1+"</td><td>Свободен</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='deleteRoom-servlet?id="+id+"'>Удалить</a></td></tr>");
                    else out.println("<tr><td>"+i+"</td><td>"+room_name1+"</td><td>"+room_cost1+"</td><td>"+start1+"</td><td>"+end1+"</td><td>Забронирован</td><td><a href='actionRoom-servlet?id="+id+"'>Изменить</a>|<a href='deleteRoom-servlet?id="+id+"'>Удалить</a></td></tr>");
                }
                resultSet.close();
                st.close();
                conn.close();
                out.println("</table><br><br><input type='submit' name='s1' value='Главное меню' />&nbsp;&nbsp;</form></body></div></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cap.equals("Просмотреть базу номеров")){
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
    public void destroy() {
    }
}