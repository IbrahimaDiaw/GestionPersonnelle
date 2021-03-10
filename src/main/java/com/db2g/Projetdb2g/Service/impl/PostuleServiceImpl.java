package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.PostuleRepository;
import com.db2g.Projetdb2g.Service.PostuleService;
import com.db2g.Projetdb2g.model.Postule;

@Service
public class PostuleServiceImpl implements PostuleService{

	@Autowired
	PostuleRepository repo;

	@Override
	public List<Postule> listePostule() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Postule> detailPostule(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void sauvegardePostule(Postule postule) {
		// TODO Auto-generated method stub
		this.repo.save(postule);
	}

	@Override
	public void supprimerPostule(Long id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
	}

	@Override
	public Postule editPost(Long id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}
	
}
