//选修课
function course() {
	$("#curriculum_all").addClass("hidden_all");
	$("#course_all").addClass("visible_all2");
	var course_path = document.getElementById('course_path');
	var course_input = document.getElementById('course_input');
	var course_all = document.getElementById('course_all')
	course_path.hidden = false;
	course_input.hidden = false;
	course_all.hidden = false;
	$("#curriculum_all").removeClass("visible_all");
	$("#course_all").addClass("hidden_all2");
	showScheduleList();
}
// 返回分类
function catalog() {
	$("#curriculum_all").addClass("visible_all");
	$("#course_all").addClass("hidden_all2");
	var course_path = document.getElementById('course_path');
	var course_input = document.getElementById('course_input');
	var course_all = document.getElementById('course_all')
	course_path.hidden = true;
	course_input.hidden = true;
	course_all.hidden = true;
	$("#curriculum_all").removeClass("hidden_all");
	$("#course_all").addClass("visible_all2");
}

// 编辑-选修
window.onload = function() {
	var course_input = document.getElementById('course_input')
	var icon = document.getElementById('icon');
	var editC = document.getElementById('editC');
	var count = 0;
	course_input.onclick = function() {
		if (count == 0) {
			$("#course_input").addClass("edit1");
			$("#iconB").addClass("edit2");
			icon.src = "img/input_2.png";
			editC.style.color = 'white';
			editC.innerHTML = '完 成';
			var course_all=document.getElementById('course_all');
			var buttons = course_all.getElementsByTagName("Button");
			for(var t=0;t<buttons.length;t++){
				buttons[t].hidden=false;
			}
			count++;
		} else {
			$("#course_input").removeClass("edit1");
			$("#iconB").removeClass("edit2");
			icon.src = "img/input_1.png";
			editC.style.color = '#A2404D';
			editC.innerHTML = '编 辑';
			var course_all=document.getElementById('course_all');
			var buttons = course_all.getElementsByTagName("Button");
			for(var t=0;t<buttons.length;t++){
				buttons[t].hidden=true;
			}
			count = 0;
		}
	}
}

// 星期日
var sunday = 0;

function sun() {
	if (sunday++ % 2 == 0) {
		document.getElementById('sun').style.background = '#6C757D';
		document.getElementById('sun').style.color = 'white';
		document.getElementById('sun').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = false;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('sun').removeAttribute("style");
		document.getElementById('from-sun').value = "";
		document.getElementById('to-sun').value = "";
	}
}

// 星期一
var monday = 0;

function mon() {
	if (monday++ % 2 == 0) {
		document.getElementById('mon').style.background = '#6C757D';
		document.getElementById('mon').style.color = 'white';
		document.getElementById('mon').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = false;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('mon').removeAttribute("style");
		document.getElementById('from-mon').value = "";
		document.getElementById('to-mon').value = "";
	}
}

// 星期二
var tuesday = 0;

function tue() {
	if (tuesday++ % 2 == 0) {
		document.getElementById('tue').style.background = '#6C757D';
		document.getElementById('tue').style.color = 'white';
		document.getElementById('tue').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = false;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('tue').removeAttribute("style");
		document.getElementById('from-tue').value = "";
		document.getElementById('to-tue').value = "";
	}
}

// 星期三
var wednesday = 0;

function wed() {
	if (wednesday++ % 2 == 0) {
		document.getElementById('wed').style.background = '#6C757D';
		document.getElementById('wed').style.color = 'white';
		document.getElementById('wed').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = false;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('wed').removeAttribute("style");
		document.getElementById('from-wed').value = "";
		document.getElementById('to-wed').value = "";
	}
}

// 星期四
var thursday = 0;

function thu() {
	if (thursday++ % 2 == 0) {
		document.getElementById('thu').style.background = '#6C757D';
		document.getElementById('thu').style.color = 'white';
		document.getElementById('thu').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = false;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('thu').removeAttribute("style");
		document.getElementById('from-thu').value = "";
		document.getElementById('to-thu').value = "";
	}
}

// 星期五
var friday = 0;

function fri() {
	if (friday++ % 2 == 0) {
		document.getElementById('fri').style.background = '#6C757D';
		document.getElementById('fri').style.color = 'white';
		document.getElementById('fri').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = false;
		document.getElementById('saturday_frame').hidden = true;
	} else {
		document.getElementById('fri').removeAttribute("style");
		document.getElementById('from-fri').value = "";
		document.getElementById('to-fri').value = "";
	}
}

