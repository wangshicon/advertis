


toastr.options.positionClass = 'toast-bottom-right';
$("#sub").click(function(){
    $.ajax({
        type: 'PUT',
        data: $("#form1").serialize(),
        url: '/module/edit',
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
        url: '/module/'+id,
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
};

function deleById(id){
    $.confirm({
        title: '操作提示!',
        content: '确定要删除选择的数据吗？',
        buttons: {
            确定: {
                btnClass: 'btn-success',
                action: function(){
                    $.ajax({
                        type: 'DELETE',
                        url: 'module/delete/'+id,
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
};