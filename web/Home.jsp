<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="fase" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <!--                        <li class="nav-item">
                                                    <a class="nav-link" href="#">Manager Account</a>
                                                </li>-->

                        <c:if test="${sessionScope.acc.admin==true}" >
                            <li class="nav-item">
                                <a class="nav-link" href="catman">Manager Category</a>
                            </li>
                        </c:if>
                            
                        <c:if test="${sessionScope.acc.admin==true}" >
                            <li class="nav-item">
                                <a class="nav-link" href="manger">Manager Product</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.acc!=null}" >
                            <li class="nav-item">
                                <a class="nav-link" href="#">Hello ${sessionScope.role}</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.acc!=null}" >
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.acc==null}">
                            <li class="nav-item">
                                <a  class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        </c:if>

                    </ul>

                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>

                    </form>

                    <a class="btn btn-success btn-sm ml-3" href="cart">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light">${sessionScope.size}</span>
                    </a>

                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
               

                <img style="height: 350px;width: 100%;" src="https://webcaycanh.com/wp-content/themes/cay/imgs/logo.png">
            </div>
        </section>
        <!--end of menu-->
        <div class="container">

            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item"><a href="category?id=${cat.id}">${cat.category}</a></li>
                            <!--                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>-->
                        </ol>
                    </nav>
                </div>
            </div>
                            
                           
          


            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div  class="card-header bg-success text-white text-uppercase">
                                <i  class="fa fa-list"></i > Danh mục</div>
                            <ul class="list-group category_block">
                                <c:forEach items="${listC}" var="o">
                                    <li class="list-group-item text-white ${tag==o.id ? "active" :""}"><a href="category?id=${o.id}">${o.category}</a></li>
                                    </c:forEach>

                            </ul>
                        </div>

                        <div class="card bg-light mb-3">
                            <div class="card-header bg-success text-white text-uppercase">Cây mới</div>
                            <c:forEach items="${new}" var="new">                                                  
                                <div class="card-body">
                                    <a href="detail?id=${new.id}" >
                                        <img class="img-fluid" src="${new.image}" /> 
                                    </a> 
                                    <a href="detail?id=${new.id}" > 
                                        <h5 class="card-title">${new.name}</h5>
                                    </a>
                                    <p class="bloc_left_price">${new.price} đ</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>


                    <div class="col-sm-9">
                        <div class="row">
                            <c:forEach items="${trees}" var="o">
                                <div class="col-12 col-md-6 col-lg-4">
                                    <div style="margin-top: 30px" class="card">
                                        <a href="detail?id=${o.id}" >
                                            <img class="card-img-top" src="${o.image}" alt="Some content">
                                        </a>


                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a href="detail?id=${o.id}" title="View Product">${o.name}</a></h4>
                                            <!--                                        <p class="card-text show_txt"></p>-->
                                            <div class="row">
                                                <div class="col">
                                                    <a href="order?id=${o.id}" class="btn btn-danger btn-block">${o.price} VNĐ</a>

                                                    <a href="order?id=${o.id}" class="btn btn-success btn-block">
                                                        <i class="fa fa-shopping-cart">  Thêm vào giỏ hàng  </i>
                                                    </a>                                          
                                                </div>


                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>
                    </div>

                </div>
                <div class="clearfix">
                    <!--                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>-->
                    <ul class="pagination">
                        <c:if test="${ghim>1}">
                            <li class="page-item"><a href="home?page=${ghim-1}" class="page-link">Previous</a></li>
                            </c:if>
                            <c:forEach  begin="1" end="${nop}" var="i">
                            <li class="page-item ${ghim ==i ?"active":""}"><a href="home?page=${i}" class="page-link ">${i}</a></li>
                            </c:forEach>     
                            <c:if test="${ghim<nop}">
                            <li class="page-item"><a href="home?page=${ghim+1}" class="page-link">Next</a></li>
                            </c:if>
                    </ul>
                </div>

            </div>




            <!-- Footer -->
            <footer class="text-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-lg-4 col-xl-3">
                            <h5>About</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <p class="mb-0">
                                Phuc 's project , wish to pass this subject
                            </p>
                        </div>

                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                            <h5>Informations</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><a href="https://www.facebook.com/profile.php?id=100006347791314">FaceBook </a></li>
                               
                            </ul>
                        </div>

                        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                            <h5>Others links</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><a href="https://www.facebook.com/profile.php?id=100006347791314">FaceBook</a></li>
                                
                            </ul>
                        </div>

                        <div class="col-md-4 col-lg-3 col-xl-3">
                            <h5>Contact</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><i class="fa fa-home mr-2"></i> My Project</li>
                                <li><i class="fa fa-envelope mr-2"></i> phucnvhe140098@fpt.edu.vn</li>
                                <li><i class="fa fa-phone mr-2"></i> + 34 966416708</li>
                                <!--                            <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>-->
                            </ul>
                        </div>
                        <div class="col-12 copyright mt-3">
                            <p class="float-left">
                                <a href="#">Back to top</a>
                            </p>
                            <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
                        </div>
                    </div>
                </div>
            </footer>
    </body>
</html>

