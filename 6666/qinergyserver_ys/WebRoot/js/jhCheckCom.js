//计划管理发电量计划的公司联动的文件、查看是否有缓存，如没有 就查询第一个
var userComData = null ; 
$(function(){
	if($("#companyPws")){
		$("#companyPws").change(function(){
			if($(this).val() == "qxz"){
				clearPwsSession();
			}else{
				sessionStorage.setItem("pwsId",$(this).val());
			}
		})
	}
})
 
function getCompanyOne(fun){
	/*var userId = $("#userId").val(); 
	var param  = "id="+userId;*/
	var userId = $("#userId").val(); 
	var use_typ = $("#use_typ").val(); 
	var slt_opt_sta = $("#slt_opt_sta").val(); 
	$.ajax({
    	/*url:url+"getOrgHieFromEcache.htm",
    	data : param,*/
		url:url+"getOrganizationHierarchyByUse.htm",
		data : "use_id="+userId+"&use_typ="+use_typ+"&slt_opt_sta="+slt_opt_sta,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data != null){
    				 userComData = data.data ;
    				 setCompanyOne();
    			 }else{
    				 getUseData();
    			 }
			} else {
               layer.alert(data.desc);
			}
    		if(fun){
    			fun();
    		}
    	}
    })
}

function getUseData(){
	var userId = $("#userId").val(); 
	var use_typ = $("#use_typ").val(); 
	var slt_opt_sta = $("#slt_opt_sta").val(); 
	$.ajax({
		url:url+"getOrganizationHierarchyByUse.htm",
		data : "use_id="+userId+"&use_typ="+use_typ+"&slt_opt_sta="+slt_opt_sta,
		success: function(datas){
			if (datas.data.length > 0 ) {
				userComData = datas.data ;
				setCompanyOne();
			}
		},
		error : function(){
			
		}
	}); 
}

function setCompanyOne(){
	 var html = '<option value="qxz">请选择一级公司</option>';
	 var firstVal = '' ;
	 for (var i = 0; i < userComData.length; i++) {
		 var comOne  = userComData[i];
		 var selectHtm = "";
		 if(sessionStorage.getItem("comOne") && sessionStorage.getItem("comOne") != null && sessionStorage.getItem("comOne") != undefined && sessionStorage.getItem("comOne") != ''){
			 if(sessionStorage.getItem("comOne") == comOne.id){
				 selectHtm = "selected";
			 }
		 }else{
			 if(i == 0){
				 firstVal  = comOne.id ;//第一条数据
				 selectHtm = "selected";
			 }  
		 }
		 
		 html += '<option value="'+comOne.id+'" '+selectHtm+'>'+comOne.com_nam+'</option>'
	}
	$("#companyOne").empty().append(html);
	
	if(sessionStorage.getItem("comOne") && sessionStorage.getItem("comOne") != undefined){
		 setCompanytwo(sessionStorage.getItem("comOne"));
	}else{
		if(firstVal != '' ){
			setCompanytwo(firstVal);
		}
	}
}


function setCompanytwo(val){
	if(val == 'qxz'){
		clearCompanyTwo();
		clearCompanyThree();
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comOne",val);
		var html = '<option value="qxz">请选择二级公司</option>';
		var firstVal = '' ;
		for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 if(comOne.id == val){
				 for (var j = 0; j < comOne.twoComLst.length; j++) {
					 var comTwo  = comOne.twoComLst[j];
					 var selectHtm = "";
					 if(sessionStorage.getItem("comTwo") && sessionStorage.getItem("comTwo") != null && sessionStorage.getItem("comTwo") != undefined && sessionStorage.getItem("comTwo") != ''){
						 if(sessionStorage.getItem("comTwo") == comTwo.id){
							 selectHtm = "selected";
						 }
					 }else{
						 if(j == 0){
							 firstVal  = comTwo.id ;//第一条数据
							 selectHtm = "selected";
						 }  
					 }
					 html += '<option value="'+comTwo.id+'" '+selectHtm+'>'+comTwo.com_nam+'</option>'
				 }
			 }
		}
		$("#companyTwo").empty().append(html);
		
		if(sessionStorage.getItem("comTwo") && sessionStorage.getItem("comTwo") != undefined){
			setCompanyThree(sessionStorage.getItem("comTwo"));
		}else{
			if(firstVal != '' ){
				setCompanyThree(firstVal);
			}
		}
	}
	 
}

