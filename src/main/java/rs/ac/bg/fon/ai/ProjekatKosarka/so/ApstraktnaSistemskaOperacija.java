package rs.ac.bg.fon.ai.ProjekatKosarka.so;


import org.springframework.transaction.annotation.Transactional;



public abstract class ApstraktnaSistemskaOperacija {

	
	
	protected Object result;
	
	
	
	
	@Transactional
	protected abstract void validate(Object o) throws Exception;
	
	@Transactional
    protected abstract void izvrsavanjeOperacije(Object o) throws Exception;
	
	public Object getResult() {
        return result;
    }
	
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