// 星期六
var saturday = 0;

function sat() {
	if (saturday++ % 2 == 0) {
		document.getElementById('sat').style.background = '#6C757D';
		document.getElementById('sat').style.color = 'white';
		document.getElementById('sat').style.border = '1px solid #464C51';
		document.getElementById('sunday_frame').hidden = true;
		document.getElementById('monday_frame').hidden = true;
		document.getElementById('tuesday_frame').hidden = true;
		document.getElementById('wednesday_frame').hidden = true;
		document.getElementById('thursday_frame').hidden = true;
		document.getElementById('friday_frame').hidden = true;
		document.getElementById('saturday_frame').hidden = false;
	} else {
		document.getElementById('sat').removeAttribute("style");
		document.getElementById('from-sat').value = "";
		document.getElementById('to-sat').value = "";
	}
}

// 信息与自动化学院
function computer() {
	$("#curriculum_all").addClass("hidden_all");
	var computer_path = document.getElementById('computer_path');
	var computer_all = document.getElementById('computer_all')
	computer_path.hidden = false;
	computer_all.hidden = false;
	$("#curriculum_all").removeClass("visible_all");
}
// 返回分类
function catalog2() {
	$("#curriculum_all").addClass("visible_all");
	var computer_path = document.getElementById('computer_path');
	var computer_all = document.getElementById('computer_all')
	computer_path.hidden = true;
	computer_all.hidden = true;
	$("#curriculum_all").removeClass("hidden_all");
}

// 计算机网络技术
function network() {
	$("#computer_all").addClass("hidden_all2");
	$("#network_all").addClass("visible_all2");
	var computer_path = document.getElementById('computer_path');
	var network_path = document.getElementById('network_path');
	var network_all = document.getElementById('network_all');
	computer_path.hidden = true;
	network_path.hidden = false;
	network_all.hidden = false;
	$("#computer_all").removeClass("visible_all2");
	$("#network_all").addClass("hidden_all2");
}

// 网络返回二级目录（信息与自动化学院）
function path2() {
	$("#computer_all").addClass("visible_all2");
	$("#network_all").addClass("hidden_all2");
	var computer_path = document.getElementById('computer_path');
	var network_path = document.getElementById('network_path');
	var network_all = document.getElementById('network_all');
	computer_path.hidden = false;
	network_path.hidden = true;
	network_all.hidden = true;
	$("#computer_all").removeClass("hidden_all2");
	$("#network_all").addClass("visible_all2");
}

// 软件技术
function softerware() {
	$("#computer_all").addClass("hidden_all2");
	$("#softerware_all").addClass("visible_all2");
	var computer_path = document.getElementById('computer_path');
	var softerware_path = document.getElementById('softerware_path');
	var softerware_all = document.getElementById('softerware_all');
	computer_path.hidden = true;
	softerware_path.hidden = false;
	softerware_all.hidden = false;
	$("#computer_all").removeClass("visible_all2");
	$("#softerware_all").addClass("hidden_all2");
}

// 软件返回二级目录（信息与自动化学院）
function path3() {
	$("#computer_all").addClass("visible_all2");
	$("#softerware_all").addClass("hidden_all2");
	var computer_path = document.getElementById('computer_path');
	var softerware_path = document.getElementById('softerware_path');
	var softerware_all = document.getElementById('softerware_all');
	computer_path.hidden = false;
	softerware_path.hidden = true;
	softerware_all.hidden = true;
	$("#computer_all").removeClass("hidden_all2");
	$("#softerware_all").addClass("visible_all2");
}

