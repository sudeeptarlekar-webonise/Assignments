var parserLib = {
	
	//This function will parse equation for line and will retrive constant from equ, saving that into array and will return array
	parseLineEquation: function(equation){
		var constant_a = parseInt(equation.substring(0,equation.indexOf('x')));
		var constant_b = parseInt(equation.substring(equation.indexOf('x')+1,equation.indexOf('y')));
		var constant_c = parseInt(equation.substring(equation.indexOf('y')+1,equation.indexOf('=')));
		var constant_d = parseInt(equation.substring(equation.indexOf('=')+1,equation.length));
		var constant_array = [constant_a,constant_b,constant_c,constant_d];
		return constant_array;	
	},
	
	drawLine: function(constant_array, Canvas, x_start, x_end, x_step){
		var context = Canvas.getContext('2d');
		
		context.beginPath(); // to tell that we are gonna draw something
		context.moveTo(250,250); 
			
		for (i=x_start; i<=x_end; i=i+x_step)
		{
			var y = parserLib.getYCoordinate(constant_array,i);
			context.lineTo(i,y);
			context.stroke(); //will display any shape we drawn on canvas
		}
	},
	
	//function to return value of y, from all constants.
	getYCoordinate: function(constant_array,x){
		return (constant_array[3]-(constant_array[0]*x)-constant_array[2])/constant_array[1];
	}
};

