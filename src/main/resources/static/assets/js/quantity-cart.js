function increaseQuantity(id, productId, orderId) {
	let quantity = Number(document.getElementById(id).value);
	let unitPrice = Number(document.getElementById('unitPrice-' + productId + '').value);

	quantity += 1;
	document.getElementById(id).value = quantity
	let total = quantity * unitPrice
	document.getElementById('totalPrice-' + productId).textContent = total.toLocaleString('vi-VN', {
		style: 'currency',
		currency: 'VND',
	});
	document.getElementById('currency-unit-' + productId).style.display = 'none';
	// Update in database
	$.ajax({
		url: "/update_quantity/" + productId + "/" + orderId + "/" + quantity,
		type: "get",
		success: function(response) {
			console.log(response)
		},
		error: function(xhr) {

		},
	});
}

function decreaseQuantity(id, productId, orderId) {
	let quantity = Number(document.getElementById(id).value);
	let unitPrice = Number(document.getElementById('unitPrice-' + productId + '').value);
	if (quantity > 1) {
		quantity -= 1
	}
	document.getElementById(id).value = quantity
	let total = quantity * unitPrice
	document.getElementById('totalPrice-' + productId).textContent = total.toLocaleString('vi-VN', {
		style: 'currency',
		currency: 'VND',
	});
	document.getElementById('currency-unit-' + productId).style.display = 'none';
	$.ajax({
		url: "/update_quantity/" + productId + "/" + orderId + "/" + quantity,
		type: "get",
		success: function(response) {
			console.log(response)
		},
		error: function(xhr) {

		},
	});
}

function changeQuantity(id, productId, orderId){
	let quantity = Number(document.getElementById(id).value);
	let unitPrice = Number(document.getElementById('unitPrice-' + productId + '').value);

	let total = quantity * unitPrice
	document.getElementById('totalPrice-' + productId).textContent = total.toLocaleString('vi-VN', {
		style: 'currency',
		currency: 'VND',
	});
	document.getElementById('currency-unit-' + productId).style.display = 'none';
	// Update in database
	$.ajax({
		url: "/update_quantity/" + productId + "/" + orderId + "/" + quantity,
		type: "get",
		success: function(response) {
			console.log(response)
		},
		error: function(xhr) {

		},
	});
}