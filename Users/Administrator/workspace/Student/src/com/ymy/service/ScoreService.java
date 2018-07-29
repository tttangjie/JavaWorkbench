package com.ymy.service;

import java.util.List;

import com.ymy.pojo.EUDataGridResult;
import com.ymy.pojo.ResultPojo;
import com.ymy.pojo.Score;
import com.ymy.pojo.vo.ScoreVo;

public interface ScoreService {
	public EUDataGridResult getScore(Integer page,Integer rows);
	public ResultPojo updateScore(ScoreVo scorevo);
	public ResultPojo deleteScore(List<String> id);
	public int addScore(Score score);
}
