//名字
function sunname() {
	var showName = document.getElementById("showName"); // 显示文本的对象
	var contentName = document.getElementById("contentName"); // 输入文字的对象
	showName.innerHTML = "：" + contentName.value; // 把两个相连接
}

// 入学时间
function admissiondate() {
	var showAdmissiondate = document.getElementById("showAdmissiondate"); // 显示文本的对象
	var contentAdmissiondate = document.getElementById("contentAdmissiondate"); // 输入文字的对象
	showAdmissiondate.style.display = "inline";
	showAdmissiondate.innerHTML = "：" + contentAdmissiondate.value; // 把两个相连接
}

// 出生年月
function born() {
	var showBorn = document.getElementById("showBorn"); // 显示文本的对象
	var contentBorn = document.getElementById("contentBorn"); // 输入文字的对象
	showBorn.style.display = "inline";
	showBorn.innerHTML = "：" + contentBorn.value; // 把两个相连接
}

// 性别
function sex1() {
	var showSex = document.getElementById("showSex"); // 显示文本的对象
	var contentSex = document.getElementById("contentSex1"); // 输入文字的对象
	showSex.innerHTML = "：" + contentSex.value; // 把两个相连接
}

function sex2() {
	var showSex = document.getElementById("showSex"); // 显示文本的对象
	var contentSex = document.getElementById("contentSex2"); // 输入文字的对象
	showSex.innerHTML = "：" + contentSex.value; // 把两个相连接
}

// 所属专业
function major() {
	var showMajor = document.getElementById("showMajor"); // 显示文本的对象
	var contentMajor = document.getElementById("contentMajor"); // 输入文字的对象
	showMajor.innerHTML = "：" + contentMajor.value; // 把两个相连接
}

// 联系电话
function phone() {
	var showPhone = document.getElementById("showPhone"); // 显示文本的对象
	var contentPhone = document.getElementById("contentPhone"); // 输入文字的对象

	showPhone.innerHTML = "：" + contentPhone.value; // 把两个相连接
}

// 管理人
function charge() {
	var showCharge = document.getElementById("showCharge"); // 显示文本的对象
	var contentCharge = document.getElementById("contentCharge"); // 输入文字的对象
	showCharge.innerHTML = "：" + contentCharge.value; // 把两个相连接
}

// 学生信息-编辑
var kg = true;
var data_st_name = null;
var data_st_phone = null;
var data_st_user_id = null;
var data_st_as_id = null;
var data_st_ma_id = null;
var data_st_admissiondate = null;
var data_st_address = null;
var data_st_born = null;
var data_avatar_file = null;
function onclickByedit() {
	var avatar_file = document.getElementById('avatar_file');
	var st_name = document.getElementById('st_name');
	var st_phone = document.getElementById('st_phone');
	var st_user_id = document.getElementById('st_user_id');
	var st_as_id = document.getElementById('st_as_id');
	var st_ma_id = document.getElementById('st_ma_id');
	var st_registerdate = document.getElementById('st_registerdate');
	var st_admissiondate = document.getElementById('st_admissiondate');
	var st_born = document.getElementById('st_born');
	var st_address = document.getElementById('st_address');
	var curriculumadd = document.getElementById('curriculumadd');
	var edit = document.getElementById('edit');
	if (data_st_name == null) {
		data_st_name = st_name.value;
	}
	if (data_st_phone == null) {
		data_st_phone = st_phone.value;
	}
	if (data_st_born == null) {
		data_st_born = st_born.value;
	}
	if (data_st_user_id == null) {
		data_st_user_id = st_user_id.value;
	}
	if (data_st_as_id == null) {
		data_st_as_id = st_as_id.value;
	}
	if (data_st_ma_id == null) {
		data_st_ma_id = st_ma_id.value;
	}
	if (data_st_admissiondate == null) {
		data_st_admissiondate = st_admissiondate.value;
	}
	if (data_st_address == null) {
		data_st_address = st_address.value;
	}
	if (kg) {
		kg = !kg;
		$("#font-edit").text("保存");
		st_name.style.color = '#6C79C8';
		st_phone.style.color = '#6C79C8';
		st_user_id.style.color = '#6C79C8';
		st_as_id.style.color = '#6C79C8';
		st_ma_id.style.color = '#6C79C8';
		st_registerdate.style.color = 'gray';
		st_admissiondate.style.color = '#6C79C8';
		st_born.style.color = '#6C79C8';
		st_address.style.color = '#6C79C8';
		avatar_file.hidden = false;
		st_name.disabled = false;
		st_phone.disabled = false;
		st_user_id.disabled = false;
		st_as_id.disabled = false;
		st_ma_id.disabled = false;
		st_admissiondate.disabled = false;
		st_born.disabled = false;
		st_address.disabled = false;
		curriculumadd.hidden = false;
	} else {
		kg = !kg;
		$("#font-edit").text("编辑");
		st_name.style.color = '#B93C38';
		st_phone.style.color = '#C9423F';
		st_user_id.style.color = '#D04937';
		st_as_id.style.color = '#D04937';
		st_ma_id.style.color = '#D04937';
		st_registerdate.style.color = '#D04937';
		st_admissiondate.style.color = '#D04937';
		st_born.style.color = '#D04937';
		st_address.style.color = '#D04937';
		avatar_file.hidden = true;
		st_name.disabled = true;
		st_phone.disabled = true;
		st_user_id.disabled = true;
		st_as_id.disabled = true;
		st_ma_id.disabled = true;
		st_registerdate.disabled = true;
		st_admissiondate.disabled = true;
		st_born.disabled = true;
		st_address.disabled = true;
		curriculumadd.hidden = true;
		var existSave = false;
		if (st_name.value != data_st_name) {
			existSave = true;
		}
		if (st_phone.value != data_st_phone) {
			existSave = true;
		}
		if (st_user_id.value != data_st_user_id) {
			existSave = true;
		}
		if (st_as_id.value != data_st_as_id) {
			existSave = true;
		}
		if (st_ma_id.value != data_st_ma_id) {
			existSave = true;
		}
		if (st_born.value != data_st_born) {
			existSave = true;
		}
		if (st_admissiondate.value != data_st_admissiondate) {
			existSave = true;
		}
		if (st_address.value != data_st_address) {
			existSave = true;
		}
		if (data_avatar_file != null) {
			alert("d");
			existSave = true;
		}
		if (existSave == true) {
			xmlhttp.onreadystatechange = saveStatus;
			var file = new FormData();
			file.append("st_id", st_name.name);
			if (data_avatar_file != null) {
				xmlhttp.open("POST", "http://" + ip
						+ ":8848/BootCMS/updateStudentIncludeImage.action",
						true);
				file.append("st_image", avatar_file.files[0]);
			} else {
				xmlhttp.open("POST", "http://" + ip
						+ ":8848/BootCMS/updateStudent.action", true);
			}
			if (st_name.value != data_st_name) {
				file.append("st_name", st_name.value);
			}
			if (st_phone.value != data_st_phone) {
				file.append("st_phone", st_phone.value);
			}
			if (st_user_id.value != data_st_user_id) {
				file.append("st_user_id", st_user_id.value);
			}
			if (st_as_id.value != data_st_as_id) {
				file.append("st_as_id", st_as_id.value);
			}
			if (st_ma_id.value != data_st_ma_id) {
				file.append("st_ma_id", st_ma_id.value);
			}
			if (st_born.value != data_st_born) {
				file.append("st_born", st_born.value);
			}
			if (st_admissiondate.value != data_st_admissiondate) {
				file.append("st_admissiondate", st_admissiondate.value);
			}
			if (st_address.value != data_st_address) {
				file.append("st_address", st_address.value);
			}
			xmlhttp.send(file);
		}
	}
}

