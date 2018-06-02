/**
 * 学员选课管理管理初始化
 */
var SubjectStuAction = {
    id: "SubjectStuActionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SubjectStuAction.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '课程id', field: 'subjectid', visible: true, align: 'center', valign: 'middle'},
            {title: '学员id', field: 'studentid', visible: true, align: 'center', valign: 'middle'},
            {title: '课时数', field: 'subjectcount', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SubjectStuAction.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SubjectStuAction.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加学员选课管理
 */
SubjectStuAction.openAddSubjectStuAction = function () {
    var index = layer.open({
        type: 2,
        title: '添加学员选课管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/subjectStuAction/subjectStuAction_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看学员选课管理详情
 */
SubjectStuAction.openSubjectStuActionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '学员选课管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/subjectStuAction/subjectStuAction_update/' + SubjectStuAction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除学员选课管理
 */
SubjectStuAction.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/subjectStuAction/delete", function (data) {
            Feng.success("删除成功!");
            SubjectStuAction.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("subjectStuActionId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询学员选课管理列表
 */
SubjectStuAction.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SubjectStuAction.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SubjectStuAction.initColumn();
    var table = new BSTable(SubjectStuAction.id, "/subjectStuAction/list", defaultColunms);
    table.setPaginationType("server");
    SubjectStuAction.table = table.init();
});
