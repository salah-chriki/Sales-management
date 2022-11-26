<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="loading_screen.jsp"%>
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
				<form action="addorderloader">
					<input type="submit" class="btn btn-warning mt-4"
						value="Add Order ">
				</form>
				<div class="container mt-5">

					<div class="row">

						<!-- 				<h3 class="fs-4 mb-3">Recent Orders</h3>-->
						<div class="col order-last">
							<table id="example" class="ui celled table" style="width: 100%">
								<thead>
									<tr>
										<th>codeCmd</th>
										<th>Client</th>
										<th>codeArt</th>
										<th>qteCmd</th>
										<th>dateCmd</th>
										<th>delete</th>
										<th>receipt</th>
										<th>edit</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="o" items="${ordersList }">
										<tr>
											<td>${o.codeCmd }</td>
											<td>${o.client }</td>
											<td>${o.codeArt }</td>
											<td>${o.qteCmd }</td>
											<td>${o.dateCmd }</td>
											<td><s:url action="deleteOrder" var="url">
													<s:param name="codeCmd">${o.codeCmd}</s:param>
												</s:url> <s:a class="btn btn-danger me-4" href="%{url}"
													role="button">
													<i class="fa-solid fa-trash-can"></i>
												</s:a> </td><td><s:url action="receipt" var="url">
													<s:param name="codeCmd">${o.codeCmd}</s:param>
													<s:param name="client">${o.client}</s:param>
													<s:param name="codeArt">${o.codeArt}</s:param>
													<s:param name="qteCmd">${o.qteCmd}</s:param>
													<s:param name="dateCmd">${o.dateCmd }</s:param>
												</s:url> <s:a class="btn btn-info me-4" href="%{url}" role="button">
													<i class="fa-solid fa-file-invoice"></i>
												</s:a> </td><td><s:url action="editOrder" var="url">
													<s:param name="codeCmd">${o.codeCmd}</s:param>
													<s:param name="client">${o.client}</s:param>
													<s:param name="codeArt">${o.codeArt}</s:param>
													<s:param name="qteCmd">${o.qteCmd}</s:param>
													<s:param name="dateCmd">${o.dateCmd }</s:param>
												</s:url> <s:a class="btn btn-success me-4" href="%{url}"
													role="button">
													<i class="fa-solid fa-pen-to-square"></i>
												</s:a></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

						</div>
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