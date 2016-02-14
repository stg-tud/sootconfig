package de.tud.cs.peaks.sootconfig;

import soot.G;
import soot.Scene;

import com.google.common.base.Stopwatch;

public class SootResult {
	private final Stopwatch totalSootRuntime = Stopwatch.createUnstarted();
	private final Stopwatch classLoadRuntime = Stopwatch.createUnstarted();
	private final Stopwatch entryPointCalculationRuntime = Stopwatch.createUnstarted();
	private final Stopwatch packRuntime = Stopwatch.createUnstarted();

	private Scene scene;

	private G sootGlobal;

	public G getSootGlobal() { return sootGlobal; }

	public void setSootGloabel(G global) { this.sootGlobal = global; }

	public Scene getScene() { return sootGlobal.soot_Scene(); }

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
