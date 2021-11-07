<%-- 
    Document   : Update
    Created on : Oct 25, 2021, 10:54:21 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-6">
                <h2> <b>Hóa Đơn</b></h2>
            </div>

        </div>
        <div class="modal-content">
            <div class="modal-header">						
                <h4 class="modal-title">Nhập thông tin</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            
                <div class="modal-body">
                    <form action="buy" method="POST">

                    <div class="modal-body">
                        <div class="form-group">    
                            <label>Họ và tên:</label>${tree.id}
                            <input type="text" class="form-control" required  name="name">
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại</label>
                            <input type="tel" class="form-control" required  name="phone">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="Email" class="form-control" required name="mail">
                        </div>
                        <div class="form-group">
                            <label>Địa Chỉ nhận hàng</label>
                            <input type="text" class="form-control" required  name="add">
                        </div>
                        <div class="form-group">
                            <label>Tổng số tiền:</label>
                            <input readonly="" type="text" class="form-control" required value="${pay} đ"  name="pay">
                        </div>
                        
                    </div>
                    <div class="modal-footer">
                        
                        <input type="submit" class="btn btn-info" value="Đặt hàng"  onclick="window.alert('Cảm ơn bạn đã mua hàng');">
                        
                    </div>
</form>
                        <a href="cart"><button class="btn btn-info">Quay lại</button></a> 
             
                </div>
           <script>
           

    </body>
</html>
