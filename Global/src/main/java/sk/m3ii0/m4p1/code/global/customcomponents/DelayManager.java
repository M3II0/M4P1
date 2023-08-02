package sk.m3ii0.m4p1.code.global.customcomponents;

import java.util.HashMap;
import java.util.Map;

public class DelayManager<O> {
	
	private final Map<O, Long> delays = new HashMap<>();
	
	public DelayManager() {}
	
	public void setDelay(O object, int seconds) {
		delays.put(object, System.currentTimeMillis() + (seconds * 1000L));
	}
	
	public boolean hasDelay(O object) {
		long sysTime = System.currentTimeMillis();
		long remaining = delays.getOrDefault(object, 0L);
		if (remaining > sysTime) {
			return true;
		}
		delays.remove(object);
		return false;
	}
	
	public int getDelayInt(O object) {
		return (int) getDelayDouble(object);
	}
	
	public double getDelayDouble(O object) {
		boolean hasDelay = hasDelay(object);
		if (!hasDelay) return 0;
		long sysTime = System.currentTimeMillis();
		long remaining = delays.get(object)-sysTime;
		return  (double) remaining/1000.0;
	}
	
	public Map<O, Long> getRawMapCopy() {
		return new HashMap<>(delays);
	}
	
}
