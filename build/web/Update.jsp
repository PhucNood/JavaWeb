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
                <h2>Edit <b>Product</b></h2>
            </div>

        </div>
        <div class="modal-content">
            <div class="modal-header">						
                <h4 class="modal-title">Thông tin cây</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            
                <div class="modal-body">
                    <form action="update" method="POST">

                    <div class="modal-body">
                        <div class="form-group">    
                            <label>ID:</label>${tree.id}
                            <input type="hidden" class="form-control" required value="${tree.id}" name="id">
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" required value="${tree.name}" name="name">
                        </div>
                        <div class="form-group">
                            <label>Price</label>
                            <input type="text" class="form-control" required value="${tree.price}" name="price">
                        </div>
                        <div class="form-group">
                            <label>Image</label>
                            <input type="text" class="form-control" required value="${tree.image}" name="image">
                        </div>
                        <div class="form-group">
                            <label>Description</label>
                            <textarea  class="form-control" required name="des">${tree.description}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Category</label>
                            <select name="cid" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listC}" var="o">
                                    <option ${tree.cid==o.id ?"selected":""} value="${o.id}">${o.category}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input  type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" onclick="cfCancel() ">
                        <input type="submit" class="btn btn-info" value="Save">
                    </div>
</form>
                </div>
           <script>
            function cfCancel(){
                if(confirm('Quay xe ?')===true){
                     window.location.href ="manger";
                }
            }
        </script>

    </body>
</html>
