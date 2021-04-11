package Ch21_Sets_and_Maps;
import java.util.*;
public class Maps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		{Map is a container object that stores a collection of key/value pairs}
//		 It enables fast retrieval, deletion, and updating of the pair through the key
//		 Each key(ex.10-111) maps to one value(ex.Johb)
		
//		3 types of maps: HashMap, LinkedHashMap, and TreeMap
		
		
//	...	Map<K,V> methods:
//		
//		+clear(): void 								Removes all entries from this map.
//		+containsKey(key: Object): boolean			Returns true if this map contains an entry for the
//		 													specified key.
//		+containsValue(value: Object): boolean		Returns true if this map maps one or more keys to the
//		 													specified value.
//		+entrySet(): Set<Map.Entry<K,V>>			Returns a set consisting of the entries in this map
//		+get(key: Object): V						Returns the value for the specified key in this map
//		+isEmpty(): boolean							Returns true if this map contains no entries
//		+keySet(): Set<K>							Returns a set consisting of the keys in this map.
//		+put(key: K, value: V): V					Puts an entry into this map.
//		+putAll(m: Map<? extends K,? extends V>): void	Adds all the entries from m to this map.
//		+remove(key: Object): V						Removes the entries for the specified key.
//		+size(): int								Returns the number of entries in this map
//		+values(): Collection<V>					Returns a collection consisting of the values in this map.
		
//		
//		The update methods include: 
//			clear,					removes all entries from the map
//			put(K key, V value) , 	adds an entry for the specified key and value in the map. 
//			putAll(Map m) , 		adds all entries in m to this map
//			remove(Object key)		removes the entry for the specified key from the map.
//		The query methods include:
//			containsKey(Object key)			whether the map contains an entry for the specified key
//			containsValue(Object value)  	checks whether the map contains an entry for this value
//			isEmpty()						checks whether the map contains anentries.
			
		
//		Map.Entry<K,V>	
//			
//		+getKey(): K
//		+getValue(): V
//		+setValue(value: V): void	
//			
//		Returns the key from this entry.
//		Returns the value from this entry.
//		Replaces the value in this entry with a new value.	
//			
		
//		
//	...	{HashMap<K,V>	: is efficient for locating a value, inserting an entry, and deleting an entry.}
//		
//		+HashMap()
//		+HashMap(m: Map<? extends K, ? extends V>)
//		+HashMap(initialCapacity: int,loadFactor: float)
//		
//	...	LinkedHashMap<K,V>		(HashMap)	:with a linked-list implementation that supports an
//												ordering of the entries in the map
//		
//		+LinkedHashMap()
//		+LinkedHashMap(m: Map<? extends K,? extends V>)
//		+LinkedHashMap(initialCapacity: int, loadFactor: float, accessOrder: boolean)
//		
//		
//	...	SortedMap<K,V>				:guarantees that the entries in the map are sorted		
//		+firstKey(): K
//		+lastKey(): K
//		+comparator(): Comparator<? super K>)
//		+headMap(toKey: K): SortedMap<K,V>
//		+tailMap(fromKey: K): SortedMap<K,V>
//		
//	...	NavigableMap<K, V>			(SortedMap)
//		+floorKey(key: K): K
//		+ceilingKey(key: K): K
//		+lowerKey(key: K): K
//		+higherKey(key: K): K
//		+pollFirstEntry(): Map.EntrySet<K, V>
//		+pollLastEntry(): Map.EntrySet<K, V>
//		
//	...	.TreeMap<K,V>			(SortedMap, NavigableMap)		:efficient for traversing the keys in a sorted order	
//								: use the TreeMap(Comparator comparator) constructor to create a sorted map 
//								that uses the compare method in the comparator to order the entries in the map based on the keys.
//		+TreeMap()
//		+TreeMap(m: Map<? extends K,? extends V>)
//		+TreeMap(c: Comparator<? super K>)

		//example:
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", 30);
		hashMap.put("Anderson", 31);
		System.out.println(hashMap + "\n");
		
		
	//21.6 Case Study: Occurrences of Words		p839
//		public static void main(String[] args) {
//			 5 // Set text in a string
//			 6 String text = "Good morning. Have a good class. " +
//			 7 "Have a good visit. Have fun!";
//			 8
//			 9 // Create a TreeMap to hold words as key and count as value
//			10 Map<String, Integer> map = new TreeMap<>();
//			11
//			12 String[] words = text.split("[ \n\t\r.,;:!?(){");
//			13 for (int i = 0; i < words.length; i++) {
//			14 String key = words[i].toLowerCase();
//			15
//			16 if (key.length() > 0) {									##method here
//			17 	if (!map.containsKey(key)) {
//			18 		map.put(key, 1);
//			19 }
//			20 	else {
//			21 		int value = map.get(key);
//			22 		value++;
//			23 		map.put(key, value);
//			24 }
//			25 }
//			26 }
//			27
//			28 // Get all entries into a set
//			29 Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//			30
//			31 // Get key and value from each entry
//			32 for (Map.Entry<String, Integer> entry: entrySet)
//			33 System.out.println(entry.getValue() + "\t" + entry.getKey());
		
		
		
		
		
		
		
		
	}

}
