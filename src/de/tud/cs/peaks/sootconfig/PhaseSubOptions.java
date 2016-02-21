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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PhaseSubOptions that = (PhaseSubOptions) o;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		return options.equals(that.options);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + options.hashCode();
		return result;
	}
}
