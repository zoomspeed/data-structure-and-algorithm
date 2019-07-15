

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
     
     console.log(answer);


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
