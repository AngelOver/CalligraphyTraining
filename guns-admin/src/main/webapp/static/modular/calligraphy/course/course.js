/**
 * 成长历程管理初始化
 */
var Course = {
    id: "CourseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Course.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '学员id', field: 'studentid', visible: true, align: 'center', valign: 'middle'},
            {title: '老师id', field: 'teacherid', visible: true, align: 'center', valign: 'middle'},
            {title: '时间', field: 'time', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '图片', field: 'image', visible: true, align: 'center', valign: 'middle'},
            {title: '主题', field: 'theme', visible: true, align: 'center', valign: 'middle'},
            {title: '摘要', field: 'summary', visible: true, align: 'center', valign: 'middle'},
            {title: '关键词', field: 'keywords', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '回复', field: 'reply', visible: true, align: 'center', valign: 'middle'},
            {title: '留言', field: 'message', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Course.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Course.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加成长历程
 */
Course.openAddCourse = function () {
    var index = layer.open({
        type: 2,
        title: '添加成长历程',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/course/course_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看成长历程详情
 */
Course.openCourseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '成长历程详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/course/course_update/' + Course.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除成长历程
 */
Course.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/course/delete", function (data) {
            Feng.success("删除成功!");
            Course.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("courseId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询成长历程列表
 */
Course.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Course.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Course.initColumn();
    var table = new BSTable(Course.id, "/course/list", defaultColunms);
    table.setPaginationType("server");
    Course.table = table.init();
});
