package br.erickweil.simplelang.utils;

public class TextUtils {

	public static String IdentText(String text) {

		String ret = text.replaceAll("\n", "\n\t");

		return "\t" + ret;
	}

	public static boolean isAlphabetic(char c) {
		/*
		 * Determines if the specified character (Unicode code point) is an
		 * alphabet. A character is considered to be alphabetic if its general
		 * category type, provided by getType(codePoint), is any of the
		 * following:
		 * 
		 * UPPERCASE_LETTER LOWERCASE_LETTER TITLECASE_LETTER MODIFIER_LETTER
		 * OTHER_LETTER LETTER_NUMBER or it has contributory property
		 * Other_Alphabetic as defined by the Unicode Standard. Parameters:
		 * codePoint the character (Unicode code point) to be tested. Returns:
		 * true if the character is a Unicode alphabet character, false
		 * otherwise. Since: 1.7
		 */
		int type = Character.getType(c);
		switch (type) {
		case Character.UPPERCASE_LETTER:
		case Character.LOWERCASE_LETTER:
		case Character.TITLECASE_LETTER:
		case Character.MODIFIER_LETTER:
		case Character.OTHER_LETTER:
		case Character.LETTER_NUMBER:
			return true;
		default:
			return false;
		}

	}
}
