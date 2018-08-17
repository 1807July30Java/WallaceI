/*Fill in the functions below and submit them in a file called JSHWPart1.js. 
Due 5pm Friday, May 11*/

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	var i;
	var current;
	var previous1;
	var previous2;
	if(n === 0){
		return 0;
	} else if(n === (1 || 2)){
		return 1;
	} else {
		for (i = 1; i < n; i++) { 
			if(i === 1){
				current = 1;
				previous1 = 1;
			} else {
				previous2 = previous1;
				previous1 = current;
				current = previous1 + previous2;
				
			}
			/*console.log("value of i: "+i+", value of current: "+current);*/
			
		}
	}
	return current;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	var i;
	var j;
	var hold;
	i = 1;
	while(i < array.length){
		j = i;
		while(j > 0 && (array[j-1] > array[j])){
			hold = array[j];
			array[j] = array[j-1];
			array[j-1] = hold;
			j--;
		}
		i++;
	}
	/*for (i = 0; i < array.length; i++){
		if((i > (i+1)){
			hold = array[i];
			for(j = 0; j){
				
			}
		}
		
	}*/
	return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	var current;
	var i;
	if(n == (0 || 1)){
		return 1;
	} else {
		for (i = n; i > 1; i--) { 
			if (i == n){
				current = i * (i-1);
			} else {
				current = current * (i-1);
			}
		}
	}
	
	return current;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	var i;
	var j;
	var first;
	thisArray = array;
	if(n < 0){
		console.log("you stop that.");
		n = 0;
	} else {
		for(i = 0; i < n; i++){
			for(j = 0; j < thisArray.length; j++){
				if(j === 0){
					/*console.log("if j = 0 step: current index: "+j+" contains: "+thisArray[j]);*/
					first = thisArray[j];
					
				} else if(j === (thisArray.length-1)){
					/*console.log("if j = last step: current index: "+j+" contains: "+thisArray[j]);*/
					thisArray[j-1] = thisArray[j];
					thisArray[j] = first;
					
				} else {
					/*console.log("else step: current index: "+j+" contains: "+thisArray[j]);*/
					thisArray[j-1] = thisArray[j];
				}
			}
		}
		
	}
	return (thisArray+", "+ n);
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	var i;
	if(((bracketsString.length % 2) !== 0) || (bracketsString[0] == (")" || "]" || "}"))){
		return false;
	}
	for(i = 0; i < (bracketsString.length/2); i++){
		if (bracketsString[i] === "("){
			if (bracketsString[bracketsString.length-(i+1)] !== ")"){
				return false;
			}
		} 
		if (bracketsString[i] === "["){
			if (bracketsString[bracketsString.length-(i+1)] !== "]"){
				return false;
			}
		} 
		if (bracketsString[i] === "{"){
			if (bracketsString[bracketsString.length-(i+1)] !== "}"){
				return false;
			}
		}
	}
	return true;
};


/*YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)*/


