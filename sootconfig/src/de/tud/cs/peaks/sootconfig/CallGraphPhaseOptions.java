package de.tud.cs.peaks.sootconfig;

public class CallGraphPhaseOptions extends PhaseOptions {
	public CallGraphPhaseOptions() {
		super("cg");
	}

	private boolean allReachable = false;

	public CallGraphPhaseOptions processAllReachable() {
		this.allReachable = true;
		return this;
	}

	public CallGraphPhaseOptions processOnlyEntryPoints() {
		this.allReachable = false;
		return this;
	}

	public CallGraphPhaseOptions addSubOption(CallGraphPhaseSubOptions pso) {
		this.pushSubOption(pso);
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		this.addOption("all-reachable", this.allReachable ? "true" : "false");

	}

}
