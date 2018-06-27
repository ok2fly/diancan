package com.qinergy.controller.commens;


public class Page {
	
	private int showCount; //每页显示记录数
	private int totalPage;		//总页数
	private int totalResult;	//总记录数
	private int currentPage;	//当前页
	private int currentResult;	//当前记录起始索引
	private boolean entityOrField;	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	private String pageStrAjax ; //显示在底部翻页导航,一个页面多个分页的方式 , 表样管理的分页;
	private String pageStrAjaxOne; //显示在底部翻页导航，ajax方式分页，组织架构管理;
	public static int NEWPAGE = 20;//初始化页面每页记录数量

	
	public Page(){
		try {
			this.showCount = NEWPAGE;
		} catch (Exception e) {
			this.showCount = NEWPAGE;
		}
	}
	
	public Page(int showCount,int currentPage,int totalResult) {
		
		this.showCount = showCount;
		this.currentPage = currentPage;
		this.totalResult = totalResult;
		
		if(totalResult%showCount==0)
			this.totalPage = totalResult/showCount;
		else
			this.totalPage = totalResult/showCount+1;
	}

	public int getTotalPage() {
		if(totalResult%showCount==0)
			totalPage = totalResult/showCount;
		else
			totalPage = totalResult/showCount+1;
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	
	public int getCurrentPage() {
		if(currentPage<=0)
			currentPage = 1;
		if(currentPage>getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		if(totalResult>0){
			sb.append("	<ul>\n");
			
			//总记录数
			sb.append("	<li><a>总记录数：<font color=red>"+totalResult+"</font></a></li>\n");
			
			//当前页和总页数
			sb.append("	<li style=\"margin-left:20px;\"><a>当前页：<font color=red>"+currentPage+"</font></a>/<a>"+totalPage+"</a></li>\n");
			
			//显示条数
			sb.append("	<li><select title='显示条数' style=\"width:55px;float:left;margin-left:20px;\" onchange=\"changeCount(this.value)\">\n");
			sb.append("	<option value='"+showCount+"'>"+showCount+"</option>\n");
			sb.append("	<option value='20'>20</option>\n");
			sb.append("	<option value='50'>50</option>\n");
			sb.append("	<option value='100'>100</option>\n");
			sb.append("	</select>\n");
			
			
			if(currentPage==1){
				sb.append("	<li style=\"margin-left:20px;\"><a>首页</a></li>\n");
				sb.append("	<li><a>上页</a></li>\n");
			}else{
				sb.append("	<li style=\"cursor:pointer;margin-left:20px;\"><a onclick=\"nextPage(1)\">首页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+(currentPage-1)+")\">上页</a></li>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(currentPage>showTag){
				startTag = currentPage-1;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append("<li><a><font color='#808080'>"+i+"</font></a></li>\n");
				else
					sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+i+")\">"+i+"</a></li>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<li><a>下页</a></li>\n");
				sb.append("	<li><a>尾页</a></li>\n");
			}else{
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+(currentPage+1)+")\">下页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+totalPage+")\">尾页</a></li>\n");
			}
			
			//跳转页面
			sb.append("	<li><input type=\"number\" min=\"1\" value=\"\" id=\"toGoPage\" style=\"width:50px;text-align:center;float:left;margin-left:20px;\" placeholder=\"页码\"/></li>\n");
			sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"toTZ();\"  style=\"margin-top:2px;line-height:14px;display:block;background-color:#F0F0F0;border:1px solid #999999\" class=\"btn btn-mini btn-success\">GO</a></li>\n");
			
			
			
			sb.append("	</li>\n");
			
			
			
			sb.append("</ul>\n");
			sb.append("<script type=\"text/javascript\">\n");
			
