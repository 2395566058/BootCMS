//名字
function sunname() {
	var showName = document.getElementById("showName"); //显示文本的对象
	var contentName = document.getElementById("contentName"); //输入文字的对象
	showName.innerHTML = "：" + contentName.value; //把两个相连接
}

//入学时间
function admissiondate() {
	var showAdmissiondate = document.getElementById("showAdmissiondate"); //显示文本的对象
	var contentAdmissiondate = document.getElementById("contentAdmissiondate"); //输入文字的对象
	showAdmissiondate.style.display = "inline";
	showAdmissiondate.innerHTML = "：" + contentAdmissiondate.value; //把两个相连接
}

//出生年月
function born() {
	var showBorn = document.getElementById("showBorn"); //显示文本的对象
	var contentBorn = document.getElementById("contentBorn"); //输入文字的对象
	showBorn.style.display = "inline";
	showBorn.innerHTML = "：" + contentBorn.value; //把两个相连接
}

//性别
function sex1() {
	var showSex = document.getElementById("showSex"); //显示文本的对象
	var contentSex = document.getElementById("contentSex1"); //输入文字的对象
	showSex.innerHTML = "：" + contentSex.value; //把两个相连接
}

function sex2() {
	var showSex = document.getElementById("showSex"); //显示文本的对象
	var contentSex = document.getElementById("contentSex2"); //输入文字的对象
	showSex.innerHTML = "：" + contentSex.value; //把两个相连接
}

//所属专业
function major() {
	var showMajor = document.getElementById("showMajor"); //显示文本的对象
	var contentMajor = document.getElementById("contentMajor"); //输入文字的对象
	showMajor.innerHTML = "：" + contentMajor.value; //把两个相连接
}

//联系电话
function phone() {
	var showPhone = document.getElementById("showPhone"); //显示文本的对象
	var contentPhone = document.getElementById("contentPhone"); //输入文字的对象

	showPhone.innerHTML = "：" + contentPhone.value; //把两个相连接
}

//管理人
function charge() {
	var showCharge = document.getElementById("showCharge"); //显示文本的对象
	var contentCharge = document.getElementById("contentCharge"); //输入文字的对象
	showCharge.innerHTML = "：" + contentCharge.value; //把两个相连接
}

//学生信息-编辑
window.onload = function() {
	var avatar_file = document.getElementById('avatar_file')
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
	var kg = true;
	edit.onclick = function() {
		if (kg) {
			$("#font-edit").text("保存");
			document.getElementById('st_name').style.color = '#6C79C8';
			document.getElementById('st_phone').style.color = '#6C79C8';
			document.getElementById('st_user_id').style.color = '#6C79C8';
			document.getElementById('st_as_id').style.color = '#6C79C8';
			document.getElementById('st_ma_id').style.color = '#6C79C8';
			document.getElementById('st_registerdate').style.color = 'gray';
			document.getElementById('st_admissiondate').style.color = '#6C79C8';
			document.getElementById('st_born').style.color = '#6C79C8';
			document.getElementById('st_address').style.color = '#6C79C8';
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
			$("#font-edit").text("编辑");
			document.getElementById('st_name').style.color = '#B93C38';
			document.getElementById('st_phone').style.color = '#C9423F';
			document.getElementById('st_user_id').style.color = '#D04937';
			document.getElementById('st_as_id').style.color = '#D04937';
			document.getElementById('st_ma_id').style.color = '#D04937';
			document.getElementById('st_ma_id').style.color = '#D04937';
			document.getElementById('st_registerdate').style.color = '#D04937';
			document.getElementById('st_admissiondate').style.color = '#D04937';
			document.getElementById('st_born').style.color = '#D04937';
			document.getElementById('st_address').style.color = '#D04937';
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
		}
		kg = !kg;
	}
}
