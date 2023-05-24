package idw.model.rn.consolidacao;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControleConsolidacaoMsEvtTest {

    @Test
    public void testQtThreadsMaiorQueOLimite() {
        int qtThreadsPt = ControleConsolidacaoMsEvt.MAX_THREADS_POOL_PT + 1;
        ControleConsolidacaoMsEvt controleConsolidacaoMsEvt = new ControleConsolidacaoMsEvt(qtThreadsPt, 0);
        assertTrue(controleConsolidacaoMsEvt.getQtThreadsPt() == ControleConsolidacaoMsEvt.MAX_THREADS_POOL_PT);
    }

    @Test
    public void testQtThreadsMenorQueOLimite() {
        int qtThreadsPt = ControleConsolidacaoMsEvt.MIN_THREADS_POOL_PT - 1;
        ControleConsolidacaoMsEvt controleConsolidacaoMsEvt = new ControleConsolidacaoMsEvt(qtThreadsPt, 0);
        assertTrue(controleConsolidacaoMsEvt.getQtThreadsPt() == ControleConsolidacaoMsEvt.MIN_THREADS_POOL_PT);
    }

    @Test
    public void testPassandoQtThreadComoStringMesmoResultadoUsandoInt() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("21", "");
        ControleConsolidacaoMsEvt controlePassandoInt = new ControleConsolidacaoMsEvt(21, 0);
        assertTrue(controlePassandoString.getQtThreadsPt() == controlePassandoInt.getQtThreadsPt());
    }

    @Test
    public void testPassandoQtThreadComoStringVazia() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("", "");
        assertTrue(controlePassandoString.getQtThreadsPt() == ControleConsolidacaoMsEvt.DEFAULT_THREADS_POOL_PT);
    }

    @Test
    public void testPassandoQtThreadComoStringNaoNumerica() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("abcde fdhja jkfhdka ", "");
        assertTrue(controlePassandoString.getQtThreadsPt() == ControleConsolidacaoMsEvt.DEFAULT_THREADS_POOL_PT);
    }

    @Test
    public void testQtEventosMaiorQueOLimite() {
        int qtEventos = ControleConsolidacaoMsEvt.MAX_EVENTOS_PARA_PROCESSAR + 1;
        ControleConsolidacaoMsEvt controleConsolidacaoMsEvt = new ControleConsolidacaoMsEvt(0, qtEventos);
        assertTrue(controleConsolidacaoMsEvt.getQtEventosParaProcessar() == ControleConsolidacaoMsEvt.MAX_EVENTOS_PARA_PROCESSAR);
    }

    @Test
    public void testQtEventosMenorQueOLimite() {
        int qtEventos = ControleConsolidacaoMsEvt.MIN_EVENTOS_PARA_PROCESSAR - 1;
        ControleConsolidacaoMsEvt controleConsolidacaoMsEvt = new ControleConsolidacaoMsEvt(0, qtEventos);
        assertTrue(controleConsolidacaoMsEvt.getQtEventosParaProcessar() == ControleConsolidacaoMsEvt.MIN_EVENTOS_PARA_PROCESSAR);
    }

    @Test
    public void testPassandoQtEventosComoStringMesmoResultadoUsandoInt() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("", "21");
        ControleConsolidacaoMsEvt controlePassandoInt = new ControleConsolidacaoMsEvt(0, 21);
        assertTrue(controlePassandoString.getQtEventosParaProcessar() == controlePassandoInt.getQtEventosParaProcessar());
    }

    @Test
    public void testPassandoQtEventosComoStringVazia() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("", "");
        assertTrue(controlePassandoString.getQtEventosParaProcessar() == ControleConsolidacaoMsEvt.DEFAULT_EVENTOS_PARA_PROCESSAR);
    }

    @Test
    public void testPassandoQtEventosComoStringNaoNumerica() {
        ControleConsolidacaoMsEvt controlePassandoString = new ControleConsolidacaoMsEvt("", "abcde fdhja jkfhdka ");
        assertTrue(controlePassandoString.getQtEventosParaProcessar() == ControleConsolidacaoMsEvt.DEFAULT_EVENTOS_PARA_PROCESSAR);
    }

}
