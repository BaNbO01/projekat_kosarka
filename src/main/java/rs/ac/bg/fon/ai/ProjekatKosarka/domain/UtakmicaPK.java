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
public class UtakmicaPK {

    @Column(name = "utakmicaid")
    private long utakmicaId;
    @Column(name = "koloid")
    private long koloId;
    @Column(name = "ligaid")
    private long ligaId;

    public UtakmicaPK() {
    }

    public UtakmicaPK(long utakmicaId, long koloId, long ligaId) {
        this.utakmicaId = utakmicaId;
        this.koloId = koloId;
        this.ligaId = ligaId;
    }

    public long getUtakmicaId() {
        return utakmicaId;
    }

    public void setUtakmicaId(long utakmicaId) {
        this.utakmicaId = utakmicaId;
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
		return Objects.hash(koloId, ligaId, utakmicaId);
	}

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

	@Override
	public String toString() {
		return "UtakmicaPK [utakmicaId=" + utakmicaId + ", koloId=" + koloId + ", ligaId=" + ligaId + "]";
	}

	
    
}
