package de.tud.cs.peaks.sootconfig.entrypointcalculator;

import java.util.LinkedList;
import java.util.List;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public abstract class FilteredMethodsEP implements EntryPointCalculator {

	public FilteredMethodsEP() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.tud.cs.peaks.sootconfig.EntryPointCalculator#calculateEntryPoints(soot.Scene)
	 */
	@Override
	public List<SootMethod> calculateEntryPoints(Scene scene) {
		List<SootMethod> entryMethods = new LinkedList<SootMethod>();

		for (SootClass c : scene.getApplicationClasses()) {
			for (SootMethod m : c.getMethods())
				if (!entryMethodFilter(m))
					entryMethods.add(m);
		}
		return entryMethods;
	}

	protected abstract boolean entryMethodFilter(SootMethod m);



}