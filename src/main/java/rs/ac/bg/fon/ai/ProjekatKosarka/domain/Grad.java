package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "grad")
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
    @NamedQuery(name = "Grad.findByGradID", query = "SELECT g FROM Grad g WHERE g.gradPK.gradID = :gradID"),
    @NamedQuery(name = "Grad.findByDrzavaID", query = "SELECT g FROM Grad g WHERE g.gradPK.drzavaID = :drzavaID"),
    @NamedQuery(name = "Grad.findByNaziv", query = "SELECT g FROM Grad g WHERE g.naziv = :naziv")})
public class Grad {

	@EmbeddedId
	private GradPK gradPK;
	
	 @JoinColumn(name = "drzavaID", referencedColumnName = "drzavaID",insertable=false, updatable=false)
	 @ManyToOne	
	private Drzava drzava;
	
	 @Column(name = "naziv")
	    private String naziv;

	 
	 public Grad() {
	    }
	 
	 
	 
	public GradPK getGradPK() {
		return gradPK;
	}

	public void setGradPK(GradPK gradPK) {
		this.gradPK = gradPK;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return  naziv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gradPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grad other = (Grad) obj;
		return Objects.equals(gradPK, other.gradPK);
	}
	 
	 
}
