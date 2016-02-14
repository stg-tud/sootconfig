package de.tud.cs.peaks.sootconfig;

public class TagAggregatorOptions extends PhaseOptions {

	private final class EnabledSubOption extends PhaseSubOptions {
		private EnabledSubOption(String name) {
			super(name);
		}

		@Override
		protected void pushToOptionSet() {
			this.addOption("enabled", "true");
		}
	}

	private boolean aggregateLineNumbers = false;
	private boolean aggregateArrayBoundsNullChecks = false;
	private boolean aggregateDependenceTags = false;
	private boolean aggregateFieldReadsWrites = false;

	public TagAggregatorOptions() {
		super("tag");
	}

	public TagAggregatorOptions aggregateLineNumber() {
		this.aggregateLineNumbers = true;
		return this;
	}

	public TagAggregatorOptions aggregateArrayBoundsAndNullPointerChecks() {
		this.aggregateArrayBoundsNullChecks = true;
		return this;
	}

	public TagAggregatorOptions aggregateDependenceTags() {
		this.aggregateDependenceTags = true;
		return this;
	}

	public TagAggregatorOptions aggregateFieldReadsWrites() {
		this.aggregateFieldReadsWrites = true;
		return this;
	}

	@Override
	protected void pushToOptionSet() {
		if (aggregateLineNumbers)
			this.pushSubOption(new EnabledSubOption("ln"));

		if (aggregateArrayBoundsNullChecks)
			this.pushSubOption(new EnabledSubOption("an"));

		if (aggregateDependenceTags)
			this.pushSubOption(new EnabledSubOption("dep"));

		if (aggregateFieldReadsWrites)
			this.pushSubOption(new EnabledSubOption("fieldrw"));
	}

}
