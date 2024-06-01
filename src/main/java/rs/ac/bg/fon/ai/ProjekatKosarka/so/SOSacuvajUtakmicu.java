package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.TabelaPK;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TabelaRepository;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.UtakmicaRepository;
/**
 * Sistemska operacija za cuvanje utakmica nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOSacuvajUtakmicu extends ApstraktnaSistemskaOperacija {

      /**
     * Repozitorijum za utakmicu
     */
	UtakmicaRepository repository;
          /**
     * Repozitorijum za tabelu
     */
        TabelaRepository tabelaRepository;
        /**
         * Konstruktor koji postavlja vrednosti repozitorijuma na vrednosti prosledjenih parametara
         * @param repository Repozitorijum tipa UtakmicaRepository
         * @param tabelaRepository Repozitorijum tipa TabelaRepository
         */
	public SOSacuvajUtakmicu(UtakmicaRepository repository,TabelaRepository tabelaRepository) {
	this.repository = repository;
        this.tabelaRepository = tabelaRepository;

	}
        
        /**
         * Validacija igraca pre samog cuvanja
         * Prosledjeni objekat mora biti tipa Utakmica
         * 
         * @param o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko prosledjeni objekat nije tipa Utakmica
         */
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Utakmica u) {
			if(u.getTimid1()==null || u.getTimid1().getTimId()==null || u.getTimid2()==null || u.getTimid2().getTimId()==null || u.getKolo()==null) {
				throw new IllegalArgumentException("Objekat utakmica nije validan");
			}
		}else {
		throw new IllegalArgumentException("Prosledjeni objekat nije klase Utakmica");
		}
		
	}

        /**
         * Cuvanje utakmice u sistem
         * To istovremeno cuva i promene vezane za Tabelu lige tih ekipa nakon sacuvanih utakmica
         * @param o Objekat koji se cuva
         * 
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Utakmica utakmica = (Utakmica)o;
		repository.save(utakmica);
                Integer kosRazlika;
                Tabela tabelaTim1 = tabelaRepository.returnByTeamId(utakmica.getTimid1().getTimId(),utakmica.getKolo().getKoloPK().getLigaId());
                Tabela tabelaTim2 = tabelaRepository.returnByTeamId(utakmica.getTimid2().getTimId(),utakmica.getKolo().getKoloPK().getLigaId());
               
                if(tabelaTim1==null){
                    tabelaTim1 = new Tabela();
                    tabelaTim1.setTimid(utakmica.getTimid1());
                    tabelaTim1.setBrojPobeda(0);
                    tabelaTim1.setBrojPobeda(0);
                    tabelaTim1.setKosRazlika(0);
                    tabelaTim1.setBrojPoraza(0);
                    tabelaTim1.setLiga(utakmica.getKolo().getLiga());
                    TabelaPK pk1 = new TabelaPK(utakmica.getTimid1().getTimId(), utakmica.getUtakmicaPK().getLigaId());
                    tabelaTim1.setTabelaPK(pk1);
                }
               
                 if(tabelaTim2==null){
                    tabelaTim2 = new Tabela();
                    tabelaTim2.setBrojPobeda(0);
                    tabelaTim2.setTimid(utakmica.getTimid2());
                    tabelaTim2.setBrojPobeda(0);
                    tabelaTim2.setKosRazlika(0);
                    tabelaTim2.setBrojPoraza(0);
                    tabelaTim2.setLiga(utakmica.getKolo().getLiga());
                    TabelaPK pk2 = new TabelaPK(utakmica.getTimid2().getTimId(), utakmica.getUtakmicaPK().getLigaId());
                    tabelaTim2.setTabelaPK(pk2);
                }
                
                
                if(utakmica.getBrojKosevaTima1()>utakmica.getBrojKosevaTima2()){
                    tabelaTim2.setBrojPoraza(tabelaTim2.getBrojPoraza()+1);
                    tabelaTim1.setBrojPobeda(tabelaTim1.getBrojPobeda() + 1);
                    kosRazlika = utakmica.getBrojKosevaTima1()-utakmica.getBrojKosevaTima2();
                    tabelaTim1.setKosRazlika(tabelaTim1.getKosRazlika() + kosRazlika);
                    tabelaTim2.setKosRazlika(tabelaTim2.getKosRazlika() - kosRazlika);
                }
                else{
                    kosRazlika = utakmica.getBrojKosevaTima2()-utakmica.getBrojKosevaTima1();
                     tabelaTim2.setBrojPobeda(tabelaTim2.getBrojPobeda()+1);
                    tabelaTim1.setBrojPoraza(tabelaTim1.getBrojPoraza() + 1);
                    tabelaTim1.setKosRazlika(tabelaTim1.getKosRazlika() - kosRazlika);
                    tabelaTim2.setKosRazlika(tabelaTim2.getKosRazlika() + kosRazlika);
                }
                
                tabelaRepository.save(tabelaTim1);
                tabelaRepository.save(tabelaTim2);
                
                
                
                
		
	}

}
