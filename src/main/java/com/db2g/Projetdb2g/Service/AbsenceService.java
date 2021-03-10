package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.model.Absence;

/**
 * @author ibrahima
 *
 */
@Service
public interface AbsenceService{
	
	public List<Absence> listeAbsences();
	public Optional<Absence> detailAbsence(ObjectId id);
	public void sauvegardeAbsence(Absence absence);
	public void supprimerAbsence(ObjectId id);
	public Absence get(ObjectId id);

}
