package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.FormationRepository;
import com.db2g.Projetdb2g.Service.FormationService;
import com.db2g.Projetdb2g.model.Formation;

@Service
public class FormationServiceimpl implements FormationService{


	@Autowired
	private FormationRepository FormationRepository;
	
	@Override
	public List<Formation> listeFormation() {
		// TODO Auto-generated method stub
		return FormationRepository.findAll();
	}

	@Override
	public Optional<Formation> detailFormation(ObjectId id) {
		// TODO Auto-generated method stub
		return FormationRepository.findById(id);
	}

	@Override
	public void sauvegardeFormation(Formation formation) {
		// TODO Auto-generated method stub
		FormationRepository.save(formation);
		
	}

	@Override
	public void supprimerFormation(ObjectId id) {
		// TODO Auto-generated method stub
		FormationRepository.deleteById(id);
		
	}

	@Override
	public Formation get(ObjectId id) {
		// TODO Auto-generated method stub
		return FormationRepository.findById(id).get();
	}

}
