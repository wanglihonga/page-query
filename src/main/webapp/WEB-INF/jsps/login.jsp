
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/LoginController/login" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录" /></td>
                <td><input type="reset" value="重置" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
