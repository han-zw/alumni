/**
 * 前端常量类，与后台的常量列保持一致
 */

// 创建一个命名空间
ALUMNI.createNS("ALUMNI.CORE");
//系统核心工具类
ALUMNI.CORE.consts = {
	//文件上传大小限制（单位M）
	UPLOAD_MAXSIZE : 20
}

window.consts = ALUMNI.CORE.consts;
