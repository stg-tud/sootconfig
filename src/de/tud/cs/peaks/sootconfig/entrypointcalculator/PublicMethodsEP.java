package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import soot.SootMethod;

public class PublicMethodsEP extends FilteredMethodsEP {

	@Override
	protected boolean entryMethodFilter(SootMethod m) {
		if (!m.isConcrete() || !m.isPublic())
			return true;
		return false;
	}

}
