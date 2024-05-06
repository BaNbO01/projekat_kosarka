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
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOIzbrisiIgraca;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOSacuvajIgraca;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOSacuvajUtakmicu;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiIgraceFiltrirane;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiKoloLige;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiStanjeTabeleLige;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveDrzave;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveIgrace;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveLige;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiSveTimove;
import rs.ac.bg.fon.ai.ProjekatKosarka.so.SOVratiUtakmiceKola;

/**
 *
 * @author Korisnik
 */
@Controller
public class UIController {

    private SOVratiIgraceFiltrirane sOVratiIgraceFiltrirane;
    private SOSacuvajIgraca sOSacuvajIgraca;
    private SOIzbrisiIgraca sOIzbrisiIgraca;
    private SOVratiSveDrzave soVratiSveDrzave;
    private SOVratiSveTimove soVratiSveTimove;
    private SOVratiStanjeTabeleLige sOVratiStanjeTabeleLige;
    private SOVratiSveLige sOVratiSveLige;
    private SOVratiKoloLige soVratiKoloLige;
    private SOSacuvajUtakmicu soSacuvajUtakmicu;
    private SOVratiUtakmiceKola soVratiUtakmiceKola;

    @Autowired
    public void setsOVratiIgraceFiltrirane(SOVratiIgraceFiltrirane sOVratiIgraceFiltrirane) {
        this.sOVratiIgraceFiltrirane = sOVratiIgraceFiltrirane;
    }

    @Autowired
    public void setsOVratiSveIgrace(SOVratiSveIgrace sOVratiSveIgrace) {
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

    @Autowired
    public void setsOVratiStanjeTabeleLige(SOVratiStanjeTabeleLige sOVratiStanjeTabeleLige) {
        this.sOVratiStanjeTabeleLige = sOVratiStanjeTabeleLige;
    }

    @Autowired
    public void setsOVratiSveLige(SOVratiSveLige sOVratiSveLige) {
        this.sOVratiSveLige = sOVratiSveLige;
    }

    @Autowired
    public void setSoSacuvajUtakmicu(SOSacuvajUtakmicu soSacuvajUtakmicu) {
        this.soSacuvajUtakmicu = soSacuvajUtakmicu;
    }

    @Autowired
    public void setSoVratiUtakmiceKola(SOVratiUtakmiceKola soVratiUtakmiceKola) {
        this.soVratiUtakmiceKola = soVratiUtakmiceKola;
    }

    @Autowired
    public void setSoVratiKoloLige(SOVratiKoloLige soVratiKoloLige) {
        this.soVratiKoloLige = soVratiKoloLige;
    }

    public List<Tim> vratiSveTimove(Tim tim) throws Exception {
        soVratiSveTimove.izvrsi(tim);
        return (List<Tim>) soVratiSveTimove.getResult();

    }

    public List<Drzava> vratiDrzave(Drzava drzava) throws Exception {
        soVratiSveDrzave.izvrsi(drzava);
        return (List<Drzava>) soVratiSveDrzave.getResult();
    }

    public List<Liga> vratiSveLige(Liga liga) throws Exception {
        sOVratiSveLige.izvrsi(liga);
        return (List<Liga>) sOVratiSveLige.getResult();
    }

    public List<Tabela> vratiStanjeTabeleLige(Tabela tabela) throws Exception {
        sOVratiStanjeTabeleLige.izvrsi(tabela);
        return (List<Tabela>) sOVratiStanjeTabeleLige.getResult();
    }

    public void sacuvaj(Utakmica utakmica) throws Exception {
        soSacuvajUtakmicu.izvrsi(utakmica);
    }

    public List<Kolo> vratiKolaLige(Kolo kolo) throws Exception {
        soVratiKoloLige.izvrsi(kolo);
        return (List<Kolo>) soVratiKoloLige.getResult();
    }

    public List<Utakmica> vratiUtakmiceKola(Utakmica utakmica) throws Exception {
        soVratiUtakmiceKola.izvrsi(utakmica);
        return (List<Utakmica>) soVratiUtakmiceKola.getResult();
    }

}
