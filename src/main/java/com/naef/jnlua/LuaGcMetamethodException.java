/*
 * $Id$
 * See LICENSE.txt for license terms.
 */

package com.naef.jnlua;

/**
 * Indicates an Lua garbage collection metamethod error.
 * 
 * <p>
 * This exception is thrown if an error occurs running a <code>__gc</code>
 * metamethod during garbage collection.
 * </p>
 */
public class LuaGcMetamethodException extends LuaException {
	// -- Static
	private static final long serialVersionUID = 1L;

	// -- Construction
	/**
	 * Creates a new instance.
	 * 
	 * @param msg
	 *            the message
	 */
	public LuaGcMetamethodException(String msg) {
		super(msg);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param msg
	 *            the message
	 * @param cause
	 *            the cause of this exception
	 */
	public LuaGcMetamethodException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
