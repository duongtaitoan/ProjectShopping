<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Search page</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <!-- Pignose Calender -->
        <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
        <!-- Chartist -->
        <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
        <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
        <!-- Custom Stylesheet -->
        <link href="css/style.css" rel="stylesheet">

        <!--use library of jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
        <link rel="stylesheet" href="jquery.back-to-top.css">

        <!--cdn of bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/9d281e3188.js" crossorigin="anonymous"></script>
    </head>

    <body>

        <!--*******************
            Preloader start
        ********************-->
        <div id="preloader">
            <div class="loader">
                <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
                </svg>
            </div>
        </div>
        <!--*******************
            Preloader end
        ********************-->


        <!--**********************************
            Main wrapper start
        ***********************************-->
        <div id="main-wrapper">

            <!--**********************************
                Nav header start
            ***********************************-->
            <div class="nav-header">
                <div class="brand-logo">
                    <a href="MainController">
                        <b class="logo-abbr"><img src="images/logo.png" alt=""> </b>
                        <span class="logo-compact"><img src="./images/logo-compact.png" alt=""></span>
                        <span class="brand-title">
                            <img src="images/logo-text.png" alt="">
                        </span>
                    </a>
                </div>
            </div>
            <!--**********************************
                Nav header end
            ***********************************-->

            <!--**********************************
                Header start
            ***********************************-->
            <div class="header">    
                <div class="header-content clearfix">

                    <div class="nav-control">
                        <div class="hamburger">
                            <span class="toggle-icon"><i class="icon-menu"></i></span>
                        </div>
                    </div>
                    <div class="header-left">
                        <div class="input-group icons">
                            <div class="input-group-prepend">
                                <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
                            </div>
                            <input type="search" class="form-control" placeholder="Search Dashboard" aria-label="Search Dashboard">
                            <div class="drop-down animated flipInX d-md-none">
                                <form action="#">
                                    <input type="text" class="form-control" placeholder="Search">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="header-right">
                        <ul class="clearfix">
                            <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                    <i class="mdi mdi-email-outline"></i>
                                    <span class="badge badge-pill gradient-1">3</span>
                                </a>
                                <div class="drop-down animated fadeIn dropdown-menu">
                                    <div class="dropdown-content-heading d-flex justify-content-between">
                                        <span class="">3 New Messages</span>  
                                        <a href="javascript:void()" class="d-inline-block">
                                            <span class="badge badge-pill gradient-1">3</span>
                                        </a>
                                    </div>
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li class="notification-unread">
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/1.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Saiful Islam</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li class="notification-unread">
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/2.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Adam Smith</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Can you do me a favour?</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/3.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Barak Obama</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/4.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Hilari Clinton</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hello</div>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                    <i class="mdi mdi-bell-outline"></i>
                                    <span class="badge badge-pill gradient-2">3</span>
                                </a>
                                <div class="drop-down animated fadeIn dropdown-menu dropdown-notfication">
                                    <div class="dropdown-content-heading d-flex justify-content-between">
                                        <span class="">2 New Notifications</span>  
                                        <a href="javascript:void()" class="d-inline-block">
                                            <span class="badge badge-pill gradient-2">5</span>
                                        </a>
                                    </div>
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Events near you</h6>
                                                        <span class="notification-text">Within next 5 days</span> 
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Event Started</h6>
                                                        <span class="notification-text">One hour ago</span> 
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Event Ended Successfully</h6>
                                                        <span class="notification-text">One hour ago</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Events to Join</h6>
                                                        <span class="notification-text">After two days</span> 
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown d-none d-md-flex">
                                <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                    <span>English</span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                                </a>
                                <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li><a href="javascript:void()">English</a></li>
                                            <li><a href="javascript:void()">Dutch</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown">
                                <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                    <span class="activity active"></span>
                                    <img src="images/user/1.png" height="40" width="40" alt="">
                                </div>
                                <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <i class="icon-envelope-open"></i> <span>Inbox</span> <div class="badge gradient-3 badge-pill gradient-1">3</div>
                                                </a>
                                            </li>

                                            <hr class="my-2">
                                            <li>
                                                <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                            </li>
                                            <c:choose>
                                                <c:when test="${empty ROLE}">
                                                    <li><a href="login.jsp"><i class="icon-key"></i> <span>Login</span></a></li>
                                                    </c:when>
                                                    <c:when test="${not empty ROLE}">
                                                    <form action="MainController" method="POST">
                                                        <li class="d-grid gap-2">
                                                            <div class="row">
                                                                <div class="col-12">
                                                                    <button style="border: none; outline: none; background: none;">
                                                                        <input type="hidden" name="btnAction" value="Logout">
                                                                        <i class="icon-key"></i> <span style="padding-left: 5px;color: #0d6efd">Logout</span>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        <li/>
                                                    </form>
                                                </c:when>
                                            </c:choose>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--**********************************
                Header end ti-comment-alt
            ***********************************-->

            <!--**********************************
                Sidebar start
            ***********************************-->
            <div class="nk-sidebar">           
                <div class="nk-nav-scroll">
                    <ul class="metismenu" id="menu">
                        <li class="nav-label">Dashboard</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
                            </a>
                            <ul aria-expanded="false">
                                <form action="MainController" method="POST">
                                    <c:if test="${ not empty ROLE}">
                                        <li class="d-grid gap-2">
                                            <div class="row">
                                                <div class="col-2"></div>
                                                <div class="col-10 text-start">
                                                    <button class="btn btn-light border border-light">
                                                        <input type="hidden" name="btnAction" value="Search Product">
                                                        <span>Product Manager</span>
                                                    </button>
                                                </div>
                                            </div>
                                        <li/>
                                    </c:if>
                                </form>
                                <form action="MainController" method="POST">
                                    <c:if test="${ROLE != 'ADMIN' && not empty ROLE}">
                                        <li class="d-grid gap-2">
                                            <div class="row">
                                                <div class="col-2"></div>
                                                <div class="col-10 text-start">
                                                    <button class="btn btn-light border border-light col-11 text-start">
                                                        <input type="hidden" name="btnAction" value="Search History Product">
                                                        <span>History Order</span>
                                                    </button>
                                                </div>
                                            </div>
                                        <li/>
                                    </c:if>
                                </form>
                                <form action="MainController" method="POST">
                                    <c:if test="${ROLE == 'ADMIN' && not empty ROLE }">
                                        <li class="d-grid gap-2">
                                            <div class="row">
                                                <div class="col-2"></div>
                                                <div class="col-10 text-start">
                                                    <button class="btn btn-light border border-light">
                                                        <input type="hidden" name="btnAction" value="Category">
                                                        <span>Category</span>
                                                    </button>
                                                </div>
                                            </div>
                                        <li/>
                                    </c:if>
                                </form>
                                <form action="MainController" method="POST">
                                    <c:if test="${ROLE != 'ADMIN' && not empty ROLE }">
                                        <li class="d-grid gap-2">
                                            <div class="row">
                                                <div class="col-2"></div>
                                                <div class="col-10 text-start">
                                                    <button class="btn btn-light border border-light">
                                                        <input type="hidden" name="btnAction" value="Shopping Cart">
                                                        <span>Shopping Cart</span>
                                                    </button>
                                                </div>
                                            </div>
                                        <li/>
                                    </c:if>
                                </form>
                            </ul>
                        </li>
                        <li class="mega-menu mega-menu-sm">
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-globe-alt menu-icon"></i><span class="nav-text">Layouts</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./layout-blank.html">Blank</a></li>
                                <li><a href="./layout-one-column.html">One Column</a></li>
                                <li><a href="./layout-two-column.html">Two column</a></li>
                                <li><a href="./layout-compact-nav.html">Compact Nav</a></li>
                                <li><a href="./layout-vertical.html">Vertical</a></li>
                                <li><a href="./layout-horizontal.html">Horizontal</a></li>
                                <li><a href="./layout-boxed.html">Boxed</a></li>
                                <li><a href="./layout-wide.html">Wide</a></li>


                                <li><a href="./layout-fixed-header.html">Fixed Header</a></li>
                                <li><a href="layout-fixed-sidebar.html">Fixed Sidebar</a></li>
                            </ul>
                        </li>
                        <li class="nav-label">Apps</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-envelope menu-icon"></i> <span class="nav-text">Email</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./email-inbox.html">Inbox</a></li>
                                <li><a href="./email-read.html">Read</a></li>
                                <li><a href="./email-compose.html">Compose</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-screen-tablet menu-icon"></i><span class="nav-text">Apps</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./app-profile.html">Profile</a></li>
                                <li><a href="./app-calender.html">Calender</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-graph menu-icon"></i> <span class="nav-text">Charts</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./chart-flot.html">Flot</a></li>
                                <li><a href="./chart-morris.html">Morris</a></li>
                                <li><a href="./chart-chartjs.html">Chartjs</a></li>
                                <li><a href="./chart-chartist.html">Chartist</a></li>
                                <li><a href="./chart-sparkline.html">Sparkline</a></li>
                                <li><a href="./chart-peity.html">Peity</a></li>
                            </ul>
                        </li>
                        <li class="nav-label">UI Components</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-grid menu-icon"></i><span class="nav-text">UI Components</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./ui-accordion.html">Accordion</a></li>
                                <li><a href="./ui-alert.html">Alert</a></li>
                                <li><a href="./ui-badge.html">Badge</a></li>
                                <li><a href="./ui-button.html">Button</a></li>
                                <li><a href="./ui-button-group.html">Button Group</a></li>
                                <li><a href="./ui-cards.html">Cards</a></li>
                                <li><a href="./ui-carousel.html">Carousel</a></li>
                                <li><a href="./ui-dropdown.html">Dropdown</a></li>
                                <li><a href="./ui-list-group.html">List Group</a></li>
                                <li><a href="./ui-media-object.html">Media Object</a></li>
                                <li><a href="./ui-modal.html">Modal</a></li>
                                <li><a href="./ui-pagination.html">Pagination</a></li>
                                <li><a href="./ui-popover.html">Popover</a></li>
                                <li><a href="./ui-progressbar.html">Progressbar</a></li>
                                <li><a href="./ui-tab.html">Tab</a></li>
                                <li><a href="./ui-typography.html">Typography</a></li>
                                <!-- </ul>
                            </li>
                            <li>
                                <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                    <i class="icon-layers menu-icon"></i><span class="nav-text">Components</span>
                                </a>
                                <ul aria-expanded="false"> -->
                                <li><a href="./uc-nestedable.html">Nestedable</a></li>
                                <li><a href="./uc-noui-slider.html">Noui Slider</a></li>
                                <li><a href="./uc-sweetalert.html">Sweet Alert</a></li>
                                <li><a href="./uc-toastr.html">Toastr</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="widgets.html" aria-expanded="false">
                                <i class="icon-badge menu-icon"></i><span class="nav-text">Widget</span>
                            </a>
                        </li>
                        <li class="nav-label">Forms</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-note menu-icon"></i><span class="nav-text">Forms</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./form-basic.html">Basic Form</a></li>
                                <li><a href="./form-validation.html">Form Validation</a></li>
                                <li><a href="./form-step.html">Step Form</a></li>
                                <li><a href="./form-editor.html">Editor</a></li>
                                <li><a href="./form-picker.html">Picker</a></li>
                            </ul>
                        </li>
                        <li class="nav-label">Table</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-menu menu-icon"></i><span class="nav-text">Table</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./table-basic.html" aria-expanded="false">Basic Table</a></li>
                                <li><a href="./table-datatable.html" aria-expanded="false">Data Table</a></li>
                            </ul>
                        </li>
                        <li class="nav-label">Pages</li>
                        <li>
                            <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="icon-notebook menu-icon"></i><span class="nav-text">Pages</span>
                            </a>
                            <ul aria-expanded="false">
                                <li><a href="./page-login.html">Login</a></li>
                                <li><a href="./page-register.html">Register</a></li>
                                <li><a href="./page-lock.html">Lock Screen</a></li>
                                <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Error</a>
                                    <ul aria-expanded="false">
                                        <li><a href="./page-error-404.html">Error 404</a></li>
                                        <li><a href="./page-error-403.html">Error 403</a></li>
                                        <li><a href="./page-error-400.html">Error 400</a></li>
                                        <li><a href="./page-error-500.html">Error 500</a></li>
                                        <li><a href="./page-error-503.html">Error 503</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!--**********************************
                Sidebar end
            ***********************************-->

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <div class="container-fluid">
                    <div class="text-center">
                        <c:if test="${not empty USER}">
                            <h3>Welcome - ${USER}</h3>
                        </c:if>
                    </div>

                    <!--Alter message-->
                    <div style="padding: 0 20%; margin-top: 10px ">
                        <c:if test="${not empty UPDATE_PRODUCT_MSG_SUCCESS}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span font-weight-semi-bold text-capitalize style="color: black">${UPDATE_PRODUCT_MSG_SUCCESS}</span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${not empty CREATE_PRODUCT_MSG_SUCCESS}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span class="font-weight-semi-bold text-capitalize"> ${CREATE_PRODUCT_MSG_SUCCESS} </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${not empty DELETE_PRODUCT_MSG}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span class="font-weight-semi-bold text-capitalize">${DELETE_PRODUCT_MSG} </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${not empty DELETE_PRODUCT}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span class="font-weight-semi-bold text-capitalize">${DELETE_PRODUCT} </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${not empty ADD_TO_CART_MSG}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span class="font-weight-semi-bold text-capitalize">${ADD_TO_CART_MSG} </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${not empty CHECK_OUT_CART_MSG}">
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <strong>Note:</strong> <span class="font-weight-semi-bold text-capitalize">${CHECK_OUT_CART_MSG} </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                    </div>

                    <!--Search Product by parameter-->
                    <c:if test="${ROLE == 'ADMIN'}">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="newProductForm" action="MainController" method="POST">
                                    <button class="btn btn-light border border-light">
                                        <input type="hidden" name="btnAction" value="New Product">
                                        <i class="fa-solid fa-file-circle-plus"></i>
                                    </button>
                                </form>
                            </div>
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-12">
                                        <!--Search data-->
                                        <div class=" container mt-2 shadow-lg mb-5 p-3 bg-body rounded">
                                            <div class="text-center">
                                                <h3>Search Product Shopping Online </h3>
                                            </div>
                                            <div class="wrapper mt-2">
                                                <div class="wrapper-header">
                                                    <p>SEARCH PRODUCT</p>
                                                </div>
                                                <div class="wrapper-content">
                                                    <form action="MainController" method="POST">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <div class="form-group">
                                                                    <label>Name</label>
                                                                    <input class="form-control" type="text" name="txtProductName" maxlength="150" value="${searchedProductByName}" placeholder="Search product by name">
                                                                </div>
                                                            </div>
                                                            <div class="col-3">
                                                                <div class="form-group">
                                                                    <label>Category</label>
                                                                    <select name="selectCategory" class="form-control">
                                                                        <option value="0">SELECT CATEGORY</option>
                                                                        <c:forEach items="${LIST_CATEGORY}" var="category">
                                                                            <option class="dropdown-item" 
                                                                                    value="${category.categoryId}" ${category.getCategoryId() == searchedCategoryID ? 'selected' : ''}>${category.typeCategory}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-3 mt-2">
                                                                <div class="form-group">
                                                                    <label></label>
                                                                    <div class="w-100">
                                                                        <button style="padding: 9px" class="btn w-100 btn btn-outline-dark" name="btnAction" value="Search Product">Search</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--Display data in table-->
                        <c:if test="${LIST_PRODUCT != null}">
                            <c:if test="${not empty LIST_PRODUCT}">
                                <c:set var="context" value="${pageContext.request.contextPath}" />
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="active-member">
                                            <div class="table-responsive shadow-lg p-3 bg-body rounded text-center">
                                                <table id="table_product" class="table table-hover mb-0">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 10px">Product</th>
                                                            <th class="col-2">Product Image</th>
                                                            <th class="col-2">Description</th>
                                                            <th>Brand</th>
                                                            <th>Sale Price</th>
                                                            <th>Import Date</th>
                                                            <th>Quantity</th>
                                                            <th>Import Price</th>
                                                            <th>Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${LIST_PRODUCT}" var="product">
                                                            <tr class="text-center">
                                                                <td>${product.productName}</td>
                                                                <td><img src="${context}/${product.productImage}" style="width: 150px;"></td>
                                                                <td>${product.description}</td>
                                                                <td>${product.category.typeCategory}</td>
                                                                <td>
                                                                    <fmt:setLocale value = "vi_VN"/>
                                                                    <fmt:formatNumber value = "${product.salePrice}"/>
                                                                </td>
                                                                <td>${product.importDate}</td>
                                                                <td>${product.quantity}</td>
                                                                <td>
                                                                    <fmt:setLocale value = "vi_VN"/>
                                                                    <fmt:formatNumber value = "${product.importPrice}"/>
                                                                </td>
                                                                <td>
                                                                    <div class="d-flex justify-content-evenly">
                                                                        <div class="d-grid gap-2 d-md-flex" role="group" aria-label="Button group with nested dropdown">
                                                                            <form action="MainController" method="POST">
                                                                                <button style="border: none;outline: none;background: none; color: #0080ff">
                                                                                    <input type="hidden" name="btnAction" value="Details Product">
                                                                                    <input name="txtProductID" type="hidden" value="${product.productId}">
                                                                                    <i class="fa-solid fa-file-pen"></i>
                                                                                </button>
                                                                            </form>
                                                                            <a title="Delete product" href="javascript:{}" onclick="setIdForDeleteModal(${product.productId})" data-bs-toggle="modal" data-bs-target="#deleteModal">
                                                                                <i class="fa-solid fa-trash-can"></i>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${empty LIST_PRODUCT}">
                                <h3 class="text-center" style="color: black">Not found product <i class="fa-solid fa-face-frown-open"></i></h3>
                                </c:if>
                            </c:if>
                        </c:if>

                    <c:if test="${ROLE == 'CUSTOMER'}">
                        <div class="row">
                            <div class="col-2">
                                <h2>CATEGORY</h2>
                                <div class="row mt-5">
                                    <c:if test="${LIST_CATEGORY != null}">
                                        <c:if test="${not empty LIST_CATEGORY}">
                                            <c:forEach items="${LIST_CATEGORY}" var="category">
                                                <form action="SearchProductController" method="POST">
                                                    <ul>
                                                        <li>
                                                            <input name="selectCategory" type="hidden" value="${category.categoryId}">
                                                            <button name="btnAction" value="Category" class="btn btn-outline-secondary w-100">
                                                                ${category.typeCategory}
                                                            </button>
                                                        </li>
                                                    </ul>
                                                </form>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                            <div class="col-10">
                                <h2 class="text-center">PRODUCT</h2>
                                <div class="row mb-5">
                                    <c:if test="${LIST_PRODUCT != null}">
                                        <c:if test="${not empty LIST_PRODUCT}">
                                            <c:set var="context" value="${pageContext.request.contextPath}" />
                                            <c:forEach items="${LIST_PRODUCT}" var="product">
                                                <div class="col-lg-3 col-md-6 mt-5 mb-4 mb-lg-0">
                                                    <div class="card rounded shadow-sm border-1">
                                                        <form action="MainController" method="POST">
                                                            <button style="border: none;outline: none;background: none; color: #0080ff">
                                                                <input type="hidden" name="btnAction" value="Details Product">
                                                                <input name="txtProductID" type="hidden" value="${product.productId}">
                                                                <img src="${context}/${product.productImage}" alt="" class="img-fluid d-block mx-auto mb-3">
                                                            </button>
                                                        </form>
                                                        <h6 class="text-center" style="height: 35px;margin-bottom: 20px">${product.description}</h6>
                                                        <div class="row pe-3 ps-3">
                                                            <div class="mt-auto" >
                                                                <h7>${product.productName}</h7>
                                                            </div>
                                                            <div class="mt-1">
                                                                <strong>
                                                                    <fmt:setLocale value = "vi_VN"/>
                                                                    <fmt:formatNumber value = "${product.salePrice}"/> VN??
                                                                </strong>
                                                            </div>
                                                        </div>
                                                        <form action="MainController" method="POST">
                                                            <div class="d-flex justify-content-center mt-3 mb-3">
                                                                <button class="btn btn-outline-dark">
                                                                    <input type="hidden" name="btnAction" value="Add To Cart">
                                                                    <input name="txtProductID" type="hidden" value="${product.productId}">
                                                                    ADD TO CART
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                </div> 
                            </div> 
                        </div>
                        <c:if test="${empty LIST_PRODUCT}">
                            <h3 class="text-center" style="color: black">Not found product <i class="fa-solid fa-face-frown-open"></i></h3>
                            </c:if>
                        </c:if>

                </div>
                <!-- #/ container -->
            </div>
            <!--**********************************
                Content body end
            ***********************************-->

            <!--**********************************
                Modal confirm message end
            ***********************************-->

            <!--Confirm to remove-->
            <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Deleting Product</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you want to delete ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Close</button>
                            <form action="MainController" method="POST">
                                <input type="hidden" id="deleteProductID" name="txtProductID">
                                <button type="submit" name="btnAction" value="Delete Product" class="btn btn-outline-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <!--**********************************
                Modal confirm message end
            ***********************************-->

            <!--**********************************
                Footer start
            ***********************************-->
            <div class="footer">
                <div class="copyright">
                    <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
                </div>
            </div>
            <!--**********************************
                Footer end
            ***********************************-->
        </div>
        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
           Scripts
        ***********************************-->
        <script src="plugins/common/common.min.js"></script>
        <script src="js/custom.min.js"></script>
        <script src="js/settings.js"></script>
        <script src="js/gleek.js"></script>
        <script src="js/styleSwitcher.js"></script>

        <!-- Chartjs -->
        <script src="./plugins/chart.js/Chart.bundle.min.js"></script>
        <!-- Circle progress -->
        <script src="./plugins/circle-progress/circle-progress.min.js"></script>
        <!-- Datamap -->
        <script src="./plugins/d3v3/index.js"></script>
        <script src="./plugins/topojson/topojson.min.js"></script>
        <script src="./plugins/datamaps/datamaps.world.min.js"></script>
        <!-- Morrisjs -->
        <script src="./plugins/raphael/raphael.min.js"></script>
        <script src="./plugins/morris/morris.min.js"></script>
        <!-- Pignose Calender -->
        <script src="./plugins/moment/moment.min.js"></script>
        <script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
        <!-- ChartistJS -->
        <script src="./plugins/chartist/js/chartist.min.js"></script>
        <script src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>
        <script src="./js/dashboard/dashboard-1.js"></script>

        <script type="text/javascript">
                                                                                //            use jquery to check paging
                                                                                $(document).ready(function () {
                                                                                    $('#table_product').DataTable({
                                                                                        "pageLength": 5,
                                                                                        "searching": false,
                                                                                        "bLengthChange": false
                                                                                    });
                                                                                });
                                                                                //                                                                                        set id of product
                                                                                function setIdForDeleteModal(productID) {
                                                                                    document.getElementById("deleteProductID").value = productID;
                                                                                }
                                                                                //            button new product
                                                                                function newProductAutoSubmit() {
                                                                                    document.getElementById("newProductForm").submit();
                                                                                }
                                                                                //            button logout
        </script>
        <!--libraries of table-->
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
        <!--libraries of bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    </body>

</html>