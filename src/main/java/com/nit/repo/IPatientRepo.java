package com.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Integer>{

	public List<Patient> findByProblemEqualsIgnoreCase(String problem);
}
