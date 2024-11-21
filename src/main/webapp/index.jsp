<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Гостиница Шанырак | Бурабай - официальный сайт гостиницы</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="book.css">
</head>
<body>
<header>
    &emsp;
    <div class="logo">
        <img src= "images/logo.jpg" alt="">
    </div>
    <div class="name">ШАНЫРАК</div>

    <div class="container">
        <br>
        <a class="logo" href="#">Главная</a>&emsp;
        <a class="logo" href="#about">Об отеле</a>&emsp;
        <a class="logo" href="#rooms">Наши номера</a>&emsp;
        <a class="logo" href="#rules">Правила проживания</a>&emsp;
        <a class="logo" href="#contacts">Контакты</a>&emsp;
        <a class="logo" href="booked_room-Servlet">Забронированные номера</a>
    </div>
    <a href="#" class="up" title="Вернуться к началу страницы">Вверх</a>
    <a href="login.jsp" class="log_in">Вход</a>
</header>
<div class="myProducts">
    <div class="myProducts-gallery">
        <img src= "images/4.jpg" alt="click here" style="width: 100px"
             onclick="myImageFunction(this)">
        <img src= "images/1.png" alt="click here" style="width: 100px"
             onclick="myImageFunction(this)">
        <img src= "images/2.jpg" alt="click here" style="width: 100px"
             onclick="myImageFunction(this)">
        <img src= "images/3.jpg" alt="click here" style="width: 100px"
             onclick="myImageFunction(this)">
    </div>

    <div class="image-container">
        <img id="img-Box" src="images/4.jpg" alt="click here">
    </div>
    <script>
        function myImageFunction(productSmallImg) {
            var productFullImg = document.getElementById("img-Box");
            productFullImg.src = productSmallImg.src;
        }
    </script>
</div>

<footer>
    <form action="bron-servlet" method="POST">
        <div class="online">
            <p class="online">Забронировать онлайн</p>
        </div>
        <div class="start_end1">
            Дата заезда
        </div>
        <div class="start_end2">
            Дата выезда
        </div>
        <div class="date">
            <input type="date" id="min" value="start" class="date" min="" max="" name="start"/>
            <input type="date" id="bron" value="end" class="date" min="" name="end"/>
        </div>
        <script>
            document.getElementById('bron').min = new Date().toISOString().substring(0, 10);
            document.getElementById('min').min = new Date().toISOString().substring(0, 10);
        </script>
        <div class="bron">
            <input type="submit" class="button" value="Проверить наличие">
        </div>
    </form>
</footer>

<div class="about" id="about">
    <h2>Об отеле</h2><br><br>
    <p>
        Уважаемые гости отеля «Шанырак»!
        <br><br>
        Мы  приглашаем вас к нам: на день, на пару дней, надолго. Выбирайте, какое количество квадратных метров вам необходимо для комфорта и – добро пожаловать!
        <br><br>
        Мы находимся в самом сердце города.
        Гостей ожидает:
        <br><br>
        Просторные и уютные номера — апартаменты, подходящие для деловых поездок и семейного отдыха<br><br>
        <ul><li>
        Вы тщательно относитесь к выбору жилья на время поездок и путешествий?<br><br></li><li>
        Вы просматриваете десятки страниц сайтов, чтобы найти идеальный вариант?<br><br></li><li>
        Вам важно, чтобы выбранное место было особенным?<br><br></li></ul>
        Если Вы трижды ответили «да», то наши апартаменты ждут именно Вас! Каждая деталь продумана и каждый элемент имеет смысл. Для наших гостей мы собрали пазл из удачного расположения и нетривиальных интерьеров, удобных матрасов и мягких подушек, качественной мебели и посуды, заботливого персонала и аромата кофе по утрам. И мы готовы поспорить, что побывав в наших апартаментах, у Вас возникнет непреодолимое желание вернуться!
        </p>