			//换页函数
			sb.append("function nextPage(page){");
			sb.append("	if(true && document.forms[0]){\n");
			sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+showCount+"\";\n");
			sb.append("		document.forms[0].action = url;\n");
			sb.append("		document.forms[0].submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+showCount+"\";\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");
			
			//调整每页显示条数
			sb.append("function changeCount(value){");
			sb.append("	if(true && document.forms[0]){\n");
			sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + \"1&" +(entityOrField?"showCount":"page.showCount")+"=\"+value;\n");
			sb.append("		document.forms[0].action = url;\n");
			sb.append("		document.forms[0].submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"1&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + \"&" +(entityOrField?"showCount":"page.showCount")+"=\"+value;\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");
			
			//跳转函数 
			sb.append("function toTZ(){");
			sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;");
			sb.append("if(toPaggeVlue > "+ totalPage +"){document.getElementById(\"toGoPage\").value=1;toPaggeVlue=" + totalPage + ";}");
			sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;toPaggeVlue=1;}");
			sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;toPaggeVlue=1;}");
			sb.append("nextPage(toPaggeVlue);");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}
	
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		
		this.showCount = showCount;
	}
	
	public int getCurrentResult() {
		currentResult = (getCurrentPage()-1)*getShowCount();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	public boolean isEntityOrField() {
		return entityOrField;
	}
	
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}
	 
	

	public void setPageStrAjax(String pageStrAjax) {
		this.pageStrAjax = pageStrAjax;
	}
	

	public String getPageStrAjaxOne() {
		
		return pageStrAjaxOne;
	}

	public void setPageStrAjaxOne(String pageStrAjaxOne) {
		this.pageStrAjaxOne = pageStrAjaxOne;
	}
	public String  getPageStrAjax(String pathUrl){
		String inde = "1";
		if(pathUrl.length()>31){
			inde = pathUrl.substring(31, 32);
		}
		StringBuffer sb = new StringBuffer();
		if(totalResult>0){
			sb.append("	<ul>\n");
			
			//总记录数
			sb.append("	<li><a>总记录数：<font color=red>"+totalResult+"</font></a></li>\n");
			
			//当前页和总页数
			sb.append("	<li style=\"margin-left:20px;\"><a>当前页：<font color=red>"+currentPage+"</font></a>/<a>"+totalPage+"</a></li>\n");
			
			//显示条数
			sb.append("	<li><select title='显示条数' style=\"width:55px;float:left;margin-left:20px;\" onchange=\"changeCount"+inde+"(this.value)\">\n");
			sb.append("	<option value='"+showCount+"'>"+showCount+"</option>\n");
		//	sb.append("	<option value='10'>10</option>\n");
			sb.append("	<option value='20'>20</option>\n");
		//	sb.append("	<option value='30'>30</option>\n");
		//	sb.append("	<option value='40'>40</option>\n");
			sb.append("	<option value='50'>50</option>\n");
		//	sb.append("	<option value='60'>60</option>\n");
		//	sb.append("	<option value='70'>70</option>\n");
		//	sb.append("	<option value='80'>80</option>\n");
		//	sb.append("	<option value='90'>90</option>\n");
			sb.append("	<option value='100'>100</option>\n");
			sb.append("	</select>\n");
			
			
			if(currentPage==1){
				sb.append("	<li style=\"margin-left:20px;\"><a>首页</a></li>\n");
				sb.append("	<li><a>上页</a></li>\n");
			}else{
				sb.append("	<li style=\"cursor:pointer;margin-left:20px;\"><a onclick=\"nextPage"+inde+"(1)\">首页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage"+inde+"("+(currentPage-1)+")\">上页</a></li>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(currentPage>showTag){
				startTag = currentPage-1;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append("<li><a><font color='#808080'>"+i+"</font></a></li>\n");
				else
					sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage"+inde+"("+i+")\">"+i+"</a></li>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<li><a>下页</a></li>\n");
				sb.append("	<li><a>尾页</a></li>\n");
			}else{
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage"+inde+"("+(currentPage+1)+")\">下页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage"+inde+"("+totalPage+")\">尾页</a></li>\n");
			}
			
			//sb.append("	<li><a>共"+totalPage+"页</a></li>\n");
			//跳转页面
			sb.append("	<li><input type=\"number\" value=\"\" id=\"toGoPage"+inde+"\" style=\"width:50px;text-align:center;float:left;margin-left:20px;\" placeholder=\"页码\"/></li>\n");
			sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"toTZ"+inde+"();\"  style=\"margin-top:2px;line-height:14px;display:block;background-color:#F0F0F0;border:1px solid #999999\" class=\"btn btn-mini btn-success\">GO</a></li>\n");
			
			
			
			sb.append("	</li>\n");
			
			
			
			sb.append("</ul>\n");
			//sb.append("scriptStart\n");
			sb.append("<script type=\"text/javascript\">\n");
			//换页函数
			sb.append("function nextPage"+inde+"(page){ ");
			sb.append("		var url = \""+pathUrl+"\";\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+showCount+"\";\n");
			sb.append("		var poolType = getQueryString(\"poolType\",url);\n");
			sb.append("		$.ajax({                                                                                                                                                                          \n");
			sb.append("			url:url,                                                                                                                                                                       \n");
			sb.append("			type:\"POST\",                                                                                                                                                                    \n");
			sb.append("			dataType:\"json\",                                                                                                                                                                \n");
			sb.append("			async:false,                                                                                                                                                                    \n");
			sb.append("			success:function(result){                                                                                                                                                       \n");
			sb.append("			 	var o = [];                                                                                                                                                                   \n");
			sb.append("			 	var j = [];                                                                                                                                                                   \n");
			sb.append("		        if(result.success==true){                                                                                                                                                 \n");
			sb.append("		        	var data = result.data;                                                                                                                                                 \n");
			sb.append("		        	o[o.length] = '<tr class=\"tHeader theader1\"  style=\"\"> ';                                                                                                               \n");
			sb.append("		    		o[o.length] = '<td align=\"center\" >字段名称</td>  ';                                                                                                                      \n");
			sb.append("					o[o.length] = '<td align=\"center\" >英文名</td> ';                                                                                                                           \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据类型</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据长度</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >是否可用</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据是否可修改</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >字段类型</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >操作</td> ';                                                                                                                             \n");
			sb.append("					o[o.length] = '</tr>';                                                                                                                                                      \n");
			sb.append("		        	if(result.data.length>0){                                                                                                                                               \n");
			sb.append("		        		for(var p=0 ; p<data.length;p++){                                                                                                                                     \n");
			sb.append("		        			var dataType , isVisible,isUpdate,isDel,fieldType,isEdit;                                                                                                                                     \n");
			sb.append("		        			if(\"1\" == data[p].fieldDataType){                                                                                                                                   \n");
			sb.append("		        				dataType = '数字型';                                                                                                                                                 \n");
			sb.append("		        			}else if(\"2\" == data[p].fieldDataType){                                                                                                                             \n");
			sb.append("		        				dataType = '字符型';                                                                                                                                             \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("		        			if(\"1\" == data[p].isUpdate){                                                                                                                                   \n");
			sb.append("		        				isUpdate = '可修改';                                                                                                                                                 \n");
			sb.append("		        			}else if(\"2\" == data[p].isUpdate){                                                                                                                             \n");
			sb.append("		        				isUpdate = '不可修改';                                                                                                                                          \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("		        			if(\"1\" == data[p].isVisible){                                                                                                                                       \n");
			sb.append("		        				isVisible = '可用';                                                                                                                                               \n");
			sb.append("		       					isDel ='<a onclick=\"delField('+data[p].poolId+','+poolType+','+data[p].fieldName+')\" href=\"javascript:void(0);\">删除</a>'; 				                                                                                  \n");
			//sb.append("		        				isEdit ='<a onclick=\"editField('+data[p].poolId+','+poolType+')\" href=\"javascript:void(0);\">修改</a>';                                                         \n");
			sb.append("		        			}else if(\"2\" == data[p].isVisible){                                                                                                                                 \n");
			sb.append("		        				isVisible = '不可用';                                                                                                                                             \n");
			sb.append("		        				isDel = '';                                                                                                                                                       \n");
			//sb.append("		        				isEdit = '';                                                                                                                                                       \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("							fieldType='无' 																																						\n");
			sb.append("							if(\"1\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '基础信息字段';																																						\n");
			sb.append("							}else if(\"2\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '养老类福利信息字段';																																						\n");
			sb.append("							}else if(\"3\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '医疗类福利信息字段';																																						\n");
			sb.append("							}else if(\"4\" == data[p].fieldType){																																					\n");
			sb.append("							fieldType = '一次性福利信息字段';																																					\n");
			sb.append("							}else if(\"5\" == data[p].fieldType){																																				\n");
			sb.append("							fieldType = '具备发放条件福利信息字段';																																				\n");
			sb.append("							}else if(\"6\" == data[p].fieldType){																																				\n");
			sb.append("							fieldType = '内退期间福利信息字段';																																				\n");
			sb.append("							}else if(\"12\" == data[p].fieldType){																																					\n");
			sb.append("								fieldType = '特殊事项字段';																																				\n");
			sb.append("								}else if(\"7\" == data[p].fieldType){																																					\n");
			sb.append("							fieldType = '财务信息字段';																																				\n");
			sb.append("							}else if(\"8\" == data[p].fieldType){																																			\n");	
			sb.append("							fieldType = '财务信息对比字段';																																			\n");
			sb.append("								}else if(\"9\" == data[p].fieldType){																																			\n");
			sb.append("							fieldType = '人员变动及福利对比字段';																																		\n");
			sb.append("								}else if(\"10\" == data[p].fieldType){																																		\n");	
			sb.append("							fieldType = '历史信息字段';																																		\n");
			sb.append("								}else if(\"11\" == data[p].fieldType){																																		\n");	
			sb.append("							fieldType = '其他信息字段';																																	\n");
			sb.append("							}																																\n");
			sb.append("		        			o[o.length] = '<tr class=\"Grid_Item\"  style=\"\">' ;                                                                                                                  \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:30%;\">'+data[p].fieldName+'</td> ' ;                                                                                 \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+data[p].fieldCode+'</td>' ;                                                                                  \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+dataType+'</td>' ;                                                                                           \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+data[p].dataLength+'</td>' ;                                                                                  \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+isVisible+'</td>' ;                                                                                          \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+isUpdate+'</td>' ;                                                                                          \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+fieldType+'</td>' ;                                                                                          \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+isDel+'</td>' ;                                                                                              \n");
			sb.append("				        	o[o.length] = '</tr> ' ;                                                                                                                                            \n");
			sb.append("				        	o[o.length] = ''                                                                                                                                                    \n");
			sb.append("		        		}                                                                                                                                                                     \n");
			sb.append("		        		j[j.length]='<div class=\"table_page\"  >'+result.pageSb+'</div>';                                                                                                      \n");
			sb.append("		        	}else{                                                                                                                                                                  \n");
			sb.append("		        		o[o.length] = '<td colspan=\"100\">没有相关数据</td>';                                                                                                                  \n");
			sb.append("		        	} 		                                                                                                                                                                  \n");
			sb.append("		        	$(\".tableList-\"+poolType).empty().html(o.join(\"\"));                                                                                                                                \n");
			sb.append("		        	$(\".tb-\"+poolType).empty().html(j.join(\"\"));                                                                                                                                       \n");
			sb.append("		        }else{                                                                                                                                                                    \n");
			sb.append("		        	alert(result.msg);                                                                                                                                                      \n");
			sb.append("		        }                                                                                                                                                                         \n");
			sb.append("			},                                                                                                                                                                              \n");
			sb.append("			error:function(){                                                                                                                                                                             \n");
			sb.append("			alert(\"错误\");                                                                                                                                                                             \n");
			sb.append("			}                                                                                                                                                                              \n");
			sb.append("		});                                                                                                                                                                                \n");
			sb.append("		}                                                                                                                                                                                \n");
			//调整每页显示条数
			sb.append("function changeCount"+inde+"(value){ ");
			sb.append("		var url = \""+pathUrl+"\";\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + \"&" +(entityOrField?"showCount":"page.showCount")+"=\"+value;\n");
			sb.append("		var poolType = getQueryString(\"poolType\",url);\n");
			sb.append("		$.ajax({                                                                                                                                                                          \n");
			sb.append("			url:url,                                                                                                                                                                       \n");
			sb.append("			type:\"POST\",                                                                                                                                                                    \n");
			sb.append("			dataType:\"json\",                                                                                                                                                                \n");
			sb.append("			async:false,                                                                                                                                                                    \n");
			sb.append("			success:function(result){                                                                                                                                                       \n");
			sb.append("			 	var o = [];                                                                                                                                                                   \n");
			sb.append("			 	var j = [];                                                                                                                                                                   \n");
			sb.append("		        if(result.success==true){                                                                                                                                                 \n");
			sb.append("		        	var data = result.data;                                                                                                                                                 \n");
			sb.append("		        	o[o.length] = '<tr class=\"tHeader theader1\"  style=\"\"> ';                                                                                                               \n");
			sb.append("		    		o[o.length] = '<td align=\"center\" >字段名称</td>  ';                                                                                                                      \n");
			sb.append("					o[o.length] = '<td align=\"center\" >英文名</td> ';                                                                                                                           \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据类型</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据长度</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >是否可用</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >数据是否可修改</td> ';                                                                                                                         \n");
			sb.append("					o[o.length] = '<td align=\"center\" >字段类型</td> ';   																													 \n");
			sb.append("					o[o.length] = '<td align=\"center\" >操作</td> ';                                                                                                                             \n");
			sb.append("					o[o.length] = '</tr>';                                                                                                                                                      \n");
			sb.append("		        	if(result.data.length>0){                                                                                                                                               \n");
			sb.append("		        		for(var p=0 ; p<data.length;p++){                                                                                                                                     \n");
			sb.append("		        			var dataType , isVisible,isDel,isUpdate,fieldType,isEdit;                                                                                                                                     \n");
			sb.append("		        			if(\"1\" == data[p].fieldDataType){                                                                                                                                   \n");
			sb.append("		        				dataType = '数字型';                                                                                                                                                 \n");
			sb.append("		        			}else if(\"2\" == data[p].fieldDataType){                                                                                                                             \n");
			sb.append("		        				dataType = '字符型';                                                                                                                                             \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("		        			if(\"1\" == data[p].isUpdate){                                                                                                                                   \n");
			sb.append("		        				isUpdate = '可修改';                                                                                                                                                 \n");
			sb.append("		        			}else if(\"2\" == data[p].isUpdate){                                                                                                                             \n");
			sb.append("		        				isUpdate = '不可修改';                                                                                                                                          \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("		        			if(\"1\" == data[p].isVisible){                                                                                                                                       \n");
			sb.append("		        				isVisible = '可用';                                                                                                                                               \n");
			sb.append("		        					isDel ='<a onclick=\"delField('+data[p].poolId+','+poolType+','+data[p].fieldName+')\" href=\"javascript:void(0);\">删除</a>';                                                         \n");
			//sb.append("		        				isEdit ='<a onclick=\"editField('+data[p].poolId+','+poolType+')\" href=\"javascript:void(0);\">修改</a>';                                                         \n");
			sb.append("		        			}else if(\"2\" == data[p].isVisible){                                                                                                                                 \n");
			sb.append("		        				isVisible = '不可用';                                                                                                                                             \n");
			sb.append("		        				isDel = '';                                                                                                                                                       \n");
			//sb.append("		        				isEdit = '';                                                                                                                                                       \n");
			sb.append("		        			}                                                                                                                                                                   \n");
			sb.append("							fieldType='无' 																																						\n");
			sb.append("							if(\"1\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '基础信息字段';																																						\n");
			sb.append("							}else if(\"2\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '养老类福利信息字段';																																						\n");
			sb.append("							}else if(\"3\" == data[p].fieldType){																																						\n");
			sb.append("							fieldType = '医疗类福利信息字段';																																						\n");
			sb.append("							}else if(\"4\" == data[p].fieldType){																																					\n");
			sb.append("							fieldType = '一次性福利信息字段';																																					\n");
			sb.append("							}else if(\"5\" == data[p].fieldType){																																				\n");
			sb.append("							fieldType = '具备发放条件福利信息字段';																																				\n");
			sb.append("							}else if(\"6\" == data[p].fieldType){																																				\n");
			sb.append("							fieldType = '内退期间福利信息字段';																																				\n");
			sb.append("							}else if(\"12\" == data[p].fieldType){																																					\n");
			sb.append("								fieldType = '特殊事项表';																																				\n");
			sb.append("								}else if(\"7\" == data[p].fieldType){																																					\n");
			sb.append("							fieldType = '财务信息表';																																				\n");
			sb.append("							}else if(\"8\" == data[p].fieldType){																																			\n");	
			sb.append("							fieldType = '财务信息表对比表';																																			\n");
			sb.append("								}else if(\"9\" == data[p].fieldType){																																			\n");
			sb.append("							fieldType = '人员变动及福利对比表';																																		\n");
			sb.append("								}else if(\"10\" == data[p].fieldType){																																		\n");	
			sb.append("							fieldType = '历史信息表';																																		\n");
			sb.append("								}else if(\"11\" == data[p].fieldType){																																		\n");	
			sb.append("							fieldType = '其他信息表';																																	\n");
			sb.append("							}																															\n");
			sb.append("		        			o[o.length] = '<tr class=\"Grid_Item\"  style=\"\">' ;                                                                                                                  \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:30%;\">'+data[p].fieldName+'</td> ' ;                                                                                 \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+data[p].fieldCode+'</td>' ;                                                                                  \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+dataType+'</td>' ;                                                                                           \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+data[p].dataLength+'</td>' ;                                                                                  \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:8%;\">'+isVisible+'</td>' ;                                                                                          \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+isUpdate+'</td>' ;                                                                                          \n");
			sb.append("	 		        	    o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+fieldType+'</td>' ;                                                                                          \n");
			sb.append("				        	o[o.length] = '<td align=\"center\" style=\"width:10%;\">'+isDel+'</td>' ;                                                                                              \n");
			sb.append("				        	o[o.length] = '</tr> ' ;                                                                                                                                            \n");
			sb.append("				        	o[o.length] = ''                                                                                                                                                    \n");
			sb.append("		        		}                                                                                                                                                                     \n");
			sb.append("		        		j[j.length]='<div class=\"table_page\"  >'+result.pageSb+'</div>';                                                                                                      \n");
			sb.append("		        	}else{                                                                                                                                                                  \n");
			sb.append("		        		o[o.length] = '<td colspan=\"100\">没有相关数据</td>';                                                                                                                  \n");
			sb.append("		        	} 		                                                                                                                                                                  \n");
			sb.append("		        	$(\".tableList-\"+poolType).empty().html(o.join(\"\"));                                                                                                                                \n");
			sb.append("		        	$(\".tb-\"+poolType).empty().html(j.join(\"\"));                                                                                                                                       \n");
			sb.append("		        }else{                                                                                                                                                                    \n");
			sb.append("		        	alert(result.msg);                                                                                                                                                      \n");
			sb.append("		        }                                                                                                                                                                         \n");
			sb.append("			},                                                                                                                                                                              \n");
			sb.append("			error:function(){                                                                                                                                                                             \n");
			sb.append("			alert(\"错误\");                                                                                                                                                                             \n");
			sb.append("			}                                                                                                                                                                              \n");
			sb.append("		});                                                                                                                                                                                \n");
			sb.append("		}                                                                                                                                                                                \n"); 
			sb.append("function delField(poolId,index ,fieldName){ \n");
			sb.append(" confirm('确认要删除吗？', {\n ");
			sb.append("   btn: ['确认','取消']                   \n ");
			sb.append(" 	}, function(){                            \n ");
			sb.append("  $.ajax({                                    \n ");
			sb.append("url:\"<c:url value='../table/delField.htm'/>\",\n ");
			sb.append("type:\"POST\",\n ");
			sb.append("data:{\n ");
			sb.append("\"poolId\":poolId,\n ");
			sb.append("	},\n ");
			sb.append("async:false,\n ");
			sb.append("success:function(result){\n ");
//			sb.append("$(\"#fieldName\"+index).val(\"\");\n ");
//			sb.append("	 $(\"#fieldDataType\"+index).val(0);\n ");
			sb.append("	alert(\"删除成功\");\n ");
			sb.append("	location.reload();	\n ");
			//sb.append("	$(\"#tabs > ul\").tabs({selected:index-1}); \n ");
			sb.append("		},\n ");
			sb.append("	 error:function(error){\n ");
			sb.append("	 alert(\"解析数据错误\");\n ");
			sb.append("	 }\n ");
			sb.append("	  });\n ");
			sb.append("	 	}, function(){\n ");
			sb.append("	close();\n ");
			sb.append("	 	});\n ");
			sb.append("	  }\n ");
			//跳转函数 
			sb.append("function toTZ"+inde+"(){");
			sb.append("var toPaggeVlue = document.getElementById(\"toGoPage"+inde+"\").value;");
			sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage"+inde+"\").value=1;return;}");
			sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage"+inde+"\").value=1;return;}");
			sb.append("nextPage"+inde+"(toPaggeVlue);");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStrAjax = sb.toString();
		return pageStrAjax;
	}
	
}
