package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import soot.SootMethod;

public class AllConcreteMethodsEP extends FilteredMethodsEP {

	private static AllConcreteMethodsEP instance = null;

	private AllConcreteMethodsEP() {

	}

	public static AllConcreteMethodsEP v() {
		if (instance == null) {
			instance = new AllConcreteMethodsEP();
		}
		return instance;
	}

	protected boolean entryMethodFilter(SootMethod m) {
		if (!m.isConcrete())
			return true;
		return false;
	}

}