</div>
<div class="rooms" id="rooms">
    <h2>Наши номера</h2><br><br>
    <div class="container1">
    <div class="room">
        <a href="studio.jsp">
            <img src= "images/studio/2.jpg" class="studio" alt="" style="width: 300px; height: 300px" onmouseover="this.src='images/studio/1.jpg'" onmouseout="this.src='images/studio/2.jpg';">
            <span class="caption">Номер-студио</span>
        </a>
    </div>
    <div class="room">
    <a href="one_bedroom.jsp">
        <img src= "images/one_bedroom/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/one_bedroom/2.jpg'" onmouseout="this.src='images/one_bedroom/1.jpg';">
        <span class="caption">Апартаменты с 1 спальней</span></a>
    </div>
    <div class="room">
    <a href="delux.jsp">
        <img src= "images/delux/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/delux/2.jpg'" onmouseout="this.src='images/delux/1.jpg';">
        <span class="caption">Апартаменты делюкс</span>
    </a>
    </div>
    <div class="room">
        <a href="superior.jsp">
            <img src= "images/superior/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/superior/2.jpg'" onmouseout="this.src='images/superior/1.jpg';">
            <span class="caption">Улучшенные апартаменты</span>
        </a>
    </div>
    <div class="room">
        <a href="standard.jsp">
            <img src= "images/standard/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/standard/2.jpg'" onmouseout="this.src='images/standard/1.jpg';">
            <span class="caption">Стандартные апартаменты</span>
        </a>
    </div>
    <div class="room">
        <a href="family.jsp">
            <img src= "images/family/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/family/2.jpg'" onmouseout="this.src='images/family/1.jpg';">
            <span class="caption">Семейный</span>
        </a>
    </div>
    <div class="room">
        <a href="apart_studio.jsp">
            <img src= "images/apart_studio/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/apart_studio/2.jpg'" onmouseout="this.src='images/apart_studio/1.jpg';">
            <span class="caption">Апартаменты-студио</span>
        </a>
</div>
    <div class="room">
        <a href="comfort.jsp">
            <img src= "images/comfort/1.jpg" alt="" class="studio"  style="width: 300px; height: 300px" onmouseover="this.src='images/comfort/2.jpg'" onmouseout="this.src='images/comfort/1.jpg';">
            <span class="caption">Апартаменты-студио комфорт</span>
        </a>
