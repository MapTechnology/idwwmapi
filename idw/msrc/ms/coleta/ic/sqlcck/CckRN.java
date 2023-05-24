package ms.coleta.ic.sqlcck;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.cck.DAOGenericoCck;
import idw.model.pojos.MsCck;
import idw.model.pojos.cck.CampoMemoria;
import idw.model.pojos.cck.Equipamento;
import idw.model.pojos.cck.Medicao;
import idw.model.pojos.cck.MemoriaMassa;
import idw.model.rn.AbstractRN;
import idw.model.rn.MsCckRN;

import java.util.List;

import ms.model.dto.IcUpDTO;

public class CckRN extends AbstractRN<DAOGenericoCck> {

	public CckRN(DAOGenericoCck dao) {
		super(dao);
	}

	public  Equipamento getEquipamentos(IcUpDTO icupdto) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT e ");
		q.append("FROM Equipamento e ");
		q.append("where e.nomeEquipamento = :nomeEquipamento ");
		q.append("AND e.ativo = :ativo ");

		q.defineParametro("nomeEquipamento", icupdto.getUpDTO().getCd_up());
		q.defineParametro("ativo", (byte) 1);

		Equipamento equipamento = (Equipamento) q.uniqueResult();

		return equipamento;

	}

	public Medicao getRegistrosMedicao(Equipamento equipamento) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT m ");
		q.append("FROM Medicao m ");
		q.append("WHERE m.idEquipamento =:idEquipamento ");

		q.defineParametro("idEquipamento", equipamento.getIdEquipamento());

		Medicao medicao = (Medicao) q.uniqueResult();

		return medicao;
	}

	public CampoMemoria getCampoMemoria(Medicao medicao) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT c ");
		q.append("FROM CampoMemoria c ");
		q.append("WHERE c.idEquipamento =:idEquipamento ");
		q.append("AND c.idGrandeza =:idGrandeza ");
		q.append("AND c.idMedicao =:idMedicao ");

		q.defineParametro("idEquipamento", medicao.getIdEquipamento());
		q.defineParametro("idGrandeza", (int) 1);
		q.defineParametro("idMedicao", medicao.getIdMedicao());

		CampoMemoria campoMemoria = (CampoMemoria) q.uniqueResult();
		
		return campoMemoria;
	}
	

	public List<MemoriaMassa> getMemoriaMassa(CampoMemoria campo) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT m ");
		q.append("FROM MemoriaMassa m ");
		q.append("INNER JOIN FETCH m.id memoria");
		q.append("WHERE memoria.idCampoMemoria =:idCampo ");
//		q.append("AND memoria.datahora > dataHora ");

//		MsCck msCck = getVerificarControle(campo/*, datahora*/);
		q.defineParametro("idCampo", campo.getIdCampoMemoria());
//		q.defineParametro("dataHora", msCck.getDatahora());
		List<MemoriaMassa> listaMassas = null;
		
		MsCck msCck = getVerificarControle(campo/*, datahora*/);
		
		if(msCck == null){
			//System.out.println("Id campo: "+campo.getIdCampoMemoria());
			listaMassas = q.list();
			//System.out.println("tamanho lista: "+listaMassas.size() );
			
			MsCckRN rn = new MsCckRN(new DAOGenerico());
			rn.iniciaConexaoBanco();
			rn.setValoresMsCck(campo, listaMassas);
			rn.finalizaConexaoBanco();
//			MsCck cck = new MsCck();
//			
//			cck.setIdCampo(campo.getIdCampoMemoria());
//			cck.setDatahora(listaMassas.get(listaMassas.size() - 1).getId().getDatahora());
//			getDao().makeTransient(cck);
		}else {
			listaMassas = setAtualizarControle(msCck);
		}
			
		return listaMassas;
	}

	
	private List<MemoriaMassa> setAtualizarControle(MsCck msCck) {
		MapQuery q = new MapQuery(this.getDao().getSession());
	
		q.append("SELECT m ");
		q.append("FROM MemoriaMassa m ");
		q.append("INNER JOIN FETCH m.id memoria");
		q.append("WHERE memoria.idCampoMemoria = :idCampo ");
		q.append("AND memoria.datahora > :dataHora ");
		
		q.defineParametro("idCampo", msCck.getIdCampo());
		q.defineParametroData("dataHora", msCck.getDatahora());
		
		List<MemoriaMassa> listaMassas = null;
		
		listaMassas = q.list();
//		//System.out.println("teste: "+listaMassas.size());
		
//		CckRN rn = new CckRN(new DAOGenerico());
//	
//		rn.iniciaConexaoBanco();
//		MsCck cck = new MsCck();
//		
//		cck.setIdCampo(msCck.getIdCampo());
//		cck.setDatahora(listaMassas.get(listaMassas.size() - 1).getId().getDatahora());
//		getDao().makeTransient(cck);
//		rn.finalizaConexaoBanco();
		MsCckRN rn = new MsCckRN(new DAOGenerico());
		rn.iniciaConexaoBanco();
		rn.setMsCck(msCck, listaMassas);
		rn.finalizaConexaoBanco();
		
		return listaMassas;
	}

	private MsCck getVerificarControle(CampoMemoria campo) {
		
		MsCckRN rn = new MsCckRN(new DAOGenerico());
		rn.iniciaConexaoBanco();
		MapQuery q = new MapQuery(rn.getDao().getSession());
		
		q.append("SELECT m ");
		q.append("FROM MsCck m ");
		q.append("WHERE m.idCampo =:idCampo ");
		
		q.defineParametro("idCampo", campo.getIdCampoMemoria());
		
		MsCck msCck = (MsCck) q.uniqueResult();
		rn.finalizaConexaoBanco();
		return msCck;
	}

}
