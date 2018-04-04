package com.github.vesm03.du1.ui;


import com.github.vesm03.du1.logika.Hra;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Třída slouží ke spuštění aplikace.
 * Při spuštění bez parametru konstruuje okno aplikace,
 * s parametrem -text se spouští v textovém režimu
 * 
 * @author Martin Vesely
 *
 */
public class Application extends javafx.application.Application {

	/**
	 * Spouštěcí metoda pro aplikaci
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
            launch(args);
		}
	}
	/**
	 * Metoda, ve které se konstruuje okno, kontroler a hra,
	 * která se předává kontroleru
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource("Home.fxml"));
		Parent root = loader.load();

		HomeController controller = loader.getController();
		controller.inicializuj(new  Hra());
		
        primaryStage.setTitle("Angličtina");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

}
