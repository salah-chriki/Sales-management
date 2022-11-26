
<script src="https://kit.fontawesome.com/d63313c652.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.semanticui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/fomantic-ui/2.8.8/semantic.min.js"></script>
<script>
	var el = document.getElementById("wrapper");
	var toggleButton = document.getElementById("menu-toggle");

	toggleButton.onclick = function() {
		el.classList.toggle("toggled");
	};
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#example").DataTable();
	});
</script>
<script type="text/javascript">
	function myFunction() {
		var x = document.getElementById("myInput");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
</script>