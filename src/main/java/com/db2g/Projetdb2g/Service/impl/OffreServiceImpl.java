/**
 * 
 */
package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.OffreRepository;
import com.db2g.Projetdb2g.Service.OffreService;
import com.db2g.Projetdb2g.model.Offre;

/**
 * @author ibrahima
 *
 */
@Service
public class OffreServiceImpl implements OffreService {

	@Autowired
	private OffreRepository offreRepository;
	
	@Override
	public List<Offre> listeOffre() {
		// TODO Auto-generated method stub
		return offreRepository.findAll();
	}

	@Override
	public Optional<Offre> detailOffre(Long id) {
		// TODO Auto-generated method stub
		return offreRepository.findById(id);
	}

	@Override
	public void sauvegardeOffre(Offre offre) {
		// TODO Auto-generated method stub
        offreRepository.save(offre);
	}

	@Override
	public void supprimerOffre(Long id) {
		// TODO Auto-generated method stub
		offreRepository.deleteById(id);

	}

	@Override
	public Offre get(Long id) {
		// TODO Auto-generated method stub
		return offreRepository.findById(id).get();
	}

}
