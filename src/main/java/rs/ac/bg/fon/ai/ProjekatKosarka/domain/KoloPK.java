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
 *
 * Klasa KoloPK koja je pomocna klasa klase Kolo i sluzi da predstavi njen primarni kljuc
 * 
 * Sadrzi id lige i id kola
 * @author Boban Todic
 */
@Embeddable
@Component
public class KoloPK {


    /**
     * Id kola tipa long
     */
    @Column(name = "koloid")
    private long koloId;
    /**
     * Id lige tipa long
     */
    @Column(name = "ligaid")
    private long ligaId;

    
    /**
     * Podrazumevani konstruktor
     */
    public KoloPK() {
    }

    /**
     * Konstruktor koji prima id lige i id kola
     * @param koloId Id kola tipa long
     * @param ligaId Id lige tipa long
     */
    public KoloPK(long koloId, long ligaId) {
        this.koloId = koloId;
        this.ligaId = ligaId;
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
     * @param koloId Id kola tipa long
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
     * Postavlja id lige na vrednost podrazumevanog parametra
     * @param ligaId Id lige tipa long
     */
    public void setLigaId(long ligaId) {
        this.ligaId = ligaId;
    }

   

	@Override
	public int hashCode() {
		return Objects.hash(koloId, ligaId);
	}

        /**
         * Provera da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju,
         * ili ako su iste klase i imaju isti id lige i id kola
         */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoloPK other = (KoloPK) obj;
		return koloId == other.koloId && ligaId == other.ligaId;
	}

        
        /**
         * Vraca String reprezentaciju klase KoloPK sa svojim atributima
         * @return Objekat klase KoloPK kao String
         */
	@Override
	public String toString() {
		return "KoloPK [koloId=" + koloId + ", ligaId=" + ligaId + "]";
	}

    
    
}
