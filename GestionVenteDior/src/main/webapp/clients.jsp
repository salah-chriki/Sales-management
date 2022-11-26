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
			<%@include file="nav.jsp"%>
			<div class="container-fluid px-5">
				<div class="container-fluid px-5">
					<s:a class="btn btn-warning mt-5" href="addClient.jsp"
						role="button">Add Client</s:a>
					<div class="row my-3">
						<div class="col">
							<table id="example" class="ui celled table" style="width: 100%">
								<thead>
									<tr>
										<th>codeClient</th>
										<th>nameClient</th>
										<th>emailClient</th>
										<th>addressClient</th>
										<th>telClient</th>
										<th>edit</th>
										<th>delete</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${clientsList }">
										<tr>
											<td>${a.codeClient }</td>
											<td>${a.nameClient }</td>
											<td>${a.emailClient }</td>
											<td>${a.addressClient }</td>
											<td>${a.telClient }</td>
											<td><s:url action="editClientRedir" var="url">
													<s:param name="codeClient">${a.codeClient}</s:param>
													<s:param name="nameClient">${a.nameClient}</s:param>
													<s:param name="emailClient">${a.emailClient}</s:param>
													<s:param name="addressClient">${a.addressClient}</s:param>
													<s:param name="telClient">${a.telClient}</s:param>
												</s:url> <s:a class="btn btn-success me-4" href="%{url}"
													role="button">
													<i class="fa-solid fa-pen-to-square"></i>
												</s:a> </td>
												<td><s:url action="deleteClient" var="url">
													<s:param name="codeClient">${a.codeClient}</s:param>
												</s:url> <s:a class="btn btn-danger me-4" href="%{url}"
													role="button">
													<i class="fa-solid fa-trash-can"></i>
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

