package de.tud.cs.peaks.sootconfig;

import soot.options.Options;

public enum OutputFormat {
	JIMPLE(Options.output_format_jimple), JIMP(Options.output_format_jimp), SHIMPLE(Options.output_format_shimple), SHIMP(
			Options.output_format_shimp), BAF(Options.output_format_baf), b(Options.output_format_b), GRIMPLE(
			Options.output_format_grimple), GRIMP(Options.output_format_grimp), XML(Options.output_format_xml), DEX(
							Options.output_format_dex), ForceDEX(Options.output_format_force_dex), NONE(Options.output_format_none), JASMIN(
									Options.output_format_jasmin), CLASS(Options.output_format_class), DAVA(Options.output_format_dava), TEMPLATE(
											Options.output_format_template), ASM(Options.output_format_asm);

	private int sootOutputFormat;

	private OutputFormat(int sootFormatID) {
		this.sootOutputFormat = sootFormatID;
	}

	public int sootOutputFormat() {
		return this.sootOutputFormat;
	}
}
