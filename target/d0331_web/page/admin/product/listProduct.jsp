<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2023/4/3
  Time: 18:57
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
    <div class="col-md-12 column">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>商品小标题</th>
                <th>商品原价</th>
                <th>商品优惠价</th>
                <th>库存</th>
                <th>商品创建时间</th>
                <th>编辑</th>
                <th>删除</th>
                <th>图片管理</th>
                <th>属性值设置</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p" varStatus="st">
                <tr>
                    <td><img src="${p.images.get(0).url}" style="width: 50px;height: 50px"></td>
                    <td>${p.name}</td>
                    <td>${p.subTitle}</td>
                    <td>${p.originalPrice}</td>
                    <td>${p.promotePrice}</td>
                    <td>${p.stock}</td>
                    <td>${p.createDate}</td>
                    <td>
                        <a href="/admin_product_edit?id=${p.id}">
                        <button type="button" class="btn btn-default btn-primary">编辑</button></a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-default btn-primary delete-btn"
                                name="/admin_product_delete?id=${p.id}">删除</button>
                    </td>
                    <td><a href="/admin_image_list?id=${p.id}">
                        <img src="../../../image/product/1.svg"/>
                    </a>
                    </td>
                    <td><a href="/admin_propertyValue_list?id=${p.id}&cid=${p.category.id}">
                        <img src="../../../image/product/1.svg"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-12 column">
        <form class="form-horizontal" role="form" action="/admin_product_add" method="post">
            <div class="form-group">
                商品名称:<input type="text" class="form-control" id="productName" name="name" />
            </div>

            <div class="form-group">
                商品小标题:<input type="text" class="form-control" id="productSub" name="subTitle" />
            </div>

            <div class="form-group">
                商品原价:<input type="text" class="form-control" id="productOri" name="originalPrice" />
            </div>

            <div class="form-group">
                商品优惠价:<input type="text" class="form-control" id="productPro" name="promotePrice" />
            </div>

            <div class="form-group">
                商品销量:<input type="text" class="form-control" id="productStock" name="productStock" />
            </div>
            <input type="hidden" class="form-control"  name="categoryId" value="${products.get(0).category.id}"/>
            <button type="submit" class="btn btn-default">添加</button>

        </form>
    </div>
</div>
</div>

</body>
<script>
    $(function () {
        $(".delete-btn").click(function () {
            let url = $(this).attr("name");
            let that = $(this);
            $.get(
                url,
                function (result) {
                    if (result == "success"){
                        that.parent().parent().hide();
                    }else {
                        alert("出错了");
                    }
                }
            )
        })
    })
</script>
</body>
</html>
