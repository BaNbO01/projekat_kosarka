package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.TabelaPK;


/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Tabela
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface TabelaRepository extends  JpaRepository<Tabela, TabelaPK>  {

    /**
     * Vraca listu objekata Tabela na osnovu id lige
     * @param ligaid Id lige tipa Long
     * @return List objekata tipa Tabela
     */
    @Query(name="Tabela.findByLigaid")
    List<Tabela> returnLeagueStanding(@Param("ligaid") Long ligaid);
    
    /**
     * Vraca objekat Tabela na osnovu id lige i id tima
     * @param teamId Id tima tipa Long
     * @param ligaId Id lige tipa Long
     * @return objekat klase Tabela
     */
      @Query(name="Tabela.findAllByTimIdAndLeagueId")
    Tabela returnByTeamId(@Param("timid") Long teamId,@Param("ligaid") Long ligaId);
    
 }
