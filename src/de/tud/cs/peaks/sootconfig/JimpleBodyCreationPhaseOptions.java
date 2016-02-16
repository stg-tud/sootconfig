package de.tud.cs.peaks.sootconfig;

public class JimpleBodyCreationPhaseOptions extends PhaseOptions {
	public JimpleBodyCreationPhaseOptions() {
		super("jb");
	}

	private boolean useOriginalNames = false;

	public JimpleBodyCreationPhaseOptions useOriginalNames() {
		this.useOriginalNames = true;
		return this;
	}

	public JimpleBodyCreationPhaseOptions doNotUseOriginalNames() {
		this.useOriginalNames = false;
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		this.addOption("use-original-names", Boolean.toString(this.useOriginalNames));

	}

	@Override
	public boolean subEquals(PhaseOptions o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		JimpleBodyCreationPhaseOptions that = (JimpleBodyCreationPhaseOptions) o;

		return useOriginalNames == that.useOriginalNames;

	}

	@Override
	public int subHashCode() {
		return (useOriginalNames ? 1 : 0);
	}
}
