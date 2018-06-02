/**
 * 课程分类管理管理初始化
 */
var SubjectCateory = {
    id: "SubjectCateoryTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SubjectCateory.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '父id', field: 'pid', visible: true, align: 'center', valign: 'middle'},
            {title: '课程分类名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '课程分类编码', field: 'key', visible: true, align: 'center', valign: 'middle'},
            {title: '课程分类编号', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'sort', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(0 禁用 1 启用)', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SubjectCateory.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SubjectCateory.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加课程分类管理
 */
SubjectCateory.openAddSubjectCateory = function () {
    var index = layer.open({
        type: 2,
        title: '添加课程分类管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/subjectCateory/subjectCateory_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看课程分类管理详情
 */
SubjectCateory.openSubjectCateoryDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '课程分类管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/subjectCateory/subjectCateory_update/' + SubjectCateory.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除课程分类管理
 */
SubjectCateory.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/subjectCateory/delete", function (data) {
            Feng.success("删除成功!");
            SubjectCateory.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("subjectCateoryId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询课程分类管理列表
 */
SubjectCateory.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SubjectCateory.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SubjectCateory.initColumn();
    var table = new BSTable(SubjectCateory.id, "/subjectCateory/list", defaultColunms);
    table.setPaginationType("server");
    SubjectCateory.table = table.init();
});
