package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;


/**
 *
 * @author Korisnik
 */
@Component
@Entity
@Table(name = "drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d"),
    @NamedQuery(name = "Drzava.findByDrzavaId", query = "SELECT d FROM Drzava d WHERE d.drzavaId = :drzavaId"),
    @NamedQuery(name = "Drzava.findByNaziv", query = "SELECT d FROM Drzava d WHERE d.naziv = :naziv")})
public class Drzava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drzavaid")
    private Long drzavaId;
    @Column(name = "naziv")
    private String naziv;

    public Drzava() {
    }
    

    public Drzava(Long drzavaId) {
        this.drzavaId = drzavaId;
    }

    public Long getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(Long drzavaId) {
        this.drzavaId = drzavaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    

  

  
    @Override
	public int hashCode() {
		return Objects.hash(drzavaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drzava other = (Drzava) obj;
		return Objects.equals(drzavaId, other.drzavaId);
	}

	@Override
	public String toString() {
		return  naziv ;
	}

	
    
}

