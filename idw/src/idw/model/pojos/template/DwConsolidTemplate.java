package idw.model.pojos.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.DataHoraRN;


public abstract class DwConsolidTemplate extends AbstractTemplate<DwConsolid> implements Comparable<DwConsolid> {

	public enum TpId{
		/** Periodo de consolidacao por hora (0)*/
		HORA((byte)0),
		/** Periodo de consolidacao por turno (1)*/
		TURNO((byte)1),
		/** Periodo de consolidacao por mes (2)*/
		MES((byte)2),
		/** Periodo de consolidacao por acumulado (maquina e CP) (3)*/
		ACUMULADO((byte)3),
		OP ((byte) 4);

		private Byte value;
		private TpId(Byte value){
			this.value = value;
		}

		public Byte getValue(){
			return this.value;
		}

		public boolean equals(Byte value){
			return this.getValue().equals(value);
		}

		public boolean equals(int value){
			return this.getValue().equals((byte)value);
		}

		public boolean equals(DwConsolid dwConsolid) {
			return (dwConsolid != null && equals(dwConsolid.getTpId()));
		}

	}

	/**
	 * Data hora de fim da última consolida��oo, itens que impactam no tempo ativo (apenas para ciclo e parada)
	 * <p> Criado como abstract apenas para documentar sua utilizado.
	 * No idw classe de pojo n�o pode ter documentações ou funcioalidades, diferentes das do mapeamento.
	 * @param dthrFconsol
	 */
	public abstract void setDthrFconsol(Date dthrFconsol);
	public abstract DwFolha getDwFolha();
	public abstract void setDwFolha(DwFolha dwFolha);
	public abstract Set<DwConsol> getDwConsols();
	public abstract void setDwConsols(Set<DwConsol> dwConsols);


	/**
	 * Data hora de início da primeira consolida��oo, itens que impactam no tempo ativo (apenas para ciclo e parada)
	 * <p> Criado como abstract apenas para documentar sua utilizado.
	 * No idw classe de pojo n�o pode ter documentações ou funcioalidades, diferentes das do mapeamento.
	 * @param dthrIconsol
	 */
	public abstract void setDthrIconsol(Date dthrIconsol);

	//Marcos Sardinha: 2017-07-26 >> Defeito #4250 (necessita dos gets abaixo para pegar dthr da ultima cosolidadcoa
	public abstract Date getDthrIconsol();
	public abstract Date getDthrFconsol();


	public void set(Long idConsolid, Long idCal, Long idPepro, Long idFolha, Long idCp, Long idPt, Long idGt, Long idTurno,
			Long idRt, DwConsolidTemplate.TpId tpId, Date dtReferencia, Integer ano, Integer mes, Date dthrIhora, Date dthrFhora,
			Date dthrIturno, Date dthrFturno, Date dthrCadastro, String dsEspecializaapon, Byte stAtivo, Byte isAlertasenviados,
			Date dthrIconsol, Date dthrFconsol){

		DwConsolid dwConsolid = (DwConsolid) this;

		DwCal dwCal = new DwCal();
		dwCal.setIdCal(idCal);

		DwPepro dwPepro = new DwPepro(idPepro);
		DwFolha dwFolha = new DwFolha();
		dwFolha.setIdFolha(idFolha);
		PpCp ppCp = new PpCp();
		ppCp.setIdCp(idCp);
		OmGt omGt = new OmGt();
		omGt.setIdGt(idGt);
		OmPt omPt = new OmPt();
		omPt.setIdPt(idPt);
		DwTurno dwTurno = new DwTurno();
		dwTurno.setIdTurno(idTurno);
		DwRt dwRt = new DwRt();
		dwRt.setIdRt(idRt);

		dwConsolid.set(idConsolid, dwCal, dwPepro, dwFolha, ppCp, omPt, omGt, dwTurno, dwRt,
				tpId.getValue(), dtReferencia, ano, mes, dthrIhora, dthrFhora, dthrIturno, dthrFturno, dthrCadastro,
				dsEspecializaapon, stAtivo, isAlertasenviados, dthrIconsol, dthrFconsol);


	}

