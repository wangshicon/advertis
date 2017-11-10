/*!
 * attachment.js
 * Copyright 2017-2018
 * Authors: Lord
 * All Rights Reserved.
 * 附件管理路由控制器
 */

// 上传前置判断是否选择分类
toastr.options.positionClass = 'toast-bottom-right';
$("#upload").click(function(){
    if(categoryId > 0){
        $('#myModal').modal('show');
    } else {
        toastr.error('请选择分类！');
    }
});

// 上传窗口初始化完成后，将分类Id追加至上传的表单中
$('#myModal').on('shown.bs.modal', function () {
    $('#uploadForm').append("<input type='hidden' id='categoryId' value=''>");
    $('#categoryId').val(categoryId);
});

// 上传窗口关闭，刷新页面数据
$('#myModal').on('hidden.bs.modal', function () {
    window.location.replace(location);
});

function deleById(id){
    $.confirm({
        title: '操作提示!',
        content: '确定要删除选择的数据吗？',
        buttons: {
            确定: {
                btnClass: 'btn-danger',
                action: function(){
                    $.ajax({
                        type: 'DELETE',
                        url: '/attachment/delete/'+id,
                        success: function(result) {
                            if(result.code > -1){
                                toastr.success(result.msg);
                                //提交成功后，刷新页面
                                setTimeout('Refresh()',2000);
                            }else{
                                toastr.error(result.msg);
                            }
                        }
                    });
                }
            },
            取消: function () {
                //close
            },
        }
    });
}

function findAttach(id){
    $.ajax({
        type: 'GET',
        url: '/attachment/'+id,
        success: function(result) {
            if(result.code == 0){
                zeroModal.show({
                    title: '图片名称：'+result.data.attname,
                    content: '<img class=img-responsive src='+result.data.filepath+'>',
                    width: '60%',
                    height: '70%',
                    max: true,
                    min: true
                });
            }else{
                toastr.error(result.msg);
            }
        }
    });
}