<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- links -->
<%@include file="links.jsp"%>
<title>Gestion De Vente</title>
</head>

<body>
<span class="loader"><span class="loader-inner"></span></span>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<!-- navigation-bar -->
			<%@include file="nav.jsp"%>
			<!-- /#navigation-bar-wrapper -->
			<div class="container-fluid px-5">
				<div class="row my-3">
					<h3 class="fs-2 mb-3">Edit Client</h3>
					 <s:fielderror fieldName="editClientError" class="error-field" style="color:red; padding-left:30px;"/>
					<div class="col">
						<form action="editClient">
						<div class="mb-3">
								<label class="form-label required">Name</label> <input
									type="text" class="form-control" name="nameClient" value="${nameClient }">
							</div>
							<div class="mb-3">
								<label class="form-label required">Email</label> <input
									type="email" class="form-control" name="emailClient" value="${emailClient }">
							</div>
							<div class="mb-3">
								<label class="form-label required">Address</label> <input
									type="text" class="form-control" name="addressClient" value="${addressClient}" id="myInput">
							</div>
							<div class="mb-3">
								<label class="form-label required">Tel</label> <input
									type="text" class="form-control" name="telClient" value="${telClient}" id="myInput">
							</div>
				<!-- 			<div class="mb-3">
								<input type="checkbox" class=" me-2" onclick="myFunction()">Show Password
							</div>
							 -->
							<input type="submit" class="btn btn-primary" value="Edit Client">
						</form>
						<s:a action="clients" class="btn btn-primary mt-3">Cancel</s:a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
	<!-- Scripts -->
	<%@include file="scripts.jsp"%>

</body>

</html>