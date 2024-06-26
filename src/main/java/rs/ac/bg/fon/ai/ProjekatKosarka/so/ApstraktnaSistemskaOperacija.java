package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Log;

/**
 * Klasa ApstraktnaSistemskaOperacija je opsta apstraktna klasa koju svaka
 * sistemska operacija nasledjuje Odredjuje sta svaka sistemska operacija mora
 * da ispostuje da bi bila deo sistema.
 * Posle svake sistemske operacije, belezi se u json fajl 
 * da li je uspesno i kada svaka od sistemskih operacija bila izvrsena
 *
 * @author Boban Todic
 */
public abstract class ApstraktnaSistemskaOperacija {

   /**
    * Aplikacijski kontekst springa
    */ 
    @Autowired
    private ApplicationContext applicationContext;
    /**
     * Oznacava da li se sistemska operacija izvrsila uspesno ili ne
     */
    private boolean successfull=true;
        
    /**
     * Sluzi za poziv json logera sistemske operacije
     */
	private JSONLog jsonl;
        /**
         * Pomocni objekat log u koji se upisiju podaci o sistemskoj operaciji,
         * i koji se kasnije smesta u json fajl
         */
        @Autowired
        private Log log;
    
    /**
     * Rezultat sistemske operacije se smesta u ovaj parametar
     */
    protected Object result;

    /**
     * Validacija prosledjenog objekta Svaka nasledjena klasa mora dati svoju
     * implementaciju ove metode
     *
     * @param o Objekat koji je prosledjen
     * @throws java.lang.Exception odnosno baca bilo koju podklasu ovog
     * exception-a u zavisnosti od potreba, nasledjena klasa bira vrstu izuzetka
     */
    @Transactional
    protected abstract void validate(Object o) throws Exception;

    /**
     * Konkretno izvrsavanje same sistemske operacije. Svaka nasledjena klasa
     * mora pruziti implementaciju
     *
     * @param o Objekat nad kojim se izvrsava
     * @throws java.lang.Exception tj njene nasledjene stvari ukoliko operacija
     * nije uspela da se izvrsi sa bazom
     */
    @Transactional
    protected abstract void izvrsavanjeOperacije(Object o) throws Exception;

    /**
     * Vraca rezultat koji je izvrsena sistemska operacija uradila
     *
     * @return Rezultat sistemske operacije kao tip Object
     */
    public Object getResult() {
        return result;
    }

    /**
     * Izvrsavanje citave sistemske operacije i metoda koja se jedina moze
     * pozvati Template method pattern upotrebljen da se mora postovati
     * algoritam izvrsavanja Prvo se mora proci validacija pa onda se prelazi na
     * samo izvrsavanje
     *  Bez obzira da li sistemska operacija bila uspesna ili ne, na kraju se izvrsava finnaly blok
     * u kome se poziva json loger da upise koja sistemska operacija je izvrsena,
     * u kom vremenskom trenutku i da li je uspesna
     *
     * @param o Objekat nad kojim se izvrsava operacija
     * @throws java.lang.Exception ukoliko sistemska operacija u bilo kom
     * trenutku nije mogla da se obavi
     */
    @Transactional
    public void izvrsi(Object o) throws Exception {
        try {
            validate(o);
            izvrsavanjeOperacije(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Neuspesno izvrsavanje sistemske operacije: " + e.getMessage());

        } finally {

            Log log = new Log(this.getClass().getName(), new Date(), successfull);
            jsonl = (JSONLog) applicationContext.getBean(JSONLog.class);
            jsonl.setLog(log);
            jsonl.izvrsi();
            System.out.println("ok");
        }
    }

}
