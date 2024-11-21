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

@WebServlet(name = "bronServlet", value = "/bron-servlet")
public class BronServlet extends HttpServlet {
    static final String GET_ALL_RECORDS_ROOMS = "SELECT * FROM public.rooms";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String cap=request.getParameter("s1");
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
        String af=String.format("alter table rooms drop constraint rooms_pkey; " +
                "create temporary sequence temp_seq; " +
                "update rooms " +
                "set id = nextval('temp_seq'); " +
                "alter table rooms add primary key (id); " +
                "drop sequence temp_seq;");
        try {
            st.executeUpdate(af);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println("<html lang='ru'>" +
                "<head>" +
                "    <title>Апартаменты-студио комфорт</title>" +
                "    <link rel='stylesheet' href='style.css'>" +
                "    <link rel='stylesheet' href='rooms.css'>" +
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
                "<div class='rooms' id='rooms'>");
        SimpleDateFormat dIn = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Date date2 = null;
        try {
            date2 = dIn.parse(end);
            date = dIn.parse(timeStamp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet resultSet = st.executeQuery(GET_ALL_RECORDS_ROOMS);
            int iStudio=0, iOne=0, iDelux=0, iSuperior=0, iStandard=0,iFamily=0,iApart=0,iComfort=0;
            while(resultSet.next()){
                String room_id=resultSet.getString(1);
                String check_in=resultSet.getString(2);
                String check_out=resultSet.getString(3);
                String room_status=resultSet.getString(4);
                String room_name=resultSet.getString(5);
                String room_cost=resultSet.getString(6);
                //if((check_in != start) && (check_out != end)) {
                /*if(daysBetween(date,date2)<0){
                    String ff =String.format("UPDATE public.rooms SET id='"+room_id+"', check_in='', check_out='', status='"+room_status+"', room_name='"+room_name+"', room_cost='"+room_cost+"' WHERE id='"+room_id+"'");
                    try {
                        st.executeUpdate(ff);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }*/
                    if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Номер-студио") && iStudio==0){
                        iStudio++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/studio/2.jpg' class='studio' alt='' style='width: 300px; height: 300px' onmouseover='this.src='images/studio/1.jpg'' onmouseout='this.src='images/studio/2.jpg';'>" +
                                "<span class='caption'>Номер-студио</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                        out.println("<input type='hidden' name='start' value='"+start+"'>");
                        out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                        out.println("</div>");
                    }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Апартаменты с 1 спальней") && iOne==0){
                        iOne++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/one_bedroom/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/one_bedroom/2.jpg'' onmouseout='this.src='images/one_bedroom/1.jpg';'>" +
                                "        <span class='caption'>Апартаменты с 1 спальней</span></a>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Апартаменты делюкс") && iDelux==0){
                        iDelux++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/delux/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/delux/2.jpg'' onmouseout='this.src='images/delux/1.jpg';'>" +
                                "        <span class='caption'>Апартаменты делюкс</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Улучшенные апартаменты") && iSuperior==0){
                        iSuperior++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/superior/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/superior/2.jpg'' onmouseout='this.src='images/superior/1.jpg';'>" +
                                "            <span class='caption'>Улучшенные апартаменты</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Стандартные апартаменты") && iStandard==0){
                        iStandard++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/standard/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/standard/2.jpg'' onmouseout='this.src='images/standard/1.jpg';'>" +
                                "            <span class='caption'>Стандартные апартаменты</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Семейный") && iFamily==0){
                        iFamily++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/family/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/family/2.jpg'' onmouseout='this.src='images/family/1.jpg';'>" +
                                "            <span class='caption'>Семейный</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Апартаменты-студио") && iApart==0){
                        iApart++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/apart_studio/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/apart_studio/2.jpg'' onmouseout='this.src='images/apart_studio/1.jpg';'>" +
                                "            <span class='caption'>Апартаменты-студио</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
                     if(Objects.equals(room_status, "0") && Objects.equals(room_name, "Апартаменты-студио комфорт") && iComfort==0){
                        iComfort++;
                        out.println("<div class='room'>");
                        out.println("<img src= 'images/comfort/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/comfort/2.jpg'' onmouseout='this.src='images/comfort/1.jpg';'>" +
                                "            <span class='caption'>Апартаменты-студио комфорт</span>");
                        out.println("<p>Доступно для бронирования с "+start+" по "+end+"</p>");
                         out.println("<input type='hidden' name='start' value='"+start+"'>");
                         out.println("<input type='hidden' name='end' value='"+end+"'>");
                        out.println("<button type='submit' name='s1' class='bron_but' value='"+room_id+"'"+"title='Забронировать'>Забронировать</button> ");

                         out.println("</div>");
                     }
//                    if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Номер-студио")){
//                        out.println("<img src= 'images/studio/2.jpg' class='studio' alt='' style='width: 300px; height: 300px' onmouseover='this.src='images/studio/1.jpg'' onmouseout='this.src='images/studio/2.jpg';'>" +
//                                "<span class='caption'>Номер-студио</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Апартаменты с 1 спальней")){
//                        out.println("<img src= 'images/one_bedroom/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/one_bedroom/2.jpg'' onmouseout='this.src='images/one_bedroom/1.jpg';'>" +
//                                "        <span class='caption'>Апартаменты с 1 спальней</span></a>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Апартаменты люкс")){
//                        out.println("<img src= 'images/delux/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/delux/2.jpg'' onmouseout='this.src='images/delux/1.jpg';'>" +
//                                "        <span class='caption'>Апартаменты делюкс</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Улучшенные апартаменты")){
//                        out.println("<img src= 'images/superior/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/superior/2.jpg'' onmouseout='this.src='images/superior/1.jpg';'>" +
//                                "            <span class='caption'>Улучшенные апартаменты</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Стандартные апартаменты")){
//                        out.println("<img src= 'images/standard/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/standard/2.jpg'' onmouseout='this.src='images/standard/1.jpg';'>" +
//                                "            <span class='caption'>Стандартные апартаменты</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Семейный")){
//                        out.println("<img src= 'images/family/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/family/2.jpg'' onmouseout='this.src='images/family/1.jpg';'>" +
//                                "            <span class='caption'>Семейный</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Апартаменты-студио")){
//                        out.println("<img src= 'images/apart_studio/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/apart_studio/2.jpg'' onmouseout='this.src='images/apart_studio/1.jpg';'>" +
//                                "            <span class='caption'>Апартаменты-студио</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
//                    else if(Objects.equals(room_status, "1") && Objects.equals(room_name, "Апартаменты-студио комфорт")){
//                        out.println("<img src= 'images/comfort/1.jpg' alt='' class='studio'  style='width: 300px; height: 300px' onmouseover='this.src='images/comfort/2.jpg'' onmouseout='this.src='images/comfort/1.jpg';'>" +
//                                "            <span class='caption'>Апартаменты-студио комфорт</span>");
//                        out.println("<p class='busy'>Забронирован</p>");
//                    }
                //}
//                else{
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("/wrong.jsp");
//                    dispatcher.forward(request,response);
//                }
            }
            resultSet.close();
            st.close();
            conn.close();
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