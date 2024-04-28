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
 *
 * @author Korisnik
 */
@Component
@Entity
@Table(name = "tim")
@NamedQueries({
    @NamedQuery(name = "Tim.findAll", query = "SELECT t FROM Tim t"),
    @NamedQuery(name = "Tim.findByTimId", query = "SELECT t FROM Tim t WHERE t.timId = :timId"),
    @NamedQuery(name = "Tim.findByNaziv", query = "SELECT t FROM Tim t WHERE t.naziv = :naziv")})
public class Tim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timid")
    private Long timId;
    @Column(name = "naziv")
    private String naziv;
    @JoinColumns({
        @JoinColumn(name = "gradid", referencedColumnName = "gradid"),
        @JoinColumn(name = "drzavaid", referencedColumnName = "drzavaid")})
    @ManyToOne
    private Grad grad;
    @OneToMany(mappedBy = "timId")
    private List<Igraci> igraciList;

    public Tim() {
    }

    public Tim(Long timId) {
        this.timId = timId;
    }

    public Long getTimId() {
        return timId;
    }

    public void setTimId(Long timId) {
        this.timId = timId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    
    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

   
    public List<Igraci> getIgraciList() {
        return igraciList;
    }

    public void setIgraciList(List<Igraci> igraciList) {
        this.igraciList = igraciList;
    }

   
    @Override
	public int hashCode() {
		return Objects.hash(timId);
	}

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

	@Override
	public String toString() {
		return naziv + " grad:" + grad;
	}

	
    
}
