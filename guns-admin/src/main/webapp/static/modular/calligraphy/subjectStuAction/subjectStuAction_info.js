/**
 * 初始化学员选课管理详情对话框
 */
var SubjectStuActionInfoDlg = {
    subjectStuActionInfoData : {}
};

/**
 * 清除数据
 */
SubjectStuActionInfoDlg.clearData = function() {
    this.subjectStuActionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectStuActionInfoDlg.set = function(key, val) {
    this.subjectStuActionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectStuActionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SubjectStuActionInfoDlg.close = function() {
    parent.layer.close(window.parent.SubjectStuAction.layerIndex);
}

/**
 * 收集数据
 */
SubjectStuActionInfoDlg.collectData = function() {
    this
    .set('id')
    .set('subjectid')
    .set('studentid')
    .set('subjectcount')
    .set('createtime');
}

/**
 * 提交添加
 */
SubjectStuActionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectStuAction/add", function(data){
        Feng.success("添加成功!");
        window.parent.SubjectStuAction.table.refresh();
        SubjectStuActionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectStuActionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SubjectStuActionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectStuAction/update", function(data){
        Feng.success("修改成功!");
        window.parent.SubjectStuAction.table.refresh();
        SubjectStuActionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectStuActionInfoData);
    ajax.start();
}

$(function() {

});
