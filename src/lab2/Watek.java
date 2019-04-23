package lab2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings({ "unchecked", "rawtypes" })
class Watek implements Runnable {
	int nr;
	long key;
	long seed;
	Thread t;
	Random rand = new Random();
	Random seededrand = new Random();
	int instance;
	int nr_of_items;
	int max_weight;
	int ItWeight;
	int ItValue;
	int algChoice;
	int nr_of_alg;
	Watek(int threadnumber) {
		this.nr = threadnumber;
		t = new Thread(this, String.valueOf(nr));
		t.start();
	}
	
	public void run() {
	try {
		while (true){
		Thread.sleep(2000 + rand.nextInt(5000));
		if(Main.classes == null)
		{
			Main.ConsolePrint("W. " + nr + " natrafil na sytuacje gdzie nie sa zaladowane zadne algorytmy, przechodzi do nastepnego cyklu");
			continue;
		}
		nr_of_alg = Main.classes.length;

		List<Item> rzeczy = new ArrayList<Item>();
		
		key = rand.nextInt(Main.MAX_KEY);
		if (Main.cache.get(key)!=null )
		{
			Main.ConsolePrint("W. " + nr + " nie liczy instancji nr: " + key + ", poniewaz jest juz w pamieci");
			continue;
		}
		seededrand.setSeed(key);
		instance = seededrand.nextInt(1000);
		nr_of_items = (instance % Main.MAX_ITEM_NR)+1;
		for (int i=0;i<nr_of_items;i++)
		{
			ItWeight = seededrand.nextInt(Main.MAX_ITEM_WEIGHT) + 1;
			ItValue = seededrand.nextInt(Main.MAX_ITEM_VALUE) + 1;
			rzeczy.add(new Item(ItValue,ItWeight,i+1));
		}
		max_weight = seededrand.nextInt(Main.MAX_ITEM_WEIGHT) * nr_of_items;
		Instance instancja = new Instance(rzeczy, max_weight);
		algChoice = seededrand.nextInt(nr_of_alg);
		
		try {	  
			Main.ConsolePrint("W. " + nr + " zaczyna liczenie instancji nr: "+ key + ", algorytmem: " + 
					(Main.classes[algChoice].getName()).replaceAll("algorithms.", ""));
            Method m = Main.classes[algChoice].getMethod("DoAlg", List.class, int.class);
            int[] rozw = (int[])m.invoke(null, instancja.getlist(), instancja.getpojemnosc());
			Solution solution = new Solution(rozw);
			solution.policzSume(instancja.getlist());
			Main.ConsolePrint("W. " + nr + " zakonczyl liczenie instancja nr:" + key + ", l. prz.: "
					+ nr_of_items + ", znaleziona wartosc:" + solution.getValueSum());
			Main.cache.add(key, solution.getValueSum(), instancja, (Main.classes[algChoice].getName()).replaceAll("algorithms.", ""));
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
	
	
}