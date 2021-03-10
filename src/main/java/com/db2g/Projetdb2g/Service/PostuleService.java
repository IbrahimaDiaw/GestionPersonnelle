package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import com.db2g.Projetdb2g.model.Postule;


public interface PostuleService {

	public List<Postule> listePostule();
	public Postule editPost(Long id);
	public Optional<Postule> detailPostule(Long id);
	public void sauvegardePostule(Postule postule);
	public void supprimerPostule(Long id);
}
