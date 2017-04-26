package com.jsc.javageeks.model;

public class StudentMark {
	private String htno;
	private String subcode;
	private String subname;
	private int internals;
	private int externals;
	private int credits;

	public StudentMark() {
	}

	public StudentMark(String htno, String subcode, String subname,
			int internals, int externals, int credits) {
		this.htno = htno;
		this.subcode = subcode;
		this.subname = subname;
		this.internals = internals;
		this.externals = externals;
		this.credits = credits;
	}

	public String getHtno() {
		return htno;
	}

	public void setHtno(String htno) {
		this.htno = htno;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getInternals() {
		return internals;
	}

	public void setInternals(int internals) {
		this.internals = internals;
	}

	public int getExternals() {
		return externals;
	}

	public void setExternals(int externals) {
		this.externals = externals;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String toString() {
		return "StudentMark [htno=" + htno + ", subcode=" + subcode
				+ ", subname=" + subname + ", internals=" + internals
				+ ", externals=" + externals + ", credits=" + credits + "]";
	}

}
