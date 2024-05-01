package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Grad;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.GradPK;


/**
 * Interfejs koji omogucava CRUD operacije nad domenskim modelom Grad
 * Nasledjuje Spring Data JPA interfejs JpaRepository i tako automatski ima metode za rad sa klasicnim crud operacijama
 * @author Boban Todic
 */
public interface GradRepository extends  JpaRepository<Grad, GradPK> {

}
