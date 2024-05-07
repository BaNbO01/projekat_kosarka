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
 * @author Korisnik
 */
@Component
public class Log {
    @SerializedName("naziv sistemske operacije")
    private String nazivSistemskeOperacije;
    @SerializedName("vreme izvrsavanja")
    private Date vremeIzvrsavanja;
    @SerializedName("uspesnost izvrsenja")
    private Boolean uspesnoIzvrsenaOperacija;

    public Log() {
    }

    public Log(String nazivSistemskeOperacije, Date vremeIzvrsavanja, Boolean uspesnoIzvrsenaOperacija) {
        this.nazivSistemskeOperacije = nazivSistemskeOperacije;
        this.vremeIzvrsavanja = vremeIzvrsavanja;
        this.uspesnoIzvrsenaOperacija = uspesnoIzvrsenaOperacija;
    }

    public String getNazivSistemskeOperacije() {
        return nazivSistemskeOperacije;
    }

    public void setNazivSistemskeOperacije(String nazivSistemskeOperacije) {
        this.nazivSistemskeOperacije = nazivSistemskeOperacije;
    }

    public Date getVremeIzvrsavanja() {
        return vremeIzvrsavanja;
    }

    public void setVremeIzvrsavanja(Date vremeIzvrsavanja) {
        this.vremeIzvrsavanja = vremeIzvrsavanja;
    }

    public Boolean getUspesnoIzvrsenaOperacija() {
        return uspesnoIzvrsenaOperacija;
    }

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

    @Override
    public String toString() {
        return "Log{" + "nazivSistemskeOperacije=" + nazivSistemskeOperacije + ", vremeIzvrsavanja=" + vremeIzvrsavanja + ", uspesnoIzvrsenaOperacija=" + uspesnoIzvrsenaOperacija + '}';
    }
    
}
