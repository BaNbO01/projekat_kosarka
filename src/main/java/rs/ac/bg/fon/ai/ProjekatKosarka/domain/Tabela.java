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
 *Klasa Tabela predstavlja rezultate jednog tima u odredjenoj ligi.Ona predstavlja slab objekat klase Liga i kao takva ima slozeni primarni kljuc
 * Za svaki objekat klase belezi se:
 * broj pobeda
 * broj poraza
 * kos razlika 
 * @author Boban Todic
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

    /**
     * Slozeni primarni kljuc klase Tabela
     */
    @EmbeddedId
    protected TabelaPK tabelaPK;
     /**
     * Broj pobeda tima u konkretnoj ligi
     */
    @Column(name = "brojpobeda")
    private Integer brojPobeda;
     /**
     * Broj poraza tima u konkretnoj ligi
     */
    @Column(name = "brojporaza")
    private Integer brojPoraza;
     /**
     * Kos razlika tima u konkretnoj ligi
     */
    @Column(name = "kosrazlika")
    private Integer kosRazlika;
    /**
     * Liga za koju se vodi evidencija
     */
    @JoinColumn(name = "ligaid", referencedColumnName = "ligaid", insertable = false, updatable = false)
    @ManyToOne
    private Liga liga;
    /**
     * Tim za koga se beleze ostali parametri u ovoj klasi
     */
    @JoinColumn(name = "timid", referencedColumnName = "timid")
    @ManyToOne
    private Tim timid;

    /**
     * Podrazumevani konstrukor
     */
    public Tabela() {
    }

    /**
     * Konstrukor koji kao parametar prima slozeni objekat
     * @param tabelaPK Objekat klase TabelaPK
     */
    public Tabela(TabelaPK tabelaPK) {
        this.tabelaPK = tabelaPK;
    }

    /**
     * Konstrukor koji kao parametar prima id tabele i id lige
     * @param tabelaid Id tabele tipa long
     * @param ligaid Id lige tipa long
     */
    public Tabela(long tabelaid, long ligaid) {
        this.tabelaPK = new TabelaPK(tabelaid, ligaid);
    }

    /**
     * Vraca primarni kljuc kao tip TabelaPK
     * @return Objekat klase TabelaPK 
     */
    public TabelaPK getTabelaPK() {
        return tabelaPK;
    }

    /**
     * Postavlja slozeni primarni kljuc na vrednost prosledjenog parametra
     * @param tabelaPK Objekat tipa TabelaPK
     */
    public void setTabelaPK(TabelaPK tabelaPK) {
        this.tabelaPK = tabelaPK;
    }

    /**
     * Vraca broj pobeda tima u ligi kao Integer
     * @return Broj pobeda
     */
    public Integer getBrojPobeda() {
        return brojPobeda;
    }

    /**
     * Postavlja broj pobeda tima na vrednost prosledjenog parametera
     * @param brojPobeda Broj pobeda tipa Integer
     */
    public void setBrojPobeda(Integer brojPobeda) {
        this.brojPobeda = brojPobeda;
    }

    /**
     * Vraca broj poraza tima u ligi tipa Integer
     * @return Broj poraza
     */
    public Integer getBrojPoraza() {
        return brojPoraza;
    }

    /**
     * Postavlja broj poraza na vrednost prosledjenog parametra
     * @param brojPoraza Broj poraza
     */
    public void setBrojPoraza(Integer brojPoraza) {
        this.brojPoraza = brojPoraza;
    }

    /**
     * Vraca kos razliku tima u ligi kao Integer
     * @return Kos razliku
     */
    public Integer getKosRazlika() {
        return kosRazlika;
    }

    /**
     * Postavlja kos razliku na vrednost prosledjenog parametra
     * @param kosRazlika Kos razlika tipa Integer
     */
    public void setKosRazlika(Integer kosRazlika) {
        this.kosRazlika = kosRazlika;
    }

    /**
     * Vraca ligu na koju se odnosi objekat Tabela
     * @return Objekat klase Liga za koga se gleda tabela
     */
    public Liga getLiga() {
        return liga;
    }

    /**
     * Postavlja ligu ,na koju se odnosi tabela ,na vrednost prosledjenog parametra
     * Liga ne sme da bude null
     * @param liga Objekat klase Liga
     * @throws java.lang.IllegalArgumentException ukoliko je liga null
     */
    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    /**
     * Vraca tim za koga se prikazuju rezultati tabele kao klasa Tim
     * @return Objekat klase Tim na koju se odnosi ova tabela
     */
    public Tim getTimid() {
        return timid;
    }

    /**
     * Postavlja tim na vrednost prosledjenog parametra
     * @param timid Objekat klase Tim
     */
    public void setTimid(Tim timid) {
        this.timid = timid;
    }


    @Override
	public int hashCode() {
		return Objects.hash(tabelaPK);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta pokazuju na istu memorijsku lokaciju,
         * ili ako su iste klase i imaju istu vrednost slozenog primarnog kljuca (id tabele i id lige)
         * false - u svakom drugom slucaju
         */
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

        /**
         * Vraca String reprezentaciju objekta Tabela sa svojim atributima
         * @return Objekat Tabela kao String
         */
	@Override
	public String toString() {
		return "Tabela [tabelaPK=" + tabelaPK + ", brojPobeda=" + brojPobeda + ", brojPoraza=" + brojPoraza
				+ ", kosRazlika=" + kosRazlika + ", liga=" + liga + ", timid=" + timid + "]";
	}

	
    
}
