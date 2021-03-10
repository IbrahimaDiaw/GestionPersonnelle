package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.CongesRepository;
import com.db2g.Projetdb2g.Service.CongesService;
import com.db2g.Projetdb2g.model.Conges;

/**
 * @author ibrahima
 *
 */
@Service
public class CongesServiceImpl implements CongesService {
	
	@Autowired
	private CongesRepository congesRepository;

	@Override
	public List<Conges> listeConges() {
		// TODO Auto-generated method stub
		return congesRepository.findAll();
	}

	@Override
	public Optional<Conges> detailConges(ObjectId id) {
		// TODO Auto-generated method stub
		return congesRepository.findById(id);
	}

	@Override
	public void sauvegardeConges(Conges conges) {
		// TODO Auto-generated method stub
		congesRepository.save(conges);
	}

	@Override
	public void supprimerConges(ObjectId id) {
		// TODO Auto-generated method stub
		congesRepository.deleteById(id);
	}

	@Override
	public Conges get(ObjectId id) {
		// TODO Auto-generated method stub
		return congesRepository.findById(id).get();
	}

}
