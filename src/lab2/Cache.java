package lab2;

 
import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
 
public class Cache{
	public static int cacheMiss = 0;
	public static int cacheHit = 0;
	
    private final ConcurrentHashMap<Long, SoftReference<Result>> cache = new ConcurrentHashMap<>();

    public void add(Long key, Float rozw, Instance instancja, String algorytm) {
        if (cache.get(key) != null) {
        	cacheHit++;
            return;
        }
        cache.put(key, new SoftReference<>(new Result(rozw,instancja,algorytm)));
        cacheMiss++;
    }
 
    public void remove(Long key) {
        cache.remove(key);
    }

    public Object get(Long key) {
        //return Optional.ofNullable(cache.get(key)).map(SoftReference::get).filter(cacheObject -> !cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
    	if(cache.get(key)== null)
    		cacheMiss++;
    	else
    		cacheHit++;
    	//	return (SoftReference::get)cache.get(key);
    	return Optional.ofNullable(cache.get(key)).map(SoftReference::get).map(Result::Rozwiazanie).orElse(null);
    }
    
    public float getHitRatio() {
    	if (cacheMiss+cacheHit > 0)
    		return (float)cacheHit/(cacheMiss+cacheHit);
    	else return 0;
    }

    private static class Result {

        private Float rozw;
        private Instance instancja;
        private String algorytm;
        
        Result(Float rozw, Instance instancja, String algorytm) {
        	this.rozw = rozw;
        	this.instancja = instancja;
        	this.algorytm = algorytm;
        }
        
        public Float getRozw() {
        	return rozw;
        }
        public Instance getInstancja() {
        	return instancja;
        }
        public String getAlgorytm() {
        	return algorytm;
        }
        
        public String Rozwiazanie() {
        	return rozw + "\nalgorytm: " + algorytm;
        }
    }
}