package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsoldef;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.util.AritmeticaUtil;


public abstract class DwConsolTemplate extends AbstractTemplate<DwConsol> {
	
	public boolean isTemParada(){
		
		DwConsol dwConsol = this.getInstanceT();
		BigDecimal qtParadaCP = ObjectUtils.defaultIfNull(dwConsol.getSegAutoTempoparadaCp(), BigDecimal.ZERO);
		BigDecimal qtParadaSP = ObjectUtils.defaultIfNull(dwConsol.getSegAutoTempoparadaSp(), BigDecimal.ZERO);
		
		return (qtParadaCP.compareTo(BigDecimal.ZERO) == 1 || qtParadaSP.compareTo(BigDecimal.ZERO) == 1);
		
	}
	
	@Override
	protected DwConsol atribuir(DwConsol itemGet, DwConsol itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsol();
		
		itemSet.setIdConsol(itemGet.getIdConsol());
		
		itemSet.setSegAutoTempocalendario(itemGet.getSegAutoTempocalendario());
		itemSet.setPcsAutoProducaoprevista(itemGet.getPcsAutoProducaoprevista());
		itemSet.setPcsAutoProducaorefugada(itemGet.getPcsAutoProducaorefugada());
		itemSet.setPcsAutoProducaobruta(itemGet.getPcsAutoProducaobruta());
		itemSet.setPcsAutoProducaoliquida(itemGet.getPcsAutoProducaoliquida());
		itemSet.setPcsAutoPerdacavidades(itemGet.getPcsAutoPerdacavidades());
		itemSet.setPcsAutoPerdaciclo(itemGet.getPcsAutoPerdaciclo());
		itemSet.setPcsAutoPerdaparadaSp(itemGet.getPcsAutoPerdaparadaSp());
		itemSet.setSegAutoCiclomedio(itemGet.getSegAutoCiclomedio());
		itemSet.setSegAutoPerdaciclo(itemGet.getSegAutoPerdaciclo());		
//		itemSet.setSegAutoTempodisponivel(itemGet.getSegAutoTempodisponivel());
		itemSet.setSegAutoTempoprodutivo(itemGet.getSegAutoTempoprodutivo());
		itemSet.setSegManuTempoprodutivo(itemGet.getSegManuTempoprodutivo());
		itemSet.setSegAutoRitmo(itemGet.getSegAutoRitmo());
		itemSet.setSegAutoTemporefugadas(itemGet.getSegAutoTemporefugadas());
		itemSet.setSegAutoTempotrabalhado(itemGet.getSegAutoTempotrabalhado());
		itemSet.setSegAutoCicloimprodutivo(itemGet.getSegAutoCicloimprodutivo());
		itemSet.setSegAutoCicloprodutivo(itemGet.getSegAutoCicloprodutivo());
		itemSet.setSegAutoTempoparadaSp(itemGet.getSegAutoTempoparadaSp());
		itemSet.setSegAutoTempoativo(itemGet.getSegAutoTempoativo());
		itemSet.setSegManuTempoativo(itemGet.getSegManuTempoativo());
		itemSet.setSegManuTempoparadaSp(itemGet.getSegManuTempoparadaSp());
		itemSet.setSegAutoCiclopadrao(itemGet.getSegAutoCiclopadrao());
		itemSet.setSegAutoPerdacav(itemGet.getSegAutoPerdacav());
		itemSet.setSegManuCicloprodutivo(itemGet.getSegManuCicloprodutivo());
		itemSet.setSegAutoBoas(itemGet.getSegAutoBoas());
		itemSet.setSegManuCicloimprodutivo(itemGet.getSegManuCicloimprodutivo());
		itemSet.setSegManuTempotrabalhado(itemGet.getSegManuTempotrabalhado());
		itemSet.setSegManuTemporefugadas(itemGet.getSegManuTemporefugadas());
		itemSet.setSegManuRitmo(itemGet.getSegManuRitmo());
//		itemSet.setSegManuTempodisponivel(itemGet.getSegManuTempodisponivel());
		itemSet.setSegManuPerdaciclo(itemGet.getSegManuPerdaciclo());
		itemSet.setSegManuCiclomedio(itemGet.getSegManuCiclomedio());
		itemSet.setSegManuCiclopadrao(itemGet.getSegManuCiclopadrao());
		itemSet.setSegManuPerdacav(itemGet.getSegManuPerdacav());
		itemSet.setSegManuBoas(itemGet.getSegManuBoas());
		itemSet.setPcsManuPerdaparadaSp(itemGet.getPcsManuPerdaparadaSp());
		itemSet.setPcsManuPerdaciclo(itemGet.getPcsManuPerdaciclo());
		itemSet.setPcsManuPerdacavidades(itemGet.getPcsManuPerdacavidades());
		itemSet.setPcsManuProducaobruta(itemGet.getPcsManuProducaobruta());
		itemSet.setPcsManuProducaoliquida(itemGet.getPcsManuProducaoliquida());
		itemSet.setPcsManuProducaorefugada(itemGet.getPcsManuProducaorefugada());
		itemSet.setPcsManuProducaoprevista(itemGet.getPcsManuProducaoprevista());
		itemSet.setSegManuTempocalendario(itemGet.getSegManuTempocalendario());
		itemSet.setSegAutoTempoalerta(itemGet.getSegAutoTempoalerta());
		itemSet.setSegManuTempoalerta(itemGet.getSegManuTempoalerta());
		itemSet.setSegAutoTempocalsempeso(itemGet.getSegAutoTempocalsempeso());
		itemSet.setSegManuTempocalsempeso(itemGet.getSegManuTempocalsempeso());
		itemSet.setPcsAutoCavTotal(itemGet.getPcsAutoCavTotal());
		itemSet.setPcsManuCavTotal(itemGet.getPcsManuCavTotal());
		itemSet.setPcsAutoCavAtivas(itemGet.getPcsAutoCavAtivas());
		itemSet.setPcsManuCavAtivas(itemGet.getPcsManuCavAtivas());
		itemSet.setSegAutoTempoparadamtbf(itemGet.getSegAutoTempoparadamtbf());

		itemSet.setSegAutoTempoparadapao(itemGet.getSegAutoTempoparadapao());
		itemSet.setSegAutoTempoparadapa(itemGet.getSegAutoTempoparadapa());
		itemSet.setSegAutoTempoparadaptp(itemGet.getSegAutoTempoparadaptp());
		itemSet.setSegAutoTempoparadascp(itemGet.getSegAutoTempoparadascp());
		itemSet.setSegAutoTempoparadamdo(itemGet.getSegAutoTempoparadamdo());
		itemSet.setGAutoPesoBruto(itemGet.getGAutoPesoBruto());
		itemSet.setGManuPesoBruto(itemGet.getGManuPesoBruto());
		itemSet.setSegAutoTempoparadaAb(itemGet.getSegAutoTempoparadaAb());
		itemSet.setGAutoPesoLiquido(itemGet.getGAutoPesoLiquido());
		itemSet.setGManuPesoLiquido(itemGet.getGManuPesoLiquido());
		itemSet.setPcsAutoPerdaparadaCp(itemGet.getPcsAutoPerdaparadaCp());
		itemSet.setQtAutoCicloimprodutivo(itemGet.getQtAutoCicloimprodutivo());
		itemSet.setQtAutoCicloprodutivo(itemGet.getQtAutoCicloprodutivo());
		itemSet.setQtAutoCicloregulagem(itemGet.getQtAutoCicloregulagem());
		itemSet.setQtAutoOcoparadafds(itemGet.getQtAutoOcoparadafds());
		itemSet.setQtAutoOcoparadaimprev(itemGet.getQtAutoOcoparadaimprev());
		itemSet.setQtAutoOcoparadamdo(itemGet.getQtAutoOcoparadamdo());
		itemSet.setQtAutoOcoparadamtbf(itemGet.getQtAutoOcoparadamtbf());

		itemSet.setQtAutoOcoparadapa(itemGet.getQtAutoOcoparadapa());
		itemSet.setQtAutoOcoparadapao(itemGet.getQtAutoOcoparadapao());
		itemSet.setQtAutoOcoparadapp(itemGet.getQtAutoOcoparadapp());
		itemSet.setQtAutoOcoparadaprev(itemGet.getQtAutoOcoparadaprev());
		itemSet.setQtAutoOcoparadaptp(itemGet.getQtAutoOcoparadaptp());
		itemSet.setQtAutoOcoparadaregulagem(itemGet.getQtAutoOcoparadaregulagem());
		itemSet.setQtAutoOcoparadascp(itemGet.getQtAutoOcoparadascp());
		itemSet.setQtAutoOcoparadaCp(itemGet.getQtAutoOcoparadaCp());
		itemSet.setQtAutoOcoparadaSp(itemGet.getQtAutoOcoparadaSp());
		itemSet.setQtManuCicloimprodutivo(itemGet.getQtManuCicloimprodutivo());
		itemSet.setQtManuCicloprodutivo(itemGet.getQtManuCicloprodutivo());
		itemSet.setQtManuCicloregulagem(itemGet.getQtManuCicloregulagem());
		itemSet.setQtManuOcoparadafds(itemGet.getQtManuOcoparadafds());
		itemSet.setQtManuOcoparadaimprev(itemGet.getQtManuOcoparadaimprev());
		itemSet.setQtManuOcoparadamdo(itemGet.getQtManuOcoparadamdo());
		itemSet.setQtManuOcoparadamtbf(itemGet.getQtManuOcoparadamtbf());

		itemSet.setQtManuOcoparadapa(itemGet.getQtManuOcoparadapa());
		itemSet.setQtManuOcoparadapao(itemGet.getQtManuOcoparadapao());
		itemSet.setQtManuOcoparadapp(itemGet.getQtManuOcoparadapp());
		itemSet.setQtManuOcoparadaprev(itemGet.getQtManuOcoparadaprev());
		itemSet.setQtManuOcoparadaptp(itemGet.getQtManuOcoparadaptp());
		itemSet.setQtManuOcoparadaregulagem(itemGet.getQtManuOcoparadaregulagem());
		itemSet.setQtManuOcoparadascp(itemGet.getQtManuOcoparadascp());
		itemSet.setQtManuOcoparadaCp(itemGet.getQtManuOcoparadaCp());
		itemSet.setQtManuOcoparadaSp(itemGet.getQtManuOcoparadaSp());
		itemSet.setSegAutoTempoparadafds(itemGet.getSegAutoTempoparadafds());
		itemSet.setSegAutoTempoparadaimprev(itemGet.getSegAutoTempoparadaimprev());
		itemSet.setSegAutoTempoparadapp(itemGet.getSegAutoTempoparadapp());
		itemSet.setSegAutoTempoparadaprev(itemGet.getSegAutoTempoparadaprev());
		itemSet.setSegAutoTempoparadaregulagem(itemGet.getSegAutoTempoparadaregulagem());
		itemSet.setSegAutoTempoparadaCp(itemGet.getSegAutoTempoparadaCp());
		itemSet.setSegManuCicloregulagem(itemGet.getSegManuCicloregulagem());
		itemSet.setSegManuTempoparadafds(itemGet.getSegManuTempoparadafds());
		itemSet.setSegManuTempoparadaimprev(itemGet.getSegManuTempoparadaimprev());
		itemSet.setSegManuTempoparadamdo(itemGet.getSegManuTempoparadamdo());
		itemSet.setSegManuTempoparadamtbf(itemGet.getSegManuTempoparadamtbf());

		itemSet.setSegManuTempoparadapa(itemGet.getSegManuTempoparadapa());
		itemSet.setSegManuTempoparadapao(itemGet.getSegManuTempoparadapao());
		itemSet.setSegManuTempoparadapp(itemGet.getSegManuTempoparadapp());
		itemSet.setSegManuTempoparadaprev(itemGet.getSegManuTempoparadaprev());
		itemSet.setSegManuTempoparadaptp(itemGet.getSegManuTempoparadaptp());
		itemSet.setSegManuTempoparadaregulagem(itemGet.getSegManuTempoparadaregulagem());
		itemSet.setSegManuTempoparadascp(itemGet.getSegManuTempoparadascp());
		itemSet.setSegManuTempoparadaCp(itemGet.getSegManuTempoparadaCp());
		itemSet.setSegAutoCicloprodutivoCta(itemGet.getSegAutoCicloprodutivoCta());
		itemSet.setSegAutoCicloimprodutivoCta(itemGet.getSegAutoCicloimprodutivoCta());
		itemSet.setSegManuCicloprodutivoCta(itemGet.getSegManuCicloprodutivoCta());
		itemSet.setSegManuCicloimprodutivoCta(itemGet.getSegManuCicloimprodutivoCta());
		itemSet.setSegAutoCta(itemGet.getSegAutoCta());
		itemSet.setSegManuCta(itemGet.getSegManuCta());
		itemSet.setSegAutoTempoparadaCpVr(itemGet.getSegAutoTempoparadaCpVr());
		itemSet.setSegAutoTempoparadaSpVr(itemGet.getSegAutoTempoparadaSpVr());
		itemSet.setSegManuTempoparadaCpVr(itemGet.getSegManuTempoparadaCpVr());
		itemSet.setSegManuTempoparadaSpVr(itemGet.getSegManuTempoparadaSpVr());
		itemSet.setQtAutoOcoparadaCpVr(itemGet.getQtAutoOcoparadaCpVr());
		itemSet.setQtAutoOcoparadaSpVr(itemGet.getQtAutoOcoparadaSpVr());
		itemSet.setQtManuOcoparadaCpVr(itemGet.getQtManuOcoparadaCpVr());
		itemSet.setQtManuOcoparadaSpVr(itemGet.getQtManuOcoparadaSpVr());
		itemSet.setSegAutoTempoparadaDefault(itemGet.getSegAutoTempoparadaDefault());
		itemSet.setSegAutoTempoparadaSemOp(itemGet.getSegAutoTempoparadaSemOp());
		itemSet.setSegAutoTempoparadaSemEvt(itemGet.getSegAutoTempoparadaSemEvt());
		itemSet.setSegAutoTempoparadaSemCnx(itemGet.getSegAutoTempoparadaSemCnx());
		itemSet.setSegManuTempoparadaDefault(itemGet.getSegManuTempoparadaDefault());
		itemSet.setSegManuTempoparadaSemOp(itemGet.getSegManuTempoparadaSemOp());
		itemSet.setSegManuTempoparadaSemEvt(itemGet.getSegManuTempoparadaSemEvt());
		itemSet.setSegManuTempoparadaSemCnx(itemGet.getSegManuTempoparadaSemCnx());
		itemSet.setQtAutoTempoparadaDefault(itemGet.getQtAutoTempoparadaDefault());
		itemSet.setQtAutoTempoparadaSemOp(itemGet.getQtAutoTempoparadaSemOp());
		itemSet.setQtAutoTempoparadaSemEvt(itemGet.getQtAutoTempoparadaSemEvt());
		itemSet.setQtAutoTempoparadaSemCnx(itemGet.getQtAutoTempoparadaSemCnx());
		itemSet.setQtManuTempoparadaDefault(itemGet.getQtManuTempoparadaDefault());
		itemSet.setQtManuTempoparadaSemOp(itemGet.getQtManuTempoparadaSemOp());
		itemSet.setQtManuTempoparadaSemEvt(itemGet.getQtManuTempoparadaSemEvt());
		itemSet.setQtManuTempoparadaSemCnx(itemGet.getQtManuTempoparadaSemCnx());
		itemSet.setQtAutoCicloPrevisto(itemGet.getQtAutoCicloPrevisto());
		itemSet.setQtManuCicloPrevisto(itemGet.getQtManuCicloPrevisto());
		
		itemSet.setQtAutoCavativas(itemGet.getQtAutoCavativas());
		itemSet.setQtAutoCavtotal(itemGet.getQtAutoCavtotal());
		
		itemSet.setQtAutoTestes(itemGet.getQtAutoTestes());
		itemSet.setQtAutoDefeitos(itemGet.getQtAutoDefeitos());
		
		if(isCopiarFK == true){
			itemSet.setDwConsolid(itemGet.getDwConsolid().clone(false));
			
			// Clona a lista de paradas
			itemSet.setDwConsolpas(new HashSet<DwConsolpa>());			
			itemSet.setDwConsolpas(cloneDwConsolpas());
			
			// Clona a lista de defeitos
			itemSet.setDwConsoldefs(cloneDwConsoldefs());

			itemSet.setDwConsolpemps(new HashSet<DwConsolpemp>());
			if (itemGet.getDwConsolpemps() != null){
				for (DwConsolpemp dwConsolpemp : itemGet.getDwConsolpemps()){
				    itemSet.getDwConsolpemps().add(dwConsolpemp.clone(true));
				}
			}
			itemSet.setDwConsolprs(new HashSet<DwConsolpr>());
			if (itemGet.getDwConsolprs() != null){
				for (DwConsolpr dwconsolpr : itemGet.getDwConsolprs()){
				    itemSet.getDwConsolprs().add(dwconsolpr.clone(false));
				}
			}
			
		}
				
		return itemSet;
	}	
	
