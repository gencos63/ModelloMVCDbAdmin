<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update result</title>
    <link rel="stylesheet"
          href="./css/styles.css"
          type="text/css"/>
</head>
<body >
<h3>Il tuo update è riuscito correttamente.</h3>
       <h4> I dati aggiornati sono:</h4>
    <p>
        ID: ${customer.id}<br>
        Name: ${customer.firstName}<br>
        Last name: ${customer.lastName}<br>
        Balance: ${customer.balance}
    </p>
    <form action="index.html">
        <input type="submit" value="Torna all'homepage">
    </form>
</body>
</html>
