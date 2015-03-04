
var equation = "";
var constant_array;
$(document).ready(function(){

	var lineObj = Object.create(parserLib);
	
	$("#equation").blur(function(){
		equation = $("#equation").val();
		var pattern = new RegExp("[+|-]*[0-9]+[a-z|A-Z]+[+|-]+[0-9]+[a-z|A-Z][+|-][0-9]+=[+|-]*[0-9]+$");

		if(equation == "" || !(pattern.test(equation)))
			alert("Please enter correct equation");
		else
		{
			constant_array = lineObj.parseLineEquation(equation); // function will return array which will contain constant values from equation

			//to display constants			
			$("#value_a").val(constant_array[0]);
			$("#value_b").val(constant_array[1]);
			$("#value_c").val(constant_array[2]);
			$("#value_d").val(constant_array[3]);
		}
	});

	$("#draw_graph").click(function(){
		var Canvas = $("#geometry_canvas")[0];	//This will return array of canvas containing canvas,context,selector etc., 
							//we are taking only first element which is canvas
		var x_start = parseInt($("#start_x").val());
		var x_end = parseInt($("#end_x").val());
		var x_step = parseInt($("#step_x").val());
		
		if(Canvas!=null)
			lineObj.drawLine(constant_array, Canvas, x_start, x_end, x_step);
	});
});
