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
	private String outputFormat;
	private boolean prependClasspath;
	private boolean wholeProgramAnalysis;

	private final Set<PhaseOptions> phaseOptions = new ArraySet<PhaseOptions>();

	public FluentOptions allowPhantomReferences() {
		this.allowPhantomReferences = true;
		return this;
	}

	public Options applyTo(Options o) {
		o.set_allow_phantom_refs(allowPhantomReferences);
		if (allowPhantomReferences)
			o.setPhaseOption("jb.tr", "ignore-wrong-staticness:true");
		o.set_full_resolver(fullResolver);
		o.set_include_all(includeAll);
		o.set_keep_line_number(keepLineNumbers);
		o.set_no_bodies_for_excluded(noBodiesForExcluded);
		// TODO: Translate Strings to Enum Values
		o.set_output_format(Options.output_format_none);
		o.set_prepend_classpath(prependClasspath);
		o.set_whole_program(wholeProgramAnalysis);

		for (PhaseOptions p : this.phaseOptions)
			p.apply(o);

		return o;
	}

	private String createOptionsString() {
		List<String> buffer = new ArrayList<String>();

		if (allowPhantomReferences)
			buffer.add("allow for phantom references");

		if (fullResolver)
			buffer.add("use full resolving");

		if (includeAll)
			buffer.add("include all");

		if (keepLineNumbers)
			buffer.add("keep line numbers");

		if (noBodiesForExcluded)
			buffer.add("don't generate bodies for excluded parts");

		if (outputFormat != null && outputFormat != "")
			buffer.add("output format: " + outputFormat);

		if (prependClasspath)
			buffer.add("prepend class path");

		if (wholeProgramAnalysis)
			buffer.add("whole program analysis");

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

	public FluentOptions outputFormat(String format) {
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

}
