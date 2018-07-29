package com.mybaties.mapper;
import java.util.List;
import com.po.Medicine;

public interface MedicineMapper {
	public Medicine findMedicineByMno(String mno);
	public List<Medicine> findMedicineByMname(String mname);
	public void insertMedicine(Medicine medicine);
	public void deleteMedicineByMno(String mno);
	public void updateMedicineByMno(Medicine medicine);

}
