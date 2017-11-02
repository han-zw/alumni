/**
 * person列表相关js
 */
ALUMNI.createNS('ALUMNI');
ALUMNI.persons = function(options) {
	this.layoutContainer = options.container;
}

/**
 * persons类定义
 */
ALUMNI.persons.prototype = {
	init : function() {
		var that = this;
		// 获取html片段
		that.layoutContainer.load("transfer?to=person/person-list");
		
		// 创建datagrid
		$("#person-list-dg").datagrid({
		    url:'person/list',
		    data:{},
		    idField:"id",
		    columns:[[
		        {field:'code',title:'Code',width:100},
		        {field:'name',title:'Name',width:100},
		        {field:'price',title:'Price',width:100,align:'right'}
		    ]]
		});
	}
}

/*
// id
    private Long id;
    // 姓名
    private String name;
    // 学号
    private String studentNo;
    // 城市
    private String city;
    // 地区
    private String area;
    // 创建时间
    private Date createdTime;
    // 最后修改时间
    private Date modifiedTime;

    // 联系信息
    private List<ContactInfo> contactInfos;
*/