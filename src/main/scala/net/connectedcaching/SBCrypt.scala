package net.connectedcaching

import org.mindrot.jbcrypt.BCrypt

package object SBCrypt  {

	class BCryptableString(s: String) {
		def bcrypt() = BCrypt.hashpw(s, BCrypt.gensalt())
		def bcrypt(rounds: Int) = BCrypt.hashpw(s, BCrypt.gensalt(rounds))
		def bcrypt(rounds: Int, random: java.security.SecureRandom) = BCrypt.hashpw(s, BCrypt.gensalt(rounds, random))
		def bcrypt(salt: String) = BCrypt.hashpw(s, salt)
		def equalsBCrypted(hash: String) = BCrypt.checkpw(s, hash)
	}

	implicit def stringToBCryptableString(s: String) = new BCryptableString(s)

}
