package com.point.baby.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.point.baby.entity.PointForm;
import com.point.baby.service.PointExecuteServiceImpl;

@RestController
public class BabyPointRestController {
	
	@Autowired
	public PointForm pointForm;
	
	@Autowired
	public PointExecuteServiceImpl pointExecuteServiceImpl;

	//ポイント操作画面の初期処理
	@PostMapping("/init")
	public int Init(@RequestBody String userName) {
		int i = pointExecuteServiceImpl.selectPoint(userName);
		System.out.println(i);
		return i;
	}
	//サブウインドウのOK押下
	@PostMapping("/click-ok")
	public ResponseEntity<Boolean> clickOk(@RequestBody PointForm pointForm) {
		try {
			pointExecuteServiceImpl.updatePoint(pointForm);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false); // エラー時
	    }
		return ResponseEntity.ok(true);
	}
}
