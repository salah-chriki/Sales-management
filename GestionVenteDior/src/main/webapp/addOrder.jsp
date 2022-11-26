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

					<h3 class="fs-2 mb-3">Add Orders</h3>
					  <s:fielderror fieldName="quantityError" class="error-field" style="color:red; padding-left:30px;"/>
					<div class="col">
						<form action="addOrderAction">

							<div class="mb-3">
								<s:select class="form-select form-select-sm"
									aria-label=".form-select-sm example" label="Client"
									list="clientsList.{emailClient}" name="client" />
							</div>
							<div class="mb-3">
								<label class="form-label required">quantity</label> <input
									type="text" class="form-control" name="qteCmd">
							</div>

							<div class="mb-3">
								<s:select class="form-select form-select-sm"
									aria-label=".form-select-sm example" label="code product"
									list="listArticles.{codeArt}" name="codeArt" />
							</div>
							<div class="mb-3">
								<label class="form-label required">Date</label> <s:date name="dateCmd" format="dd/MM/yyyy" />
								<input
									type="date" class="form-control" name="dateCmd"
									value="2022-02-22" min="2014-01-01" max="2030-12-31" >
							</div>


							<input type="submit" class="btn btn-primary" value="Add Order">



						</form>

						<s:a action="orders" class="btn btn-primary mt-3">Cancel</s:a>

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