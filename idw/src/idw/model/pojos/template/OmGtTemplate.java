package idw.model.pojos.template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.IPojoMAP;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;


public abstract class OmGtTemplate extends AbstractTemplate<OmGt> implements IPojoMAP{

	public final static String _FIELD_NAME_CD = "CdGt";

	@Override
	public Long getId() {		
		return getInstanceT().getIdGt();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdGt(id);
	}	
	
	@Override
	public String getCd() {
		return ((OmGt) this).getCdGt();
	}

	@Override
	public String getFieldNameCd() {
		return OmGtTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmGt omGtOther = (OmGt) o;
			final OmGt omGt = (OmGt) this;
			equals = (new EqualsBuilderIdw())
						.append(omGt.getCdGt(), omGtOther.getCdGt())
						.append(omGt.getAltura(), omGtOther.getAltura())
						.append(omGt.getDepara(), omGtOther.getDepara())
						.append(omGt.getDsCurta(), omGtOther.getDsCurta())
						.append(omGt.getDsGt() , omGtOther.getDsGt())
						.append(omGt.getGridx(), omGtOther.getGridx())
						.append(omGt.getGridy(), omGtOther.getGridy())
						.append(omGt.getIndOee() , omGtOther.getIndOee())
						.append(omGt.getLargura(), omGtOther.getLargura())
						.append(omGt.getOmCc(), omGtOther.getOmCc())
						.append(omGt.getOmImg(), omGtOther.getOmImg())
						.append(omGt.getOmTpgt(), omGtOther.getOmTpgt())
						.append(omGt.getSegX(), omGtOther.getSegX())
						.append(omGt.getSegY(), omGtOther.getSegY())
						.append(omGt.getSegZ(), omGtOther.getSegZ())
						.append(omGt.getTensaoMax(), omGtOther.getTensaoMax())
						.append(omGt.getTensaoMin(), omGtOther.getTensaoMin())
						.append(omGt.getTensaoNom(), omGtOther.getTensaoNom())
						.append(omGt.getCor(), omGtOther.getCor())
						.append(omGt.getStAtivo(), omGtOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){

		OmGt omGt = (OmGt) this;

		return (new HashCodeBuilderIdw())
						.append(omGt.getCdGt())
						.append(omGt.getAltura())
						.append(omGt.getDepara())
						.append(omGt.getDsCurta())
						.append(omGt.getDsGt())
						.append(omGt.getGridx())
						.append(omGt.getGridy())
						.append(omGt.getIndOee())
						.append(omGt.getLargura())
						.append(omGt.getOmCc())
						.append(omGt.getOmImg())
						.append(omGt.getOmTpgt())
						.append(omGt.getSegX())
						.append(omGt.getSegY())
						.append(omGt.getSegZ())
						.append(omGt.getTensaoMax())
						.append(omGt.getTensaoMin())
						.append(omGt.getTensaoNom())
						.append(omGt.getCor())
						.append(omGt.getStAtivo())
						.toHashCode();
	}

	@Override
	protected OmGt atribuir(OmGt from, OmGt to, boolean isCopiarFK) {
		if(to == null){
			to = new OmGt();
		}

		to.setIdGt(from.getIdGt());
		to.setCdGt(from.getCdGt());
		to.setDsGt(from.getDsGt());
		to.setDsCurta(from.getDsCurta());
		to.setCb(from.getCb());
		to.setDepara(from.getDepara());
		to.setIndOee(from.getIndOee());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setSegX(from.getSegX());
		to.setSegY(from.getSegY());
		to.setSegZ(from.getSegZ());
		to.setTensaoMin(from.getTensaoMin());
		to.setTensaoNom(from.getTensaoNom());
		to.setTensaoMax(from.getTensaoMax());
		to.setGridx(from.getGridx());
		to.setRevisao(from.getRevisao());
		to.setCor(from.getCor());
		to.setStAtivo(from.getStAtivo());
		to.setTpAlgoabc(from.getTpAlgoabc());

/*
 * Comentado por Hugo:
 * Comentei este codigo porque dava o problema de ciclicidade no banco ao consultar CPs
 * no Planejamento de Producao (Manipulacao das CPs)
 * A ciclicidade se da porque as CPs sao recuperadas e delas recupera-se os PTs e GTs
 */
//		Set<PpCp> lista = null;
//		if(from.getPpCps() != null) {
//		lista = new HashSet<PpCp>();
//			for(PpCp cp : from.getPpCps()) {
//				lista.add(cp.clone(false));
//			}
//		}
//		to.setPpCps(lista);

		if(isCopiarFK){
			if (from.getOmGtfase() != null) {
				to.setOmGtfase(from.getOmGtfase().clone(false));
			}
			if(from.getOmTpgt() != null){
				to.setOmTpgt(from.getOmTpgt().clone(false));
			}

			if(from.getOmCc() != null){
				to.setOmCc(from.getOmCc().clone(false));
			}

			if(from.getOmImg() != null){
				to.setOmImg(from.getOmImg().clone(false));
			}

			if(from.getOmUsrByIdUsrrevisao() != null){
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}

			if(from.getOmUsrByIdUsrstativo() != null){
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}


			if(from.getOmObjsForIdGt() != null){
				to.setOmObjsForIdGt(new HashSet<OmObj>());
				for(OmObj obj: from.getOmObjsForIdGt()){
					to.getOmObjsForIdGt().add(obj.clone(false));
				}
			}
		}

		return to;
	}

	/**
	 * Procura objetos de um GT, mesmo se o Gt for um filho do GT atual
	 * @param gtFilho Grupo de trabalho procurado
	 * @return objetos do <code>gtFilho</code>
	 * @see MonitorizacaoRN#getArvoreObjsGt(OmGt, OmGt)
	 */

	public Set<OmObj> getObjs(OmGt gtFilho){

		OmGt gt = (OmGt) this;
		Set<OmObj> retorno = null;

		// Alessandre: comentei o if abaixo em 4-2-14 nao vi necessidade dele e ele impactou no calculo do tempocalendario pois
		// estava sem retornando 0
		// se gtFilho for igual ao gt, retorna omObjsForIdGt de gt
		//if(gt.getIdGt().equals(gtFilho.getIdGt())){
		//	return gt.getOmObjsForIdGt();
		//}

		if((gt.getOmObjsForIdGt() != null) && (gt.getOmObjsForIdGt().size() > 0)) {

			for(OmObj obj: gt.getOmObjsForIdGt()){
				if(obj.getOmGtByIdGtfilho() != null) {

					// Se gt for encontrado, retorna seus objetos
					if(obj.getOmGtByIdGtfilho().getIdGt().equals(gtFilho.getIdGt())){
						retorno = obj.getOmGtByIdGtfilho().getOmObjsForIdGt();

					// se n�o for o objeto filho, procura nos outros sub itens
					} else {
						retorno = obj.getOmGtByIdGtfilho().getObjs(gtFilho);
						if(retorno != null){
							break;
						}
					}
				}
			}
		}

		return retorno;
	}


	/**
	 * Procura <code>gtFilho</code>
	 * @param gtFilho
	 * @return lista da decendencia at� chegar no <code>gtFilho</code>
	 */
	public List<OmGt> procuraGtFilho(OmGt gtFilho){
		OmGt gt = (OmGt) this;
		List<OmGt> retorno = null;
		if((gtFilho != null) && (gt.getOmObjsForIdGt() != null)){

			 for(OmObj obj: gt.getOmObjsForIdGt()){
				 if((obj.getOmGtByIdGtfilho() != null)
						 && (obj.getOmGtByIdGtfilho().getIdGt().equals(gtFilho.getIdGt()))){

					 retorno = new ArrayList<OmGt>();
					 retorno.add(gt);

				 } else {
					 retorno = obj.getOmGtByIdGt().procuraGtFilho(gtFilho);
					 if(retorno != null){
						 retorno.add(gt);
					 }
				 }

			 }

		}
		return retorno;

	}

	/**
	 * Gera texto mostrando o caminho at� chegar ao <code>gtFilho</code> procurado
	 * @param gtFilho
	 * @return
	 */
	public String descendenciaFilho(OmGt gtFilho){
		String retorno = "";

		List<OmGt> descendentes = this.procuraGtFilho(gtFilho);
		if( descendentes != null) {
			for(OmGt gtItem: descendentes){
				if(retorno.equals("")){
					retorno = "[CdGt: " + gtItem.getCdGt() + "]" ;
				} else {
					retorno = "[CdGt: " + gtItem.getCdGt() + "] -> " + retorno;
				}
			}
		}

		return retorno;
	}

}