</div></div></div>
<div class="rules" id="rules">
    <h2>Правила проживания</h2><br><br>
        <h4>I. ОБЩИЕ ПОЛОЖЕНИЯ</h4>
        <p><b>1.</b><span>&nbsp;</span>Настоящие правила разработаны на основании "Правил предоставления гостиничных услуг в Казахстане", утвержденными Постановлением Правительства от 21.04.2008 №366 "Об утверждении правил предоставления физическими и юридическими лицами торговых, развлекательных, гостиничных, медицинских и иных услуг на территории столицы", Закон от 5 июня 1991 года № 640-XII «О защите прав потребителей», Международных гостиничных правил от 2 ноября 1981года.</p>
        <p><b>2.</b><span>&nbsp;</span>В настоящих Правилах используются следующие основные термины:</p>
        <ul>
            <li><b>Бронирование</b>&nbsp;– услуга отеля по резервированию номера с гарантией предоставить его потребителю на согласованных условиях;</li>
            <li><b>Отель</b>&nbsp;– отель «Жумбактас», осуществляющее гостиничное обслуживание;</li>
            <li><b>Гостиничное обслуживание</b>&nbsp;- услуги по предоставлению отелем номеров для временного проживания физических лиц, а также дополнительные услуги (далее все вместе – услуги);</li>
            <li><b>Дополнительные услуги</b>&nbsp;- услуги общественного питания, бытовые услуги, услуги связи и т.п., оказываемые на возмездной или безвозмездной основе отелем;</li>
            <li><b>Заселение</b>&nbsp;– процедура с момента выдачи ключей Гостю, ознакомления его с условиями размещения в номере, правилами проживания и пожарной безопасности до фактического размещения в номере;</li>
            <li><b>Партнер отеля</b>&nbsp;– Компания/Агентство - юридическое или физическое лицо, оказывающее услуги гостям в рамках договоров заключенных с отелем;</li>
            <li><b>Гость</b>&nbsp;– потребитель - юридическое или физическое лицо, заказывающее и (или) пользующееся услугами;</li>
            <li><b>Авторизационная форма</b>&nbsp;– письмо-разрешение на снятие/блокировку денежных средств с карты Гостя.</li>
            <li><b>Reception</b>&nbsp;- стойка приёма и размещения гостей.</li>
        </ul>
        <p><b>3.</b>&nbsp;Гостиничное обслуживание осуществляется на основании договора. Договор не имеет какой-либо особой формы. Он считается заключенным, когда одна сторона принимает условия, предложенные другой стороной.</p>
        <p><b>4.</b>&nbsp;Настоящие Правила, перечень услуг, прейскурант на услуги, информация о форме и порядке оплаты услуг, о хранении вещей, находятся в информационных папках Reception в холле 1 этажа отеля.</p>
        <p><b>5.</b>&nbsp;Настоящие Правила размещены на официальном сайте отеля www.jumbaktas.kz.</p>
        <p><b>6.</b>&nbsp;Правила проживания в отеле, а также правила пожарной безопасности и информация о предлагаемых потребителю услугах находятся в каждом гостиничном номере.</p>
        <p><b>7.</b>&nbsp;Книга замечаний и предложений находится на Reception.</p>
        <h4>II. ГОСТИНИЧНОЕ ОБСЛУЖИВАНИЕ</h4>
        <p><b>1. ПРЕДОСТАВЛЕНИЕ НОМЕРОВ ДЛЯ ВРЕМЕННОГО ПРОЖИВАНИЯ</b></p>
        <p><b>1.1.</b>&nbsp;Отель предназначен для временного проживания гостей в течение срока, согласованного с администрацией отеля.</p>
        <p><b>1.2.</b>&nbsp;Оформление Гостей, прибывающих в отель и выбывающих из него, осуществляется круглосуточно.</p>
        <p><b>1.3.</b>&nbsp;Бронирование возможно при условии наличия в Отеле необходимого количества свободных (незабронированных) гостиничных номеров запрашиваемой категории в соответствующий период.</p>
        <p><b>1.4.</b>&nbsp;Бронирование номеров осуществляется только на основании письменной заявки с помощью почтовой, электронной или факсимильной связи. В заявке на бронирование номеров указывается: Ф.И.О. гостей, дата и время заезда/предполагаемого выезда; количество и категория номеров, гарантии оплаты проживания.</p>
        <p><b>1.5.</b>&nbsp;Любые изменения, дополнения или аннуляция, к ранее направленному в Отель бронированию, должны быть направлены (сообщены) Отелю не позднее, чем за 24 часа до времени заезда. При размещении групповых заездов, условия оплаты и условия аннуляции устанавливаются индивидуально.</p>
        <p><b>1.6.</b>&nbsp;Отель принимает заявки, как правило, на гарантированной основе. Гарантированное бронирование - это резервирование со специально регистрируемым подтверждением Отеля о том, что он гарантирует Гостю получение заказанного им номера в необходимое ему время. Гость, в свою очередь, гарантирует оплатить номер, даже если не сможет им воспользоваться, в случае неявки. Оплата за неиспользованный номер взимается с Гостя в том случае, если он не смог вовремя аннулировать заказ на размещение в Отеле.</p>
        <p><b>1.7.</b>&nbsp;Для гарантии Вашей брони предусмотрены следующие варианты:<br>-&nbsp;<b>внесение депозита</b>&nbsp;– бронирование с предоплатой за первые сутки на Reception в любое удобное для Вас время, до заезда гостя. В случае отмены бронирования до срока, после которого начинаются штрафные санкции, предоплата возвращается. В случае, когда изменяется дата заезда (изменения должны быть заявлены заранее), предоплата переносится. В случае, заезда гостя предоплата используется для оплаты за проживание и прочие гостиничные услуги. В случае незаезда или отмены бронирования позже установленного срока предоплата не возвращается.<br>-&nbsp;<b>авторизационная форма</b>&nbsp;– бронирование под гарантию кредитной карты. Предоставляются данные банковской карты (производится предварительное снятие/блокирование средств в размере стоимости одних суток). Для этого Вам необходимо заполнить и выслать нам сканированный вариант авторизационной формы, копию паспорта и кредитной карты. Суть этой политики в том, что до тех пор, пока бронирование не отменено (до установленного срока), Отель имеет право накладывать на Гостя штрафные санкции, используя данные по кредитным картам.<br>-&nbsp;<b>безналичный расчет</b>&nbsp;- бронирование по выставлению счёта, осуществляется, как правило, банковским переводом (для юридических лиц). Бронирование по предварительной оплате предполагает полную оплату за весь период пребывания в Отеле. Срок подтверждения предоплаты устанавливается Отелем, но не менее одних суток до заезда гостя.<br>-&nbsp;<b>гарантийное письмо</b>&nbsp;- бронирование под гарантию компании. Партнеры Отеля (компании, корпорации, фирмы) заключают с Отелем договоры, которые устанавливают, что всю финансовую ответственность за неприбытие своих сотрудников или Гостей несут сами организации; достаточно отправить заявку на бронирование в виде гарантийного письма.</p>
        <p><b>1.8.</b>&nbsp;Предоплата за проживание должна поступить не позднее, чем за сутки до момента заезда, в противном случае бронирование аннулируется.</p>
        <p><b>1.9.</b>&nbsp;Менеджер отдела бронирования осуществляет подтверждение бронирования, по указанной в форме бронирования контактной информации, не позднее, 24 часов после получения заявки с предоставлением регистрационного номера брони. Заявки, отправленные в выходные и официальные праздничные дни, обслуживаются в первый последующий за выходными рабочий день.</p>
        <p><b>1.10.</b>&nbsp;Оплата счета является подтверждением заключения договора оказания услуг на условиях, предусмотренных настоящими Правилами.</p>
        <p><b>1.11.</b>&nbsp;Если Гость не заехал в течение 3 (трех) часов после заявленного времени прибытия, бронирование аннулируется без предварительного уведомления с выставлением штрафа за незаезд в размере стоимости одних суток.</p>
        <p><b>1.12.</b>&nbsp;В редких случаях Отель может принять бронирование на негарантированной основе. Это тип бронирования, который не гарантирует, что гость получит номер, а Отель, в случае неявки гостя, - оплату за забронированный номер. Этот тип бронирования используется, когда Гость не желает иметь никаких обязательств перед Отелем.</p>
        <p>О возможности принять Гостя по данному типу бронирования необходимо связаться с менеджером отдела бронирования.</p>
        <p><b>2. ОФОРМЛЕНИЕ ПРОЖИВАНИЯ</b></p>
        <p><b>2.1</b>&nbsp;Для оформления проживания Гость предъявляет документ, подтверждающий личность Гостя. Гость заполняет анкету и ставит свою подпись, подтверждающую заключение договора на оказание услуг между Отелем и Гостем. Допускается заполнение анкеты администратором Отеля, на основании представленных гостем данных, с последующим подписанием её Гостем.</p>
        <p><b>2.2</b>&nbsp;При оформлении проживания администратор отеля выдает Гостю электронный ключ от номера, знакомит его с правилами проживания и пожарной безопасности в Отеле.</p>
        <p><b>2.3</b>&nbsp;По просьбе Гостя в номере может предоставляться дополнительное место для проживания с оплатой в соответствии с прейскурантом и оформлением проживания в порядке, предусмотренном настоящими Правилами.</p>
        <p><b>2.4</b>&nbsp;Администрация обеспечивает возможность проживания Гостя в Отеле только в оплаченный период времени. По истечении согласованного срока проживания Гостю надлежит освободить номер. Гости, желающие продлить проживание в отеле, сообщают об этом в Reception не позднее, чем за 4 часа до окончания срока проживания. В случае, если номер забронирован другими лицами, в продлении срока проживания в этом номере может быть отказано.</p>
        <p><b>2.5</b>&nbsp;Гость вправе досрочно расторгнуть договор. Возврат денег производится после инспекции номера сотрудником номерного фонда. Для расторжения договора, в случае досрочного выезда, Гость обязан предоставить администратору Reception оригиналы квитанции документов об оплате (счет, фискальный чеки и т.д.), а в случае оплаты кредитной картой дополнительно предоставить оригинал слипа с личною подписью, а также электронный ключ от номера. Взамен выдается новый счет за фактическое проживание.</p>
        <p><b>2.6</b>&nbsp;В случае отсутствия у Гостя оригиналов счета, электронного ключа, а также при выезде Гостя менее чем за 24 часа до окончания оплаченного срока проживания, возврат денежных средств не осуществляется.</p>
        <p><b>2.7</b>&nbsp;При этом Гостю, не разместившемуся в номере и отказавшемуся от проживания в течение 10 минут с момента поселения и оплаты проживания, осуществляется полный возврат денежных средств, согласно п.п.1.4.5. и при условии, если Гость не использовал номер.</p>
        <p><b>3. ПЛАТА ЗА ГОСТИНИЧНЫЕ УСЛУГИ</b></p>
        <p><b>3.1.</b>&nbsp;Плата за гостиничное обслуживание осуществляется: Все тарифы на услуги Отеля указаны в тенге и включают 12% НДС.</p>
        <p><b>3.2.</b>&nbsp;За наличный расчет</p>
        <p><b>3.3.</b>&nbsp;Банковскими картами К оплате принимаются Visa, MasterCard, American Express.</p>
        <p><b>3.4.</b>&nbsp;Безналичным платежом: в тенге, долларах США, Евро или российскими рублями (до заезда гостя)</p>
        <p><b>3.5.</b>&nbsp;Авторизационным письмом. Отель оставляет за собой право предварительного блокирования средств на кредитной карте до приезда гостя.</p>
        <p><b>3.6.</b>&nbsp;Дорожные чеки к оплате не принимаются.</p>
        <p><b>3.7.</b>&nbsp;Цены на гостиничное обслуживание отражаются в прейскуранте. В случае изменения стоимости проживания авансовые платежи гостей перерасчету не подлежат.</p>
        <p><b>3.8.</b>&nbsp;Плата за проживание производится Гостем в аванс, посуточно или в полном объеме за весь период планируемого проживания, в соответствии с единым расчетным часом, установленным с 12 часов дня текущих суток.</p>
        <p><b>3.9.</b>&nbsp;Размещение Гостя до и после расчетного часа производится только при наличии свободных от брони номеров. Плата за проживание взимается в следующем порядке</p>
        <p><b>3.10.</b>&nbsp;При раннем прибытии Гостя (размещении в номере в течение 6 часов до расчетного часа) плата за проживание взимается в размере 60% от стоимости номера</p>
        <p><b>3.11.</b>&nbsp;При позднем выезде (в течение 6 часов после расчетного часа выезда) плата за проживание взимается в размере 60% от стоимости номера.</p>
        <p><b>3.12.</b>&nbsp;При размещении в номере более чем за 6 часов до расчетного часа или выезде более чем через 6 часов после расчетного часа, плата за проживание взимается как за полные сутки.</p>
        <p><b>3.13.</b>&nbsp;Оплата за проживание по безналичному расчету должна поступить на расчетный счет Отеля не позднее, чем за двое суток до заезда, если иное не предусмотрено договором.</p>
        <p><b>3.14.</b>&nbsp;В случае осуществления предварительной оплаты проживания и расторжения договора в связи с досрочным выездом в порядке, предусмотренном пунктом 1.5., Отель возвращает Гостю денежные средства в размере стоимости невостребованных услуг. При этом:</p>
        <p><b>3.15.</b>&nbsp;Гостю, оплатившему проживание наличными денежными средствами, их возврат осуществляется во время выезда;</p>
        <p><b>3.16.</b>&nbsp;Гостю, оплатившему проживание банковской картой, возврат денежных средств Отелем осуществляется на банковскую карточку в момент выезда. Срок перечисления средств зависит от банка-эмитента, как правило, в течение 5-10 рабочих дней с момента возврата денежных средств Отелем;</p>
        <p><b>3.17.</b>&nbsp;Гостю, оплатившему проживание по безналичному расчету, возврат денежных средств на расчетный счет осуществляется на основании оригинала письма о возврате, в течение 5 (пяти) банковских дней с момента получения письма.</p>
        <p><b>3.18.</b>&nbsp;В случае изменения заявки на бронирование или отказа от неё возврат денежных средств Гостю в размере стоимости невостребованных услуг осуществляется в течение 5 (пяти) суток с момента поступления в адрес Отеля соответствующего сообщения (заявления).</p>
        <p><b>3.19.</b>&nbsp;В случае поступления сообщения об изменения заявки на бронирование или отказа от неё с нарушением сроков, предусмотренных п.п. 1.8., а также в случае не заезда в Отель, Гость оплачивает Отелю неустойку в размере суточной стоимости проживания. Возврат денежных средств в размере стоимости невостребованных услуг производится в этом случае за вычетом неустойки.</p>
        <p><b>3.20.</b>&nbsp;Не взимается плата: за проживание детей в возрасте до 10 лет при условии их размещения с родителями (опекунами) в одном номере без предоставления отдельного места в номере; Детям до 2 лет детская кроватка предоставляется бесплатно (по запросу).</p>
        <p><b>3.21.</b>&nbsp;Стоимость проживания дополнительного Гостя в номере 8500,00 тенге без предоставления дополнительной кровати (включая завтрак).</p>
        <p><b>3.22.</b>&nbsp;Стоимость дополнительной кровати 5000,00 тенге.</p>
        <p><b>3.23.</b>&nbsp;Размещение домашних животных в Гостинице категорически запрещено.</p>
        <p><b>3.24.</b>&nbsp;Для получения закрывающих документов (акт и счет-фактуры) Гостю, как представителю юридического лица, необходимо заранее, до момента оплаты услуг наличными средствами, предупредить администратора Reception. Акты оформляется на основании предоставленных реквизитов организации, командировочного удостоверения или доверенности.</p>
        <p><b>3.25.</b>&nbsp;Отель использует понятие сезонности ценообразования и предоставления услуг (даты высокой загрузки номерного фонда, выставочные дни, периоды проведения мероприятий). Цена формируется на основе соотношения спроса и предложения на определенный момент времени. Данный тариф может меняться до нескольких раз в день в зависимости от колебания спроса</p>
        <p><b>3.26.</b>&nbsp;В Отеле применяется система скидок согласно условиям акций, специальных ценовых предложений или пакетов услуг, вводимых Отелем. Информация об акциях, а также о порядке и условиях их проведения размещается на сайте: www.jumbaktas.kz, а также путем электронной рассылки сообщений.</p>
        <p><b>3.27.</b>&nbsp;Скидки не суммируются.</p>
        <h4>III. ПРАВИЛА ПРОЖИВАНИЯ В ОТЕЛЕ</h4>
        <p><b>4.1.</b>&nbsp;Заселение Гостя в номер осуществляется после оплаты проживания.</p>
        <p><b>4.2.</b>&nbsp;Гость может пользоваться всеми объектами Отеля, согласно установленному регламенту, рабочего времени и порядка пребывания.</p>
        <p><b>4.3.</b>&nbsp;При выезде из Отеля Гость обязан сдать номер и электронный ключ от номера администратору Reception и окончательно рассчитаться за предоставленные основные и дополнительные услуги.</p>
        <p><b>4.4.</b>&nbsp;Отель имеет право отказать во входе приглашенным лицам, находящимся в состоянии алкогольного опьянения либо состоянии, вызванном потреблением наркотических средств.</p>
        <p><b>4.5.</b>&nbsp;Гость несет ответственность за своевременный уход приглашенных лиц. По приглашению Гостя допускается нахождение приглашенных лиц в номере с 07:00 до 23:00 часов.<br>Для нахождения приглашенного лица в номере после 23 часов (при наличии свободных мест) должно быть оформлено его проживание в Отеле в порядке, предусмотренном настоящими Правилами.</p>
        <p><b>4.6.</b>&nbsp;Гостям и приглашенным лицам надлежит: бережно относиться к имуществу, оборудованию Отеля, соблюдать чистоту и порядок, правила проживания в Отеле, правила пожарной безопасности, правил общественного порядка.</p>
        <p><b>4.7.</b>&nbsp;Гости в период отдыха необходимо соблюдать морально-этические нормы, воздерживаться в общественных местах от чрезмерного употребления алкоголя и нецензурных выражений. Соблюдать правила поведения в Отеле, не оскорблять действиями и словами посетителей и других Гостей Отеля, находящихся на территории Отеля.</p>
        <p><b>4.8.</b>&nbsp;В период с 23 ч.00 мин. до 09 ч. 00 мин. соблюдать тишину и не создавать неудобства другим Гостям Отеля.</p>
        <p><b>4.9.</b>&nbsp;Беречь имущество Отеля, переданное во временное пользование. В случае нанесения ущерба, возмещать убытки, причиненные имуществу Отеля.</p>
        <p><b>4.10.</b>&nbsp;С целью обеспечения комфортного проживания всех гостей, Отель действует в соответствии с некурящей политикой. Однако вы вполне можете насладиться сигаретой в обозначенных зонах. Курение строго запрещено в номере. Не соблюдение данного правила, влечет за собой штраф в размере 15 000 тенге.</p>
        <p><b>4.11.</b>&nbsp;Гость принимает к сведению и не возражает против факта использования в помещениях Отеля (за исключением номеров и туалетных кабин) систем видеонаблюдения.</p>
        <p><b>4.12.</b>&nbsp;Деньги, валютные ценности, ценные бумаги, кредитные и телефонные карточки, драгоценности, ювелирные украшение и другие драгоценные вещи гость обязан хранить в сейфе номера. За утрату денег, иных валютных ценностей, ценных бумаг, кредитных и телефонных карточек, драгоценностей, ювелирных изделий и других драгоценных вещей, не сданных на хранение, Отель ответственности не несет.</p>
        <p><b>4.13.</b>&nbsp;С целью обеспечения в Отеле порядка и безопасности запрещается:</p>
        <p><b>4.13.1.</b>&nbsp;Передавать посторонним лицам ключ и карточку гостя. Гость несет ответственность в рамках действующего законодательства за действия, приглашенных им гостей, в случае нанесения ущерба и другим Гостям Отеля.</p>
        <p><b>4.13.2.</b>&nbsp;Хранить в номере громоздкие вещи, легко¬вос¬пламе¬ня¬ющи¬еся, взрывчатые, ток¬сичес¬кие, наркотические материалы и вещества.</p>
        <p><b>4.13.3.</b>&nbsp;Переставлять, выносить из номера мебель, постельные принадлежности.</p>
        <p><b>5. Ответственность Гостя:</b></p>
        <p><b>5.1.</b>&nbsp;В случае нарушения правил Отеля со стороны Гостя, администрация имеет право отказать Гостю в дальнейшем пребывании на территории Отеля с обязательным составлением акта по данному нарушению и приглашением при необходимости сотрудников компетентных органов.</p>
        <p><b>5.2.</b>&nbsp;В случае отказа от предоставления услуг Гостю, в отношении которого была применена мера по прекращению проживания, возврат денег за оплаченные, но нереализованные услуги по проживанию осуществляется в соответствии с законодательством РК.</p>
        <p><b>5.3.</b>&nbsp;Немедленно сообщить администрации гостиницы при обнаружении пропажи личных вещей из номера для принятия мер по розыску пропавших вещей.</p>
        <p><b>6.</b>Права и обязанности администрации Отеля</p>
        <p><b>6.1.</b>&nbsp;Отель обязан информировать Гостей при оформлении их проживания о предоставляемых основных и дополнительных услугах, форме и порядке их оплаты.</p>
        <p><b>6.2.</b>&nbsp;Отель обязан обеспечить размещение правил предоставления гостиничных услуг; прейскуранта стоимости номеров и других услуг в удобном для обозрения месте и представлять по первому требованию Гостей:</p>
        <p><b>6.3.</b>&nbsp;Отель обязан обеспечить наличие в каждом номере информации о порядке проживания в Гостинице, правил противопожарной безопасности и правил пользования электробытовыми приборами.</p>
        <p><b>6.4.</b>&nbsp;Отель имеет право отказать в размещении лицам:</p>
        <p><b>6.4.1.</b>&nbsp;не предоставившим документов, удостоверяющих личность</p>
        <p><b>6.4.2.</b>&nbsp;не предоставившим оплаты/ гарантии оплаты</p>
        <p><b>6.4.3.</b>&nbsp;не согласным с условиями предоставления размещения/ проживания в гостинице,</p>
        <p><b>6.4.4.</b>&nbsp;нарушающим общественный порядок,</p>
        <p><b>6.4.5.</b>&nbsp;находящимся в состоянии алкогольного/ наркотического опьянения.</p>
        <p><b>6.5.</b>&nbsp;Отель обеспечивает полное соответствие нормам СЭС, другим нормативным актам качества предлагаемых услуг.</p>
        <p><b>6.6.</b>&nbsp;Отель обеспечивает конфиденциальность информации о Гостях и посетителях Отеля.</p>
        <p><b>6.7.</b>&nbsp;Отель обязуется своевременно реагировать на просьбы Гостя в устранении неудобств, поломок в номерном фонде.</p>
        <p><b>6.8.</b>&nbsp;В случае возникновения необходимости осуществления в занимаемом Гостем номере экстренных ремонтных, санитарно - эпидемиологических и иных мероприятий, направленных на устранение причин, создающих угрозу или препятствующих их нормальному (качественному и безопасному) использованию, Отель вправе произвести замену и требовать незамедлительного освобождения и ранее занимаемого Гостем номера.</p>
        <p><b>6.9.</b>&nbsp;Отель обеспечивает сохранность личных вещей проживающих, находящихся в номере, при условии соблюдения порядка проживания в Гостинице и условий, указанных в п.4.12. настоящих Правил.</p>
        <p><b>6.10.</b>&nbsp;Отель в случае обнаружения забытых вещей принимает меры по возврату их владельцу, согласно Правилам обращения с забытыми вещами, действующими в Отеле</p>
        <p><b>7. Забытые вещи</b></p>
        <p><span>В случае обнаружения забытых вещей, Отель принимает все меры по возврату их владельцу согласно установленному порядку:</span></p>
        <p><b>7.1.</b>&nbsp;Вещи, оставленные Гостем в номере, помещаются Отелем на хранение в камеру хранения. Помещение вещей на хранение осуществляется администрацией Отеля в присутствии сотрудников службы внутренней безопасности Отеля, руководителя отдела приема и размещения гостей, руководителем службы горничных.</p>
        <p><b>7.2.</b>&nbsp;Отель хранит забытую Гостем вещь в течение 6 месяцев. Ценные вещи, а также крупные суммы денег хранятся в Гостинице в срок до 1 года с момента составления Акта о забытых вещах.</p>
        <p><b>7.3.</b>&nbsp;Отель не несет ответственность за автотранспорт, оставленный на территории Отеля после выезда Гостя более чем на сутки. В случае невозможности связаться или установить владельца, Отель оставляет за собой право эвакуировать данный автотранспорт за пределы территории Отеля</p>
        <p><b>8. Рекламации и порядок разрешения споров</b></p>
        <p><b>8.1.</b>&nbsp;В случае возникновения каких-либо спорных вопросов относительно качества обслуживания, Гость Отеля должен стремиться к тому, чтобы решить их с администратором Отеля путем обращения на Reception.</p>
        <p><b>8.2.</b>&nbsp;Если проблема не может быть решена на месте, то Гостю необходимо изложить свои пожелания в письменной форме и зарегистрировать их на Reception. Невыполнение этого условия может служить основанием для полного или частичного отказа в удовлетворении претензий.</p>
        <p><b>8.3.</b>&nbsp;В случае невозможности устранения выявленных недостатков на месте, составляется акт в 2-х экземплярах с указанием замечаний, подписанный Гостем Отеля и уполномоченным лицом со стороны Отеля.</p>
        <p><b>8.4.</b>&nbsp;Если администрации Отеля не удалось устранить обнаруженные недостатки на месте, Гость имеет право, при наличии акта выявленных нарушений, в течение 20 дней предъявить претензию.</p>
        <p><b>8.5.</b>&nbsp;При отсутствии соответствующего Акта, упомянутого в п. 8.2, рекламация не может быть принята к рассмотрению, а требования потребителя услуги считаются необоснованными.</p>
</div>

<section class="action" id="contacts">
    <div class="container1">
        <div class="action-wrap">
            <div class="hero-text">
                <div class="cont">
                    <h2 style="color: #FFFFFF">Контакты</h2>
                </div>
                <p class="intro">Адрес: г. Бурабай, ул. Жумабаева</p>
                <p class="number">Номер: +77014332531</p>
                <p class="hero-social"><img src="images/whats.png" alt="" class="social"><img src="images/inst.png" alt="" class="social"><img
                        src="images/telega.png" alt="" class="social"></p>
            </div>
                <div class="action-logo">
                <div class="logo">
                    <img src= "images/blogo.jpg" alt="">
                </div>
                <div class="name">ШАНЫРАК</div>
            </div>
        </div>
    </div>
</section>
<form action="hello-servlet" method="POST">
</form>
</body>
</html>