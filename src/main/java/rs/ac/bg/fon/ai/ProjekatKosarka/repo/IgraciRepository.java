package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Pozicija;

public interface IgraciRepository extends JpaRepository<Igraci, Long> {

    @Query(name = "Igraci.findAllByCriteria")
    List<Igraci> findAllByCriteria(@Param("ime") String ime,
            @Param("prezime") String prezime,
            @Param("visina") Double visina,
            @Param("pozicija") Pozicija pozicija,
            @Param("broj") Integer broj
    );
}
