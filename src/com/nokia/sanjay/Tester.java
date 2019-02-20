package com.nokia.sanjay;

import com.nokia.sanjay.apis.RegexpMatchCalculator;
import com.nokia.sanjay.exceptions.RegexpException;

/**
 * 
 * @author <a href=
 *         "https://www.youracclaim.com/badges/1cacfc10-a704-44ed-94b4-1cd7abbfd168/public_url"
 *         style="color:red; font-size:16; "><em>Sanjay Chauhan</em></a>
 */

public class Tester {

	public static void main(String[] args) {

		RegexpMatchCalculator regexpCalculator = new RegexpMatchCalculatorImpl();

		try {

			regexpCalculator.findRegexpMatch("Source String here");

		} catch (RegexpException e) {

			System.out.println(e.getErrorMessage());
			System.out.println(e.getErrorCode());

		} catch (Throwable ex) {

			System.out.println("Unexpected error occured! Reason : " + ex.getMessage());

		}

	}

}
