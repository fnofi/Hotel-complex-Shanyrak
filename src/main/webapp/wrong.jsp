<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Вход</title>
</head>
<body>
<div id="container_demo" style="text-align: center">
  <a class="hiddenanchor" id="tologin"></a>
  <div id="wrapper">
    <div id="login" class="animate form">
      <form action="login-servlet" method="POST">
        <h1>Вход</h1>
        <h2 style="color: red">Неверный логин или пароль</h2>
        <p>
          <label for="username" class="uname" data-icon="u" > Введите имя пользователя или почту </label>
          <input id="username" name="username" required="required" type="text" placeholder="name or mymail@mail.com"/>
        </p>
        <p>
          <label for="password" class="youpasswd" data-icon="p"> Введите пароль </label>
          <input id="password" name="password" required="required" type="password" placeholder="X8df!90EO" />
        </p>
        <p class="keeplogin">
          <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
          <label for="loginkeeping">Запомнить</label>
        </p>
        <p class="login button">
          <input type="submit" value="Login" />
        </p>
      </form>
    </div>
  </div>
</div>
</body>
</html>
