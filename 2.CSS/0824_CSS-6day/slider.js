
var inter = setInterval("slide()", 3000);
var i = 0;
var pos = document.querySelectorAll("[type='radio']");

function slide(){
    i++;
    if(i >= 4){
        i = 0;
    }
   
    pos[i].checked = true;  
}
function change(idx){
    i = idx;
    console.log(i);
    clearInterval(inter);
    inter = setInterval("slide()", 3000);
}



