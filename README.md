sBCrypt
=======

sBCrypt is a lightweight Scala wrapper around [jBCrypt](http://www.mindrot.org/projects/jBCrypt/) that allows to hash strings with BCrypt in an object-oriented way.

Usage
-----
```Scala
import net.connectedcaching.sBCrypt._

// standard random salt generation with 10 rounds
"password".bcrypt => "$2a$10$SZcGTDDA5lHoq7JeyMrML.Nbw.GRz5ecZKn62YqLVgwl/T9aoBUq."
// standard random salt generation with user defined rounds
"password".bcrypt(12) => "$2a$12$I9FoRqOeZXZbaUbZC2KkO.2VbuEQTbU9XOkedAfz3x7cDTYNCU83y"
// hashing with user defined salt
"password".bcrypt("$2a$10$XioEvBw/KFQo6kP0J5ttxe") => "$2a$10$XioEvBw/KFQo6kP0J5ttxeAHm8cje9AMxAQgdQOJ98o8dFqmqON9W"

// hash comparison
"password".equalsBCrypted("$2a$12$TRuaejRkNEVYbB9vGSb2x.cAxl9n.RCGTCRUjLOz/uavsfy10dM.q") => true
"$2a$12$TRuaejRkNEVYbB9vGSb2x.cAxl9n.RCGTCRUjLOz/uavsfy10dM.q".bcryptedEquals("password") => true
```

Build Status
------------
[![Build Status](https://secure.travis-ci.org/ConnectedCaching/sBCrypt.png)](http://travis-ci.org/ConnectedCaching/sBCrypt)

Installation
-----
sBCrypt is available on Maven Central compiled for Scala 2.9.2. If you need to compile sBCrypt for another Scala version,
download the sources and run a build with [sbt](https://github.com/harrah/xsbt/wiki). Otherwise, just add a dependency
to your build file like shown below.

###SBT
	libraryDependencies += "net.connectedcaching" % "sbcrypt" % "1.0"

###Maven
	<dependency>
		<groupId>net.connectedcaching</groupId>
		<artifactId>sbcrypt</artifactId>
		<version>1.0</version>
	</dependency>

History
-------
- v1.0 - September 28 2012
	- Initial release