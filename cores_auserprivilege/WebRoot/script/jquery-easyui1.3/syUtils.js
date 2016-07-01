/**
 * 获取项目根路径
 * 
 * 
 * */
function sybp(){
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath=  curWwwPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/')+1);
	return (localhostPath+projectName);
}
/**
 * 设置未来(全局)的AJAX请求默认选项
 * 主要设置了AJAX请求遇到Session过期的情况
 */
$.ajaxSetup({
    type: 'POST',
    complete: function(xhr,status) {
        var sessionStatus = xhr.getResponseHeader('sessionstatus');
        if(sessionStatus == 'timeout') {
            var top = getTopWinow();
            var yes = confirm('由于您长时间没有操作, session已过期, 请重新登录.');
            if (yes) {
                top.location.href = sybp()+'/index.jsp';            
            }
        }
    }
});

/**
 * 在页面中任何嵌套层次的窗口中获取顶层窗口
 * @return 当前页面的顶层窗口对象
 */
function getTopWinow(){
    var p = window;
    while(p != p.parent){
        p = p.parent;
    }
    return p;
}


/**
 * 将form表单值序列化成对象
 * @param form
 * @return
 */
function serializeObject(form){
	var o = {};
	$.each(form.serializeArray(),function(index){
		if(o[this['name']]){
			o[this['name']] = o[this['name']]+","+this['value'];
		}else{
			o[this['name']] = this['value'];
		}
	});
	return o;
}
/***
 * validatebox 最大长度
 */
$.extend($.fn.validatebox.defaults.rules, {    
    maxLength: {    
        validator: function(value, param){    
            return value.length <= param[0];    
        },    
        message: '长度不能大于 {0}.'   
    }    
});

/**检查密码和确认密码是否相同*/
$.extend($.fn.validatebox.defaults.rules, {    
    equals: {    
        validator: function(value,param){    
            return value == $(param[0]).val();    
        },    
        message: '两次输入密码不相同'   
    }    
});  
/**输入的为正整数*/
$.extend($.fn.validatebox.defaults.rules, {    
	signlessInteger: {    
		validator: function(value,param){
			var signlessInt = parseInt(value);
			return signlessInt > 0 && (signlessInt+'') == value;    
		},    
	message: '输入格式错误'   
	}    
});  
/**输入的为非负整数*/
$.extend($.fn.validatebox.defaults.rules, {    
	nonnegativeInteger: {    
	validator: function(value,param){
	var signlessInt = parseInt(value);
	return signlessInt >= 0 && (signlessInt+'') == value;    
},    
message: '输入格式错误'   
}    
});  

/**大于前一个数*/
/**检查密码和确认密码是否相同*/
$.extend($.fn.validatebox.defaults.rules, {    
	great: {    
        validator: function(value,param){  
			var signlessInt = parseInt(value);
			var minValue = parseInt($(param[0]).val());
            return signlessInt > minValue && (signlessInt+"") == value;    
        },    
        message: '该值应该比前一个值大'   
    }    
});  
/**输入的为大于等于  0  的数值（非负数）*/
$.extend($.fn.validatebox.defaults.rules, {    
	positiveNumber: {    
		validator: function(value){
				if(!isNaN(value)){
					if(Number(value) < 0){
						return false;
					}else{
						if(value.length<10){
							return true;
						}else{
							return false;
						}
					}
				}else{
					return false;
				}
		},    
	message: '请输入非负数'   
	}    
}); 

/***
 * validatebox 大于（） 的整数
 */
$.extend($.fn.validatebox.defaults.rules, {    
    minNumber: {    
        validator: function(value, param){    
	if(!isNaN(value)){
		var signlessInt = parseInt(value);
		return signlessInt >= Number(param) && (signlessInt+'') == value; 
	}else{
		return false;
	}    
        },    
        message: '请输入大于 {0}的整数.'   
    }    
});