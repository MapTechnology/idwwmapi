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
import modbus.procimg.IllegalAddressException;
import modbus.procimg.ProcessImage;
import modbus.procimg.Register;

/**
 * Class implementing a <tt>ReadMultipleRegistersRequest</tt>.
 * The implementation directly correlates with the class 0
 * function <i>read multiple registers (FC 3)</i>. It
 * encapsulates the corresponding request message.
 *
 * @author Dieter Wimberger
 * @version 1.1 (08/06/2004)
 */
public final class ReadMultipleRegistersRequest
    extends ModbusRequest {

  //instance attributes
  private int m_Reference;
  private int m_WordCount;

  /**
   * Constructs a new <tt>ReadMultipleRegistersRequest</tt>
   * instance.
   */
  public ReadMultipleRegistersRequest() {
    super();
    setFunctionCode(Modbus.READ_MULTIPLE_REGISTERS);
    //4 bytes (remember unit identifier and function
    //code are excluded)
    setDataLength(4);
  }//constructor

  /**
   * Constructs a new <tt>ReadMultipleRegistersRequest</tt>
   * instance with a given reference and count of words
   * to be read.
   * <p>
   * @param ref the reference number of the register
   *        to read from.
   * @param count the number of words to be read.
   */
  public ReadMultipleRegistersRequest(int ref, int count) {
    super();
    setFunctionCode(Modbus.READ_MULTIPLE_REGISTERS);
    setDataLength(4);
    setReference(ref);
    setWordCount(count);
  }//constructor
/*
  public ModbusResponse getResponse() {
    ReadMultipleRegistersResponse response =
        new ReadMultipleRegistersResponse();
    response.setHeadless(isHeadless());
    return response;
  }//getResponse
*/
  @Override
public ModbusResponse createResponse() {
    ReadMultipleRegistersResponse response = null;
    Register[] regs = null;

    //1. get process image
    ProcessImage procimg = ModbusCoupler.getReference().getProcessImage();
    //2. get input registers range
    try {
      regs = procimg.getRegisterRange(this.getReference(), this.getWordCount());
    } catch (IllegalAddressException iaex) {
      return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
    }
    response = new ReadMultipleRegistersResponse(regs);
    //transfer header data
    if (!isHeadless()) {
      response.setTransactionID(this.getTransactionID());
      response.setProtocolID(this.getProtocolID());
    } else {
      response.setHeadless();
    }
    response.setUnitID(this.getUnitID());
    response.setFunctionCode(this.getFunctionCode());

    //for (int i = 0; i < regs.length; i++) {
    //  response.setRegisterValue(i, regs[i].getValue());
    //}
    return response;
  }//createResponse

  /**
   * Sets the reference of the register to start reading
   * from with this <tt>ReadMultipleRegistersRequest</tt>.
   * <p>
   * @param ref the reference of the register
   *        to start reading from.
   */
  public void setReference(int ref) {
    m_Reference = ref;
    //setChanged(true);
  }//setReference

  /**
   * Returns the reference of the register to to start
   * reading from with this
   * <tt>ReadMultipleRegistersRequest</tt>.
   * <p>
   * @return the reference of the register
   *        to start reading from as <tt>int</tt>.
   */
  public int getReference() {
    return m_Reference;
  }//getReference

  /**
   * Sets the number of words to be read with this
   * <tt>ReadMultipleRegistersRequest</tt>.
   * <p>
   * @param count the number of words to be read.
   */
  public void setWordCount(int count) {
    m_WordCount = count;
    //setChanged(true);
  }//setWordCount

  /**
   * Returns the number of words to be read with this
   * <tt>ReadMultipleRegistersRequest</tt>.
   * <p>
   * @return the number of words to be read as
   *        <tt>int</tt>.
   */
  public int getWordCount() {
    return m_WordCount;
  }//getWordCount

  @Override
public void writeData(DataOutput dout)
      throws IOException {
    dout.writeShort(m_Reference);
    dout.writeShort(m_WordCount);
  }//writeData

  @Override
public void readData(DataInput din)
      throws IOException {
    m_Reference = din.readUnsignedShort();
    m_WordCount = din.readUnsignedShort();
  }//readData

  /*
  protected void assembleData() throws IOException {
    m_DataOut.writeShort(m_Reference);
    m_DataOut.writeShort(m_WordCount);
  }//assembleData

  public void readData(DataInputStream in) throws IOException, EOFException {
    m_Reference = in.readUnsignedShort();
    m_WordCount = in.readUnsignedShort();
  }//readData
*/
}//class ReadMultipleRegistersRequest
