package de.tud.cs.peaks.sootconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import soot.options.Options;
import soot.util.ArraySet;

public class FluentOptions {

	private boolean allowPhantomReferences;
	private boolean fullResolver;
	private boolean includeAll;
	private boolean keepLineNumbers;
	private boolean noBodiesForExcluded;
	private OutputFormat outputFormat = OutputFormat.NONE;
	private boolean prependClasspath;
	private boolean wholeProgramAnalysis;
	private boolean useCoffi;
	private boolean useASMBackend;

	private final Set<PhaseOptions> phaseOptions = new ArraySet<PhaseOptions>();

	public FluentOptions allowPhantomReferences() {
		this.allowPhantomReferences = true;
		return this;
	}

	public Options applyTo(Options o) {
		o.set_allow_phantom_refs(this.allowPhantomReferences);
		if (this.allowPhantomReferences)
			o.setPhaseOption("jb.tr", "ignore-wrong-staticness:true");
		o.set_full_resolver(this.fullResolver);
		o.set_include_all(this.includeAll);
		o.set_keep_line_number(this.keepLineNumbers);
		o.set_no_bodies_for_excluded(this.noBodiesForExcluded);
		o.set_output_format(this.outputFormat.sootOutputFormat());
		o.set_prepend_classpath(this.prependClasspath);
		o.set_whole_program(this.wholeProgramAnalysis);
		if (this.useCoffi)
			o.set_coffi(true);
		for (PhaseOptions p : this.phaseOptions)
			p.apply(o);

		return o;
	}

	private String createOptionsString() {
		List<String> buffer = new ArrayList<String>();

		if (this.allowPhantomReferences)
			buffer.add("allow for phantom references");

		if (this.fullResolver)
			buffer.add("use full resolving");

		if (this.includeAll)
			buffer.add("include all");

		if (this.keepLineNumbers)
			buffer.add("keep line numbers");

		if (this.noBodiesForExcluded)
			buffer.add("don't generate bodies for excluded parts");

		if (this.outputFormat != null)
			buffer.add("output format: " + this.outputFormat);

		if (this.prependClasspath)
			buffer.add("prepend class path");

		if (this.wholeProgramAnalysis)
			buffer.add("whole program analysis");

		if (this.useCoffi)
			buffer.add("uses coffi");

		if (this.useASMBackend)
			buffer.add("use asm backend");

		return StringUtils.join(buffer, ",");
	}

	public FluentOptions fullResolver() {
		this.fullResolver = true;
		return this;
	}

	public FluentOptions includeAll() {
		this.includeAll = true;
		return this;
	}

	public FluentOptions keepLineNumbers() {
		this.keepLineNumbers = true;
		return this;
	}

	public FluentOptions noBodiesForExcluded() {
		this.noBodiesForExcluded = true;
		return this;
	}

	public FluentOptions outputFormat(OutputFormat format) {
		this.outputFormat = format;
		return this;
	}

	public FluentOptions prependClasspath() {
		this.prependClasspath = true;
		return this;
	}

	public FluentOptions addPhaseOptions(PhaseOptions po) {
		this.phaseOptions.add(po);
		return this;
	}

	@Override
	public String toString() {
		return "Options(" + createOptionsString() + ")";
	}

	public FluentOptions wholeProgramAnalysis() {
		this.wholeProgramAnalysis = true;
		return this;
	}

	public FluentOptions useCoffi() {
		this.useCoffi = true;
		return this;
	}

	public FluentOptions useASMBackend() {
		this.useASMBackend = true;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FluentOptions that = (FluentOptions) o;

		if (allowPhantomReferences != that.allowPhantomReferences) return false;
		if (fullResolver != that.fullResolver) return false;
		if (includeAll != that.includeAll) return false;
		if (keepLineNumbers != that.keepLineNumbers) return false;
		if (noBodiesForExcluded != that.noBodiesForExcluded) return false;
		if (prependClasspath != that.prependClasspath) return false;
		if (wholeProgramAnalysis != that.wholeProgramAnalysis) return false;
		if (useCoffi != that.useCoffi) return false;
		if (useASMBackend != that.useASMBackend) return false;
		if (outputFormat != that.outputFormat) return false;
		return phaseOptions.equals(that.phaseOptions);

	}

	@Override
	public int hashCode() {
		int result = (allowPhantomReferences ? 1 : 0);
		result = 31 * result + (fullResolver ? 1 : 0);
		result = 31 * result + (includeAll ? 1 : 0);
		result = 31 * result + (keepLineNumbers ? 1 : 0);
		result = 31 * result + (noBodiesForExcluded ? 1 : 0);
		result = 31 * result + outputFormat.hashCode();
		result = 31 * result + (prependClasspath ? 1 : 0);
		result = 31 * result + (wholeProgramAnalysis ? 1 : 0);
		result = 31 * result + (useCoffi ? 1 : 0);
		result = 31 * result + (useASMBackend ? 1 : 0);
		result = 31 * result + phaseOptions.hashCode();
		return result;
	}
}
