/**
 * 
 */
const returnStockButton = document.getElementById("returnStockButton");
const backButton = document.getElementById("backButton");
const urlParams = new URLSearchParams(window.location.search);
const point = Number(urlParams.get("point"))

returnStockButton.addEventListener('click', async ()=>{
    const selectedRadio = document.querySelector('input[name="stockOptions"]:checked');
    if(selectedRadio){
		
		//リクエストデータを定義
		const stockId = selectedRadio.id;
		const stockPoint  = point + Number(selectedRadio.value);
		//リクエストボディに設定
		const requestBody = {
			userName: 'masa',
			pointId: stockId,
			point: stockPoint,
		};
		
		try{
			//レスポンスURL、方式、データ形式、ボディ部を定義
			const responce = await fetch('/crud-execute', {
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
    }else{
        errorMessage.textContent = `1つ選択してください。`;
    }
})

backButton.addEventListener('click', ()=>{
	window.opener.postMessage({updatePoint:point}, window.location.origin);
	window.close();
})