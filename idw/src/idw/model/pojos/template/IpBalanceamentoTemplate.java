package idw.model.pojos.template;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IPojoMAP;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.IpBalanceamento;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.webservices.dto.ListaTipoAlgoritmoBalanceamentoDTO;
import idw.webservices.dto.TipoAlgoritmoBalanceamentoDTO;

public abstract class IpBalanceamentoTemplate extends AbstractTemplate<IpBalanceamento> implements IPojoMAP{
	
	public static final String _FIELD_NAME_CD = "cdBalanceamento";
	
	public enum StatusBalanceamento {
		CADASTRADO((byte)0) {
			@Override
			public String toString() {
				return "CADASTRADO";
			}
		},
		FIRMADO((byte)1) {
			@Override
			public String toString() {
				return "FIRMADO";
			}
		};

		private final byte value;
		
		private StatusBalanceamento(byte value){
			this.value = value;
		}
		
		public byte getValue(){
			return this.value;
		}
	}
	
	public enum TipoAlgoritmo {
		PESO_POSICIONAL((byte)1) {
			@Override
			public String toString() {
				return "PESO_POSICIONAL";
			}
		};

		private final byte value;
		
		private TipoAlgoritmo(byte value){
			this.value = value;
		}
		
		public byte getValue(){
			return this.value;
		}
	}

	@Override
	public Long getId() {
		return getInstanceT().getIdBalanceamento();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdBalanceamento(id);
	}

	@Override
	public String getCd() {
		return ((IpBalanceamento)this).getCdBalanceamento();
	}

	@Override
	public String getFieldNameCd() {
		return IpBalanceamentoTemplate._FIELD_NAME_CD;
	}

	@Override
	protected IpBalanceamento atribuir(IpBalanceamento from,
			IpBalanceamento to, boolean isCopiarFK) {
		
		if (to == null) {
			to = new IpBalanceamento();
		}
		
		to.set(
				(from.getIdBalanceamento() == null ? 0L : from.getIdBalanceamento()),
				from.getCdBalanceamento(),
				from.getDsBalanceamento(),
				(isCopiarFK ? CloneUtil.clone(from.getOmProdutoByIdProdutoacabado(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmProdutoByIdProdutosemiacabado(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmGt(),false) : null),	
				from.getStBalanceamento(),
				from.getPcsProducaoplanejadadiaria(),
				from.getSegTempodisponiveldiario(),
				from.getSegTakttime(),
				from.getIndFadiga(),
				from.getTpAlgoritmo(),			
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false) : null),				
				from.getRevisao(),				
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDtStativo());
		
		return to;
	}
	
	public void set(long idBalanceamento,
			String cdBalanceamento,
			String dsBalanceamento,
			OmProduto produtoAcabado,
			OmProduto produtoSemiAcabado,
			OmGt omGt,
			Byte stBalanceamento,
			BigDecimal pcsProducaoplanejadadiaria,
			BigDecimal segTempodisponiveldiario,
			BigDecimal segTakttime,
			BigDecimal indFadiga,
			Byte tpAlgoritmo,			
			OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao,
			Long revisao,
			Date dtRevisao,
			Byte stAtivo,
			Date dtStativo) {

		IpBalanceamento ipBalanceamento = (IpBalanceamento) this;
		
		ipBalanceamento.setIdBalanceamento(idBalanceamento);
		ipBalanceamento.setCdBalanceamento(cdBalanceamento);
		ipBalanceamento.setDsBalanceamento(dsBalanceamento);
		ipBalanceamento.setOmProdutoByIdProdutoacabado(produtoAcabado);
		ipBalanceamento.setOmProdutoByIdProdutosemiacabado(produtoSemiAcabado);
		ipBalanceamento.setOmGt(omGt);
		ipBalanceamento.setStBalanceamento(stBalanceamento);
		ipBalanceamento.setPcsProducaoplanejadadiaria(pcsProducaoplanejadadiaria);
		ipBalanceamento.setSegTempodisponiveldiario(segTempodisponiveldiario);
		ipBalanceamento.setSegTakttime(segTakttime);
		ipBalanceamento.setIndFadiga(indFadiga);
		ipBalanceamento.setTpAlgoritmo(tpAlgoritmo);
		ipBalanceamento.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		ipBalanceamento.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		ipBalanceamento.setRevisao(revisao);
		ipBalanceamento.setDtRevisao(dtRevisao);
		ipBalanceamento.setStAtivo(stAtivo);
		ipBalanceamento.setDtStativo(dtStativo);
	}
	
	/**
	 * 
	 * @param tempoEmSegundos tempo que trabalha uma pessoa por dia em segundos
	 * @param producao capacidade de producao diaria em pecas
	 * @param indiceFadiga indice de fadiga
	 * @return tempo / (producao - ((producao * fadiga)/ 100) )
	 */
	public BigDecimal calcularTaktTime(BigDecimal tempoEmSegundos, BigDecimal producao, BigDecimal indiceFadiga){
	    BigDecimal dividendo = tempoEmSegundos;
	    BigDecimal fadigaEmPecas = producao.multiply(indiceFadiga).divide(new BigDecimal(100));
        BigDecimal divisor = producao.subtract(fadigaEmPecas);
        if(divisor == BigDecimal.ZERO){
            return dividendo;
        }
        return dividendo.divide(divisor, 0, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getTempoTotalMontagem(List<DwOperacao> operacoes){
		BigDecimal soma = BigDecimal.ZERO;
		
		if(operacoes == null){
			return soma;
		}
		
		for(DwOperacao operacao : operacoes){
			soma = soma.add(operacao.getSegCiclopadrao());
		}
		return soma;
	}
	
	public long getQuantidadeTotalOperacoes(List<DwOperacao> operacoes){
		if(operacoes == null){
			return 0L;
		}
		return operacoes.size();
	}
	
	/**
	 * 
	 * @param tempo tempo total de montagem
	 * @param taktTime
	 * @return tempo / taktTime
	 */
	public BigDecimal getNumeroPostosTrabalho(BigDecimal tempo, BigDecimal taktTime){
		BigDecimal dividendo = tempo;
		BigDecimal divisor = taktTime;
		if(divisor == BigDecimal.ZERO){
			return dividendo;
		}
		return dividendo.divide(divisor, 0, RoundingMode.UP);
	}
	
	/**
	 * 
	 * @param postos numero de postos de trabalho
	 * @param taktTime
	 * @param tempo tempo total de montagem
	 * @return postos x taktTime / tempo
	 */
	public BigDecimal calcularEficiencia(BigDecimal postos, BigDecimal taktTime, BigDecimal tempo){
		BigDecimal dividendo = postos.multiply(taktTime);
		BigDecimal divisor = tempo;
		if(divisor == BigDecimal.ZERO){
			return dividendo;
		}		
		return dividendo.divide(tempo, 3, RoundingMode.HALF_UP);
	}
	
	public static ListaTipoAlgoritmoBalanceamentoDTO getTipoAlgoritmos(){
		ListaTipoAlgoritmoBalanceamentoDTO dtos = new ListaTipoAlgoritmoBalanceamentoDTO();
		dtos.setDtos(new ArrayList<TipoAlgoritmoBalanceamentoDTO>());
		for(TipoAlgoritmo algoritmo : TipoAlgoritmo.values()){
			TipoAlgoritmoBalanceamentoDTO dto = new TipoAlgoritmoBalanceamentoDTO();
			dto.setValor(algoritmo.value);
			dto.setDescricao(algoritmo.toString());
			dtos.getDtos().add(dto);
		}
		return dtos;
	}
	
	

}
