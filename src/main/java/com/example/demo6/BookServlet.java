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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@WebServlet(name = "bookServlet", value = "/book-servlet")
public class BookServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    static final String GET_ALL_RECORDS_BOOKS = "SELECT * FROM public.book";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String cap = request.getParameter("s1");
        LocalDate cDstart = LocalDate.parse(start);
        int daystart = cDstart.getDayOfMonth();
        Month month1 = cDstart.getMonth();
        int yearStart = cDstart.getYear();
        String monthStart="";
        LocalDate cDend = LocalDate.parse(end);
        int dayEnd = cDend.getDayOfMonth();
        Month month2 = cDend.getMonth();
        int yearEnd = cDend.getYear();
        String monthEnd="";
        SimpleDateFormat dIn = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dIn.parse(start);
            date2 = dIn.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int daycount=daysBetween(date1,date2);
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
        String room_id = cap;
        out.println("<html lang='ru'>" +
                "<head>" +
                "    <title>Апартаменты-студио комфорт</title>" +
                "    <link rel='stylesheet' href='style.css'>" +
                "    <link rel='stylesheet' href='book.css'>" +
                "<meta charset='utf-8' />" +
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
                "</header>" +
                "<form action='last-servlet' method='POST'>" +
                "<input type='hidden' name='start' value='"+start+"'>"+
                "<input type='hidden' name='end' value='"+end+"'>"+
                "<input type='hidden' name='room_id' value='"+room_id+"'>"+
                "<section class='section'>" +
                "    <div class='container-info'>"
        );
        String r_id = request.getParameter("s1");
        String dayCount="";
        if(daycount==1){
            dayCount=daycount+" день";
        }
        else if(daycount>1 && daycount <5){
            dayCount=daycount+" дня";
        }
        else if(daycount>=5){
            dayCount=daycount+" дней";
        }
        try {
            ResultSet resultSet = st.executeQuery("SELECT * FROM public.rooms where rooms.id='" + r_id + "'");
            while (resultSet.next()) {
                String room_name = resultSet.getString(5);
                int room_cost = Integer.parseInt(resultSet.getString(6));
                room_cost=room_cost*daycount;
                out.println("<div class='form1'><div class='form1_main'>" +"<div class='form1_start'>Заезд<div class='form1_day'>"+
                        daystart+"</div><div class='form1_month'>"+monthStart+"</div><div class='form1_year'>"+yearStart+"</div> "+
                        "  </div>" +
                        "<div class='day_count'>"+dayCount+"</div>"+
                        "<div class='form1_end'>Выезд"+
                        "<div class='form1_day'>" +
                        dayEnd+"</div><div class='form1_month'>"+monthEnd+"</div><div class='form1_year'>"+yearEnd+"</div>"+
                        "</div>"+
                        "</div>"+
                        "<div class='form1_cost'>" +
                        room_name+" . . . . . . . . . . . . . . . . . . . . . "+room_cost+"тг"+
                        "</div>"+
                        "</div>" +
                        "        <div class='form2'>" +
                        "            <div class='info'>" +
                        "                <div class='info-info'>" +
                        "                    <span>Имя</span>" +
                        "                    <input class='info-input' name='first_name'>" +
                        "                </div>" +
                        "                <div class='info-info'>" +
                        "                    <span>Фамилия</span>" +
                        "                    <input class='info-input' name='second_name'>" +
                        "                </div>" +
                        "                <div class='info-info'>" +
                        "                    <span>Телефон</span>" +
                        "                    <input class='info-input' name='phone_number'>" +
                        "                </div>" +
                        "                <div class='info-info'>" +
                        "                    <span>ИИН</span>" +
                        "                    <input class='info-input' name='email'>" +
                        "                </div>" +
                        "                <div class='info-note'>" +
                        "                    <span>Примечание</span>" +
                        "                    <textarea class='info-note1' name='note' type='text'></textarea>" +
                        "                </div>" +
                        "                <div class='info-note'>" +
                        "                    <input type='submit' name='s2' value='Подтвердить' class='input-info'>" +
                        "                </div>" +
                        "            </div>" +
                        "        </div>"+
                        "    </div>" +
                        "</section>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public static int daysBetween(Date before, Date after) {
        Calendar c1 = createCalendarWithoutTime(before);
        Calendar c2 = createCalendarWithoutTime(after);
        int days = 0;

        for (;c1.before(c2); days++) {
            c1.add(Calendar.DATE, 1);
        }

        return days;
    }
    private static Calendar createCalendarWithoutTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
