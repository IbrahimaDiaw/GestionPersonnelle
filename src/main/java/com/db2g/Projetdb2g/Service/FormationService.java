package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.db2g.Projetdb2g.model.Formation;

public interface FormationService {

	public Optional<Formation> detailFormation(ObjectId id);
	public void sauvegardeFormation(Formation formation);
	public void supprimerFormation(ObjectId id);
	public Formation get(ObjectId id);
	List<Formation> listeFormation();
}
