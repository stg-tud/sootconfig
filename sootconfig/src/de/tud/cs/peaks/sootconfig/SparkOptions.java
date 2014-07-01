package de.tud.cs.peaks.sootconfig;

public class SparkOptions extends CallGraphPhaseSubOptions {

	private boolean enabled = false;
	private boolean preJimplify = false;

	public SparkOptions() {
		super("spark");
	}

	public SparkOptions enable() {
		this.enabled = true;
		return this;
	}

	public SparkOptions disable() {
		this.enabled = false;
		return this;
	}

	public SparkOptions preJimplify() {
		this.preJimplify = true;
		return this;
	}

	public SparkOptions doNotPreJimplify() {
		this.preJimplify = false;
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		this.addOption("enabled", this.enabled ? "true" : "false");
		this.addOption("pre-jimplify", this.preJimplify ? "true" : "false");
	}
}
