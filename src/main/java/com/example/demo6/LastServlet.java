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

@WebServlet(name = "lastServlet", value = "/last-servlet")
public class LastServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    static final String GET_ALL_RECORDS_BOOKS = "SELECT * FROM public.book";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String first_name = request.getParameter("first_name");
        String second_name = request.getParameter("second_name");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String room_id = request.getParameter("room_id");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        session.setMaxInactiveInterval(60*60);   // 1 час
        session.setMaxInactiveInterval(-1); // до закрытия браузера
        DbCon db = new DbCon();
        Connection conn;
        try {
            conn = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                "<form action='book-servlet' method='POST'>" +
                "<div class='rooms1' id='rooms'>");
            try {
                addInClient cd=new addInClient();
                cd.add(first_name,second_name,phone_number,email,note);
                updateRooms uR=new updateRooms();
                uR.add(start,end,room_id,email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String r_id = request.getParameter("room_id");
        ResultSet resultSet = null;
        try {
            resultSet = st.executeQuery("SELECT * FROM public.rooms where rooms.id='" + r_id + "'");
        while (resultSet.next()) {
            String room_name = resultSet.getString(5);
            int room_cost = Integer.parseInt(resultSet.getString(6));
            room_cost=room_cost*daycount;
        out.println("<div class='form1'><div class='form1_main'>" +"<div class='form1_start'>Заезд<div class='form1_day'>"+
                daystart+"</div><div class='form1_month'>"+monthStart+"</div><div class='form1_year'>"+yearStart+"</div> "+
                "  </div>" +
                "<div class='booked'>Номер забронирован</div>"+
                "<div class='form1_end1'>Выезд"+
                "<div class='form1_day'>" +
                dayEnd+"</div><div class='form1_month'>"+monthEnd+"</div><div class='form1_year'>"+yearEnd+"</div>"+
                "</div>"+
                "</div>"+
                "<div class='form1_cost'>" +
                room_name+" . . . . . . . . . . . . . . . . . . . . . "+room_cost+"тг"+
                "</div>"+
                "</div>" +
                "    </div>" +
                "</section>");
            session.setAttribute("name", first_name);
            session.setAttribute("iin", email);
            session.setAttribute("start", start);
            session.setAttribute("end", end);
            session.setAttribute("room_name", room_name);
            session.setAttribute("room_cost", room_cost);
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
                        "</html>");}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
