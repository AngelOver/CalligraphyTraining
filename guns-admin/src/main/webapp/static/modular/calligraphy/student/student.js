/**
 * 学员管理管理初始化
 */
var Student = {
    id: "StudentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Student.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '学号', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '头像', field: 'avatar', visible: true, align: 'center', valign: 'middle'},
            {title: '账号', field: 'account', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: 'md5密码盐', field: 'salt', visible: true, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '昵称', field: 'nick', visible: true, align: 'center', valign: 'middle'},
            {title: '生日', field: 'birthday', visible: true, align: 'center', valign: 'middle'},
            {title: '性别（1：男 2：女）', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '电子邮件', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '监1：启用护人', field: 'guardian', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(  2：冻结  3：删除）', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '课时数', field: 'subjectcount', visible: true, align: 'center', valign: 'middle'},
            {title: '微信openid', field: 'openid', visible: true, align: 'center', valign: 'middle'},
            {title: 'qq号', field: 'qq', visible: true, align: 'center', valign: 'middle'},
            {title: 'wx号', field: 'wx', visible: true, align: 'center', valign: 'middle'},
            {title: '第三方登录类型1-QQ 2-微信 3-新浪', field: 'thirdtype', visible: true, align: 'center', valign: 'middle'},
            {title: 'token', field: 'thirdtoken', visible: true, align: 'center', valign: 'middle'},
            {title: '身份验证', field: 'isVerify', visible: true, align: 'center', valign: 'middle'},
            {title: '余额', field: 'money', visible: true, align: 'center', valign: 'middle'},
            {title: '冻结金额', field: 'frozenMoney', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Student.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Student.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加学员管理
 */
Student.openAddStudent = function () {
    var index = layer.open({
        type: 2,
        title: '添加学员管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/student/student_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看学员管理详情
 */
Student.openStudentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '学员管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/student/student_update/' + Student.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除学员管理
 */
Student.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/student/delete", function (data) {
            Feng.success("删除成功!");
            Student.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("studentId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询学员管理列表
 */
Student.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Student.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Student.initColumn();
    var table = new BSTable(Student.id, "/student/list", defaultColunms);
    table.setPaginationType("server");
    Student.table = table.init();
});
