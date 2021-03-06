package de.tud.cs.peaks.sootconfig;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import soot.options.Options;
import de.tud.cs.peaks.sootconfig.entrypointcalculator.EntryPointCalculator;
import de.tud.cs.peaks.sootconfig.entrypointcalculator.ZeroEntryPoints;

/***
 *
 *
 * @author Ben Hermann
 *
 */
public class AnalysisTarget {
	private final List<String> classes = new ArrayList<String>();
	private String classPath;
	private String processPath;
	private EntryPointCalculator entryPointCalculator = ZeroEntryPoints.v();

	public AnalysisTarget addClass(String className) {
		this.classes.add(className);
		return this;
	}

	public AnalysisTarget classPath(String classPath) {
		this.setClassPath(classPath);
		return this;
	}

	public AnalysisTarget processPath(String processPath) {
		this.setProcessPath(processPath);
		return this;
	}

	public String getClassPath() {
		return this.classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getProcessPath() {
		return this.processPath;
	}

	public void setProcessPath(String processPath) {
		this.processPath = processPath;
	}

	public Options applyTo(Options o) {
		if (this.classes.size() > 0)
			for (String c : this.classes)
				o.classes().add(c);

		if (this.classPath != null && this.classPath != "")
			o.set_soot_classpath(this.classPath);

		if (this.processPath != null && this.processPath != "") {
			List<String> setting = new LinkedList<String>();
			setting.add(this.processPath);
			o.set_process_dir(setting);
		}

		return o;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("analysis target (");

		if (this.processPath != null && this.processPath != "")
			buffer.append("Process path: " + this.processPath + " ");

		if (this.classPath != null && this.classPath != "")
			buffer.append("Class path: " + this.classPath + " ");

		buffer.append(")");

		return buffer.toString();
	}

	public AnalysisTarget classPathToProcessPathDirectory() {
		File file = new File(this.processPath);
		File path = new File(file.getParent());

		File[] jarFiles = path.listFiles(new FilenameFilter() {
			protected final String regex = ".*\\.jar$";

			@Override
			public boolean accept(File dir, String name) {
				return name.matches(this.regex);
			}

		});

		if (jarFiles != null) {
			ArrayList<String> jarFileNames = new ArrayList<String>(
					jarFiles.length);
			for (File j : jarFiles)
				jarFileNames.add(j.getPath());

			String newClassPath = StringUtils.join(jarFileNames,
					File.pathSeparator);

			return classPath(newClassPath);
		} else {
			return this;
		}

	}

	public EntryPointCalculator getEntryPointCalculator() {
		return this.entryPointCalculator;
	}

	public void setEntryPointCalculator(
			EntryPointCalculator entryPointCalculator) {
		this.entryPointCalculator = entryPointCalculator;
	}

	public AnalysisTarget entryPointCalculator(
			EntryPointCalculator entryPointCalculator) {
		this.setEntryPointCalculator(entryPointCalculator);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AnalysisTarget that = (AnalysisTarget) o;

		if (!classes.equals(that.classes)) return false;
		if (classPath != null ? !classPath.equals(that.classPath) : that.classPath != null) return false;
		if (processPath != null ? !processPath.equals(that.processPath) : that.processPath != null) return false;
		return entryPointCalculator != null ? entryPointCalculator.equals(that.entryPointCalculator) : that.entryPointCalculator == null;

	}

	@Override
	public int hashCode() {
		int result = classes.hashCode();
		result = 31 * result + (classPath != null ? classPath.hashCode() : 0);
		result = 31 * result + (processPath != null ? processPath.hashCode() : 0);
		result = 31 * result + (entryPointCalculator != null ? entryPointCalculator.hashCode() : 0);
		return result;
	}
}
