package ms.coleta.ic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.template.MsIcTemplate;
import ms.coleta.ic.alcatel.ICAlcatel;
import ms.coleta.ic.aoi.ICAoiOmron;
import ms.coleta.ic.aoi.ICAoiTri7500;
import ms.coleta.ic.aoiVTRNS.ICAoiVTRNS;
import ms.coleta.ic.aoiVTRNSSQL.ICAoiVTRNSSQL;
import ms.coleta.ic.aoikyza.ICAoiKYZA;
import ms.coleta.ic.aoikyzl.ICAoiKyZl;
import ms.coleta.ic.aoiqx500.ICAoiQX500;
import ms.coleta.ic.automata.ICAutomata;
import ms.coleta.ic.buffereventos.MSBufferEventos;
import ms.coleta.ic.cckModbus.CckModbus;
import ms.coleta.ic.flex.askey.ICFlexAskey;
import ms.coleta.ic.flex.assign.ICAssign;
import ms.coleta.ic.flex.ate.ICIctsAte;
import ms.coleta.ic.flex.finaltest.ICFinalTest;
import ms.coleta.ic.flex.fornobtu.ICBtu;
import ms.coleta.ic.flex.fornoheller.ICFlexForno;
import ms.coleta.ic.flex.fornoheller1809.ICForno1809;
import ms.coleta.ic.flex.fqc.ICFlexFqc;
import ms.coleta.ic.flex.ftp.ICFlexftp;
import ms.coleta.ic.flex.pk.ICFlexPk;
import ms.coleta.ic.flex.pt.ICFlexPt;
import ms.coleta.ic.flex.refmac.ICRefMac;
import ms.coleta.ic.flex.rx.ICFlexRx;
import ms.coleta.ic.flex.spicyber.ICSpiCyber;
import ms.coleta.ic.flex.ssid.ICFlexSSID;
import ms.coleta.ic.flex.ssidzte.ICSsidZte;
import ms.coleta.ic.flex.teste24g.ICFlex24g;
import ms.coleta.ic.flex.teste24gadsl.ICFlex24gadsl;
import ms.coleta.ic.flex.teste5g.ICFlex5g;
import ms.coleta.ic.flex.tx.ICFlexTx;
import ms.coleta.ic.flex.wc.ICWcZTE;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.ic.inova.MSInova;
import ms.coleta.ic.inovastandalone.InovaStandaloneDriver;
import ms.coleta.ic.jconcentrador.JConcentrador;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.kic.ICKic;
import ms.coleta.ic.micrologix.Micrologix;
import ms.coleta.ic.printerDEK.ICPrinter;
import ms.coleta.ic.sony.ICSony;
import ms.coleta.ic.spi.ICSpi;
import ms.coleta.ic.spiKY2.ICSpiKY2;
import ms.coleta.ic.sqlcck.MsqlCCK;
import ms.coleta.ic.virtual.MSVirtual;
import ms.model.dto.IcDTO;


public class ICFactory {

	private static ICFactory instancia = null;

	@SuppressWarnings("rawtypes")
	private Map<BigDecimal, Class> driversDisponiveis = new HashMap<BigDecimal, Class>();

	private ICFactory() {
		super();

		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_Inova_StandAlone.getTpIc(), InovaStandaloneDriver.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_INOVA.getTpIc(), MSInova.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_Virtual.getTpIc(), MSVirtual.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_MICROLOGIC1400.getTpIc(), Micrologix.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_SQLCCK.getTpIc(), MsqlCCK.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc(), MSBufferEventos.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_ALCATEL.getTpIc(), ICAlcatel.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_MIDIASONY.getTpIc(), ICSony.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AUTOMATA.getTpIc(), ICAutomata.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_CCK7200ME.getTpIc(), CckModbus.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_JCONCENTRADOR.getTpIc(), JConcentrador.class);

		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_INSERSORA.getTpIc(), MSBufferEventos.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_5G.getTpIc(), ICFlex5g.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_24G.getTpIc(), ICFlex24g.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_24GADSL.getTpIc(), ICFlex24gadsl.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_FTP.getTpIc(), ICFlexftp.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_PT.getTpIc(), ICFlexPt.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_RX.getTpIc(), ICFlexRx.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_PK.getTpIc(), ICFlexPk.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_TX.getTpIc(), ICFlexTx.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_SSID.getTpIc(), ICFlexSSID.class);

		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_JUKI.getTpIc(), ICJuki.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_FUJI.getTpIc(), ICFuji.class);
		
		//driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_FORNOS.getTpIc(), ICForno.class);
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_FORNOS.getTpIc(), ICFlexForno.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_ASKEY.getTpIc(), ICFlexAskey.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_AOI_OMRON.getTpIc(), ICAoiOmron.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_SPI.getTpIc(), ICSpi.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_AOI_VTRNS.getTpIc(), ICAoiVTRNS.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_PRINTER_DEK.getTpIc(), ICPrinter.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_FORNO_HELLER1809.getTpIc(), ICForno1809.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_WCZTE.getTpIc(), ICWcZTE.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_FQC.getTpIc(), ICFlexFqc.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_SPI_SEMP.getTpIc(), ICSpiKY2.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_FT.getTpIc(), ICFinalTest.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_ASSIGN.getTpIc(), ICAssign.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_SSIDZTE.getTpIc(), ICSsidZte.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_REFMAC.getTpIc(), ICRefMac.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_LOGS_IM_FLEX_ICTS_ATE.getTpIc(), ICIctsAte.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AOI_KYZL.getTpIc(), ICAoiKyZl.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_KIC.getTpIc(), ICKic.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_BTU.getTpIc(), ICBtu.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_SPI_CYBER.getTpIc(), ICSpiCyber.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AOI_CYBER.getTpIc(), ICAoiQX500.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AOI_TRI7000.getTpIc(), ICAoiTri7500.class); // falta criar essa classe em separado da omron
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AOI_VTRNSSQL.getTpIc(), ICAoiVTRNSSQL.class);
		
		driversDisponiveis.put(MsIcTemplate.TpIc._TP_IC_AOI_KYZA.getTpIc(), ICAoiKYZA.class);
		
	}

	public static ICFactory getInstancia() {
		if (instancia == null) {
			instancia = new ICFactory();
		}
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public IIC getMS(IcDTO ms) {
		try {
			return (IIC) driversDisponiveis.get(new BigDecimal(ms.getTp_ic())).getConstructor(IcDTO.class).newInstance(ms);
		} catch (Exception e) {
			throw new RuntimeException("Nao foi possivel criar o driver: " + ms.getTp_ic());
		}
	}
}
