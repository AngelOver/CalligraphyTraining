/**
 * 教师课程管理管理初始化
 */
var SubjectTeaAction = {
    id: "SubjectTeaActionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SubjectTeaAction.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '课程id', field: 'subjectid', visible: true, align: 'center', valign: 'middle'},
            {title: '教师id', field: 'teacherid', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SubjectTeaAction.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SubjectTeaAction.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加教师课程管理
 */
SubjectTeaAction.openAddSubjectTeaAction = function () {
    var index = layer.open({
        type: 2,
        title: '添加教师课程管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/subjectTeaAction/subjectTeaAction_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看教师课程管理详情
 */
SubjectTeaAction.openSubjectTeaActionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '教师课程管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/subjectTeaAction/subjectTeaAction_update/' + SubjectTeaAction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除教师课程管理
 */
SubjectTeaAction.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/subjectTeaAction/delete", function (data) {
            Feng.success("删除成功!");
            SubjectTeaAction.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("subjectTeaActionId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询教师课程管理列表
 */
SubjectTeaAction.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SubjectTeaAction.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SubjectTeaAction.initColumn();
    var table = new BSTable(SubjectTeaAction.id, "/subjectTeaAction/list", defaultColunms);
    table.setPaginationType("server");
    SubjectTeaAction.table = table.init();
});
