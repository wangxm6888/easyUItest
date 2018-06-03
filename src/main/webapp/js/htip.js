/**

获取项目的路径
*/
var htip = function(){
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0,pos);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/') + 1);
	return (localhostPath + projectName);
}
//
jQuery.serializeObject = function(form)
{
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if(o[this['name']])
		{
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else{
			o[this['name']] = this['value'];
		}			
	});
	return o;
};