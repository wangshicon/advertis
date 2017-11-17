/*!
 * index.js
 * Copyright 2017-2018
 * Authors: Lord
 * All Rights Reserved.
 * 首页管理路由控制器
 */

toastr.options.positionClass = 'toast-bottom-right';

// H5自带验证提示实现
phone.oninput=function(){
    phone.setCustomValidity("");
};
phone.oninvalid=function(){
    phone.setCustomValidity("请不要输入火星的手机号好吗？");
};

// 提交客户意向
$("#form1").on("submit", function(ev) {
    $.ajax({
        type: 'POST',
        data: $("#form1").serialize(),
        url: '/manager/customers/add',
        success: function(result) {
            if(result.code == 0){
                toastr.success("信息已记录");
            }else{
                toastr.error(result.msg);
            }
        }
    });
    //阻止submit表单提交
    ev.preventDefault();
    //或者return false
    //return false;
});

