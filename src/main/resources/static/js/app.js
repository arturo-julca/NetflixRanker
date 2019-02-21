$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace("/?pageSize=" + this.value + "&page=1");
	});
}

function getComboA() {
	var genres = document.getElementById("genreSelect");
	var selectedGenre = genres.options[genres.selectedIndex];
	window.location.replace("/?idGenre=" + selectedGenre.value);
}