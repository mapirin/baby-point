/**
 * 
 */
//2人用のボタンを定義
const masaButton = document.getElementById("masaButton");
const momoButton = document.getElementById("momoButton");

//まさボタン押下時
masaButton.addEventListener('click', ()=>{
	showPagePointExecuteJs();
})

momoButton.addEventListener('click', ()=>{
	showPagePointExecuteJs();
})

//画面に取得した現在のポイントを反映するための処理用関数
async function showPagePointExecuteJs(){
	try {
        const response = await fetch("/pointExecute.html"); // 静的リソースへリクエスト
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const html = await response.text();
        document.body.innerHTML = html;

        const script = document.createElement("script");
        script.src = "pointOperate.js"; // 必要ならスクリプトも挿入
        script.defer = true;
        document.body.appendChild(script);
    } catch (error) {
        console.error("エラー発生:", error);
    }

//	try{
//		 //BabyPointControllerで定義された『/point-execute』エンドポイントにリクエストを送り、
//		 //HTMLコンテンツを取得
//		const responce = await fetch("/point-execute");
//		//フェッチしたレスポンスのテキストをHTMLデータとして取得
//		const html = await responce.text();
//		//取得したHTMLを現在の画面に動的に挿入し、DOMを更新
//		document.body.innerHTML = html;
//		
//		//要素名「script」の要素を作成（まだDOMには未挿入）
//		const script = document.createElement("script");
//		//『script』要素のソース属性に『pointOperate.js』を設定して、外部スクリプトを指定
//		script.src = "pointOperate.js";
//		//スクリプトの実行をHTML解析完了後に遅延するよう指定
//		script.defer = true;
//		//現在のHTMLの『body』要素に『script』を挿入し、ブラウザがスクリプトのロードを開始
//		document.body.appendChild(script);
//	}catch(error){
//		console.log("エラー発生", error);
//	}
}