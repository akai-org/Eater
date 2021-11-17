package pl.org.akai.eater.util

import java.lang.RuntimeException

class NullArgumentException(argumentName: String): RuntimeException("Argument $argumentName is null.")