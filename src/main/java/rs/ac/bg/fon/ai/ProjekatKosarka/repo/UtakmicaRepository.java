package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.UtakmicaPK;

public interface UtakmicaRepository extends  JpaRepository<Utakmica, UtakmicaPK>  {

	@Query(name = "Utakmica.findByKolo")
	public List<Utakmica> findAllMatchesInFixture(@Param("koloId") Long koloId,@Param("ligaId") Long ligaId);
	
}
