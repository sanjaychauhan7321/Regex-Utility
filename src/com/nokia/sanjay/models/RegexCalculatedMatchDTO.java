package com.nokia.sanjay.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegexCalculatedMatchDTO {

	private Map<Integer, List<String>> mapOfMatchedString;

	/**
	 * @return the mapOfMatchedString
	 */
	public Map<Integer, List<String>> getMapOfMatchedString() {

		if (null == this.mapOfMatchedString) {
			this.mapOfMatchedString = new HashMap<Integer, List<String>>();
		}
		return mapOfMatchedString;
	}

}
