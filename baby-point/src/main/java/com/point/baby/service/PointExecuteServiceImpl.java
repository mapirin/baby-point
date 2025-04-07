package com.point.baby.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.point.baby.entity.PointForm;
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
	public PointForm pointForm;
	
	@Autowired
	public UserPoint userPoint;
	
	@Autowired
	public PointList pointList;
	
	
	/*
	 * 
	 */
	public int selectPoint(String userName) {
		return userPointRepository.findByPoint(userName);
	}
	
	
	/**
	 * 「ためる」「つかう」用CRUD処理
	 * ポイント表示用更新処理と履歴確認用のTBL登録処理
	 */
//	@Transactional
	public void updatePoint(PointForm pointForm) {
		//recordIdとupdateTimestampを生成
		String recordId = String.valueOf(System.currentTimeMillis());
		LocalDateTime updateTimestamp = LocalDateTime.now();
		
		//USER_POINT TBL用のBEANにデータ設定
		userPoint.setUserName(pointForm.getUserName());
		userPoint.setPoint(pointForm.getPoint());
		userPoint.setUpdateTimestamp(updateTimestamp);
		
		insertUserPoint(userPoint);
		
		//POINT_LIST TBL用のBEANにデータ設定
		pointList.setRecordId(recordId);
		pointList.setUserName(pointForm.getUserName());
		pointList.setPointId(pointForm.getPointId());
		pointList.setPoint(pointForm.getPoint());
		pointList.setUpdateTimestamp(updateTimestamp);
		
		insertPointList(pointList);
	}
	
	/*
	 * 「ためる」「つかう」ボタン押下時処理後、ユーザのUSER_POINT TBLレコードを最新ポイントで更新
	 */
	public void insertUserPoint(UserPoint userPoint) {
		userPointRepository.save(userPoint);
	}
	
	/*
	 * 「ためる」「つかう」ボタン押下後、いずれかの処理で使用したデータでPOINT_LIST TBLの新規レコード登録
	 */
	public void insertPointList(PointList pointList) {
		pointListRepository.save(pointList);
	}
}
