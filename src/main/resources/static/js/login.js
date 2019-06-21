$("#login_btn").click(function() {
	if (checkLoginAll()) {
		var form = $(".loginform");
		form.submit();
	} else {
		alert("格式错误，请依据提示修改内容！！");
	}
});

// 检查格式正确性
function checkLoginAll() {
	return true;
}