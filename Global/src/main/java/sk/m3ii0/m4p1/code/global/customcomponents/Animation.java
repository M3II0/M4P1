package sk.m3ii0.m4p1.code.global.customcomponents;

import java.util.ArrayList;
import java.util.List;

public class Animation <U> {
	
	private final int delay;
	private final List<U> objects = new ArrayList<>();
	private int currentFrame;
	private long lastUpdate;
	
	public Animation(int delay) {
		this.delay = delay;
	}
	
	public U getNextFrame() {
		long current = System.currentTimeMillis();
		U value;
		if (lastUpdate == 0L) {
			currentFrame = 0;
		} else {
			long difference = current - lastUpdate;
			int frames = (int) (difference/delay);
			currentFrame += frames;
			if (currentFrame >= size()) {
				currentFrame = currentFrame-size();
			}
		}
		value = safePick(currentFrame);
		lastUpdate = current;
		return value;
	}
	
	public void addFrame(U frame) {
		objects.add(frame);
	}
	
	public U getFrameAt(int position) {
		return safePick(position);
	}
	
	public void skipFrames(int frames) {
		for (int i = 0; i <= frames; i++) {
			if (currentFrame+1 >= size()) {
				currentFrame = 0;
				continue;
			}
			++currentFrame;
		}
	}
	
	public void clear() {
		objects.clear();
	}
	
	public void reset() {
		lastUpdate = 0L;
	}
	
	public int getTotalTime() {
		return delay* size();
	}
	
	public int size() {
		return objects.size();
	}
	
	public Animation<U> detachCopy() {
		return new Animation<>(delay);
	}
	
	private U safePick(int frame) {
		if (objects.size() <= frame) return null;
		return objects.get(frame);
	}
	
}