	public void set(Long idConsolid, DwCal dwCal, DwPepro dwPepro, DwFolha dwFolha, PpCp ppCp, OmPt omPt, OmGt omGt, DwTurno dwTurno,
			DwRt dwRt, Byte tpId, Date dtReferencia, Integer ano, Integer mes, Date dthrIhora, Date dthrFhora,
			Date dthrIturno, Date dthrFturno, Date dthrCadastro, String dsEspecializaapon, Byte stAtivo, Byte isAlertasenviados,
			Date dthrIconsol, Date dthrFconsol){

		DwConsolid dwConsolid = (DwConsolid) this;
		dwConsolid.setIdConsolid(idConsolid);

		dwConsolid.setDwCal(dwCal);
		dwConsolid.setDwPepro(dwPepro);
		dwConsolid.setDwFolha(dwFolha);
		dwConsolid.setPpCp(ppCp);
		dwConsolid.setOmPt(omPt);
		dwConsolid.setOmGt(omGt);
		dwConsolid.setDwTurno(dwTurno);
		dwConsolid.setDwRt(dwRt);
		dwConsolid.setTpId(tpId);
		dwConsolid.setDtReferencia(dtReferencia);
		dwConsolid.setAno(ano);
		dwConsolid.setMes(mes);
		dwConsolid.setDthrIhora(dthrIhora);
		dwConsolid.setDthrFhora(dthrFhora);
		dwConsolid.setDthrIturno(dthrIturno);
		dwConsolid.setDthrFturno(dthrFturno);
		dwConsolid.setDthrIconsol(dthrIconsol);
		dwConsolid.setDthrFconsol(dthrFconsol);
		dwConsolid.setDthrCadastro(dthrCadastro);
		dwConsolid.setDsEspecializaapon(dsEspecializaapon);
		dwConsolid.setStAtivo(stAtivo);
		dwConsolid.setIsAlertasenviados(isAlertasenviados);

	}

	/**
	 * Compara��oo para {@code DwConsolid}
	 * <br> Usa {@code DtHrIconsol} para compara��oo, se estiverem preenchidos. Caso contrário, usa o {@code IdConsolid}
	 * @param o N�o pode ser nulo
	 */
	@Override
	public int compareTo(DwConsolid o2) {
		Validate.notNull(o2);
		DwConsolid o1 = getInstanceT();
		return new CompareToBuilder()
			.append(o1.getDthrIconsol(), o2.getDthrIconsol())
			.append(o1.getIdConsolid(), o2.getIdConsolid())
			.toComparison();
	}

	/**
	 * Atualiza data de início e fim de consolida��oo do período
	 * <br> Datas passadas devem corresponder apenas a eventos de início e fim de eventos de ciclos e paradas
	 * <br> Só atualiza início, se o que for passado for menor que o existente
	 * <br> Só atualiza fim, se o que for passado for maior que o existente
	 * @param dtHrInicio
	 * @param dtHrFim
	 */
	public void setDtHr(Date dtHrInicio, Date dtHrFim){

		// Atualiza início
		getInstanceT().setDthrIconsol(DataHoraRN.getMenorData(getInstanceT().getDthrIconsol(), dtHrInicio));

		// Atualiza fim
		getInstanceT().setDthrFconsol(DataHoraRN.getMaiorData(getInstanceT().getDthrFconsol(), dtHrFim));

	}

	@Override
	public String toString(){
		return new ToStringBuilder(this)
				.append("IdConsolid", getInstanceT().getIdConsolid())
				.append("idPt", getInstanceT().getOmPt().getIdPt())
				.append("idGt", (getInstanceT().getOmGt() == null? null: getInstanceT().getOmGt().getIdGt()))
				.append("idFolha", getInstanceT().getDwFolha().getIdFolha())
				.append("idCal", (getInstanceT().getDwCal() == null ? null : getInstanceT().getDwCal().getIdCal()))
				.append("tpId", getInstanceT().getTpId())
				.append("dtHrIconsol", getInstanceT().getDthrIconsol())
				.append("dtHrFconsol", getInstanceT().getDthrFconsol())
				.append("dtHrCadastro", getInstanceT().getDthrCadastro())
				.append("mes", getInstanceT().getMes())
				.append("ano", getInstanceT().getAno())
				.append("dtReferencia", getInstanceT().getDtReferencia())
				.append("dtHrIturno", getInstanceT().getDthrIturno())
				.append("dtHrFturno", getInstanceT().getDthrFturno())
				.append("dtHrIhora", getInstanceT().getDthrIhora())
				.append("dtHrFhora", getInstanceT().getDthrFhora())
				.append("idTurno", (getInstanceT().getDwTurno() == null ? null: getInstanceT().getDwTurno().getIdTurno()))
				.toString();
	}

