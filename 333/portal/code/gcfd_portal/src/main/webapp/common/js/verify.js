/**
 * d1显示，d2隐藏
 * @param d1{ document }
 * @param d2{ document }
 * @returns
 */
function domHidden( d1, d2 ){
	$(d1).removeAttr('hidden');
	$(d2).attr('hidden','hidden');
}

/**
 * 去掉首尾空格
 * @param str
 * @returns
 */
function trimStr(str){
	return str.replace(/(^\s*)|(\s*$)/g,"");
}