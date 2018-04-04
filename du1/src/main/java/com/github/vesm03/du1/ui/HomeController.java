package com.github.vesm03.du1.ui;

import java.util.Observable;
import java.util.Observer;

import com.github.vesm03.du1.logika.IHra;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

import javax.swing.JOptionPane;

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
	private String vyberObrazku = "";
	private String obrazek = "";
	private int last = 10;
	@FXML private Label hadej;
	@FXML private Label spravne;
	@FXML private Label spatne;
	@FXML private Button bStrawberry;
	@FXML private Button bPear;
	@FXML private Button bMelon;
	@FXML private Button bOrange;
	@FXML private Button bPepper;
	@FXML private Button bCarrot;
	@FXML private MenuItem newGame;
	@FXML private MenuItem endGame;
	
	public void setLast(int cislo){
		last = cislo;
	}
	
	public int getLast(){
		return last;
	}
	
	public void setVyberObrazku(String obrazek){
		vyberObrazku = obrazek;
	}
	
	public String getVyberObrazku(){
		return vyberObrazku;
	}
	
	public void setObrazek(String obrazek){
		this.obrazek = obrazek;
	}
	
	public String getObrazek(){
		return obrazek;
	}
	
	public void setSpravne(){
		int cislo = Integer.parseInt(getSpravne()) + 1;
		spravne.setText(Integer.toString(cislo));
	}
	
	public String getSpravne(){
		return spravne.getText();
	}
	
	public void setSpatne(){
		int cislo = Integer.parseInt(getSpatne()) + 1;
		spatne.setText(Integer.toString(cislo));
	}
	
	public String getSpatne(){
		return spatne.getText();
	}
	
	public void checkVyberObrazku(){
		if(getVyberObrazku() == getObrazek()){
			setSpravne();
			JOptionPane.showMessageDialog(null, "Správně!");
		}
		else{
			setSpatne();
			JOptionPane.showMessageDialog(null, "Špatně!");
		}
	}
	
	public void klikObrazek1(){
		setVyberObrazku("strawberry");
		checkVyberObrazku();
	}
	
	public void klikObrazek2(){
		setVyberObrazku("pear");
		checkVyberObrazku();
	}
	
	public void klikObrazek3(){
		setVyberObrazku("melon");
		checkVyberObrazku();
	}
	
	public void klikObrazek4(){
		setVyberObrazku("orange");
		checkVyberObrazku();
	}
	
	public void klikObrazek5(){
		setVyberObrazku("pepper");
		checkVyberObrazku();
	}
	
	public void klikObrazek6(){
		setVyberObrazku("carrot");
		checkVyberObrazku();
	}
	
	public void hadejSlovo(){
		Random generator = new Random();
		int  cislo = generator.nextInt(6) + 1;
		if(cislo == getLast()) {
			while (cislo == getLast()) {
				cislo = generator.nextInt(6) + 1;
			}
		}
		switch (cislo) {
			case 1:  setObrazek("strawberry");
                break;
			case 2:  setObrazek("pear");
                break;
			case 3:  setObrazek("melon");
				break;
			case 4:  setObrazek("orange");
                break;
			case 5:  setObrazek("pepper");
                break;
			case 6:  setObrazek("carrot");
                break;
        
			default: setObrazek("strawberry");
                break;
		}
		hadej.setText(getObrazek());
		setLast(cislo);
	}
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		this.hra = hra;
		spravne.setText("0");
		spatne.setText("0");
		hadej.setText("");
	}
	
	public void newGame() {
		spravne.setText("0");
		spatne.setText("0");
		hadej.setText("");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//dodelat updaty pro observer
	}

}