	@Override
	protected DwConsolid atribuir(DwConsolid itemGet, DwConsolid itemSet, boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwConsolid();
		}
		itemSet.setIdConsolid(itemGet.getIdConsolid());
		itemSet.setAno(itemGet.getAno());
		itemSet.setMes(itemGet.getMes());
		itemSet.setDthrCadastro(itemGet.getDthrCadastro());
		itemSet.setStAtivo(itemGet.getStAtivo());
		itemSet.setDthrFhora(itemGet.getDthrFhora());
		itemSet.setDthrFturno(itemGet.getDthrFturno());
		itemSet.setDthrIhora(itemGet.getDthrIhora());
		itemSet.setDthrIturno(itemGet.getDthrIturno());
		itemSet.setDthrIconsol(itemGet.getDthrIconsol());
		itemSet.setDthrFconsol(itemGet.getDthrFconsol());
		itemSet.setDtReferencia(itemGet.getDtReferencia());
		itemSet.setTpId(itemGet.getTpId());
		itemSet.setDsEspecializaapon(itemGet.getDsEspecializaapon());

		itemSet.setDwConsols(new HashSet<DwConsol>());

		for (DwConsol consol : itemGet.getDwConsols()){
			itemSet.getDwConsols().add(consol.clone(false));
		}

		if (isCopiarFK == true){
			itemSet.setOmPt(itemGet.getOmPt().clone(false));
			itemSet.setPpCp((itemGet.getPpCp() == null? null: (PpCp) itemGet.getPpCp().clone(false)));
			if(itemGet.getDwRt() != null){
				itemSet.setDwRt(itemGet.getDwRt().clone(isCopiarFK));
			}
			itemSet.setDwCal(itemGet.getDwCal().clone());
			itemSet.setDwFolha(itemGet.getDwFolha().clone(false));
			itemSet.setDwPepro((DwPepro)itemGet.getDwPepro().clone());
			itemSet.setDwTurno(itemGet.getDwTurno().clone(false));
			if(itemGet.getOmGt()!=null){
				itemSet.setOmGt(itemGet.getOmGt().clone(false));
			}
		} else {
			itemSet.setOmPt(itemGet.getOmPt().clone(false));
			DwCal calendario = new DwCal();
			calendario.setCdCal(itemGet.getDwCal().getCdCal());
			itemSet.setDwCal(calendario);
			itemSet.setPpCp((itemGet.getPpCp() == null? null: (PpCp) itemGet.getPpCp().clone(false)));
		}

		return itemSet;
	}




	/*
	 * Obtem a ferramenta associadas
	 */
	public DwRap getFerramenta() {
		DwRap retorno = null;
		if (getDwFolha() != null) {
			if (getDwFolha().getDwFolharaps() != null) {
				for (DwFolharap folharap : getDwFolha().getDwFolharaps()) {
					retorno = folharap.getDwRap();
				}
			}
		}
		return retorno;
	}

	/*
	 * Obtem o produto
	 *
	 */
	public List<OmProduto> getProdutos() {
		List<OmProduto> retorno = new ArrayList<>();
		if (getDwConsols() != null) {
			for (DwConsol consol : getDwConsols()) {
				for (DwConsolpr pr : consol.getDwConsolprs()) {
					retorno.add(pr.getOmProduto());
				}
			}
		}

		return retorno;
	}


	public DwConsol getDwConsol() {
		DwConsol retorno = null;
		if (getDwConsols() != null && !getDwConsols().isEmpty()) {
			retorno = getDwConsols().iterator().next();
		}
		return retorno;
	}
}
