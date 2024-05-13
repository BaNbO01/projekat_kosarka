package rs.ac.bg.fon.ai.ProjekatKosarka;

import java.awt.GraphicsEnvironment;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.ai.ProjekatKosarka.view.MainFrame;

@Component
@Profile("prod")
public class Main implements ApplicationRunner {

	@Autowired
	ApplicationContext applicationContext;

	MainFrame frame;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
			frame = applicationContext.getBean(MainFrame.class);
			frame.setVisible(true);
		
	}

}
