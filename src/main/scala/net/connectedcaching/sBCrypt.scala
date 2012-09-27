package net.connectedcaching

/**
 * The purpose of the sBCrypt object is to serve as import helper for the implicit conversions that
 * allow the usage of BCrypt (Strings only at the moment)
 */
object sBCrypt {

	/**
	 * extends [[java.lang.String]] with BCrypt specific methods
	 */
	implicit def stringToBCryptableString(s: String) = new net.connectedcaching.sbcrypt.BCryptableString(s)

}
