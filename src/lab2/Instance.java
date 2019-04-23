package lab2;
import java.util.List;


/**
 * @author pas109
 * Klasa prechowuje listê przedmiotów oraz pojemnoœæ plecaka
 */
public class Instance {
	
	/**
	 * lista wszystkich przedmiotów instancji 
	 */
	public List<Item> listarzeczy;
	
	/**
	 * maksymalna waga jak¹ mo¿e plecak trzymaæ
	 */
	int pojemnosc;
	
	/**
	 * 
	 * @param listarzeczy - lista wszystkich przedmiotów instancji 
	 * @param pojemnosc - maksymalna waga jak¹ mo¿e plecak trzymaæ
	 */
	public Instance (List<Item> listarzeczy, int pojemnosc) {
		this.listarzeczy = listarzeczy;
		this.pojemnosc = pojemnosc;
	}
	
	/**
	 * Getter zwracajacy liste przechowujaca przedmioty
	 * @return lista rzeczy
	 */
	public List<Item> getlist()
	{
		return listarzeczy;
	}
	
	/**
	 * Getter zwracajacy pojemnosc plecaka
	 * @return maksymalna pojemnosc plecaka
	 */
	public int getpojemnosc()
	{
		return pojemnosc;
	}
	
	
}
