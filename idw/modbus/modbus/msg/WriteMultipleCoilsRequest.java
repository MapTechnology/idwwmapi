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
import modbus.procimg.DigitalOut;
import modbus.procimg.IllegalAddressException;
import modbus.procimg.ProcessImage;
import modbus.util.BitVector;

/**
 * Class implementing a <tt>WriteMultipleCoilsRequest</tt>.
 * The implementation directly correlates with the class 1
 * function <i>write multiple coils (FC 15)</i>. It encapsulates
 * the corresponding request message.
 * <p>
 * Coils are understood as bits that can be manipulated
 * (i.e. set or unset).
 *
 * @author Dieter Wimberger
 * @version 1.1 (08/06/2004)
 */
public final class WriteMultipleCoilsRequest
    extends ModbusRequest {

  //instance attributes
  private int m_Reference;
  private int m_BitCount;
  private BitVector m_Coils;

  /**
   * Constructs a new <tt>ReadCoilsRequest</tt>
   * instance.
   */
  public WriteMultipleCoilsRequest() {
    super();
    setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
    //5 bytes (unit id and function code is excluded)
    setDataLength(5);
  }//constructor

  /**
   * Constructs a new <tt>ReadCoilsRequest</tt>
   * instance with a given reference and count of coils
   * (i.e. bits) to be read.
   * <p>
   * @param ref the index of the first coil to be written.
   * @param count the number of coils to be written.
   */
  public WriteMultipleCoilsRequest(int ref, int count) {
    super();
    setFunctionCode(Modbus.READ_COILS);
    setReference(ref);
    setBitCount(count);
  }//constructor

/*
  public ModbusResponse getResponse() {
    WriteMultipleCoilsResponse response = new WriteMultipleCoilsResponse();
    response.setHeadless(isHeadless());
    return response;
  }//getResponse
*/

  @Override
public ModbusResponse createResponse() {
    WriteMultipleCoilsResponse response = null;
    DigitalOut douts[] = null;

    //1. get process image
    ProcessImage procimg = ModbusCoupler.getReference().getProcessImage();
    //2. get coil range
    try {
      douts = procimg.getDigitalOutRange(m_Reference, m_BitCount);
      //3. set coils
      for(int i=0;i<douts.length;i++) {
        douts[i].set(m_Coils.getBit(i));
      }
    } catch (IllegalAddressException iaex) {
      return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
    }
    response = new WriteMultipleCoilsResponse(m_Reference, m_BitCount);

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
   * Sets the reference of the register to start reading
   * from with this <tt>ReadCoilsRequest</tt>.
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
   * reading from with this <tt>ReadCoilsRequest</tt>.
   * <p>
   * @return the reference of the register
   *        to start reading from as <tt>int</tt>.
   */
  public int getReference() {
    return m_Reference;
  }//getReference

  /**
   * Returns the number of bits (i.e. input discretes)
   * read with the request.
   * <p>
   * @return the number of bits that have been read.
   */
  public int getBitCount() {
    return m_BitCount;
  }//getBitCount

  /**
   * Sets the number of coil bits to be written.
   *
   * @param count the number as <tt>int</tt>.
   */
  public void setBitCount(int count) {
    m_BitCount = count;
    m_Coils = new BitVector(count);
    m_Coils.setStartLSB(true);
    //set correct length, without counting unitid and fc
    setDataLength(m_Coils.byteSize() + 5);
  }//setBitCount

  /**
   * Returns the number of bytes required for packing the
   * coil bits.
   *
   * @return the number of bytes required for packing the coil bits.
   */
  public int getByteCount() {
    return m_Coils.byteSize();
  }//getByteCount

  /**
   * Returns the status of the given coil.
   *
   * @param index the index of the coil to be tested.
   * @return true if set, false otherwise.
   * @throws IndexOutOfBoundsException if the given index is out of bounds.
   */
  public boolean getCoilStatus(int index)
      throws IndexOutOfBoundsException {

    return m_Coils.getBit(index);
  }//getCoilStatus

  /**
   * Sets the coil status of the given coil.
   *
   * @param index the index of the coil to be set/reset.
   * @param b true if to be set, false for reset.
   * @throws IndexOutOfBoundsException if the given index is out of bounds.
   */
  public void setCoilStatus(int index, boolean b)
      throws IndexOutOfBoundsException {
    m_Coils.setBit(index, b);
  }//setCoilStatus

  /**
   * Returns the <tt>BitVector</tt> instance holding coil
   * status information.
   *
   * @return the coils status as <tt>BitVector</tt> instance.
   */
  public BitVector getCoils() {
    return m_Coils;
  }//getCoils

  @Override
public void writeData(DataOutput dout)
      throws IOException {
    dout.writeShort(m_Reference);
    dout.writeShort(m_BitCount);
    dout.writeByte(m_Coils.byteSize());
    dout.write(m_Coils.getBytes());
  }//writeData

  @Override
public void readData(DataInput din)
      throws IOException {

    m_Reference = din.readUnsignedShort();
    m_BitCount = din.readUnsignedShort();
    int count = din.readUnsignedByte();
    byte[] data = new byte[count];
    for (int k = 0; k < count; k++) {
      data[k] = din.readByte();
    }
    //decode bytes into bitvector, sets data
    m_Coils = BitVector.createBitVector(data);
    m_Coils.setStartLSB(true);

    //update data length
    setDataLength(count + 5);
  }//readData


}//class WriteMultipleCoilsRequest
