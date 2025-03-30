/**
 * 
 */
const returnStockButton = document.getElementById("returnStockButton");
const backButton = document.getElementById("backButton");
const urlParams = new URLSearchParams(window.location.search);
let point = Number(urlParams.get("point"))

returnStockButton.addEventListener('click', ()=>{
    const selectedRadio = document.querySelector('input[name="stockOptions"]:checked');
    if(selectedRadio){
        point = point + Number(selectedRadio.value);
        window.opener.postMessage({updatePoint:point}, window.location.origin);
        window.close();
    }else{
        errorMessage.textContent = `1つ選択してください。`;
    }
})

backButton.addEventListener('click', ()=>{
	window.opener.postMessage({updatePoint:point}, window.location.origin);
	window.close();
})