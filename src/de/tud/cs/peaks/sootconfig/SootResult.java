package de.tud.cs.peaks.sootconfig;

import com.google.common.base.Stopwatch;

import soot.G;
import soot.Scene;

public class SootResult {
	private final Stopwatch totalSootRuntime = new Stopwatch();
	private final Stopwatch classLoadRuntime = new Stopwatch();
	private final Stopwatch entryPointCalculationRuntime = new Stopwatch();
	private final Stopwatch packRuntime = new Stopwatch();

	private Scene scene;

	private G sootGlobal;

	public G getSootGlobal() {
		return this.sootGlobal;
	}

	public void setSootGloabel(G global) {
		this.sootGlobal = global;
	}

	public Scene getScene() {
		return this.sootGlobal.soot_Scene();
	}

	private String completeOutput;

	public String getCompleteOutput() {
		return this.completeOutput;
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