var ip="120.79.218.123";
function showScheduleList(){  // 页面刷新触发
	var xmlhttp = null;
	var parentDiv=document.getElementById("course_all");  // !!!!!!!!!!!!循环的父容器
	var divs=parentDiv.getElementsByTagName("div");
	for(var del=1;del<divs.length;del++){
		if(divs[del].getAttribute("name")=="deleteCard"){
			parentDiv.removeChild(divs[del]);
			divs=parentDiv.getElementsByTagName("div");
			del=0;
		}
	}
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange =function (){
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				var msg=xmlhttp.responseText;				
				if(msg=="null"){
					// 没有数据，清空父容器
					var p = document.createElement('p');
					p.innerHTML = "没有查询到数据！";
					parentDiv.appendChild(p);
					return;
				}
				var array = JSON.parse(msg);
				for (var i = 0; i < array.length; i++) {	// 循环卡片
					var obj = array[i];
					var list_sc_time=(obj.sc_time).split("$$");
					var show_sc_time="";
					for(var j=0;j<list_sc_time.length;j++){
						var scsc_day=(list_sc_time[j].split("~"))[0];
						var scsc_day2=scsc_day;
						var scsc_start=(((list_sc_time[j].split("~"))[1]).split("-"))[0];
						var scsc_end=(((list_sc_time[j].split("~"))[1]).split("-"))[1];
						switch(scsc_day) {
					     case "1":
					    	 scsc_day="周一";
					        break;
					     case "2":
					    	 scsc_day="周二";
					        break;
					     case "3":
					    	 scsc_day="周三";
					        break;
					     case "4":
					    	 scsc_day="周四";
					        break;
					     case "5":
					    	 scsc_day="周五";
					        break;
					     case "6":
					    	 scsc_day="周六";
					        break;
					     case "7":
					    	 scsc_day="周日";
					        break;
						} 
						show_sc_time=show_sc_time+"<p>"+scsc_day+"：<span id='startdaydata"+obj.sc_id+"-"+scsc_day2+"'>"+scsc_start+
							"</span> - <span id='enddaydata"+obj.sc_id+"-"+scsc_day2+"'>"+scsc_end+"</span></p>";
					}
					var div = document.createElement('div');
					div.id="ScheduleCard"+obj.sc_id;
					div.setAttribute("name","deleteCard");
					div.innerHTML = 
						"<div class='course-card' id='wentdelete"+obj.sc_id+"' >"+
						"<button hidden class='curriculum_delet' onclick='booleanDeleteSchedule("+obj.sc_id+")' >x</button>"+
						"<div class='card-left'>"+
						"<p id='sc_name"+obj.sc_id+"' class='course-name'>"+obj.sc_name+"</p>"+
						"<p id='sc_user_id"+obj.sc_id+"' class='course-tutor'>"+obj.sc_user_id+"</p>"+
						"</div><div class='card-right'> <p class='tittle-start'>开始</p>"+
						"<div class='divider1'></div>"+
						"<p id='sc_start"+obj.sc_id+"' class='content-start'>"+obj.sc_start+"</p>"+
						"<p class='tittle-end'>结束</p><div class='divider2'></div>"+
						"<p id='sc_end"+obj.sc_id+"' class='content-end'>"+obj.sc_end+"</p>"+
						"<p class='tittle-classroom'>地点</p><div class='divider6'></div>"+
						"<p id='sc_build"+obj.sc_id+"' class='content-classroom1'>"+(obj.sc_cl_id.split('-'))[0]+"</p>"+
						"<p id='sc_classroom"+obj.sc_id+"' class='content-classroom2'>"+(obj.sc_cl_id.split('-'))[1]+"</p>"+
						"<div class='more' data-toggle='modal' data-target='#course_more"+obj.sc_id+"'><p class='more-font'>更&nbsp;多</p></div>"+
						"<div class='modal fade' id='course_more"+obj.sc_id+"' data-backdrop='static'>"+
						"<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>"+
						"<h5>课程详细信息</h5><button class='close' data-dismiss='modal'>×</button>"+
						"</div><div class='modal-body'>"+
						"<p>课程名：<span id='more_sc_name"+obj.sc_id+"'>"+obj.sc_name+"</span></p>"+
						"<p>开始：<span id='more_sc_start"+obj.sc_id+"'>"+obj.sc_start+"</span></p>"+
						"<p>结束：<span id='more_sc_end"+obj.sc_id+"'>"+obj.sc_end+"</span></p>"+
						"<hr>"+
						show_sc_time+
						"<hr>"+
						"<p>地点：<span id='more_sc_build"+obj.sc_id+"'>"+(obj.sc_cl_id.split("-"))[0]+"</span>&nbsp;"+
						"<span id='more_sc_classroom"+obj.sc_id+"'>"+(obj.sc_cl_id.split("-"))[1]+"</span></p>"+
						"<p>老师：<span id='more_sc_user_id'>"+obj.sc_user_id+"</span></p>"+
						"</div></div></div></div></div></div>";
					parentDiv.appendChild(div);
				}
			}else {
				alert("Problem retrieving XML data");
			}
		}
	};
	xmlhttp.open("POST", "http://"+ip+":8848/BootCMS/getScheduleAll.action", true);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send();
}

