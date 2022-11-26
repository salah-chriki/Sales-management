<!-- Sidebar -->
<div class="bg-white" id="sidebar-wrapper">
	<div
		class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
		<img src="img/dior-logo.png" alt="Dior logo" height="38">

	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	
	<div class="list-group list-group-flush my-3">
		<a href="#"
			class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
			<i class="fas fa-tachometer-alt me-2"></i>Dashboard
		</a> <a href="products"
			class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeProducts }">
			<i class="fas fa-gift me-2"></i>Products
		</a> <a href="orders"
			class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeOrders }">
			<i class="fas fa-shopping-cart me-2"></i>Orders
		</a> <a href="clients"
			class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeClients }">
			<i class="fa fa-users me-2" aria-hidden="true"></i>Clients
		</a> <a href="logout"
			class="list-group-item list-group-item-action bg-transparent text-danger fw-bold">
			<i class="fas fa-power-off me-2"></i>Logout
		</a>
	</div>
</div>
<!-- /#sidebar-wrapper -->
