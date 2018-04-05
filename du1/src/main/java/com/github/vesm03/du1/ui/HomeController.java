package com.github.vesm03.du1.ui;

import java.util.Observable;
import java.util.Observer;


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
	

	/**
	 * Metoda nastavuje cislo posledne hadaneho ovoce do pameti
	 * aby pri opetovnem hadani mohlo dojit ke kontrole, zda 
	 * by se nehadalo stejne ovoce
	 * @param cislo hadaneho ovoce
	 */
	public void setLast(int cislo){
		last = cislo;
	}
	
	/**
	 * Metoda vraci cislo posledne hadaneho ovoce
	 */
	public int getLast(){
		return last;
	}
	
	/**
	 * Metoda uklada do promenne uzivatelem vybrany obrazek ovoce
	 * @param nazev ovoce
	 */
	public void setVyberObrazku(String obrazek){
		vyberObrazku = obrazek;
	}
	
	/**
	 * Metoda vraci nazev uzivatelem vybraneho obrazku
	 */
	public String getVyberObrazku(){
		return vyberObrazku;
	}
	
	/**
	 * Metoda uklada do promenne programem vybrany obrazek ovoce
	 * @param nazev ovoce
	 */
	public void setObrazek(String obrazek){
		this.obrazek = obrazek;
	}
	
	/**
	 * Metoda vraci nazev programem vybraneho obrazku
	 */
	public String getObrazek(){
		return obrazek;
	}
	
	/**
	 * Metoda pricita pocet spravne zodpovezenych otazek
	 */
	public void setSpravne(){
		int cislo = Integer.parseInt(getSpravne()) + 1;
		spravne.setText(Integer.toString(cislo));
	}
	
	/**
	 * Metoda vraci pocet spravne zodpovezenych odpovedi
	 */
	public String getSpravne(){
		return spravne.getText();
	}
	
	/**
	 * Metoda pricita pocet spatne zodpovezenych otazek
	 */
	public void setSpatne(){
		int cislo = Integer.parseInt(getSpatne()) + 1;
		spatne.setText(Integer.toString(cislo));
	}
	
	/**
	 * Metoda vraci pocet spatne zodpovezenych odpovedi
	 */
	public String getSpatne(){
		return spatne.getText();
	}
	
	/**
	 * Metoda kontroluje spravnost odpovedi
	 * podle odpovedi zobrazi dialogove okno se zpravou
	 * spravna nebo spatna odpoved
	 */
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
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 1, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek1(){
		setVyberObrazku("strawberry");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 2, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek2(){
		setVyberObrazku("pear");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 3, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek3(){
		setVyberObrazku("melon");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 4, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek4(){
		setVyberObrazku("orange");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 5, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek5(){
		setVyberObrazku("pepper");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda nastavuje do promenne nazev obrazku 6, pokud
	 * na nej uzivatel kliknul
	 */
	public void klikObrazek6(){
		setVyberObrazku("carrot");
		checkVyberObrazku();
	}
	
	/**
	 * Metoda vygeneruje nahodne slovo, ktere ma uzivatel uhodnout,
	 * zaroven kontroluje, zda nebylo stejne slovo hadano v predchozim tahu,
	 * pokud ano, vygeneruje nove slovo a dela to tak dlouho, dokud nevygeneruje
	 * jina slovo, nez v predchozim tahu
	 * cislo hadaneho slova ulozi do promenne
	 */
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
	 * pocatecni nastaveni hodnot pocitadel a textu s hadanym slovem
	 * pri spusteni hry
	 */
	public void inicializuj() {
		spravne.setText("0");
		spatne.setText("0");
		hadej.setText("");
	}
	
	/**
	 * resetovani pocitadel a hadaneho textu na vychozi hodnoty
	 */
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
