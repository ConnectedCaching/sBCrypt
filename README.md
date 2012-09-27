sBCrypt
=======

sBCrypt is a lightweight Scala wrapper around [jBCrypt](http://www.mindrot.org/projects/jBCrypt/) that allows to hash strings with BCrypt in an object-oriented way.

Usage
-----
	
	import net.connectedcaching.sbcrypt._
	
	// standard random salt generation with 10 rounds
	"password".bcrypt => "$2a$10$SZcGTDDA5lHoq7JeyMrML.Nbw.GRz5ecZKn62YqLVgwl/T9aoBUq."
	// standard random salt generation with user defined rounds
	"password".bcrypt(12) => "$2a$12$I9FoRqOeZXZbaUbZC2KkO.2VbuEQTbU9XOkedAfz3x7cDTYNCU83y"
	// hashing with user defined salt
	"password".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe") => "$2a$10$XioEvBw/KFQo6kP0J5ttxeAHm8cje9AMxAQgdQOJ98o8dFqmqON9W"
	
	// hash comparison
	"password".equalsBCrypted("$2a$12$TRuaejRkNEVYbB9vGSb2x.cAxl9n.RCGTCRUjLOz/uavsfy10dM.q") => true
	"password".equalsBCrypted("$2a$10$TRuaejRkNEVYbB9vGSb2x.cAxl9n.RCGTCRUjLOz/uavsfy10dM.q") => false

Build Status
------------
[![Build Status](https://secure.travis-ci.org/ConnectedCaching/sBCrypt.png)](http://travis-ci.org/ConnectedCaching/sBCrypt)