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

/**
 * Klasa Grad koja predstavlja slab objekat klase Drzava.
 * Koristi se da bi se opisalo iz kog grada dolazi neki tim, i u kom gradu se odigravaju odredjene utakmice
 * 
 * 
 * @author Boban Todic
 */

@Component
@Entity
@Table(name = "grad")
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
    @NamedQuery(name = "Grad.findByGradID", query = "SELECT g FROM Grad g WHERE g.gradPK.gradID = :gradID"),
    @NamedQuery(name = "Grad.findByDrzavaID", query = "SELECT g FROM Grad g WHERE g.gradPK.drzavaID = :drzavaID"),
    @NamedQuery(name = "Grad.findByNaziv", query = "SELECT g FROM Grad g WHERE g.naziv = :naziv")})

public class Grad {

    
     /**
         * Slozeni primarni kljuc za Grad
         */
	@EmbeddedId
	private GradPK gradPK;
	
        
        /**
          * Drzava iz koje dolazi grad
          */
	 @JoinColumn(name = "drzavaID", referencedColumnName = "drzavaID",insertable=false, updatable=false)
	 @ManyToOne	
	private Drzava drzava;
	
         
         
         /**
          * Naziv grada
          */
	 @Column(name = "naziv")
	    private String naziv;

	 /**
          * Podrazumevani konstruktor klase Grad
          */
	 public Grad() {
	    }
	 
	 
	 /**
          * Vraca slozeni primarni kljuc tipa GradPK
          * 
          * @return Slozeni id tipa GradPK
          */
	public GradPK getGradPK() {
		return gradPK;
	}

        /**
         * Postavlja vrednost slozenog primarnog kljuca na vrednost parametra
         * @param gradPK Slozeni kljuc tipa GradPk
         */
	public void setGradPK(GradPK gradPK) {
		this.gradPK = gradPK;
	}

        /**
         * Vraca drzavu iz koje je grad
         * @return Drzava grada
         */
	public Drzava getDrzava() {
		return drzava;
	}

        /**
         * Postavlja drzavu za grad na vrednost prosledjenog parametra
         * @param drzava Objekat klase Drzava
         */
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

        /**
         * Vraca naziv grada tipa String
         * @return Naziv grada
         */
	public String getNaziv() {
		return naziv;
	}

        /**
         * Postavlja naziv grada na unetu vrednost parametra
         * @param naziv Naziv grada
         */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

        /**
         * Vraca naziv grada tipa String
         * @return Naziv grada
         */
	@Override
	public String toString() {
		return  naziv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gradPK);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju istu vrednost primarnog kljuca
         * (id grada i id drzave),
         * false - u ostalim slucajevima
         
         */
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
