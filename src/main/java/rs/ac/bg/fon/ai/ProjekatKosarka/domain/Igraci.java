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
 * @author Korisnik
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "igracid")
    private Long igracID;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "broj")
    private Integer broj;
    @Column(name = "datum")
    private Date datumRodjenja;
    @Column(name = "visina")
    private Double visina;
    @Enumerated(EnumType.STRING)
    @Column(name = "pozicija")
    private Pozicija pozicija;
    @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")
    @ManyToOne
    private Drzava drzavaId;
    @JoinColumn(name = "timid", referencedColumnName = "timiD")
    @ManyToOne
    private Tim timId;

    public Igraci() {
    }

    public Igraci(Long igracID) {
        this.igracID = igracID;
    }

    public Long getIgracID() {
        return igracID;
    }

    public void setIgracID(Long igracID) {
        this.igracID = igracID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Double getVisina() {
        return visina;
    }

    public void setVisina(Double visina) {
        this.visina = visina;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public Drzava getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(Drzava drzavaId) {
        this.drzavaId = drzavaId;
    }

    public Tim getTimId() {
        return timId;
    }

    public void setTimId(Tim timId) {
        this.timId = timId;
    }

    

	@Override
	public int hashCode() {
		return Objects.hash(igracID);
	}

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

	@Override
	public String toString() {
		return "Igraci [igracID=" + igracID + ", ime=" + ime + ", prezime=" + prezime + ", broj=" + broj
				+ ", datumRodjenja=" + datumRodjenja + ", visina=" + visina + ", drzavaId=" + drzavaId + "]";
	}

  
    
}
