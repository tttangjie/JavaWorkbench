package com.mybaties.mapper;

import com.po.Prepay;

public interface PrepayMapper {
	public Prepay findPrepayByPno(String pno);
	public void insertPrepay(Prepay prepay);
	public void deletePrepayByPno(String pno);
	public void updatePrepayById(Prepay prepay);

}
