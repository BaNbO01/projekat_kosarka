package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;

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
         * Prosledjeni objekat mora biti tipa Utakmica, njegovi timovi ne smeju biti null kao i njigovi id, ne sme biti null ni kolo
         * 
         * @param o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko su timovi null,
         * njihovi id null, 
         * ako je kolo null
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
                if(utakmica.getBrojKosevaTima1()>utakmica.getBrojKosevaTima2()){
                    tabelaTim2.setBrojPoraza(tabelaTim2.getBrojPoraza()+1);
                    tabelaTim1.setBrojPobeda(tabelaTim1.getBrojPobeda() + 1);
                    kosRazlika = utakmica.getBrojKosevaTima1()-utakmica.getBrojKosevaTima2();
                    tabelaTim1.setKosRazlika(tabelaTim1.getKosRazlika() + kosRazlika);
                    tabelaTim2.setKosRazlika(tabelaTim2.getKosRazlika() - kosRazlika);
                }
                else{
                    kosRazlika = utakmica.getBrojKosevaTima2()-utakmica.getBrojKosevaTima1();
                     tabelaTim2.setBrojPobeda(tabelaTim2.getBrojPoraza()+1);
                    tabelaTim1.setBrojPoraza(tabelaTim1.getBrojPobeda() + 1);
                    tabelaTim1.setKosRazlika(tabelaTim1.getKosRazlika() - kosRazlika);
                    tabelaTim2.setKosRazlika(tabelaTim2.getKosRazlika() + kosRazlika);
                }
                
                tabelaRepository.save(tabelaTim1);
                tabelaRepository.save(tabelaTim2);
                
                
                
                
		
	}

}
