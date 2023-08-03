package sk.m3ii0.m4p1.code.global.customcomponents;

import sk.m3ii0.m4p1.code.global.customcomponents.enums.AnimationTiming;
import sk.m3ii0.m4p1.code.global.customcomponents.interfaces.FramesBuilder;

import java.util.List;

public class AnimatedTextCreator {
	
	private final FramesBuilder framesBuilder;
	
	public AnimatedTextCreator(FramesBuilder framesBuilder) {
		this.framesBuilder = framesBuilder;
	}
	
	public Animation<String> createAnimation(String text, int delay) {
		Animation<String> value = new Animation<>(delay);
		List<String> frames = framesBuilder.createFrames(text);
		for (String var : frames) {
			value.addFrame(var);
		}
		return value;
	}
	
	public Animation<String> createAnimation(String text, int delay, AnimationTiming timing) {
		Animation<String> value = new Animation<>(delay, timing);
		List<String> frames = framesBuilder.createFrames(text);
		for (String var : frames) {
			value.addFrame(var);
		}
		return value;
	}
	
	public Animation<String> createAnimation(String text, int delay, boolean repeat) {
		Animation<String> value = new Animation<>(delay, repeat);
		List<String> frames = framesBuilder.createFrames(text);
		for (String var : frames) {
			value.addFrame(var);
		}
		return value;
	}
	
	public Animation<String> createAnimation(String text, int delay, AnimationTiming timing, boolean repeat) {
		Animation<String> value = new Animation<>(delay, timing, repeat);
		List<String> frames = framesBuilder.createFrames(text);
		for (String var : frames) {
			value.addFrame(var);
		}
		return value;
	}
	
}
