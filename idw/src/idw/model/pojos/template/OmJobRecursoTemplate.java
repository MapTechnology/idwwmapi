package idw.model.pojos.template;

import idw.model.pojos.OmJobRecurso;

public abstract class OmJobRecursoTemplate extends AbstractTemplate<OmJobRecurso>{

	public enum _TipoRecurso {
		ImportacaoBOM(1), 
		ImportacaoOP(2),
		ImportacaoGrupoProduto(3),
		ImportacaoIndisponibilidade(4),
		ImportacaoPosto(5),
		ImportacaoCliente(6),
		ImportacaoFerramenta(7),
		ImportacaoFolha(8),
		ImportacaoUsuario(9),
		ExportacaoProducao(10),
		ExportacaoParada(11);
		
		private final long id;
		
		private _TipoRecurso(long id){
			this.id = id;
		}
		
		public long getId(){
			return this.id;
		}
	}	

	@Override
	protected OmJobRecurso atribuir(OmJobRecurso from, OmJobRecurso to, boolean isCopiarFK) {
		if(to == null){
			to = new OmJobRecurso();
		}

		to.setDsJobRecurso(from.getDsJobRecurso());
		to.setIdJobRecurso(from.getIdJobRecurso());
		
		return to;
	}


}
