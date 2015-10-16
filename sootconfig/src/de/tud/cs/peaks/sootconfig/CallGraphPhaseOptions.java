package de.tud.cs.peaks.sootconfig;

import static de.tud.cs.peaks.sootconfig.CallGraphAlgorithmMode.Application;
import static de.tud.cs.peaks.sootconfig.CallGraphAlgorithmMode.Library;
import static de.tud.cs.peaks.sootconfig.CallGraphAlgorithmMode.LibraryWithSignatureResolution;

public class CallGraphPhaseOptions extends PhaseOptions {
	public CallGraphPhaseOptions() {
		super("cg");
	}

	private boolean allReachable = false;
	private CallGraphAlgorithmMode mode = Application;

	public CallGraphPhaseOptions processAllReachable() {
		this.allReachable = true;
		return this;
	}

	public CallGraphPhaseOptions processOnlyEntryPoints() {
		this.allReachable = false;
		return this;
	}

	public CallGraphPhaseOptions applicationMode() {
		this.mode = Application;
		return this;
	}

	public CallGraphPhaseOptions libraryMode() {
		this.mode = Library;
		return this;
	}

	public CallGraphPhaseOptions libraryModeSignatureResolution() {
		this.mode = LibraryWithSignatureResolution;
		return this;
	}

	public CallGraphPhaseOptions addSubOption(CallGraphPhaseSubOptions pso) {
		this.pushSubOption(pso);
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		this.addOption("all-reachable", this.allReachable ? "true" : "false");
		switch (this.mode) {
		case Application:
			this.addOption("library", "disabled");
			break;
		case Library:
			this.addOption("library", "any-subtype");
			break;
		case LibraryWithSignatureResolution:
			this.addOption("library", "signature-resolution");
			break;
		}

	}

}
