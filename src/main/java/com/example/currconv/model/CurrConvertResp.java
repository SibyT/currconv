package com.example.currconv.model;

import java.util.Map;
import java.util.TreeMap;

public class CurrConvertResp {


	private Map<String, String> rates = new TreeMap<String, String>();

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}


}