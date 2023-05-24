package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;

public abstract class AbstractParadaRN extends AbstractRN<DAOGenerico>{

	public AbstractParadaRN() {
		this(null);
	}
	
	public AbstractParadaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	
	
	
	//20170127
	
	/*
	protected List<DwConsolpa> getParadasEmAberto(Date dataInicio, Date dataFim, TurnoDTO turnoDTO, OmPt posto, OmGt gt, Long idgpRap){
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());

		//prepara uma lista de PTs.
		//para em seguida procurar as paradas em abertas dessa lista de PTs.
		List<OmPt> postos = new ArrayList<>();
		if (posto == null || posto.getCdPt() == null || posto.getCdPt().equals("")) {
			PTRN postoRN = new PTRN(getDao());
			if (gt != null) {
				postos.addAll(postoRN.pesquisarPtByGtComLayout(gt));
			} else {
				// Nesse caso nao tem filtro de PT nem GT, pode ser por Molde ou grupo de molde
				// Assim pegarei todos os pts para depois filtrar o molde ou grupo de molde
				postos.addAll(postoRN.pesquisarTodosPtStAtivo());
			}
		} else {
			postos.add(posto);
		}
		
		List<DwConsolpa> paradasEmAberto = new ArrayList<>();
		
		//Procurando as paradas em aberto da lista de PTs.
		for (OmPt ompt : postos) {
			//TODO adicionar filtro de molde ou grupo de molde
			// Se existir um filtro de Molde ou Grupo de molde tratar aqui


			DwConsolpa paradaAberta = null ;
			if (dataInicio!=null || dataFim!=null ) //20161104F: if
			{
				paradaAberta = rn.getDwConsolpaEmAberto(
						ompt.getCdPt(),
						dataInicio,
						dataFim,
						turnoDTO,
						idgpRap);
			}

			if(paradaAberta != null){
				paradasEmAberto.add(paradaAberta);
				System.out.println(paradaAberta);
			}
							
		}
		
		System.out.println("--PARADAS EM ABERTO:"+paradasEmAberto.size());
		
		return paradasEmAberto;
	}
	*/
	
	
	/*
	protected List<DwConsolpa> getParadasEmAberto(Date dataInicio, Date dataFim, TurnoDTO turnoDTO, OmPt posto, OmGt gt){
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());

		//prepara uma lista de PTs.
		//para em seguida procurar as paradas em abertas dessa lista de PTs.
		List<OmPt> postos = new ArrayList<>();
		if (posto == null || posto.getCdPt() == null || posto.getCdPt().equals("")) {
			PTRN postoRN = new PTRN(getDao());
			if (gt != null) {
				postos.addAll(postoRN.pesquisarPtByGtComLayout(gt));
			} else {
				// Nesse caso nao tem filtro de PT nem GT, pode ser por Molde ou grupo de molde
				// Assim pegarei todos os pts para depois filtrar o molde ou grupo de molde
				postos.addAll(postoRN.pesquisarTodosPtStAtivo());
			}
		} else {
			postos.add(posto);
		}
		
		List<DwConsolpa> paradasEmAberto = new ArrayList<>();
		
		//Procurando as paradas em aberto da lista de PTs.
		for (OmPt ompt : postos) {
			//TODO adicionar filtro de molde ou grupo de molde
			// Se existir um filtro de Molde ou Grupo de molde tratar aqui


			DwConsolpa paradaAberta = null ;
			if (dataInicio!=null || dataFim!=null ) //20161104F: if
			{
				paradaAberta = rn.getDwConsolpaEmAberto(
						ompt.getCdPt(),
						dataInicio,
						dataFim,
						turnoDTO);
			}

			if(paradaAberta != null){
				paradasEmAberto.add(paradaAberta);
				System.out.println(paradaAberta);
			}
			
			
		}
		
		System.out.println("--PARADAS EM ABERTO:"+paradasEmAberto.size());
		
		return paradasEmAberto;
	}
	*/
	
	/** retorna as paradas em aberto usando como parametro principal o codigo da OP
	 * 
	 * @param cdop NOT NULL
	 * @param dataInicial CAN BE NULL
	 * @param dataFinal CAN BE NULL
	 * @param turnoDTO CAN BE NULL
	 * @return List
	 */
	
