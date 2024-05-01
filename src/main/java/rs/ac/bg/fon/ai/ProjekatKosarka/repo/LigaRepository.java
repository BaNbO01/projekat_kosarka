package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;


/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Liga
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface LigaRepository extends  JpaRepository<Liga, Long>  {

}
