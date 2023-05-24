package idw.model.rn;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwMacrangeDAO;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.pojos.DwMacrange;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwMacrangeTemplate.StMacrange;
import idw.model.pojos.template.DwMacrangeTemplate.TpRegra;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.dto.MacDTO;

public class MacRN extends AbstractRN<DAOGenerico> {
	
	private final String formatoData;
	
	public MacRN(String formatoData) {
		this(null, formatoData);
	}

	public MacRN(DAOGenerico dao, String formatoData) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
	}
	
	public List<MacDTO> getAll() {
		List<MacDTO> macsDTO = new ArrayList<MacDTO>();
		DwMacrangeDAO dao = new DwMacrangeDAO(getDaoSession());
		for(DwMacrange mac : dao.getTodos()) {
			macsDTO.add(converterParaDTO(mac));
		}
		return macsDTO;
	}
	
	public List<MacDTO> getMacsLimiteGlobal() {
		List<MacDTO> macsDTO = new ArrayList<MacDTO>();
		DwMacrangeDAO dao = new DwMacrangeDAO(getDaoSession());
		for(DwMacrange mac : dao.getMacPorRegra(TpRegra.LIMITEGLOBAL)) {
			macsDTO.add(converterParaDTO(mac));
		}
		return macsDTO;
	}
	
	public BigInteger getQuantidadeRestanteTotalMac(List<MacDTO> dtos) {
		BigInteger acumulado = new BigInteger("0");
		for(MacDTO dto : dtos) {
			BigInteger quantidade = new BigInteger(dto.getQuantidadeRestante());
			acumulado = acumulado.add(quantidade);
		}
		return acumulado;
	}
	
	public void salvar(MacDTO dto) throws JsonException {		
		DwMacrange mac = converterParaPojo(dto);
		validarMacRange(mac);
		
		mac.setIdMacrange(null);
		mac.setStMacrange(StMacrange.COM_MAC_DISPONIVEL.getId());
		mac.setDthrCadastro(DataHoraRN.getDataHoraAtual());
		//System.out.println("salvando imaginariamente");
		getDao().makePersistent(mac);
	}
	
	private MacDTO converterParaDTO(DwMacrange mac) {
		if(mac == null) {
			
		}
		
		MacDTO dto = new MacDTO();
		dto.setIdMacRange(mac.getIdMacrange());
		dto.setCdMacInicio(mac.getCdMacInicial());
		dto.setCdMacFim(mac.getCdMacFinal());
		dto.setModelo(mac.getCdModelo());
		if(mac.getOmGt() != null) {
			dto.setCdGt(mac.getOmGt().getCdGt());
		}
		dto.setQtdPorPeca(mac.getQtPorpeca());
		dto.setRegraConsumo(mac.getTpRegraFormatado());
		dto.setCdUltimoMacConsumido(mac.getCdUltimomacusado());
		dto.setDtHr(mac.getDthrCadastroFormatado(formatoData));
		if(mac.getOmUsr() != null) {
			dto.setCdUsr(mac.getOmUsr().getCdUsr());
			dto.setDsApelido(mac.getOmUsr().getDsApelido());
		}
		dto.setQuantidadeRestante(String.valueOf(
				calcularADiferenca(
						mac.getCdMacInicial(), mac.getCdMacFinal())));
		return dto;
	}
	
	private DwMacrange converterParaPojo(MacDTO dto) throws JsonException {
		if(dto == null) {
			
		}
		
		DwMacrange mac = new DwMacrange();
		try {
			mac.setIdMacrange(dto.getIdMacRange());
			mac.setCdMacInicial(dto.getCdMacInicio().toUpperCase());
			mac.setCdMacFinal(dto.getCdMacFim().toUpperCase());
			mac.setCdModelo(dto.getModelo());
			mac.setOmGt(getGt(dto.getCdGt()));
			mac.setQtPorpeca(dto.getQtdPorPeca());
			mac.setTpRegraUsandoTemplate(dto.getRegraConsumo());
			mac.setCdUltimomacusado(dto.getCdUltimoMacConsumido());
			mac.setDthrCadastroUsandoTemplate(dto.getDtHr(), formatoData);
			mac.setOmUsr(getUsuario(dto.getCdUsr()));
			if(dto.getIdMacPai() > 0) {
				DwMacrangeDAO dao = new DwMacrangeDAO(getDaoSession());
				mac.setDwMacrangepai(dao.getMacPorId(dto.getIdMacPai()));
				System.out.println("PAI: " + mac.getDwMacrangepai().getCdModelo());
			}
		} catch (Exception exception) {
			throw exception;
		}
		
		return mac;
	}
	
	private OmGt getGt(String cdGt) throws JsonException {
		OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
		OmGt gt = gtDAO.getOmGtPorCdAtivo(cdGt);
		if(gt == null) {
			throw new JsonException("Linha(GT) inválida");
		}
		return gt;
	}
	
	private OmUsr getUsuario(String cdUsuario) throws JsonException {
		OmUsrDAO usuarioDAO = new OmUsrDAO(getDaoSession());
		OmUsr usuario = usuarioDAO.getOmUsrPorCdAtivo(cdUsuario);
		if(usuario == null) {
			throw new JsonException("Usuário inválido");
		}
		return usuario;
	}
	
	private void validarMacRange(DwMacrange mac) throws JsonException {
		String macInicial = mac.getCdMacInicial();
		String macFinal = mac.getCdMacFinal();
		
		if(macInicial == null) {
			throw new JsonException("Mac inicial não pode ser vazio.");
		}
		
		if(macFinal == null) {
			throw new JsonException("Mac final não pode ser vazio.");
		}
		
		if(!isMacFinalMaiorQueMacInicial(macInicial, macFinal)) {
			throw new JsonException("Mac final deve ser maior que o Mac inicial.");
		}
		
		DwMacrangeDAO dao = new DwMacrangeDAO(getDaoSession());
		
		if(mac.getTpRegra() == TpRegra.LIMITEGLOBAL.getId()) {
			boolean possuiIntercessao = dao.possuiIntercessaoRangeGlobal(macInicial, macFinal);
			if(possuiIntercessao) {
				throw new JsonException("Range de Mac possui intercessão.");
			}
		} else {
			
			String macInicialPai = mac.getDwMacrangepai().getCdMacInicial();
			String macFinalPai = mac.getDwMacrangepai().getCdMacFinal();
			
			if(!isDentroDoRange(macInicial, macInicialPai, macFinalPai)) {
				throw new JsonException("Mac inicial deve estar dentro do limite global.");
			}

			if(!isDentroDoRange(macFinal, macInicialPai, macFinalPai)) {
				throw new JsonException("Mac final deve estar dentro do limite global.");
			}
			
			boolean possuiIntercessaoDentroPai = dao.possuiIntercessaoRangePai(mac.getDwMacrangepai().getIdMacrange(), macInicial, macFinal);
			if(possuiIntercessaoDentroPai) {
				throw new JsonException("Range de Mac possui intercessão.");
			}
		}
		
	}

	public static boolean isDentroDoRange(String valorString, String valorRangeInicio, String valorRangeFinal) {
		BigInteger valor = new BigInteger(valorString, 16);
		BigInteger inicio = new BigInteger(valorRangeInicio, 16);
		BigInteger fim = new BigInteger(valorRangeFinal, 16);
		
		if (valor.compareTo(inicio) < 0) {
			// valor menor que range inicio
			return false;
		}
		
		if (valor.compareTo(fim) >= 1) {
			// valor maior que range final
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		MacRN r = new MacRN(null, null);
		BigInteger ipai = new BigInteger("1");
		BigInteger fpai = new BigInteger("10");
		BigInteger i = new BigInteger("11");
		BigInteger f = new BigInteger("20");
		
		System.out.println(r.isIntersecaoNoRange(ipai, fpai, i, f));
	}
	public boolean isIntersecaoNoRange(BigInteger nsInicialPai, BigInteger nsFinalPai, BigInteger nsInicialFilho, BigInteger nsFinalFilho) {
		boolean isRetorno =  (nsInicialFilho.compareTo(nsInicialPai) >= 0 && 
				nsInicialFilho.compareTo(nsFinalPai) <= 0 && 
				nsFinalFilho.compareTo(nsInicialPai) >= 0 && 
				nsFinalFilho.compareTo(nsFinalPai) <= 0);
		
		return isRetorno;
	}
	
	private boolean isMacFinalMaiorQueMacInicial(String macInicial, String macFinal) {
		BigInteger inicio = new BigInteger(macInicial, 16);
		BigInteger fim = new BigInteger(macFinal, 16);
		int resultado = fim.compareTo(inicio);
		if(resultado == 1) {
			return true;
		}
		return false;
	}
	
	private BigInteger calcularADiferenca(String macInicial, String macFinal) {
		BigInteger inicio = new BigInteger(macInicial, 16);
		BigInteger fim = new BigInteger(macFinal, 16);
		return fim.subtract(inicio);
	}

}
