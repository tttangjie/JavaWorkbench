package com.mybaties.mapper;

import java.util.List;

import com.po.Doctor;

public interface DoctorMapper {
	public Doctor findDoctorByDno(String Dno);
	public List<Doctor> findDoctorByDname(String  dname);
	public List<Doctor> findAllDoctor();
	public void insertDoctor(Doctor doctor);
	public void deleteDoctorByDno(String Dno);
	public void updateDoctorByDno(Doctor doctor);

}
