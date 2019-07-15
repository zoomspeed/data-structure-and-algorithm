

var readline = require('readline');        

var rl = readline.createInterface({
     input: process.stdin,
     output: process.stdout
});

rl.prompt();                         

rl.on("line", (data) => {
     //console.log(data);                    

     var num = data.split(" ");


     var answer = gcd(num);
     
     

     rl.on("line",(data2)=>{

      var num2 = data2.split(" ");
    
      var answer2 = multipleGcd(num2);
      
      console.log("answer1",answer);
      console.log("answer2",answer2);
      
      rl.close();
     });     
     

});



function gcd(arr){

  var a = arr[0]*1;
  var b = arr[1]*1;


/*node 
  if(a<b){
    var tmp = a;
    a = b;
    b = tmp;
  }
*/
  while(b>0){

    var tmp = a;
    a = b;
    b = tmp%b;

  }

  return a;

}

function multipleGcd(arr){

  var CurrentGCD = 0;
  var temp = new Array();
  temp[0] = arr[0];
  temp[1] = arr[1];


  CurrentGCD = gcd(temp);

  

  for(var i=2; i<arr.length; i++){

    var arr1 = new Array();
    arr1[0] = CurrentGCD;
    arr1[1] = arr[i];
    CurrentGCD = gcd(arr1);
    
  }
  
  return CurrentGCD;

}
