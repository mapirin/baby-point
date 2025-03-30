/**
 * 
 */
const returnUseButton = document.getElementById("returnUseButton");
const backButton = document.getElementById("backButton");
let errorMessage = document.getElementById("errorMessage");
const urlParams = new URLSearchParams(window.location.search);
let point = Number(urlParams.get("point"))

returnUseButton.addEventListener('click', ()=>{
    const selectedRadio = document.querySelector('input[name="useOptions"]:checked');
    if(selectedRadio && (point - Number(selectedRadio.value)>=0)){
        point = point - Number(selectedRadio.value);
        window.opener.postMessage({updatePoint:point}, window.location.origin);
        window.close();
    }else if(selectedRadio && (point - Number(selectedRadio.value)<0)){
        errorMessage.textContent = `ポイントが足りません。(現在のポイント)：${point}`;
    }else {
        errorMessage.textContent = `1つ選択してください。`;
    }
})

backButton.addEventListener('clicl', ()=>{
	window.opener.postMessage({updatePoint:point}, window.location.origin);
	window.close();
})