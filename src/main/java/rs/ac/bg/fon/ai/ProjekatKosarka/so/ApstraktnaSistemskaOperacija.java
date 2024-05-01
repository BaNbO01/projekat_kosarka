package rs.ac.bg.fon.ai.ProjekatKosarka.so;


import org.springframework.transaction.annotation.Transactional;


/**
 * Klasa ApstraktnaSistemskaOperacija je opsta apstraktna klasa koju svaka sistemska operacija nasledjuje
 * Odredjuje sta svaka sistemska operacija mora da ispostuje da bi bila deo sistema
 * 
 * @author Boban Todic
 */
public abstract class ApstraktnaSistemskaOperacija {

	
	/**
         * Rezultat sistemske operacije se smesta u ovaj parametar
         */
	protected Object result;
	
	
	
	/**
         * Validacija prosledjenog objekta
         * Svaka nasledjena klasa mora dati svoju implementaciju ove metode
         * @param o Objekat koji je prosledjen
         * @throws java.lang.Exception odnosno baca bilo koju podklasu ovog exception-a u zavisnosti od potreba, nasledjena klasa bira vrstu izuzetka
         */
	@Transactional
	protected abstract void validate(Object o) throws Exception;
	
        /**
         * Konkretno izvrsavanje same sistemske operacije.
         *Svaka nasledjena klasa mora pruziti implementaciju
         * @param o Objekat nad kojim se izvrsava
         * @throws java.lang.Exception tj njene nasledjene stvari ukoliko operacija nije uspela da se izvrsi sa bazom
         */
	@Transactional
    protected abstract void izvrsavanjeOperacije(Object o) throws Exception;
	
    /**
     * Vraca rezultat koji je izvrsena sistemska operacija uradila
     * @return Rezultat sistemske operacije kao tip Object
     */
	public Object getResult() {
        return result;
    }
	
        /**
         * Izvrsavanje citave sistemske operacije i metoda koja se jedina moze pozvati
         * Template method pattern upotrebljen da se mora postovati algoritam izvrsavanja
         * Prvo se mora proci validacija pa onda se prelazi na samo izvrsavanje
         * @param o Objekat nad kojim se izvrsava operacija
         * @throws java.lang.Exception ukoliko sistemska operacija u bilo kom trenutku nije mogla da se obavi
         */
	@Transactional
	 public void izvrsi(Object o) throws Exception{
	        try {
	             validate(o);
	        izvrsavanjeOperacije(o);
	        } catch (Exception e) {
                    e.printStackTrace();
	             throw new Exception("Neuspesno izvrsavanje sistemske operacije: " + e.getMessage());
	            
	        }
	 }
	
}
