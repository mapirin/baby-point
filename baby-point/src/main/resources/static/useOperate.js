/**
 * 
 */
const returnUseButton = document.getElementById("returnUseButton");
const backButton = document.getElementById("backButton");
let errorMessage = document.getElementById("errorMessage");
const urlParams = new URLSearchParams(window.location.search);
let point = Number(urlParams.get("point"))

returnUseButton.addEventListener('click', async ()=>{
    const selectedRadio = document.querySelector('input[name="useOptions"]:checked');
    //リクエストデータを定義
	const stockId = selectedRadio.id;
	const stockPoint  = point - Number(selectedRadio.value);
    
    if(selectedRadio && (point - Number(selectedRadio.value)>=0)){
		
		//リクエストボディに設定
		const requestBody = {
			userName: 'masa',
			pointId: stockId,
			point: stockPoint,
		};
		
		try{
			//レスポンスURL、方式、データ形式、ボディ部を定義
			const responce = await fetch('/click-ok', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(requestBody),
			});
			//レスポンス結果による処理分岐
			if(responce.ok){
		        window.opener.postMessage({updatePoint:stockPoint}, window.location.origin);
		        window.close();
			}else{
				errorMessage.textContent = `リクエストが失敗しました。: ${responce.status}`;
			}
		}catch(error){
			errorMessage.textContent = `エラーが発生しました。: ${error.message}`;
		}
    }else if(selectedRadio && (point - Number(selectedRadio.value)<0)){
        errorMessage.textContent = `ポイントが足りません。(現在のポイント)：${point}`;
    }else{
        errorMessage.textContent = `1つ選択してください。`;
    }
})

backButton.addEventListener('click', ()=>{
	window.opener.postMessage({updatePoint:point}, window.location.origin);
	window.close();
})