	/**
	 * Clona lista {@code dwConsolpas} do {@code DwConsol}
	 * @return
	 */
	public Set<DwConsolpa> cloneDwConsolpas(){
		HashSet<DwConsolpa> dwConsolpas = new HashSet<DwConsolpa>();
		
		if (this.getInstanceT().getDwConsolpas() != null){
			for (DwConsolpa dwconsolpa : this.getInstanceT().getDwConsolpas()){
				if (dwconsolpa.getSegAutoTempoparadaCp() != null || dwconsolpa.getSegAutoTempoparadaSp() != null)
					dwConsolpas.add(dwconsolpa.clone(true));
			}
		}
		return dwConsolpas;
	}
	
	public Set<DwConsolre> cloneDwConsolres() {
		Set<DwConsolre> dwconsolres = new HashSet<DwConsolre>();
		if (this.getInstanceT().getDwConsolres() != null) {
			for (DwConsolre dwconsolre : this.getInstanceT().getDwConsolres()) {
				dwconsolres.add(dwconsolre.clone(true));
			}
		}
		return dwconsolres;
	}
	
	/**
	 * Clona lista {@code dwConsoldefs} do {@code DwConsol}
	 * @return
	 */
	public Set<DwConsoldef> cloneDwConsoldefs(){
		HashSet<DwConsoldef> dwConsoldefs = new HashSet<DwConsoldef>();
		
		if (this.getInstanceT().getDwConsoldefs() != null){
			for (DwConsoldef dwconsoldef : this.getInstanceT().getDwConsoldefs()){
				dwConsoldefs.add(dwconsoldef.clone(true));
			}
		}
		return dwConsoldefs;
	}
	
