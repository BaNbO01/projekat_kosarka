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
 * Klasa Liga predstavlja kosarkasku ligu za koju se beleze rezultati utakmica, koja ima odredjeni broj odredjenih kola i
 * preko koje moze da se vidi stanje tabele
 * Sadrzi id lige, naziv same lige i drzavu iz koje liga dolazi
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "liga")
@NamedQueries({
    @NamedQuery(name = "Liga.findAll", query = "SELECT l FROM Liga l"),
    @NamedQuery(name = "Liga.findByLigaId", query = "SELECT l FROM Liga l WHERE l.ligaId = :ligaId"),
    @NamedQuery(name = "Liga.findByNaziv", query = "SELECT l FROM Liga l WHERE l.naziv = :naziv")})
public class Liga {

    /**
     * Id lige tipa Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ligaid")
    private Long ligaId;
    
    /**
     * Naziv lige tipa String
     */
    @Column(name = "naziv")
    private String naziv;
    
    /**
     * Drzava iz koje dolazi liga
     */
    @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")
    @ManyToOne
    private Drzava drzavaId;

    /**
     * Podrazumevani konstruktor
     */
    public Liga() {
    }

    /**
     * Konstruktor koji prihvata id lige kao parametar
     * @param ligaId Id lige tipa Long
     */
    public Liga(Long ligaId) {
        this.ligaId = ligaId;
    }

    /**
     * Vraca id lige kao Long
     * @return Id lige
     */
    public Long getLigaId() {
        return ligaId;
    }

    /**
     * Postavlja id lige na vrednost prosledjenog parametra
     * @param ligaId Id lige tipa Long
     */
    public void setLigaId(Long ligaId) {
        this.ligaId = ligaId;
    }

    /**
     * Vraca naziv lige tipa String
     * @return Naziv lige
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Postavlja naziv lige na vrednost prosledjenog parametra
     * @param naziv Naziv lige
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    /**
     * Vraca tip Drzava i predstavlja drzavu iz koje dolazi liga
     * @return Drzava iz koje dolazi liga
     */
    public Drzava getDrzavaId() {
        return drzavaId;
    }

    /**
     * Postavlja drzavu iz koje dolazi liga na vrednost unetog parametra
     * @param drzavaId Objekat klase Drzava
     */
    public void setDrzavaId(Drzava drzavaId) {
        this.drzavaId = drzavaId;
    }

    @Override
	public int hashCode() {
		return Objects.hash(ligaId);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta pokazuju na istu memorijsku lokaciju
         * ili ako su objekti iste klase i imaju istu vrednost id lige
         */
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

        /**
         * Vraca String reprezentaciju objekta klase Liga sa nazivom lige i drzavom
         * @return Objekat Liga kao String
         */
	@Override
	public String toString() {
		return  naziv + " " + drzavaId;
	}

	

	
    
}
