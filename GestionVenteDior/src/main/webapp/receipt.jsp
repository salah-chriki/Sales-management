<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Receipt</title>
</head>
<body>

	<div class="container">
		<div class="card">
			<div class="card-header">
				<strong>${dateCmd }</strong> <span class="float-right"> <strong>Status:</strong>
					Pending
				</span>

			</div>
			<div class="card-body">
				<div class="row mb-4">
					<div class="col-sm-6">
						<h6 class="mb-3">To:</h6>
						<div>
							<strong>${clientBill.nameClient }</strong>
						</div>
						<div>${clientBill.addressClient }</div>
						<div>Email: ${clientBill.emailClient }</div>
						<div>Phone: ${clientBill.telClient }</div>
					</div>
				</div>
				<div class="table-responsive-sm">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="center">#</th>
								<th class="center">Item</th>
								<th>Description</th>
								<th class="right">Unit Cost</th>
								<th class="center">Qty</th>
								<th class="right">Total</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="left strong">${article.codeArt}</td>
								<td class="left strong">${article.nomArt}</td>
								<td class="left">${article.descArt}</td>
								<td class="right">${article.prixArt}MAD</td>
								<td class="center">${qteCmd }</td>
								<td class="right">${total} MAD</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-lg-4 col-sm-5"></div>

					<div class="col-lg-4 col-sm-5 ml-auto">
						<table class="table table-clear">
							<tbody>
								<tr>
									<td class="left"><strong>Total</strong></td>
									<td class="right"><strong>${total} MAD</strong></td>
								</tr>
							</tbody>
						</table>

					</div>

				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			window.print();
		}
	</script>
</body>
</html>