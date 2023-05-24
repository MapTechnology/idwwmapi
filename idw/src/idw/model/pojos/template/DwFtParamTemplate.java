package idw.model.pojos.template;

import idw.model.pojos.DwFtParam;


public abstract class DwFtParamTemplate extends AbstractTemplate<DwFtParam>{
	
	public enum Type {		
		CORRENTE(1),
		FLUXO_ENTRADA(2),
		FLUXO_SAIDA(3),
		TENSAO(4),
		TEMPERATURA(5),
		ENERGIACONSUMIDA(6),
		FATORPONTENCIA(7),
		CORRENTE_FASE_1(8),
		CORRENTE_FASE_2(9),
		CORRENTE_FASE_3(10),
		TENSAO_FASE_1(11),
		TENSAO_FASE_2(12),
		TENSAO_FASE_3(13),
		TENSAO_FASE_1_e_2(14),
		TENSAO_FASE_1_e_3(15),
		TENSAO_FASE_2_e_3(16),
		TEMPERATURA_ZONAS(17),
		TEMPERATURA_ZONAS_TOP(18),
		TEMPERATURA_ZONAS_BOTTOM(19),
		VELOCIDADE(20),
		PRESSAO(21),
		PRESSAOMOLDE(22),
		PRESSAOINJECAO(23),
		PRESSAOCONTRA(24),
		PRESSAORECALQUE(25),
		PRESSAO_PASSAGEM_RECALQUE(26),
		SCRIPT_PADRAO(27),
		
		/*
		 *  Parametros definidos enre 28 e 43 estão sem uso
		 *  
		 *  Em 2019-08-05 - Fabricio Oliveira ia usar estes parametros
		 *  
		 *  Em 2019-08-08 - Fabricio Oliveira mudou a lista de parametros
		 *  
		 */
		 
		FECHAMENTO_MOLDE_POSICAO_mm(28),
		FECHAMENTO_MOLDE_PRESSAO_bar(29),
		FECHAMENTO_MOLDE_FLUXO(30),
		
		ABERTURA_MOLDE_POSICAO_mm(31),
		ABERTURA_MOLDE_PRESSAO_bar(32),
		ABERTURA_MOLDE_FLUXO(33),
		
		INJECAO_MOLDE_POSICAO_mm(34),
		INJECAO_MOLDE_PRESSAO_bar(35),
		INJECAO_MOLDE_FLUXO(36),
		
		RECALQUE_PRESSAO_bar(37),
		RECALQUE_FLUXO(38),
		RECALQUE_TEMPO_s(39),
		
		DOSAGEM_POSICAO_mm(40),
		DOSAGEM_PRESSAO_bar(41),
		DOSAGEM_FLUXO(42),
		DOSAGEM_CONTRA_PRESSAO_bar(43),
		
		/*
		 * Fim sem uso 
		 */
		
		// Pressao
		PRESSAO_INJECAO_MAX_bar(44),
		PRESSAO_FORCA_FECHAMENTO_bar(45),
		PRESSAO_PROTECAO_MOLDE_bar(46),

		// tempo de ciclo
		TEMPO_INJECAO_REAL_s(47),
		TEMPO_RECALQUE_s(48),
		TEMPO_ABERTURA_PLACA_MOVEL_s(49),
		TEMPO_FECHAMENTO_PLACA_MOVEL_s(50),
		TEMPO_EXTRACAO_s(51),
		TEMPO_DOSAGEM_s(52),
		TEMPO_RESFRIAMENTO_s(53),
		TEMPO_PROTECAO_MOLDE_s(54),

		// velocidade de injecao
		VELOCIDADE_INJECAO_1_perc(55),
		VELOCIDADE_INJECAO_2_perc(56),
		VELOCIDADE_INJECAO_3_perc(57),
		VELOCIDADE_INJECAO_4_perc(58),
		VELOCIDADE_INJECAO_5_perc(59),
		VELOCIDADE_INJECAO_6_perc(60),

		// perfil contra-pressao
		POSICAO_RECALQUE_mm(61),
		CURSO_DOSAGEM_mm(62),
		ROTACAO_POR_MINUTO_ROSCA_rpm(63),
		CONTRAPRESSAO_MAX_bar(64),

