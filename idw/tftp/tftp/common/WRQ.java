/**
 * (c) Melexis Telecom and/or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp.common;

import idw.util.IdwLogger;

public class WRQ extends FRQ {
   
  /**
   * 
   * WRQ default constructor
   * @param tftpP
   * @throws InstantiationException
   */ 
  public WRQ(IdwLogger log) throws InstantiationException{
     super(log);
  }
  
  public WRQ(byte [] tftpP,IdwLogger log) throws InstantiationException {
    super(tftpP,log);
  }

  static public final int OPCODE  = 2;
  @Override
public int getOpCode() { return OPCODE; }
}

