package idw.model.pojos.template;

import idw.model.pojos.OmInd;

public abstract class OmIndTemplate extends AbstractTemplate<OmInd>{
	
	public enum Tipo{
		EFICIENCIA_REALIZACAO(1, true),
		EFICIENCIA_CICLO(2, true),
		INDICE_REFUGO(3, true),
		INDICE_PARADA(4, true),
		OEE(5, true),
		PRODUTIVIDADE(6, true),
		RITMO(7, false),
		RITMO_PERC(8, true),
		QUALIDADE(9, true), 
		TEMPO_CICLO_PRODUTIVO(10, true), 
		TEMPO_PARADA_COM_PESO(11, true), 
		TEMPO_CICLO_IMPRODUTIVO(12, true), 
		TEMPO_PARADA_COM_PESO_VAR_RITMO(13, true), 
		TEMPO_PARADA_SEM_PESO_VAR_RITMO(14, true), 
		TEMPO_PRODUTIVO(15, true), 
		TEMPO_ATIVO(16, true), 
		TEMPO_REFUGADO(17, true), 
		PCS_REFUGADAS(18, true), 
		QT_CICLOS_PRODUTIVOS(19, true), 
		TEMPO_CICLO_MEDIO(20, true), 
		TEMPO_BOAS(21, true), TEMPO_PERDA_CAVIDADE_INATIVA(22, true), 
		TEMPO_TOTAL(23, true), OEE_CAPITAL(24, true), PCS_PRODUCAO_BRUTA(25, true),
		TEMPO_TRABALHADAS(26, true), DISPONIBILIDADE(27, true),
		TOTAL_MAQ_PAR_COM_PESO(28, true), 
		TOTAL_MAQ_PAR_SEM_PESO(29, true),
		TOTAL_MAQUINAS(30, true),
		STATUS_PARADA_COM_PESO(31, true),
		STATUS_PARADA_SEM_PESO(32, true),
		QT_CICLOS_PREVISTOS(33, false)
		;
		
		private final int id;
		private final boolean isMelhorAcimaMeta;
		
		private Tipo(final int id, boolean isMelhorAcimaMeta){
			this.id = id;
			this.isMelhorAcimaMeta = isMelhorAcimaMeta;
		}
		
		public long getId(){
			return id;
		}
		
		public boolean isMelhorAcimaMeta(){
			return isMelhorAcimaMeta;
		}
		
		public static Tipo  getTipo(long id){
			for(Tipo tipo: Tipo.values()){
				if(tipo.getId() == id){
					return tipo;
				}
			}
			return null;
		}
	}

	public boolean isMelhorAcimaMeta(){
		
		Tipo tipo = Tipo.getTipo(getInstanceT().getIdInd());
		
		if(tipo != null){
			return tipo.isMelhorAcimaMeta();
		}
		
		return false;
		
	}

	public void setMelhorAcimaMeta(boolean v){		
	}
	
	
	public boolean isEficienciaRealizacao(){
		return Tipo.EFICIENCIA_REALIZACAO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}

	public void setEficienciaRealizacao(boolean v){		
	}
	
	
	public boolean isEficienciaCiclo(){
		return Tipo.EFICIENCIA_CICLO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}

	public void setEficienciaCiclo(boolean v){		
	}
	
	public boolean isIndiceRefugo(){
		return Tipo.INDICE_REFUGO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}

	public void setIndiceRefugo(boolean v){		
	}
	
	public boolean isIndiceParada(){
		return Tipo.INDICE_PARADA.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	
	public void setIndiceParada(boolean v){		
	}
	
	public boolean isOee(){
		return Tipo.OEE.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	

	public void setOee(boolean v){		
	}
	
	public boolean isProdutividade(){
		return Tipo.PRODUTIVIDADE.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
		
	public void setProdutividade(boolean v){		
	}
	

	public boolean isDisponibilidade(){
		return Tipo.DISPONIBILIDADE.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
		
	public void setDisponibilidade(boolean v){		
	}
	

	public boolean isRitmo(){
		return Tipo.RITMO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	
	public void setRitmo(boolean v){		
	}
	
	public boolean isRitmoPerc(){
		return Tipo.RITMO_PERC.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	
	public void setRitmoPerc(boolean v){		
	}
	
	
	public boolean isQualidade(){
		return Tipo.QUALIDADE.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	public void setQualidade(boolean v){		
	}
		
	public boolean isTotalMaquinas(){
		return Tipo.TOTAL_MAQUINAS.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	public void setTotalMaquinas(boolean v)
	{		
	}
		
	public boolean isTotalMaquinasParadasComPeso(){
		return Tipo.TOTAL_MAQ_PAR_COM_PESO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	public void setTotalMaquinasParadasComPeso(boolean v)
	{		
	}
		
	public boolean isTotalMaquinasParadasSemPeso(){
		return Tipo.TOTAL_MAQ_PAR_SEM_PESO.equals(Tipo.getTipo(getInstanceT().getIdInd()));
	}	
	public void setTotalMaquinasParadasSemPeso(boolean v)
	{		
	}
	
	public void set(long idInd, String cdInd, String dsInd, String dsCurta) {
				
	    OmInd omInd = (OmInd) this;

		omInd.setIdInd(idInd);
		omInd.setCdInd(cdInd);
		omInd.setDsInd(dsInd);
		omInd.setDsCurta(dsCurta);

//		omIndgts = new HashSet<OmIndgt>(0);
//		Set<OmIndpt> omIndpts = new HashSet<OmIndpt>(0);
//		Set<OmIndtppt> omIndtppts = new HashSet<OmIndtppt>(0);
//		Set<OmCfgind> omCfginds = new HashSet<OmCfgind>(0);
	}

	@Override
	protected OmInd atribuir(OmInd itemGet, OmInd itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new OmInd();
		}

		itemSet.set(
				itemGet.getIdInd(),
				itemGet.getCdInd(),
				itemGet.getDsInd(),
				itemGet.getDsCurta());
//				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),


		return itemSet;

	}
	
}
