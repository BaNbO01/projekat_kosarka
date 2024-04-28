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
 * @author Korisnik
 */
@Component
@Embeddable
public class TabelaPK {


    @Column(name = "tabelaid")
    private long tabelaid;

    @Column(name = "ligaid")
    private long ligaid;

    public TabelaPK() {
    }

    public TabelaPK(long tabelaid, long ligaid) {
        this.tabelaid = tabelaid;
        this.ligaid = ligaid;
    }

    public long getTabelaid() {
        return tabelaid;
    }

    public void setTabelaid(long tabelaid) {
        this.tabelaid = tabelaid;
    }

    public long getLigaid() {
        return ligaid;
    }

    public void setLigaid(long ligaid) {
        this.ligaid = ligaid;
    }

 

   

    @Override
	public int hashCode() {
		return Objects.hash(ligaid, tabelaid);
	}

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

	@Override
	public String toString() {
		return "TabelaPK [tabelaid=" + tabelaid + ", ligaid=" + ligaid + "]";
	}

	
    
}
