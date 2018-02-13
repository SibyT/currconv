package com.example.currconv.model;

import java.util.Map;
import java.util.TreeMap;
/*
 * This class is to collect response from api
 */
public class CurrConvertResp {


	private Map<String, String> rates = new TreeMap<String, String>();

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}


}