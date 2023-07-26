package sk.m3ii0.m4p1.code.global.objects;

import sk.m3ii0.m4p1.code.global.utils.MathUtils;

import java.util.*;

public class PercentageList<T> implements Map<Double, List<T>> {
	
	private final Map<Double, List<T>> items = new HashMap<>();
	
	public PercentageList() {}
	
	public T pickRandom() {
		double percentage = MathUtils.generateRandomDouble(0, 100);
		int size = size();
		
	}
	
	private List<Entry<Double, List<T>>> getCopy(double number) {
		List<Entry<Double, List<T>>> result = new ArrayList<>();
		for (Entry<Double, List<T>> entry : items.entrySet()) {
			if (entry.getKey() <= number) {
				result.add(entry);
			}
		}
		return result;
	}
	
	@Override
	public int size() {
		int size = 0;
		for (List<T> vars : items.values()) {
			size += vars.size();
		}
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	@Override
	public boolean containsKey(Object key) {
		return items.containsKey(key);
	}
	
	@Override
	public boolean containsValue(Object value) {
		for (List<T> vars : items.values()) {
			for (T var : vars) {
				if (var.equals(value)) return true;
			}
		}
		return false;
	}
	
	@Override
	public List<T> get(Object key) {
		return items.get(key);
	}
	
	@Override
	public List<T> put(Double key, List<T> value) {
		List<T> vars = items.getOrDefault(key, new ArrayList<>());
		vars.addAll(value);
		items.put(key, vars);
		return vars;
	}
	
	@Override
	public List<T> remove(Object key) {
		return items.remove(key);
	}
	
	@Override
	public void putAll(Map<? extends Double, ? extends List<T>> m) {
		for (double var : m.keySet()) {
			List<T> vars = items.getOrDefault(var, new ArrayList<>());
			vars.addAll(m.get(var));
			items.put(var, vars);
		}
	}
	
	@Override
	public void clear() {
		items.clear();
	}
	
	@Override
	public Set<Double> keySet() {
		return items.keySet();
	}
	
	@Override
	public Collection<List<T>> values() {
		return items.values();
	}
	
	@Override
	public Set<Entry<Double, List<T>>> entrySet() {
		return items.entrySet();
	}
	
}
