package idw.model.rn.alimentacao;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmUsr;
import idw.util.Util;
import idw.webservices.dto.LeituraCODTO;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.MapaCODTO;
import idw.webservices.dto.PosicaoCODTO;
import idw.webservices.dto.UsuarioCODTO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlimentacaoTest {
	
	private DAOGenericoTest daoGenericoTest;
	
	@Before
	public void iniciaConexaoBanco() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaConexaoBanco();
		OmCfg omCfg = Util.getConfigGeral(daoGenericoTest.getSession());
		Assert.assertNotNull(omCfg);
	}
	
	@After
	public void finalizaConexaoBanco() throws Exception {
		daoGenericoTest.finalizaConexaoBanco();
		daoGenericoTest = null;
	}
	
	/**
	 * Gera lista de DTO apartir do mapa
	 * @param mapa
	 * @return List<LeituraCODTO> 
	 * @throws NumberFormatException
	 */
	private List<LeituraCODTO> getLeiturasCODTO(OmMapa mapa) throws NumberFormatException {
		List<LeituraCODTO> retorno = new ArrayList<>();
		for(OmMapapa mapapa : mapa.getOmMapapas()){
			LeituraCODTO dto = new LeituraCODTO();
			dto.setCbRap(mapapa.getOmPa().getCdPa());
			dto.setCdLidoProduto(mapapa.getOmProduto().getCdProduto());
			dto.setDthrLeitura("2014-11-15");
			dto.setIdUsuario(1); 
			dto.setIsConferenciaOuAlimentacao(1);
			dto.setLeituraOk(true);
			dto.setPosicaoASerLida(getPosicaoCODTO(mapapa));
			dto.setQtAlimentada(Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade para a posiçãoo "+mapapa.getOmPa().getCdPa())));
			retorno.add(dto);
		}
		return retorno;
	}
	
	/**
	 * Monta DTO apartir do mapapa
	 * @param mapapa
	 * @return PosicaoCODTO
	 */
	private PosicaoCODTO getPosicaoCODTO(OmMapapa mapapa) {
		PosicaoCODTO retorno = new PosicaoCODTO();
		retorno.setCdFeeder(mapapa.getOmPa().getCdPa());
//		retorno.setAutorizado(autorizado);
//		retorno.setCdProduto(cdProduto);
//		retorno.setCdRap(cdRap);
//		retorno.setDesvio(desvio);
//		retorno.setIdFeeder(idFeeder);
//		retorno.setIdMapapa(idMapapa);
//		retorno.setIdProduto(idProduto);
//		retorno.setLido(lido);
//		retorno.setOrdem(ordem);
		return retorno;
	}
	
	/**
	 * Monta DTO apartir do mapa
	 * @param idMapa
	 * @return MapaCODTO
	 */
	private MapaCODTO getMapa(OmMapa mapa) {
		MapaCODTO dto = new MapaCODTO();
		dto.setCdMapa(mapa.getCdMapa());
		dto.setIdMapa(mapa.getIdMapa());
//		dto.setIsAlimentacaoCorrenteExclusiva(?);//trecho usando na linha AlimentacaoRN linha 425, campo em ompt fica tudo null por que isso nao Ã© setado
//		dto.setIsControlarNivelAlimentacao(?);
//		dto.setMascaraQtd(?);
		return dto;
	}
	
	/**
	 * Monta DTO apartir do usuÃ¡rio
	 * @param usr
	 * @return
	 */
	private UsuarioCODTO getUsuarioCODTO(OmUsr usr) {
		UsuarioCODTO retorno = new UsuarioCODTO();
//		retorno.setApelido(apelido);
//		retorno.setDthrServidor(dthrServidor);
		retorno.setIdUsuario(usr.getIdUsr());
//		retorno.setIsAutorizado(isAutorizado);
//		retorno.setMatricula(matricula);
		return retorno;
	}
	
	/**
	 * Monta DTO referente a alimentaçãoo
	 * @return LeiturasCODTO
	 * @throws NumberFormatException
	 */
	private LeiturasCODTO simulaLeituras() throws NumberFormatException{
		
		//parametros
		OmMapa mapa = daoGenericoTest.findById(OmMapa.class, 206164l, true);
		OmUsr usuario = daoGenericoTest.findById(OmUsr.class, 1l, false);
		
		LeiturasCODTO retorno = new LeiturasCODTO();
		retorno.setIsExclusividade("sim");
		retorno.setUsuario(getUsuarioCODTO(usuario));
		retorno.setStatus((byte)1);		
		//maquina a ser alimentada
		retorno.setCdMaquina("CM402-2_L6");
		retorno.setMapa(getMapa(mapa));
		retorno.setLeituras(getLeiturasCODTO(mapa));
		return retorno;
	}
	
	@Test
	public void realizarAlimentacaoTest(){
		AlimentacaoRN alimentacaoRN = new AlimentacaoRN();
		alimentacaoRN.setDao(daoGenericoTest);
		try {
			LeiturasCODTO leituras = simulaLeituras();
			alimentacaoRN.setConferenciaOuPre(leituras);
		} catch(NumberFormatException e) {
			System.out.println("Quantidade informada não Ã© vÃ¡lida");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
