<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<div style="text-align: center;">
    <head>
        <title>Data base</title>
    </head>
    <body>

    <form action="hello-servlet" method="POST">
        <h1>
            Выберите действие
        </h1><br><br>
            <font size="24pt">
                <div class="worker">
                <input type="submit" name="s1" value="Добавить работника в базу" />&nbsp;&nbsp;
                <input type="submit" name="s1" value="Просмотреть базу работников" />&nbsp;&nbsp;
                </div>
                <br>
                <div class="client">
                <input type="submit" name="s1" value="Добавить клиента в базу" />&nbsp;&nbsp;
                <input type="submit" name="s1" value="Просмотреть базу клиентов" />&nbsp;&nbsp;
                </div>
                <br>
                <div class="rooms">
                    <input type="submit" name="s1" value="Добавить номер в базу" />&nbsp;&nbsp;
                    <input type="submit" name="s1" value="Просмотреть базу номеров" />&nbsp;&nbsp;
                </div>
            </font>
    </form>
    </body>
</div>
</html>