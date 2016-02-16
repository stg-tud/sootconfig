package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import java.util.Collections;
import java.util.List;

import soot.Scene;
import soot.SootMethod;

public class ZeroEntryPoints implements EntryPointCalculator {

	private static ZeroEntryPoints instance = null;

	private ZeroEntryPoints() {}

	public static ZeroEntryPoints v() {
		if (instance == null)
			instance = new ZeroEntryPoints();
		return instance;
	}


	@Override
	public List<SootMethod> calculateEntryPoints(Scene scene) {
		return Collections.emptyList();
	}

}