		// unidade de fechamento
		MOLDE_FECHADO_PRESSAO_1_bar(65),
		MOLDE_FECHADO_VELOCIDADE_1_perc(66),
		MOLDE_FECHADO_FECHAR_MOLDE_POSICAO_1_mm(67),
		MOLDE_FECHADO_PRESSAO_2_bar(68),
		MOLDE_FECHADO_VELOCIDADE_2_perc(69),
		MOLDE_FECHADO_FECHAR_MOLDE_POSICAO_2_mm(70),
		MOLDE_FECHADO_PRESSAO_bar(71),
		MOLDE_FECHADO_VELOCIDADE_3_perc(72),
		MOLDE_FECHADO_FECHAR_MOLDE_POSICAO_3_mm(73),
		MOLDE_FECHADO_TEMPO_PROTECAO_MOLDE_s(74),
		MOLDE_FECHADO_TEMPO_RETARDO_FECHAMENTO_s(75),
		MOLDE_FECHADO_TEMPO_RETARDO_ABERTURA_s(76),

		// extracao
		EXTRACAO_POSICAO_mm(77),
		EXTRACAO_RECUO_EXTRATOR_mm(78),
		EXTRACAO_POSICAO_1_EXTRATOR_PARA_FRENTE_mm(79),
		EXTRACAO_PRESSAO_1_EXTRATOR_PARA_FRENTE_bar(80),
		EXTRACAO_VELOCIDADE_1_EXTRATOR_PARA_FRENTE_perc(81),
		EXTRACAO_POSICAO_2_EXTRATOR_PARA_FRENTE_mm(82),
		EXTRACAO_PRESSAO_2_EXTRATOR_PARA_FRENTE_bar(83),
		EXTRACAO_VELOCIDADE_2_EXTRATOR_PARA_FRENTE_perc(84),
		EXTRACAO_ATRASO_EXTRACAO_s(85),
		EXTRACAO_ATRASO_EXTRACAO_NO_FINAL_mm(86),
		EXTRACAO_POSICAO_1_ATRASO_EXTRACAO_mm_(87),
		EXTRACAO_PRESSAO_1_ATRASO_EXTRACAO_bar(88),
		EXTRACAO_VELOCIDADE_1_ATRASO_EXTRACAO_perc(89),
		EXTRACAO_PRESSAO_2_ATRASO_EXTRACAO_bar(90),
		EXTRACAO_VELOCIDADE_2_ATRASO_EXTRACAO_perc(91),
		EXTRACAO_RETARDO_NA_EXTRACAO_s(92),
		EXTRACAO_TEMPO_MOVIMENTACAO_EXTRACAO_s(93),		
		PRESSAO_DO_MATERIAL_bar(94),
		TEMPO_DE_SOPRO_s(95),
		TEMPO_DE_PRE_SOPRO_s(96),
		POSICAO_FIM_ABERTURA_mm(97),
		TEMPO_DE_REFRIGERACAO_MOLDE_s(98),
		VELOCIDADE_EXTRUSORA_per(99),
		POSICAO_SUBIDA_MANDRIL_mm(100),
		POSICAO_DESCIDA_MANDRIL_mm(101),
		CURSO_FIM_INJECAO_mm(102),
		CURSO_FIM_DOSAGEM_mm(103),
		TEMPO_DE_DESCARGA_s(104),
		
		// Parâmetros de Usinagem Mazaki (solicitado for Fabricio Oliveira - 2019-11-14)		
		VELOCIDADE_CORTE_m_por_min(105),
		VELOCIDADE_AVANÇO_m_por_min(106),
		VELOCIDADE_ROTACAO_m_por_min(107),
		POSICAO_USINAGEM_mm(108),

		// Parâmetros de Dosadores Motan (solicitado for Fabricio Oliveira - 2019-11-14)		
		QUANTIDADE_MATERIAL_DOSADO_MASTER_g(109),
		PORCENTAGEM_MATERIAL_DOSADO_MASTER_perc (110),
		
		// injetoras (solicitado for Fabricio Oliveira - 2019-11-14)
		TEMPERATURA_ZONA_2_celsius(111),
		TEMPERATURA_ZONA_3_celsius(112),
		TEMPERATURA_ZONA_4_celsius(113),
		TEMPERATURA_ZONA_5_celsius(114),
		TEMPERATURA_ZONA_6_celsius(115),
		TEMPERATURA_ZONA_7_celsius(116),
		TEMPERATURA_ZONA_8_celsius(117),
		PRESSAO_INJECAO_2_bar(118),
		PRESSAO_INJECAO_3_bar(119),
		PRESSAO_INJECAO_4_bar(120),
		PRESSAO_INJECAO_5_bar(121),
		PRESSAO_INJECAO_6_bar(122),
		POSICAO_INJECAO_2_mm(123),
		POSICAO_INJECAO_3_mm(124),
		POSICAO_INJECAO_4_mm(125),
		POSICAO_INJECAO_5_mm(126),
		
