package de.tud.cs.peaks.sootconfig;

public class TagAggregatorOptions extends PhaseOptions {

	private final class EnabledSubOption extends PhaseSubOptions {

		private EnabledSubOption(String name) { super(name); }

		@Override
		protected void pushToOptionSet() {
			this.addOption("enabled", "true");
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			if (!super.equals(o)) return false;

			return true;

		}

		@Override
		public int hashCode() {
			int result = super.hashCode();
			return result;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		TagAggregatorOptions that = (TagAggregatorOptions) o;

		if (aggregateLineNumbers != that.aggregateLineNumbers) return false;
		if (aggregateArrayBoundsNullChecks != that.aggregateArrayBoundsNullChecks) return false;
		if (aggregateDependenceTags != that.aggregateDependenceTags) return false;
		return aggregateFieldReadsWrites == that.aggregateFieldReadsWrites;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (aggregateLineNumbers ? 1 : 0);
		result = 31 * result + (aggregateArrayBoundsNullChecks ? 1 : 0);
		result = 31 * result + (aggregateDependenceTags ? 1 : 0);
		result = 31 * result + (aggregateFieldReadsWrites ? 1 : 0);
		return result;
	}
}
