package net.connectedcaching

import org.specs2.mutable._

class SBCryptSpec extends Specification {

	import SBCrypt._

	"sBCrypt" should {

		"return the correct result when using a user-defined salt" in {
			"foobar".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe") must be equalTo("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C")
		}

		"identify valid hashes correctly" in {
			"foobar".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beTrue
			"foobar".equalsBCrypted("$2a$09$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beFalse
			"foobaz".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxebYa6ujuMZLt5kWnvHOkIPiI7CYqzf3C") must beFalse
			"foobar".equalsBCrypted("$2a$10$XioEvBw/KFQo6kP0J5ttxeGuRTyMuNyipAR42vzf4ANGCnZ0n41Uy") must beFalse
		}

		"use a salt generated in 10 rounds per default" in {
			"foobar".bcrypt() must startWith("$2a$10$")
		}

		"use as many rounds as defined by the user for salting" in {
			"foobar".bcrypt(5) must startWith("$2a$05$")
		}

	}

}
