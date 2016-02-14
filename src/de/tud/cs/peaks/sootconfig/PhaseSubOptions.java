package de.tud.cs.peaks.sootconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class PhaseSubOptions {
	private final String name;
	private final Map<String, String> options = new HashMap<String, String>();

	public String getName() {
		return name;
	}

	public PhaseSubOptions(String name) {
		super();
		this.name = name;
	}

	protected abstract void pushToOptionSet();

	protected void addOption(String key, String value) {
		options.put(key, value);
	}

	protected void removeOption(String key) {
		options.remove(key);
	}

	public Set<Entry<String, String>> entrySet() {
		return this.options.entrySet();
	}

}
