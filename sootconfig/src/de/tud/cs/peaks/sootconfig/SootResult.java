package de.tud.cs.peaks.sootconfig;

import soot.Scene;

import com.google.common.base.Stopwatch;

public class SootResult {
	private final Stopwatch totalSootRuntime = new Stopwatch();
	private final Stopwatch classLoadRuntime = new Stopwatch();
	private final Stopwatch entryPointCalculationRuntime = new Stopwatch();
	private final Stopwatch packRuntime = new Stopwatch();

	private Scene scene;

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	private String completeOutput;

	public String getCompleteOutput() {
		return completeOutput;
	}

	public void setCompleteOutput(String completeOutput) {
		this.completeOutput = completeOutput;
	}

	public Stopwatch totalSootRuntime() {
		return this.totalSootRuntime;
	}

	public Stopwatch classLoadRuntime() {
		return this.classLoadRuntime;
	}

	public Stopwatch entryPointCalculationRuntime() {
		return this.entryPointCalculationRuntime;
	}

	public Stopwatch packRuntime() {
		return this.packRuntime;
	}

}
