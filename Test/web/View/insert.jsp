<%-- 
    Document   : insert
    Created on : Feb 23, 2024, 8:19:21 AM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="post">
            ID<input type="number" name="id" ></br>
            Name<input type="text" name="name"></br>
            Gender<input type="radio" name="gender" value="male"/>male
                         <input type="radio" name="gender" value="female"/>female<br/>
            Date<input type="date" name="dob"/><br/>
            Class <select name="cid">
                <c:forEach items="${requestScope.classes}" var="c">
                    <option value="${c.id}" >${c.name}</option>
                </c:forEach>
            </select></br>      
            Area <select name="aid">
                <c:forEach items="${requestScope.areas}" var="a">
                    <option value="${a.id}" >${a.name}</option>
                </c:forEach>
            </select></br>   
            <input type="submit" value="Save">
        </form>
    </body>
</html>
