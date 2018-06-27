//统计分析的电站排行的公司联动文件、可以根据一级公司就查询出电站，不用必须查询到三级公司
//companyPwsNew元素是为了跟基本的companyPws区分，因为查询一级公司就要刷新这个数据
//20180327 修改有缓存时 电站下拉框数据不对，因为反复的执行setPwsNew方法，但是因为异步请求，执行的不确定是第几次执行的所以数据不对，修改成如果下一级有缓存当前公司就不查询setPwsNew方法
var userComData = null ; 
$(function(){
	if($("#companyPwsNew")){
		$("#companyPwsNew").change(function(){
			if($(this).val() == "qxz"){
				clearPwsSession();
			}else{
				sessionStorage.setItem("pwsIdPh",$(this).val());
			}
		})
	}
})
function getCompanyOne(){
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
    	}
    })
    
}


function setCompanyOne(){
	 var html = '<option value="qxz">请选择一级公司</option>';
	 for (var i = 0; i < userComData.length; i++) {
		 var comOne  = userComData[i];
		 var selectHtm = "";
		 if(sessionStorage.getItem("comOnePh") && sessionStorage.getItem("comOnePh") == comOne.id){
			   selectHtm = "selected";
			   if($("#companyPwsNew") && $("#companyPwsNew").html() != undefined){
				   if( sessionStorage.getItem("comTwoPh") == ''  ||  sessionStorage.getItem("comTwoPh")  == undefined ){ 
					  //加此判断是为了判断如果后边还有缓存的公司就不需要根据现在这个公司查询电站
					   setPwsNew(sessionStorage.getItem("comOnePh"),1);
				   }
				   
			   }
			   setCompanytwo(sessionStorage.getItem("comOnePh"));
			   
		 }
		 html += '<option value="'+comOne.id+'" '+selectHtm+'>'+comOne.com_nam+'</option>'
	}
	$("#companyOne").empty().append(html);
}


function setCompanytwo(val){
	if(val == 'qxz'){
		clearCompanyTwo();
		clearCompanyThree();
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comOnePh",val);
		var html = '<option value="qxz">请选择二级公司</option>';
		for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 if(comOne.id == val){
				 for (var j = 0; j < comOne.twoComLst.length; j++) {
					 var comTwo  = comOne.twoComLst[j];
					 var selectHtm = "";
					 if(sessionStorage.getItem("comTwoPh") && sessionStorage.getItem("comTwoPh") == comTwo.id){
						 if($("#companyPwsNew") && $("#companyPwsNew").html() != undefined){
							   if(sessionStorage.getItem("comThreePh") == '' || sessionStorage.getItem("comThreePh")  == undefined ){ 
								 	//加后边的判断是为了判断如果后边还有缓存的公司就不需要根据现在这个公司查询电站{
								   setPwsNew(sessionStorage.getItem("comTwoPh"),2);
							   }
						   }
						   selectHtm = "selected";
						   setCompanyThree(sessionStorage.getItem("comTwoPh"));
					 }
					 html += '<option value="'+comTwo.id+'" '+selectHtm+'>'+comTwo.com_nam+'</option>'
				 }
			 }
		}
		$("#companyTwo").empty().append(html);
	}
	 
}

function setCompanyThree(val){
	if(val == 'qxz'){
		clearCompanyThree();
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comTwoPh",val);
		var html = '<option value="qxz">请选择三级公司</option>';
		 for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 for (var j = 0; j < comOne.twoComLst.length; j++) {
				 var comTwo  = comOne.twoComLst[j];
				 if(comTwo.id == val){
					 for (var k = 0; k < comTwo.thrComLst.length; k++) {
						 var comThree  = comTwo.thrComLst[k];
						 var selectHtm = "";
						 if(sessionStorage.getItem("comThreePh") && sessionStorage.getItem("comThreePh") == comThree.id){
							 if($("#companyPwsNew") && $("#companyPwsNew").html() != undefined){
								   setPwsNew(sessionStorage.getItem("comThreePh"),3);
							   }
							   selectHtm = "selected";
							   setPws(sessionStorage.getItem("comThreePh"));
						 }
						 html += '<option value="'+comThree.id+'" '+selectHtm+'>'+comThree.com_nam+'</option>'
					 }
				 }
			 }
			 
		}
		$("#companyThree").empty().append(html);
	}
}


function setPws(val){
	if(val == 'qxz'){
		clearPws();
		clearPwsSession();
	}else{
		sessionStorage.setItem("comThreePh",val);
		var html = '<option value="qxz">请选择电站</option>';
		var use_id = $("#userId").val();
		var param = 'com_id='+val+"&use_id="+use_id;
		$.ajax({
	    	url:url+"getPwsIdByComId.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			for (var l = 0; l < data.data.length; l++) {
						 var pws = data.data[l];
						 var selectHtm = "";
						 if(sessionStorage.getItem("pwsIdPh") && sessionStorage.getItem("pwsIdPh") == pws.id){
							   selectHtm = "selected";
							   /*setPws(sessionStorage.getItem("pwsId"));*/
						 }
						 html += '<option value="'+pws.id+'" '+selectHtm+'>'+pws.pws_nam+'</option>'
					 }
	    			$("#companyPws").empty().append(html);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	}
}

function clearCompanyTwo(){
	sessionStorage.removeItem("comOnePh");
	$("#companyTwo").empty().append('<option value="qxz">请选择二级公司</option>');
}

function clearCompanyThree(){
	sessionStorage.removeItem("comTwoPh");
	$("#companyThree").empty().append('<option value="qxz">请选择三级公司</option>');
}
function clearPws(){
	sessionStorage.removeItem("comThreePh");
	$("#companyPws").empty().append('<option value="qxz">请选择电站</option>');
}
function clearPwsSession(){
	sessionStorage.removeItem("pwsIdPh");
}