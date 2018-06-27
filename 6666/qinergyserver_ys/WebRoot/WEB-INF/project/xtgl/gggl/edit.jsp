<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>公告管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" id="id" value="${id}" >
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>公告内容</th>
			<td colspan="3">
				<textarea cols="3" rows="3" placeholder="请输入公告内容" id="ann_cont" onfocus="" class="poptextarea"></textarea>
			</td>
		</tr>
		<tr>
			<th>公告状态</th>
			<td>
				<select  class="popinput quinputcol requiredInp" id="ann_typ"  placeholder="请选择区域标识">
	          	  	<option value="1">播出</option>
	          	  	<option value="2">不播出</option>
          	 	 </select>
			</td>
			<th>公告排序号</th>
			<td><input type="text" id="ann_sort"  placeholder="请输入公告排序号" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript">
 
$(function(){
	var id = $("#id").val();
	getById(id);
})

function getById(id){
	 $.ajax({
		  url:url+"getAnnInfById.htm",
		  data: "ann_id="+id  ,
		  dataType:"json",
		  async: false,
		  type:"post",
		  success:function(data){
			  if(data.resultcode=="USR000"){
				  var d = data.data[0];
				  $("#ann_cont").val(d.ann_cont)
				  $("#ann_sort").val(d.ann_sort)
				  $("#ann_typ").val(d.ann_typ)
				  $("#remark").val(d.remark)
			  }else{
				  layer.alert(data.desc);
			  }
		  }
	 });

}
function update(){
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	} 
	  		if(reFlag){
	  			return false;
	  		}
	 }); 
	 if(reFlag){
		   return false;
	 }
  	var id = $("#id").val();
  	var ann_cont = $("#ann_cont").val();
	var ann_sort = $("#ann_sort").val();
	var ann_typ = $("#ann_typ").val();
	var remark = $("#remark").val();
	
	layer.confirm("确定修改？",function(){

	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	 $.ajax({
		  url:url+"updAnnInf.htm",
		  data: "ann_id="+id+"&ann_cont="+ann_cont 
	  		+"&&ann_sort="+ann_sort
	  		+"&&ann_typ="+ann_typ
	  		+"&&remark="+remark  ,
		  dataType:"json",
		  type:"post",
		  success:function(data){
			  layer.close(indexlayer); //关闭 loading 
			  if(data.resultcode=="USR000"){
				  top.frames['bottom'].getGg();
				  window.parent.currentPage = 1;
				  window.parent.getData();
				  $(".cancle").click();
				  window.parent.layer.alert("保存成功");
			  }else{
				  layer.alert(data.desc);
			  }
		  }
	 })
	})
}

</script>
</body>
</html>
