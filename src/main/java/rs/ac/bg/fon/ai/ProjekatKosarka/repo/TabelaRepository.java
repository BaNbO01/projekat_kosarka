package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.TabelaPK;

public interface TabelaRepository extends  JpaRepository<Tabela, TabelaPK>  {

    @Query(name="Tabela.findByLigaid")
    List<Tabela> returnLeagueStanding(@Param("ligaid") Long ligaid);
    
      @Query(name="Tabela.findAllByTimIdAndLeagueId")
    Tabela returnByTeamId(@Param("timid") Long teamId,@Param("ligaid") Long ligaId);
    
 }
