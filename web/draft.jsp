<!DOCTYPE html>
<html class="h-100" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="h-100">

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

        <!--    <form action="draft" method="post">
                    <label>password :
                        <input name="password" id="password" type="password" onChange="onChange()"/>
                    </label>
                    <br>
                    <label>confirm password:
                        <input type="password" name="confirm" id="confirm_password" onChange="onChange()"/>
                        <span id='message'></span>
                    </label><br>
                    <input type="submit" value="Submit" />
                </form>-->



        <div class="login-form-bg h-100">
            <div class="container h-100">
                <div class="row justify-content-center h-100">
                    <div class="col-xl-6">
                        <div class="form-input-content">
                            <div class="card login-form mb-0">
                                <div class="card-body pt-5">
                                    <a class="text-center" href="index.html"> <h4>Rosella</h4></a>
                                    <h3>Hello,${sessionScope.useremail}</h3>
                                    <form action="draft" method="post" class="mt-5 mb-3 login-input">
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required onChange="onChange()">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="confirm"  id="confirm_password" placeholder="Confirm Password" required onChange="onChange()">
                                            <span id='message'></span>
                                        </div>
                                        <h3>${sessionScope.mess}</h3>
                                        <button class="btn login-form__btn submit w-100">Reset Password</button>
                                    
                                  
                                    </form>
                                            <div class="form-group">

                                            <a href="login.jsp"  class="btn login-form__btn submit w-100">Login Again</a>
                                        </div>
                                </div>
                                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script>
                                          function onChange() {
                                              const password = document.querySelector('input[name=password]');
                                              const confirm = document.querySelector('input[name=confirm]');
                                              if (confirm.value === password.value) {
                                                  confirm.setCustomValidity('');
                                              } else {
                                                  confirm.setCustomValidity('Passwords do not match');
                                              }
                                          }
    </script>

    <script>
        $('#password, #confirm_password').on('keyup', function () {
            if ($('#password').val() == $('#confirm_password').val()) {
                $('#message').html('Matching').css('color', 'green');
            } else
                $('#message').html('Not Matching').css('color', 'red');
        });
    </script>
</body>
</html>





