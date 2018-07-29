package com.ymy.mapper;

import java.util.List;

import com.ymy.pojo.Score;
import com.ymy.pojo.vo.ScoreVo;

public interface ScoreMapper {
	public List<ScoreVo> getScoreList(Integer page,Integer rows);
	public void updateScore(ScoreVo scorevo);
	public void deleteScores(List<String> id);
	public int addScore(Score score);
}
