package com.github.tutorial.model;

public enum CyberSource {
	Submission_Date_Time("Submission Date/Time"), Submission_File_ID("Submission File ID"), link_to_request, request_id,
	transaction_date, cybs_mid, processor_mid, hierarchy_id, trans_ref_number, merchant_ref_number, transaction_type,
	amount, transaction_amount_currency, payment_method, payment_type, account_suffix, decision, reason_code, reserved,
	auth_trans_ref_number, auth_date, auth_request_id, auth_amount, auth_currency, auth_code, auth_reason_code,
	auth_rcode, merchant_defined_data1, merchant_defined_data2, merchant_defined_data3, merchant_defined_data4,;

	private String value;

	CyberSource() {
	}

	CyberSource(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
