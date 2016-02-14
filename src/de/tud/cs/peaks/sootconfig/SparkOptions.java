package de.tud.cs.peaks.sootconfig;

public class SparkOptions extends CallGraphPhaseSubOptions {

	private boolean enabled = false;
	private boolean preJimplify = false;
	private boolean onFlyCallGraph = false;
	private boolean simulateNatives = false;

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

	public SparkOptions buildCallGraphOnFly() {
		this.onFlyCallGraph = true;
		return this;
	}

	public SparkOptions doNotBuildCallGraphOnFly() {
		this.onFlyCallGraph = false;
		return this;
	}

	public SparkOptions simulateNativeMethods() {
		this.simulateNatives = true;
		return this;
	}

	public SparkOptions doNotSimulateNativeMethods() {
		this.simulateNatives = false;
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		this.addOption("enabled", Boolean.toString(this.enabled));
		this.addOption("pre-jimplify", Boolean.toString(this.preJimplify));
		this.addOption("on-fly-cg", Boolean.toString(this.onFlyCallGraph));
		this.addOption("simulate-natives", Boolean.toString(this.simulateNatives));
	}
}
