/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

/**
 * Klasa UtakmicaPK je pomocna klasa klase Utakmica i predstavlja njen slozeni primarni kljuc.
 * Sadrzi:
 * id utakmice
 * id kola
 * id lige
 * @author Boban Todic
 */
@Component
@Embeddable
public class UtakmicaPK {

    /**
     * Id utakmice kao long
     */
    @Column(name = "utakmicaid")
    private long utakmicaId;
    /**
     * Id kola kao long
     */
    @Column(name = "koloid")
    private long koloId;
    /**
     * Id lige kao long
     */
    @Column(name = "ligaid")
    private long ligaId;

    /**
     * Podrazumevani konstruktor
     */
    public UtakmicaPK() {
    }

    /**
     * Konstruktor koji kao parametre prima id utakmice, id kola i id lige
     * @param utakmicaId Id utakmice tipa long
     * @param koloId Id kola tipa long
     * @param ligaId Id lige tipa long
     */
    public UtakmicaPK(long utakmicaId, long koloId, long ligaId) {
        this.utakmicaId = utakmicaId;
        this.koloId = koloId;
        this.ligaId = ligaId;
    }

    /**
     * Vraca id utakmice kao long
     * @return Id utakmice
     */
    public long getUtakmicaId() {
        return utakmicaId;
    }

    /**
     * Postavlja id utakmice na vrednost proslejdenog parametra
     * @param utakmicaId Id utakmice tipa long
     */
    public void setUtakmicaId(long utakmicaId) {
        this.utakmicaId = utakmicaId;
    }

    /**
     * Vraca id kola tipa long
     * @return Id kola
     */
    public long getKoloId() {
        return koloId;
    }

    /**
     * Postavlja id kola na vrednost prosledjenog parametra
     * @param koloId Id kolo tipa long
     */
    public void setKoloId(long koloId) {
        this.koloId = koloId;
    }

    /**
     * Vraca id lige tipa long
     * @return Id lige
     */
    public long getLigaId() {
        return ligaId;
    }

    /**
     * Postavlja id lige na vrednost prosledjenog parametra
     * @param ligaId Id lige tipa long
     */
    public void setLigaId(long ligaId) {
        this.ligaId = ligaId;
    }

  

    @Override
	public int hashCode() {
		return Objects.hash(koloId, ligaId, utakmicaId);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat kojim se poredi
         * @return true - ako objekti imaju istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju iste vrednosti id utakmice, id kola i id lige
         * false - u svim ostalim slucajevima
         */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtakmicaPK other = (UtakmicaPK) obj;
		return koloId == other.koloId && ligaId == other.ligaId && utakmicaId == other.utakmicaId;
	}

        /**
         * Vraca String reprezentaciju objekta UtakmicaPk sa svojim atributima
         * @return Objekat UtakmicaPK kao String
         */
	@Override
	public String toString() {
		return "UtakmicaPK [utakmicaId=" + utakmicaId + ", koloId=" + koloId + ", ligaId=" + ligaId + "]";
	}

	
    
}
