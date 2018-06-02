/**
 * 初始化课程分类管理详情对话框
 */
var SubjectCateoryInfoDlg = {
    subjectCateoryInfoData : {}
};

/**
 * 清除数据
 */
SubjectCateoryInfoDlg.clearData = function() {
    this.subjectCateoryInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectCateoryInfoDlg.set = function(key, val) {
    this.subjectCateoryInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectCateoryInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SubjectCateoryInfoDlg.close = function() {
    parent.layer.close(window.parent.SubjectCateory.layerIndex);
}

/**
 * 收集数据
 */
SubjectCateoryInfoDlg.collectData = function() {
    this
    .set('id')
    .set('pid')
    .set('name')
    .set('key')
    .set('code')
    .set('sort')
    .set('status');
}

/**
 * 提交添加
 */
SubjectCateoryInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectCateory/add", function(data){
        Feng.success("添加成功!");
        window.parent.SubjectCateory.table.refresh();
        SubjectCateoryInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectCateoryInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SubjectCateoryInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectCateory/update", function(data){
        Feng.success("修改成功!");
        window.parent.SubjectCateory.table.refresh();
        SubjectCateoryInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectCateoryInfoData);
    ajax.start();
}

$(function() {

});
