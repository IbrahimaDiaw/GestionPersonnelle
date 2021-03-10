package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.model.Conges;
/**
 * @author ibrahima
 *
 */
@Service
public interface CongesService{
	
	public List<Conges> listeConges();
	public Optional<Conges> detailConges(ObjectId id);
	public void sauvegardeConges(Conges conges);
	public void supprimerConges(ObjectId id);
	public Conges get(ObjectId id);

}
