/**
 * 
 */
package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import com.db2g.Projetdb2g.model.Offre;

/**
 * @author ibrahima
 *
 */
public interface OffreService {
	
	public List<Offre> listeOffre();
	public Optional<Offre> detailOffre(Long id);
	public void sauvegardeOffre(Offre offre);
	public void supprimerOffre(Long id);
	public Offre get(Long id);

}
