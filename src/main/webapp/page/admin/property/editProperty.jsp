<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2023/4/3
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="../include/header.jsp" />
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/admin_property_update" method="post">
                <div class="form-group">
                    <input type="hidden" class="form-control" id="exampleInputEmail1" value="${p.id}" name="id" />
                </div>
                <div class="form-group">
                    <label for="propertyName">属性名</label><input type="text" class="form-control" id="propertyName" name="name"/>
                </div>
                <button type="submit" class="btn btn-default">更新</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
