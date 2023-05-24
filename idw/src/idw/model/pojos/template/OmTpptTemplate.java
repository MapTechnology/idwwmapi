package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class OmTpptTemplate extends AbstractTemplate<OmTppt> implements IPojoMAP{

	public static final String _FIELD_NAME_CD = "CdTppt";
	
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
	
	public enum Type {
		/**	 M�quinas c�clicas */
		CIC(1), 
		
		/** Posto de montagem */
		PMO(3), 
		
		/** Posto de teste funcional */
		PTF(4),
		
		/** Posto de teste reprocesso */
		PRE(5), 
		
		/** Posto de teste el�trico */
		PTE(6), 
		
		/** Posto de teste visual */
		PTD(7), 
		
		/** Posto de verifica��o */
		PVE(8), 
		
		/** M�quina SMD, insersoras */
		IAC(13), 
		
		/** Forno */
		CEP(14), 
		
		/** Geral */
		CDI(15),
		EMB(16),
		/* Seladoras */
		SEL(17);
		
		private final long id;
		
		private Type(long id){
			this.id = id;
		}
		
		public long getId(){
			return this.id;
		}
		
		/**
		 * Pega o OmTpptTemplate.Type, com base no id
		 * @param id
		 * @return
		 */
		public static Type get(long id) {
			for (Type type : Type.values()){
				if (type.equals(id)){
					return type;
				}
			}
			
			throw new IllegalArgumentException("N�o foi possivel identificar o tipo do posto. id=" + id);
		}			
		
		public boolean equals(long id){
			return this.id == id;
		}
		
		public boolean equals(OmTppt omTppt){
			if(omTppt == null){
				return false;
			}
			
			return equals(omTppt.getIdTppt());
		}
		
	}	

	@Override
	public Long getId() {		
		return getInstanceT().getIdTppt();				
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTppt(id == null ? 0L: id.longValue());
	}	
	
	@Override
	public String getCd() {
		return ((OmTppt)this).getCdTppt();
	}

	@Override
	public String getFieldNameCd() {
		return OmTpptTemplate._FIELD_NAME_CD;
	}

	/**
	 * Campos usados no equals: CdTppt, DsTppt, StAtivo
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmTppt omTpptOther = (OmTppt) o;
			final OmTppt omTppt = (OmTppt) this;
			equals = (new EqualsBuilderIdw())
						.append(omTppt.getCdTppt(), omTpptOther.getCdTppt())
						.append(omTppt.getDsTppt(), omTpptOther.getDsTppt())
						.append(omTppt.getOmAlgocor(), omTpptOther.getOmAlgocor())
						.append(omTppt.getStAtivo(), omTpptOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTppt, DsTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		OmTppt omTppt = (OmTppt) this;

		return (new HashCodeBuilderIdw())
				.append(omTppt.getCdTppt())
				.append(omTppt.getDsTppt())
				.append(omTppt.getOmAlgocor())
				.append(omTppt.getStAtivo())
				.toHashCode();
	}

	@Override
	protected OmTppt atribuir(OmTppt from, OmTppt to, boolean isCopiarFK) {
		if(to == null){
			to = new OmTppt();
		}

		to.setIdTppt(from.getIdTppt());
		to.setCdTppt(from.getCdTppt());
		to.setDsTppt(from.getDsTppt());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIsIhmtrocaop(from.getIsIhmtrocaop());
		to.setIsRequerTecnicoFimCip(from.getIsRequerTecnicoFimCip());
		to.setIsRequerTecnicoInicioCip(from.getIsRequerTecnicoInicioCip());
		
		to.setTpColeta(from.getTpColeta());
		to.setTpProducao(from.getTpProducao());

		if(from.getOmUsrByIdUsrrevisao() != null){
			if(isCopiarFK){
				from.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			} else {
				OmUsr omUsrRev = new OmUsr();
				try {
					omUsrRev.setCdUsr(from.getOmUsrByIdUsrrevisao().getCdUsr());
					omUsrRev.setDsNome(from.getOmUsrByIdUsrrevisao().getDsNome());
				} catch (Exception e) {

				}
				to.setOmUsrByIdUsrrevisao(omUsrRev);
			}
		}

		if(from.getOmUsrByIdUsrstativo() != null){
			to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone());
		}else{
			OmUsr omUsrSt = new OmUsr();
			try {
				omUsrSt.setCdUsr(from.getOmUsrByIdUsrstativo().getCdUsr());
				omUsrSt.setDsNome(from.getOmUsrByIdUsrstativo().getDsNome());
			} catch (Exception e) {

			}
			to.setOmUsrByIdUsrstativo(omUsrSt);
		}

		if (from.getRevisao() != null) {
			to.setRevisao(from.getRevisao().longValue());
		}

		if (from.getStAtivo() != null) {
			to.setStAtivo(from.getStAtivo().byteValue());
		}

		return to;
	}

	// As maquinas ciclicas tem um tratamento diferenciado. Em geral sao aquelas gerenciadas pelo INOVA
	public boolean isMaquinaCiclica() {
		return getId().equals(OmTpptTemplate.Type.CIC.getId()) ||
				getId().equals(OmTpptTemplate.Type.SEL.getId());
	}

	// usado no lancamento da passagem. se for embalagem sempre lancara o ciclo
	public boolean isPostoEmbalgem() {
		return getId().equals(OmTpptTemplate.Type.EMB.getId());
	}
	
	public boolean isPostoMontagem() {
		return getId().equals(OmTpptTemplate.Type.PMO.getId());
	}
	public boolean isPostoTesteComDefeito() {
		return getId().equals(OmTpptTemplate.Type.PTD.getId());
	}
}
