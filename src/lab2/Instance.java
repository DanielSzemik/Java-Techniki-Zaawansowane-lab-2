package lab2;
import java.util.List;


/**
 * @author pas109
 * Klasa prechowuje list� przedmiot�w oraz pojemno�� plecaka
 */
public class Instance {
	
	/**
	 * lista wszystkich przedmiot�w instancji 
	 */
	public List<Item> listarzeczy;
	
	/**
	 * maksymalna waga jak� mo�e plecak trzyma�
	 */
	int pojemnosc;
	
	/**
	 * 
	 * @param listarzeczy - lista wszystkich przedmiot�w instancji 
	 * @param pojemnosc - maksymalna waga jak� mo�e plecak trzyma�
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
