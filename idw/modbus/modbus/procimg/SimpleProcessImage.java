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

import java.util.Vector;

/**
 * Class implementing a simple process image
 * to be able to run unit tests or handle
 * simple cases.
 *
 * @author Dieter Wimberger
 * @version 1.1 (08/06/2004)
 */

@SuppressWarnings("rawtypes")
public class SimpleProcessImage
    implements ProcessImageImplementation {

  //instance attributes
  
  private Vector m_DigitalInputs;
  private Vector m_DigitalOutputs;
  private Vector m_InputRegisters;
  private Vector m_Registers;

  /**
   * Constructs a new <tt>SimpleProcessImage</tt> instance.
   */
  public SimpleProcessImage() {
    m_DigitalInputs = new Vector();
    m_DigitalOutputs = new Vector();
    m_InputRegisters = new Vector();
    m_Registers = new Vector();
  }//SimpleProcessImage

 
@SuppressWarnings("unchecked")
@Override
public void addDigitalIn(DigitalIn di) {
    m_DigitalInputs.addElement(di);
  }//addDigitalIn

 @Override 
public void removeDigitalIn(DigitalIn di) {
    m_DigitalInputs.removeElement(di);
  }//removeDigitalIn

  @Override
  @SuppressWarnings("unchecked")
public void setDigitalIn(int ref, DigitalIn di)
      throws IllegalAddressException {
    try {
      m_DigitalInputs.setElementAt(di, ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//setDigitalIn

  @Override
public DigitalIn getDigitalIn(int ref)
      throws IllegalAddressException {

    try {
      return (DigitalIn) m_DigitalInputs.elementAt(ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//getDigitalIn

  @Override
public int getDigitalInCount() {
    return m_DigitalInputs.size();
  }//getDigitalInCount

  @Override
public DigitalIn[] getDigitalInRange(int ref, int count) {
    //ensure valid reference range
    if (ref < 0 || ref + count > m_DigitalInputs.size()) {
      throw new IllegalAddressException();
    } else {
      DigitalIn[] dins = new DigitalIn[count];
      for (int i = 0; i < dins.length; i++) {
        dins[i] = getDigitalIn(ref + i);
      }
      return dins;
    }
  }//getDigitalInRange

  @Override
  @SuppressWarnings("unchecked")
public void addDigitalOut(DigitalOut _do) {
    m_DigitalOutputs.addElement(_do);
  }//addDigitalOut

  @Override
public void removeDigitalOut(DigitalOut _do) {
    m_DigitalOutputs.removeElement(_do);
  }//removeDigitalOut

  @Override
  @SuppressWarnings("unchecked")
public void setDigitalOut(int ref, DigitalOut _do)
      throws IllegalAddressException {
    try {
      m_DigitalOutputs.setElementAt(_do, ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//setDigitalOut

  @Override
public DigitalOut getDigitalOut(int ref)
      throws IllegalAddressException {

    try {
      return (DigitalOut) m_DigitalOutputs.elementAt(ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//getDigitalOut

  @Override
public int getDigitalOutCount() {
    return m_DigitalOutputs.size();
  }//getDigitalOutCount

  @Override
public DigitalOut[] getDigitalOutRange(int ref, int count) {
    //ensure valid reference range
    if (ref < 0 || ref + count > m_DigitalOutputs.size()) {
      throw new IllegalAddressException();
    } else {
      DigitalOut[] douts = new DigitalOut[count];
      for (int i = 0; i < douts.length; i++) {
        douts[i] = getDigitalOut(ref + i);
      }
      return douts;
    }
  }//getDigitalOutRange

  @Override
  @SuppressWarnings("unchecked")
public void addInputRegister(InputRegister reg) {
    m_InputRegisters.addElement(reg);
  }//addInputRegister

  @Override
public void removeInputRegister(InputRegister reg) {
    m_InputRegisters.removeElement(reg);
  }//removeInputRegister

  @Override
  @SuppressWarnings("unchecked")
public void setInputRegister(int ref, InputRegister reg)
      throws IllegalAddressException {
    try {
      m_InputRegisters.setElementAt(reg, ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//setInputRegister

  @Override
public InputRegister getInputRegister(int ref)
      throws IllegalAddressException {

    try {
      return (InputRegister) m_InputRegisters.elementAt(ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//getInputRegister

  @Override
public int getInputRegisterCount() {
    return m_InputRegisters.size();
  }//getInputRegisterCount

  @Override
public InputRegister[] getInputRegisterRange(int ref, int count) {
    //ensure valid reference range
    if (ref < 0 || ref + count > m_InputRegisters.size()) {
      throw new IllegalAddressException();
    } else {
      InputRegister[] iregs = new InputRegister[count];
      for (int i = 0; i < iregs.length; i++) {
        iregs[i] = getInputRegister(ref + i);
      }
      return iregs;
    }
  }//getInputRegisterRange

  @Override
  @SuppressWarnings("unchecked")
public void addRegister(Register reg) {
    m_Registers.addElement(reg);
  }//addRegister

  @Override
public void removeRegister(Register reg) {
    m_Registers.removeElement(reg);
  }//removeRegister

  @Override
  @SuppressWarnings("unchecked")
public void setRegister(int ref, Register reg)
      throws IllegalAddressException {
    try {
      m_Registers.setElementAt(reg, ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//setRegister

  @Override
public Register getRegister(int ref)
      throws IllegalAddressException {

    try {
      return (Register) m_Registers.elementAt(ref);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalAddressException();
    }
  }//getRegister

  @Override
public int getRegisterCount() {
    return m_Registers.size();
  }//getRegisterCount

  @Override
public Register[] getRegisterRange(int ref, int count) {
    //ensure valid reference range
    if (ref < 0 || ref + count > m_Registers.size()) {
      throw new IllegalAddressException();
    } else {
      Register[] iregs = new Register[count];
      for (int i = 0; i < iregs.length; i++) {
        iregs[i] = getRegister(ref + i);
      }
      return iregs;
    }
  }//getRegisterRange

}//class SimpleProcessImage
