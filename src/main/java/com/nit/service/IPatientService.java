package com.nit.service;

import java.util.List;

import com.nit.model.Patient;

public interface IPatientService {

	public Patient savePatient(Patient patient);
	public Patient getById(int pId);
	public List<Patient> getAllById(List<Integer> pId);
	public List<Patient> getAllByProblem(String pId);
	
	public List<Patient> getAll();
	
	public long getTotalCount();
	
	public boolean ExistById(int id);
	
	public String deleteById(int id);
	
	public String updatePatient(Patient p);
	
	
}