	/**
	 * Faz o c�lculo da produ��o l�quida
	 * TODO criar campo na tabela com este calculo, e ajustar trechos para realiz�-lo 
	 * @return
	 */
	public BigDecimal getPcsProducaoLiquida(){
		BigDecimal pl = getInstanceT().getPcsAutoProducaoliquida();
		if (pl == null)
			pl = AritmeticaUtil.diminuir(
				getPcsProducaoBruta(),
				getPcsProducaoRefugada());
		return pl;
	}
	
	// Retorna a producao bruta considerando a correcao manual
	public BigDecimal getPcsProducaoBruta() {
		BigDecimal autoProducaoBruta = getInstanceT().getPcsAutoProducaobruta();
		
		if (autoProducaoBruta == null)
			autoProducaoBruta = BigDecimal.ZERO;
		
		if (getInstanceT().getPcsManuProducaobruta() != null)
			autoProducaoBruta = autoProducaoBruta.add(getInstanceT().getPcsManuProducaobruta() );
		
		return autoProducaoBruta;
	}
	
	// Retorna a producao refugada considerando correcao
	public BigDecimal getPcsProducaoRefugada() {
		BigDecimal autoProducaoRefugada = getInstanceT().getPcsAutoProducaorefugada();
		if (autoProducaoRefugada == null)
			autoProducaoRefugada = BigDecimal.ZERO;
		if (getInstanceT().getPcsManuProducaorefugada() != null)
			autoProducaoRefugada = autoProducaoRefugada.add(getInstanceT().getPcsManuProducaorefugada());
		return autoProducaoRefugada;
	}
	
