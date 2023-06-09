//License
/***
 * Java Modbus Library (jamod)
 * Copyright (c) 2002-2004, jamod development team
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the author nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS ``AS
 * IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ***/
package modbus.procimg;

/**
 * Class implementing a simple <tt>Register</tt>.
 * <p>
 * The <tt>setValue()</tt> method is synchronized,
 * which ensures atomic access, but no specific access order.
 *
 * @author Dieter Wimberger
 * @version 1.1 (08/06/2004)
 */
public class SimpleRegister
    extends SynchronizedAbstractRegister
    implements Register {

  /**
   * Constructs a new <tt>SimpleRegister</tt> instance.
   * It's state will be invalid.
   */
  public SimpleRegister() {
    m_Register = null;
  }//constructor

  /**
   * Constructs a new <tt>SimpleRegister</tt> instance.
   * 
   * @param b1 the first (hi) byte of the word.
   * @param b2 the second (low) byte of the word.
   */
  public SimpleRegister(byte b1, byte b2) {
    m_Register[0] = b1;
    m_Register[1] = b2;
  }//constructor

  /**
   * Constructs a new <tt>SimpleRegister</tt> instance
   * with the given value.
   *
   * @param value the value of this <tt>SimpleRegister</tt>
   *        as <tt>int</tt>.
   */
  public SimpleRegister(int value) {
    setValue(value);
  }//constructor(int)

  @Override
public boolean isValid() {
    return m_Register != null;
  }//isValid

  /**
   * Invalidates the state of this <tt>SimpleRegister</tt>.
   */
  public void invalidate() {
    m_Register = null;
  }//invalidate

}//SimpleInputRegister
