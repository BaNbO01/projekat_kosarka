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
@Table(name = "tabela")
@NamedQueries({
     @NamedQuery(name = "Tabela.findAllByTimIdAndLeagueId", query = "SELECT t FROM Tabela t WHERE t.timid.timId  = :timid  AND t.liga.ligaId = :ligaid"),
    @NamedQuery(name = "Tabela.findAll", query = "SELECT t FROM Tabela t "),
    @NamedQuery(name = "Tabela.findByTabelaid", query = "SELECT t FROM Tabela t WHERE t.tabelaPK.tabelaid = :tabelaid"),
    @NamedQuery(name = "Tabela.findByBrojPobeda", query = "SELECT t FROM Tabela t WHERE t.brojPobeda = :brojPobeda"),
    @NamedQuery(name = "Tabela.findByBrojPoraza", query = "SELECT t FROM Tabela t WHERE t.brojPoraza = :brojPoraza"),
    @NamedQuery(name = "Tabela.findByKosRazlika", query = "SELECT t FROM Tabela t WHERE t.kosRazlika = :kosRazlika"),
    @NamedQuery(name = "Tabela.findByLigaid", query = "SELECT t FROM Tabela t WHERE t.tabelaPK.ligaid = :ligaid ORDER BY t.brojPobeda DESC, t.brojPoraza ASC, t.kosRazlika DESC")})
public class Tabela {

    @EmbeddedId
    protected TabelaPK tabelaPK;
    @Column(name = "brojpobeda")
    private Integer brojPobeda;
    @Column(name = "brojporaza")
    private Integer brojPoraza;
    @Column(name = "kosrazlika")
    private Integer kosRazlika;
    @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)
    @ManyToOne
    private Liga liga;
    @JoinColumn(name = "timid", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid;

    public Tabela() {
    }

    public Tabela(TabelaPK tabelaPK) {
        this.tabelaPK = tabelaPK;
    }

    public Tabela(long tabelaid, long ligaid) {
        this.tabelaPK = new TabelaPK(tabelaid, ligaid);
    }

    public TabelaPK getTabelaPK() {
        return tabelaPK;
    }

    public void setTabelaPK(TabelaPK tabelaPK) {
        this.tabelaPK = tabelaPK;
    }

    public Integer getBrojPobeda() {
        return brojPobeda;
    }

    public void setBrojPobeda(Integer brojPobeda) {
        this.brojPobeda = brojPobeda;
    }

    public Integer getBrojPoraza() {
        return brojPoraza;
    }

    public void setBrojPoraza(Integer brojPoraza) {
        this.brojPoraza = brojPoraza;
    }

    public Integer getKosRazlika() {
        return kosRazlika;
    }

    public void setKosRazlika(Integer kosRazlika) {
        this.kosRazlika = kosRazlika;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Tim getTimid() {
        return timid;
    }

    public void setTimid(Tim timid) {
        this.timid = timid;
    }


    @Override
	public int hashCode() {
		return Objects.hash(tabelaPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabela other = (Tabela) obj;
		return Objects.equals(tabelaPK, other.tabelaPK);
	}

	@Override
	public String toString() {
		return "Tabela [tabelaPK=" + tabelaPK + ", brojPobeda=" + brojPobeda + ", brojPoraza=" + brojPoraza
				+ ", kosRazlika=" + kosRazlika + ", liga=" + liga + ", timid=" + timid + "]";
	}

	
    
}
