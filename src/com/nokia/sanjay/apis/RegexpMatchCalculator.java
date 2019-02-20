package com.nokia.sanjay.apis;

import com.nokia.sanjay.exceptions.RegexpException;
import com.nokia.sanjay.models.RegexCalculatedMatchDTO;

public interface RegexpMatchCalculator {

	public RegexCalculatedMatchDTO findRegexpMatch(CharSequence sourceCharSequence) throws RegexpException;

}
