package idw.webservices.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;

public class ListaIndicadoresPtDTO {
	
	private transient Agrupador agrupador;
	private IndicadoresDTO indicadoresDTO;
	private List<IndicadoresPtDTO> lista;
	
	public ListaIndicadoresPtDTO(){
		this.indicadoresDTO = new IndicadoresDTO();
		this.lista = new ArrayList<IndicadoresPtDTO>();
	}
	
	public String toString(){
		
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("indicadoresDTO", indicadoresDTO.toString())
			.append("lista", "\n" + StringUtils.repeat(" ", 10) + StringUtils.join(lista, "\n" + StringUtils.repeat(" ", 10)))
			.toString();
	}
	
	public IndicadoresDTO getIndicadoresDTO() {
		return indicadoresDTO;
	}
	public void setIndicadoresDTO(IndicadoresDTO indicadoresDTO) {
		this.indicadoresDTO = indicadoresDTO;
	}
	public List<IndicadoresPtDTO> getLista() {
		return lista;
	}
	public void setLista(
			List<IndicadoresPtDTO> listaIndicadoresPtDTOs) {
		this.lista = listaIndicadoresPtDTOs;
	}
	
	public void prepararSerializacao(){
		for(IndicadoresPtDTO ind: this.lista){
			ind.prepararSerializacao();
		}
	}
	
	/**
	 * Disponibiliza metodos para fazer o agrupamento dos indicadores para cada Pt 
	 * 
	 */	 
	public Agrupador getAgrupador(Object... params){
		if(this.agrupador == null){
			this.agrupador = new Agrupador(this);
		}
		return this.agrupador;
	}
	
	/**
	 * Agrupa os dados de todos os OmPts, e para cada Pt 
	 *
	 */
	public class Agrupador{
		ListaIndicadoresPtDTO listaIndicadoresPtDTO;
		
		/** {@code Map} com o idPt como chave e {@code IndicadoresPtDTO} */ 
		Map<Long, IndicadoresPtDTO> indices = new HashMap<Long, IndicadoresPtDTO>();
		
		ListaIndicadoresPtDTO listaAgrupada;
		
		public  Agrupador(ListaIndicadoresPtDTO listaIndicadoresPtDTO){
			this.listaIndicadoresPtDTO = listaIndicadoresPtDTO;
			this.listaAgrupada = new ListaIndicadoresPtDTO();
		}
		
		
		
		public void add(IndicadoresPtDTO indicadoresPtDTO){
			
			Long idPt = indicadoresPtDTO.getOmPt().getIdPt();
			
			// Agrupa para todas as maquinas
			listaAgrupada.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO());
			