	@Override
	public String toString() {
		DwConsol itemGet = (DwConsol) this;
		
		StringBuilder formatado = new StringBuilder();
		int contador = 0;
		formatado.append(contador++).append(" = ").append(itemGet.getIdConsol()).append("\n");
		
		formatado.append("getSegAutoTempocalendario").append(" = ").append(itemGet.getSegAutoTempocalendario()).append("\n");
		formatado.append("getPcsAutoProducaoprevista").append(" = ").append(itemGet.getPcsAutoProducaoprevista()).append("\n");
		formatado.append("getPcsAutoProducaorefugada").append(" = ").append(itemGet.getPcsAutoProducaorefugada()).append("\n");
		formatado.append("getPcsAutoProducaobruta").append(" = ").append(itemGet.getPcsAutoProducaobruta()).append("\n");
		formatado.append("getPcsAutoPerdacavidades").append(" = ").append(itemGet.getPcsAutoPerdacavidades()).append("\n");
		formatado.append("getPcsAutoPerdaciclo").append(" = ").append(itemGet.getPcsAutoPerdaciclo()).append("\n");
		formatado.append("getPcsAutoPerdaparadaSp").append(" = ").append(itemGet.getPcsAutoPerdaparadaSp()).append("\n");
		formatado.append("getSegAutoCiclomedio").append(" = ").append(itemGet.getSegAutoCiclomedio()).append("\n");
		formatado.append("getSegAutoPerdaciclo").append(" = ").append(itemGet.getSegAutoPerdaciclo()).append("\n");	
		formatado.append("getSegAutoTempoprodutivo").append(" = ").append(itemGet.getSegAutoTempoprodutivo()).append("\n");
		formatado.append("getSegManuTempoprodutivo").append(" = ").append(itemGet.getSegManuTempoprodutivo()).append("\n");
		formatado.append("getSegAutoRitmo").append(" = ").append(itemGet.getSegAutoRitmo()).append("\n");
		formatado.append("getSegAutoTemporefugadas").append(" = ").append(itemGet.getSegAutoTemporefugadas()).append("\n");
		formatado.append("getSegAutoTempotrabalhado").append(" = ").append(itemGet.getSegAutoTempotrabalhado()).append("\n");
		formatado.append("getSegAutoCicloimprodutivo").append(" = ").append(itemGet.getSegAutoCicloimprodutivo()).append("\n");
		formatado.append("getSegAutoCicloprodutivo").append(" = ").append(itemGet.getSegAutoCicloprodutivo()).append("\n");
		formatado.append("getSegAutoTempoparadaSp").append(" = ").append(itemGet.getSegAutoTempoparadaSp()).append("\n");
		formatado.append("getSegAutoTempoativo").append(" = ").append(itemGet.getSegAutoTempoativo()).append("\n");
		formatado.append("getSegManuTempoativo").append(" = ").append(itemGet.getSegManuTempoativo()).append("\n");
		formatado.append("getSegManuTempoparadaSp").append(" = ").append(itemGet.getSegManuTempoparadaSp()).append("\n");
		formatado.append("getSegAutoCiclopadrao").append(" = ").append(itemGet.getSegAutoCiclopadrao()).append("\n");
		formatado.append("getSegAutoPerdacav").append(" = ").append(itemGet.getSegAutoPerdacav()).append("\n");
		formatado.append("getSegManuCicloprodutivo").append(" = ").append(itemGet.getSegManuCicloprodutivo()).append("\n");
		formatado.append("getSegAutoBoas").append(" = ").append(itemGet.getSegAutoBoas()).append("\n");
		formatado.append("getSegManuCicloimprodutivo").append(" = ").append(itemGet.getSegManuCicloimprodutivo()).append("\n");
		formatado.append("getSegManuTempotrabalhado").append(" = ").append(itemGet.getSegManuTempotrabalhado()).append("\n");
		formatado.append("getSegManuTemporefugadas").append(" = ").append(itemGet.getSegManuTemporefugadas()).append("\n");
		formatado.append("getSegManuRitmo").append(" = ").append(itemGet.getSegManuRitmo()).append("\n");
		formatado.append("getSegManuPerdaciclo").append(" = ").append(itemGet.getSegManuPerdaciclo()).append("\n");
		formatado.append("getSegManuCiclomedio").append(" = ").append(itemGet.getSegManuCiclomedio()).append("\n");
		formatado.append("getSegManuCiclopadrao").append(" = ").append(itemGet.getSegManuCiclopadrao()).append("\n");
		formatado.append("getSegManuPerdacav").append(" = ").append(itemGet.getSegManuPerdacav()).append("\n");
		formatado.append("getSegManuBoas").append(" = ").append(itemGet.getSegManuBoas()).append("\n");
		formatado.append("getPcsManuPerdaparadaSp").append(" = ").append(itemGet.getPcsManuPerdaparadaSp()).append("\n");
		formatado.append("getPcsManuPerdaciclo").append(" = ").append(itemGet.getPcsManuPerdaciclo()).append("\n");
		formatado.append("getPcsManuPerdacavidades").append(" = ").append(itemGet.getPcsManuPerdacavidades()).append("\n");
		formatado.append("getPcsManuProducaobruta").append(" = ").append(itemGet.getPcsManuProducaobruta()).append("\n");
		formatado.append("getPcsManuProducaorefugada").append(" = ").append(itemGet.getPcsManuProducaorefugada()).append("\n");
		formatado.append("getPcsManuProducaoprevista").append(" = ").append(itemGet.getPcsManuProducaoprevista()).append("\n");
		formatado.append("getSegManuTempocalendario").append(" = ").append(itemGet.getSegManuTempocalendario()).append("\n");
		formatado.append("getSegAutoTempoalerta").append(" = ").append(itemGet.getSegAutoTempoalerta()).append("\n");
		formatado.append("getSegManuTempoalerta").append(" = ").append(itemGet.getSegManuTempoalerta()).append("\n");
		formatado.append("getSegAutoTempocalsempeso").append(" = ").append(itemGet.getSegAutoTempocalsempeso()).append("\n");
		formatado.append("getSegManuTempocalsempeso").append(" = ").append(itemGet.getSegManuTempocalsempeso()).append("\n");
		formatado.append("getPcsAutoCavTotal").append(" = ").append(itemGet.getPcsAutoCavTotal()).append("\n");
		formatado.append("getPcsManuCavTotal").append(" = ").append(itemGet.getPcsManuCavTotal()).append("\n");
		formatado.append("getPcsAutoCavAtivas").append(" = ").append(itemGet.getPcsAutoCavAtivas()).append("\n");
		formatado.append("getPcsManuCavAtivas").append(" = ").append(itemGet.getPcsManuCavAtivas()).append("\n");
		formatado.append("getSegAutoTempoparadamtbf").append(" = ").append(itemGet.getSegAutoTempoparadamtbf()).append("\n");

		formatado.append("getSegAutoTempoparadapao").append(" = ").append(itemGet.getSegAutoTempoparadapao()).append("\n");
		formatado.append("getSegAutoTempoparadapa").append(" = ").append(itemGet.getSegAutoTempoparadapa()).append("\n");
		formatado.append("getSegAutoTempoparadaptp").append(" = ").append(itemGet.getSegAutoTempoparadaptp()).append("\n");
		formatado.append("getSegAutoTempoparadascp").append(" = ").append(itemGet.getSegAutoTempoparadascp()).append("\n");
		formatado.append("getSegAutoTempoparadamdo").append(" = ").append(itemGet.getSegAutoTempoparadamdo()).append("\n");
		formatado.append("getGAutoPesoBruto").append(" = ").append(itemGet.getGAutoPesoBruto()).append("\n");
		formatado.append("getGManuPesoBruto").append(" = ").append(itemGet.getGManuPesoBruto()).append("\n");
		formatado.append("getSegAutoTempoparadaAb").append(" = ").append(itemGet.getSegAutoTempoparadaAb()).append("\n");
		formatado.append("getGAutoPesoLiquido").append(" = ").append(itemGet.getGAutoPesoLiquido()).append("\n");
		formatado.append("getGManuPesoLiquido").append(" = ").append(itemGet.getGManuPesoLiquido()).append("\n");
		formatado.append("getPcsAutoPerdaparadaCp").append(" = ").append(itemGet.getPcsAutoPerdaparadaCp()).append("\n");
		formatado.append("getQtAutoCicloimprodutivo").append(" = ").append(itemGet.getQtAutoCicloimprodutivo()).append("\n");
		formatado.append("getQtAutoCicloprodutivo").append(" = ").append(itemGet.getQtAutoCicloprodutivo()).append("\n");
		formatado.append("getQtAutoCicloregulagem").append(" = ").append(itemGet.getQtAutoCicloregulagem()).append("\n");
		formatado.append("getQtAutoOcoparadafds").append(" = ").append(itemGet.getQtAutoOcoparadafds()).append("\n");
		formatado.append("getQtAutoOcoparadaimprev").append(" = ").append(itemGet.getQtAutoOcoparadaimprev()).append("\n");
		formatado.append("getQtAutoOcoparadamdo").append(" = ").append(itemGet.getQtAutoOcoparadamdo()).append("\n");
		formatado.append("getQtAutoOcoparadamtbf").append(" = ").append(itemGet.getQtAutoOcoparadamtbf()).append("\n");

		formatado.append("getQtAutoOcoparadapa").append(" = ").append(itemGet.getQtAutoOcoparadapa()).append("\n");
		formatado.append("getQtAutoOcoparadapao").append(" = ").append(itemGet.getQtAutoOcoparadapao()).append("\n");
		formatado.append("getQtAutoOcoparadapp").append(" = ").append(itemGet.getQtAutoOcoparadapp()).append("\n");
		formatado.append("getQtAutoOcoparadaprev").append(" = ").append(itemGet.getQtAutoOcoparadaprev()).append("\n");
		formatado.append("getQtAutoOcoparadaptp").append(" = ").append(itemGet.getQtAutoOcoparadaptp()).append("\n");
		formatado.append("getQtAutoOcoparadaregulagem").append(" = ").append(itemGet.getQtAutoOcoparadaregulagem()).append("\n");
		formatado.append("getQtAutoOcoparadascp").append(" = ").append(itemGet.getQtAutoOcoparadascp()).append("\n");
		formatado.append("getQtAutoOcoparadaCp").append(" = ").append(itemGet.getQtAutoOcoparadaCp()).append("\n");
		formatado.append("getQtAutoOcoparadaSp").append(" = ").append(itemGet.getQtAutoOcoparadaSp()).append("\n");
		formatado.append("getQtManuCicloimprodutivo").append(" = ").append(itemGet.getQtManuCicloimprodutivo()).append("\n");
		formatado.append("getQtManuCicloprodutivo").append(" = ").append(itemGet.getQtManuCicloprodutivo()).append("\n");
		formatado.append("getQtManuCicloregulagem").append(" = ").append(itemGet.getQtManuCicloregulagem()).append("\n");
		formatado.append("getQtManuOcoparadafds").append(" = ").append(itemGet.getQtManuOcoparadafds()).append("\n");
		formatado.append("getQtManuOcoparadaimprev").append(" = ").append(itemGet.getQtManuOcoparadaimprev()).append("\n");
		formatado.append("getQtManuOcoparadamdo").append(" = ").append(itemGet.getQtManuOcoparadamdo()).append("\n");
		formatado.append("getQtManuOcoparadamtbf").append(" = ").append(itemGet.getQtManuOcoparadamtbf()).append("\n");

		formatado.append("getQtManuOcoparadapa").append(" = ").append(itemGet.getQtManuOcoparadapa()).append("\n");
		formatado.append("getQtManuOcoparadapao").append(" = ").append(itemGet.getQtManuOcoparadapao()).append("\n");
		formatado.append("getQtManuOcoparadapp").append(" = ").append(itemGet.getQtManuOcoparadapp()).append("\n");
		formatado.append("getQtManuOcoparadaprev").append(" = ").append(itemGet.getQtManuOcoparadaprev()).append("\n");
		formatado.append("getQtManuOcoparadaptp").append(" = ").append(itemGet.getQtManuOcoparadaptp()).append("\n");
		formatado.append("getQtManuOcoparadaregulagem").append(" = ").append(itemGet.getQtManuOcoparadaregulagem()).append("\n");
		formatado.append("getQtManuOcoparadascp").append(" = ").append(itemGet.getQtManuOcoparadascp()).append("\n");
		formatado.append("getQtManuOcoparadaCp").append(" = ").append(itemGet.getQtManuOcoparadaCp()).append("\n");
		formatado.append("getQtManuOcoparadaSp").append(" = ").append(itemGet.getQtManuOcoparadaSp()).append("\n");
		formatado.append("getSegAutoTempoparadafds").append(" = ").append(itemGet.getSegAutoTempoparadafds()).append("\n");
		formatado.append("getSegAutoTempoparadaimprev").append(" = ").append(itemGet.getSegAutoTempoparadaimprev()).append("\n");
		formatado.append("getSegAutoTempoparadapp").append(" = ").append(itemGet.getSegAutoTempoparadapp()).append("\n");
		formatado.append("getSegAutoTempoparadaprev").append(" = ").append(itemGet.getSegAutoTempoparadaprev()).append("\n");
		formatado.append("getSegAutoTempoparadaregulagem").append(" = ").append(itemGet.getSegAutoTempoparadaregulagem()).append("\n");
		formatado.append("getSegAutoTempoparadaCp").append(" = ").append(itemGet.getSegAutoTempoparadaCp()).append("\n");
		formatado.append("getSegManuCicloregulagem").append(" = ").append(itemGet.getSegManuCicloregulagem()).append("\n");
		formatado.append("getSegManuTempoparadafds").append(" = ").append(itemGet.getSegManuTempoparadafds()).append("\n");
		formatado.append("getSegManuTempoparadaimprev").append(" = ").append(itemGet.getSegManuTempoparadaimprev()).append("\n");
		formatado.append("getSegManuTempoparadamdo").append(" = ").append(itemGet.getSegManuTempoparadamdo()).append("\n");
		formatado.append("getSegManuTempoparadamtbf").append(" = ").append(itemGet.getSegManuTempoparadamtbf()).append("\n");

		formatado.append("getSegManuTempoparadapa").append(" = ").append(itemGet.getSegManuTempoparadapa()).append("\n");
		formatado.append("getSegManuTempoparadapao").append(" = ").append(itemGet.getSegManuTempoparadapao()).append("\n");
		formatado.append("getSegManuTempoparadapp").append(" = ").append(itemGet.getSegManuTempoparadapp()).append("\n");
		formatado.append("getSegManuTempoparadaprev").append(" = ").append(itemGet.getSegManuTempoparadaprev()).append("\n");
		formatado.append("getSegManuTempoparadaptp").append(" = ").append(itemGet.getSegManuTempoparadaptp()).append("\n");
		formatado.append("getSegManuTempoparadaregulagem").append(" = ").append(itemGet.getSegManuTempoparadaregulagem()).append("\n");
		formatado.append("getSegManuTempoparadascp").append(" = ").append(itemGet.getSegManuTempoparadascp()).append("\n");
		formatado.append("getSegManuTempoparadaCp").append(" = ").append(itemGet.getSegManuTempoparadaCp()).append("\n");
		formatado.append("getSegAutoCicloprodutivoCta").append(" = ").append(itemGet.getSegAutoCicloprodutivoCta()).append("\n");
		formatado.append("getSegAutoCicloimprodutivoCta").append(" = ").append(itemGet.getSegAutoCicloimprodutivoCta()).append("\n");
		formatado.append("getSegManuCicloprodutivoCta").append(" = ").append(itemGet.getSegManuCicloprodutivoCta()).append("\n");
		formatado.append("getSegManuCicloimprodutivoCta").append(" = ").append(itemGet.getSegManuCicloimprodutivoCta()).append("\n");
		formatado.append("getSegAutoCta").append(" = ").append(itemGet.getSegAutoCta()).append("\n");
		formatado.append("getSegManuCta").append(" = ").append(itemGet.getSegManuCta()).append("\n");
		formatado.append("getSegAutoTempoparadaCpVr").append(" = ").append(itemGet.getSegAutoTempoparadaCpVr()).append("\n");
		formatado.append("getSegAutoTempoparadaSpVr").append(" = ").append(itemGet.getSegAutoTempoparadaSpVr()).append("\n");
		formatado.append("getSegManuTempoparadaCpVr").append(" = ").append(itemGet.getSegManuTempoparadaCpVr()).append("\n");
		formatado.append("getSegManuTempoparadaSpVr").append(" = ").append(itemGet.getSegManuTempoparadaSpVr()).append("\n");
		formatado.append("getQtAutoOcoparadaCpVr").append(" = ").append(itemGet.getQtAutoOcoparadaCpVr()).append("\n");
		formatado.append("getQtAutoOcoparadaSpVr").append(" = ").append(itemGet.getQtAutoOcoparadaSpVr()).append("\n");
		formatado.append("getQtManuOcoparadaCpVr").append(" = ").append(itemGet.getQtManuOcoparadaCpVr()).append("\n");
		formatado.append("getQtManuOcoparadaSpVr").append(" = ").append(itemGet.getQtManuOcoparadaSpVr()).append("\n");
		formatado.append("getSegAutoTempoparadaDefault").append(" = ").append(itemGet.getSegAutoTempoparadaDefault()).append("\n");
		formatado.append("getSegAutoTempoparadaSemOp").append(" = ").append(itemGet.getSegAutoTempoparadaSemOp()).append("\n");
		formatado.append("getSegAutoTempoparadaSemEvt").append(" = ").append(itemGet.getSegAutoTempoparadaSemEvt()).append("\n");
		formatado.append("getSegAutoTempoparadaSemCnx").append(" = ").append(itemGet.getSegAutoTempoparadaSemCnx()).append("\n");
		formatado.append("getSegManuTempoparadaDefault").append(" = ").append(itemGet.getSegManuTempoparadaDefault()).append("\n");
		formatado.append("getSegManuTempoparadaSemOp").append(" = ").append(itemGet.getSegManuTempoparadaSemOp()).append("\n");
		formatado.append("getSegManuTempoparadaSemEvt").append(" = ").append(itemGet.getSegManuTempoparadaSemEvt()).append("\n");
		formatado.append("getSegManuTempoparadaSemCnx").append(" = ").append(itemGet.getSegManuTempoparadaSemCnx()).append("\n");
		formatado.append("getQtAutoTempoparadaDefault").append(" = ").append(itemGet.getQtAutoTempoparadaDefault()).append("\n");
		formatado.append("getQtAutoTempoparadaSemOp").append(" = ").append(itemGet.getQtAutoTempoparadaSemOp()).append("\n");
		formatado.append("getQtAutoTempoparadaSemEvt").append(" = ").append(itemGet.getQtAutoTempoparadaSemEvt()).append("\n");
		formatado.append("getQtAutoTempoparadaSemCnx").append(" = ").append(itemGet.getQtAutoTempoparadaSemCnx()).append("\n");
		formatado.append("getQtManuTempoparadaDefault").append(" = ").append(itemGet.getQtManuTempoparadaDefault()).append("\n");
		formatado.append("getQtManuTempoparadaSemOp").append(" = ").append(itemGet.getQtManuTempoparadaSemOp()).append("\n");
		formatado.append("getQtManuTempoparadaSemEvt").append(" = ").append(itemGet.getQtManuTempoparadaSemEvt()).append("\n");
		formatado.append("getQtManuTempoparadaSemCnx").append(" = ").append(itemGet.getQtManuTempoparadaSemCnx()).append("\n");
		formatado.append("getQtAutoCicloPrevisto").append(" = ").append(itemGet.getQtAutoCicloPrevisto()).append("\n");
		formatado.append("getQtManuCicloPrevisto").append(" = ").append(itemGet.getQtManuCicloPrevisto()).append("\n");

		return formatado.toString();
	}

	
	public void addDwConsol(DwConsol itemGet) {
		DwConsol itemSet = (DwConsol) this;
		
		itemSet.setPcsAutoProducaoprevista(AritmeticaUtil.somar(itemSet.getPcsAutoProducaoprevista(), itemGet.getPcsAutoProducaoprevista()) );
		itemSet.setPcsAutoProducaorefugada(AritmeticaUtil.somar(itemSet.getPcsAutoProducaorefugada(), itemGet.getPcsAutoProducaorefugada()) );
		itemSet.setPcsAutoProducaobruta(AritmeticaUtil.somar(itemSet.getPcsAutoProducaobruta(), itemGet.getPcsAutoProducaobruta()) );
		itemSet.setPcsAutoProducaoliquida(AritmeticaUtil.somar(itemSet.getPcsAutoProducaoliquida(), itemGet.getPcsAutoProducaoliquida()) );
		itemSet.setPcsAutoPerdacavidades(AritmeticaUtil.somar(itemSet.getPcsAutoPerdacavidades(), itemGet.getPcsAutoPerdacavidades()) );
		itemSet.setPcsAutoPerdaciclo(AritmeticaUtil.somar(itemSet.getPcsAutoPerdaciclo(), itemGet.getPcsAutoPerdaciclo()) );
		itemSet.setPcsAutoPerdaparadaSp(AritmeticaUtil.somar(itemSet.getPcsAutoPerdaparadaSp(), itemGet.getPcsAutoPerdaparadaSp()) );
		
		if (itemSet.getPcsAutoProducaoliquida().compareTo(BigDecimal.ZERO) == 0)
			itemSet.setPcsAutoProducaoliquida(null); // mandar null pois o GUI espera caso nao exista o valor

	}
}
