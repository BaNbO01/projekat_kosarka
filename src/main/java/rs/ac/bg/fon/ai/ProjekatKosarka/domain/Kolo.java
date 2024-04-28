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
 *
 * @author Korisnik
 */
@Component
@Entity
@Table(name = "kolo")
@NamedQueries({
    @NamedQuery(name = "Kolo.findAll", query = "SELECT k FROM Kolo k"),
    @NamedQuery(name = "Kolo.findByKoloId", query = "SELECT k FROM Kolo k WHERE k.koloPK.koloId = :koloId"),
    @NamedQuery(name = "Kolo.findByLigaId", query = "SELECT k FROM Kolo k WHERE k.koloPK.ligaId = :ligaId")})
public class Kolo  {

    @EmbeddedId
    protected KoloPK koloPK;
    @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)
    @ManyToOne
    private Liga liga;
    

    public Kolo() {
    }

    public Kolo(KoloPK koloPK) {
        this.koloPK = koloPK;
    }


    public KoloPK getKoloPK() {
        return koloPK;
    }

    public void setKoloPK(KoloPK koloPK) {
        this.koloPK = koloPK;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

  
   

    @Override
	public int hashCode() {
		return Objects.hash(koloPK);
	}

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

	@Override
	public String toString() {
		return koloPK.getKoloId()+ ". kolo";
	}

	
    
}
