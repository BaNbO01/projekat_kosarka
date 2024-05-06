package rs.ac.bg.fon.ai.ProjekatKosarka;

import java.util.List;
import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import rs.ac.bg.fon.ai.ProjekatKosarka.view.MainFrame;


@Component
public class Main implements ApplicationRunner {

	
	
        
      
        MainFrame frame;

          @Autowired
    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }
	@Override
	public void run(ApplicationArguments args) throws Exception {

		
            frame.setVisible(true);
	}
       

}
