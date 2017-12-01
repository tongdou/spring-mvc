<%--
  Created by IntelliJ IDEA.
  User: shenyuzhu
  Date: 2017/11/19
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user register</title>
</head>
<body>
    <form action="/user/register.html" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input name="userName" type="text"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
