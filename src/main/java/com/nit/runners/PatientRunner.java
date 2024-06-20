package com.nit.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.Patient;
import com.nit.service.IPatientService;

@Component
public class PatientRunner implements CommandLineRunner{

	@Autowired
	private IPatientService patientService;
	@Autowired
	private Patient patient;
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(patient);
		//Patient p1 = patientService.savePatient(patient);
		//System.out.println(p1);
		//Patient byId = patientService.getById(1004);
		//System.out.println(byId);
		
		/*List<Patient> byId = patientService.getAllById(Arrays.asList(1001,1002,1004));
		for(Patient p:byId)
		{
			System.out.println(p);
		}*/
		/*	List<Patient> byId = patientService.getAllByProblem("Fever");
			for(Patient p:byId)
			{
				System.out.println(p);
			}*/
		patientService.getAll().forEach(System.out::println);
		
		long count = patientService.getTotalCount();
		System.out.println("Total Patient Count:"+count);
		
		boolean existById = patientService.ExistById(1001);
		System.out.println("Id Exist::"+existById);
		
		System.out.println("*****************************");
		
		String deleteById = patientService.deleteById(1010);
		
		System.out.println(deleteById);
		
		patient.setPId(1010);
		String patient2 = patientService.updatePatient(patient);
		System.out.println(patient2);
		
	}

}
