/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modbus;

import idw.util.IdwLogger;
import idw.webservices.dto.ParametroDTO;
import idw.model.excessoes.SemComunicacaoException;
import idw.model.rn.DataHoraRN;

import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modbus.ModbusIOException;
import modbus.io.ModbusTCPTransaction;
import modbus.msg.ReadCoilsRequest;
import modbus.msg.ReadCoilsResponse;
import modbus.msg.ReadMultipleRegistersRequest;
import modbus.msg.ReadMultipleRegistersResponse;
import modbus.msg.WriteCoilRequest;
import modbus.msg.WriteMultipleRegistersRequest;
import modbus.msg.WriteSingleRegisterRequest;
import modbus.net.TCPMasterConnection;
import modbus.procimg.Register;
import modbus.procimg.SimpleRegister;


/**
 * 
 * @author Senoj
 * Nessa classe devem ter apenas os metodos basicos de IO ao altus
 */
public class ModBusIO {

	private TCPMasterConnection con = null;
	private Date ini;
	
	private String conIP = "";
	private int conPort = 0;
	private IdwLogger log;
	boolean isCLPsemComunicacao;	
	protected List<ParametroDTO> listaParametroDTO= new ArrayList<ParametroDTO>();
	protected Calendar dthrCLPUltimoEvento;
	
	public Date SetIniCronometro(){
		ini= new Date();
		return this.ini;
	}
	
	public void GeraLogTempoDecorrido(String nomeMetodo){
		log.info(this+" - M�todo "+nomeMetodo+"() executado em: "+
				DataHoraRN.getQuantidadeMilisegundosNoPeriodo(ini, new Date())+"ms");
	}

	public ModBusIO(String ip, int porta, IdwLogger log) {
		this.conIP = ip;
		this.conPort = porta;
		this.log = log;		
	}
	
	public IdwLogger getLog(){
		return this.log;
	}
	
	public String GetIP(){
		return this.conIP;
	}
	
	public int GetPort(){
		return this.conPort;
	}
	
	public Calendar obtemDtHrUltimoEvento(){
		return dthrCLPUltimoEvento;
	}
	
