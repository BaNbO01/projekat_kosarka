package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Pozicija;

/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Igraci
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface IgraciRepository extends JpaRepository<Igraci, Long> {

    /**
     * Vraca listu igraca prema unetim kriterijumima
     * @param ime Ime igraca
     * @param prezime Prezime igraca
     * @param visina Visina igraca
     * @param pozicija Pozicija igraca
     * @param broj Broj na dresu igraca
     * @return lista igraca
     * 
     */
    @Query(name = "Igraci.findAllByCriteria")
    List<Igraci> findAllByCriteria(@Param("ime") String ime,
            @Param("prezime") String prezime,
            @Param("visina") Double visina,
            @Param("pozicija") Pozicija pozicija,
            @Param("broj") Integer broj
    );
}
