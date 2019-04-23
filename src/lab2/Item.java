package lab2;


/**
 * Klasa przedmiotu, przechowuje wagê wartoœc i nr przedmiotu
 * @author pas109
 *
 */
public class Item {
	/**
	 * wartosc przedmiotu
	 */
	float value; 
	
	/**
	 * waga przedmiotu
	 */
	int weight; 
	
	/**
	 * nr przedmiotu
	 */
	int nr;
	
	/**
	 * 
	 * @param value - wartosc przedmiotu
	 * @param weight - waga przedmiotu
	 * @param nr - nr przedmiotu
	 */
	public Item(float value, int weight, int nr) {
		this.value = value;
		this.weight = weight;
		this.nr = nr;
	}
	
	/**
	 * getter zwracajacy wartosc przedmiotu
	 * @return wartosc przedmiotu
	 */
	public float getValue(){
		return value;
	}
	
	/**
	 * getter zwracajacy nr przedmiotu
	 * @return nr przedmiotu
	 */
	public int getNr(){
		return nr;
	}
	
	
	/**
	 * getter zwracajacy wage przedmiotu
	 * @return waga przedmiotu
	 */
	public int getWeight(){
		return weight;
	}
}




