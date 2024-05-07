/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 *
 * Klasa za belezenje podataka o uspesnosti i vremenu izvrsavanja svake sistemske operacije
 * Sadrzi naziv sistemske operacije, njeno vreme izvrsavanja, i uspesnost realizacije
 * @author Boban Todic
 */
@Component
public class Log {
    /**
     * Pun kvalifikovani naziv sistemske operacije
     */
    @SerializedName("naziv sistemske operacije")
    private String nazivSistemskeOperacije;
    /**
     * Vreme izvrsavanja sistemske operacije
     */
    @SerializedName("vreme izvrsavanja")
    private Date vremeIzvrsavanja;
    /**
     * Uspesnost izvrsavanja sistemske operacije 
     * (true - uspesno / false - neuspesno)
     */
    @SerializedName("uspesnost izvrsenja")
    private Boolean uspesnoIzvrsenaOperacija;

    /**
     * Podrazumevani konstruktor klase Log
     */
    public Log() {
    }

    /**
     * Parametarski konstruktor klase Log koji postavlja vrednosti atributa na osnovu prosledjenih parametara
     * @param nazivSistemskeOperacije Naziv sistemske operacije
     * @param vremeIzvrsavanja Vreme izvrsavanja sistemske operacije
     * @param uspesnoIzvrsenaOperacija Uspesnost izvrsenja sistemske operacije
     */
    public Log(String nazivSistemskeOperacije, Date vremeIzvrsavanja, Boolean uspesnoIzvrsenaOperacija) {
        this.nazivSistemskeOperacije = nazivSistemskeOperacije;
        this.vremeIzvrsavanja = vremeIzvrsavanja;
        this.uspesnoIzvrsenaOperacija = uspesnoIzvrsenaOperacija;
    }

    /**
     * Vraca naziv sistemske operacije kao String
     * @return Naziv sistemske operacije
     */
    public String getNazivSistemskeOperacije() {
        return nazivSistemskeOperacije;
    }

    /**
     * Postavlja naziv sistemske operacije na vrednost prosledjenog parametra
     * @param nazivSistemskeOperacije Naziv sistemske operacije
     */
    public void setNazivSistemskeOperacije(String nazivSistemskeOperacije) {
        this.nazivSistemskeOperacije = nazivSistemskeOperacije;
    }

    /**
     * Vreme izvrsavanja sistemske operacije
     * @return  vreme izvrsenja sistemske operacije
     */
    public Date getVremeIzvrsavanja() {
        return vremeIzvrsavanja;
    }

    /**
     * Postavlja vreme izvrsenja sistemske operacije na vrednost prosledjenog parametra
     * @param vremeIzvrsavanja Vreme izvrsavanja sistemske operacije tipa Date
     */
    public void setVremeIzvrsavanja(Date vremeIzvrsavanja) {
        this.vremeIzvrsavanja = vremeIzvrsavanja;
    }

    /**
     * Vraca uspesnost izvrsenja sistemske operacije kao tip Boolean
     * @return true - ako je uspesno, false ako nije uspesno
     */
    public Boolean getUspesnoIzvrsenaOperacija() {
        return uspesnoIzvrsenaOperacija;
    }

    /**
     * Postavlja uspesnost izvrsavanja na vrednost prosledjenog parametra
     * @param uspesnoIzvrsenaOperacija  Uspesnost izvrsavanja sistemske operacije kao Boolean
     */
    public void setUspesnoIzvrsenaOperacija(Boolean uspesnoIzvrsenaOperacija) {
        this.uspesnoIzvrsenaOperacija = uspesnoIzvrsenaOperacija;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nazivSistemskeOperacije);
        hash = 61 * hash + Objects.hashCode(this.vremeIzvrsavanja);
        hash = 61 * hash + Objects.hashCode(this.uspesnoIzvrsenaOperacija);
        return hash;
    }

    /**
     * Proverava da li su dva objekta jednaka
     * 
     * @param obj Objekat sa kojim se poredi
     * @return true - ako su objekti iste memorijske lokacije, ili ako su 
     * iste klase i i svaki atribut im ima iste vrednosti
     * false -  u svim ostalim situacijama
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Log other = (Log) obj;
        if (!Objects.equals(this.nazivSistemskeOperacije, other.nazivSistemskeOperacije)) {
            return false;
        }
        if (!Objects.equals(this.vremeIzvrsavanja, other.vremeIzvrsavanja)) {
            return false;
        }
        return Objects.equals(this.uspesnoIzvrsenaOperacija, other.uspesnoIzvrsenaOperacija);
    }

    /**
     * Vraca String reprezentaciju objekta Log sa svojim atributima
     * @return Objekat Log kao String
     */
    @Override
    public String toString() {
        return "Log{" + "nazivSistemskeOperacije=" + nazivSistemskeOperacije + ", vremeIzvrsavanja=" + vremeIzvrsavanja + ", uspesnoIzvrsenaOperacija=" + uspesnoIzvrsenaOperacija + '}';
    }
    
}
