package net.connectedcaching

package object sbcrypt  {

	implicit def stringToBCryptableString(s: String) = new BCryptableString(s)

}
