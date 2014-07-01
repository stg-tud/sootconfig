package de.tud.cs.peaks.sootconfig;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public final class SceneChecker {

	/***
	 * Checks a scene for missing bodies of concrete methods of non-phantom
	 * non-excluded classes.
	 *
	 * @param scene
	 *            A scene to check
	 * @return true, iff a concrete method has no active body. false otherwise.
	 */
	public static boolean hasForMissingBodies(Scene scene) {
		for (SootClass c : scene.getClasses())
			if (!c.isPhantom() && !scene.isExcluded(c))
				for (SootMethod m : c.getMethods())
					if (m.isConcrete() && !m.hasActiveBody())
						return true;
		return false;
	}

}