	/*
	protected List<DwConsolpa> getParadasEmAbertoPorOP(String cdop, Date dataInicial, Date dataFinal, TurnoDTO turnoDTO) {
		List<DwConsolpa> paradasEmAberto = new ArrayList<>();
		if(cdop == null || cdop.equals("")){
			return paradasEmAberto;
		}
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.ppCp ppcp");
		q.append("JOIN ppcp.ppCpprodutos ppcpproduto");
		q.append("WHERE ppcpproduto.nrDoc = :cdop");
		q.append("AND consolid.tpId = 1");
		
		if (dataInicial != null && dataFinal != null) {
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		
		if (turnoDTO != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		
		q.defineParametro("cdop", cdop);
		
		if (dataInicial != null && dataFinal != null) {
			q.defineParametroData("dataincial", DataHoraRN.getDataHoraInicial(dataInicial));
			q.defineParametroData("datafinal", DataHoraRN.getDataHora235959(dataFinal));
		}		
		
		if (turnoDTO != null) {
			q.defineParametro("idturno", turnoDTO.getTurno().getIdTurno());
		}
		
		List<DwConsolid> lista = q.list();
		System.out.println("--SIZE CONSOLID:"+lista.size());
		
		Map<String, List<DwConsolid>> mapPostos = new HashMap<>();
		for(DwConsolid consolid : lista){
			OmPt posto = consolid.getOmPt();
			if(posto == null){
				continue;
			}
			
			String cdPt = posto.getCdPt();
			List<DwConsolid> listaConsolid = mapPostos.get(cdPt);
			
			if(listaConsolid == null){
				listaConsolid = new ArrayList<>();
				listaConsolid.add(consolid);
				mapPostos.put(cdPt, listaConsolid);
			} else {
				listaConsolid.add(consolid);
			}
		}		
		
		for(String chave : mapPostos.keySet()){
			System.out.println("---PT:"+chave);
			for(DwConsolid id: mapPostos.get(chave)){
				System.out.println("-----ID:"+id.getIdConsolid());
			}
		}
		
		GraficoParettoParadaRN rn = new GraficoParettoParadaRN(getDao());		
		for(String cdpt : mapPostos.keySet()){
			List<DwConsolid> consolids = mapPostos.get(cdpt);
			OmPt ompt;
			try {
				ompt = getDao().findByCd(OmPt.class, cdpt, "cdPt", true);
			} catch (RegistroDesconhecidoException e) {
				continue;
			}
			
			DwConsolpa paradaEmAberto = rn.getDwConsolpaEmAberto(ompt, consolids);
			if(paradaEmAberto != null){
				paradasEmAberto.add(paradaEmAberto);
			}
		}
		
		System.out.println("--PARADAS EM ABERTO:"+paradasEmAberto.size());
		
		return paradasEmAberto;
	}
	*/

	/*
	protected List<DwConsolpa> removeConsolpaComIdRepetido(List<DwConsolpa> listaConsolpa){
		List<DwConsolpa> listaConsolpaSemIdRepetido = new ArrayList<>();
		
		for(DwConsolpa pa : listaConsolpa){
			boolean isConsolpaRepetido = false;
			for(DwConsolpa paSalvo : listaConsolpaSemIdRepetido){
				if(paSalvo.getIdConsolpa() == pa.getIdConsolpa()){
					isConsolpaRepetido = true;
					break;
				}
			}
			if(isConsolpaRepetido == false){
				listaConsolpaSemIdRepetido.add(pa);
			}
		}
		
		return listaConsolpaSemIdRepetido;
	}
	*/
	
	
	//20170123: especialização [removeConsolpaComIdRepetido] (considera também IDpa=0); 
	// .. casos nos quais IDpa=0 para mesma OP e maquinas diferentes estavam sendo indevidamente eliminados.
	
	protected List<DwConsolpa> removeConsolpaComIdRepetido(List<DwConsolpa> listaConsolpa, boolean isConsideraIDPA0){
		List<DwConsolpa> listaConsolpaSemIdRepetido = new ArrayList<>();
		
		for(DwConsolpa pa : listaConsolpa){
			boolean isConsolpaRepetido = false;
			for(DwConsolpa paSalvo : listaConsolpaSemIdRepetido){
				
				// Condicional abaixo NÃO considera IPpa=0
				if( (paSalvo.getIdConsolpa() == pa.getIdConsolpa()) 
					&& (paSalvo.getIdConsolpa()!=0L) && (pa.getIdConsolpa()!=0L)  ){
						isConsolpaRepetido = true;
						break;
				}
				// Condicional abaixo considera IPpa=0
				if( 	(paSalvo.getIdConsolpa() == pa.getIdConsolpa()) 
						&& (paSalvo.getIdConsolpa()==0L)
						&& (
								(paSalvo.getDwConsol()==null || pa.getDwConsol()==null)
								|| (paSalvo.getDwConsol()!=null && pa.getDwConsol()!=null && (paSalvo.getDwConsol().getIdConsol() == pa.getDwConsol().getIdConsol()) )
							)
						){
					isConsolpaRepetido = true;
					break;
				}
				
			}
			if(isConsolpaRepetido == false){
				listaConsolpaSemIdRepetido.add(pa);
			}
		}
		
		return listaConsolpaSemIdRepetido;
	}
	
	
	protected List<DwConsolpaoco> removeConsolpaocoComIdRepetido(List<DwConsolpaoco> listaConsolpaoco){
		List<DwConsolpaoco> listaConsolpaocoSemIdRepetido = new ArrayList<>();
		
		for(DwConsolpaoco oco : listaConsolpaoco){
			boolean isConsolpaocoRepetido = false;
			for(DwConsolpaoco ocoSalvo : listaConsolpaocoSemIdRepetido){
				if(ocoSalvo.getIdConsolpaoco() == oco.getIdConsolpaoco()){
					isConsolpaocoRepetido = true;
					break;
				}
			}
			if(isConsolpaocoRepetido == false){
				listaConsolpaocoSemIdRepetido.add(oco);
			}
		}
		
		return listaConsolpaocoSemIdRepetido;
	}
	
	protected void addConsolpa(DwConsolpa consolpa, List<DwConsolpa> listaConsolpa){
		if(consolpa.getIdConsolpa() == 0){
			listaConsolpa.add(consolpa);
			return;
		}
		boolean isConsolpaSalvo = false;
		for(int i=0; i<listaConsolpa.size(); i++){
			if(listaConsolpa.get(i).getIdConsolpa() == consolpa.getIdConsolpa()){
				listaConsolpa.set(i, consolpa);
				isConsolpaSalvo = true;
				break;
			}
		}
		
		if(isConsolpaSalvo == false){
			listaConsolpa.add(consolpa);
			return;
		}
	}

}
