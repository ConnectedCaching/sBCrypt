package net.connectedcaching.sbcrypt

import org.mindrot.jbcrypt.BCrypt

/**
 * Rich wrapper around [[java.lang.String]] which provides BCrypt specific functionality
 */
class BCryptableString(s: String) {

	/**
	 * @return a BCrypt hash of the receiving string using a random salt
	 */
	def bcrypt() = BCrypt.hashpw(s, BCrypt.gensalt())

	/**
	 * @param rounds load factor
	 * @return a BCrypt hash of the receiving string using a random salt generated with a
	 *         load factor of n rounds
	 */
	def bcrypt(rounds: Int) = BCrypt.hashpw(s, BCrypt.gensalt(rounds))

	/**
	 * @param rounds load factor
	 * @param random a [[java.security.SecureRandom]] instance serving as PRNG for salt generation
	 * @return a BCrypt hash of the receiving string using a load factor of n rounds and the given
	 *         [[java.security.SecureRandom]] instance as PRNG
	 */
	def bcrypt(rounds: Int, random: java.security.SecureRandom) = BCrypt.hashpw(s, BCrypt.gensalt(rounds, random))

	/**
	 * @param salt a user defined salt value
	 * @return a BCrypt hash of the receiving string using the given salt value
	 */
	def bcrypt(salt: String) = BCrypt.hashpw(s, salt)

	/**
	 * @param hash a BCrypt hash
	 * @return whether bcrypting the receiving string would result in the given hash
	 */
	def equalsBCrypted(hash: String) = BCrypt.checkpw(s, hash)

}