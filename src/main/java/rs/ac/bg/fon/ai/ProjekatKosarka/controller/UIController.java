/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Drzava;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOIzbrisiIgraca;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOSacuvajIgraca;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiIgraceFiltrirane;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveDrzave;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveIgrace;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveTimove;

/**
 *
 * @author Korisnik
 */
@Controller
public class UIController {

    private SOVratiIgraceFiltrirane sOVratiIgraceFiltrirane;
    private SOVratiSveIgrace sOVratiSveIgrace;
    private SOSacuvajIgraca sOSacuvajIgraca;
    private SOIzbrisiIgraca sOIzbrisiIgraca;
    private SOVratiSveDrzave soVratiSveDrzave;
    private SOVratiSveTimove soVratiSveTimove;

    @Autowired
    public void setsOVratiIgraceFiltrirane(SOVratiIgraceFiltrirane sOVratiIgraceFiltrirane) {
        this.sOVratiIgraceFiltrirane = sOVratiIgraceFiltrirane;
    }

    @Autowired
    public void setsOVratiSveIgrace(SOVratiSveIgrace sOVratiSveIgrace) {
        this.sOVratiSveIgrace = sOVratiSveIgrace;
    }

    @Autowired
    public void setsOSacuvajIgraca(SOSacuvajIgraca sOSacuvajIgraca) {
        this.sOSacuvajIgraca = sOSacuvajIgraca;
    }

    @Autowired
    public void setsOIzbrisiIgraca(SOIzbrisiIgraca sOIzbrisiIgraca) {
        this.sOIzbrisiIgraca = sOIzbrisiIgraca;
    }

    public List<Igraci> vratiSveIgraceFiltrirane(Igraci igrac) throws Exception {
        sOVratiIgraceFiltrirane.izvrsi(igrac);
        return (List<Igraci>) sOVratiIgraceFiltrirane.getResult();
    }

    public void obrisiIgraca(Igraci igrac) throws Exception {
        sOIzbrisiIgraca.izvrsi(igrac);
    }

    public void sacuvaj(Igraci igrac) throws Exception {
        sOSacuvajIgraca.izvrsi(igrac);

    }

    @Autowired
    public void setSOVratiSveDrzave(SOVratiSveDrzave SOVratiSveDrzave) {
        this.soVratiSveDrzave = SOVratiSveDrzave;
    }

    @Autowired
    public void setSOVratiSveTimove(SOVratiSveTimove SOVratiSveTimove) {
        this.soVratiSveTimove = SOVratiSveTimove;
    }
    
    
    public List<Tim> vratiSveTimove(Tim tim) throws Exception {
        soVratiSveTimove.izvrsi(tim);
        return (List<Tim>) soVratiSveTimove.getResult();
        
    }

    public List<Drzava> vratiDrzave(Drzava drzava) throws Exception {
        soVratiSveDrzave.izvrsi(drzava);
        return (List<Drzava>) soVratiSveDrzave.getResult();
    }
}
