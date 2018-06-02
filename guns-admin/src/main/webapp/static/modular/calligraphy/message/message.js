/**
 * 报名管理管理初始化
 */
var Message = {
    id: "MessageTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Message.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '处理人', field: 'processid', visible: true, align: 'center', valign: 'middle'},
            {title: '处理意见', field: 'processRemark', visible: true, align: 'center', valign: 'middle'},
            {title: '处理结果', field: 'processResult', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Message.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Message.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加报名管理
 */
Message.openAddMessage = function () {
    var index = layer.open({
        type: 2,
        title: '添加报名管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/message/message_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看报名管理详情
 */
Message.openMessageDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '报名管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/message/message_update/' + Message.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除报名管理
 */
Message.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/message/delete", function (data) {
            Feng.success("删除成功!");
            Message.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("messageId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询报名管理列表
 */
Message.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Message.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Message.initColumn();
    var table = new BSTable(Message.id, "/message/list", defaultColunms);
    table.setPaginationType("server");
    Message.table = table.init();
});
