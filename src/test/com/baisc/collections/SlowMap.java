package test.com.baisc.collections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V>{
	
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	@Override
	public V put(K key, V value) {
		V oldValue = get(key);// the old value or null
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);//ArrayList是按顺序存储的?
		}
		return oldValue;
	}
	
	@Override
	public V get(Object key) { //key is type Object . not K
		if(!keys.contains(key)){
			return null;
		}
		return values.get(keys.indexOf(key));
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		Iterator<K> ki = keys.iterator();//Iterable 和 Iterator关系
		Iterator<V> vi = values.iterator();
		while(ki.hasNext()){
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
		}
		return set;
	}

	public static void main(String[] args) {
		SlowMap<String,String> m = new SlowMap<String, String>();
		m.putAll(m);
	}
}
