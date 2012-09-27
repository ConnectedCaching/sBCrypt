package net.connectedcaching.sbcrypt

import org.mindrot.jbcrypt.BCrypt

class BCryptableString(s: String) {
	def bcrypt() = BCrypt.hashpw(s, BCrypt.gensalt())
	def bcrypt(rounds: Int) = BCrypt.hashpw(s, BCrypt.gensalt(rounds))
	def bcrypt(rounds: Int, random: java.security.SecureRandom) = BCrypt.hashpw(s, BCrypt.gensalt(rounds, random))
	def bcrypt(salt: String) = BCrypt.hashpw(s, salt)
	def equalsBCrypted(hash: String) = BCrypt.checkpw(s, hash)
}