package com.mybaties.mapper;

import com.po.Patient;

public interface PatientMapper {
	public Patient findPatientByPno(String pno);
	public void insertPatient(Patient patient);
	public void deletePatientByPno(String pno);
	public void updatePatientByPno(Patient patient);

}
