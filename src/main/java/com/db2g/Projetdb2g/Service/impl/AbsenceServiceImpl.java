package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.AbsenceRepository;
import com.db2g.Projetdb2g.Service.AbsenceService;
import com.db2g.Projetdb2g.model.Absence;

/**
 * @author ibrahima
 *
 */
@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceRepository absenceRepository;
	@Override
	public List<Absence> listeAbsences() {
		// TODO Auto-generated method stub
		return absenceRepository.findAll();
	}

	@Override
	public Optional<Absence> detailAbsence(ObjectId id) {
		// TODO Auto-generated method stub
		return absenceRepository.findById(id);
	}

	@Override
	public void sauvegardeAbsence(Absence absence) {
		// TODO Auto-generated method stub
		absenceRepository.save(absence);
	}

	@Override
	public void supprimerAbsence(ObjectId id) {
		// TODO Auto-generated method stub
		absenceRepository.deleteById(id);
	}

	@Override
	public Absence get(ObjectId id) {
		// TODO Auto-generated method stub
		return absenceRepository.findById(id).get();
	}
	
	
}
