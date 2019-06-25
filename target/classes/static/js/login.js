function check(form) {
	$.ajax({
		url: /BootCMS/Login.action
		data: {
			"user_password": user_password,
			"user_code": user_code
		},
		type: "POST",
		dataType: "json",
		success: function(data) {
			if (data) {
				if (data.code == "msg") {
					showMsg(data.message);
					return false;
				}
			}
		},
		error: function(data) {
			showMsg(data.message);
		}
	});
}