/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Korisnik
 */
@Component
@Embeddable
public class GradPK  {


    @Column(name = "gradid")
    private long gradID;
    @Column(name = "drzavaid")
    private long drzavaID;

    public GradPK() {
    }

    public GradPK(long gradID, long drzavaID) {
        this.gradID = gradID;
        this.drzavaID = drzavaID;
    }

    public long getGradID() {
        return gradID;
    }

    public void setGradID(long gradID) {
        this.gradID = gradID;
    }

    public long getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(long drzavaID) {
        this.drzavaID = drzavaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gradID;
        hash += (int) drzavaID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradPK)) {
            return false;
        }
        GradPK other = (GradPK) object;
        if (this.gradID != other.gradID) {
            return false;
        }
        if (this.drzavaID != other.drzavaID) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "GradPK [gradID=" + gradID + ", drzavaID=" + drzavaID + "]";
	}

    
    
}
