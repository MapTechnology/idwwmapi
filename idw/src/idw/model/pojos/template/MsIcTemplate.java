package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.MsIc;
import ms.model.APojoMs;

public class MsIcTemplate extends APojoMs<MsIc>{

	public enum TpIc {
		_TP_IC_Adam_6050(BigDecimal.ONE),
		_TP_IC_Adam_4055(new BigDecimal(2)),
		_TP_IC_Nao_gerenciavel_por_driver(new BigDecimal(3)),
		_TP_IC_PAINELAUTOMATA(new BigDecimal(4)),
		_TP_IC_MICROLOGIC1400(new BigDecimal(5)),
		_TP_IC_INSERSORA(new BigDecimal(6)),

		_TP_IC_SQLCCK(new BigDecimal(7)),

		_TP_IC_Inova_StandAlone(new BigDecimal(8)),
		
		
		_TP_IC_ALCATEL(new BigDecimal(9)),
		_TP_IC_MIDIASONY(new BigDecimal(10)),	
		_TP_IC_AUTOMATA(new BigDecimal(11)),
		
		_TP_IC_CCK7200ME(new BigDecimal(12)),
		_TP_IC_INOVA(new BigDecimal(13)),
		_TP_IC_JCONCENTRADOR(new BigDecimal(14)),

		_TP_IC_LOGS_5G(new BigDecimal(15)),
		_TP_IC_LOGS_PT(new BigDecimal(16)),
		_TP_IC_LOGS_FTP(new BigDecimal(17)),
		_TP_IC_LOGS_TX(new BigDecimal(18)),
		
		_TP_IC_MINI_REMOTO(new BigDecimal(19)),
		_TP_IC_LOGS_SSID(new BigDecimal(20)),
		_TP_IC_JUKI(new BigDecimal(21)),
		
		_TP_IC_LOGS_24G(new BigDecimal(22)),
		_TP_IC_LOGS_RX(new BigDecimal(23)),
		_TP_IC_LOGS_PK(new BigDecimal(24)),
		
		_TP_IC_FUJI(new BigDecimal(25)),
		
		_TP_IC_FORNOS(new BigDecimal(26)),
		
		_TP_IC_LOGS_ASKEY(new BigDecimal(27)),
		
		_TP_IC_LOGS_AOI_OMRON(new BigDecimal(28)),
		
		_TP_IC_LOGS_SPI(new BigDecimal(29)),
		
		_TP_IC_LOGS_AOI_VTRNS(new BigDecimal(30)),
		
		_TP_IC_LOGS_PRINTER_DEK(new BigDecimal(31)),
		
		_TP_IC_LOGS_FORNO_HELLER1809(new BigDecimal(32)),
		
		_TP_IC_LOGS_IM_WCZTE(new BigDecimal(33)),
		
		_TP_IC_LOGS_IM_FLEX_FQC(new BigDecimal(34)),
		
		_TP_IC_LOGS_SPI_SEMP(new BigDecimal(35)),
		
		_TP_IC_LOGS_IM_FLEX_FT(new BigDecimal(36)),

		_TP_IC_LOGS_24GADSL(new BigDecimal(37)),
		
		_TP_IC_LOGS_IM_FLEX_ASSIGN(new BigDecimal(38)),
		
		_TP_IC_LOGS_IM_FLEX_SSIDZTE(new BigDecimal(39)),
		
		_TP_IC_LOGS_IM_FLEX_REFMAC(new BigDecimal(40)),
		
		_TP_IC_LOGS_IM_FLEX_ICTS_ATE(new BigDecimal(41)),
		
		_TP_IC_AOI_KYZL(new BigDecimal(42)),
		
		_TP_IC_KIC (new BigDecimal(43)),
		
		_TP_IC_BTU (new BigDecimal(44)),
		
		_TP_IC_SPI_CYBER (new BigDecimal(45)),
		
		_TP_IC_AOI_CYBER (new BigDecimal(46)),
		
		_TP_IC_AOI_TRI7000(new BigDecimal(47)),
		
		_TP_IC_Virtual(new BigDecimal(48)),

		_TP_IC_AOI_VTRNSSQL(new BigDecimal(49)),
		
		_TP_IC_AOI_KYZA(new BigDecimal(50));
		
		

		private BigDecimal tp;
		
		private TpIc(BigDecimal valor) {
			this.tp = valor;
		}
		
		public BigDecimal getTpIc() {
			return this.tp;
		}
	}

	@Override
	protected MsIc atribuir(MsIc from, MsIc to, boolean isCopiarFK) {
		if (to == null)
			to = new MsIc();
		
		to.setIdIc(from.getIdIc());
		to.setCdIc(from.getCdIc());
		to.setDsIc(from.getDsIc());
		to.setDthrHeartbeat(from.getDthrHeartbeat());
		to.setDthrRevisao(from.getDthrRevisao());
		to.setDthrStativo(from.getDthrStativo());
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setTpIc(from.getTpIc());
		to.setUrlConexao(from.getUrlConexao());
		
		to.setIsAutenticacao(from.getIsAutenticacao());
		to.setLogin(from.getLogin());
		to.setSenha(from.getSenha());

		if (isCopiarFK){
			if (from.getMsUsr() != null)
				to.setMsUsr(from.getMsUsr().clone(false));
			if (from.getMsPerfilandon() != null)
				to.setMsPerfilandon(from.getMsPerfilandon().clone(false));
		}
		return to;
	}

}
