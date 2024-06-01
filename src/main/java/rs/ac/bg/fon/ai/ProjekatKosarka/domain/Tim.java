/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *Klasa Tim predstavlja kosarkasku ekipu
 * Ona je sastavljena od igraca koji su objekti tipa Igraci,
 * dolazi iz nekog grada tipa Grad
 * i mogu nastupati u raznim ligama, igraju utakmice,
 * za koje se beleze rezultati u svakoj ligi
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "tim")
@NamedQueries({
    @NamedQuery(name = "Tim.findAll", query = "SELECT t FROM Tim t"),
    @NamedQuery(name = "Tim.findByTimId", query = "SELECT t FROM Tim t WHERE t.timId = :timId"),
    @NamedQuery(name = "Tim.findByNaziv", query = "SELECT t FROM Tim t WHERE t.naziv = :naziv")})
public class Tim {

    /**
     * Id tima tipa Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timid")
    private Long timId;
    /**
     * Naziv tima tipa String
     */
    @Column(name = "naziv")
    private String naziv;
    /**
     * Grad iz kog dolazi tim
     */
    @JoinColumns({
        @JoinColumn(name = "gradid", referencedColumnName = "gradid"),
        @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")})
    @ManyToOne
    private Grad grad;
    /**
     * Igraci koji pripadaju nekoj ekipi
     */
    @OneToMany(mappedBy = "timId")
    private List<Igraci> igraciList;

    /**
     * Podrazumevani konstruktor klase Tim
     */
    public Tim() {
    }

    /**
     * Konstruktor koji prima kao parametar id tima
     * @param timId Id tima tipa Long
     */
    public Tim(Long timId) {
        this.timId = timId;
    }

    /**
     * Vraca id tima tipa Long
     * @return Id tima
     */
    public Long getTimId() {
        return timId;
    }

    /**
     * Postavlja id tima na vrednost prosledjenog parametra
     * Tim id ne sme da bude null
     * @param timId Id tima tipa Long
     * @throws java.lang.IllegalArgumentException ukoliko je tim id null
     */
    public void setTimId(Long timId) {
    	if(timId==null)
    		throw new IllegalArgumentException("Tim id ne sme da bude null");
        this.timId = timId;
    }

    /**
     * Vraca naziv tima tipa String
     * @return Naziv tima
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv tima na vrednost prosledjenog parametra
     * @param naziv Naziv tima
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Vraca grad odakle dolazi tim kao klasa Grad
     * @return Grad iz kog dolazi tim
     */
    public Grad getGrad() {
        return grad;
    }

    /**
     * Postavlja grad na vrednost prosledjenog parametra
     * @param grad Objekat klase Grad
     */
    public void setGrad(Grad grad) {
        this.grad = grad;
    }

   
    /**
     * Vraca listu igraca tipa kao List 
     * @return Igraci tima
     */
    public List<Igraci> getIgraciList() {
        return igraciList;
    }

    /**
     * Postavlja listu igraca tima na vrednost prosledjenog parametra
     * @param igraciList Objekat tipa List
     */
    public void setIgraciList(List<Igraci> igraciList) {
        this.igraciList = igraciList;
    }

   
    @Override
	public int hashCode() {
		return Objects.hash(timId);
	}

        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju istu vrednost id tima
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
		Tim other = (Tim) obj;
		return Objects.equals(timId, other.timId);
	}

        /**
         * Vraca String reprezentaciju objekta Tim sa atributima naziv i grad
         * @return Objekat Tim kao String
         */
	@Override
	public String toString() {
		return naziv + " grad:" + grad;
	}

	
    
}
