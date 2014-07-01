package de.tud.cs.peaks.sootconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import soot.options.Options;
import soot.util.ArraySet;

public abstract class PhaseOptions {
	private final String phase;
	private final Map<String, String> options = new HashMap<String, String>();
	private final Set<PhaseSubOptions> subOptions = new ArraySet<PhaseSubOptions>();

	public PhaseOptions(String phase) {
		super();
		this.phase = phase;
	}

	public Options apply(Options o) {
		pushToOptionSet();

		for (Map.Entry<String, String> entry : this.options.entrySet()) {
			o.setPhaseOption(phase, entry.getKey() + ":" + entry.getValue());
		}
		for (PhaseSubOptions pso : subOptions) {
			pso.pushToOptionSet();
			for (Map.Entry<String, String> entry : pso.entrySet()) {
				o.setPhaseOption(phase + "." + pso.getName(), entry.getKey()
						+ ":" + entry.getValue());
			}
		}
		return o;
	}

	protected void pushSubOption(PhaseSubOptions pso) {
		this.subOptions.add(pso);
	}

	protected abstract void pushToOptionSet();

	protected void addOption(String key, String value) {
		options.put(key, value);
	}

	protected void removeOption(String key) {
		options.remove(key);
	}
}
