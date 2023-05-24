package idw.webservices.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import idw.model.pojos.DwRap;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroDetalhePTInjetDTO {
	public static final Byte CONSOLIDACAO_MAQUINA_HORA = 0;
	public static final Byte CONSOLIDACAO_MAQUINA_TURNO = 1;
	public static final Byte CONSOLIDACAO_MAQUINA_MES = 2;
	public static final Byte CONSOLIDACAO_MAQUINA_ACUMULADO = 3;
	
	private Date dtReferencia;
	private long idDwConsolId;
	private Date dtReferenciaInicial;
	private Date dtReferenciaFinal;
	private DwTurno dwTurno;
	private DwRap dwRap;
	private OmPt omPt;
	private OmPt omptParaPesquisa; // usado apenas para obeter o codigo e descricao do pt para mostrar na ficha da maq qdo for por OP
	private PpCp ppCp;
	private OmGt omGt;
	private OmProduto omProduto;
	private DwTParada dwTParada;
	private DwTArea dwtarea;
	
	private IndicadoresMinMetaMaxDTO indicadoresMinMetaMaxDTO;
	
	private Date dthrIhora;
	private Date dthrFhora;
	
	private Byte tpId;
	private Integer anoInicial;
	private Integer mesInicial;
	private Integer anoFinal;
	private Integer mesFinal;
	private Long idCp; 

	private Byte tpClasseABCpt;
	private Byte tpClasseABCproduto;
	
    private Byte tipoPareto;
    private Long idtparada;
    private String cdtparada;
    private String dstparada;
    
    private Long idtrefugo;
    private String cdtrefugo;
    private String dstrefugo;
    
    private String cdCp;
    private Boolean isClonar = false; // Alessandre: 25-6-13 passarei true apenas no detalhe da hora
	
    private Integer filtroOp;
    
    private String cdGrupoFerramenta;
    private String dsGrupoFerramenta;
    
    private String cdProdutoPai;  // produto-pai de um conjunto
    private Long idProdutoPai;
    
    private Boolean isParadasComPeso;
    private Boolean isParadasSemPeso;
    
    private String nrDoc;
    
    
	public Integer getFiltroOp() {
		return filtroOp;
	}
	public void setFiltroOp(Integer filtroOp) {
		this.filtroOp = filtroOp;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	public DwTParada getDwTParada(){
		return this.dwTParada;
	}	
	public void setDwTParada(DwTParada dwTParada){
		this.dwTParada = dwTParada;
	}
	public IndicadoresMinMetaMaxDTO getIndicadoresMinMetaMaxDTO() {
		return indicadoresMinMetaMaxDTO;
	}
	public void setIndicadoresMinMetaMaxDTO(
			IndicadoresMinMetaMaxDTO indicadoresMinMetaMaxDTO) {
		this.indicadoresMinMetaMaxDTO = indicadoresMinMetaMaxDTO;
	}
	public Date getDtReferenciaInicial() {
		return dtReferenciaInicial;
	}
	public void setDtReferenciaInicial(Date dtReferenciaInicial) {
		this.dtReferenciaInicial = dtReferenciaInicial;
	}
	public Date getDtReferenciaFinal() {
		return dtReferenciaFinal;
	}
	public void setDtReferenciaFinal(Date dtReferenciaFinal) {
		this.dtReferenciaFinal = dtReferenciaFinal;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public long getIdDwConsolId() {
		return idDwConsolId;
	}
	public void setIdDwConsolId(long idDwConsolId) {
		this.idDwConsolId = idDwConsolId;
	}
	public Date getDthrIhora() {
		return dthrIhora;
	}
	public void setDthrIhora(Date dthrIhora) {
		this.dthrIhora = dthrIhora;
	}
	public Date getDthrFhora() {
		return dthrFhora;
	}
	public void setDthrFhora(Date dthrFhora) {
		this.dthrFhora = dthrFhora;
	}
	public Byte getTpId() {
		return tpId;
	}
	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}
	public Integer getAnoInicial() {
		return anoInicial;
	}
	public void setAnoInicial(Integer anoInicial) {
		this.anoInicial = anoInicial;
	}
	public Integer getMesInicial() {
		return mesInicial;
	}
	public void setMesInicial(Integer mesInicial) {
		this.mesInicial = mesInicial;
	}
	public Integer getAnoFinal() {
		return anoFinal;
	}
	public void setAnoFinal(Integer anoFinal) {
		this.anoFinal = anoFinal;
	}
	public Integer getMesFinal() {
		return mesFinal;
	}
	public void setMesFinal(Integer mesFinal) {
		this.mesFinal = mesFinal;
	}
	public Long getIdCp() {
		return idCp;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public Byte getTipoPareto() {
		return tipoPareto;
	}
	public void setTipoPareto(Byte tipoPareto) {
		this.tipoPareto = tipoPareto;
	}
	public Long getIdtparada() {
		return idtparada;
	}
	public void setIdtparada(Long idtparada) {
		this.idtparada = idtparada;
	}
	public String getDstparada() {
		return dstparada;
	}
	public void setDstparada(String dstparada) {
		this.dstparada = dstparada;
	}
	public String getCdtparada() {
		return cdtparada;
	}
	public void setCdtparada(String cdtparada) {
		this.cdtparada = cdtparada;
	}
	public Long getIdtrefugo() {
		return idtrefugo;
	}
	public void setIdtrefugo(Long idtrefugo) {
		this.idtrefugo = idtrefugo;
	}
	public String getCdtrefugo() {
		return cdtrefugo;
	}
	public void setCdtrefugo(String cdtrefugo) {
		this.cdtrefugo = cdtrefugo;
	}
	public String getDstrefugo() {
		return dstrefugo;
	}
	public void setDstrefugo(String dstrefugo) {
		this.dstrefugo = dstrefugo;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public Boolean getIsClonar() {
		return isClonar;
	}
	public void setIsClonar(Boolean isClonar) {
		this.isClonar = isClonar;
	}
	public String getCdGrupoFerramenta() {
		return cdGrupoFerramenta;
	}
	public void setCdGrupoFerramenta(String cdGrupoFerramenta) {
		this.cdGrupoFerramenta = cdGrupoFerramenta;
	}
	public String getCdProdutoPai() {
		return cdProdutoPai;
	}
	public void setCdProdutoPai(String cdProdutoPai) {
		this.cdProdutoPai = cdProdutoPai;
	}
	public Long getIdProdutoPai() {
		return idProdutoPai;
	}
	public void setIdProdutoPai(Long idProdutoPai) {
		this.idProdutoPai = idProdutoPai;
	}
	public DwTArea getDwtarea() {
		return dwtarea;
	}
	public void setDwtarea(DwTArea dwtarea) {
		this.dwtarea = dwtarea;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
		String retorno = "FiltroDetalhePTInjetDTO\n";
		
		retorno += "	idDwConsolId = "+ idDwConsolId + "\n";
		
		retorno += "	dtReferencia = ";
		if(dtReferencia != null){
			retorno += sdf.format(dtReferencia) + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dtReferenciaInicial = ";
		if(dtReferenciaInicial != null){
			retorno += sdf.format(dtReferenciaInicial) + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dtReferenciaFinal = ";
		if(dtReferenciaFinal != null){
			retorno += sdf.format(dtReferenciaFinal) + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwTurno = ";
		if(dwTurno != null){
			retorno += dwTurno.getCdTurno() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwRap = ";
		if(dwRap != null){
			retorno += dwRap.getCdRap() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omPt = ";
		if(omPt != null){
			retorno += omPt.getCdPt() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	ppCp = ";
		if(ppCp != null){
			retorno += ppCp.getCdCp() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omGt = ";
		if(omGt != null){
			retorno += omGt.getCdGt() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	omProduto = ";
		if(omProduto != null){
			retorno += omProduto.getCdProduto() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwTParada = ";
		if(dwTParada != null){
			retorno += dwTParada.getCdTparada() + "\n";
		} else {
			retorno += "null\n";
		}
		
		retorno += "	dwtarea = ";
		if(dwtarea != null){
			retorno += dwtarea.getCdArea() + "\n";
		} else {
			retorno += "null\n";
		}
		
		return retorno;
	}
	public Byte getTpClasseABCpt() {
		return tpClasseABCpt;
	}
	public void setTpClasseABCpt(Byte tpClasseABCpt) {
		this.tpClasseABCpt = tpClasseABCpt;
	}
	public Byte getTpClasseABCproduto() {
		return tpClasseABCproduto;
	}
	public void setTpClasseABCproduto(Byte tpClasseABCproduto) {
		this.tpClasseABCproduto = tpClasseABCproduto;
	}
	public String getDsGrupoFerramenta() {
		return dsGrupoFerramenta;
	}
	public void setDsGrupoFerramenta(String dsGrupoFerramenta) {
		this.dsGrupoFerramenta = dsGrupoFerramenta;
	}
	public Boolean getIsParadasComPeso() {
		return isParadasComPeso;
	}
	public void setIsParadasComPeso(Boolean isParadasComPeso) {
		this.isParadasComPeso = isParadasComPeso;
	}
	public Boolean getIsParadasSemPeso() {
		return isParadasSemPeso;
	}
	public void setIsParadasSemPeso(Boolean isParadasSemPeso) {
		this.isParadasSemPeso = isParadasSemPeso;
	}
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	public OmPt getOmptParaPesquisa() {
		return omptParaPesquisa;
	}
	public void setOmptParaPesquisa(OmPt omptParaPesquisa) {
		this.omptParaPesquisa = omptParaPesquisa;
	}

}