	public boolean leCoil( int iRegister)
			throws SemComunicacaoException {		
		boolean retorno = false;
		ModbusTCPTransaction trans;
		ReadCoilsRequest reqRdCoil = null;
		ReadCoilsResponse resRdCoil = null;

		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdCoil = new ReadCoilsRequest(iRegister, 1);
			reqRdCoil.setUnitID(1);
			trans.setRequest(reqRdCoil);
			trans.execute();
			resRdCoil = (ReadCoilsResponse) trans.getResponse();
			retorno = resRdCoil.getCoils().getBit(0);
			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}

	}

	public boolean[] leVetorCoil(int iRegister, int size)
			throws SemComunicacaoException {			
		boolean retorno[] = new boolean[size];
		ModbusTCPTransaction trans;
		ReadCoilsRequest reqRdCoil = null;
		ReadCoilsResponse resRdCoil = null;

		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdCoil = new ReadCoilsRequest(iRegister, size);
			reqRdCoil.setUnitID(1);			
			trans.setRequest(reqRdCoil);
			trans.execute();
			resRdCoil = (ReadCoilsResponse) trans.getResponse();
			for (int i = 0; i < size; i++) {
				retorno[i] = resRdCoil.getCoils().getBit(i);
			}
			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}	
	
	
	public void tentaReconectar()throws Exception{
		InetAddress addr = null;
		if (con == null || !con.isConnected()) {
			addr = InetAddress.getByName(this.conIP);
			con = new TCPMasterConnection(addr);
			con.setPort(this.conPort);
			con.connect();		
			Thread.sleep(10);
		}
	}
	
	public void tentaFecharConexao(){
		try{
			if(con !=null)
				con.close();
		}catch(Exception e){
			log.info("N�o pode Fechar a Conex�o:"+con.getAddress()+":"+con.getPort()+" -- "+e.getMessage());
			log.info(e);
			//n�o faz nada apenas tenta fecha a conex�o antes de setar NULL na conex�o
		}
		con = null;
	}
	
	public boolean escreveCoil( int iRegister,
			boolean valor) throws SemComunicacaoException {
		ModbusTCPTransaction trans;
		WriteCoilRequest reqWrCoil = null;
		try {
			tentaReconectar();	
			trans = new ModbusTCPTransaction(con);
			reqWrCoil = new WriteCoilRequest(iRegister, valor);
			reqWrCoil.setUnitID(1);			
			trans.setRequest(reqWrCoil);
			trans.execute();
			return true;
		} catch (SocketTimeoutException ste) {			
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("No IP " + this);
			tentaFecharConexao();
			throw new SemComunicacaoException();			
		}

	}

	public int leHoldingRegister(int iRegister)
			throws SemComunicacaoException {
		int retorno = 0;	    
		ModbusTCPTransaction trans;
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegister, 1);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();
			retorno = resRdReg.getRegisterValue(0);
			return retorno;
		} catch (ModbusIOException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (ConnectException e){
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} 
	}
		
	public long leLongHoldingRegister(int iRegister)
			throws SemComunicacaoException {
		long retorno = 0;
		ModbusTCPTransaction trans;
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegister, 4);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();

			retorno = 0L;
			retorno = ((long) (0xffFFL & resRdReg.getRegisterValue(0)) << 48);
			retorno |= ((long) (0xffFFL & resRdReg.getRegisterValue(1)) << 32);
			retorno |= ((long) (0xffFFL & resRdReg.getRegisterValue(2)) << 16);
			retorno |= ((long) (0xffFFL & resRdReg.getRegisterValue(3)));

			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}
	
	public void escreveLongHoldingRegister( int iRegister, long valor)
			throws SemComunicacaoException {
		ModbusTCPTransaction trans;
		WriteMultipleRegistersRequest reqWrReg = null;
		
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			Register[] registers = new Register[4];
			registers[0] = new SimpleRegister((int) (0xffFF & (valor >> 48)));
			registers[1] = new SimpleRegister((int) (0xffFF & (valor >> 32)));
			registers[2] = new SimpleRegister((int) (0xffFF & (valor >> 16)));
			registers[3] = new SimpleRegister((int) (0xffFF & valor));
			reqWrReg = new WriteMultipleRegistersRequest(iRegister, registers);
			reqWrReg.setUnitID(1);
			trans.setRequest(reqWrReg);
			trans.execute();

		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}

	public void escreveHoldingRegister( int iRegister, int valor)
			throws SemComunicacaoException {
		ModbusTCPTransaction trans;
		WriteSingleRegisterRequest reqWrReg=null;
		
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqWrReg = new WriteSingleRegisterRequest(iRegister, new SimpleRegister(valor) );
			reqWrReg.setUnitID(1);
			trans.setRequest(reqWrReg);
			trans.execute();
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " +this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}
		
	public void escreveVetorHoldingRegister(int iRegister, Register[] registers) throws SemComunicacaoException {
		
		ModbusTCPTransaction trans;
		WriteMultipleRegistersRequest reqWrReg = null;
		
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqWrReg = new WriteMultipleRegistersRequest(iRegister,	registers);
			reqWrReg.setUnitID(1);	
			trans.setRequest(reqWrReg);			
			trans.execute();
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}

	public String lerStringDados( int iRegister, int size)
			throws SemComunicacaoException {
		int valor;
		String retorno = null;
		ModbusTCPTransaction trans;
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		 
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegister, size);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();
			retorno = "";
			for (int i = 0; i < size; i++) {
				valor = resRdReg.getRegisterValue(i);
				retorno += Character.toString((char) (valor & 0xFF))
						+ Character.toString((char) ((valor >> 8) & 0xFF));
			}
			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " +this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}

	public void moveMemoria( int iRegisterOrigem,
			int iRegisterDestino, int size) throws SemComunicacaoException {
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		WriteMultipleRegistersRequest reqWrReg = null;
		
		ModbusTCPTransaction trans;
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegisterOrigem, size);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			Register[] registers = new Register[size];
			for (int i = 0; i < size; i++) {				
				registers[i] = new SimpleRegister(resRdReg.getRegisterValue(i));
			}
			reqWrReg = new WriteMultipleRegistersRequest(iRegisterDestino,
					registers);
			reqWrReg.setUnitID(1);
			trans.setRequest(reqWrReg);
			trans.execute();
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " +this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}	
	
	public List<Float> leVetorFloatHoldingRegister(int iRegister, int quantidade) throws SemComunicacaoException {
		List<Float> retorno = new ArrayList<Float>();
		ModbusTCPTransaction trans;
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegister, quantidade);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();

			for (int i = 0 ; i < quantidade; i+=2){
				retorno.add(Float.intBitsToFloat( resRdReg.getRegisterValue(i) ^ resRdReg.getRegisterValue(i+1)<<16 ));
				
			}
			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}
	
	public List<Integer> leVetorHoldingRegister(int iRegister, int quantidade) throws SemComunicacaoException {
		List<Integer> retorno = new ArrayList<Integer>();
		ModbusTCPTransaction trans;
		ReadMultipleRegistersRequest reqRdReg = null;
		ReadMultipleRegistersResponse resRdReg = null;
		try {
			tentaReconectar();
			trans = new ModbusTCPTransaction(con);
			reqRdReg = new ReadMultipleRegistersRequest(iRegister, quantidade);
			reqRdReg.setUnitID(1);
			trans.setRequest(reqRdReg);
			trans.execute();
			resRdReg = (ReadMultipleRegistersResponse) trans.getResponse();

			String registers = "Valores lidos dos registradores iRegister:" + iRegister + " [";
			for (int i = 0 ; i < quantidade; i++){
				retorno.add((Integer)resRdReg.getRegisterValue(i));
				registers = registers + (Integer)resRdReg.getRegisterValue(i) + ", ";
			}
			
			registers = registers + "]";
			log.info(registers);
			
			return retorno;
		} catch (SocketTimeoutException ste) {
			tentaFecharConexao();
			throw new SemComunicacaoException();
		} catch (Exception ex) {
			log.info("Erro no IP " + this);
			log.info("ERROR: ", ex);
			tentaFecharConexao();
			throw new SemComunicacaoException();
		}
	}

	@Override
	public String toString(){
		return conIP + ":" + conPort;
	}		

}
