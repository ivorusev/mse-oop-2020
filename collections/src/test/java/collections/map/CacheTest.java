package collections.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import collectons.map.cache.LRUCache;
import collectons.map.cache.Person;

class CacheTest {

	@Test
	public void testCacheInsertion() {
		Person personA = new Person("Ivan", 185, 80);
		Person personB = new Person("Dragan", 175, 70);
		Person personC = new Person("Petkan", 190, 100);

		LRUCache<String, Person> cache = new LRUCache<>(2);
		cache.put(personA.getName(), personA);
		cache.put(personB.getName(), personB);
		cache.put(personC.getName(), personC);

		Person actual = cache.get(personB.getName());
		assertEquals(personB, actual);

		actual = cache.get(personC.getName());
		assertEquals(personC, actual);
	}

	@Test
	public void testCacheGet() {
		Person personA = new Person("Ivan", 185, 80);
		Person personB = new Person("Dragan", 175, 70);
		Person personC = new Person("Petkan", 190, 100);

		LRUCache<String, Person> cache = new LRUCache<>(3);
		cache.put(personA.getName(), personA);
		cache.put(personB.getName(), personB);
		cache.put(personC.getName(), personC);

		Person actual = cache.get(personA.getName());
		assertEquals(personA, actual);

		actual = cache.get(personB.getName());
		assertEquals(personB, actual);

		Person personD = new Person("Override", 199, 99);
		cache.put(personD.getName(), personD);

		assertNull(cache.get(personC));
	}

}
