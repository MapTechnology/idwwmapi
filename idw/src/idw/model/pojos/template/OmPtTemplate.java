package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmClp;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;
import idw.webservices.dto.ComboDTO;
import idw.webservices.dto.ListaComboDTO;
import injetws.webservices.dto.IwsUpDTO;

public abstract class OmPtTemplate extends AbstractTemplate<OmPt> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdPt";
	private static final int _MAX_LEN_CD_PT = 30;
	private static final int _MAX_LEN_DS_PT = 100;
	private static final int _MAX_LEN_DS_CURTA = 10;
	private static final int _MAX_LEN_DEPARA = 10;
	
	public abstract Byte getTpSessao();
	public abstract void setTpSessao(Byte tpSessao);
	
	/*
	 * 
			0 - todas as operacoes são manuais
			1 - todas as operacoes são automáticas
			2 - operacoes principais automaticas com auxiliares manuais
			3 - operacoes principais manuais com auxiliares automaticas
	 */
	public enum _TP_PRODUCAO {
		_TP_PRODUCAO_MANUAL( (byte) 0),
		_TP_PRODUCAO_AUTOMATICA((byte) 1),
		_TP_PRODUCAO_AUTOMATICA_MANUAL((byte) 2),
		_TP_PRODUCAO_MANUAL_AUTOMATICA((byte) 3);
		
		private byte tp_producao;
		
		private _TP_PRODUCAO(byte tp) {
			this.tp_producao = tp;
		}
		
		public byte getValue() {
			return this.tp_producao;
		}
	}

	
	public enum TpClasseABCCritica {
		CLASSE_A((byte)0) {
			@Override
			public String toString() {
				return "CLASSE_A";
			}
		},
		CLASSE_B((byte)1) {
			@Override
			public String toString() {
				return "CLASSE_B";
			}
		},
		CLASSE_C((byte)2) {
			@Override
			public String toString() {
				return "CLASSE_C";
			}
		};

		private final byte value;
		
		private TpClasseABCCritica(byte value){
			this.value = value;
		}
		
		public boolean equals(Byte id) {
			return (id != null && id.equals(value));
		}
		
		public byte getValue(){
			return this.value;
		}
	}
	
	public enum TipoSessao {
		TP_RECUPERA_OP_NUMERO((byte)0),
		TP_RECUPERA_OP_FERRAMENTA((byte)1),
		TP_RECUPERA_OP_PRODUTO((byte)2),
		TP_CRIA_OP_FOLHA((byte) 3),
		TP_CRIA_OP_PRODUTO((byte)4),
		TP_CRIA_OP_PRODUTO_ESTRUTURA((byte)5),
		TP_CRIA_OP_FERRAMENTA_QTCICLOS((byte)6),
		TP_CRIA_OP_FERRAMENTA_PRODUTO_QTCICLOS((byte)7);
		
		private byte tipoSessao;
		
		private TipoSessao(byte tipoSessao) {
			this.tipoSessao = tipoSessao;
		}
		
		public byte getValue() {
			return this.tipoSessao;
		}
	}

	@Override
	public Long getId() {		
		return getInstanceT().getIdPt();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdPt(id);
	}	
	
	@Override
	public String getCd() {
		return ((OmPt)this).getCdPt();
	}

	@Override
	public String getFieldNameCd() {
		return OmPtTemplate._FIELD_NAME_CD;
	}

	public void set(Long idPt, OmClp omClp, OmTppt omTppt, OmAlim omAlimByIdAlimpre, OmAlim omAlimByIdAlim,
			OmAlim omAlimByIdAlimcorrente, OmGt omGt, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao,
			OmCc omCc, String cdPt, Long revisao, Date dtRevisao, Date dtStativo, String urlConexao,
			String dsPt, String dsCurta, String depara, Byte tpImpprog, Byte stAtivo, Integer estagio,
			DwFolha dwFolha, Boolean isPlangt, Boolean isApongt, BigDecimal indOee, Boolean isParadalinha, 
			Byte tpSessao, String dsSessao, Boolean isConsolpendente, Boolean isPerdasinc, Byte tpClasseabc, String urlImpressoracb, 
			String urlImpressoradoc, Integer ordemnogt,
			Boolean isTrocaopgt, Byte tpColeta, Byte tpProducao, Integer modulo){

		OmPt omPt = (OmPt) this;
		omPt.setIdPt(idPt);
		omPt.setOmClp(omClp);
		omPt.setOmTppt(omTppt);
		omPt.setOmAlimByIdAlimpre(omAlimByIdAlimpre);
		omPt.setOmAlimByIdAlim(omAlimByIdAlim);
		omPt.setOmAlimByIdAlimcorrente(omAlimByIdAlimcorrente);
		omPt.setOmGt(omGt);
		omPt.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omPt.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omPt.setOmCc(omCc);
		omPt.setCdPt(cdPt);
		omPt.setRevisao(revisao);
		omPt.setDtRevisao(dtRevisao);
		omPt.setDtStativo(dtStativo);
		omPt.setUrlConexao(urlConexao);
		omPt.setDsPt(dsPt);
		omPt.setDsCurta(dsCurta);
		omPt.setDepara(depara);
		omPt.setTpImpprog(tpImpprog);
		omPt.setStAtivo(stAtivo);
		omPt.setEstagio(estagio);
		omPt.setModulo(modulo);
		omPt.setDwFolha(dwFolha);
		omPt.setIsPlangt(isPlangt);
		omPt.setIsApongt(isApongt);
		omPt.setIndOee(indOee);
		omPt.setIsParadalinha(isParadalinha);
		omPt.setTpSessao(tpSessao);
		omPt.setDsSessao(dsSessao);
		omPt.setTpClasseabc(tpClasseabc);
		omPt.setUrlImpressoracb(urlImpressoracb);
		omPt.setUrlImpressoradoc(urlImpressoradoc);
		omPt.setOrdemnogt(ordemnogt);
		omPt.setIsTrocaopgt(isTrocaopgt);
		omPt.setTpColeta(tpColeta);
		omPt.setTpProducao(tpProducao);
	}
	
	public void setForeignKeys(OmClp omClp, OmTppt omTppt, OmAlim omAlimByIdAlimpre, OmAlim omAlimByIdAlim, 
			OmAlim omAlimByIdAlimcorrente, OmGt omGt, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao,
			OmCc omCc, DwFolha dwFolha){
		
		OmPt omPt = (OmPt) this;
		
		omPt.setOmClp(omClp);
		omPt.setOmTppt(omTppt);
		omPt.setOmAlimByIdAlimpre(omAlimByIdAlimpre);
		omPt.setOmAlimByIdAlim(omAlimByIdAlim);
		omPt.setOmAlimByIdAlimcorrente(omAlimByIdAlimcorrente);
		omPt.setOmGt(omGt);
		omPt.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omPt.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omPt.setOmCc(omCc);
		omPt.setDwFolha(dwFolha);
		
	}
	
	public void limitarStrings(){
		OmPt omPt = (OmPt) this;
		omPt.setCdPt(StringUtils.left(omPt.getCdPt(), OmPtTemplate._MAX_LEN_CD_PT));
		omPt.setDsPt(StringUtils.left(omPt.getDsPt(), OmPtTemplate._MAX_LEN_DS_PT));
		omPt.setDsCurta(StringUtils.left(omPt.getDsCurta(), OmPtTemplate._MAX_LEN_DS_CURTA));
		omPt.setDepara(StringUtils.left(omPt.getDepara(), OmPtTemplate._MAX_LEN_DEPARA));
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmPt omPtOther = (OmPt) o;
			final OmPt omPt = (OmPt) this;
			equals = (new EqualsBuilderIdw())
						.append(omPt.getOmClp(), omPtOther.getOmClp())
						.append(omPt.getOmTppt(), omPtOther.getOmTppt())
						.append(omPt.getOmAlimByIdAlimpre(), omPtOther.getOmAlimByIdAlimpre())
						.append(omPt.getOmAlimByIdAlim(), omPtOther.getOmAlimByIdAlim())
						.append(omPt.getOmAlimByIdAlimcorrente(), omPtOther.getOmAlimByIdAlimcorrente())
						.append(omPt.getOmGt(), omPtOther.getOmGt())
						.append(omPt.getOmCc(), omPtOther.getOmCc())
						.append(omPt.getCdPt(), omPtOther.getCdPt())
						.append(omPt.getUrlConexao(), omPtOther.getUrlConexao())
						.append(omPt.getDsPt(), omPtOther.getDsPt())
						.append(omPt.getDsCurta(), omPtOther.getDsCurta())
						.append(omPt.getDepara(), omPtOther.getDepara())
						.append(omPt.getTpImpprog(), omPtOther.getTpImpprog())
						.append(omPt.getStAtivo(), omPtOther.getStAtivo())
						.append(omPt.getEstagio(), omPtOther.getEstagio())
						.append(omPt.getDwFolha(), omPtOther.getDwFolha())
						.append(omPt.getIsPlangt(), omPtOther.getIsPlangt())
						.append(omPt.getIsApongt(), omPtOther.getIsApongt())
						.append(omPt.getIsParadalinha(), omPtOther.getIsParadalinha())
						.append(omPt.getTpSessao(), omPtOther.getTpSessao())
						.append(omPt.getDsSessao(), omPtOther.getDsSessao())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){

		OmPt omPt = (OmPt) this;

		return (new HashCodeBuilderIdw())
						.append(omPt.getOmClp())
						.append(omPt.getOmTppt())
						.append(omPt.getOmAlimByIdAlimpre())
						.append(omPt.getOmAlimByIdAlim())
						.append(omPt.getOmAlimByIdAlimcorrente())
						.append(omPt.getOmGt())
						.append(omPt.getOmUsrByIdUsrstativo())
						.append(omPt.getOmUsrByIdUsrrevisao())
						.append(omPt.getOmCc())
						.append(omPt.getCdPt())
						.append(omPt.getUrlConexao())
						.append(omPt.getDsPt())
						.append(omPt.getDsCurta())
						.append(omPt.getDepara())
						.append(omPt.getTpImpprog())
						.append(omPt.getStAtivo())
						.append(omPt.getEstagio())
						.append(omPt.getIsPlangt())
						.append(omPt.getIsApongt())
						.append(omPt.getIsParadalinha())
						.append(omPt.getTpSessao())
						.append(omPt.getDsSessao())
						.toHashCode();
	}

	@Override
	protected OmPt atribuir(OmPt from, OmPt to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPt();
		}

		to.setIdPt(from.getIdPt());
		to.setCdPt(from.getCdPt());
		to.setDsPt(from.getDsPt());
		to.setDsCurta(from.getDsCurta());
		to.setUrlConexao(from.getUrlConexao());
		to.setTpImpprog(from.getTpImpprog());
		to.setTpClasseabc(from.getTpClasseabc());
		to.setDepara(from.getDepara());
		to.setEstagio(from.getEstagio());
		to.setModulo(from.getModulo());
		to.setIsPlangt(from.getIsPlangt());
		to.setIsApongt(from.getIsApongt() !=null? from.getIsApongt():false);
		to.setIsAponparadagt(from.getIsAponparadagt() !=null ? from.getIsAponparadagt() : false);
		to.setIsParadalinha(from.getIsParadalinha() !=null? from.getIsParadalinha() : false);
		to.setIsTrocaopgt(from.getIsTrocaopgt() != null ? from.getIsTrocaopgt() : false);

		to.setIsCipAtivado(from.getIsCipAtivado());
		to.setIsSemop(from.getIsSemop());
		to.setIsSolicitaqtde(from.getIsSolicitaqtde());
		to.setIsDevepassarns(from.getIsDevepassarns());
		to.setIsPerdasinc(from.getIsPerdasinc());
		to.setIsConsolpendente(from.getIsConsolpendente());
		to.setIsHabilitaCip(from.getIsHabilitaCip());
		to.setIsCiclocomrefugo(from.getIsCiclocomrefugo());
		to.setIsLogingt(from.getIsLogingt());
		to.setIsParadaFechaciclo(from.getIsParadaFechaciclo());
		to.setIsApontarposicaomecanica(from.getIsApontarposicaomecanica());
		to.setIsHabilitaVaritmo(from.getIsHabilitaVaritmo());
		to.setPercVaritmo(from.getPercVaritmo());
		to.setQtVaritmo(from.getQtVaritmo());
		to.setQtEventosnoclp(from.getQtEventosnoclp());

		to.setIsAlimcorexc(from.getIsAlimcorexc());
		to.setIndOee(from.getIndOee());
		to.setDtRevisao(from.getDtRevisao());		
		to.setDtStativo(from.getDtStativo());		
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setSegAutoTempoparadanociclo(from.getSegAutoTempoparadanociclo());
		
		to.setTpSessao(from.getTpSessao());
		to.setDsSessao(from.getDsSessao());
		
		to.setUrlImpressoracb(from.getUrlImpressoracb());
		to.setUrlImpressoradoc(from.getUrlImpressoradoc());
		
		to.setOrdemnogt(from.getOrdemnogt());
		
		to.setTpColeta(from.getTpColeta());
		to.setTpProducao(from.getTpProducao());
		

		if (isCopiarFK == true){
			if(from.getOmGt() != null){
				to.setOmGt(from.getOmGt().clone(false));
			}

			if(from.getOmCc() != null){
				to.setOmCc(from.getOmCc().clone(false));
			}

			if(from.getOmTppt() != null){
				to.setOmTppt(from.getOmTppt().clone(false));
			}

			if(from.getOmUsrByIdUsrrevisao() != null){
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}

			if(from.getOmUsrByIdUsrstativo() != null){
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			if (from.getPpCp() != null) {
				to.setPpCp(from.getPpCp().clone(false));
			}
			
			if (from.getOmPtPa() != null)
				to.setOmPtPa(from.getOmPtPa().clone(false));
			
			// Adiciona dados de DwConsolpts (s� deve ter 1 item)
			if(from.getDwConsolpts() != null){
				
				to.setDwConsolpts(new HashSet<DwConsolpt>());
				
				for(DwConsolpt dwConsolpt: from.getDwConsolpts()){
					to.getDwConsolpts().add(dwConsolpt.clone(false));
				}
				
			}
			
			// TODO implementar clone para o campo OmClp
			
			// TODO implementar clone para o campo OmAlimByIdAlimpre
			
			// TODO implementar clone para o campo OmAlimByIdAlim
			
			// TODO implementar clone para o campo OmAlimByIdAlimcorrente
			
			
		}


		return to;
	}
	
	public static ListaComboDTO getTiposClasseABC(){
		ListaComboDTO dtos = new ListaComboDTO();
		dtos.setDtos(new ArrayList<ComboDTO>());
		for(TpClasseABCCritica classes : TpClasseABCCritica.values()){
			ComboDTO dto = new ComboDTO();
			dto.setValor(classes.value);
			dto.setDescricao(classes.toString());
			dtos.getDtos().add(dto);
		}
		return dtos;
	}
	
	
	/* Metodo para retornar o tipo da sessao no padrao do Injet baseando-se no cadastro atual do PT
	 * 
	 * 				 * Tipos de sessao que procuram uma OP que ja existe

					1 - Pede Molde
					2 - Pede OP
					3 - Produto

								Abaixo tipos de sessao que foram desabilitados para o IDW pois sao especificas de integracoes
									6 - Produto (desabilitar)
									9 - Molde produto e qtde de cartoes (desabilitado)
									11 - OP (desabilitado)
									12 - OP, Molde e estrutura (desabilitad) Arthi
									13 - OP Molde Estrutura Producao Planejada (desabilitado) Fitesa


					Ops criadas no servidor
					
					Ferramenta e producao planejada
					Produto e producao planejada
					4 - Molde e estrutura qtde ciclo (falta)
					5 - Produto estrutura e producao planejada  (contemplada)
					7 - Produto producao planjeada (contemplado)
					8 - Molde produto e qtde ciclos (falta)
					
					
								Tipo de sesssao desabilitadas criados no servidor
								
								10 - OP producao planejada (desabilitado)

	 */
	public Integer obtemTipoSessaoInjet() {
		Integer retorno = 0;

		if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_NUMERO.getValue()))
			retorno = IwsUpDTO.TIPO_CP_OP;
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()))
			retorno = IwsUpDTO.TIPO_CP_MOLDE;
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_PRODUTO.getValue()))
			retorno = IwsUpDTO.TIPO_CP_PRODUTO;
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO_ESTRUTURA.getValue()))
			retorno = IwsUpDTO.TIPO_CP_PRODUTO_ESTRUTURA_COM_OPCRIACAONOMASTER;
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO.getValue()))
			retorno = IwsUpDTO.TIPO_CP_PRODUTO_OP_COM_OPCRIACAOMASTER;
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_QTCICLOS.getValue()))
			retorno = IwsUpDTO.TIPO_CP_MOLDE_ESTRUTURA_COM_OPCRIACAONOMASTER; // igual ao outro rever
		else if (getTpSessao().equals(OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_PRODUTO_QTCICLOS.getValue()))
			retorno = IwsUpDTO.TIPO_CP_MOLDE_PRODUTO_QTCICLOS;
		else
			retorno = IwsUpDTO.TIPO_CP_OP;
		
		return retorno;
	}

	public boolean isTipoSessaoCriaOP() {
		return  getTpSessao() == OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_PRODUTO_QTCICLOS.getValue() ||
				getTpSessao() == OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_QTCICLOS.getValue() ||
				getTpSessao() == OmPtTemplate.TipoSessao.TP_CRIA_OP_FOLHA.getValue() ||
				getTpSessao() == OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO.getValue() ||
				getTpSessao() == OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO_ESTRUTURA.getValue();
	}
}
