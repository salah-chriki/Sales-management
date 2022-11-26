<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="signup-form">
                <form action="signup" class="mt-5 border p-4 bg-light shadow">
                    <h4 class="mb-5 text-secondary">Create Your Account</h4>
                     <s:fielderror fieldName="userExistError" class="error-field" style="color:red; padding-left:30px;"/>
                    <div class="row">
                        <div class="mb-3 col-md-12">
                            <label>Email<span class="text-danger">*</span></label>
                            <input type="email" name="login" class="form-control" placeholder="Enter First Name" required>
                        </div>

                        <div class="mb-3 col-md-12">
                            <label>Password<span class="text-danger">*</span></label>
                            <input type="password" name="pass" class="form-control" placeholder="Enter Password" required>
                        </div>
                        <div class="mb-3 col-md-12">
                            <label>Confirm Password<span class="text-danger">*</span></label>
                            <input type="password" name="confirmpassword" class="form-control" placeholder="Confirm Password" required>
                           
                        </div>
                        <s:fielderror fieldName="passwordError" class="error-field" style="color:red; padding-left:30px;"/>
                        <div class="col-md-12">
                           <button class="btn btn-primary float-end">SIGNUP</button>
                        </div>
                    </div>
                </form>
                <p class="text-center mt-3 text-secondary">If you have account, Please <a href="login.jsp">Login</a></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
      $(window).on('load',function(){
    		setTimeout(function(){ // allowing 3 secs to fade out loader
    		$('.error-field').hide();
    		},2500);
    	});
      </script>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  ></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>