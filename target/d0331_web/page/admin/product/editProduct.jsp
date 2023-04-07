<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2023/4/3
  Time: 19:49
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
            <form role="form" action="/admin_product_update" method="post">
                <div class="form-group">
                    <input type="hidden" class="form-control"  value="${product.id}" name="id" />
                </div>
                <div class="form-group">
                    <input type="hidden" class="form-control"  value="${product.category.id}" name="cid" />
                </div>
                <div class="form-group">
                商品名称: <input type="text" class="form-control"  name="name" value="${product.name}"/>
            </div>

                <div class="form-group">
                    商品小标题: <input type="text" class="form-control"  name="subTitle" value="${product.subTitle}"/>
                </div>

                <div class="form-group">
                    商品原价: <input type="text" class="form-control"  name="originalPrice" value="${product.originalPrice}"/>
                </div>

                <div class="form-group">
                    商品现价: <input type="text" class="form-control"  name="promotePrice" value="${product.promotePrice}"/>
                </div>

                <div class="form-group">
                    商品库存: <input type="text" class="form-control"  name="stock" value="${product.stock}"/>
                </div>
                <div class="form-group">
                     <input type="hidden" class="form-control"  name="createDate" value="${product.createDate}"/>
                </div>

                <button type="submit" class="btn btn-default">更新</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
