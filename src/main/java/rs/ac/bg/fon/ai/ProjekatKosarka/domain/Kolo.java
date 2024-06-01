/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *Klasa Kolo prestavlja jedno kolo odredjene lige klase Liga
 * Sadrzi ligu na koju se kolo odnosi i id kola
 * 
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "kolo")
@NamedQueries({
    @NamedQuery(name = "Kolo.findAll", query = "SELECT k FROM Kolo k"),
    @NamedQuery(name = "Kolo.findByKoloId", query = "SELECT k FROM Kolo k WHERE k.koloPK.koloId = :koloId"),
    @NamedQuery(name = "Kolo.findByLigaId", query = "SELECT k FROM Kolo k WHERE k.koloPK.ligaId = :ligaId")})
public class Kolo  {

    /**
     * Predstavlja slozeni primatni kljuc kola tipa KoloPK
     */
    @EmbeddedId
    protected KoloPK koloPK;
    
    /**
     * Liga na koju se kolo odnosi
     */
    @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)
    @ManyToOne
    private Liga liga;
    

    /**
     * Podrazumevani konstruktor klase Kolo
     */
    public Kolo() {
    }

    
    /**
     * Konstruktor koji prima slozeni primarni kljuc kao parametar
     * @param koloPK Objekat tipa KoloPk
     */
    public Kolo(KoloPK koloPK) {
        this.koloPK = koloPK;
    }


    /**
     * Vraca slozeni primarni kljuc kao tip KoloPK
     * @return primarni kljuc kao objekat KoloPK
     */
    public KoloPK getKoloPK() {
        return koloPK;
    }

    /**
     * Postavlja primarni kljuc kola na vrednost prosledjenog parametra
     * @param koloPK Objekat tipa KoloPK
     */
    public void setKoloPK(KoloPK koloPK) {
        this.koloPK = koloPK;
    }

    /**
     * Vraca ligu na koju se kolo odnosi kao tip Liga
     * @return Ligu kola
     */
    public Liga getLiga() {
        return liga;
    }

    /**
     * Postavlja ligu kola na vrednost prosledjenog parametra
     * Liga ne sme biti null
     * @param liga Objekat tipa Liga
     * @throws java.lang.IllegalArgumentException ukoliko je liga null
     */
    public void setLiga(Liga liga) {
    	if(liga==null) 
    		throw new IllegalArgumentException("Liga ne sme da bude null");
        this.liga = liga;
    }

  
   

    @Override
	public int hashCode() {
		return Objects.hash(koloPK);
	}

        
        /**
         * Proverava da li su dva objekata jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta pokazuju na istu memorisjku lokaciju,
         * ili ako su iste klase i imaju istu vrednost primarnog kljuca (id lige i id kola)
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
		Kolo other = (Kolo) obj;
		return Objects.equals(koloPK, other.koloPK);
	}

        /**
         * Vraca id kola kao String
         * @return Id kola tipa String
         */
	@Override
	public String toString() {
		return koloPK.getKoloId()+ ". kolo";
	}

	
    
}