function closeCard() {
	data_st_name = null;
	data_st_phone = null;
	data_st_user_id = null;
	data_st_as_id = null;
	data_st_ma_id = null;
	data_st_admissiondate = null;
	data_st_address = null;
	data_st_born = null;
	data_avatar_file = null;
}

function changeFile() {
	var file2 = document.getElementById('avatar_file');
	var img = document.getElementById('avatar_img');
	var reader = new FileReader();
	reader.onload = function(evt) {
		img.src = evt.target.result;
		data_avatar_file = file2.files[0];
	}
	reader.readAsDataURL(file2.files[0]);

}

function saveStatus() {
	if (xmlhttp.readyState == 4) {// 4 = "loaded"
		if (xmlhttp.status == 200) {// 200 = OK
			var msg = xmlhttp.responseText;
			var avatar_file = document.getElementById('avatar_file');
			var st_name = document.getElementById('st_name');
			var st_phone = document.getElementById('st_phone');
			var st_user_id = document.getElementById('st_user_id');
			var st_as_id = document.getElementById('st_as_id');
			var st_ma_id = document.getElementById('st_ma_id');
			var st_registerdate = document.getElementById('st_registerdate');
			var st_admissiondate = document.getElementById('st_admissiondate');
			var st_born = document.getElementById('st_born');
			var st_address = document.getElementById('st_address');
			if (msg == "更改成功") {
				data_st_name = st_name.value;
				data_st_phone = st_phone.value;
				data_st_user_id = st_user_id.value;
				data_st_as_id = st_as_id.value;
				data_st_ma_id = st_ma_id.value;
				data_st_born = st_born.value;
				data_st_admissiondate = st_admissiondate.value;
				data_st_address = st_address.value;
				data_avatar_file = avatar_file.value;
				st_registerdate.value = getNowFormatDate();
			} else {
				st_name.value = data_st_name;
				st_phone.value = data_st_phone;
				st_user_id.value = data_st_user_id;
				st_as_id.value = data_st_as_id;
				st_ma_id.value = data_st_ma_id;
				st_born.value = data_st_born;
				st_admissiondate.value = data_st_admissiondate;
				st_address.value = data_st_address;
				avatar_file.value = data_avatar_file;
			}
			alert(msg);
		} else {
			alert("Problem retrieving XML data");
		}
	}
}

function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date
			.getMonth() + 1;
	var strDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
	var currentdate = date.getFullYear() + seperator1 + month + seperator1
			+ strDate + " " + timeAdd0(date.getHours()) + seperator2
			+ timeAdd0(date.getMinutes()) + seperator2
			+ timeAdd0(date.getSeconds());
	return currentdate;
}

function timeAdd0(str) {
	if (str.length <= 1) {
		str = '0' + str;
	}
	return str
}

function onclickByadd() {
	var add = document.getElementById('add');
	var container = document.getElementById('container');
	var node = container.nextSibling;
	var test = document.getElementById('test');
	oDiv = document.createElement('div');
	oDiv.id = "container1";
	oDiv.innerHTML = "<input disabled type='text' id='curriculum-output' value='"
			+ test.value
			+ "'>"
			+ "<input id='curriculum-delete' type='button' onclick='test(this)' value='&times;'/>";
	container.parentNode.insertBefore(oDiv, node);
	node = oDiv.nextSibling;
	test.value = '';
}

function test(test) {
	test.parentNode.parentNode.removeChild(test.parentNode);
}
