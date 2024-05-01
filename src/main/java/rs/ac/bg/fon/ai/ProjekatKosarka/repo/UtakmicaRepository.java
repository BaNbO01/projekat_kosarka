package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.UtakmicaPK;


/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Utakmica
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface UtakmicaRepository extends  JpaRepository<Utakmica, UtakmicaPK>  {

    /**
     * Vrati listu utakmica na osnovu parametra prosledjenih
     * @param koloId Id kola tipa Long
     * @param ligaId Id lige tipa Long
     * @return Lista objekata tipa Utakmica
     */
	@Query(name = "Utakmica.findByKolo")
	public List<Utakmica> findAllMatchesInFixture(@Param("koloId") Long koloId,@Param("ligaId") Long ligaId);
	
}
