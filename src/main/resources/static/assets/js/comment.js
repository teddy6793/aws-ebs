function comment(id) {
	let content = document.getElementById("comment").value
	if(content !== ""){
		$.ajax({
		url: "/comment/" + id + "/" + content,
		type: "post",
		success: function(data) {
			if (data != 0) {
					document.getElementById("comment-container").innerHTML += data;
				} else {
					window.location.href = "/sign_in_sign_up"
				}
		},
		error: function(xhr) {

		},
	});
	}
	
}