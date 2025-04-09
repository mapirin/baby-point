/**
 * 
 */
const stockButton = document.getElementById("stockButton");
const useButton = document.getElementById("useButton");
const backButton = document.getElementById("backButton");
	
//再ロード内容反映処理を実行
initialize();

//index.jsで再ロードした内容を反映するための関数を指定
async function initialize(){
	let pointDspl = document.getElementById("pointDspl");
	
	//初期表示時のSQLパラメータ
	const requestBody = {
		userName: 'masa'
	};
	
	try{
		const responce = await fetch('/init',{
			method: 'POST',
			headers: {
				'Content-Type':'application/json',
			},
			body: JSON.stringify(requestBody),
		});
		
		if(!responce.ok){
			console.log(responce.status);
//		}else{
			const responceJson = await responce.json();
			pointDspl.textContent = responceJson.point();
		}
	}catch(error){
		
	}
	pointDspl.textContent = 0;
	if(pointDspl.textContent <= 0){
	    useButton.disabled = true; 
	}
}

stockButton.addEventListener('click', ()=>{
    let point = Number(pointDspl.textContent);
    const modal = window.open(`stockExecute.html?point=${point}`,"_blank","width=400,height=300")

    window.addEventListener(("message"), (e)=>{
        if(e.origin === window.location.origin){
            point = e.data.updatePoint;
            pointDspl.textContent = point;
            if(useButton.disabled){
                useButton.disabled = false;
            }
        }
    })
})

useButton.addEventListener('click', ()=>{
    let point = Number(pointDspl.textContent);
    const modal = window.open(`useExecute.html?point=${point}`,"_blank","width=400,height=300")

    window.addEventListener(("message"), (e)=>{
        if(e.origin === window.location.origin){
            point = e.data.updatePoint;
            pointDspl.textContent = point;
            //比較時はString→Numberに変換して数値で実行が必要
            if(Number(pointDspl.textContent) <= 0){
                useButton.disabled = true;
            }
        }
    })
})

//定義されたhtmlの表示のみ
backButton.addEventListener('click', ()=>{
	window.open("index.html","_self","");
})