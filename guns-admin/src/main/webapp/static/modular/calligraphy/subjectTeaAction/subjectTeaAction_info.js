/**
 * 初始化教师课程管理详情对话框
 */
var SubjectTeaActionInfoDlg = {
    subjectTeaActionInfoData : {}
};

/**
 * 清除数据
 */
SubjectTeaActionInfoDlg.clearData = function() {
    this.subjectTeaActionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectTeaActionInfoDlg.set = function(key, val) {
    this.subjectTeaActionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectTeaActionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SubjectTeaActionInfoDlg.close = function() {
    parent.layer.close(window.parent.SubjectTeaAction.layerIndex);
}

/**
 * 收集数据
 */
SubjectTeaActionInfoDlg.collectData = function() {
    this
    .set('id')
    .set('subjectid')
    .set('teacherid')
    .set('createtime');
}

/**
 * 提交添加
 */
SubjectTeaActionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectTeaAction/add", function(data){
        Feng.success("添加成功!");
        window.parent.SubjectTeaAction.table.refresh();
        SubjectTeaActionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectTeaActionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SubjectTeaActionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subjectTeaAction/update", function(data){
        Feng.success("修改成功!");
        window.parent.SubjectTeaAction.table.refresh();
        SubjectTeaActionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectTeaActionInfoData);
    ajax.start();
}

$(function() {

});
