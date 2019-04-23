package lab2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.lang.reflect.Method;
import java.net.URL;
import java.lang.reflect.Field;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor; 



@SuppressWarnings({ "rawtypes" })
public class Main {
	
	public final static int THREAD_NUMBER = 3;
	public final static int MAX_KEY = 20;
	public final static int MAX_ITEM_WEIGHT = 20;
	public final static int MAX_ITEM_VALUE = 20;
	public final static int MAX_ITEM_NR = 15;
	
	public static Cache cache = new Cache();
	public static Class[] classes = null;
	
	public static void main(String[] args) { 
		/*try {
		Thread.sleep(30000);
		}catch (Exception e) {
            e.printStackTrace();
        }*/
		
		for (int i=0;i<THREAD_NUMBER;i++)
		{
			new Watek(i);
		}
		
		try {
		Thread.sleep(10000);
		}catch (Exception e) {
            e.printStackTrace();
        }
		loadClasses();
		
		//unloadClasses();
		while(true)
		{
			try{
				System.gc();
				Thread.sleep(10000);
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			System.out.println("Odsetek trafien: " + cache.getHitRatio());
		}
		
	}
	private static void loadClasses()
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			classes = getClasses("algorithms");
			for (int i = 0; i<classes.length; i++)
			{
				Class c1 = classLoader.loadClass(Main.classes[i].getName());
			}
		}catch (Exception e) {
            e.printStackTrace();
		}
	}
	private static void unloadClasses()
	{
		System.gc();
		classes = null;
	}
	
	private static String getAlgDesc() {
		String desc = "";
		if (classes!=null) {
			for(int i=0;i<classes.length;i++) {
				desc = "Algorytm " + Integer.toString(i+1) +": "+ desc + classes[i].getName();
			}
			return desc;
		}
		return null;
	}
	
	synchronized public static void ConsolePrint(String msg)
	{
		System.out.println(msg);
	}
	
	
	private static Class[] getClasses(String packageName)
	        throws ClassNotFoundException, IOException{
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    assert classLoader != null;
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    ArrayList<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes.toArray(new Class[classes.size()]);
	}
	
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}
	

}

