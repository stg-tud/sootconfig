package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import java.util.List;

import soot.Scene;
import soot.SootMethod;

public interface EntryPointCalculator {

	public abstract List<SootMethod> calculateEntryPoints(Scene scene);

}