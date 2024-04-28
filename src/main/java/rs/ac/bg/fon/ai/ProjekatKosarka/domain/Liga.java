/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "liga")
@NamedQueries({
    @NamedQuery(name = "Liga.findAll", query = "SELECT l FROM Liga l"),
    @NamedQuery(name = "Liga.findByLigaId", query = "SELECT l FROM Liga l WHERE l.ligaId = :ligaId"),
    @NamedQuery(name = "Liga.findByNaziv", query = "SELECT l FROM Liga l WHERE l.naziv = :naziv")})
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ligaid")
    private Long ligaId;
    @Column(name = "naziv")
    private String naziv;
    @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")
    @ManyToOne
    private Drzava drzavaId;

    public Liga() {
    }

    public Liga(Long ligaId) {
        this.ligaId = ligaId;
    }

    public Long getLigaId() {
        return ligaId;
    }

    public void setLigaId(Long ligaId) {
        this.ligaId = ligaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public Drzava getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(Drzava drzavaId) {
        this.drzavaId = drzavaId;
    }

    @Override
	public int hashCode() {
		return Objects.hash(ligaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liga other = (Liga) obj;
		return Objects.equals(ligaId, other.ligaId);
	}

	@Override
	public String toString() {
		return  naziv + " " + drzavaId;
	}

	

	
    
}
