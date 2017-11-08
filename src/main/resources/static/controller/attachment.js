/*!
 * attachment.js
 * Copyright 2017-2018
 * Authors: Lord
 * All Rights Reserved.
 * 附件管理路由控制器
 */

// 初始化tree，定义分类id并赋值
var categoryId = 0;
$(document).ready(function (){
    $(".cid").each(function(index){
        $(this).click(function(){
            $("#category-all").removeClass("selective");
            $(".cid span").removeClass("selective");
            $(".cid span").eq(index).addClass("selective");
            categoryId = index+1;
        });
    });
});

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