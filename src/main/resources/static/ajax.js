$(document).ready(function(){

$("#btnnew").click(function(){
        $("#btnnew").hide();
        $(".add-form").show();
    })


$("#btn-cancel").click(function(){
	$("#btnnew").show();
	$(".add-form").hide();
})

   $('#datepicker').datepicker({
       minDate: new Date()
   });




var getAppointments = $("#btnSearch").click(function() {
    const searchstr=$("#txtSearch").val();
    $.ajax({
        url: "/appointment",
        method: "get",
        data: {'str': searchstr},

        success: function (data) {
            var appointments = "";
            $.each(data, function (key, value) {

                appointments += "<tr >" +
                    "<td  >" + value.date + "</td>" +
                    "<td  >" + value.time + "</td>" +
                    "<td  >" + value.description + "</td>" +
                    "</tr>";
            });
            $("#listofAppointment").html(appointments);
            $("#listofAppointment").closest("#hidden").show();
        },
      
    });
});



});