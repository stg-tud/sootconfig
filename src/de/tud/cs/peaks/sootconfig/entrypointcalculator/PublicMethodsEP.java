package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import soot.SootMethod;

public class PublicMethodsEP extends FilteredMethodsEP {

	private static PublicMethodsEP instance = null;

	private PublicMethodsEP() { }

	public static PublicMethodsEP v() {
		if (instance == null)
			instance = new PublicMethodsEP();
		return instance;
	}

	@Override
	protected boolean entryMethodFilter(SootMethod m) {
		if (!m.isConcrete() || !m.isPublic())
			return true;
		return false;
	}



}
