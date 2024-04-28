package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;

public interface KoloRepository extends  JpaRepository<Kolo, KoloPK> {

	@Query(name = "Kolo.findByLigaId")
	public List<Kolo> findAllFeaturesByLeage(@Param("ligaId") Long ligaid);
	
}
