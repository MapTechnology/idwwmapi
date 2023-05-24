/**
 * (c) Melexis Telecom and/or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp.common;

import idw.util.IdwLogger;


public class RRQ extends FRQ {
  /**
   * 
   * RRQ default constructor. 
   * Added because off the client requirement to create RRQ objects. 
   *
   */
  public RRQ(IdwLogger log) throws InstantiationException {
     super(log);
  }
  
  public RRQ(byte [] tftpP,IdwLogger log) throws InstantiationException {
    super(tftpP,log);
  }

  static public final int OPCODE  = 1;
  @Override
public int getOpCode() { return OPCODE; }
}
