package net.connectedcaching

package object sBCrypt {

	implicit def stringToBCryptableString(s: String) = new net.connectedcaching.sbcrypt.BCryptableString(s)

}
