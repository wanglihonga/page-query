<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.pageInfo.list}" var="person" varStatus="status" >
            <tr>
                <td>${status.count }</td>
                <td>${person.name }</td>
                <td>${person.age }</td>
                <td>
                    <a href="#">修改</a>
                    <c:if test="${sessionScope.loginPerson.id != person.id}">
                        <a href="<%=request.getContextPath()%>/PersonController/delete/${person.id}">删除</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                当前页：${requestScope.pageInfo.pageNum}/总页数：${requestScope.pageInfo.pages}
                <a href="<%=request.getContextPath()%>/PersonController/list?pageNum=1">首页</a>
                <c:if test="${not requestScope.pageInfo.isFirstPage}">
                    <a href="<%=request.getContextPath()%>/PersonController/list?pageNum=${requestScope.pageInfo.pageNum-1}">上一页</a>
                </c:if>
                <c:if test="${not requestScope.pageInfo.isLastPage}">
                    <a href="<%=request.getContextPath()%>/PersonController/list?pageNum=${requestScope.pageInfo.pageNum+1}">下一页</a>
                </c:if>
                <a href="<%=request.getContextPath()%>/PersonController/list?pageNum=${requestScope.pageInfo.pages}">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
