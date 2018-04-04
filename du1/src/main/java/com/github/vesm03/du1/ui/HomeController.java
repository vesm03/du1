package com.github.vesm03.du1.ui;

import java.util.Observable;
import java.util.Observer;

import com.github.vesm03.du1.logika.IHra;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou aplikace
 * 
 * @author Martin Vesely
 *
 */
public class HomeController extends GridPane implements Observer {
	
	//promenne pro graficke rozhrani
	@FXML private TextField vstupniText;
	private IHra hra;
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		this.hra = hra;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//dodelat updaty pro observer
	}

}
