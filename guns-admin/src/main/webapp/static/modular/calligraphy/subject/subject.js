/**
 * 课程管理管理初始化
 */
var Subject = {
    id: "SubjectTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Subject.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '课程分类id', field: 'cateoryid', visible: true, align: 'center', valign: 'middle'},
            {title: '开课人id', field: 'teaid', visible: true, align: 'center', valign: 'middle'},
            {title: '开课人', field: 'teaname', visible: true, align: 'center', valign: 'middle'},
            {title: '课程名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '课程编码', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '主题', field: 'theme', visible: true, align: 'center', valign: 'middle'},
            {title: '摘要', field: 'summary', visible: true, align: 'center', valign: 'middle'},
            {title: '关键词', field: 'keywords', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '课程时间段', field: 'range', visible: true, align: 'center', valign: 'middle'},
            {title: '开始时间', field: 'starttime', visible: true, align: 'center', valign: 'middle'},
            {title: '结束时间', field: 'endtime', visible: true, align: 'center', valign: 'middle'},
            {title: '总课时数', field: 'totalcount', visible: true, align: 'center', valign: 'middle'},
            {title: '当前课时数', field: 'nowcount', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(0 未开始 1 进行中 2 已完成 3未完成 4已过期)', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人id', field: 'createid', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'createname', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改人id', field: 'updateid', visible: true, align: 'center', valign: 'middle'},
            {title: '修改人', field: 'updatename', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Subject.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Subject.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加课程管理
 */
Subject.openAddSubject = function () {
    var index = layer.open({
        type: 2,
        title: '添加课程管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/subject/subject_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看课程管理详情
 */
Subject.openSubjectDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '课程管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/subject/subject_update/' + Subject.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除课程管理
 */
Subject.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/subject/delete", function (data) {
            Feng.success("删除成功!");
            Subject.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("subjectId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询课程管理列表
 */
Subject.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Subject.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Subject.initColumn();
    var table = new BSTable(Subject.id, "/subject/list", defaultColunms);
    table.setPaginationType("server");
    Subject.table = table.init();
});
