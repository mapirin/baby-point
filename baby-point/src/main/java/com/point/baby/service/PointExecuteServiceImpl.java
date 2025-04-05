package com.point.baby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.point.baby.entity.PointList;
import com.point.baby.entity.UserPoint;
import com.point.baby.repository.PointListRepository;
import com.point.baby.repository.UserPointRepository;

@Service
public class PointExecuteServiceImpl implements PointExecuteService {

	@Autowired
	public UserPointRepository userPointRepository;
	
	@Autowired
	public PointListRepository pointListRepository;
	
	@Autowired
	public UserPoint userPoint;
	
	@Autowired
	public PointList pointList;
	
	/**
	 * 「ためる」「つかう」用CRUD処理
	 * 各INSERT用処理と履歴確認用のTBL登録処理
	 */
//	@Transactional
	public void executePointExecute(String userName, int point) {
		//ボタン押下ごとにユニークなタイムスタンプを取得して設定
		//TODO 動作確認用に最大値をオンコーディング
		String timestamp = "9999/12/31 23:59:99.999999";
		
		userPoint.setUserName(userName);
		userPoint.setPoint(point);
		userPoint.setUpdateTimestamp(timestamp);
		
		insertPointStock(userPoint);
		insertPointUse(userPoint);
		
		//TODO ユニークな値=TIMESTAMPをintに変換した値を使用
		pointList.setRecordId("");
		pointList.setUserName(userName);
		//TODO 画面からタイトルを渡す必要あり
		pointList.setPointTitle("");
		pointList.setPoint(point);
		pointList.setUpdateTimestamp(timestamp);
		
		insertPointList(pointList);
	}
	
	/*
	 * 「ためる」ボタン押下時処理後、ユーザのUSERPOINTTBLレコードを最新ポイントで更新
	 */
	public void insertPointStock(UserPoint userPoint) {
		userPointRepository.save(userPoint);
	}
	
	/*
	 * 「つかう」ボタン押下時処理後、ユーザのUSERPOINTTBLレコードを最新ポイントで更新
	 */
	public void insertPointUse(UserPoint userPoint) {
		userPointRepository.save(userPoint);
	}
	
	/*
	 * 「ためる」「つかう」ボタン押下後、いずれかの処理で使用したデータで新規レコード登録
	 */
	public void insertPointList(PointList pointList) {
		pointListRepository.save(pointList);
	}
}
