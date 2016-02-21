JNLua (Java Native Lua) integrates the [Lua Scripting Language](http://www.lua.org/) into Java. The integration is based on the original implementation of Lua which is written in ANSI C. The Lua C code is integrated into Java using the Java Native API (JNI).



# Features #

JNLua provides the following features:
  * **Full Lua support with full Java type-safety.** JNLua provides the full functionality of Lua C API including large parts of the Lua Auxiliary Library. All Lua Standard Libraries are supported, including the coroutine functions. At the same time, JNLua maintains the type-safety of the Java VM by performing rigorous checks in its native library.
  * **Two-way integration.** With JNLua, you can access Java from Lua and Lua from Java. From Lua, JNLua provides full Java object access with intuitive syntax and the abilitiy to implement Java interfaces in Lua. From Java, JNLua provides full Lua access including the ability to implement Lua functions in Java. The integration works transparently in both directions and on each end conforms to the common principles of the respective platform.
  * **Dual bootstrapping.** JNLua can be started from both the Java and the Lua side. If started from the Java side, a Lua state is attached to the calling Java virtual machine; if started from the Lua side, a Java virtual machine is attached to the calling Lua process.
  * **Extensive language bindings.** The bindings between Lua and Java are abstracted into the domains of _Java reflection_ and _conversion_. The _default Java reflector_ supports field, method and property access on Java classes and objects. For overloaded methods, it provides a dispatch logic that mimics the behavior described in Java Language Specification. The _default converter_ handles the bidirectional conversion of primitive types, such as numbers and strings. For complex types, it supports the bidirectional mapping of Lua tables to Java maps, lists and arrays. These mappings are generally implemented with proxy objects, that is, they work _by reference_. Both the Java reflector and converter can be specialized to fit custom needs.
  * **Java module.** The JNLua Java module provides a small but comprehensive set of Lua functions providing Java language support for Lua.
  * **Java VM module.** The Java VM module is a Lua module written in C that allows a Lua process to create a Java Virtual Machine and run Java code in that machine.
  * **Transparent error handling.** Java does error handling by exceptions; Lua uses mechanics such as `error()` and `pcall()`. JNLua ensures a seamless translation of error conditions between the two domains. Lua errors are reported as exceptions to Java. Java exceptions generate errors on the Lua side.
  * **JSR 223: Scripting for the Java Platform provider.** JNLua includes a provider that conforms to the [JSR 223: Scripting for the Java Platform](http://www.jcp.org/en/jsr/detail?id=223) specification. This allows the use of Lua as a scripting language for Java in a standardized way. The JSR 223 provider also supports the optional Compilable and Invocable interfaces.
  * **JNLua Console.** A simple console implemented in Java for experimenting with JNLua.

# Design Goals #

The following goals drive the design of JNLua:
  * **Stability.** Both Java and Lua are mature and stable platforms. However, the underlying Java VM is a type-safe in a way that ANSI C is not. When loading C code into the Java VM, one must be careful not to corrupt the type-safety of the VM. JNLua achieves this goal by rigorous argument checking, stack checking and a sufficient amount of internal synchronization.
  * **Performance.** Lua has a reputation of being a very fast scripting language. Basically, JNLua simply tries not to get into the way of that performance ;) In support of good performance, JNLua avoids copying values between Java and Lua. Instead, JNLua uses proxy objects where possible.
  * **Simplicity.** JNLua aims at being simple and easy to learn by adhering to well-known patterns in both the Java and the Lua world. Lua provides a large spectrum of flexibility with relatively few, but well-designed features. JNLua _tries_ to adhere to that spirit.

# Architecture #

The figure below depicts the architecture of JNLua:

![](https://github.com/airminer/jnlua-wiki/blob/master/Architecture.png)

When JNLua is bootstrapped from Java, the Java code calls the JNLua Java library. The JNLua Java library invokes the JNLua native library via JNI, and the JNLua native library calls the Lua C API. Lua code can use the JNLua Java module to access Java functionality.

When JNLua is bootstrapped from Lua, the Lua code uses the JNLua Java VM module to create a Java virtual machine with the JNLua Java library, and then calls the JNLua Java module to access Java functionality.

# Requirements #

JNLua 0.9 is based on the Java 6 Platform (JDK 1.6) and Lua 5.1.

JNLua 1.0 is based on the Java 6 Platform (JDK 1.6) and Lua 5.2.

Max Raskin has done a port of JNLua for the [Android platform](https://github.com/airminer/jnlua-android).

# Documentation #

Documentation is provided in the [wiki](https://github.com/airminer/jnlua/wiki) as well as in the form of generated Javadoc (see links on the left side.)

# License #

JNLua is licensed under the MIT license which at the time of this writing is the same license as the one of Lua.