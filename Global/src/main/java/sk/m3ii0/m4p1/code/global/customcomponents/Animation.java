package sk.m3ii0.m4p1.code.global.customcomponents;

import sk.m3ii0.m4p1.code.global.customcomponents.enums.AnimationTiming;

import java.util.ArrayList;
import java.util.List;

public class Animation <U> {
	
	private final int delay;
	private final boolean repeat;
	private final List<U> objects = new ArrayList<>();
	private int currentFrame;
	private long lastUpdate;
	private final AnimationTiming timing;
	
	public Animation(int delay) {
		this(delay, AnimationTiming.SYSTEM_MILLIS, true);
	}
	
	public Animation(int delay, boolean repeat) {
		this(delay, AnimationTiming.SYSTEM_MILLIS, true);
	}
	
	public Animation(int delay, AnimationTiming timing) {
		this(delay, timing, true);
	}
	
	public Animation(int delay, AnimationTiming timing, boolean repeat) {
		this.delay = delay;
		this.timing = timing;
		this.repeat = repeat;
	}
	
	public U getNextFrame() {
		long current = System.currentTimeMillis();
		U value;
		if (timing == AnimationTiming.SYSTEM_MILLIS) {
			if (lastUpdate == 0L) {
				currentFrame = 0;
			} else {
				long difference = current - lastUpdate;
				int frames = (int) (difference/delay);
				currentFrame += frames;
				if (currentFrame >= size()) {
					if (repeat) {
						currentFrame = currentFrame-size();
					} else {
						currentFrame = size()-1;
					}
				}
			}
		}
		if (timing == AnimationTiming.TAKEN_FRAMES) {
			if (lastUpdate == 0L) {
				currentFrame = 0;
			} else {
				currentFrame += 1;
				if (currentFrame >= size()) {
					if (repeat) {
						currentFrame = 0;
					} else {
						currentFrame = size()-1;
					}
				}
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
