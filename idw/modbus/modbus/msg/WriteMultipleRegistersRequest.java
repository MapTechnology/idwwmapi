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
package modbus.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import modbus.Modbus;
import modbus.ModbusCoupler;
import modbus.io.NonWordDataHandler;
import modbus.procimg.IllegalAddressException;
import modbus.procimg.ProcessImage;
import modbus.procimg.Register;
import modbus.procimg.SimpleRegister;

/**
 * Class implementing a <tt>ReadMultipleRegistersRequest</tt>.
 * The implementation directly correlates with the class 0
 * function <i>write multiple registers (FC 16)</i>. It
 * encapsulates the corresponding request message.
 *
 * @author Dieter Wimberger
 * @version 1.1 (08/06/2004)
 */
public final class WriteMultipleRegistersRequest
    extends ModbusRequest {

  //instance attributes
  private int m_Reference;
  //private int[] m_RegisterValues;
  private Register[] m_Registers;
  private NonWordDataHandler m_NonWordDataHandler = null;
  //private static boolean m_NonWord=false;

  /**
   * Constructs a new <tt>WriteMultipleRegistersRequest</tt>
   * instance.
   */
  public WriteMultipleRegistersRequest() {
    super();
    setFunctionCode(Modbus.WRITE_MULTIPLE_REGISTERS);
  }//constructor

  /**
   * Constructs a new <tt>WriteMultipleRegistersRequest</tt>
   * instance with a given reference and values to be written.
   * <p>
   * @param ref the reference number of the register
   *        to read from.
   * @param registers the registers to be written.
   */
  public WriteMultipleRegistersRequest(int ref, Register[] registers) {
    super();
    setFunctionCode(Modbus.WRITE_MULTIPLE_REGISTERS);
    setReference(ref);
    setRegisters(registers);
  }//constructor

  @Override
public ModbusResponse createResponse() {
    WriteMultipleRegistersResponse response = null;

    if (m_NonWordDataHandler == null) {
      Register[] regs = null;
      //1. get process image
      ProcessImage procimg = ModbusCoupler.getReference().getProcessImage();
      //2. get registers
      try {
        //TODO: realize a setRegisterRange()?
        regs = procimg.getRegisterRange(this.getReference(), this.getWordCount());
        //3. set Register values
        for (int i = 0; i < regs.length; i++) {
          regs[i].setValue(this.getRegister(i).toBytes());
        }
      } catch (IllegalAddressException iaex) {
        return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
      }
      response = new WriteMultipleRegistersResponse(this.getReference(), regs.length);
    } else {
      int result = m_NonWordDataHandler.commitUpdate();
      if (result > 0) {
        return createExceptionResponse(result);
      }
      response = new WriteMultipleRegistersResponse(
          this.getReference(),
          m_NonWordDataHandler.getWordCount()
      );
    }
    //transfer header data
    if (!isHeadless()) {
      response.setTransactionID(this.getTransactionID());
      response.setProtocolID(this.getProtocolID());
    } else {
      response.setHeadless();
    }
    response.setUnitID(this.getUnitID());
    response.setFunctionCode(this.getFunctionCode());
    return response;
  }//createResponse

  /**
   * Sets the reference of the register to writing to
   * with this <tt>WriteMultipleRegistersRequest</tt>.
   * <p>
   * @param ref the reference of the register
   *        to start writing to as <tt>int</tt>.
   */
  public void setReference(int ref) {
    m_Reference = ref;
  }//setReference

  /**
   * Returns the reference of the register to start
   * writing to with this
   * <tt>WriteMultipleRegistersRequest</tt>.
   * <p>
   * @return the reference of the register
   *        to start writing to as <tt>int</tt>.
   */
  public int getReference() {
    return m_Reference;
  }//getReference

  /**
   * Sets the registers to be written with this
   * <tt>WriteMultipleRegistersRequest</tt>.
   * <p>
   * @param registers the registers to be written
   *        as <tt>Register[]</tt>.
   */
  public void setRegisters(Register[] registers) {
    m_Registers = registers;
  }//setRegisters


  /**
   * Returns the registers to be written with this
   * <tt>WriteMultipleRegistersRequest</tt>.
   * <p>
   * @return the registers to be written as <tt>Register[]</tt>.
   */
  public Register[] getRegisters() {
    return m_Registers;
  }//getRegisters

  /**
   * Returns the <tt>Register</tt> at
   * the given position (relative to the reference
   * used in the request).
   * <p>
   * @param index the relative index of the <tt>Register</tt>.
   *
   * @return the register as <tt>Register</tt>.
   *
   * @throws IndexOutOfBoundsException if
   *         the index is out of bounds.
   */
  public Register getRegister(int index)
      throws IndexOutOfBoundsException {

    if (index >= getWordCount()) {
      throw new IndexOutOfBoundsException();
    } else {
      return m_Registers[index];
    }
  }//getRegister


  /**
   * Returns the value of the register at
   * the given position (relative to the reference
   * used in the request) interpreted as unsigned short.
   * <p>
   * @param index the relative index of the register
   *        for which the value should be retrieved.
   *
   * @return the value as <tt>int</tt>.
   *
   * @throws IndexOutOfBoundsException if
   *         the index is out of bounds.
   */
  public int getRegisterValue(int index)
      throws IndexOutOfBoundsException {
    return m_Registers[index].toUnsignedShort();
  }//getRegisterValue

  /**
   * Returns the number of bytes representing the
   * values to be written.
   * <p>
   * @return the number of bytes to be written
   *         as <tt>int</tt>.
   */
  public int getByteCount() {
    return getWordCount() * 2;
  }//getByteCount

  /**
   * Returns the number of words to be written.
   * <p>
   * @return the number of words to be written
   *         as <tt>int</tt>.
   */
  public int getWordCount() {
    return m_Registers.length;
  }//getWordCount

  /**
   * Sets a non word data handler.
   *
   * @param dhandler a  <tt>NonWordDataHandler</tt> instance.
   */
  public void setNonWordDataHandler(NonWordDataHandler dhandler) {
    m_NonWordDataHandler = dhandler;
  }//setNonWordDataHandler

  /**
   * Returns the actual non word data handler.
   *
   * @return the actual <tt>NonWordDataHandler</tt>.
   */
  public NonWordDataHandler getNonWordDataHandler() {
    return m_NonWordDataHandler;
  }//getNonWordDataHandler

  @Override
public void writeData(DataOutput dout)
      throws IOException {
    //1. the reference
    dout.writeShort(m_Reference);
    //2. the word count
    dout.writeShort(getWordCount());
    //3. the byte count as byte
    dout.writeByte(getByteCount());
    //4. write values
    if (m_NonWordDataHandler == null) {
      for (int n = 0; n < m_Registers.length; n++) {
        dout.write(m_Registers[n].toBytes());
      }
    } else {
      m_NonWordDataHandler.prepareData(getReference(), getWordCount());
      dout.write(m_NonWordDataHandler.getData());
    }
  }

  @Override
public void readData(DataInput din)
      throws IOException {

    m_Reference = din.readShort();
    //read lengths
    int wc = din.readUnsignedShort();
    @SuppressWarnings("unused")
	int bc = din.readUnsignedByte();

    //read values
    if (m_NonWordDataHandler == null) {
      m_Registers = new Register[wc];
      for (int i = 0; i < wc; i++) {
        m_Registers[i] = new SimpleRegister(din.readByte(), din.readByte());
      }
    } else {
      //m_NonWordDataHandler.readData(din, m_Reference, wc);
    }
  }//readData

}//class WriteMultipleRegistersRequest
