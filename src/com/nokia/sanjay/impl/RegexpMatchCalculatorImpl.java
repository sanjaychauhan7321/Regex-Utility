package com.nokia.sanjay.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nokia.sanjay.apis.RegexpMatchCalculator;
import com.nokia.sanjay.exceptions.RegexpException;
import com.nokia.sanjay.models.RegexCalculatedMatchDTO;
import com.nokia.sanjay.util.Constants;
import com.nokia.sanjay.util.Utilities;

/**
 * 
 * @author <a href=
 *         "https://www.youracclaim.com/badges/1cacfc10-a704-44ed-94b4-1cd7abbfd168/public_url"
 *         style="color:red; font-size:16; "><em>Sanjay Chauhan</em></a>
 */

public class RegexpMatchCalculatorImpl implements RegexpMatchCalculator {

	public RegexCalculatedMatchDTO findRegexpMatch(CharSequence sourceCharSequence) throws RegexpException {

		// Get value of RegEx expression from the property file
		String regExpressionValue = Utilities.getPropertyValue(Constants.regExpressionString);

		// Data object to be returned
		RegexCalculatedMatchDTO regexCalculatedMatchDTO = null;

		if (null == sourceCharSequence) {

			throw new RegexpException(103, "Source string is null! Please provide some valid data to calculate on!");
		}

		// Get Regular expression first, if its null throw error!
		if (null != regExpressionValue) {

			System.out.println("Value of the property regexp is : " + regExpressionValue);

			Pattern pattern = Pattern.compile(regExpressionValue);
			Matcher matcher = pattern.matcher(sourceCharSequence);

			System.out.println("group count in the regex : " + matcher.groupCount());

			// Total sub-regex group count
			int totalGroupCount = matcher.groupCount();

			// Total match found in the source char sequence
			int totalMatchFound = 0;

			// List of matched items with the full regular expression
			List<String> listOfMatchedItems = new ArrayList<String>();

			// Instantiate the return object
			regexCalculatedMatchDTO = new RegexCalculatedMatchDTO();

			for (int i = 1; i <= totalGroupCount; i++) {

				regexCalculatedMatchDTO.getMapOfMatchedString().put(i, new ArrayList<String>());

			}
			System.out.println("Structure is : " + regexCalculatedMatchDTO.getMapOfMatchedString());

			while (matcher.find()) {

				// Add result of sub-regex according to the group number (ie. 1, 2, 3...)
				for (int i = 1; i <= totalGroupCount; i++) {
					regexCalculatedMatchDTO.getMapOfMatchedString().get(i).add(matcher.group(i));

				}

				listOfMatchedItems.add(matcher.group());
				totalMatchFound++;
			}

			for (Integer key : regexCalculatedMatchDTO.getMapOfMatchedString().keySet()) {

				System.out.println("Size of the list at index : " + key + " is : "
						+ regexCalculatedMatchDTO.getMapOfMatchedString().get(key).size());

				System.out.println("elemets of the list at : " + key + " is : "
						+ regexCalculatedMatchDTO.getMapOfMatchedString().get(key));

			}

			// Adding all matched element at 0th position of the map
			regexCalculatedMatchDTO.getMapOfMatchedString().put(0, listOfMatchedItems);

			// Show result
			System.out.println("Total match count is : " + totalMatchFound);
			System.out.println("Matched items list is : " + listOfMatchedItems);
			System.out.println("value is : " + regexCalculatedMatchDTO.getMapOfMatchedString());

		} else {

			throw new RegexpException(100, "Couldn't find the property : \"" + Constants.regExpressionString
					+ "\" defined in the property file ");

		}
		return regexCalculatedMatchDTO;

	}

}
