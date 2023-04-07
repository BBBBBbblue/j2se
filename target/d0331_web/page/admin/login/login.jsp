<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2023/4/3
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp" />
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center text-success">
                欢迎来到后台管理系统
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <img src="../../../image/login/login1.jpg" style="width: 300px;height: 300px"/>
        </div>
        <div class="col-md-4 column">
            <form role="form" action="/admin_user_login" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户</label><input type="text" name="username" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="exampleInputPassword1" name="password"/>
                </div>
                 <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-md-4 column">
            <img src="../../../image/login/login2.jpg" style="width: 300px;height: 300px"/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
    </div>
</div>
</body>
</html>
