<%@ page contentType="text/html;charset=UTF-8" language="java" import="model.Customer" %>
<!DOCTYPE html>
<html>
<head><title>You Owe Us Money!</title>
    <link href="./css/styles.css"
          rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <table class="title">
        <tr>
            <th>
                We Know Where You Live!
            </th>
        </tr>
    </table>
    <p/>
    <img src="./images/club.gif" align="left"/>

    <!-- the View uses the "customer" javabean to extract the information retrieved by the Model -->
    <h2>Watch out, ${customer.firstName},
        we know where you live. </h2>
    <h2>Pay us the $<%=(-1)*((Customer)request.getAttribute("customer")).getBalance()%>
        you owe us before it is too late!</h2>
</div>
</body>
</html>