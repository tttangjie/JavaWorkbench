package com.ymy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymy.pojo.EUDataGridResult;
import com.ymy.pojo.ResultPojo;
import com.ymy.pojo.Score;
import com.ymy.pojo.vo.ScoreVo;
import com.ymy.service.ScoreService;

@Controller
@RequestMapping("/Score")
public class ScoreController {
	@Autowired
	ScoreService scoreservice;
	@RequestMapping("/ScoreList.do")
	@ResponseBody
	public EUDataGridResult getScoreList(Integer page,Integer rows)
	{
		EUDataGridResult result=scoreservice.getScore(page, rows);
		return result;
	}
	@RequestMapping("/updateScore.do")
	@ResponseBody
	public ResultPojo updateScore(ScoreVo scorevo)
	{
		return scoreservice.updateScore(scorevo);
	}
	@RequestMapping("/deleteScore.do")
	@ResponseBody
	public ResultPojo deleteScore(String id)
	{
		String[] strs = id.split(",");
	    List<String> ss=new ArrayList<String>();
		for(String s:strs)
		{
			ss.add(s);
		}
		ResultPojo result = scoreservice.deleteScore(ss);
		return result;
	}
	@RequestMapping("/addScore.do")
	@ResponseBody
	public ResultPojo addScore(int course_id,int stu_id,int score)
	{
		Score temp=new Score();
		temp.setCourse_id(course_id);
		temp.setStu_id(stu_id);
		temp.setScore(score);
		ResultPojo result=new ResultPojo();
		int i=scoreservice.addScore(temp);
		if(i==1)
			return ResultPojo.ok();
		result.setStatus(404);
		return result;
		
	}
}
