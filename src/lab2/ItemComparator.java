package lab2;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item>{
	public int compare(Item item1, Item item2) {
		return (int) (item1.getValue()/item1.getWeight() - item1.getValue()/item1.getWeight());
	}
}