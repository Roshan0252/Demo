package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Patient;
import com.nit.repo.IPatientRepo;
@Service("patientService")
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo patientRepo;
	@Override
	public Patient savePatient(Patient patient) {
		Patient save = patientRepo.save(patient);
		return save;
	}
	@Override
	public Patient getById(int pId) {
		Optional<Patient> findById = patientRepo.findById(pId);
		
		return findById.orElseThrow(()->new IllegalArgumentException("Invalid Patiend Id"));
	}
	
	@Override
	public List<Patient> getAllById(List<Integer> pId) {
		List<Patient> allById = patientRepo.findAllById(pId);
		return allById;
	}
	@Override
	public List<Patient> getAllByProblem(String pId) {
		List<Patient> list = patientRepo.findByProblemEqualsIgnoreCase(pId);
		return list;
	}

	@Override
	public List<Patient> getAll() {
		List<Patient> findAll = patientRepo.findAll();
		return findAll;
	}
	
	@Override
	public long getTotalCount() {
		
		return patientRepo.count();
	}
	
	@Override
	public boolean ExistById(int id) {
		boolean existsById = patientRepo.existsById(id);
		return existsById;
	}
	@SuppressWarnings("deprecation")
	@Override
	public String deleteById(int id) {
		 Optional<Patient> findById = patientRepo.findById(id);
		 //System.out.println(findById);
		if(findById.isEmpty())return "No Data Prensent for Patient id:"+id;
		else
		{
			patientRepo.deleteById(id);
			return "Data Deleted With Patient id:"+id;
		}
		
	}
	@Override
	public String updatePatient(Patient p) {
		Optional<Patient> findById = patientRepo.findById(p.getPId());
		if(!findById.isEmpty())
		{
			Patient save = patientRepo.save(p);
			return "Patient Data Updated with id:"+save.getPId();
		}
		
		return "No data Present";
	}
}
