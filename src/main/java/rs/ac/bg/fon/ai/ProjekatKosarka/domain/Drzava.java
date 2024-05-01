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
 * Klasa Drzava koja sadrzi naziv i svoj id.
 * 
 * Koristi se da bi se izrazilo iz koje zemlje dolazi neki igrac ili grad
 * gde se odigravala odredjena utakmica, iz koje zemlje je neka liga.
 * 
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d"),
    @NamedQuery(name = "Drzava.findByDrzavaId", query = "SELECT d FROM Drzava d WHERE d.drzavaId = :drzavaId"),
    @NamedQuery(name = "Drzava.findByNaziv", query = "SELECT d FROM Drzava d WHERE d.naziv = :naziv")})
public class Drzava {

    /**
     * Id drzave tipa Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drzavaid")
    private Long drzavaId;
    /**
     * Naziv drzave tipa String
     */
    @Column(name = "naziv")
    private String naziv;

    /**
     * Podrazumevani konstruktor klase Drzava
     */
    public Drzava() {
    }
    

    /**
     * Konstruktor koji kao parametar prima id drzave
     * @param drzavaId  Id drzave
     */
    public Drzava(Long drzavaId) {
        this.drzavaId = drzavaId;
    }

    /**
     * Vraca id drzave tipa Long
     * @return Id drzave 
     */
    public Long getDrzavaId() {
        return drzavaId;
    }

    /**
     * Postavlja id drzave na unetu vrednost parametra
     * @param drzavaId Id drzave
     */
    public void setDrzavaId(Long drzavaId) {
        this.drzavaId = drzavaId;
    }

    /**
     * Vraca naziv drzave kao String
     * @return Naziv drzave
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv drzave na unetu vrednost
     * @param naziv Naziv drzave
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    

  

  
    @Override
	public int hashCode() {
		return Objects.hash(drzavaId);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju, 
         * ako su objekti iste klase i imaju isti id
         * false - u svakom drugom slucaju
         */
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

        /**
         * Vraca naziv zemllje kao String
         * @return Naziv zemlje 
         */
	@Override
	public String toString() {
		return  naziv ;
	}

	
    
}