function setCompanyThree(val){
	if(val == 'qxz'){
		clearCompanyThree();
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comTwo",val);
		var html = '<option value="qxz">请选择三级公司</option>';
		var firstVal = '' ;
		 for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 for (var j = 0; j < comOne.twoComLst.length; j++) {
				 var comTwo  = comOne.twoComLst[j];
				 if(comTwo.id == val){
					 for (var k = 0; k < comTwo.thrComLst.length; k++) {
						 var comThree  = comTwo.thrComLst[k];
						 var selectHtm = "";
						 if(sessionStorage.getItem("comThree") && sessionStorage.getItem("comThree") != null && sessionStorage.getItem("comThree") != undefined && sessionStorage.getItem("comThree") != ''){
							 if(sessionStorage.getItem("comThree") == comThree.id){
								 selectHtm = "selected";
							 }
						 }else{
							 if(k == 0){
								 firstVal  = comThree.id ;//第一条数据
								 selectHtm = "selected";
							 }  
						 }
						 html += '<option value="'+comThree.id+'" '+selectHtm+'>'+comThree.com_nam+'</option>'
					 }
				 }
			 }
			 
		}
		$("#companyThree").empty().append(html);
		if(sessionStorage.getItem("comThree") && sessionStorage.getItem("comThree") != undefined){
			setPws(sessionStorage.getItem("comThree"));
		}else{
			if(firstVal != '' ){
				setPws(firstVal);
			}
		}
	}
}


function setPws(val){
	if(val == 'qxz'){
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comThree",val);
		var html = '<option value="qxz">请选择电站</option>';
		var firstVal = '' ;
		 for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 for (var j = 0; j < comOne.twoComLst.length; j++) {
				 var comTwo  = comOne.twoComLst[j];
				 for (var k = 0; k < comTwo.thrComLst.length; k++) {
					 var comThree  = comTwo.thrComLst[k];
					 if(comThree.id == val){
						 for (var l = 0; l < comThree.pwsInfLst.length; l++) {
							 var pws = comThree.pwsInfLst[l];
							 var selectHtm = "";
							 if(sessionStorage.getItem("pwsId") && sessionStorage.getItem("pwsId") != null && sessionStorage.getItem("pwsId") != undefined && sessionStorage.getItem("pwsId") != ''){
								 if(sessionStorage.getItem("pwsId") == pws.id){
									 selectHtm = "selected";
								 }
							 }else{
								 if(l == 0){
									 firstVal  = pws.id ;//第一条数据
									 selectHtm = "selected";
								 }  
							 }
							 html += '<option value="'+pws.id+'" '+selectHtm+'>'+pws.pws_nam+'</option>'
						 }
						
					 }
				 }
			 }
		}
		$("#companyPws").empty().append(html);
		getData();//每个页面都加入这个方法
	}
}

function clearCompanyTwo(){
	sessionStorage.removeItem("comOne");
	$("#companyTwo").empty().append('<option value="qxz">请选择二级公司</option>');
}

function clearCompanyThree(){
	sessionStorage.removeItem("comTwo");
	$("#companyThree").empty().append('<option value="qxz">请选择三级公司</option>');
}
function clearPws(){
	sessionStorage.removeItem("comThree");
	$("#companyPws").empty().append('<option value="qxz">请选择电站</option>');
}
function clearPwsSession(){
	sessionStorage.removeItem("pwsId");
}