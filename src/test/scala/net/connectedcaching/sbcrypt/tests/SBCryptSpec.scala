package net.connectedcaching.sbcrypt.tests

import org.specs2.mutable._

class SBCryptSpec extends Specification {

	import net.connectedcaching.sBCrypt._

	"sBCrypt" should {

		"use a salt generated in 10 rounds per default" in {
			"foobar".bcrypt must startWith("$2a$10$")
		}

		"use as many rounds as defined by the user for salting" in {
			"foobar".bcrypt(5) must startWith("$2a$05$")
		}

		"identify valid hashes correctly" in {
			"foobar".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beTrue
			"foobar".equalsBCrypted("$2a$09$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beFalse
			"foobaz".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beFalse
			"foobar".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxeGuRTyMuNyipAR42vzf4ANGCnZ0n41Uy") must beFalse
			"$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C".bcryptedEquals("foobar") must beTrue
		}

		"not deliver the same result twice if no seed is specified" in {
			val a = "foobar".bcrypt
			val b = "foobar".bcrypt
			a must not be equalTo(b)
		}

		"always deliver the same result when using a user defined salt" in {
			val a = "foobar".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe")
			val b = "foobar".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe")
			a must be equalTo(b)
		}

		"not deliver the same result twice when using a SecureRandom instance" in {
			val prng = java.security.SecureRandom.getInstance("SHA1PRNG")
			"foobar".bcrypt(10, prng) must not be equalTo("foobar".bcrypt(10, prng))
		}

		"return the correct result when using a user-defined salt" in {
			"foobar".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe") must be equalTo("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C")
		}

	}

}
