/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * Klasa Utakmica predstavlja slab objekat klase Kolo.
 * Sluzi da belezi rezultat nekog kosarkaskog meca.
 * Pamti se koja dva tima igracu utakmicu, koji je rezultat bio, koje je kolo bilo odredjene lige.
 * To sve utice na stanje na tabeli.
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "utakmica")
@NamedQueries({
    @NamedQuery(name = "Utakmica.findAll", query = "SELECT u FROM Utakmica u"),
    @NamedQuery(name = "Utakmica.findByUtakmicaId", query = "SELECT u FROM Utakmica u WHERE u.utakmicaPK.utakmicaId = :utakmicaId"),
    @NamedQuery(name = "Utakmica.findByBrojKosevaTima1", query = "SELECT u FROM Utakmica u WHERE u.brojKosevaTima1 = :brojKosevaTima1"),
    @NamedQuery(name = "Utakmica.findByBrojKosevaTima2", query = "SELECT u FROM Utakmica u WHERE u.brojKosevaTima2 = :brojKosevaTima2"),
    @NamedQuery(name = "Utakmica.findByKolo", query = "SELECT u FROM Utakmica u WHERE u.utakmicaPK.koloId = :koloId AND u.utakmicaPK.ligaId = :ligaId"),
    @NamedQuery(name = "Utakmica.findByLigaId", query = "SELECT u FROM Utakmica u WHERE u.utakmicaPK.ligaId = :ligaId")})
public class Utakmica{

    /**
     * Slozeni primarni kljuc tipa UtakmicaPK
     */
    @EmbeddedId
    protected UtakmicaPK utakmicaPK;
    /**
     * Broj koseva domacina tipa Integer
     */
    @Column(name = "brojkosevatima1")
    private Integer brojKosevaTima1;
    /**
     * Broj koseva gosta tipa Integer
     */
    @Column(name = "brojkosevatima2")
    private Integer brojKosevaTima2;
    /**
     * Tim domacin
     */
    @JoinColumn(name = "timid1", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid1;
    /**
     * Tim gost
     */
    @JoinColumn(name = "timid2", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid2;
    /**
     * Kolo na koje se odnosi
     */
    @JoinColumns({
        @JoinColumn(name = "koloid", referencedColumnName = "koloid",insertable=false, updatable=false),
        @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)})
    @ManyToOne
    private Kolo kolo;

    /**
     * Podrazumevani konstruktor
     */
    public Utakmica() {
    }

    /**
     * Konstruktor koji kao parametar prima slozeni primarni kljuc kao objekat klase UtakmicaPK
     * @param utakmicaPK Objekat klase UtakmicaPK
     */
    public Utakmica(UtakmicaPK utakmicaPK) {
        this.utakmicaPK = utakmicaPK;
    }


    /**
     * Vraca primarni kljuc utakmice kao objekat klase UtakmicaPK
     * @return Objekat tipa UtakmicaPK
     */
    public UtakmicaPK getUtakmicaPK() {
        return utakmicaPK;
    }

    /**
     * Postavlja primarni kljuc utakmice na vrednost prosledjenog parametra
     * @param utakmicaPK Objekat klase UtakmicaPK
     */
    public void setUtakmicaPK(UtakmicaPK utakmicaPK) {
        this.utakmicaPK = utakmicaPK;
    }

    /**
     * Vraca broj postignutih poena domace ekipe tipa Integer
     * @return Broj poena domacina
     */
    public Integer getBrojKosevaTima1() {
        return brojKosevaTima1;
    }

    /**
     * Postavlja broj poena domace ekipe na vrednost prosledjenog parametra
     * @param brojKosevaTima1 Broj poena domacina tipa Integer
     */
    public void setBrojKosevaTima1(Integer brojKosevaTima1) {
        this.brojKosevaTima1 = brojKosevaTima1;
    }

    /**
     * Vraca broj poena gostujuce ekipe tipa Integer
     * @return Broj poena gosta
     */
    public Integer getBrojKosevaTima2() {
        return brojKosevaTima2;
    }

    /**
     * Postavlja broj poena gostujuce ekipe na vrednost prosledjenog parametra
     * @param brojKosevaTima2 Broj poena gostiju tipa Integer
     */
    public void setBrojKosevaTima2(Integer brojKosevaTima2) {
        this.brojKosevaTima2 = brojKosevaTima2;
    }

    /**
     * Vraca tim domacina kao objekat klase Tim
     * @return Tim domacin
     */
    public Tim getTimid1() {
        return timid1;
    }

    /**
     * Postavlja domaci tim na vrednost prosledjenog parametra
     * @param timid1 Objekat klase Tim
     */
    public void setTimid1(Tim timid1) {
        this.timid1 = timid1;
    }

    /**
     * Vraca tim gosta kao objekat klase Tim
     * @return Gostujuci tim
     */
    public Tim getTimid2() {
        return timid2;
    }

    /**
     * Postavlja gostujuci tim na vrednost prosledjenog parametra
     * @param timid2 Objekat klase Tim
     */
    public void setTimid2(Tim timid2) {
        this.timid2 = timid2;
    }

    /**
     * Vraca kolo na koje se odnosi utakmica kao objekat klase Kolo
     * @return Objekat klase Kolo na koju se odnosi utakmica
     */
    public Kolo getKolo() {
        return kolo;
    }

    /**
     * Postavlja kolo na vrednost prosledjenog parametra
     * @param kolo Objekat klase Kolo
     */
    public void setKolo(Kolo kolo) {
        this.kolo = kolo;
    }

    
    @Override
	public int hashCode() {
		return Objects.hash(utakmicaPK);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju istu vrednost slozenog primarnog kljuca (id utakmice,id kola,id lige)
         */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utakmica other = (Utakmica) obj;
		return Objects.equals(utakmicaPK, other.utakmicaPK);
	}

        /**
         * Vraca String reprezentaciju objekta klase Utakmica sa svojim atributima
         * @return Objekat Utakmica kao String
         */
	@Override
	public String toString() {
		return "Utakmica [utakmicaPK=" + utakmicaPK + ", brojKosevaTima1=" + brojKosevaTima1 + ", brojKosevaTima2="
				+ brojKosevaTima2 + ", timid1=" + timid1 + ", timid2=" + timid2 + ", kolo=" + kolo + "]";
	}

		
    
}
