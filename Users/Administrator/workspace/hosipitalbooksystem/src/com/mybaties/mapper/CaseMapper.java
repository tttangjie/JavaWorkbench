package com.mybaties.mapper;


import com.po.MedicalCase;

public interface CaseMapper {
	public MedicalCase findCaseByPno(String pno);
	public void insertCase(MedicalCase ca);
	public void deleteCaseByPno(String pno);
	public void updateCaseByPno(MedicalCase ca);

}