function addSchedule(){     //添加新课程
	var sc_name=document.getElementById("sc_name");
	var sc_start=document.getElementById("sc_start");
	var sc_end=document.getElementById("sc_end");
	var sc_build=document.getElementById("sc_build");
	var sc_classroom=document.getElementById("sc_classroom");
	var sc_user_id=document.getElementById("sc_user_id");
	var yes="rgb(108, 117, 125)";
	var sun=document.getElementById("sun").style.backgroundColor;
	var mon=document.getElementById("mon").style.backgroundColor;
	var tue=document.getElementById("tue").style.backgroundColor;
	var wed=document.getElementById("wed").style.backgroundColor;
	var thu=document.getElementById("thu").style.backgroundColor;
	var fri=document.getElementById("fri").style.backgroundColor;
	var sat=document.getElementById("sat").style.backgroundColor;
	var sc_week="";
	var sc_time="";
	if(sun==yes){
		var from=document.getElementById("from-sun");
		var to=document.getElementById("to-sun");
		sc_time=sc_time+"7~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"7,";
	}
	if(mon==yes){
		var from=document.getElementById("from-mon");
		var to=document.getElementById("to-mon");
		sc_time=sc_time+"1~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"1,";
	}
	if(tue==yes){
		var from=document.getElementById("from-tue");
		var to=document.getElementById("to-tue");
		sc_time=sc_time+"2~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"2,";
	}
	if(wed==yes){
		var from=document.getElementById("from-wed");
		var to=document.getElementById("to-wed");
		sc_time=sc_time+"3~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"3,";
	}
	if(thu==yes){
		var from=document.getElementById("from-thu");
		var to=document.getElementById("to-thu");
		sc_time=sc_time+"4~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"4,";
	}
	if(fri==yes){
		var from=document.getElementById("from-fri");
		var to=document.getElementById("to-fri");
		sc_time=sc_time+"5~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"5,";
	}
	if(sat==yes){
		var from=document.getElementById("from-sat");
		var to=document.getElementById("to-sat");
		sc_time=sc_time+"6~"+from.value+":00-"+to.value+":00$$";
		sc_week=sc_week+"6,";
	}
	sc_time = sc_time.substring(0, sc_time.length - 2);
	sc_week = sc_week.substring(0, sc_week.length - 1);
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange =function (){
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				var msg=xmlhttp.responseText;
				alert(msg);
				if(msg=="添加成功"){
					course();
				}
			}else{
				alert("Problem retrieving XML data");
			}
		}
	};
	xmlhttp.open("POST", "http://"+ip+":8848/BootCMS/addSchedule.action", true);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send("sc_name="+sc_name.value+"&sc_start="+sc_start.value+"&sc_end="+sc_end.value+"&sc_cl_id="+sc_build.value+"-"+
			sc_classroom.value+"&sc_user_id="+sc_user_id.value+"&sc_week="+sc_week+"&sc_time="+sc_time);
}


function booleanDeleteSchedule(sc_id){   // 确认是否删除课程
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange =function (){
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				var msg=xmlhttp.responseText;
				if(confirm("当前有"+msg+"人报了这门课程，确定要删除该课程吗？")){
					DeleteSchedule(sc_id);
				}
			}else{
				alert("Problem retrieving XML data");
			}
		}
	};
	xmlhttp.open("POST", "/BootCMS/booleanDeleteSchedule.action", true);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send("sc_id="+sc_id);
}

function DeleteSchedule(sc_id){   // 删除课程
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange =function (){
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				var msg=xmlhttp.responseText;
				if(msg=="true"){
					alert("删除成功！");
					var course_all=document.getElementById('course_all');
					var wentdelete=document.getElementById('ScheduleCard'+sc_id);
					course_all.removeChild(wentdelete);
				}else{
					alert("删除失败！");
				}
			}else{
				return "Problem retrieving XML data";
			}
		}
	};
	xmlhttp.open("POST", "/BootCMS/deleteSchedule.action", true);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send("sc_id="+sc_id);
}

function logout(){
	window.location.href="http://"+ip+":8848/BootCMS/Logout.action";
}