			// Verifica se precisa adicionar os indicadores do pt na colecao 
			IndicadoresPtDTO item = indices.get(idPt);
			if(item == null){
				
				item = new IndicadoresPtDTO();
				item.setOmPt(indicadoresPtDTO.getOmPt());
				item.setIndicadoresDTO(new IndicadoresDTO());
				item.getIndicadoresDTO().copy(indicadoresDTO, false);
				
				// Adiciona indicadores de OmPt
				indices.put(idPt, item);
				this.listaAgrupada.getLista().add(item);
				
			}			
			// Agrupar os indicadores
			item.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO());
		}
		public void add(IndicadoresPtDTO indicadoresPtDTO, boolean isGargalosAgrupados){
			
			if (isGargalosAgrupados){
				//190423 Long idPt = indicadoresPtDTO.getOmPt().getIdPt();
				Long idPt = indicadoresPtDTO.getOmPt().getOmTppt().getIdTppt(); //190423 //idtppt
				
				//190513..
				//190513 - devido a questao de simplificacao do tipopt para todas as maquinas em IAC (usando mesmo 'SMD' para tudo).
				if (indicadoresPtDTO.getOmPt()!=null && indicadoresPtDTO.getOmPt().getCdPt()!=null){
					String sCd = indicadoresPtDTO.getOmPt().getCdPt();
					String sIDArtificial = "";
					char cAux = 0;
					int iAux = 0;
					if (sCd.length()<=1){
						cAux = sCd.charAt(0);
						iAux = cAux;
						sIDArtificial = String.valueOf(iAux);
					}
					if (sCd.length()>=2){
						cAux = sCd.charAt(0);
						iAux = cAux;
						sIDArtificial = String.valueOf(iAux);
						cAux = sCd.charAt(1);
						iAux = cAux;
						sIDArtificial = sIDArtificial + String.valueOf(iAux);
					}
					sIDArtificial = String.valueOf(idPt) + sIDArtificial;
					idPt = Long.valueOf(sIDArtificial);
				}
				//190513.
				

				// Agrupa para todas as maquinas
				listaAgrupada.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO(), isGargalosAgrupados);
				
				// Verifica se precisa adicionar os indicadores do pt na cole��o 
				IndicadoresPtDTO item = indices.get(idPt);
				if(item == null){
					
					item = new IndicadoresPtDTO();
					item.setOmPt(indicadoresPtDTO.getOmPt());
					item.setIndicadoresDTO(new IndicadoresDTO());
					item.getIndicadoresDTO().copy(indicadoresDTO, false);
					
					// Adiciona indicadores de OmPt
					indices.put(idPt, item);
					this.listaAgrupada.getLista().add(item);
					
				}			
				// Agrupar os indicadores
				item.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO(), isGargalosAgrupados);

				
			} else {

				Long idPt = indicadoresPtDTO.getOmPt().getIdPt();
				
				// Agrupa para todas as maquinas
				listaAgrupada.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO());
				
				// Verifica se precisa adicionar os indicadores do pt na colecao 
				IndicadoresPtDTO item = indices.get(idPt);
				if(item == null){
					
					item = new IndicadoresPtDTO();
					item.setOmPt(indicadoresPtDTO.getOmPt());
					item.setIndicadoresDTO(new IndicadoresDTO());
					item.getIndicadoresDTO().copy(indicadoresDTO, false);
					
					// Adiciona indicadores de OmPt
					indices.put(idPt, item);
					this.listaAgrupada.getLista().add(item);
					
				}			
				// Agrupar os indicadores
				item.getIndicadoresDTO().getAgrupador().add(indicadoresPtDTO.getIndicadoresDTO());

			}
				
		}

		
		
		
		/**
		 * Finaliza o agrupamento dos dados
		 */
		public ListaIndicadoresPtDTO result(OmCfg omcfg, OmPt ompt){
			this.listaAgrupada.getIndicadoresDTO().getAgrupador().resultMerge(this.listaAgrupada.getLista().size(), omcfg, ompt);
			for(IndicadoresPtDTO i: this.listaAgrupada.getLista()){
				i.getIndicadoresDTO().getAgrupador().resultMerge(omcfg, ompt);
			}
			return this.listaAgrupada;
		}
		public ListaIndicadoresPtDTO result(OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			if (isGargalosAgrupados){
				this.listaAgrupada.getIndicadoresDTO().getAgrupador().resultMerge(this.listaAgrupada.getLista().size(), omcfg, ompt, isGargalosAgrupados);
				for(IndicadoresPtDTO i: this.listaAgrupada.getLista()){
					i.getIndicadoresDTO().getAgrupador().resultMerge(omcfg, ompt, isGargalosAgrupados);
				}				
			} else {
				this.listaAgrupada.getIndicadoresDTO().getAgrupador().resultMerge(this.listaAgrupada.getLista().size(), omcfg, ompt);
				for(IndicadoresPtDTO i: this.listaAgrupada.getLista()){
					i.getIndicadoresDTO().getAgrupador().resultMerge(omcfg, ompt);
				}				
			}
			return this.listaAgrupada;
		}

		
		
		
		/**
		 * Finaliza agrupamento mesclando com a ListaIndicadoresPtDTO 
		 */
		public void resultMerge(OmCfg omcfg, OmPt ompt){
			this.result(omcfg, ompt);
			this.listaIndicadoresPtDTO.setIndicadoresDTO(this.listaAgrupada.getIndicadoresDTO());
			this.listaIndicadoresPtDTO.setLista(this.listaAgrupada.getLista());			
		}
		public void resultMerge(OmCfg omcfg, OmPt ompt, boolean isGargalosAgrupados){
			if (isGargalosAgrupados){
				this.result(omcfg, ompt, isGargalosAgrupados);
				this.listaIndicadoresPtDTO.setIndicadoresDTO(this.listaAgrupada.getIndicadoresDTO());
				this.listaIndicadoresPtDTO.setLista(this.listaAgrupada.getLista());
			} else {
				this.result(omcfg, ompt);
				this.listaIndicadoresPtDTO.setIndicadoresDTO(this.listaAgrupada.getIndicadoresDTO());
				this.listaIndicadoresPtDTO.setLista(this.listaAgrupada.getLista());
			}
		}

		
		
		
		public void add(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao){
			this.add(IndicadoresPtDTO.newInstance(dwConsolid, omcfg, dao));
		}
		public void add(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao, boolean isGargalosAgrupados){
			if (isGargalosAgrupados){
				this.add(IndicadoresPtDTO.newInstance(dwConsolid, omcfg, dao, isGargalosAgrupados), isGargalosAgrupados);
			}else{
				this.add(IndicadoresPtDTO.newInstance(dwConsolid, omcfg, dao));	
			}
		}
		
		
		
	}
}
