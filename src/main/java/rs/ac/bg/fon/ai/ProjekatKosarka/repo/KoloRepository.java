package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;



/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Kolo
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface KoloRepository extends  JpaRepository<Kolo, KoloPK> {

    /**
     * Vraca sva kola na osnovu lige koja se prosledjue kao parametar
     * Metoda automatski implementirana preko springa sa anotacijama
     * @param ligaid Liga id tipa Long
     * @return Lista kola
     */
	@Query(name = "Kolo.findByLigaId")
	public List<Kolo> findAllFeaturesByLeage(@Param("ligaId") Long ligaid);
	
}
