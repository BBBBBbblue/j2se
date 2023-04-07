<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2023/4/3
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp"/>

<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <strong>欢迎</strong> 尊贵的用户${user.name}
            <a href="/admin_user_exitLogin" class="alert-link">退出</a>
        </div>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-12 column" id="updateProValue">

            <c:forEach items="${proMap}" var="p" varStatus="st">
                <div>${p.key.name}:&nbsp;&nbsp;
                    <input name="/admin_propertyValue_update?id=${p.value.id}" value="${p.value.value}"/></div>
            </c:forEach>
    </div>
</div>

</div>
</body>
<script>
    $("#updateProValue").delegate("div input","blur",function () {
        let value = $(this).val();
        let url = $(this).attr("name");
        let that = $(this);
        $.get(
            url,
            {value:value},
            function (result) {
                if (result == "success"){
                    that.css({borderColor:"green"});
                }else {
                    that.css({borderColor:"red"});
                }
            }
        )
    })
</script>
</html>
