package com.mybaties.mapper;

import java.util.List;

import com.po.Bed;

public interface BedMapper {
	public Bed findBedByBno(String bno);
	public List<Bed> findBedByCondition(int condition);
	public void insertBed(Bed bed);
	public void deleteBedByBno(String bno);
	public void updateBedByBno(Bed bed);

}
