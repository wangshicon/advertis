/*!
 * module.js
 * Copyright 2017-2018
 * Authors: Lord
 * All Rights Reserved.
 * 模块管理路由控制器
 */

toastr.options.positionClass = 'toast-bottom-right';
$("#sub").click(function(){
    $.ajax({
        type: 'PUT',
        data: $("#form1").serialize(),
        url: '/manager/module/edit',
        success: function(result) {
            if(result.code == 0){
                $('#myModal').modal('hide');
                toastr.success(result.msg);
                //提交成功后，刷新页面
                setTimeout('Refresh()',2000);
            }else{
                toastr.error(result.msg);
            }
        }
    });
});

function findById(id){
    $.ajax({
        type: 'GET',
        url: '/manager/module/'+id,
        success: function(result) {
            if(result.code == 0){
                $("#moduleId").val(result.data.id);
                $("input[name='name']").attr("placeholder", result.data.name);
                $("textarea[name='desction']").attr("placeholder", result.data.desction);
            }else{
                toastr.error(result.msg);
            }
        }
    });
}

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
                        url: '/manager/module/delete/'+id,
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

function findModule(id){
    $.ajax({
        type: 'GET',
        url: '/manager/module/'+id,
        success: function(result) {
            if(result.code == 0){
                zeroModal.show({
                    title: '查看',
                    content: '名称：'+result.data.name+'<br><br>描述：'+result.data.desction,
                    ok: false,
                    cancel: true,
                    overlay: true,
                });
            }else{
                toastr.error(result.msg);
            }
        }
    });
}