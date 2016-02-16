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

	@Override
	public boolean subEquals(PhaseSubOptions o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SparkOptions that = (SparkOptions) o;

		if (enabled != that.enabled) return false;
		if (preJimplify != that.preJimplify) return false;
		if (onFlyCallGraph != that.onFlyCallGraph) return false;
		return simulateNatives == that.simulateNatives;

	}

	@Override
	public int subHashCode() {
		int result = super.hashCode();
		result = 31 * result + (enabled ? 1 : 0);
		result = 31 * result + (preJimplify ? 1 : 0);
		result = 31 * result + (onFlyCallGraph ? 1 : 0);
		result = 31 * result + (simulateNatives ? 1 : 0);
		return result;
	}
}
