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
 * @author Korisnik
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

    @EmbeddedId
    protected UtakmicaPK utakmicaPK;
    @Column(name = "brojkosevatima1")
    private Integer brojKosevaTima1;
    @Column(name = "brojkosevatima2")
    private Integer brojKosevaTima2;
    @JoinColumn(name = "timid1", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid1;
    @JoinColumn(name = "timid2", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid2;
    @JoinColumns({
        @JoinColumn(name = "koloid", referencedColumnName = "koloid",insertable=false, updatable=false),
        @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)})
    @ManyToOne
    private Kolo kolo;

    public Utakmica() {
    }

    public Utakmica(UtakmicaPK utakmicaPK) {
        this.utakmicaPK = utakmicaPK;
    }


    public UtakmicaPK getUtakmicaPK() {
        return utakmicaPK;
    }

    public void setUtakmicaPK(UtakmicaPK utakmicaPK) {
        this.utakmicaPK = utakmicaPK;
    }

    public Integer getBrojKosevaTima1() {
        return brojKosevaTima1;
    }

    public void setBrojKosevaTima1(Integer brojKosevaTima1) {
        this.brojKosevaTima1 = brojKosevaTima1;
    }

    public Integer getBrojKosevaTima2() {
        return brojKosevaTima2;
    }

    public void setBrojKosevaTima2(Integer brojKosevaTima2) {
        this.brojKosevaTima2 = brojKosevaTima2;
    }

    public Tim getTimid1() {
        return timid1;
    }

    public void setTimid1(Tim timid1) {
        this.timid1 = timid1;
    }

    public Tim getTimid2() {
        return timid2;
    }

    public void setTimid2(Tim timid2) {
        this.timid2 = timid2;
    }

    public Kolo getKolo() {
        return kolo;
    }

    public void setKolo(Kolo kolo) {
        this.kolo = kolo;
    }

    
    @Override
	public int hashCode() {
		return Objects.hash(utakmicaPK);
	}

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

	@Override
	public String toString() {
		return "Utakmica [utakmicaPK=" + utakmicaPK + ", brojKosevaTima1=" + brojKosevaTima1 + ", brojKosevaTima2="
				+ brojKosevaTima2 + ", timid1=" + timid1 + ", timid2=" + timid2 + ", kolo=" + kolo + "]";
	}

		
    
}
