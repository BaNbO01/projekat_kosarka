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
 * Klasa GradPK predstavlja pomocnu klasu koja sluzi da cuva podatke slozenog
 * primarnog kljuca za klasu Grad
 * 
 * Sadrzi id grada i id drzave
 * 
 * @author Boban Todic
 */
@Component
@Embeddable
public class GradPK  {


        /**
         * Grad id tipa long
         */
    @Column(name = "gradid")
    private long gradID;
    /**
     * Drzava id tipa long
     */
    @Column(name = "drzavaid")
    private long drzavaID;

    
    /**
     * Podrazumevani konstruktor klase GradPK
     */
    public GradPK() {
    }

    /**
     * Konstruktor klase GradPk koji prima kao parametre id grada i id drzave
     * @param gradID Id grada tipa long
     * @param drzavaID Id drzave tipa long
     */
    public GradPK(long gradID, long drzavaID) {
        this.gradID = gradID;
        this.drzavaID = drzavaID;
    }

    /**
     * Vraca id grada kao long
     * @return Id grada
     */
    public long getGradID() {
        return gradID;
    }

    /**
     * Postavlja id grada na unetu vrednost
     * @param gradID Id grada
     */
    public void setGradID(long gradID) {
        this.gradID = gradID;
    }

    /**
     * Vrati id drzave
     * @return Id drzave
     */
    public long getDrzavaID() {
        return drzavaID;
    }

    /**
     * Postavi id drzave na prosledjenu vrednost parametra
     * @param drzavaID Id drzave
     */
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

    /**
     * Provera da li su dva objekta jednaka
     * @param object objekat sa kojim se poredi
     * @return true - ako oba objekta imaju istu memorijsku lokaciju,
     * ili ako su objekti iste klase i imaju isti id grada i id drzave.
     * false - u svakom drugom slucaju
     */
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
        /**
         * Vraca kao String parametre ove klase
         * @return objekat GradPK kao String
         */
	@Override
	public String toString() {
		return "GradPK [gradID=" + gradID + ", drzavaID=" + drzavaID + "]";
	}

    
    
}
