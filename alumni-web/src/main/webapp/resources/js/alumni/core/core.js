var ALUMNI = {}
/**
 * 创建命名空间
 * @param namespaceString 命名空间字符串,等同于java中的package,例如ALUMNI.CORE
 * 为了便于与类名区分,命名空间一律采用大写
 * @returns 命名空间对象
 */
ALUMNI.createNS = function(namespaceString) {
    var parts = namespaceString.split('.'),
        parent = window,
        currentPart = ''; 
        
    for (var i = 0, length = parts.length; i < length; i++) {
        currentPart = parts[i];
        parent[currentPart] = parent[currentPart] || {};
        parent = parent[currentPart];
    }
    
    return parent;
}

// 创建一个命名空间
ALUMNI.createNS("ALUMNI.CORE");

//系统核心工具类
ALUMNI.CORE.ac = function() {
	//ajax请求函数，系统通过该函数进行ajax请求
	this.ajax = function(options) {
		if (!options.dataType) {
			options.dataType = "json";
		}
		
		if (!options.timeout) {
			options.timeout = 1000 * 60 * 60;
		}
		
		if (!options.timeout) {
			options.timeout = 1000 * 60 * 3;
		}
		if (!options.contentType) {
			options.contentType = "application/json; charset=utf-8";
		}

		if (options.url.indexOf('?') > -1) {//加入时间戳
			options.url += '&' + new Date().getTime();
		} else {
			options.url += '?' + new Date().getTime();
		}

		if (!options.success) { //没有加入自定义的success回调函数，则调用默认回调函数
			options.success = function(res, textStatus, jqXHR) {
				if (res.status != 0) { // 如果返回结果消息状态码非零则表示失败,弹出错误信息
						if(res.status == 501){
				        	window.location.href = consts.PROJECT_URL;
						}
					if(options.fail) {
						options.fail.call(this, res, textStatus, jqXHR);
						return;
					}
					alert("ERROR:" + res.statusInfo);
					return;
				}

				if (options.ok) { //如果有自定义ok回调，则在结果码为成功时回调
					options.ok.call(this, res, textStatus, jqXHR);
				}
			}
		}
		if (!options.error) { // 没有加入自定义的error回调函数，则指定默认回调
			options.error = function(res, textStatus, jqXHR) {
				alert("ERROR:" + jqXHR);
				if (res.status != 0) { //如果返回结果消息状态码非零则表示失败,弹出错误信息
					if(res.status == 501){
			        	window.location.href = consts.PROJECT_URL;
					}
				}
			}
		}
		

		return $.ajax(options);
	},
	
	/**
	 * 获取html页面或者片段，
	 * 如果需要获得页面中的某个片段，可以传入片段的id
	 * 例如forward?url=test/dummy #targetId
	 */
	this.getHtml = function(urlStr) {
		var urlELs = urlStr.split(" ");
		var url = urlELs[0];
		var selector = urlELs.length > 1 ? urlELs[1] : null;
		
		var html = "";
		$.ajax({
			  url: url,
			  async: false,
			  dataType: "html",
			  success: function(data, textStatus, jqXHR) {
				html = selector ? $("<div>").append( $.parseHTML( data ) ).find(selector).html() : data;
			  }
			});
		return html;
	}
}

window.ac = new ALUMNI.CORE.ac();