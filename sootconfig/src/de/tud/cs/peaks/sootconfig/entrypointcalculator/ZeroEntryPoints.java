package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import java.util.Collections;
import java.util.List;

import soot.Scene;
import soot.SootMethod;

public class ZeroEntryPoints implements EntryPointCalculator {

	@Override
	public List<SootMethod> calculateEntryPoints(Scene scene) {
		return Collections.emptyList();
	}

}
