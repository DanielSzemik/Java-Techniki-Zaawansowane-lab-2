package lab2;

import java.util.List;

/**
 * klasa przechowuje rozwiazanie problemu
 * @author pas109
 *
 */
public class Solution {
	
	/**
	 * rozwiazanie przechowywana jest w tablicy integerów, jedynka 
	 * oznacza i¿ przedmiot jest zawarty w rozwi¹zaniu
	 */
	int[] rozwiazanie;
	private int weightSum;
	private float valueSum;
	/**
	 * 
	 * @param rozwiazanie - rozwiazanie problemu
	 */
	public Solution(int[] rozwiazanie)
	{
		this.rozwiazanie = rozwiazanie;
	}
	
	/**
	 * metoda wyswietla wynik, printuje cechy przedmiotów w rozwi¹zaniu oraz
	 * sumy ich wag i wartosci
	 * 
	 * @param lista lista przedmiotow typu Item
	 */
	public void wyswwynik(List<Item> lista) {
		int n = 1;
		int totalweight = 0;
		float totalvalue = 0;
		for(int i=0; i<rozwiazanie.length;i++)
		{
			if (rozwiazanie[i]==1)
			{
				System.out.println("Przedmiot " +  lista.get(i).getNr() + ": Waga - " + lista.get(i).getWeight() + " Wartosc - " + lista.get(i).getValue());
				totalweight += lista.get(i).getWeight();
				totalvalue += lista.get(i).getValue();
				n++;
			}
		}
		System.out.println("Suma wag: " + totalweight + " Suma wartosci: " + totalvalue);
	}
	
	public void policzSume(List<Item> lista) {
		int n = 1;
		int totalweight = 0;
		float totalvalue = 0;
		for(int i=0; i<rozwiazanie.length;i++)
		{
			if (rozwiazanie[i]==1)
			{
				totalweight += lista.get(i).getWeight();
				totalvalue += lista.get(i).getValue();
				n++;
			}
		}
		weightSum = totalweight;
		valueSum = totalvalue;
	}
	
	public int getWeightSum()
	{
		return weightSum;
	}
	public float getValueSum()
	{
		return valueSum;
	}
	
	
	
	public String ResultPL(List<Item> lista) {
		String rozw = "";
		int n = 0;
		int totalweight = 0;
		float totalvalue = 0;
		
		for(int i=0; i<rozwiazanie.length;i++)
		{
			if (rozwiazanie[i]==1)
			{
				rozw = rozw + ("Przedmiot:  Nr " +  lista.get(i).getNr() + ", Waga - " + lista.get(i).getWeight() + ", Wartość - " + 
						lista.get(i).getValue()) + "\n";
				totalweight += lista.get(i).getWeight();
				totalvalue += lista.get(i).getValue();
				n++;
			}
		}
		rozw = rozw + "Suma wag: " + totalweight + " Suma wartośći: " + totalvalue + " Ilość przedmiotów: " + n;
		return rozw;
	}
	
	
}
