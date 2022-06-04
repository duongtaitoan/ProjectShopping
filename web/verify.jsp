<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">
        <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous"> -->
        <link href="css/style.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">Forgot Your Password?</h1>
                                        <p class="mb-4">We already send a verification  code to your email</p>
                                    </div>
                                     
                                <c:set var="z" value="${sessionScope.username}"/>
                                        <h3>Hello,${sessionScope.useremail}</h3>
                                    <form action="verify" method="post" class="user">
                                    
                                        <div class="form-group">
                                            <input type="textbox" name="authcode" class="form-control form-control-user"
                                                id="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="Enter Verify....">
                                            
                                        </div>
                                        <div id="donghodemnguoc">
                                            <h3>Time:</h3>
                                            <h3><span id="sophut"></span><span id="sogiay"></span></h3>
                                            <h3 id="hetgio" style="display: none;" >Time Off</h3>      
                                        </div>

                                        <input type="submit" value="Verify" class="btn btn-primary btn-user btn-block">
                                    </form>
                                     
                                   
                                                                       
                                       
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="login.html">Already have an account? Login!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
                                    <script>
                                        var thoiluong=30;
//                                  function  thoigian(x){
//                                      x=30;
//                                      thoiluong=x;
//                                      demnguoc();
//                                  }
                                     
                                        setInterval( function() {
                                            thoiluong--;
                                            sophut=Math.floor(thoiluong/60);
                                            sogiay=thoiluong%60;
                                            document.getElementById("sophut").innerText=sophut;
                                            document.getElementById("sogiay").innerText=sogiay;
                                            
                                           
                                                if(thoiluong<=0){
                                             thoiluong=0;
                                        
                                           document.getElementById("hetgio").style.display="block";
                                           document.getElementById("sogiay").style.display="none";
                                           document.getElementById("sophut").style.display="none";
                                        }
                                    },1000);
                                        
                                    </script>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>