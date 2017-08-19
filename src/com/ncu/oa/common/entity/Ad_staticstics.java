package com.ncu.oa.common.entity;

import java.io.Serializable;

public class Ad_staticstics implements Serializable {

	private int late;

	private int early;

	private int vacation;

	private int overtime;

	public Ad_staticstics(int late, int early, int vacation, int overtiome) {
		this.late = late;
		this.early = early;
		this.vacation = vacation;
		this.overtime = overtiome;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getEarly() {
		return early;
	}

	public void setEarly(int early) {
		this.early = early;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}

	public int getOvertiome() {
		return overtime;
	}

	public void setOvertiome(int overtiome) {
		this.overtime = overtiome;
	}

	@Override
	public String toString() {
		return "Ad_staticstics [late=" + late + ", early=" + early
				+ ", vacation=" + vacation + ", overtiome=" + overtime + "]";
	}

}
