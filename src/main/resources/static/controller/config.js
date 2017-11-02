/**
 * 页面刷新、模态框居中
 * Author：Lord
 * version:1.0
 * datetime:2017-11-2
 */

//刷新当前页面
function Refresh() {
	window.location.replace(location);
};

//模态框垂直和水平居中
$('#myModal').on('shown.bs.modal', function (e) {  
    // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零  
    $(this).css('display', 'block');  
    var modalHeight=$(window).height() / 3 - $('#myModal .modal-dialog').height() / 2;  
    $(this).find('.modal-dialog').css({  
        'margin-top': modalHeight  
    });  
});