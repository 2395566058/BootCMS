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
var data_st_name = null;
var data_st_phone = null;
var data_st_user_id = null;
var data_st_as_id = null;
var data_st_ma_id = null;
var data_st_admissiondate = null;
var data_st_address = null;
var data_st_born = null;
var data_avatar_file = null;
var data_st_sc=null;
var data_st_sex=null;
function onclickByedit(num) {
	var kg = document.getElementById('font-edit' + num);
	var avatar_file = document.getElementById("avatar_file" + num);
	var st_name = document.getElementById('st_name' + num);
	var st_phone = document.getElementById('st_phone' + num);
	var st_user_id = document.getElementById('st_user_id' + num);
	var st_as_id = document.getElementById('st_as_id' + num);
	var st_ma_id = document.getElementById('st_ma_id' + num);
	var st_registerdate = document.getElementById('st_registerdate' + num);
	var st_admissiondate = document.getElementById('st_admissiondate' + num);
	var st_born = document.getElementById('st_born' + num);
	var st_address = document.getElementById('st_address' + num);
	var curriculumadd = document.getElementById('curriculumadd' + num);
	var div_curriculum = document.getElementById('div-curriculum' + num);
	var divs = div_curriculum.getElementsByTagName("div");
	var deletes=div_curriculum.getElementsByClassName("delete");
	var st_sex=document.getElementById('img-sex'+num);
	var st_sc1 = "";
	for (var i = 0; i < divs.length; i++) {
		var inputs = divs[i].getElementsByTagName("input");
		st_sc1 = st_sc1 + inputs[0].value + "~";
	}
	st_sc1 = st_sc1.substring(0, st_sc1.length - 1);
	if(data_st_sc==null){
		data_st_sc=st_sc1;
	}
	if (data_st_sex == null) {
		data_st_sex = st_sex.innerHTML;
	}
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
	if (data_avatar_file ==null ) {
		data_avatar_file==avatar_file.value;
	}
	if (kg.innerHTML == "编辑") {
		$("#font-edit" + num).text("保存");
		if(deletes.length!=0){
			for(var t=0;t<deletes.length;t++){
				deletes[t].hidden=false;
			}
		}
		st_name.style.color = '#6C79C8';
		st_phone.style.color = '#6C79C8';
		st_user_id.style.color = '#6C79C8';
		st_as_id.style.color = '#6C79C8';
		st_ma_id.style.color = '#6C79C8';
		st_registerdate.style.color = 'gray';
		st_admissiondate.style.color = '#6C79C8';
		st_born.style.color = '#6C79C8';
		st_address.style.color = '#6C79C8';
		st_sex.style.cursor="pointer";
		st_sex.onclick=function (){switchSex(this);};
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
		$("#font-edit" + num).text("编辑");
		if(deletes.length!=0){
			for(var t=0;t<deletes.length;t++){
				deletes[t].hidden=true;
			}
		}
		st_name.style.color = '#B93C38';
		st_phone.style.color = '#C9423F';
		st_user_id.style.color = '#D04937';
		st_as_id.style.color = '#D04937';
		st_ma_id.style.color = '#D04937';
		st_registerdate.style.color = '#D04937';
		st_admissiondate.style.color = '#D04937';
		st_born.style.color = '#D04937';
		st_address.style.color = '#D04937';
		st_sex.onclick=false;
		st_sex.style.cursor="auto";
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
		if (st_sc1!=data_st_sc) {
			existSave = true;
		}
		if (st_sex.innerHTML != data_st_sex) {
			existSave = true;
		}
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
		if (data_avatar_file != null&&data_avatar_file!="") {
			existSave = true;
		}
		if (existSave == true) {
			xmlhttp.onreadystatechange = function(){saveStatus(num)};
			var file = new FormData();
			file.append("st_id", st_name.name);
			if (data_avatar_file != null&&data_avatar_file!="") {
				xmlhttp.open("POST", "/BootCMS/updateStudentIncludeImage.action",
						true);
				file.append("st_image", avatar_file.files[0]);
			} else {
				xmlhttp.open("POST", "/BootCMS/updateStudent.action", true);
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
			if (st_sc1!=data_st_sc) {
				file.append("st_sc", st_sc1);
			}
			if (st_sex.innerHTML != data_st_sex) {
				var sex=st_sex.innerHTML;
				if(sex=="♂"){
					sex="男";
				}else{
					sex="女";
				}
				file.append("st_sex",sex);
			}
			xmlhttp.send(file);
		}
	}
}

function switchSex(obj){
	var sex=obj.innerHTML;
	if(sex=="♂"){
		obj.innerHTML="♀";
	}else{
		obj.innerHTML="♂";
	}
}

function closeCard(num) {
	 data_st_name = null;
	 data_st_phone = null;
	 data_st_user_id = null;
	 data_st_as_id = null;
	 data_st_ma_id = null;
	 data_st_admissiondate = null;
	 data_st_address = null;
	 data_st_born = null;
	 data_avatar_file = null;
	 data_st_sc=null;
	 data_st_sex=null;
}

function changeFile(num) {
	var file2 = document.getElementById('avatar_file' + num);
	var img = document.getElementById('avatar_img' + num);
	var reader = new FileReader();
	reader.onload = function(evt) {
		img.src = evt.target.result;
		data_avatar_file = file2.files[0];
	}
	reader.readAsDataURL(file2.files[0]);

}

function saveStatus(num) {
	if (xmlhttp.readyState == 4) {// 4 = "loaded"
		if (xmlhttp.status == 200) {// 200 = OK
			var msg = xmlhttp.responseText;
			var avatar_file = document.getElementById('avatar_file' + num);
			var st_name = document.getElementById('st_name' + num);
			var st_phone = document.getElementById('st_phone' + num);
			var st_user_id = document.getElementById('st_user_id' + num);
			var st_sex = document.getElementById('img-sex' + num);
			var st_as_id = document.getElementById('st_as_id' + num);
			var st_ma_id = document.getElementById('st_ma_id' + num);
			var st_registerdate = document.getElementById('st_registerdate'
					+ num);
			var st_admissiondate = document.getElementById('st_admissiondate'
					+ num);
			var st_born = document.getElementById('st_born' + num);
			var st_address = document.getElementById('st_address' + num);
			var div_curriculum = document.getElementById('div-curriculum' + num);
			var divs = div_curriculum.getElementsByTagName("div");
			var deletes=div_curriculum.getElementsByClassName("delete");
			var consloe_st_sex= document.getElementById('consloe-st_sex'+num)
			
			var st_sc1 = "";
			for (var i = 0; i < divs.length; i++) {
				var inputs = divs[i].getElementsByTagName("input");
				st_sc1 = st_sc1 + inputs[0].value + "~";
			}
			st_sc1 = st_sc1.substring(0, st_sc1.length - 1);
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
				data_st_sc=st_sc1;
				st_registerdate.value = getNowFormatDate();
				if(st_sex.value=="♂"){
					consloe_st_sex.innerHTML="男";
				}else{
					consloe_st_sex.innerHTML="女";
				}
				data_st_sex=st_sex.innerHTML;
				
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
				if(data_st_sex.value=="♂"){
					consloe_st_sex.value="男";
				}else{
					consloe_st_sex.value="女";
				}
				st_sex.innerHTML=data_st_sex;
				var st_sc2="";
				var list_st_sc=data_st_sc.split("~");
				for(var a=0;a<list_st_sc.length;a++){
					st_sc2=st_sc2+"<div id='container1-"+st_name.name+"' style='width:auto;float:left;'><input disabled type='text' id='curriculum-output"
					+ st_name.name + "' value='" + list_st_sc[a] + "' />"
					+ "<input hidden id='curriculum-delete" + st_name.name
					+ "' type='button' class='delete' onclick='test(this)' value='&times;'/></div>";
				}
				div_curriculum.innerHTML=st_sc2;			
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

function onclickByadd(num) {
	var add = document.getElementById('add' + num);
	var div_curriculum = document.getElementById('div-curriculum' + num);
	var test = document.getElementById('test' + num);
	if (test.value != "") {
		oDiv = document.createElement('div');
		oDiv.id = "container1-" + num;
		oDiv.style.width="auto";
		oDiv.style.float="left";
		oDiv.innerHTML="<input disabled type='text' id='curriculum-output"
				+ num + "' value='" + test.value + "' />"
				+ "<input id='curriculum-delete" + num
				+ "' type='button' class='delete'  onclick='test(this)' value='&times;' />";
		div_curriculum.insertBefore(oDiv,div_curriculum.childNodes[0]);
		test.value = '';
	}
}

function test(test) {
	test.parentNode.parentNode.removeChild(test.parentNode);
}

function chooseDelete(num){
	if(confirm("你确定要删除该学生卡吗？")){
		deleteStudent(num);
	}
}

function deleteStudent(num){
	var xmlhttp2 = null;
	if (window.XMLHttpRequest) {
		xmlhttp2 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlhttp2 != null) {
		xmlhttp2.onreadystatechange = function(){deleteStatus(xmlhttp2,num)};
		xmlhttp2.open("POST", "/BootCMS/deleteStudent.action", true);
		xmlhttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlhttp2.send("st_id=" + num);
	} else {
		alert("Your browser does not support XMLHTTP.");
	}
}

function deleteStatus(xmlhttp2,num) {
	if (xmlhttp2.readyState == 4) {
		if (xmlhttp2.status == 200) {
			var result = xmlhttp2.responseText;
			if(result=="true"){
				alert("删除成功");
				var studentCard = document.getElementById("studentCard"+num);
				studentCard.parentNode.removeChild(studentCard);
			}else{
				alert("删除失败");
			}
		} else {
			alert("Problem retrieving XML data");
		}
	}
}

function addStudent(){
	var avatar_file = document.getElementById("avatar_file0");
	var st_name = document.getElementById('st_name0');
	var st_phone = document.getElementById('st_phone0');
	var st_ma_id = document.getElementById('st_ma_id0');
	var st_registerdate = document.getElementById('st_registerdate0');
	var st_admissiondate = document.getElementById('st_admissiondate0');
	var st_born = document.getElementById('st_born0');
	var st_address = document.getElementById('st_address0');
	var curriculumadd = document.getElementById('curriculumadd0');
	var div_curriculum = document.getElementById('div-curriculum0');
	var divs = div_curriculum.getElementsByTagName("div");
	var st_sex =  document.getElementById("img-sex0");
	
	var form_st_name=st_name.value;
	var form_st_ma_id=st_ma_id.value;
	var form_st_admissiondate=st_admissiondate.value;
	var form_st_phone=st_phone.value;
	var form_st_address=st_address.value;
	var form_st_born=st_born.value;
	var form_st_sex="";
	if(st_sex.innerHTML=="♂"){
		form_st_sex="男";
	}else{
		form_st_sex="女";
	}
	var form_st_sc="";
	if(divs.length!="0"){
		for(var i=0;i<divs.length;i++){
			var div=divs[i];
			var input = div.getElementsByTagName("input");
			form_st_sc=form_st_sc+input[0].value+"~";
		}
		form_st_sc = form_st_sc.substring(0, form_st_sc.length - 1);
	}
	var form_st_image=avatar_file.files[0];
	var xmlhttp3 = null;
	if (window.XMLHttpRequest) {
		xmlhttp3 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp3 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(form_st_name==null||form_st_name==""){
		alert("姓名不能为空！");
		return;
	}
	if(form_st_ma_id==null||form_st_ma_id==""){
		alert("专业不能为空！");
		return;
	}
	if(form_st_admissiondate==null||form_st_admissiondate==""){
		alert("入学时间不能为空！");
		return;
	}
	if(form_st_phone==null||form_st_phone==""){
		alert("手机号码不能为空！");
		return;
	}
	if(form_st_address==null||form_st_address==""){
		alert("家庭地址不能为空！");
		return;
	}
	if(form_st_born==null||form_st_born==""){
		alert("出生日期不能为空！");
		return;
	}
	if(form_st_image==null){
		alert("头像不能为空！");
		return;
	}
	if (xmlhttp3 != null) {
		xmlhttp3.onreadystatechange = function (){addStatus(xmlhttp3)};
		xmlhttp3.open("POST", "/BootCMS/AddStudentList.action", true);
		var file = new FormData();
		file.append("st_name", form_st_name);
		file.append("st_ma_id", form_st_ma_id);
		file.append("st_admissiondate", form_st_admissiondate);
		file.append("st_phone", form_st_phone);
		file.append("st_address", form_st_address);
		file.append("st_born", form_st_born);
		file.append("st_sex", form_st_sex);
		file.append("st_sc", form_st_sc);
		file.append("st_image", form_st_image);
		xmlhttp3.send(file);
	} else {
		alert("Your browser does not support XMLHTTP.");
	}
}

function addStatus(xmlhttp3){
	if (xmlhttp3.readyState == 4) {
		if (xmlhttp3.status == 200) {
			var result = xmlhttp3.responseText;
			alert(result);
			if(result=="添加成功"){
				location.reload();
			}
		} else {
			alert("Problem retrieving XML data");
		}
	}
}

function exitAdd(){
	
}