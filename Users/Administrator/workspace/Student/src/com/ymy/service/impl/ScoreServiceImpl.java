package com.ymy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ymy.mapper.ScoreMapper;
import com.ymy.pojo.EUDataGridResult;
import com.ymy.pojo.ResultPojo;
import com.ymy.pojo.Score;
import com.ymy.pojo.vo.ScoreVo;
import com.ymy.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreMapper scoremapper;

	@Override
	public EUDataGridResult getScore(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<ScoreVo> scoreList=scoremapper.getScoreList(page, rows);
		
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(scoreList);
		
		PageInfo<ScoreVo> pageInfo = new PageInfo<>(scoreList);
       	result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public ResultPojo updateScore(ScoreVo scorevo) {
		// TODO Auto-generated method stub
		scoremapper.updateScore(scorevo);
		return ResultPojo.ok();
	}

	@Override
	public ResultPojo deleteScore(List<String> id) {
		// TODO Auto-generated method stub
		scoremapper.deleteScores(id);
		return ResultPojo.ok();
	}

	@Override
	public int addScore(Score score) {
		// TODO Auto-generated method stub
		int i=scoremapper.addScore(score);
		return i;
	}
	
}
