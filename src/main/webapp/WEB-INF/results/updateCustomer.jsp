<%--
  Created by IntelliJ IDEA.
  User: attor
  Date: 17/03/2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
    <link rel="stylesheet"
          href="./css/styles.css"
          type="text/css"/>
</head>
<body >
<table class="title">
    <tr><th>Aggiorna Cliente</th></tr>
</table>
<br/>
<fieldset>
    <legend>Form aggiornamento</legend>


    <form action="update-servlet" method="post">
    <input type="hidden" name="id" value="${customer.id}"><br/>
    Nome: <input type="text" name="name" value="${customer.firstName}"><br/>
    Cognome: <input type="text" name="lastname" value="${customer.lastName}"><br/>
    Balance: <input type="text" name="balance" value="${customer.balance}"><br/>
    <input type="submit" value="Salva Modifica">
    </form>
    </fieldset>
</body>
</html>
