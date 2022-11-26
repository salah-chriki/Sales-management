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
<title>DIOR</title>
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
					<div class="col">
						<table id="example" class="ui celled table" style="width: 100%">
							<thead>
								<tr>
									<th>codeArt</th>
									<th>nomArt</th>
									<th>PrixArt</th>
									<th>qteArt</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="a" items="${listArticles }">
									<tr>
										<td>${a.codeArt }</td>
										<td>${a.nomArt }</td>
										<td><p class="text-success">${a.prixArt }MAD</p></td>
										<td>${a.qteArt }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
