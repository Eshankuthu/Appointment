$(document).ready(function(){

$("#btnnew").click(function(){
        $("#btnnew").hide();
        $(".add-form").show();
    })


$("#btn-cancel").click(function(){
	$("#btnnew").show();
	$(".add-form").hide();
})

});