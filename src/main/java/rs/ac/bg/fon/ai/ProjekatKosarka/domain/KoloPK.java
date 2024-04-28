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
@Embeddable
@Component
public class KoloPK {


    @Column(name = "koloid")
    private long koloId;
    @Column(name = "ligaid")
    private long ligaId;

    public KoloPK() {
    }

    public KoloPK(long koloId, long ligaId) {
        this.koloId = koloId;
        this.ligaId = ligaId;
    }

    public long getKoloId() {
        return koloId;
    }

    public void setKoloId(long koloId) {
        this.koloId = koloId;
    }

    public long getLigaId() {
        return ligaId;
    }

    public void setLigaId(long ligaId) {
        this.ligaId = ligaId;
    }

   

	@Override
	public int hashCode() {
		return Objects.hash(koloId, ligaId);
	}

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

	@Override
	public String toString() {
		return "KoloPK [koloId=" + koloId + ", ligaId=" + ligaId + "]";
	}

    
    
}
