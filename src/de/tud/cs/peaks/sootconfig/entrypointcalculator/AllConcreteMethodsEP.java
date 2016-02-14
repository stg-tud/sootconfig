package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import soot.SootMethod;

public class AllConcreteMethodsEP extends FilteredMethodsEP {

	protected boolean entryMethodFilter(SootMethod m) {
		if (!m.isConcrete())
			return true;
		return false;
	}
}
