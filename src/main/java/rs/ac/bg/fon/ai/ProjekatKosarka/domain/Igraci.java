/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.stereotype.Component;

/**
 *
 * 
 * Klasa Igraci koja opisuje kosarkasa sa svojim karakteristikama
 * Svaki igrac je ili deo nekog tima ili slobodan igrac i za njega se cuvaju opste informacije,
 * pored imena i prezimena i datuma rodjenja, cuva se broj na dresu, visina, pozicija koju igra, iz koje zemlje dolazi
 * @author Boban Todic
 */
@Component
@Entity
@Table(name = "igraci")
@NamedQueries({
	@NamedQuery(name = "Igraci.findAllByCriteria", query = "SELECT i FROM Igraci i WHERE (ime LIKE CONCAT('%',:ime,'%') OR :ime IS NULL) AND (broj=:broj OR :broj IS NULL OR :broj=0) AND (prezime LIKE CONCAT ('%',:prezime,'%') OR :prezime IS NULL) AND (visina=:visina OR :visina IS NULL OR :visina=0) AND (pozicija=:pozicija OR :pozicija IS NULL)"),
    @NamedQuery(name = "Igraci.findAll", query = "SELECT i FROM Igraci i"),
    @NamedQuery(name = "Igraci.findByIgracID", query = "SELECT i FROM Igraci i WHERE i.igracID = :igracID"),
    @NamedQuery(name = "Igraci.findByIme", query = "SELECT i FROM Igraci i WHERE i.ime = :ime"),
    @NamedQuery(name = "Igraci.findByPrezime", query = "SELECT i FROM Igraci i WHERE i.prezime = :prezime"),
    @NamedQuery(name = "Igraci.findByBroj", query = "SELECT i FROM Igraci i WHERE i.broj = :broj"),
    @NamedQuery(name = "Igraci.findByDatumRodjenja", query = "SELECT i FROM Igraci i WHERE i.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Igraci.findByVisina", query = "SELECT i FROM Igraci i WHERE i.visina = :visina"),
    @NamedQuery(name = "Igraci.findByPozicija", query = "SELECT i FROM Igraci i WHERE i.pozicija = :pozicija")})
public class Igraci {

    /**
     * Id igraca kao Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "igracid")
    private Long igracID;
    
    /**
     * Ime igraca kao String
     */
    @Column(name = "ime")
    private String ime;
    
    /**
     * Prezime igraca kao String
     */
    @Column(name = "prezime")
    private String prezime;
    /**
     * Broj na dresu kao Integer
     */
    @Column(name = "broj")
    private Integer broj;
    
    /**
     * Datum rodjenja igraca
     */
    @Column(name = "datum")
    private Date datumRodjenja;
    
    /**
     * Visina igraca izrazena u centimetrima
     */
    @Column(name = "visina")
    private Double visina;
    
    /**
     * Pozicija igraca u igri [PG,SG,SF,PF,C]
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pozicija")
    private Pozicija pozicija;
    /**
     * Drzava iz koje dolazi igrac
     */
    @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")
    @ManyToOne
    private Drzava drzavaId;
    
    /**
     * Tim za koji igra igrac
     */
    @JoinColumn(name = "timid", referencedColumnName = "timiD")
    @ManyToOne
    private Tim timId;

    
    /**
     * Podrazumevani konstruktor klase Igraci
     */
    public Igraci() {
    }

    
    /**
     * Konstruktor koji kao parametar prima id igraca
     * 
     * @param igracID Id igraca
     * 
     */
    public Igraci(Long igracID) {
        this.igracID = igracID;
    }

    
    /**
     * Vraca id igraca
     * @return Id igraca
     */
    public Long getIgracID() {
        return igracID;
    }

    /**
     * Postavlja id igraca na prosledjenu vrednost parametra
     * Id igraca ne sme da bude null
     * @param igracID Id igraca
     * @throws java.lang.IllegalArgumentException ukoliko je id igraca null
     */
    public void setIgracID(Long igracID) {
    	if(igracID==null)
    		throw new IllegalArgumentException("Igrac mora imati neki id");
        this.igracID = igracID;
    }
/**
 * Vraca ime igraca kao String
 * @return Ime igraca
 */
    public String getIme() {
        return ime;
    }
    
