<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LogIn</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="signup-form">
					<form action="login" class="mt-5 border p-4 bg-light shadow">
						<h4 class="mb-5 text-secondary">Login</h4>
						<div class="row">
							<div>
								<s:fielderror fieldName="loginFail" class="error-field"
									style="color:red; padding-left:30px;" />
							</div>
							<div class="mb-3 col-md-12">
								<label>Email<span class="text-danger">*</span></label> <input
									type="email" name="login" class="form-control"
									placeholder="Enter First Name" required="required">
							</div>

							<div class="mb-3 col-md-12">
								<label>Password<span class="text-danger">*</span></label> <input
									type="password" name="pass" class="form-control"
									placeholder="Enter Password" required="required">
							</div>
							<div class="col-md-12">
								<input class="btn btn-primary float-end" type="submit"
									value="LOGIN">
							</div>
							<p class="text-center mt-3 text-secondary">
								If you have account, Please <a href="signup.jsp">Signup</a>
							</p>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		$(window).on('load', function() {
			setTimeout(function() { // allowing 3 secs to fade out loader
				$('.error-field').hide();
			}, 2500);
		});
	</script>
</body>
</html>