		// injetoras (solicitado for Fabricio Oliveira - 2019-12-03)
		AQUECEDOR_MOLDE_TEMPERATURA_CONTROLE_celsius(127),
		AQUECEDOR_MOLDE_TEMPERATURA_AGUA_RETORNO_celsius(128),
		AQUECEDOR_MOLDE_TEMPERATURA_AGUA_SAIDA_celsius(129),
		AQUECEDOR_MOLDE_TEMPERATURA_CONFIGURADA_celsius(130),
		AQUECEDOR_MOLDE_TEMPERATURA_ATUAL_celsius(131),

		CHILLER_TEMPERATURA_CONTROLE_celsius(132),
		CHILLER_TEMPERATURA_CONFIGURADA_celsius(133),
		CHILLER_TEMPERATURA_ATUAL_celsius(134),

		DESUMIDIFICADOR_TEMPERATURA_CONFIGURADA_celsius(135),
		DESUMIDIFICADOR_TEMPERATURA_ATUAL_celsius(136),
		DESUMIDIFICADOR_TEMPERATURA_CONTROLE_celsius(137);
		
		
		private final long id;

		private Type(long id) {
			this.id = id;
		}

		public long getId() {
			return this.id;
		}

		public static Type getType(long id) {
			for (Type type : Type.values()){
				if (type.getId() == id){
					return type;
				}
			}
			return null;
		}
		
		public boolean equals(Long id){
			return this.id == id.intValue();
		}
	}
	
	@Override
	public DwFtParam clone() {
		DwFtParam DwFtParam = (DwFtParam) this;
		
		DwFtParam clone = new DwFtParam();
		clone.setIdFtParam(DwFtParam.getIdFtParam());
		clone.setDsParametro(DwFtParam.getDsParametro());
		clone.setDsValor1(DwFtParam.getDsValor1());
		clone.setDsValor2(DwFtParam.getDsValor2());
		clone.setDsValor3(DwFtParam.getDsValor3());
		clone.setDsValor4(DwFtParam.getDsValor4());
		clone.setIsCombo(DwFtParam.getIsCombo());
		clone.setIsMaximo(DwFtParam.getIsMaximo());
		clone.setIsMeta(DwFtParam.getIsMeta());
		clone.setIsMinimo(DwFtParam.getIsMinimo());
		clone.setStValor1(DwFtParam.getStValor1());					
		clone.setStValor2(DwFtParam.getStValor2());
		clone.setStValor3(DwFtParam.getStValor3());
		clone.setStValor4(DwFtParam.getStValor4());		
				
		return clone;

	  }
	
	@Override
	public void copy(DwFtParam omFrom,boolean copiarFK){
		DwFtParam omTo = (DwFtParam) this;
		omTo.setIdFtParam(omFrom.getIdFtParam());
		omTo.setDsParametro(omFrom.getDsParametro());
		omTo.setDsValor1(omFrom.getDsValor1());
		omTo.setDsValor2(omFrom.getDsValor2());
		omTo.setDsValor3(omFrom.getDsValor3());
		omTo.setDsValor4(omFrom.getDsValor4());
		omTo.setIsCombo(omFrom.getIsCombo());
		omTo.setIsMaximo(omFrom.getIsMaximo());
		omTo.setIsMeta(omFrom.getIsMeta());
		omTo.setIsMinimo(omFrom.getIsMinimo());
		omTo.setStValor1(omFrom.getStValor1());					
		omTo.setStValor2(omFrom.getStValor2());
		omTo.setStValor3(omFrom.getStValor3());
		omTo.setStValor4(omFrom.getStValor4());			
		
	}

	@Override
	protected DwFtParam atribuir(DwFtParam itemGet, DwFtParam itemSet,
			boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwFtParam();
		
		itemSet.setDsParametro(itemGet.getDsParametro());
		itemSet.setDsValor1(itemGet.getDsValor1());
		itemSet.setDsValor2(itemGet.getDsValor2());
		itemSet.setDsValor3(itemGet.getDsValor3());
		itemSet.setDsValor4(itemGet.getDsValor4());
		itemSet.setIdFtParam(itemGet.getIdFtParam());
		itemSet.setIsCombo(itemGet.getIsCombo());
		itemSet.setIsMaximo(itemGet.getIsMaximo());
		itemSet.setIsMeta(itemGet.getIsMeta());
		itemSet.setIsMinimo(itemGet.getIsMinimo());
		itemSet.setStValor1(itemGet.getStValor1());
		itemSet.setStValor2(itemGet.getStValor2());
		itemSet.setStValor3(itemGet.getStValor3());
		itemSet.setStValor4(itemGet.getStValor4());
		
		return itemSet;
	}
}