    /**
     * Postavlja ime igraca na vrednost prosledjenog parametra
     * Ime mora da ima najmanje dva karaktera
     * @param ime Ime igraca
     * @throws java.lang.IllegalArgumentException ukoliko je ime prazan string ili ako ima manje od dva karaktera
     * 
     */

    public void setIme(String ime) {
    	if(ime!=null && (ime.isBlank() || ime.length()<2))
    		throw new IllegalArgumentException("Ime mora biti popunjeno i sadrzati bar 2 karaktera");
        this.ime = ime;
    }

    /**
     * Vraca prezime igraca kao String
     * @return Prezime igraca
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime na vrednost prosledjenog parametra
     * Prezime mora da ima najmanje dva karaktera
     * @param prezime Prezime igraca
     * @throws java.lang.IllegalArgumentException ukoliko je prezime prazan string ili ako ima manje od dva karaktera
     */
    public void setPrezime(String prezime) {
    	  if (prezime!=null && (prezime.isBlank() || prezime.length() < 2)) {
              throw new IllegalArgumentException("Prezime mora biti popunjeno i sadrzati bar 2 karaktera");
          }
        this.prezime = prezime;
    }

    /**
     * Vraca broj na dresu igraca
     * @return Broj na dresu
     */
    public Integer getBroj() {
        return broj;
    }

    /**
     * Postavlja broj igraca na vrednost prosledjenog parametra
     * @param broj Broj na dresu
     */
    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    /**
     * Vraca datum rodjenja igraca kao Date
     * @return Datum rodjenja
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Postavlja datum rodjenja na vrednost prosledjenog parametra
     * @param datumRodjenja datum rodjenja igraca
     */
    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Vraca visinu igraca u centimetrima
     * @return Visina igraca
     */
    public Double getVisina() {
        return visina;
    }

    /**
     * Postavlja visinu igraca na vrednost prosledjenog parametra
     * @param visina Visina igraca
     */
    public void setVisina(Double visina) {
        this.visina = visina;
    }

    /**
     * Vraca poziciju igraca
     * @return Pozicija igraca
     */
    public Pozicija getPozicija() {
        return pozicija;
    }

    /**
     * Postavlja poziciju igraca na vrednost prosledjenog parametra
     * @param pozicija Pozicija igraca
     */
    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    /**
     * Vraca objekat Drzava iz koje dolazi igrac 
     * @return Drzavu kao objekat
     */
    public Drzava getDrzavaId() {
        return drzavaId;
    }

    /**
     * Postavlja kao objekat Drzava na vrednost prosledjenog parametra
     * Drzava ne sme da bude null
     * @param drzavaId Objekat drzava klase Drzava
     * @throws java.lang.IllegalArgumentException ukoliko je drzava null
     * 
     */
    public void setDrzavaId(Drzava drzavaId) {
    	if(drzavaId==null)
    		throw new IllegalArgumentException("Igrac mora dolaziti iz neke zemlje");
        this.drzavaId = drzavaId;
    }

    /**
     * Vraca tim kao objekat za koga nastupa igrac
     * @return tim igraca kao objekat klase Tim
     */
    public Tim getTimId() {
        return timId;
    }

    /**
     * Postavlja tim igraca na vrednost prosledjenog parametra
     * @param timId Tim objekat klase Tim
     */
    public void setTimId(Tim timId) {
        this.timId = timId;
    }

    

	@Override
	public int hashCode() {
		return Objects.hash(igracID);
	}

        
        /**
         * Proverava da li su dva objekta jednaka
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta pokazuju na istu memorisjku
         * lokaciju, ili ako su objekti iste klase i imaju isti id Igraca
         * false - u ostalim slucajevima
         */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Igraci other = (Igraci) obj;
		return Objects.equals(igracID, other.igracID);
	}

        
        /**
         * Vraca String reprezentaciju objekta Igraci
         * @return Objekat tipa Igraci kao String
         */
	@Override
	public String toString() {
		return "Igraci [igracID=" + igracID + ", ime=" + ime + ", prezime=" + prezime + ", broj=" + broj
				+ ", datumRodjenja=" + datumRodjenja + ", visina=" + visina + ", drzavaId=" + drzavaId + "]";
	}

  
    
}
