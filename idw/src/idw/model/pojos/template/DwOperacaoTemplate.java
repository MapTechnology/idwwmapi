package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.IPojoMAP;
import idw.model.pojos.DwFolhaoperacao;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwOperacaocomp;
import idw.model.pojos.DwOperacaomidia;
import idw.model.pojos.DwOperacaopredecessora;
import idw.model.pojos.DwOperacaorap;
import idw.model.pojos.DwTOperacao;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;


public abstract class DwOperacaoTemplate extends AbstractTemplate<DwOperacao> implements IPojoMAP{

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

	public static final String _FIELD_NAME_CD = "CdOperacao";

	@Override
	public Long getId() {		
		return getInstanceT().getIdOperacao();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdOperacao(id);
	}

	@Override
	public String getCd() {
		return ((DwOperacao)this).getCdOperacao();
	}

	@Override
	public String getFieldNameCd() {
		return DwOperacaoTemplate._FIELD_NAME_CD;
	}


	@Override
	protected DwOperacao atribuir(DwOperacao from, DwOperacao to, boolean isCopiarFK) {

		if (to == null) {
			to = new DwOperacao();
		}
		
		to.set(
				(from.getIdOperacao() == null ? 0L : from.getIdOperacao()),
				from.getCdOperacao(),
				from.getDsOperacao(),
				from.getSegCiclopadrao(),
				from.getGrupooperacoes(),
				from.getX(),
				from.getY(),
				(isCopiarFK ? CloneUtil.clone(from.getOmProdutoByIdProdutoacabado(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmProdutoByIdProdutosemiacabado(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmGt(),false) : null),				
				(isCopiarFK ? CloneUtil.clone(from.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmPt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getDwTOperacao(),false) : null),				
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false) : null),				
				from.getRevisao(),				
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDtStativo());		
		
		if (isCopiarFK == true) {
			
			if(from.getDwOperacaocomps() != null){
				try{
					Set<DwOperacaocomp> componentes = new HashSet<DwOperacaocomp>();
					for (DwOperacaocomp componente : from.getDwOperacaocomps()) {
						componentes.add((DwOperacaocomp) componente.clone());
					}
					to.setDwOperacaocomps(componentes);
				} catch(Exception e){
					to.setDwOperacaocomps(null);
				}
			}
			
			if(from.getDwOperacaoraps() != null){
				try{
					Set<DwOperacaorap> raps = new HashSet<DwOperacaorap>();
					for (DwOperacaorap rap : from.getDwOperacaoraps()) {
						raps.add((DwOperacaorap) rap.clone());
					}
					to.setDwOperacaoraps(raps);
				} catch(Exception e){
					to.setDwOperacaoraps(null);
				}
			}
			
			if(from.getDwOperacaomidias() != null){
				try{
					Set<DwOperacaomidia> midias = new HashSet<DwOperacaomidia>();
					for (DwOperacaomidia midia : from.getDwOperacaomidias()) {
						midias.add((DwOperacaomidia) midia.clone());
					}
					to.setDwOperacaomidias(midias);
				} catch(Exception e){
					to.setDwOperacaomidias(null);
				}
			}
			
			if(from.getDwOperacaopredecessorasForIdOperacaoanterior() != null){
				try{
					Set<DwOperacaopredecessora> operacoes = new HashSet<DwOperacaopredecessora>();
					for (DwOperacaopredecessora operacao : from.getDwOperacaopredecessorasForIdOperacaoanterior()) {
						operacoes.add((DwOperacaopredecessora) operacao.clone());
					}
					to.setDwOperacaopredecessorasForIdOperacaoanterior(operacoes);
				} catch(Exception e){
					to.setDwOperacaopredecessorasForIdOperacaoanterior(null);
				}
			}

			if(from.getDwOperacaopredecessorasForIdOperacao() != null){
				try{
					Set<DwOperacaopredecessora> operacoes = new HashSet<DwOperacaopredecessora>();
					for (DwOperacaopredecessora operacao : from.getDwOperacaopredecessorasForIdOperacao()) {
						operacoes.add((DwOperacaopredecessora) operacao.clone());
					}
					to.setDwOperacaopredecessorasForIdOperacao(operacoes);
				} catch(Exception e){
					to.setDwOperacaopredecessorasForIdOperacao(null);
				}
			}
			
			if(from.getDwFolhaoperacoes() != null){
				try{
					Set<DwFolhaoperacao> folhas = new HashSet<DwFolhaoperacao>();
					for (DwFolhaoperacao folha : from.getDwFolhaoperacoes()) {
						folhas.add((DwFolhaoperacao) folha.clone());
					}
					to.setDwFolhaoperacoes(folhas);
				} catch(Exception e){
					to.setDwFolhaoperacoes(null);
				}
			}
			
		}

		return to;
	}
	
	public void set(long idOperacao,
			String cdOperacao,
			String dsOperacao,
			BigDecimal cicloPadrao,
			Integer grupoOperacoes,
			BigDecimal x,
			BigDecimal y,
			OmProduto produtoAcabado,
			OmProduto produtoSemiAcabado,
			OmGt omGt,			
			OmTppt omTppt,
			OmPt omPt,
			DwTOperacao tipoOperacao,
			OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao,
			Long revisao,
			Date dtRevisao,
			Byte stAtivo,
			Date dtStativo) {

		DwOperacao dwOperacao = (DwOperacao) this;

		dwOperacao.setIdOperacao(idOperacao);
		dwOperacao.setCdOperacao(cdOperacao);
		dwOperacao.setDsOperacao(dsOperacao);
		dwOperacao.setSegCiclopadrao(cicloPadrao);
		dwOperacao.setGrupooperacoes(grupoOperacoes);
		dwOperacao.setX(x);
		dwOperacao.setY(y);
		dwOperacao.setOmProdutoByIdProdutoacabado(produtoAcabado);
		dwOperacao.setOmProdutoByIdProdutosemiacabado(produtoSemiAcabado);
		dwOperacao.setOmGt(omGt);
		dwOperacao.setOmTppt(omTppt);
		dwOperacao.setOmPt(omPt);
		dwOperacao.setDwTOperacao(tipoOperacao);
		dwOperacao.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwOperacao.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);		
		dwOperacao.setRevisao(revisao);		
		dwOperacao.setDtRevisao(dtRevisao);
		dwOperacao.setStAtivo(stAtivo);
		dwOperacao.setDtStativo(dtStativo);
	}
}
