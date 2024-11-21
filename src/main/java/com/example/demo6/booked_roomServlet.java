package com.example.demo6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@WebServlet(name = "booked_roomServlet", value = "/booked_room-Servlet")
public class booked_roomServlet extends HttpServlet {


    public static class user{
        public String name,second_name;

        public void setName(String name) {
            this.name=name;
        }
        public void setSecond_name(String second_name) {
            this.second_name=second_name;
        }
        public String getName() {
            return name;
        }
        public String getSecond_name() {
            return second_name;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String iin = (String) session.getAttribute("iin");
        String first_name = request.getParameter("first_name");
        //String email = request.getParameter("email");
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
        ResultSet resultSet = null;
        out.println("<html lang='ru'>" +
                "<head>" +
                "    <title>Апартаменты-студио комфорт</title>" +
                "    <link rel='stylesheet' href='style.css'>" +
                "    <link rel='stylesheet' href='book.css'>" +
                "<meta charset='utf-8' />"+
                "</head>" +
                "<body>" +
                "<header>" +
                "    &emsp;" +
                "    <div class='logo'>" +
                "        <img src= 'images/logo.jpg' alt=''>" +
                "    </div>" +
                "    <div class='name'>ШАНЫРАК</div>" +
                "" +
                "    <div class='container'>" +
                "        <br>" +
                "        <a class='logo' href='index.jsp#'>Главная</a>&emsp;" +
                "        <a class='logo' href='index.jsp#about'>Об отеле</a>&emsp;" +
                "        <a class='logo' href='index.jsp#rooms'>Наши номера</a>&emsp;" +
                "        <a class='logo' href='index.jsp#rules'>Правила проживания</a>&emsp;" +
                "        <a class='logo' href='index.jsp#contacts'>Контакты</a>&emsp;" +
                "        <a class='logo' href='booked_room-Servlet'>Забронированные номера</a>" +
                "    </div>" +
                "    <a href='#' class='up' title='Вернуться к началу страницы' class='topNubex'>Вверх</a>" +
                "</header>"+
                "<form action='booked_room-Servlet' method='GET'>" +
                "<div class='rooms2' id='rooms'>");
        if(iin==null){
            out.println("<div class='form2'>" +
                    "       <div class='info1'>" +
                    "                <div class='info-info1'>" +
                    "                    <span>Введите имя</span>" +
                    "                    <input type='text' class='info-input1' id='nam' name='first_name'>" +
                    "                </div>" +

                            "<div class='info-note'>" +
            "                    <input type='submit' name='s2' id='but' value='Подтвердить' class='input-info' onClick='check_pattern(this.form)'>" +
                    "                </div>" +
                    "            </div>" +
                    "        </div>"
                    );

        }
        if(first_name!=null){
            try {
            resultSet = st.executeQuery("SELECT * FROM public.rooms where rooms.first_name='"+first_name+"'");
            while (resultSet.next()) {
                String start1=resultSet.getString(2);
                String end1=resultSet.getString(3);
                String room_name1=resultSet.getString(5);
                String room_cost1=resultSet.getString(6);
                LocalDate cDstart = LocalDate.parse(start1);
                int daystart = cDstart.getDayOfMonth();
                Month month1 = cDstart.getMonth();
                int yearStart = cDstart.getYear();
                String monthStart="";
                LocalDate cDend = LocalDate.parse(end1);
                int dayEnd = cDend.getDayOfMonth();
                Month month2 = cDend.getMonth();
                int yearEnd = cDend.getYear();
                String monthEnd="";
                SimpleDateFormat dIn = new SimpleDateFormat( "yyyy-MM-dd" );

                if(month1.name()=="JANUARY"){
                    monthStart= "января";
                }
                else if(month1.name()=="FEBRUARY"){
                    monthStart="февраля";
                }
                else if(month1.name()=="MARCH"){
                    monthStart="марта";
                }
                else if(month1.name()=="APRIL"){
                    monthStart="апреля";
                }
                else if(month1.name()=="MAY"){
                    monthStart="мая";
                }
                else if(month1.name()=="JUNE"){
                    monthStart="июня";
                }
                else if(month1.name()=="JULY"){
                    monthStart="июля";
                }
                else if(month1.name()=="AUGUST"){
                    monthStart="августа";
                }
                else if(month1.name()=="SEPTEMBER"){
                    monthStart="сентября";
                }
                else if(month1.name()=="OCTOBER"){
                    monthStart="октября";
                }
                else if(month1.name()=="NOVEMBER"){
                    monthStart="ноября";
                }
                else if(month1.name()=="DECEMBER"){
                    monthStart="декабря";
                }
                if(month2.name()=="JANUARY"){
                    monthEnd= "января";
                }
                else if(month2.name()=="FEBRUARY"){
                    monthEnd="февраля";
                }
                else if(month2.name()=="MARCH"){
                    monthEnd="марта";
                }
                else if(month2.name()=="APRIL"){
                    monthEnd="апреля";
                }
                else if(month2.name()=="MAY"){
                    monthEnd="мая";
                }
                else if(month2.name()=="JUNE"){
                    monthEnd="июня";
                }
                else if(month2.name()=="JULY"){
                    monthEnd="июля";
                }
                else if(month2.name()=="AUGUST"){
                    monthEnd="августа";
                }
                else if(month2.name()=="SEPTEMBER"){
                    monthEnd="сентября";
                }
                else if(month2.name()=="OCTOBER"){
                    monthEnd="октября";
                }
                else if(month2.name()=="NOVEMBER"){
                    monthEnd="ноября";
                }
                else if(month2.name()=="DECEMBER"){
                    monthEnd="декабря";
                }
                out.println("<div class='form3'><div class='form1_main'>" +"<div class='form1_start'>Заезд<div class='form1_day'>"+
                        daystart+"</div><div class='form1_month'>"+monthStart+"</div><div class='form1_year'>"+yearStart+"</div> "+
                        "  </div>" +
                        "<div class='booked'>Номер забронирован</div>"+
                        "<div class='form1_end1'>Выезд"+
                        "<div class='form1_day'>" +
                        dayEnd+"</div><div class='form1_month'>"+monthEnd+"</div><div class='form1_year'>"+yearEnd+"</div>"+
                        "</div>"+
                        "</div>"+
                        "<div class='form1_cost'>" +
                        room_name1+" . . . . . . . . . . . . . . . . . . . . . "+room_cost1+"тг"+
                        "</div>"+
                        "</div>" +
                        "</section>");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
        if(iin!=null){
        try {
            resultSet = st.executeQuery("SELECT * FROM public.rooms where rooms.first_name='"+iin+"'");
            while (resultSet.next()) {
                String start1=resultSet.getString(2);
                String end1=resultSet.getString(3);
                String room_name1=resultSet.getString(5);
                String room_cost1=resultSet.getString(6);
                LocalDate cDstart = LocalDate.parse(start1);
                int daystart = cDstart.getDayOfMonth();
                Month month1 = cDstart.getMonth();
                int yearStart = cDstart.getYear();
                String monthStart="";
                LocalDate cDend = LocalDate.parse(end1);
                int dayEnd = cDend.getDayOfMonth();
                Month month2 = cDend.getMonth();
                int yearEnd = cDend.getYear();
                String monthEnd="";
                SimpleDateFormat dIn = new SimpleDateFormat( "yyyy-MM-dd" );

                if(month1.name()=="JANUARY"){
                    monthStart= "января";
                }
                else if(month1.name()=="FEBRUARY"){
                    monthStart="февраля";
                }
                else if(month1.name()=="MARCH"){
                    monthStart="марта";
                }
                else if(month1.name()=="APRIL"){
                    monthStart="апреля";
                }
                else if(month1.name()=="MAY"){
                    monthStart="мая";
                }
                else if(month1.name()=="JUNE"){
                    monthStart="июня";
                }
                else if(month1.name()=="JULY"){
                    monthStart="июля";
                }
                else if(month1.name()=="AUGUST"){
                    monthStart="августа";
                }
                else if(month1.name()=="SEPTEMBER"){
                    monthStart="сентября";
                }
                else if(month1.name()=="OCTOBER"){
                    monthStart="октября";
                }
                else if(month1.name()=="NOVEMBER"){
                    monthStart="ноября";
                }
                else if(month1.name()=="DECEMBER"){
                    monthStart="декабря";
                }
                if(month2.name()=="JANUARY"){
                    monthEnd= "января";
                }
                else if(month2.name()=="FEBRUARY"){
                    monthEnd="февраля";
                }
                else if(month2.name()=="MARCH"){
                    monthEnd="марта";
                }
                else if(month2.name()=="APRIL"){
                    monthEnd="апреля";
                }
                else if(month2.name()=="MAY"){
                    monthEnd="мая";
                }
                else if(month2.name()=="JUNE"){
                    monthEnd="июня";
                }
                else if(month2.name()=="JULY"){
                    monthEnd="июля";
                }
                else if(month2.name()=="AUGUST"){
                    monthEnd="августа";
                }
                else if(month2.name()=="SEPTEMBER"){
                    monthEnd="сентября";
                }
                else if(month2.name()=="OCTOBER"){
                    monthEnd="октября";
                }
                else if(month2.name()=="NOVEMBER"){
                    monthEnd="ноября";
                }
                else if(month2.name()=="DECEMBER"){
                    monthEnd="декабря";
                }
                out.println("<div class='form3'><div class='form1_main'>" +"<div class='form1_start'>Заезд<div class='form1_day'>"+
                        daystart+"</div><div class='form1_month'>"+monthStart+"</div><div class='form1_year'>"+yearStart+"</div> "+
                        "  </div>" +
                        "<div class='booked'>Номер забронирован</div>"+
                        "<div class='form1_end1'>Выезд"+
                        "<div class='form1_day'>" +
                        dayEnd+"</div><div class='form1_month'>"+monthEnd+"</div><div class='form1_year'>"+yearEnd+"</div>"+
                        "</div>"+
                        "</div>"+
                        "<div class='form1_cost'>" +
                        room_name1+" . . . . . . . . . . . . . . . . . . . . . "+room_cost1+"тг"+
                        "</div>"+
                        "</div>" +
                        "</section>");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
        out.println(
                "</div><section class='action' id='contacts'>" +
                        "    <div class='container1'>" +
                        "        <div class='action-wrap'>" +
                        "            <div class='hero-text'>" +
                        "                <h2 style='color: #FFFFFF'>Контакты</h2>" +
                        "                <p class='intro'>Адрес: г. Бурабай, ул. Жумабаева</p>" +
                        "                <p class='number'>Номер: +77014332531</p>" +
                        "                <p class='hero-social'><img src='images/whats.png' alt='' class='social'><img src='images/inst.png' alt='' class='social'><img" +
                        "                        src='images/telega.png' alt='' class='social'></p>" +
                        "            </div>" +
                        "            <div class='action-logo'>" +
                        "                <div class='logo'>" +
                        "                    <img src= 'images/blogo.jpg' alt=''>" +
                        "                </div>" +
                        "                <div class='name'>ШАНЫРАК</div>" +
                        "            </div>" +
                        "        </div>" +
                        "    </div>" +
                        "</section>" +
                        "</form>" +
                        "</body>" +
                        "</html>");
    }
}
