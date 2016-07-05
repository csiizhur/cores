/**
 * @author zhur
 */
$.extend($.fn.validatebox.defaults.rules, {
	/* 必须和某个字段相等,密码验证 */
	equalTo : {
		validator : function(value, param) {
			return $(param[0]).val() == value;
		},
		message : '字段不匹配'
	}
});