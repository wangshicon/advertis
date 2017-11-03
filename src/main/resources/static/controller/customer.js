/*!
 * customers.js
 * Copyright 2017-2018
 * Authors: Lord
 * All Rights Reserved.
 * 客户意向管理路由控制器
 */

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
                        url: 'customers/delete/'+id,
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

function findCustomer(id){
    $.ajax({
        type: 'GET',
        url: '/customers/'+id,
        success: function(result) {
            if(result.code == 0){
                zeroModal.show({
                    title: '查看',
                    content: '姓名：'+result.data.username+'<br>电话：'+result.data.phone+'<br>信息：'+result.data.message,
                    overlay: true,
                    buttons: [{
                        className: 'zeromodal-btn zeromodal-btn-primary',
                        name: '确定',
                        fn: function(opt) {
                            //提交成功后，更新信息状态为已读
                            $("#status"+id).text("已读");
                        }
                    }]
                });
            }else{
                toastr.error(result.msg);
            }
        }
    });
}