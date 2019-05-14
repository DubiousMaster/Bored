package main.util;

/**
 * Define a relations between two object types.
 * @author Alex Tigchelaar
 *
 * @param <K> Define a Key type.
 * @param <V> Define a Value type.
 */
public class Pair<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
