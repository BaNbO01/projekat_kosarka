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
 * Klasa TabelaPK je pomocna klasa za klasu Tabela i sluzi da cuva podatke o primarnom kljucu
 * Sadrzi id lige i id tabele
 * @author Boban Todic
 */
@Component
@Embeddable
public class TabelaPK {


    /**
     * Id tabele tipa long
     */
    @Column(name = "tabelaid")
    private long tabelaid;

    /**
     * Id lige tipa long
     */
    @Column(name = "ligaid")
    private long ligaid;

    /**
     * Podrazumevani konstruktor klase TabelaPK
     */
    public TabelaPK() {
    }

    /**
     * Konstruktor koji kao parametre prima id tabele i id lige
     * @param tabelaid Id tabele tipa long
     * @param ligaid Id lige tipa long
     */
    public TabelaPK(long tabelaid, long ligaid) {
        this.tabelaid = tabelaid;
        this.ligaid = ligaid;
    }

    /**
     * Vraca id tabele kao long
     * @return Id tabele
     */
    public long getTabelaid() {
        return tabelaid;
    }
    
    /**
     * Postavlja id tabele na vrednost prosledjenog parametra
     * @param tabelaid Id tabele kao long
     */
    public void setTabelaid(long tabelaid) {
        this.tabelaid = tabelaid;
    }

    /**
     * Vraca id lige kao long
     * @return 
     */
    public long getLigaid() {
        return ligaid;
    }

    /**
     * Postavlja id lige na vrednost prosledjenog parametrea
     * @param ligaid Id lige tipa long
     */
    public void setLigaid(long ligaid) {
        this.ligaid = ligaid;
    }

 

   

    @Override
	public int hashCode() {
		return Objects.hash(ligaid, tabelaid);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta pokazuju na istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju iste vrednosti id tabele i id lige
         */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaPK other = (TabelaPK) obj;
		return ligaid == other.ligaid && tabelaid == other.tabelaid;
	}

        /**
         * Vraca String reprezentaciju objekta TabelaPK sa svojim atributima
         * @return Objekat TabelaPK kao String
         */
	@Override
	public String toString() {
		return "TabelaPK [tabelaid=" + tabelaid + ", ligaid=" + ligaid + "]";
	}

	
    
}
