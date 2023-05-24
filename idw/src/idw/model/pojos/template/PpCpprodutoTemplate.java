package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpData;
import idw.model.pojos.PpCpproduto;

public abstract class PpCpprodutoTemplate extends AbstractTemplate<PpCpproduto> {

	public abstract BigDecimal getPcsProducaobruta();
	public abstract void setPcsProducaobruta(BigDecimal pcsProducaobruta);
	public abstract BigDecimal getPcsProducaorefugada();
	public abstract void setPcsProducaorefugada(BigDecimal pcs);
	
	public void set(Long idCpproduto,
		String nrDoc,
		Double pcsProducaoplanejada,
		Double pcsProducaobruta,
		OmProduto omProduto,
		PpCp ppCp){

		PpCpproduto ppCpproduto = (PpCpproduto) this;
		ppCpproduto.setIdCpproduto(idCpproduto);
		ppCpproduto.setOmProduto(omProduto);
		ppCpproduto.setPpCp(ppCp);
		ppCpproduto.setNrDoc(nrDoc);
		ppCpproduto.setPcsProducaobruta(new BigDecimal(pcsProducaobruta));
		ppCpproduto.setPcsProducaoplanejada(new BigDecimal(pcsProducaoplanejada));

	}

	@Override
	protected PpCpproduto atribuir(PpCpproduto from, PpCpproduto to,
			boolean isCopiarFK) {

		if(to == null) {
			to = new PpCpproduto();
		}

		to.setIdCpproduto(from.getIdCpproduto());
		to.setNrDoc(from.getNrDoc());
		to.setPcsProducaoplanejada(from.getPcsProducaoplanejada());
		to.setPcsProducaobruta(from.getPcsProducaobruta());
		to.setPcsProducaorefugada(from.getPcsProducaorefugada());

		if(isCopiarFK) {
			if(from.getOmProduto() != null) {
				try {
					to.setOmProduto(from.getOmProduto().clone(false));
				}catch(SessionException e) {
					to.setOmProduto(null);
				}
			}

			to.setPpCpDatas(null);
			if(from.getPpCpDatas() != null) {
				to.setPpCpDatas(new HashSet<PpCpData>());

				try {
					for(PpCpData data : from.getPpCpDatas()) {
						to.getPpCpDatas().add(data.clone());
					}
				}catch(SessionException e) {
					to.setPpCpDatas(null);
				}catch(LazyInitializationException e) {
					to.setPpCpDatas(null);
				}
			}
		}

		to.setPpCp(null);

		return to;
	}

	@Override
	public String toString() {
		PpCpproduto itemGet = (PpCpproduto) this;
		
		StringBuilder formatado = new StringBuilder();
		
		formatado.append("nrDoc").append(itemGet.getNrDoc()).append("\n");
		formatado.append("producaoBruta").append(itemGet.getPcsProducaobruta()).append("\n");
		formatado.append("producaoplanejada").append(itemGet.getPcsProducaoplanejada()).append("\n");
		formatado.append("producaoRefugada").append(itemGet.getPcsProducaorefugada()).append("\n");
		
		return formatado.toString();

	}
	
	public BigDecimal getProducaoLiquida() {
		BigDecimal retorno = getPcsProducaobruta();
		if (retorno != null && getPcsProducaorefugada() != null)
			retorno = retorno.subtract(getPcsProducaorefugada());
		else if (retorno == null)
			retorno = BigDecimal.ZERO;
		return retorno;
	}
}
