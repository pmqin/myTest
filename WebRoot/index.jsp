<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<style type="text/css">
            table,td{
                border: 1px solid;
                border-collapse: collapse;
            }
        </style>
</head>
<body>
   <table>
            <tr>
                <td>用户ID</td>
                <td>用户名</td>
                <td>用户年龄</td>
                <td>角色编号</td>
            </tr>
            <%--遍历lstUsers集合中的User对象 --%>
            <c:forEach var="user" items="${lstUsers}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.roleId}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>