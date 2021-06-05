package com.oguztopal.annualpermit.enums;

public enum PermissionStatus {

	APPROVED("APPROVED"),
	WAITING_APPROVAL("WAITING_APPROVAL"),
	REJECTED("REJECTED");

	private String key;

	PermissionStatus(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
