package rs.ac.bg.fon.ai.ProjekatKosarka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Grad;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.GradPK;

public interface GradRepository extends  JpaRepository<Grad, GradPK> {

}
