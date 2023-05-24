/**
 * DwConsol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsol  extends idw.idwws.DwConsolTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsolal[] dwConsolals;

    private idw.idwws.DwConsolid dwConsolid;

    private idw.idwws.DwConsollog[] dwConsollogs;

    private idw.idwws.DwConsolmedparam[] dwConsolmedparams;

    private idw.idwws.DwConsolmo[] dwConsolmos;

    private idw.idwws.DwConsolpa[] dwConsolpas;

    private idw.idwws.DwConsolpemp[] dwConsolpemps;

    private idw.idwws.DwConsolpr[] dwConsolprs;

    private idw.idwws.DwConsolre[] dwConsolres;

    private java.math.BigDecimal GAutoPesoBruto;

    private java.math.BigDecimal GAutoPesoLiquido;

    private java.math.BigDecimal GManuPesoBruto;

    private java.math.BigDecimal GManuPesoLiquido;

    private long idConsol;

    private java.math.BigDecimal pcsAutoCavAtivas;

    private java.math.BigDecimal pcsAutoCavTotal;

    private java.math.BigDecimal pcsAutoPerdacavidades;

    private java.math.BigDecimal pcsAutoPerdaciclo;

    private java.math.BigDecimal pcsAutoPerdaparadaCp;

    private java.math.BigDecimal pcsAutoPerdaparadaSp;

    private java.math.BigDecimal pcsAutoProducaobruta;

    private java.math.BigDecimal pcsAutoProducaoprevista;

    private java.math.BigDecimal pcsAutoProducaorefugada;

    private java.math.BigDecimal pcsManuCavAtivas;

    private java.math.BigDecimal pcsManuCavTotal;

    private java.math.BigDecimal pcsManuPerdacavidades;

    private java.math.BigDecimal pcsManuPerdaciclo;

    private java.math.BigDecimal pcsManuPerdaparadaSp;

    private java.math.BigDecimal pcsManuProducaobruta;

    private java.math.BigDecimal pcsManuProducaoprevista;

    private java.math.BigDecimal pcsManuProducaorefugada;

    private java.math.BigDecimal qtAutoCicloimprodutivo;

    private java.math.BigDecimal qtAutoCicloprodutivo;

    private java.math.BigDecimal qtAutoCicloregulagem;

    private java.math.BigDecimal qtAutoOcoparadaCp;

    private java.math.BigDecimal qtAutoOcoparadaCpVr;

    private java.math.BigDecimal qtAutoOcoparadaSp;

    private java.math.BigDecimal qtAutoOcoparadaSpVr;

    private java.math.BigDecimal qtAutoOcoparadafds;

    private java.math.BigDecimal qtAutoOcoparadaimprev;

    private java.math.BigDecimal qtAutoOcoparadamdo;

    private java.math.BigDecimal qtAutoOcoparadamtbf;

    private java.math.BigDecimal qtAutoOcoparadamttr;

    private java.math.BigDecimal qtAutoOcoparadapa;

    private java.math.BigDecimal qtAutoOcoparadapao;

    private java.math.BigDecimal qtAutoOcoparadapp;

    private java.math.BigDecimal qtAutoOcoparadaprev;

    private java.math.BigDecimal qtAutoOcoparadaptp;

    private java.math.BigDecimal qtAutoOcoparadaregulagem;

    private java.math.BigDecimal qtAutoOcoparadascp;

    private java.math.BigDecimal qtAutoTempoparadaDefault;

    private java.math.BigDecimal qtAutoTempoparadaSemCnx;

    private java.math.BigDecimal qtAutoTempoparadaSemEvt;

    private java.math.BigDecimal qtAutoTempoparadaSemOp;

    private java.math.BigDecimal qtManuCicloimprodutivo;

    private java.math.BigDecimal qtManuCicloprodutivo;

    private java.math.BigDecimal qtManuCicloregulagem;

    private java.math.BigDecimal qtManuOcoparadaCp;

    private java.math.BigDecimal qtManuOcoparadaCpVr;

    private java.math.BigDecimal qtManuOcoparadaSp;

    private java.math.BigDecimal qtManuOcoparadaSpVr;

    private java.math.BigDecimal qtManuOcoparadafds;

    private java.math.BigDecimal qtManuOcoparadaimprev;

    private java.math.BigDecimal qtManuOcoparadamdo;

    private java.math.BigDecimal qtManuOcoparadamtbf;

    private java.math.BigDecimal qtManuOcoparadamttr;

    private java.math.BigDecimal qtManuOcoparadapa;

    private java.math.BigDecimal qtManuOcoparadapao;

    private java.math.BigDecimal qtManuOcoparadapp;

    private java.math.BigDecimal qtManuOcoparadaprev;

    private java.math.BigDecimal qtManuOcoparadaptp;

    private java.math.BigDecimal qtManuOcoparadaregulagem;

    private java.math.BigDecimal qtManuOcoparadascp;

    private java.math.BigDecimal qtManuTempoparadaDefault;

    private java.math.BigDecimal qtManuTempoparadaSemCnx;

    private java.math.BigDecimal qtManuTempoparadaSemEvt;

    private java.math.BigDecimal qtManuTempoparadaSemOp;

    private java.math.BigDecimal segAutoBoas;

    private java.math.BigDecimal segAutoCicloimprodutivo;

    private java.math.BigDecimal segAutoCicloimprodutivoCta;

    private java.math.BigDecimal segAutoCiclomedio;

    private java.math.BigDecimal segAutoCiclopadrao;

    private java.math.BigDecimal segAutoCicloprodutivo;

    private java.math.BigDecimal segAutoCicloprodutivoCta;

    private java.math.BigDecimal segAutoCta;

    private java.math.BigDecimal segAutoPerdacav;

    private java.math.BigDecimal segAutoPerdaciclo;

    private java.math.BigDecimal segAutoRitmo;

    private java.math.BigDecimal segAutoTempoalerta;

    private java.math.BigDecimal segAutoTempoativo;

    private java.math.BigDecimal segAutoTempocalendario;

    private java.math.BigDecimal segAutoTempocalsempeso;

    private java.math.BigDecimal segAutoTempoparadaAb;

    private java.math.BigDecimal segAutoTempoparadaCp;

    private java.math.BigDecimal segAutoTempoparadaCpVr;

    private java.math.BigDecimal segAutoTempoparadaDefault;

    private java.math.BigDecimal segAutoTempoparadaSemCnx;

    private java.math.BigDecimal segAutoTempoparadaSemEvt;

    private java.math.BigDecimal segAutoTempoparadaSemOp;

    private java.math.BigDecimal segAutoTempoparadaSp;

    private java.math.BigDecimal segAutoTempoparadaSpVr;

    private java.math.BigDecimal segAutoTempoparadafds;

    private java.math.BigDecimal segAutoTempoparadaimprev;

    private java.math.BigDecimal segAutoTempoparadamdo;

    private java.math.BigDecimal segAutoTempoparadamtbf;

    private java.math.BigDecimal segAutoTempoparadamttr;

    private java.math.BigDecimal segAutoTempoparadapa;

    private java.math.BigDecimal segAutoTempoparadapao;

    private java.math.BigDecimal segAutoTempoparadapp;

    private java.math.BigDecimal segAutoTempoparadaprev;

    private java.math.BigDecimal segAutoTempoparadaptp;

    private java.math.BigDecimal segAutoTempoparadaregulagem;

    private java.math.BigDecimal segAutoTempoparadascp;

    private java.math.BigDecimal segAutoTempoprodutivo;

    private java.math.BigDecimal segAutoTemporefugadas;

    private java.math.BigDecimal segAutoTempotrabalhado;

    private java.math.BigDecimal segManuBoas;

    private java.math.BigDecimal segManuCicloimprodutivo;

    private java.math.BigDecimal segManuCicloimprodutivoCta;

    private java.math.BigDecimal segManuCiclomedio;

    private java.math.BigDecimal segManuCiclopadrao;

    private java.math.BigDecimal segManuCicloprodutivo;

    private java.math.BigDecimal segManuCicloprodutivoCta;

    private java.math.BigDecimal segManuCicloregulagem;

    private java.math.BigDecimal segManuCta;

    private java.math.BigDecimal segManuPerdacav;

    private java.math.BigDecimal segManuPerdaciclo;

    private java.math.BigDecimal segManuRitmo;

    private java.math.BigDecimal segManuTempoalerta;

    private java.math.BigDecimal segManuTempoativo;

    private java.math.BigDecimal segManuTempocalendario;

    private java.math.BigDecimal segManuTempocalsempeso;

    private java.math.BigDecimal segManuTempoparadaCp;

    private java.math.BigDecimal segManuTempoparadaCpVr;

    private java.math.BigDecimal segManuTempoparadaDefault;

    private java.math.BigDecimal segManuTempoparadaSemCnx;

    private java.math.BigDecimal segManuTempoparadaSemEvt;

    private java.math.BigDecimal segManuTempoparadaSemOp;

    private java.math.BigDecimal segManuTempoparadaSp;

    private java.math.BigDecimal segManuTempoparadaSpVr;

    private java.math.BigDecimal segManuTempoparadafds;

    private java.math.BigDecimal segManuTempoparadaimprev;

    private java.math.BigDecimal segManuTempoparadamdo;

    private java.math.BigDecimal segManuTempoparadamtbf;

    private java.math.BigDecimal segManuTempoparadamttr;

    private java.math.BigDecimal segManuTempoparadapa;

    private java.math.BigDecimal segManuTempoparadapao;

    private java.math.BigDecimal segManuTempoparadapp;

    private java.math.BigDecimal segManuTempoparadaprev;

    private java.math.BigDecimal segManuTempoparadaptp;

    private java.math.BigDecimal segManuTempoparadaregulagem;

    private java.math.BigDecimal segManuTempoparadascp;

    private java.math.BigDecimal segManuTempoprodutivo;

    private java.math.BigDecimal segManuTemporefugadas;

    private java.math.BigDecimal segManuTempotrabalhado;

    public DwConsol() {
    }

    public DwConsol(
           idw.idwws.DwConsolal[] dwConsolals,
           idw.idwws.DwConsolid dwConsolid,
           idw.idwws.DwConsollog[] dwConsollogs,
           idw.idwws.DwConsolmedparam[] dwConsolmedparams,
           idw.idwws.DwConsolmo[] dwConsolmos,
           idw.idwws.DwConsolpa[] dwConsolpas,
           idw.idwws.DwConsolpemp[] dwConsolpemps,
           idw.idwws.DwConsolpr[] dwConsolprs,
           idw.idwws.DwConsolre[] dwConsolres,
           java.math.BigDecimal GAutoPesoBruto,
           java.math.BigDecimal GAutoPesoLiquido,
           java.math.BigDecimal GManuPesoBruto,
           java.math.BigDecimal GManuPesoLiquido,
           long idConsol,
           java.math.BigDecimal pcsAutoCavAtivas,
           java.math.BigDecimal pcsAutoCavTotal,
           java.math.BigDecimal pcsAutoPerdacavidades,
           java.math.BigDecimal pcsAutoPerdaciclo,
           java.math.BigDecimal pcsAutoPerdaparadaCp,
           java.math.BigDecimal pcsAutoPerdaparadaSp,
           java.math.BigDecimal pcsAutoProducaobruta,
           java.math.BigDecimal pcsAutoProducaoprevista,
           java.math.BigDecimal pcsAutoProducaorefugada,
           java.math.BigDecimal pcsManuCavAtivas,
           java.math.BigDecimal pcsManuCavTotal,
           java.math.BigDecimal pcsManuPerdacavidades,
           java.math.BigDecimal pcsManuPerdaciclo,
           java.math.BigDecimal pcsManuPerdaparadaSp,
           java.math.BigDecimal pcsManuProducaobruta,
           java.math.BigDecimal pcsManuProducaoprevista,
           java.math.BigDecimal pcsManuProducaorefugada,
           java.math.BigDecimal qtAutoCicloimprodutivo,
           java.math.BigDecimal qtAutoCicloprodutivo,
           java.math.BigDecimal qtAutoCicloregulagem,
           java.math.BigDecimal qtAutoOcoparadaCp,
           java.math.BigDecimal qtAutoOcoparadaCpVr,
           java.math.BigDecimal qtAutoOcoparadaSp,
           java.math.BigDecimal qtAutoOcoparadaSpVr,
           java.math.BigDecimal qtAutoOcoparadafds,
           java.math.BigDecimal qtAutoOcoparadaimprev,
           java.math.BigDecimal qtAutoOcoparadamdo,
           java.math.BigDecimal qtAutoOcoparadamtbf,
           java.math.BigDecimal qtAutoOcoparadamttr,
           java.math.BigDecimal qtAutoOcoparadapa,
           java.math.BigDecimal qtAutoOcoparadapao,
           java.math.BigDecimal qtAutoOcoparadapp,
           java.math.BigDecimal qtAutoOcoparadaprev,
           java.math.BigDecimal qtAutoOcoparadaptp,
           java.math.BigDecimal qtAutoOcoparadaregulagem,
           java.math.BigDecimal qtAutoOcoparadascp,
           java.math.BigDecimal qtAutoTempoparadaDefault,
           java.math.BigDecimal qtAutoTempoparadaSemCnx,
           java.math.BigDecimal qtAutoTempoparadaSemEvt,
           java.math.BigDecimal qtAutoTempoparadaSemOp,
           java.math.BigDecimal qtManuCicloimprodutivo,
           java.math.BigDecimal qtManuCicloprodutivo,
           java.math.BigDecimal qtManuCicloregulagem,
           java.math.BigDecimal qtManuOcoparadaCp,
           java.math.BigDecimal qtManuOcoparadaCpVr,
           java.math.BigDecimal qtManuOcoparadaSp,
           java.math.BigDecimal qtManuOcoparadaSpVr,
           java.math.BigDecimal qtManuOcoparadafds,
           java.math.BigDecimal qtManuOcoparadaimprev,
           java.math.BigDecimal qtManuOcoparadamdo,
           java.math.BigDecimal qtManuOcoparadamtbf,
           java.math.BigDecimal qtManuOcoparadamttr,
           java.math.BigDecimal qtManuOcoparadapa,
           java.math.BigDecimal qtManuOcoparadapao,
           java.math.BigDecimal qtManuOcoparadapp,
           java.math.BigDecimal qtManuOcoparadaprev,
           java.math.BigDecimal qtManuOcoparadaptp,
           java.math.BigDecimal qtManuOcoparadaregulagem,
           java.math.BigDecimal qtManuOcoparadascp,
           java.math.BigDecimal qtManuTempoparadaDefault,
           java.math.BigDecimal qtManuTempoparadaSemCnx,
           java.math.BigDecimal qtManuTempoparadaSemEvt,
           java.math.BigDecimal qtManuTempoparadaSemOp,
           java.math.BigDecimal segAutoBoas,
           java.math.BigDecimal segAutoCicloimprodutivo,
           java.math.BigDecimal segAutoCicloimprodutivoCta,
           java.math.BigDecimal segAutoCiclomedio,
           java.math.BigDecimal segAutoCiclopadrao,
           java.math.BigDecimal segAutoCicloprodutivo,
           java.math.BigDecimal segAutoCicloprodutivoCta,
           java.math.BigDecimal segAutoCta,
           java.math.BigDecimal segAutoPerdacav,
           java.math.BigDecimal segAutoPerdaciclo,
           java.math.BigDecimal segAutoRitmo,
           java.math.BigDecimal segAutoTempoalerta,
           java.math.BigDecimal segAutoTempoativo,
           java.math.BigDecimal segAutoTempocalendario,
           java.math.BigDecimal segAutoTempocalsempeso,
           java.math.BigDecimal segAutoTempoparadaAb,
           java.math.BigDecimal segAutoTempoparadaCp,
           java.math.BigDecimal segAutoTempoparadaCpVr,
           java.math.BigDecimal segAutoTempoparadaDefault,
           java.math.BigDecimal segAutoTempoparadaSemCnx,
           java.math.BigDecimal segAutoTempoparadaSemEvt,
           java.math.BigDecimal segAutoTempoparadaSemOp,
           java.math.BigDecimal segAutoTempoparadaSp,
           java.math.BigDecimal segAutoTempoparadaSpVr,
           java.math.BigDecimal segAutoTempoparadafds,
           java.math.BigDecimal segAutoTempoparadaimprev,
           java.math.BigDecimal segAutoTempoparadamdo,
           java.math.BigDecimal segAutoTempoparadamtbf,
           java.math.BigDecimal segAutoTempoparadamttr,
           java.math.BigDecimal segAutoTempoparadapa,
           java.math.BigDecimal segAutoTempoparadapao,
           java.math.BigDecimal segAutoTempoparadapp,
           java.math.BigDecimal segAutoTempoparadaprev,
           java.math.BigDecimal segAutoTempoparadaptp,
           java.math.BigDecimal segAutoTempoparadaregulagem,
           java.math.BigDecimal segAutoTempoparadascp,
           java.math.BigDecimal segAutoTempoprodutivo,
           java.math.BigDecimal segAutoTemporefugadas,
           java.math.BigDecimal segAutoTempotrabalhado,
           java.math.BigDecimal segManuBoas,
           java.math.BigDecimal segManuCicloimprodutivo,
           java.math.BigDecimal segManuCicloimprodutivoCta,
           java.math.BigDecimal segManuCiclomedio,
           java.math.BigDecimal segManuCiclopadrao,
           java.math.BigDecimal segManuCicloprodutivo,
           java.math.BigDecimal segManuCicloprodutivoCta,
           java.math.BigDecimal segManuCicloregulagem,
           java.math.BigDecimal segManuCta,
           java.math.BigDecimal segManuPerdacav,
           java.math.BigDecimal segManuPerdaciclo,
           java.math.BigDecimal segManuRitmo,
           java.math.BigDecimal segManuTempoalerta,
           java.math.BigDecimal segManuTempoativo,
           java.math.BigDecimal segManuTempocalendario,
           java.math.BigDecimal segManuTempocalsempeso,
           java.math.BigDecimal segManuTempoparadaCp,
           java.math.BigDecimal segManuTempoparadaCpVr,
           java.math.BigDecimal segManuTempoparadaDefault,
           java.math.BigDecimal segManuTempoparadaSemCnx,
           java.math.BigDecimal segManuTempoparadaSemEvt,
           java.math.BigDecimal segManuTempoparadaSemOp,
           java.math.BigDecimal segManuTempoparadaSp,
           java.math.BigDecimal segManuTempoparadaSpVr,
           java.math.BigDecimal segManuTempoparadafds,
           java.math.BigDecimal segManuTempoparadaimprev,
           java.math.BigDecimal segManuTempoparadamdo,
           java.math.BigDecimal segManuTempoparadamtbf,
           java.math.BigDecimal segManuTempoparadamttr,
           java.math.BigDecimal segManuTempoparadapa,
           java.math.BigDecimal segManuTempoparadapao,
           java.math.BigDecimal segManuTempoparadapp,
           java.math.BigDecimal segManuTempoparadaprev,
           java.math.BigDecimal segManuTempoparadaptp,
           java.math.BigDecimal segManuTempoparadaregulagem,
           java.math.BigDecimal segManuTempoparadascp,
           java.math.BigDecimal segManuTempoprodutivo,
           java.math.BigDecimal segManuTemporefugadas,
           java.math.BigDecimal segManuTempotrabalhado) {
        this.dwConsolals = dwConsolals;
        this.dwConsolid = dwConsolid;
        this.dwConsollogs = dwConsollogs;
        this.dwConsolmedparams = dwConsolmedparams;
        this.dwConsolmos = dwConsolmos;
        this.dwConsolpas = dwConsolpas;
        this.dwConsolpemps = dwConsolpemps;
        this.dwConsolprs = dwConsolprs;
        this.dwConsolres = dwConsolres;
        this.GAutoPesoBruto = GAutoPesoBruto;
        this.GAutoPesoLiquido = GAutoPesoLiquido;
        this.GManuPesoBruto = GManuPesoBruto;
        this.GManuPesoLiquido = GManuPesoLiquido;
        this.idConsol = idConsol;
        this.pcsAutoCavAtivas = pcsAutoCavAtivas;
        this.pcsAutoCavTotal = pcsAutoCavTotal;
        this.pcsAutoPerdacavidades = pcsAutoPerdacavidades;
        this.pcsAutoPerdaciclo = pcsAutoPerdaciclo;
        this.pcsAutoPerdaparadaCp = pcsAutoPerdaparadaCp;
        this.pcsAutoPerdaparadaSp = pcsAutoPerdaparadaSp;
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
        this.pcsAutoProducaoprevista = pcsAutoProducaoprevista;
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
        this.pcsManuCavAtivas = pcsManuCavAtivas;
        this.pcsManuCavTotal = pcsManuCavTotal;
        this.pcsManuPerdacavidades = pcsManuPerdacavidades;
        this.pcsManuPerdaciclo = pcsManuPerdaciclo;
        this.pcsManuPerdaparadaSp = pcsManuPerdaparadaSp;
        this.pcsManuProducaobruta = pcsManuProducaobruta;
        this.pcsManuProducaoprevista = pcsManuProducaoprevista;
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
        this.qtAutoCicloimprodutivo = qtAutoCicloimprodutivo;
        this.qtAutoCicloprodutivo = qtAutoCicloprodutivo;
        this.qtAutoCicloregulagem = qtAutoCicloregulagem;
        this.qtAutoOcoparadaCp = qtAutoOcoparadaCp;
        this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
        this.qtAutoOcoparadaSp = qtAutoOcoparadaSp;
        this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
        this.qtAutoOcoparadafds = qtAutoOcoparadafds;
        this.qtAutoOcoparadaimprev = qtAutoOcoparadaimprev;
        this.qtAutoOcoparadamdo = qtAutoOcoparadamdo;
        this.qtAutoOcoparadamtbf = qtAutoOcoparadamtbf;
        this.qtAutoOcoparadamttr = qtAutoOcoparadamttr;
        this.qtAutoOcoparadapa = qtAutoOcoparadapa;
        this.qtAutoOcoparadapao = qtAutoOcoparadapao;
        this.qtAutoOcoparadapp = qtAutoOcoparadapp;
        this.qtAutoOcoparadaprev = qtAutoOcoparadaprev;
        this.qtAutoOcoparadaptp = qtAutoOcoparadaptp;
        this.qtAutoOcoparadaregulagem = qtAutoOcoparadaregulagem;
        this.qtAutoOcoparadascp = qtAutoOcoparadascp;
        this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
        this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
        this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
        this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
        this.qtManuCicloimprodutivo = qtManuCicloimprodutivo;
        this.qtManuCicloprodutivo = qtManuCicloprodutivo;
        this.qtManuCicloregulagem = qtManuCicloregulagem;
        this.qtManuOcoparadaCp = qtManuOcoparadaCp;
        this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
        this.qtManuOcoparadaSp = qtManuOcoparadaSp;
        this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
        this.qtManuOcoparadafds = qtManuOcoparadafds;
        this.qtManuOcoparadaimprev = qtManuOcoparadaimprev;
        this.qtManuOcoparadamdo = qtManuOcoparadamdo;
        this.qtManuOcoparadamtbf = qtManuOcoparadamtbf;
        this.qtManuOcoparadamttr = qtManuOcoparadamttr;
        this.qtManuOcoparadapa = qtManuOcoparadapa;
        this.qtManuOcoparadapao = qtManuOcoparadapao;
        this.qtManuOcoparadapp = qtManuOcoparadapp;
        this.qtManuOcoparadaprev = qtManuOcoparadaprev;
        this.qtManuOcoparadaptp = qtManuOcoparadaptp;
        this.qtManuOcoparadaregulagem = qtManuOcoparadaregulagem;
        this.qtManuOcoparadascp = qtManuOcoparadascp;
        this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
        this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
        this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
        this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
        this.segAutoBoas = segAutoBoas;
        this.segAutoCicloimprodutivo = segAutoCicloimprodutivo;
        this.segAutoCicloimprodutivoCta = segAutoCicloimprodutivoCta;
        this.segAutoCiclomedio = segAutoCiclomedio;
        this.segAutoCiclopadrao = segAutoCiclopadrao;
        this.segAutoCicloprodutivo = segAutoCicloprodutivo;
        this.segAutoCicloprodutivoCta = segAutoCicloprodutivoCta;
        this.segAutoCta = segAutoCta;
        this.segAutoPerdacav = segAutoPerdacav;
        this.segAutoPerdaciclo = segAutoPerdaciclo;
        this.segAutoRitmo = segAutoRitmo;
        this.segAutoTempoalerta = segAutoTempoalerta;
        this.segAutoTempoativo = segAutoTempoativo;
        this.segAutoTempocalendario = segAutoTempocalendario;
        this.segAutoTempocalsempeso = segAutoTempocalsempeso;
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
        this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
        this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
        this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
        this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
        this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
        this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
        this.segAutoTempoparadafds = segAutoTempoparadafds;
        this.segAutoTempoparadaimprev = segAutoTempoparadaimprev;
        this.segAutoTempoparadamdo = segAutoTempoparadamdo;
        this.segAutoTempoparadamtbf = segAutoTempoparadamtbf;
        this.segAutoTempoparadamttr = segAutoTempoparadamttr;
        this.segAutoTempoparadapa = segAutoTempoparadapa;
        this.segAutoTempoparadapao = segAutoTempoparadapao;
        this.segAutoTempoparadapp = segAutoTempoparadapp;
        this.segAutoTempoparadaprev = segAutoTempoparadaprev;
        this.segAutoTempoparadaptp = segAutoTempoparadaptp;
        this.segAutoTempoparadaregulagem = segAutoTempoparadaregulagem;
        this.segAutoTempoparadascp = segAutoTempoparadascp;
        this.segAutoTempoprodutivo = segAutoTempoprodutivo;
        this.segAutoTemporefugadas = segAutoTemporefugadas;
        this.segAutoTempotrabalhado = segAutoTempotrabalhado;
        this.segManuBoas = segManuBoas;
        this.segManuCicloimprodutivo = segManuCicloimprodutivo;
        this.segManuCicloimprodutivoCta = segManuCicloimprodutivoCta;
        this.segManuCiclomedio = segManuCiclomedio;
        this.segManuCiclopadrao = segManuCiclopadrao;
        this.segManuCicloprodutivo = segManuCicloprodutivo;
        this.segManuCicloprodutivoCta = segManuCicloprodutivoCta;
        this.segManuCicloregulagem = segManuCicloregulagem;
        this.segManuCta = segManuCta;
        this.segManuPerdacav = segManuPerdacav;
        this.segManuPerdaciclo = segManuPerdaciclo;
        this.segManuRitmo = segManuRitmo;
        this.segManuTempoalerta = segManuTempoalerta;
        this.segManuTempoativo = segManuTempoativo;
        this.segManuTempocalendario = segManuTempocalendario;
        this.segManuTempocalsempeso = segManuTempocalsempeso;
        this.segManuTempoparadaCp = segManuTempoparadaCp;
        this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
        this.segManuTempoparadaDefault = segManuTempoparadaDefault;
        this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
        this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
        this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
        this.segManuTempoparadaSp = segManuTempoparadaSp;
        this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
        this.segManuTempoparadafds = segManuTempoparadafds;
        this.segManuTempoparadaimprev = segManuTempoparadaimprev;
        this.segManuTempoparadamdo = segManuTempoparadamdo;
        this.segManuTempoparadamtbf = segManuTempoparadamtbf;
        this.segManuTempoparadamttr = segManuTempoparadamttr;
        this.segManuTempoparadapa = segManuTempoparadapa;
        this.segManuTempoparadapao = segManuTempoparadapao;
        this.segManuTempoparadapp = segManuTempoparadapp;
        this.segManuTempoparadaprev = segManuTempoparadaprev;
        this.segManuTempoparadaptp = segManuTempoparadaptp;
        this.segManuTempoparadaregulagem = segManuTempoparadaregulagem;
        this.segManuTempoparadascp = segManuTempoparadascp;
        this.segManuTempoprodutivo = segManuTempoprodutivo;
        this.segManuTemporefugadas = segManuTemporefugadas;
        this.segManuTempotrabalhado = segManuTempotrabalhado;
    }


    /**
     * Gets the dwConsolals value for this DwConsol.
     * 
     * @return dwConsolals
     */
    public idw.idwws.DwConsolal[] getDwConsolals() {
        return dwConsolals;
    }


    /**
     * Sets the dwConsolals value for this DwConsol.
     * 
     * @param dwConsolals
     */
    public void setDwConsolals(idw.idwws.DwConsolal[] dwConsolals) {
        this.dwConsolals = dwConsolals;
    }

    public idw.idwws.DwConsolal getDwConsolals(int i) {
        return this.dwConsolals[i];
    }

    public void setDwConsolals(int i, idw.idwws.DwConsolal _value) {
        this.dwConsolals[i] = _value;
    }


    /**
     * Gets the dwConsolid value for this DwConsol.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolid getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this DwConsol.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolid dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the dwConsollogs value for this DwConsol.
     * 
     * @return dwConsollogs
     */
    public idw.idwws.DwConsollog[] getDwConsollogs() {
        return dwConsollogs;
    }


    /**
     * Sets the dwConsollogs value for this DwConsol.
     * 
     * @param dwConsollogs
     */
    public void setDwConsollogs(idw.idwws.DwConsollog[] dwConsollogs) {
        this.dwConsollogs = dwConsollogs;
    }

    public idw.idwws.DwConsollog getDwConsollogs(int i) {
        return this.dwConsollogs[i];
    }

    public void setDwConsollogs(int i, idw.idwws.DwConsollog _value) {
        this.dwConsollogs[i] = _value;
    }


    /**
     * Gets the dwConsolmedparams value for this DwConsol.
     * 
     * @return dwConsolmedparams
     */
    public idw.idwws.DwConsolmedparam[] getDwConsolmedparams() {
        return dwConsolmedparams;
    }


    /**
     * Sets the dwConsolmedparams value for this DwConsol.
     * 
     * @param dwConsolmedparams
     */
    public void setDwConsolmedparams(idw.idwws.DwConsolmedparam[] dwConsolmedparams) {
        this.dwConsolmedparams = dwConsolmedparams;
    }

    public idw.idwws.DwConsolmedparam getDwConsolmedparams(int i) {
        return this.dwConsolmedparams[i];
    }

    public void setDwConsolmedparams(int i, idw.idwws.DwConsolmedparam _value) {
        this.dwConsolmedparams[i] = _value;
    }


    /**
     * Gets the dwConsolmos value for this DwConsol.
     * 
     * @return dwConsolmos
     */
    public idw.idwws.DwConsolmo[] getDwConsolmos() {
        return dwConsolmos;
    }


    /**
     * Sets the dwConsolmos value for this DwConsol.
     * 
     * @param dwConsolmos
     */
    public void setDwConsolmos(idw.idwws.DwConsolmo[] dwConsolmos) {
        this.dwConsolmos = dwConsolmos;
    }

    public idw.idwws.DwConsolmo getDwConsolmos(int i) {
        return this.dwConsolmos[i];
    }

    public void setDwConsolmos(int i, idw.idwws.DwConsolmo _value) {
        this.dwConsolmos[i] = _value;
    }


    /**
     * Gets the dwConsolpas value for this DwConsol.
     * 
     * @return dwConsolpas
     */
    public idw.idwws.DwConsolpa[] getDwConsolpas() {
        return dwConsolpas;
    }


    /**
     * Sets the dwConsolpas value for this DwConsol.
     * 
     * @param dwConsolpas
     */
    public void setDwConsolpas(idw.idwws.DwConsolpa[] dwConsolpas) {
        this.dwConsolpas = dwConsolpas;
    }

    public idw.idwws.DwConsolpa getDwConsolpas(int i) {
        return this.dwConsolpas[i];
    }

    public void setDwConsolpas(int i, idw.idwws.DwConsolpa _value) {
        this.dwConsolpas[i] = _value;
    }


    /**
     * Gets the dwConsolpemps value for this DwConsol.
     * 
     * @return dwConsolpemps
     */
    public idw.idwws.DwConsolpemp[] getDwConsolpemps() {
        return dwConsolpemps;
    }


    /**
     * Sets the dwConsolpemps value for this DwConsol.
     * 
     * @param dwConsolpemps
     */
    public void setDwConsolpemps(idw.idwws.DwConsolpemp[] dwConsolpemps) {
        this.dwConsolpemps = dwConsolpemps;
    }

    public idw.idwws.DwConsolpemp getDwConsolpemps(int i) {
        return this.dwConsolpemps[i];
    }

    public void setDwConsolpemps(int i, idw.idwws.DwConsolpemp _value) {
        this.dwConsolpemps[i] = _value;
    }


    /**
     * Gets the dwConsolprs value for this DwConsol.
     * 
     * @return dwConsolprs
     */
    public idw.idwws.DwConsolpr[] getDwConsolprs() {
        return dwConsolprs;
    }


    /**
     * Sets the dwConsolprs value for this DwConsol.
     * 
     * @param dwConsolprs
     */
    public void setDwConsolprs(idw.idwws.DwConsolpr[] dwConsolprs) {
        this.dwConsolprs = dwConsolprs;
    }

    public idw.idwws.DwConsolpr getDwConsolprs(int i) {
        return this.dwConsolprs[i];
    }

    public void setDwConsolprs(int i, idw.idwws.DwConsolpr _value) {
        this.dwConsolprs[i] = _value;
    }


    /**
     * Gets the dwConsolres value for this DwConsol.
     * 
     * @return dwConsolres
     */
    public idw.idwws.DwConsolre[] getDwConsolres() {
        return dwConsolres;
    }


    /**
     * Sets the dwConsolres value for this DwConsol.
     * 
     * @param dwConsolres
     */
    public void setDwConsolres(idw.idwws.DwConsolre[] dwConsolres) {
        this.dwConsolres = dwConsolres;
    }

    public idw.idwws.DwConsolre getDwConsolres(int i) {
        return this.dwConsolres[i];
    }

    public void setDwConsolres(int i, idw.idwws.DwConsolre _value) {
        this.dwConsolres[i] = _value;
    }


    /**
     * Gets the GAutoPesoBruto value for this DwConsol.
     * 
     * @return GAutoPesoBruto
     */
    public java.math.BigDecimal getGAutoPesoBruto() {
        return GAutoPesoBruto;
    }


    /**
     * Sets the GAutoPesoBruto value for this DwConsol.
     * 
     * @param GAutoPesoBruto
     */
    public void setGAutoPesoBruto(java.math.BigDecimal GAutoPesoBruto) {
        this.GAutoPesoBruto = GAutoPesoBruto;
    }


    /**
     * Gets the GAutoPesoLiquido value for this DwConsol.
     * 
     * @return GAutoPesoLiquido
     */
    public java.math.BigDecimal getGAutoPesoLiquido() {
        return GAutoPesoLiquido;
    }


    /**
     * Sets the GAutoPesoLiquido value for this DwConsol.
     * 
     * @param GAutoPesoLiquido
     */
    public void setGAutoPesoLiquido(java.math.BigDecimal GAutoPesoLiquido) {
        this.GAutoPesoLiquido = GAutoPesoLiquido;
    }


    /**
     * Gets the GManuPesoBruto value for this DwConsol.
     * 
     * @return GManuPesoBruto
     */
    public java.math.BigDecimal getGManuPesoBruto() {
        return GManuPesoBruto;
    }


    /**
     * Sets the GManuPesoBruto value for this DwConsol.
     * 
     * @param GManuPesoBruto
     */
    public void setGManuPesoBruto(java.math.BigDecimal GManuPesoBruto) {
        this.GManuPesoBruto = GManuPesoBruto;
    }


    /**
     * Gets the GManuPesoLiquido value for this DwConsol.
     * 
     * @return GManuPesoLiquido
     */
    public java.math.BigDecimal getGManuPesoLiquido() {
        return GManuPesoLiquido;
    }


    /**
     * Sets the GManuPesoLiquido value for this DwConsol.
     * 
     * @param GManuPesoLiquido
     */
    public void setGManuPesoLiquido(java.math.BigDecimal GManuPesoLiquido) {
        this.GManuPesoLiquido = GManuPesoLiquido;
    }


    /**
     * Gets the idConsol value for this DwConsol.
     * 
     * @return idConsol
     */
    public long getIdConsol() {
        return idConsol;
    }


    /**
     * Sets the idConsol value for this DwConsol.
     * 
     * @param idConsol
     */
    public void setIdConsol(long idConsol) {
        this.idConsol = idConsol;
    }


    /**
     * Gets the pcsAutoCavAtivas value for this DwConsol.
     * 
     * @return pcsAutoCavAtivas
     */
    public java.math.BigDecimal getPcsAutoCavAtivas() {
        return pcsAutoCavAtivas;
    }


    /**
     * Sets the pcsAutoCavAtivas value for this DwConsol.
     * 
     * @param pcsAutoCavAtivas
     */
    public void setPcsAutoCavAtivas(java.math.BigDecimal pcsAutoCavAtivas) {
        this.pcsAutoCavAtivas = pcsAutoCavAtivas;
    }


    /**
     * Gets the pcsAutoCavTotal value for this DwConsol.
     * 
     * @return pcsAutoCavTotal
     */
    public java.math.BigDecimal getPcsAutoCavTotal() {
        return pcsAutoCavTotal;
    }


    /**
     * Sets the pcsAutoCavTotal value for this DwConsol.
     * 
     * @param pcsAutoCavTotal
     */
    public void setPcsAutoCavTotal(java.math.BigDecimal pcsAutoCavTotal) {
        this.pcsAutoCavTotal = pcsAutoCavTotal;
    }


    /**
     * Gets the pcsAutoPerdacavidades value for this DwConsol.
     * 
     * @return pcsAutoPerdacavidades
     */
    public java.math.BigDecimal getPcsAutoPerdacavidades() {
        return pcsAutoPerdacavidades;
    }


    /**
     * Sets the pcsAutoPerdacavidades value for this DwConsol.
     * 
     * @param pcsAutoPerdacavidades
     */
    public void setPcsAutoPerdacavidades(java.math.BigDecimal pcsAutoPerdacavidades) {
        this.pcsAutoPerdacavidades = pcsAutoPerdacavidades;
    }


    /**
     * Gets the pcsAutoPerdaciclo value for this DwConsol.
     * 
     * @return pcsAutoPerdaciclo
     */
    public java.math.BigDecimal getPcsAutoPerdaciclo() {
        return pcsAutoPerdaciclo;
    }


    /**
     * Sets the pcsAutoPerdaciclo value for this DwConsol.
     * 
     * @param pcsAutoPerdaciclo
     */
    public void setPcsAutoPerdaciclo(java.math.BigDecimal pcsAutoPerdaciclo) {
        this.pcsAutoPerdaciclo = pcsAutoPerdaciclo;
    }


    /**
     * Gets the pcsAutoPerdaparadaCp value for this DwConsol.
     * 
     * @return pcsAutoPerdaparadaCp
     */
    public java.math.BigDecimal getPcsAutoPerdaparadaCp() {
        return pcsAutoPerdaparadaCp;
    }


    /**
     * Sets the pcsAutoPerdaparadaCp value for this DwConsol.
     * 
     * @param pcsAutoPerdaparadaCp
     */
    public void setPcsAutoPerdaparadaCp(java.math.BigDecimal pcsAutoPerdaparadaCp) {
        this.pcsAutoPerdaparadaCp = pcsAutoPerdaparadaCp;
    }


    /**
     * Gets the pcsAutoPerdaparadaSp value for this DwConsol.
     * 
     * @return pcsAutoPerdaparadaSp
     */
    public java.math.BigDecimal getPcsAutoPerdaparadaSp() {
        return pcsAutoPerdaparadaSp;
    }


    /**
     * Sets the pcsAutoPerdaparadaSp value for this DwConsol.
     * 
     * @param pcsAutoPerdaparadaSp
     */
    public void setPcsAutoPerdaparadaSp(java.math.BigDecimal pcsAutoPerdaparadaSp) {
        this.pcsAutoPerdaparadaSp = pcsAutoPerdaparadaSp;
    }


    /**
     * Gets the pcsAutoProducaobruta value for this DwConsol.
     * 
     * @return pcsAutoProducaobruta
     */
    public java.math.BigDecimal getPcsAutoProducaobruta() {
        return pcsAutoProducaobruta;
    }


    /**
     * Sets the pcsAutoProducaobruta value for this DwConsol.
     * 
     * @param pcsAutoProducaobruta
     */
    public void setPcsAutoProducaobruta(java.math.BigDecimal pcsAutoProducaobruta) {
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
    }


    /**
     * Gets the pcsAutoProducaoprevista value for this DwConsol.
     * 
     * @return pcsAutoProducaoprevista
     */
    public java.math.BigDecimal getPcsAutoProducaoprevista() {
        return pcsAutoProducaoprevista;
    }


    /**
     * Sets the pcsAutoProducaoprevista value for this DwConsol.
     * 
     * @param pcsAutoProducaoprevista
     */
    public void setPcsAutoProducaoprevista(java.math.BigDecimal pcsAutoProducaoprevista) {
        this.pcsAutoProducaoprevista = pcsAutoProducaoprevista;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsol.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.math.BigDecimal getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsol.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.math.BigDecimal pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuCavAtivas value for this DwConsol.
     * 
     * @return pcsManuCavAtivas
     */
    public java.math.BigDecimal getPcsManuCavAtivas() {
        return pcsManuCavAtivas;
    }


    /**
     * Sets the pcsManuCavAtivas value for this DwConsol.
     * 
     * @param pcsManuCavAtivas
     */
    public void setPcsManuCavAtivas(java.math.BigDecimal pcsManuCavAtivas) {
        this.pcsManuCavAtivas = pcsManuCavAtivas;
    }


    /**
     * Gets the pcsManuCavTotal value for this DwConsol.
     * 
     * @return pcsManuCavTotal
     */
    public java.math.BigDecimal getPcsManuCavTotal() {
        return pcsManuCavTotal;
    }


    /**
     * Sets the pcsManuCavTotal value for this DwConsol.
     * 
     * @param pcsManuCavTotal
     */
    public void setPcsManuCavTotal(java.math.BigDecimal pcsManuCavTotal) {
        this.pcsManuCavTotal = pcsManuCavTotal;
    }


    /**
     * Gets the pcsManuPerdacavidades value for this DwConsol.
     * 
     * @return pcsManuPerdacavidades
     */
    public java.math.BigDecimal getPcsManuPerdacavidades() {
        return pcsManuPerdacavidades;
    }


    /**
     * Sets the pcsManuPerdacavidades value for this DwConsol.
     * 
     * @param pcsManuPerdacavidades
     */
    public void setPcsManuPerdacavidades(java.math.BigDecimal pcsManuPerdacavidades) {
        this.pcsManuPerdacavidades = pcsManuPerdacavidades;
    }


    /**
     * Gets the pcsManuPerdaciclo value for this DwConsol.
     * 
     * @return pcsManuPerdaciclo
     */
    public java.math.BigDecimal getPcsManuPerdaciclo() {
        return pcsManuPerdaciclo;
    }


    /**
     * Sets the pcsManuPerdaciclo value for this DwConsol.
     * 
     * @param pcsManuPerdaciclo
     */
    public void setPcsManuPerdaciclo(java.math.BigDecimal pcsManuPerdaciclo) {
        this.pcsManuPerdaciclo = pcsManuPerdaciclo;
    }


    /**
     * Gets the pcsManuPerdaparadaSp value for this DwConsol.
     * 
     * @return pcsManuPerdaparadaSp
     */
    public java.math.BigDecimal getPcsManuPerdaparadaSp() {
        return pcsManuPerdaparadaSp;
    }


    /**
     * Sets the pcsManuPerdaparadaSp value for this DwConsol.
     * 
     * @param pcsManuPerdaparadaSp
     */
    public void setPcsManuPerdaparadaSp(java.math.BigDecimal pcsManuPerdaparadaSp) {
        this.pcsManuPerdaparadaSp = pcsManuPerdaparadaSp;
    }


    /**
     * Gets the pcsManuProducaobruta value for this DwConsol.
     * 
     * @return pcsManuProducaobruta
     */
    public java.math.BigDecimal getPcsManuProducaobruta() {
        return pcsManuProducaobruta;
    }


    /**
     * Sets the pcsManuProducaobruta value for this DwConsol.
     * 
     * @param pcsManuProducaobruta
     */
    public void setPcsManuProducaobruta(java.math.BigDecimal pcsManuProducaobruta) {
        this.pcsManuProducaobruta = pcsManuProducaobruta;
    }


    /**
     * Gets the pcsManuProducaoprevista value for this DwConsol.
     * 
     * @return pcsManuProducaoprevista
     */
    public java.math.BigDecimal getPcsManuProducaoprevista() {
        return pcsManuProducaoprevista;
    }


    /**
     * Sets the pcsManuProducaoprevista value for this DwConsol.
     * 
     * @param pcsManuProducaoprevista
     */
    public void setPcsManuProducaoprevista(java.math.BigDecimal pcsManuProducaoprevista) {
        this.pcsManuProducaoprevista = pcsManuProducaoprevista;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsol.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.math.BigDecimal getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsol.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.math.BigDecimal pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the qtAutoCicloimprodutivo value for this DwConsol.
     * 
     * @return qtAutoCicloimprodutivo
     */
    public java.math.BigDecimal getQtAutoCicloimprodutivo() {
        return qtAutoCicloimprodutivo;
    }


    /**
     * Sets the qtAutoCicloimprodutivo value for this DwConsol.
     * 
     * @param qtAutoCicloimprodutivo
     */
    public void setQtAutoCicloimprodutivo(java.math.BigDecimal qtAutoCicloimprodutivo) {
        this.qtAutoCicloimprodutivo = qtAutoCicloimprodutivo;
    }


    /**
     * Gets the qtAutoCicloprodutivo value for this DwConsol.
     * 
     * @return qtAutoCicloprodutivo
     */
    public java.math.BigDecimal getQtAutoCicloprodutivo() {
        return qtAutoCicloprodutivo;
    }


    /**
     * Sets the qtAutoCicloprodutivo value for this DwConsol.
     * 
     * @param qtAutoCicloprodutivo
     */
    public void setQtAutoCicloprodutivo(java.math.BigDecimal qtAutoCicloprodutivo) {
        this.qtAutoCicloprodutivo = qtAutoCicloprodutivo;
    }


    /**
     * Gets the qtAutoCicloregulagem value for this DwConsol.
     * 
     * @return qtAutoCicloregulagem
     */
    public java.math.BigDecimal getQtAutoCicloregulagem() {
        return qtAutoCicloregulagem;
    }


    /**
     * Sets the qtAutoCicloregulagem value for this DwConsol.
     * 
     * @param qtAutoCicloregulagem
     */
    public void setQtAutoCicloregulagem(java.math.BigDecimal qtAutoCicloregulagem) {
        this.qtAutoCicloregulagem = qtAutoCicloregulagem;
    }


    /**
     * Gets the qtAutoOcoparadaCp value for this DwConsol.
     * 
     * @return qtAutoOcoparadaCp
     */
    public java.math.BigDecimal getQtAutoOcoparadaCp() {
        return qtAutoOcoparadaCp;
    }


    /**
     * Sets the qtAutoOcoparadaCp value for this DwConsol.
     * 
     * @param qtAutoOcoparadaCp
     */
    public void setQtAutoOcoparadaCp(java.math.BigDecimal qtAutoOcoparadaCp) {
        this.qtAutoOcoparadaCp = qtAutoOcoparadaCp;
    }


    /**
     * Gets the qtAutoOcoparadaCpVr value for this DwConsol.
     * 
     * @return qtAutoOcoparadaCpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaCpVr() {
        return qtAutoOcoparadaCpVr;
    }


    /**
     * Sets the qtAutoOcoparadaCpVr value for this DwConsol.
     * 
     * @param qtAutoOcoparadaCpVr
     */
    public void setQtAutoOcoparadaCpVr(java.math.BigDecimal qtAutoOcoparadaCpVr) {
        this.qtAutoOcoparadaCpVr = qtAutoOcoparadaCpVr;
    }


    /**
     * Gets the qtAutoOcoparadaSp value for this DwConsol.
     * 
     * @return qtAutoOcoparadaSp
     */
    public java.math.BigDecimal getQtAutoOcoparadaSp() {
        return qtAutoOcoparadaSp;
    }


    /**
     * Sets the qtAutoOcoparadaSp value for this DwConsol.
     * 
     * @param qtAutoOcoparadaSp
     */
    public void setQtAutoOcoparadaSp(java.math.BigDecimal qtAutoOcoparadaSp) {
        this.qtAutoOcoparadaSp = qtAutoOcoparadaSp;
    }


    /**
     * Gets the qtAutoOcoparadaSpVr value for this DwConsol.
     * 
     * @return qtAutoOcoparadaSpVr
     */
    public java.math.BigDecimal getQtAutoOcoparadaSpVr() {
        return qtAutoOcoparadaSpVr;
    }


    /**
     * Sets the qtAutoOcoparadaSpVr value for this DwConsol.
     * 
     * @param qtAutoOcoparadaSpVr
     */
    public void setQtAutoOcoparadaSpVr(java.math.BigDecimal qtAutoOcoparadaSpVr) {
        this.qtAutoOcoparadaSpVr = qtAutoOcoparadaSpVr;
    }


    /**
     * Gets the qtAutoOcoparadafds value for this DwConsol.
     * 
     * @return qtAutoOcoparadafds
     */
    public java.math.BigDecimal getQtAutoOcoparadafds() {
        return qtAutoOcoparadafds;
    }


    /**
     * Sets the qtAutoOcoparadafds value for this DwConsol.
     * 
     * @param qtAutoOcoparadafds
     */
    public void setQtAutoOcoparadafds(java.math.BigDecimal qtAutoOcoparadafds) {
        this.qtAutoOcoparadafds = qtAutoOcoparadafds;
    }


    /**
     * Gets the qtAutoOcoparadaimprev value for this DwConsol.
     * 
     * @return qtAutoOcoparadaimprev
     */
    public java.math.BigDecimal getQtAutoOcoparadaimprev() {
        return qtAutoOcoparadaimprev;
    }


    /**
     * Sets the qtAutoOcoparadaimprev value for this DwConsol.
     * 
     * @param qtAutoOcoparadaimprev
     */
    public void setQtAutoOcoparadaimprev(java.math.BigDecimal qtAutoOcoparadaimprev) {
        this.qtAutoOcoparadaimprev = qtAutoOcoparadaimprev;
    }


    /**
     * Gets the qtAutoOcoparadamdo value for this DwConsol.
     * 
     * @return qtAutoOcoparadamdo
     */
    public java.math.BigDecimal getQtAutoOcoparadamdo() {
        return qtAutoOcoparadamdo;
    }


    /**
     * Sets the qtAutoOcoparadamdo value for this DwConsol.
     * 
     * @param qtAutoOcoparadamdo
     */
    public void setQtAutoOcoparadamdo(java.math.BigDecimal qtAutoOcoparadamdo) {
        this.qtAutoOcoparadamdo = qtAutoOcoparadamdo;
    }


    /**
     * Gets the qtAutoOcoparadamtbf value for this DwConsol.
     * 
     * @return qtAutoOcoparadamtbf
     */
    public java.math.BigDecimal getQtAutoOcoparadamtbf() {
        return qtAutoOcoparadamtbf;
    }


    /**
     * Sets the qtAutoOcoparadamtbf value for this DwConsol.
     * 
     * @param qtAutoOcoparadamtbf
     */
    public void setQtAutoOcoparadamtbf(java.math.BigDecimal qtAutoOcoparadamtbf) {
        this.qtAutoOcoparadamtbf = qtAutoOcoparadamtbf;
    }


    /**
     * Gets the qtAutoOcoparadamttr value for this DwConsol.
     * 
     * @return qtAutoOcoparadamttr
     */
    public java.math.BigDecimal getQtAutoOcoparadamttr() {
        return qtAutoOcoparadamttr;
    }


    /**
     * Sets the qtAutoOcoparadamttr value for this DwConsol.
     * 
     * @param qtAutoOcoparadamttr
     */
    public void setQtAutoOcoparadamttr(java.math.BigDecimal qtAutoOcoparadamttr) {
        this.qtAutoOcoparadamttr = qtAutoOcoparadamttr;
    }


    /**
     * Gets the qtAutoOcoparadapa value for this DwConsol.
     * 
     * @return qtAutoOcoparadapa
     */
    public java.math.BigDecimal getQtAutoOcoparadapa() {
        return qtAutoOcoparadapa;
    }


    /**
     * Sets the qtAutoOcoparadapa value for this DwConsol.
     * 
     * @param qtAutoOcoparadapa
     */
    public void setQtAutoOcoparadapa(java.math.BigDecimal qtAutoOcoparadapa) {
        this.qtAutoOcoparadapa = qtAutoOcoparadapa;
    }


    /**
     * Gets the qtAutoOcoparadapao value for this DwConsol.
     * 
     * @return qtAutoOcoparadapao
     */
    public java.math.BigDecimal getQtAutoOcoparadapao() {
        return qtAutoOcoparadapao;
    }


    /**
     * Sets the qtAutoOcoparadapao value for this DwConsol.
     * 
     * @param qtAutoOcoparadapao
     */
    public void setQtAutoOcoparadapao(java.math.BigDecimal qtAutoOcoparadapao) {
        this.qtAutoOcoparadapao = qtAutoOcoparadapao;
    }


    /**
     * Gets the qtAutoOcoparadapp value for this DwConsol.
     * 
     * @return qtAutoOcoparadapp
     */
    public java.math.BigDecimal getQtAutoOcoparadapp() {
        return qtAutoOcoparadapp;
    }


    /**
     * Sets the qtAutoOcoparadapp value for this DwConsol.
     * 
     * @param qtAutoOcoparadapp
     */
    public void setQtAutoOcoparadapp(java.math.BigDecimal qtAutoOcoparadapp) {
        this.qtAutoOcoparadapp = qtAutoOcoparadapp;
    }


    /**
     * Gets the qtAutoOcoparadaprev value for this DwConsol.
     * 
     * @return qtAutoOcoparadaprev
     */
    public java.math.BigDecimal getQtAutoOcoparadaprev() {
        return qtAutoOcoparadaprev;
    }


    /**
     * Sets the qtAutoOcoparadaprev value for this DwConsol.
     * 
     * @param qtAutoOcoparadaprev
     */
    public void setQtAutoOcoparadaprev(java.math.BigDecimal qtAutoOcoparadaprev) {
        this.qtAutoOcoparadaprev = qtAutoOcoparadaprev;
    }


    /**
     * Gets the qtAutoOcoparadaptp value for this DwConsol.
     * 
     * @return qtAutoOcoparadaptp
     */
    public java.math.BigDecimal getQtAutoOcoparadaptp() {
        return qtAutoOcoparadaptp;
    }


    /**
     * Sets the qtAutoOcoparadaptp value for this DwConsol.
     * 
     * @param qtAutoOcoparadaptp
     */
    public void setQtAutoOcoparadaptp(java.math.BigDecimal qtAutoOcoparadaptp) {
        this.qtAutoOcoparadaptp = qtAutoOcoparadaptp;
    }


    /**
     * Gets the qtAutoOcoparadaregulagem value for this DwConsol.
     * 
     * @return qtAutoOcoparadaregulagem
     */
    public java.math.BigDecimal getQtAutoOcoparadaregulagem() {
        return qtAutoOcoparadaregulagem;
    }


    /**
     * Sets the qtAutoOcoparadaregulagem value for this DwConsol.
     * 
     * @param qtAutoOcoparadaregulagem
     */
    public void setQtAutoOcoparadaregulagem(java.math.BigDecimal qtAutoOcoparadaregulagem) {
        this.qtAutoOcoparadaregulagem = qtAutoOcoparadaregulagem;
    }


    /**
     * Gets the qtAutoOcoparadascp value for this DwConsol.
     * 
     * @return qtAutoOcoparadascp
     */
    public java.math.BigDecimal getQtAutoOcoparadascp() {
        return qtAutoOcoparadascp;
    }


    /**
     * Sets the qtAutoOcoparadascp value for this DwConsol.
     * 
     * @param qtAutoOcoparadascp
     */
    public void setQtAutoOcoparadascp(java.math.BigDecimal qtAutoOcoparadascp) {
        this.qtAutoOcoparadascp = qtAutoOcoparadascp;
    }


    /**
     * Gets the qtAutoTempoparadaDefault value for this DwConsol.
     * 
     * @return qtAutoTempoparadaDefault
     */
    public java.math.BigDecimal getQtAutoTempoparadaDefault() {
        return qtAutoTempoparadaDefault;
    }


    /**
     * Sets the qtAutoTempoparadaDefault value for this DwConsol.
     * 
     * @param qtAutoTempoparadaDefault
     */
    public void setQtAutoTempoparadaDefault(java.math.BigDecimal qtAutoTempoparadaDefault) {
        this.qtAutoTempoparadaDefault = qtAutoTempoparadaDefault;
    }


    /**
     * Gets the qtAutoTempoparadaSemCnx value for this DwConsol.
     * 
     * @return qtAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemCnx() {
        return qtAutoTempoparadaSemCnx;
    }


    /**
     * Sets the qtAutoTempoparadaSemCnx value for this DwConsol.
     * 
     * @param qtAutoTempoparadaSemCnx
     */
    public void setQtAutoTempoparadaSemCnx(java.math.BigDecimal qtAutoTempoparadaSemCnx) {
        this.qtAutoTempoparadaSemCnx = qtAutoTempoparadaSemCnx;
    }


    /**
     * Gets the qtAutoTempoparadaSemEvt value for this DwConsol.
     * 
     * @return qtAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemEvt() {
        return qtAutoTempoparadaSemEvt;
    }


    /**
     * Sets the qtAutoTempoparadaSemEvt value for this DwConsol.
     * 
     * @param qtAutoTempoparadaSemEvt
     */
    public void setQtAutoTempoparadaSemEvt(java.math.BigDecimal qtAutoTempoparadaSemEvt) {
        this.qtAutoTempoparadaSemEvt = qtAutoTempoparadaSemEvt;
    }


    /**
     * Gets the qtAutoTempoparadaSemOp value for this DwConsol.
     * 
     * @return qtAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getQtAutoTempoparadaSemOp() {
        return qtAutoTempoparadaSemOp;
    }


    /**
     * Sets the qtAutoTempoparadaSemOp value for this DwConsol.
     * 
     * @param qtAutoTempoparadaSemOp
     */
    public void setQtAutoTempoparadaSemOp(java.math.BigDecimal qtAutoTempoparadaSemOp) {
        this.qtAutoTempoparadaSemOp = qtAutoTempoparadaSemOp;
    }


    /**
     * Gets the qtManuCicloimprodutivo value for this DwConsol.
     * 
     * @return qtManuCicloimprodutivo
     */
    public java.math.BigDecimal getQtManuCicloimprodutivo() {
        return qtManuCicloimprodutivo;
    }


    /**
     * Sets the qtManuCicloimprodutivo value for this DwConsol.
     * 
     * @param qtManuCicloimprodutivo
     */
    public void setQtManuCicloimprodutivo(java.math.BigDecimal qtManuCicloimprodutivo) {
        this.qtManuCicloimprodutivo = qtManuCicloimprodutivo;
    }


    /**
     * Gets the qtManuCicloprodutivo value for this DwConsol.
     * 
     * @return qtManuCicloprodutivo
     */
    public java.math.BigDecimal getQtManuCicloprodutivo() {
        return qtManuCicloprodutivo;
    }


    /**
     * Sets the qtManuCicloprodutivo value for this DwConsol.
     * 
     * @param qtManuCicloprodutivo
     */
    public void setQtManuCicloprodutivo(java.math.BigDecimal qtManuCicloprodutivo) {
        this.qtManuCicloprodutivo = qtManuCicloprodutivo;
    }


    /**
     * Gets the qtManuCicloregulagem value for this DwConsol.
     * 
     * @return qtManuCicloregulagem
     */
    public java.math.BigDecimal getQtManuCicloregulagem() {
        return qtManuCicloregulagem;
    }


    /**
     * Sets the qtManuCicloregulagem value for this DwConsol.
     * 
     * @param qtManuCicloregulagem
     */
    public void setQtManuCicloregulagem(java.math.BigDecimal qtManuCicloregulagem) {
        this.qtManuCicloregulagem = qtManuCicloregulagem;
    }


    /**
     * Gets the qtManuOcoparadaCp value for this DwConsol.
     * 
     * @return qtManuOcoparadaCp
     */
    public java.math.BigDecimal getQtManuOcoparadaCp() {
        return qtManuOcoparadaCp;
    }


    /**
     * Sets the qtManuOcoparadaCp value for this DwConsol.
     * 
     * @param qtManuOcoparadaCp
     */
    public void setQtManuOcoparadaCp(java.math.BigDecimal qtManuOcoparadaCp) {
        this.qtManuOcoparadaCp = qtManuOcoparadaCp;
    }


    /**
     * Gets the qtManuOcoparadaCpVr value for this DwConsol.
     * 
     * @return qtManuOcoparadaCpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaCpVr() {
        return qtManuOcoparadaCpVr;
    }


    /**
     * Sets the qtManuOcoparadaCpVr value for this DwConsol.
     * 
     * @param qtManuOcoparadaCpVr
     */
    public void setQtManuOcoparadaCpVr(java.math.BigDecimal qtManuOcoparadaCpVr) {
        this.qtManuOcoparadaCpVr = qtManuOcoparadaCpVr;
    }


    /**
     * Gets the qtManuOcoparadaSp value for this DwConsol.
     * 
     * @return qtManuOcoparadaSp
     */
    public java.math.BigDecimal getQtManuOcoparadaSp() {
        return qtManuOcoparadaSp;
    }


    /**
     * Sets the qtManuOcoparadaSp value for this DwConsol.
     * 
     * @param qtManuOcoparadaSp
     */
    public void setQtManuOcoparadaSp(java.math.BigDecimal qtManuOcoparadaSp) {
        this.qtManuOcoparadaSp = qtManuOcoparadaSp;
    }


    /**
     * Gets the qtManuOcoparadaSpVr value for this DwConsol.
     * 
     * @return qtManuOcoparadaSpVr
     */
    public java.math.BigDecimal getQtManuOcoparadaSpVr() {
        return qtManuOcoparadaSpVr;
    }


    /**
     * Sets the qtManuOcoparadaSpVr value for this DwConsol.
     * 
     * @param qtManuOcoparadaSpVr
     */
    public void setQtManuOcoparadaSpVr(java.math.BigDecimal qtManuOcoparadaSpVr) {
        this.qtManuOcoparadaSpVr = qtManuOcoparadaSpVr;
    }


    /**
     * Gets the qtManuOcoparadafds value for this DwConsol.
     * 
     * @return qtManuOcoparadafds
     */
    public java.math.BigDecimal getQtManuOcoparadafds() {
        return qtManuOcoparadafds;
    }


    /**
     * Sets the qtManuOcoparadafds value for this DwConsol.
     * 
     * @param qtManuOcoparadafds
     */
    public void setQtManuOcoparadafds(java.math.BigDecimal qtManuOcoparadafds) {
        this.qtManuOcoparadafds = qtManuOcoparadafds;
    }


    /**
     * Gets the qtManuOcoparadaimprev value for this DwConsol.
     * 
     * @return qtManuOcoparadaimprev
     */
    public java.math.BigDecimal getQtManuOcoparadaimprev() {
        return qtManuOcoparadaimprev;
    }


    /**
     * Sets the qtManuOcoparadaimprev value for this DwConsol.
     * 
     * @param qtManuOcoparadaimprev
     */
    public void setQtManuOcoparadaimprev(java.math.BigDecimal qtManuOcoparadaimprev) {
        this.qtManuOcoparadaimprev = qtManuOcoparadaimprev;
    }


    /**
     * Gets the qtManuOcoparadamdo value for this DwConsol.
     * 
     * @return qtManuOcoparadamdo
     */
    public java.math.BigDecimal getQtManuOcoparadamdo() {
        return qtManuOcoparadamdo;
    }


    /**
     * Sets the qtManuOcoparadamdo value for this DwConsol.
     * 
     * @param qtManuOcoparadamdo
     */
    public void setQtManuOcoparadamdo(java.math.BigDecimal qtManuOcoparadamdo) {
        this.qtManuOcoparadamdo = qtManuOcoparadamdo;
    }


    /**
     * Gets the qtManuOcoparadamtbf value for this DwConsol.
     * 
     * @return qtManuOcoparadamtbf
     */
    public java.math.BigDecimal getQtManuOcoparadamtbf() {
        return qtManuOcoparadamtbf;
    }


    /**
     * Sets the qtManuOcoparadamtbf value for this DwConsol.
     * 
     * @param qtManuOcoparadamtbf
     */
    public void setQtManuOcoparadamtbf(java.math.BigDecimal qtManuOcoparadamtbf) {
        this.qtManuOcoparadamtbf = qtManuOcoparadamtbf;
    }


    /**
     * Gets the qtManuOcoparadamttr value for this DwConsol.
     * 
     * @return qtManuOcoparadamttr
     */
    public java.math.BigDecimal getQtManuOcoparadamttr() {
        return qtManuOcoparadamttr;
    }


    /**
     * Sets the qtManuOcoparadamttr value for this DwConsol.
     * 
     * @param qtManuOcoparadamttr
     */
    public void setQtManuOcoparadamttr(java.math.BigDecimal qtManuOcoparadamttr) {
        this.qtManuOcoparadamttr = qtManuOcoparadamttr;
    }


    /**
     * Gets the qtManuOcoparadapa value for this DwConsol.
     * 
     * @return qtManuOcoparadapa
     */
    public java.math.BigDecimal getQtManuOcoparadapa() {
        return qtManuOcoparadapa;
    }


    /**
     * Sets the qtManuOcoparadapa value for this DwConsol.
     * 
     * @param qtManuOcoparadapa
     */
    public void setQtManuOcoparadapa(java.math.BigDecimal qtManuOcoparadapa) {
        this.qtManuOcoparadapa = qtManuOcoparadapa;
    }


    /**
     * Gets the qtManuOcoparadapao value for this DwConsol.
     * 
     * @return qtManuOcoparadapao
     */
    public java.math.BigDecimal getQtManuOcoparadapao() {
        return qtManuOcoparadapao;
    }


    /**
     * Sets the qtManuOcoparadapao value for this DwConsol.
     * 
     * @param qtManuOcoparadapao
     */
    public void setQtManuOcoparadapao(java.math.BigDecimal qtManuOcoparadapao) {
        this.qtManuOcoparadapao = qtManuOcoparadapao;
    }


    /**
     * Gets the qtManuOcoparadapp value for this DwConsol.
     * 
     * @return qtManuOcoparadapp
     */
    public java.math.BigDecimal getQtManuOcoparadapp() {
        return qtManuOcoparadapp;
    }


    /**
     * Sets the qtManuOcoparadapp value for this DwConsol.
     * 
     * @param qtManuOcoparadapp
     */
    public void setQtManuOcoparadapp(java.math.BigDecimal qtManuOcoparadapp) {
        this.qtManuOcoparadapp = qtManuOcoparadapp;
    }


    /**
     * Gets the qtManuOcoparadaprev value for this DwConsol.
     * 
     * @return qtManuOcoparadaprev
     */
    public java.math.BigDecimal getQtManuOcoparadaprev() {
        return qtManuOcoparadaprev;
    }


    /**
     * Sets the qtManuOcoparadaprev value for this DwConsol.
     * 
     * @param qtManuOcoparadaprev
     */
    public void setQtManuOcoparadaprev(java.math.BigDecimal qtManuOcoparadaprev) {
        this.qtManuOcoparadaprev = qtManuOcoparadaprev;
    }


    /**
     * Gets the qtManuOcoparadaptp value for this DwConsol.
     * 
     * @return qtManuOcoparadaptp
     */
    public java.math.BigDecimal getQtManuOcoparadaptp() {
        return qtManuOcoparadaptp;
    }


    /**
     * Sets the qtManuOcoparadaptp value for this DwConsol.
     * 
     * @param qtManuOcoparadaptp
     */
    public void setQtManuOcoparadaptp(java.math.BigDecimal qtManuOcoparadaptp) {
        this.qtManuOcoparadaptp = qtManuOcoparadaptp;
    }


    /**
     * Gets the qtManuOcoparadaregulagem value for this DwConsol.
     * 
     * @return qtManuOcoparadaregulagem
     */
    public java.math.BigDecimal getQtManuOcoparadaregulagem() {
        return qtManuOcoparadaregulagem;
    }


    /**
     * Sets the qtManuOcoparadaregulagem value for this DwConsol.
     * 
     * @param qtManuOcoparadaregulagem
     */
    public void setQtManuOcoparadaregulagem(java.math.BigDecimal qtManuOcoparadaregulagem) {
        this.qtManuOcoparadaregulagem = qtManuOcoparadaregulagem;
    }


    /**
     * Gets the qtManuOcoparadascp value for this DwConsol.
     * 
     * @return qtManuOcoparadascp
     */
    public java.math.BigDecimal getQtManuOcoparadascp() {
        return qtManuOcoparadascp;
    }


    /**
     * Sets the qtManuOcoparadascp value for this DwConsol.
     * 
     * @param qtManuOcoparadascp
     */
    public void setQtManuOcoparadascp(java.math.BigDecimal qtManuOcoparadascp) {
        this.qtManuOcoparadascp = qtManuOcoparadascp;
    }


    /**
     * Gets the qtManuTempoparadaDefault value for this DwConsol.
     * 
     * @return qtManuTempoparadaDefault
     */
    public java.math.BigDecimal getQtManuTempoparadaDefault() {
        return qtManuTempoparadaDefault;
    }


    /**
     * Sets the qtManuTempoparadaDefault value for this DwConsol.
     * 
     * @param qtManuTempoparadaDefault
     */
    public void setQtManuTempoparadaDefault(java.math.BigDecimal qtManuTempoparadaDefault) {
        this.qtManuTempoparadaDefault = qtManuTempoparadaDefault;
    }


    /**
     * Gets the qtManuTempoparadaSemCnx value for this DwConsol.
     * 
     * @return qtManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getQtManuTempoparadaSemCnx() {
        return qtManuTempoparadaSemCnx;
    }


    /**
     * Sets the qtManuTempoparadaSemCnx value for this DwConsol.
     * 
     * @param qtManuTempoparadaSemCnx
     */
    public void setQtManuTempoparadaSemCnx(java.math.BigDecimal qtManuTempoparadaSemCnx) {
        this.qtManuTempoparadaSemCnx = qtManuTempoparadaSemCnx;
    }


    /**
     * Gets the qtManuTempoparadaSemEvt value for this DwConsol.
     * 
     * @return qtManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getQtManuTempoparadaSemEvt() {
        return qtManuTempoparadaSemEvt;
    }


    /**
     * Sets the qtManuTempoparadaSemEvt value for this DwConsol.
     * 
     * @param qtManuTempoparadaSemEvt
     */
    public void setQtManuTempoparadaSemEvt(java.math.BigDecimal qtManuTempoparadaSemEvt) {
        this.qtManuTempoparadaSemEvt = qtManuTempoparadaSemEvt;
    }


    /**
     * Gets the qtManuTempoparadaSemOp value for this DwConsol.
     * 
     * @return qtManuTempoparadaSemOp
     */
    public java.math.BigDecimal getQtManuTempoparadaSemOp() {
        return qtManuTempoparadaSemOp;
    }


    /**
     * Sets the qtManuTempoparadaSemOp value for this DwConsol.
     * 
     * @param qtManuTempoparadaSemOp
     */
    public void setQtManuTempoparadaSemOp(java.math.BigDecimal qtManuTempoparadaSemOp) {
        this.qtManuTempoparadaSemOp = qtManuTempoparadaSemOp;
    }


    /**
     * Gets the segAutoBoas value for this DwConsol.
     * 
     * @return segAutoBoas
     */
    public java.math.BigDecimal getSegAutoBoas() {
        return segAutoBoas;
    }


    /**
     * Sets the segAutoBoas value for this DwConsol.
     * 
     * @param segAutoBoas
     */
    public void setSegAutoBoas(java.math.BigDecimal segAutoBoas) {
        this.segAutoBoas = segAutoBoas;
    }


    /**
     * Gets the segAutoCicloimprodutivo value for this DwConsol.
     * 
     * @return segAutoCicloimprodutivo
     */
    public java.math.BigDecimal getSegAutoCicloimprodutivo() {
        return segAutoCicloimprodutivo;
    }


    /**
     * Sets the segAutoCicloimprodutivo value for this DwConsol.
     * 
     * @param segAutoCicloimprodutivo
     */
    public void setSegAutoCicloimprodutivo(java.math.BigDecimal segAutoCicloimprodutivo) {
        this.segAutoCicloimprodutivo = segAutoCicloimprodutivo;
    }


    /**
     * Gets the segAutoCicloimprodutivoCta value for this DwConsol.
     * 
     * @return segAutoCicloimprodutivoCta
     */
    public java.math.BigDecimal getSegAutoCicloimprodutivoCta() {
        return segAutoCicloimprodutivoCta;
    }


    /**
     * Sets the segAutoCicloimprodutivoCta value for this DwConsol.
     * 
     * @param segAutoCicloimprodutivoCta
     */
    public void setSegAutoCicloimprodutivoCta(java.math.BigDecimal segAutoCicloimprodutivoCta) {
        this.segAutoCicloimprodutivoCta = segAutoCicloimprodutivoCta;
    }


    /**
     * Gets the segAutoCiclomedio value for this DwConsol.
     * 
     * @return segAutoCiclomedio
     */
    public java.math.BigDecimal getSegAutoCiclomedio() {
        return segAutoCiclomedio;
    }


    /**
     * Sets the segAutoCiclomedio value for this DwConsol.
     * 
     * @param segAutoCiclomedio
     */
    public void setSegAutoCiclomedio(java.math.BigDecimal segAutoCiclomedio) {
        this.segAutoCiclomedio = segAutoCiclomedio;
    }


    /**
     * Gets the segAutoCiclopadrao value for this DwConsol.
     * 
     * @return segAutoCiclopadrao
     */
    public java.math.BigDecimal getSegAutoCiclopadrao() {
        return segAutoCiclopadrao;
    }


    /**
     * Sets the segAutoCiclopadrao value for this DwConsol.
     * 
     * @param segAutoCiclopadrao
     */
    public void setSegAutoCiclopadrao(java.math.BigDecimal segAutoCiclopadrao) {
        this.segAutoCiclopadrao = segAutoCiclopadrao;
    }


    /**
     * Gets the segAutoCicloprodutivo value for this DwConsol.
     * 
     * @return segAutoCicloprodutivo
     */
    public java.math.BigDecimal getSegAutoCicloprodutivo() {
        return segAutoCicloprodutivo;
    }


    /**
     * Sets the segAutoCicloprodutivo value for this DwConsol.
     * 
     * @param segAutoCicloprodutivo
     */
    public void setSegAutoCicloprodutivo(java.math.BigDecimal segAutoCicloprodutivo) {
        this.segAutoCicloprodutivo = segAutoCicloprodutivo;
    }


    /**
     * Gets the segAutoCicloprodutivoCta value for this DwConsol.
     * 
     * @return segAutoCicloprodutivoCta
     */
    public java.math.BigDecimal getSegAutoCicloprodutivoCta() {
        return segAutoCicloprodutivoCta;
    }


    /**
     * Sets the segAutoCicloprodutivoCta value for this DwConsol.
     * 
     * @param segAutoCicloprodutivoCta
     */
    public void setSegAutoCicloprodutivoCta(java.math.BigDecimal segAutoCicloprodutivoCta) {
        this.segAutoCicloprodutivoCta = segAutoCicloprodutivoCta;
    }


    /**
     * Gets the segAutoCta value for this DwConsol.
     * 
     * @return segAutoCta
     */
    public java.math.BigDecimal getSegAutoCta() {
        return segAutoCta;
    }


    /**
     * Sets the segAutoCta value for this DwConsol.
     * 
     * @param segAutoCta
     */
    public void setSegAutoCta(java.math.BigDecimal segAutoCta) {
        this.segAutoCta = segAutoCta;
    }


    /**
     * Gets the segAutoPerdacav value for this DwConsol.
     * 
     * @return segAutoPerdacav
     */
    public java.math.BigDecimal getSegAutoPerdacav() {
        return segAutoPerdacav;
    }


    /**
     * Sets the segAutoPerdacav value for this DwConsol.
     * 
     * @param segAutoPerdacav
     */
    public void setSegAutoPerdacav(java.math.BigDecimal segAutoPerdacav) {
        this.segAutoPerdacav = segAutoPerdacav;
    }


    /**
     * Gets the segAutoPerdaciclo value for this DwConsol.
     * 
     * @return segAutoPerdaciclo
     */
    public java.math.BigDecimal getSegAutoPerdaciclo() {
        return segAutoPerdaciclo;
    }


    /**
     * Sets the segAutoPerdaciclo value for this DwConsol.
     * 
     * @param segAutoPerdaciclo
     */
    public void setSegAutoPerdaciclo(java.math.BigDecimal segAutoPerdaciclo) {
        this.segAutoPerdaciclo = segAutoPerdaciclo;
    }


    /**
     * Gets the segAutoRitmo value for this DwConsol.
     * 
     * @return segAutoRitmo
     */
    public java.math.BigDecimal getSegAutoRitmo() {
        return segAutoRitmo;
    }


    /**
     * Sets the segAutoRitmo value for this DwConsol.
     * 
     * @param segAutoRitmo
     */
    public void setSegAutoRitmo(java.math.BigDecimal segAutoRitmo) {
        this.segAutoRitmo = segAutoRitmo;
    }


    /**
     * Gets the segAutoTempoalerta value for this DwConsol.
     * 
     * @return segAutoTempoalerta
     */
    public java.math.BigDecimal getSegAutoTempoalerta() {
        return segAutoTempoalerta;
    }


    /**
     * Sets the segAutoTempoalerta value for this DwConsol.
     * 
     * @param segAutoTempoalerta
     */
    public void setSegAutoTempoalerta(java.math.BigDecimal segAutoTempoalerta) {
        this.segAutoTempoalerta = segAutoTempoalerta;
    }


    /**
     * Gets the segAutoTempoativo value for this DwConsol.
     * 
     * @return segAutoTempoativo
     */
    public java.math.BigDecimal getSegAutoTempoativo() {
        return segAutoTempoativo;
    }


    /**
     * Sets the segAutoTempoativo value for this DwConsol.
     * 
     * @param segAutoTempoativo
     */
    public void setSegAutoTempoativo(java.math.BigDecimal segAutoTempoativo) {
        this.segAutoTempoativo = segAutoTempoativo;
    }


    /**
     * Gets the segAutoTempocalendario value for this DwConsol.
     * 
     * @return segAutoTempocalendario
     */
    public java.math.BigDecimal getSegAutoTempocalendario() {
        return segAutoTempocalendario;
    }


    /**
     * Sets the segAutoTempocalendario value for this DwConsol.
     * 
     * @param segAutoTempocalendario
     */
    public void setSegAutoTempocalendario(java.math.BigDecimal segAutoTempocalendario) {
        this.segAutoTempocalendario = segAutoTempocalendario;
    }


    /**
     * Gets the segAutoTempocalsempeso value for this DwConsol.
     * 
     * @return segAutoTempocalsempeso
     */
    public java.math.BigDecimal getSegAutoTempocalsempeso() {
        return segAutoTempocalsempeso;
    }


    /**
     * Sets the segAutoTempocalsempeso value for this DwConsol.
     * 
     * @param segAutoTempocalsempeso
     */
    public void setSegAutoTempocalsempeso(java.math.BigDecimal segAutoTempocalsempeso) {
        this.segAutoTempocalsempeso = segAutoTempocalsempeso;
    }


    /**
     * Gets the segAutoTempoparadaAb value for this DwConsol.
     * 
     * @return segAutoTempoparadaAb
     */
    public java.math.BigDecimal getSegAutoTempoparadaAb() {
        return segAutoTempoparadaAb;
    }


    /**
     * Sets the segAutoTempoparadaAb value for this DwConsol.
     * 
     * @param segAutoTempoparadaAb
     */
    public void setSegAutoTempoparadaAb(java.math.BigDecimal segAutoTempoparadaAb) {
        this.segAutoTempoparadaAb = segAutoTempoparadaAb;
    }


    /**
     * Gets the segAutoTempoparadaCp value for this DwConsol.
     * 
     * @return segAutoTempoparadaCp
     */
    public java.math.BigDecimal getSegAutoTempoparadaCp() {
        return segAutoTempoparadaCp;
    }


    /**
     * Sets the segAutoTempoparadaCp value for this DwConsol.
     * 
     * @param segAutoTempoparadaCp
     */
    public void setSegAutoTempoparadaCp(java.math.BigDecimal segAutoTempoparadaCp) {
        this.segAutoTempoparadaCp = segAutoTempoparadaCp;
    }


    /**
     * Gets the segAutoTempoparadaCpVr value for this DwConsol.
     * 
     * @return segAutoTempoparadaCpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaCpVr() {
        return segAutoTempoparadaCpVr;
    }


    /**
     * Sets the segAutoTempoparadaCpVr value for this DwConsol.
     * 
     * @param segAutoTempoparadaCpVr
     */
    public void setSegAutoTempoparadaCpVr(java.math.BigDecimal segAutoTempoparadaCpVr) {
        this.segAutoTempoparadaCpVr = segAutoTempoparadaCpVr;
    }


    /**
     * Gets the segAutoTempoparadaDefault value for this DwConsol.
     * 
     * @return segAutoTempoparadaDefault
     */
    public java.math.BigDecimal getSegAutoTempoparadaDefault() {
        return segAutoTempoparadaDefault;
    }


    /**
     * Sets the segAutoTempoparadaDefault value for this DwConsol.
     * 
     * @param segAutoTempoparadaDefault
     */
    public void setSegAutoTempoparadaDefault(java.math.BigDecimal segAutoTempoparadaDefault) {
        this.segAutoTempoparadaDefault = segAutoTempoparadaDefault;
    }


    /**
     * Gets the segAutoTempoparadaSemCnx value for this DwConsol.
     * 
     * @return segAutoTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemCnx() {
        return segAutoTempoparadaSemCnx;
    }


    /**
     * Sets the segAutoTempoparadaSemCnx value for this DwConsol.
     * 
     * @param segAutoTempoparadaSemCnx
     */
    public void setSegAutoTempoparadaSemCnx(java.math.BigDecimal segAutoTempoparadaSemCnx) {
        this.segAutoTempoparadaSemCnx = segAutoTempoparadaSemCnx;
    }


    /**
     * Gets the segAutoTempoparadaSemEvt value for this DwConsol.
     * 
     * @return segAutoTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemEvt() {
        return segAutoTempoparadaSemEvt;
    }


    /**
     * Sets the segAutoTempoparadaSemEvt value for this DwConsol.
     * 
     * @param segAutoTempoparadaSemEvt
     */
    public void setSegAutoTempoparadaSemEvt(java.math.BigDecimal segAutoTempoparadaSemEvt) {
        this.segAutoTempoparadaSemEvt = segAutoTempoparadaSemEvt;
    }


    /**
     * Gets the segAutoTempoparadaSemOp value for this DwConsol.
     * 
     * @return segAutoTempoparadaSemOp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSemOp() {
        return segAutoTempoparadaSemOp;
    }


    /**
     * Sets the segAutoTempoparadaSemOp value for this DwConsol.
     * 
     * @param segAutoTempoparadaSemOp
     */
    public void setSegAutoTempoparadaSemOp(java.math.BigDecimal segAutoTempoparadaSemOp) {
        this.segAutoTempoparadaSemOp = segAutoTempoparadaSemOp;
    }


    /**
     * Gets the segAutoTempoparadaSp value for this DwConsol.
     * 
     * @return segAutoTempoparadaSp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSp() {
        return segAutoTempoparadaSp;
    }


    /**
     * Sets the segAutoTempoparadaSp value for this DwConsol.
     * 
     * @param segAutoTempoparadaSp
     */
    public void setSegAutoTempoparadaSp(java.math.BigDecimal segAutoTempoparadaSp) {
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }


    /**
     * Gets the segAutoTempoparadaSpVr value for this DwConsol.
     * 
     * @return segAutoTempoparadaSpVr
     */
    public java.math.BigDecimal getSegAutoTempoparadaSpVr() {
        return segAutoTempoparadaSpVr;
    }


    /**
     * Sets the segAutoTempoparadaSpVr value for this DwConsol.
     * 
     * @param segAutoTempoparadaSpVr
     */
    public void setSegAutoTempoparadaSpVr(java.math.BigDecimal segAutoTempoparadaSpVr) {
        this.segAutoTempoparadaSpVr = segAutoTempoparadaSpVr;
    }


    /**
     * Gets the segAutoTempoparadafds value for this DwConsol.
     * 
     * @return segAutoTempoparadafds
     */
    public java.math.BigDecimal getSegAutoTempoparadafds() {
        return segAutoTempoparadafds;
    }


    /**
     * Sets the segAutoTempoparadafds value for this DwConsol.
     * 
     * @param segAutoTempoparadafds
     */
    public void setSegAutoTempoparadafds(java.math.BigDecimal segAutoTempoparadafds) {
        this.segAutoTempoparadafds = segAutoTempoparadafds;
    }


    /**
     * Gets the segAutoTempoparadaimprev value for this DwConsol.
     * 
     * @return segAutoTempoparadaimprev
     */
    public java.math.BigDecimal getSegAutoTempoparadaimprev() {
        return segAutoTempoparadaimprev;
    }


    /**
     * Sets the segAutoTempoparadaimprev value for this DwConsol.
     * 
     * @param segAutoTempoparadaimprev
     */
    public void setSegAutoTempoparadaimprev(java.math.BigDecimal segAutoTempoparadaimprev) {
        this.segAutoTempoparadaimprev = segAutoTempoparadaimprev;
    }


    /**
     * Gets the segAutoTempoparadamdo value for this DwConsol.
     * 
     * @return segAutoTempoparadamdo
     */
    public java.math.BigDecimal getSegAutoTempoparadamdo() {
        return segAutoTempoparadamdo;
    }


    /**
     * Sets the segAutoTempoparadamdo value for this DwConsol.
     * 
     * @param segAutoTempoparadamdo
     */
    public void setSegAutoTempoparadamdo(java.math.BigDecimal segAutoTempoparadamdo) {
        this.segAutoTempoparadamdo = segAutoTempoparadamdo;
    }


    /**
     * Gets the segAutoTempoparadamtbf value for this DwConsol.
     * 
     * @return segAutoTempoparadamtbf
     */
    public java.math.BigDecimal getSegAutoTempoparadamtbf() {
        return segAutoTempoparadamtbf;
    }


    /**
     * Sets the segAutoTempoparadamtbf value for this DwConsol.
     * 
     * @param segAutoTempoparadamtbf
     */
    public void setSegAutoTempoparadamtbf(java.math.BigDecimal segAutoTempoparadamtbf) {
        this.segAutoTempoparadamtbf = segAutoTempoparadamtbf;
    }


    /**
     * Gets the segAutoTempoparadamttr value for this DwConsol.
     * 
     * @return segAutoTempoparadamttr
     */
    public java.math.BigDecimal getSegAutoTempoparadamttr() {
        return segAutoTempoparadamttr;
    }


    /**
     * Sets the segAutoTempoparadamttr value for this DwConsol.
     * 
     * @param segAutoTempoparadamttr
     */
    public void setSegAutoTempoparadamttr(java.math.BigDecimal segAutoTempoparadamttr) {
        this.segAutoTempoparadamttr = segAutoTempoparadamttr;
    }


    /**
     * Gets the segAutoTempoparadapa value for this DwConsol.
     * 
     * @return segAutoTempoparadapa
     */
    public java.math.BigDecimal getSegAutoTempoparadapa() {
        return segAutoTempoparadapa;
    }


    /**
     * Sets the segAutoTempoparadapa value for this DwConsol.
     * 
     * @param segAutoTempoparadapa
     */
    public void setSegAutoTempoparadapa(java.math.BigDecimal segAutoTempoparadapa) {
        this.segAutoTempoparadapa = segAutoTempoparadapa;
    }


    /**
     * Gets the segAutoTempoparadapao value for this DwConsol.
     * 
     * @return segAutoTempoparadapao
     */
    public java.math.BigDecimal getSegAutoTempoparadapao() {
        return segAutoTempoparadapao;
    }


    /**
     * Sets the segAutoTempoparadapao value for this DwConsol.
     * 
     * @param segAutoTempoparadapao
     */
    public void setSegAutoTempoparadapao(java.math.BigDecimal segAutoTempoparadapao) {
        this.segAutoTempoparadapao = segAutoTempoparadapao;
    }


    /**
     * Gets the segAutoTempoparadapp value for this DwConsol.
     * 
     * @return segAutoTempoparadapp
     */
    public java.math.BigDecimal getSegAutoTempoparadapp() {
        return segAutoTempoparadapp;
    }


    /**
     * Sets the segAutoTempoparadapp value for this DwConsol.
     * 
     * @param segAutoTempoparadapp
     */
    public void setSegAutoTempoparadapp(java.math.BigDecimal segAutoTempoparadapp) {
        this.segAutoTempoparadapp = segAutoTempoparadapp;
    }


    /**
     * Gets the segAutoTempoparadaprev value for this DwConsol.
     * 
     * @return segAutoTempoparadaprev
     */
    public java.math.BigDecimal getSegAutoTempoparadaprev() {
        return segAutoTempoparadaprev;
    }


    /**
     * Sets the segAutoTempoparadaprev value for this DwConsol.
     * 
     * @param segAutoTempoparadaprev
     */
    public void setSegAutoTempoparadaprev(java.math.BigDecimal segAutoTempoparadaprev) {
        this.segAutoTempoparadaprev = segAutoTempoparadaprev;
    }


    /**
     * Gets the segAutoTempoparadaptp value for this DwConsol.
     * 
     * @return segAutoTempoparadaptp
     */
    public java.math.BigDecimal getSegAutoTempoparadaptp() {
        return segAutoTempoparadaptp;
    }


    /**
     * Sets the segAutoTempoparadaptp value for this DwConsol.
     * 
     * @param segAutoTempoparadaptp
     */
    public void setSegAutoTempoparadaptp(java.math.BigDecimal segAutoTempoparadaptp) {
        this.segAutoTempoparadaptp = segAutoTempoparadaptp;
    }


    /**
     * Gets the segAutoTempoparadaregulagem value for this DwConsol.
     * 
     * @return segAutoTempoparadaregulagem
     */
    public java.math.BigDecimal getSegAutoTempoparadaregulagem() {
        return segAutoTempoparadaregulagem;
    }


    /**
     * Sets the segAutoTempoparadaregulagem value for this DwConsol.
     * 
     * @param segAutoTempoparadaregulagem
     */
    public void setSegAutoTempoparadaregulagem(java.math.BigDecimal segAutoTempoparadaregulagem) {
        this.segAutoTempoparadaregulagem = segAutoTempoparadaregulagem;
    }


    /**
     * Gets the segAutoTempoparadascp value for this DwConsol.
     * 
     * @return segAutoTempoparadascp
     */
    public java.math.BigDecimal getSegAutoTempoparadascp() {
        return segAutoTempoparadascp;
    }


    /**
     * Sets the segAutoTempoparadascp value for this DwConsol.
     * 
     * @param segAutoTempoparadascp
     */
    public void setSegAutoTempoparadascp(java.math.BigDecimal segAutoTempoparadascp) {
        this.segAutoTempoparadascp = segAutoTempoparadascp;
    }


    /**
     * Gets the segAutoTempoprodutivo value for this DwConsol.
     * 
     * @return segAutoTempoprodutivo
     */
    public java.math.BigDecimal getSegAutoTempoprodutivo() {
        return segAutoTempoprodutivo;
    }


    /**
     * Sets the segAutoTempoprodutivo value for this DwConsol.
     * 
     * @param segAutoTempoprodutivo
     */
    public void setSegAutoTempoprodutivo(java.math.BigDecimal segAutoTempoprodutivo) {
        this.segAutoTempoprodutivo = segAutoTempoprodutivo;
    }


    /**
     * Gets the segAutoTemporefugadas value for this DwConsol.
     * 
     * @return segAutoTemporefugadas
     */
    public java.math.BigDecimal getSegAutoTemporefugadas() {
        return segAutoTemporefugadas;
    }


    /**
     * Sets the segAutoTemporefugadas value for this DwConsol.
     * 
     * @param segAutoTemporefugadas
     */
    public void setSegAutoTemporefugadas(java.math.BigDecimal segAutoTemporefugadas) {
        this.segAutoTemporefugadas = segAutoTemporefugadas;
    }


    /**
     * Gets the segAutoTempotrabalhado value for this DwConsol.
     * 
     * @return segAutoTempotrabalhado
     */
    public java.math.BigDecimal getSegAutoTempotrabalhado() {
        return segAutoTempotrabalhado;
    }


    /**
     * Sets the segAutoTempotrabalhado value for this DwConsol.
     * 
     * @param segAutoTempotrabalhado
     */
    public void setSegAutoTempotrabalhado(java.math.BigDecimal segAutoTempotrabalhado) {
        this.segAutoTempotrabalhado = segAutoTempotrabalhado;
    }


    /**
     * Gets the segManuBoas value for this DwConsol.
     * 
     * @return segManuBoas
     */
    public java.math.BigDecimal getSegManuBoas() {
        return segManuBoas;
    }


    /**
     * Sets the segManuBoas value for this DwConsol.
     * 
     * @param segManuBoas
     */
    public void setSegManuBoas(java.math.BigDecimal segManuBoas) {
        this.segManuBoas = segManuBoas;
    }


    /**
     * Gets the segManuCicloimprodutivo value for this DwConsol.
     * 
     * @return segManuCicloimprodutivo
     */
    public java.math.BigDecimal getSegManuCicloimprodutivo() {
        return segManuCicloimprodutivo;
    }


    /**
     * Sets the segManuCicloimprodutivo value for this DwConsol.
     * 
     * @param segManuCicloimprodutivo
     */
    public void setSegManuCicloimprodutivo(java.math.BigDecimal segManuCicloimprodutivo) {
        this.segManuCicloimprodutivo = segManuCicloimprodutivo;
    }


    /**
     * Gets the segManuCicloimprodutivoCta value for this DwConsol.
     * 
     * @return segManuCicloimprodutivoCta
     */
    public java.math.BigDecimal getSegManuCicloimprodutivoCta() {
        return segManuCicloimprodutivoCta;
    }


    /**
     * Sets the segManuCicloimprodutivoCta value for this DwConsol.
     * 
     * @param segManuCicloimprodutivoCta
     */
    public void setSegManuCicloimprodutivoCta(java.math.BigDecimal segManuCicloimprodutivoCta) {
        this.segManuCicloimprodutivoCta = segManuCicloimprodutivoCta;
    }


    /**
     * Gets the segManuCiclomedio value for this DwConsol.
     * 
     * @return segManuCiclomedio
     */
    public java.math.BigDecimal getSegManuCiclomedio() {
        return segManuCiclomedio;
    }


    /**
     * Sets the segManuCiclomedio value for this DwConsol.
     * 
     * @param segManuCiclomedio
     */
    public void setSegManuCiclomedio(java.math.BigDecimal segManuCiclomedio) {
        this.segManuCiclomedio = segManuCiclomedio;
    }


    /**
     * Gets the segManuCiclopadrao value for this DwConsol.
     * 
     * @return segManuCiclopadrao
     */
    public java.math.BigDecimal getSegManuCiclopadrao() {
        return segManuCiclopadrao;
    }


    /**
     * Sets the segManuCiclopadrao value for this DwConsol.
     * 
     * @param segManuCiclopadrao
     */
    public void setSegManuCiclopadrao(java.math.BigDecimal segManuCiclopadrao) {
        this.segManuCiclopadrao = segManuCiclopadrao;
    }


    /**
     * Gets the segManuCicloprodutivo value for this DwConsol.
     * 
     * @return segManuCicloprodutivo
     */
    public java.math.BigDecimal getSegManuCicloprodutivo() {
        return segManuCicloprodutivo;
    }


    /**
     * Sets the segManuCicloprodutivo value for this DwConsol.
     * 
     * @param segManuCicloprodutivo
     */
    public void setSegManuCicloprodutivo(java.math.BigDecimal segManuCicloprodutivo) {
        this.segManuCicloprodutivo = segManuCicloprodutivo;
    }


    /**
     * Gets the segManuCicloprodutivoCta value for this DwConsol.
     * 
     * @return segManuCicloprodutivoCta
     */
    public java.math.BigDecimal getSegManuCicloprodutivoCta() {
        return segManuCicloprodutivoCta;
    }


    /**
     * Sets the segManuCicloprodutivoCta value for this DwConsol.
     * 
     * @param segManuCicloprodutivoCta
     */
    public void setSegManuCicloprodutivoCta(java.math.BigDecimal segManuCicloprodutivoCta) {
        this.segManuCicloprodutivoCta = segManuCicloprodutivoCta;
    }


    /**
     * Gets the segManuCicloregulagem value for this DwConsol.
     * 
     * @return segManuCicloregulagem
     */
    public java.math.BigDecimal getSegManuCicloregulagem() {
        return segManuCicloregulagem;
    }


    /**
     * Sets the segManuCicloregulagem value for this DwConsol.
     * 
     * @param segManuCicloregulagem
     */
    public void setSegManuCicloregulagem(java.math.BigDecimal segManuCicloregulagem) {
        this.segManuCicloregulagem = segManuCicloregulagem;
    }


    /**
     * Gets the segManuCta value for this DwConsol.
     * 
     * @return segManuCta
     */
    public java.math.BigDecimal getSegManuCta() {
        return segManuCta;
    }


    /**
     * Sets the segManuCta value for this DwConsol.
     * 
     * @param segManuCta
     */
    public void setSegManuCta(java.math.BigDecimal segManuCta) {
        this.segManuCta = segManuCta;
    }


    /**
     * Gets the segManuPerdacav value for this DwConsol.
     * 
     * @return segManuPerdacav
     */
    public java.math.BigDecimal getSegManuPerdacav() {
        return segManuPerdacav;
    }


    /**
     * Sets the segManuPerdacav value for this DwConsol.
     * 
     * @param segManuPerdacav
     */
    public void setSegManuPerdacav(java.math.BigDecimal segManuPerdacav) {
        this.segManuPerdacav = segManuPerdacav;
    }


    /**
     * Gets the segManuPerdaciclo value for this DwConsol.
     * 
     * @return segManuPerdaciclo
     */
    public java.math.BigDecimal getSegManuPerdaciclo() {
        return segManuPerdaciclo;
    }


    /**
     * Sets the segManuPerdaciclo value for this DwConsol.
     * 
     * @param segManuPerdaciclo
     */
    public void setSegManuPerdaciclo(java.math.BigDecimal segManuPerdaciclo) {
        this.segManuPerdaciclo = segManuPerdaciclo;
    }


    /**
     * Gets the segManuRitmo value for this DwConsol.
     * 
     * @return segManuRitmo
     */
    public java.math.BigDecimal getSegManuRitmo() {
        return segManuRitmo;
    }


    /**
     * Sets the segManuRitmo value for this DwConsol.
     * 
     * @param segManuRitmo
     */
    public void setSegManuRitmo(java.math.BigDecimal segManuRitmo) {
        this.segManuRitmo = segManuRitmo;
    }


    /**
     * Gets the segManuTempoalerta value for this DwConsol.
     * 
     * @return segManuTempoalerta
     */
    public java.math.BigDecimal getSegManuTempoalerta() {
        return segManuTempoalerta;
    }


    /**
     * Sets the segManuTempoalerta value for this DwConsol.
     * 
     * @param segManuTempoalerta
     */
    public void setSegManuTempoalerta(java.math.BigDecimal segManuTempoalerta) {
        this.segManuTempoalerta = segManuTempoalerta;
    }


    /**
     * Gets the segManuTempoativo value for this DwConsol.
     * 
     * @return segManuTempoativo
     */
    public java.math.BigDecimal getSegManuTempoativo() {
        return segManuTempoativo;
    }


    /**
     * Sets the segManuTempoativo value for this DwConsol.
     * 
     * @param segManuTempoativo
     */
    public void setSegManuTempoativo(java.math.BigDecimal segManuTempoativo) {
        this.segManuTempoativo = segManuTempoativo;
    }


    /**
     * Gets the segManuTempocalendario value for this DwConsol.
     * 
     * @return segManuTempocalendario
     */
    public java.math.BigDecimal getSegManuTempocalendario() {
        return segManuTempocalendario;
    }


    /**
     * Sets the segManuTempocalendario value for this DwConsol.
     * 
     * @param segManuTempocalendario
     */
    public void setSegManuTempocalendario(java.math.BigDecimal segManuTempocalendario) {
        this.segManuTempocalendario = segManuTempocalendario;
    }


    /**
     * Gets the segManuTempocalsempeso value for this DwConsol.
     * 
     * @return segManuTempocalsempeso
     */
    public java.math.BigDecimal getSegManuTempocalsempeso() {
        return segManuTempocalsempeso;
    }


    /**
     * Sets the segManuTempocalsempeso value for this DwConsol.
     * 
     * @param segManuTempocalsempeso
     */
    public void setSegManuTempocalsempeso(java.math.BigDecimal segManuTempocalsempeso) {
        this.segManuTempocalsempeso = segManuTempocalsempeso;
    }


    /**
     * Gets the segManuTempoparadaCp value for this DwConsol.
     * 
     * @return segManuTempoparadaCp
     */
    public java.math.BigDecimal getSegManuTempoparadaCp() {
        return segManuTempoparadaCp;
    }


    /**
     * Sets the segManuTempoparadaCp value for this DwConsol.
     * 
     * @param segManuTempoparadaCp
     */
    public void setSegManuTempoparadaCp(java.math.BigDecimal segManuTempoparadaCp) {
        this.segManuTempoparadaCp = segManuTempoparadaCp;
    }


    /**
     * Gets the segManuTempoparadaCpVr value for this DwConsol.
     * 
     * @return segManuTempoparadaCpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaCpVr() {
        return segManuTempoparadaCpVr;
    }


    /**
     * Sets the segManuTempoparadaCpVr value for this DwConsol.
     * 
     * @param segManuTempoparadaCpVr
     */
    public void setSegManuTempoparadaCpVr(java.math.BigDecimal segManuTempoparadaCpVr) {
        this.segManuTempoparadaCpVr = segManuTempoparadaCpVr;
    }


    /**
     * Gets the segManuTempoparadaDefault value for this DwConsol.
     * 
     * @return segManuTempoparadaDefault
     */
    public java.math.BigDecimal getSegManuTempoparadaDefault() {
        return segManuTempoparadaDefault;
    }


    /**
     * Sets the segManuTempoparadaDefault value for this DwConsol.
     * 
     * @param segManuTempoparadaDefault
     */
    public void setSegManuTempoparadaDefault(java.math.BigDecimal segManuTempoparadaDefault) {
        this.segManuTempoparadaDefault = segManuTempoparadaDefault;
    }


    /**
     * Gets the segManuTempoparadaSemCnx value for this DwConsol.
     * 
     * @return segManuTempoparadaSemCnx
     */
    public java.math.BigDecimal getSegManuTempoparadaSemCnx() {
        return segManuTempoparadaSemCnx;
    }


    /**
     * Sets the segManuTempoparadaSemCnx value for this DwConsol.
     * 
     * @param segManuTempoparadaSemCnx
     */
    public void setSegManuTempoparadaSemCnx(java.math.BigDecimal segManuTempoparadaSemCnx) {
        this.segManuTempoparadaSemCnx = segManuTempoparadaSemCnx;
    }


    /**
     * Gets the segManuTempoparadaSemEvt value for this DwConsol.
     * 
     * @return segManuTempoparadaSemEvt
     */
    public java.math.BigDecimal getSegManuTempoparadaSemEvt() {
        return segManuTempoparadaSemEvt;
    }


    /**
     * Sets the segManuTempoparadaSemEvt value for this DwConsol.
     * 
     * @param segManuTempoparadaSemEvt
     */
    public void setSegManuTempoparadaSemEvt(java.math.BigDecimal segManuTempoparadaSemEvt) {
        this.segManuTempoparadaSemEvt = segManuTempoparadaSemEvt;
    }


    /**
     * Gets the segManuTempoparadaSemOp value for this DwConsol.
     * 
     * @return segManuTempoparadaSemOp
     */
    public java.math.BigDecimal getSegManuTempoparadaSemOp() {
        return segManuTempoparadaSemOp;
    }


    /**
     * Sets the segManuTempoparadaSemOp value for this DwConsol.
     * 
     * @param segManuTempoparadaSemOp
     */
    public void setSegManuTempoparadaSemOp(java.math.BigDecimal segManuTempoparadaSemOp) {
        this.segManuTempoparadaSemOp = segManuTempoparadaSemOp;
    }


    /**
     * Gets the segManuTempoparadaSp value for this DwConsol.
     * 
     * @return segManuTempoparadaSp
     */
    public java.math.BigDecimal getSegManuTempoparadaSp() {
        return segManuTempoparadaSp;
    }


    /**
     * Sets the segManuTempoparadaSp value for this DwConsol.
     * 
     * @param segManuTempoparadaSp
     */
    public void setSegManuTempoparadaSp(java.math.BigDecimal segManuTempoparadaSp) {
        this.segManuTempoparadaSp = segManuTempoparadaSp;
    }


    /**
     * Gets the segManuTempoparadaSpVr value for this DwConsol.
     * 
     * @return segManuTempoparadaSpVr
     */
    public java.math.BigDecimal getSegManuTempoparadaSpVr() {
        return segManuTempoparadaSpVr;
    }


    /**
     * Sets the segManuTempoparadaSpVr value for this DwConsol.
     * 
     * @param segManuTempoparadaSpVr
     */
    public void setSegManuTempoparadaSpVr(java.math.BigDecimal segManuTempoparadaSpVr) {
        this.segManuTempoparadaSpVr = segManuTempoparadaSpVr;
    }


    /**
     * Gets the segManuTempoparadafds value for this DwConsol.
     * 
     * @return segManuTempoparadafds
     */
    public java.math.BigDecimal getSegManuTempoparadafds() {
        return segManuTempoparadafds;
    }


    /**
     * Sets the segManuTempoparadafds value for this DwConsol.
     * 
     * @param segManuTempoparadafds
     */
    public void setSegManuTempoparadafds(java.math.BigDecimal segManuTempoparadafds) {
        this.segManuTempoparadafds = segManuTempoparadafds;
    }


    /**
     * Gets the segManuTempoparadaimprev value for this DwConsol.
     * 
     * @return segManuTempoparadaimprev
     */
    public java.math.BigDecimal getSegManuTempoparadaimprev() {
        return segManuTempoparadaimprev;
    }


    /**
     * Sets the segManuTempoparadaimprev value for this DwConsol.
     * 
     * @param segManuTempoparadaimprev
     */
    public void setSegManuTempoparadaimprev(java.math.BigDecimal segManuTempoparadaimprev) {
        this.segManuTempoparadaimprev = segManuTempoparadaimprev;
    }


    /**
     * Gets the segManuTempoparadamdo value for this DwConsol.
     * 
     * @return segManuTempoparadamdo
     */
    public java.math.BigDecimal getSegManuTempoparadamdo() {
        return segManuTempoparadamdo;
    }


    /**
     * Sets the segManuTempoparadamdo value for this DwConsol.
     * 
     * @param segManuTempoparadamdo
     */
    public void setSegManuTempoparadamdo(java.math.BigDecimal segManuTempoparadamdo) {
        this.segManuTempoparadamdo = segManuTempoparadamdo;
    }


    /**
     * Gets the segManuTempoparadamtbf value for this DwConsol.
     * 
     * @return segManuTempoparadamtbf
     */
    public java.math.BigDecimal getSegManuTempoparadamtbf() {
        return segManuTempoparadamtbf;
    }


    /**
     * Sets the segManuTempoparadamtbf value for this DwConsol.
     * 
     * @param segManuTempoparadamtbf
     */
    public void setSegManuTempoparadamtbf(java.math.BigDecimal segManuTempoparadamtbf) {
        this.segManuTempoparadamtbf = segManuTempoparadamtbf;
    }


    /**
     * Gets the segManuTempoparadamttr value for this DwConsol.
     * 
     * @return segManuTempoparadamttr
     */
    public java.math.BigDecimal getSegManuTempoparadamttr() {
        return segManuTempoparadamttr;
    }


    /**
     * Sets the segManuTempoparadamttr value for this DwConsol.
     * 
     * @param segManuTempoparadamttr
     */
    public void setSegManuTempoparadamttr(java.math.BigDecimal segManuTempoparadamttr) {
        this.segManuTempoparadamttr = segManuTempoparadamttr;
    }


    /**
     * Gets the segManuTempoparadapa value for this DwConsol.
     * 
     * @return segManuTempoparadapa
     */
    public java.math.BigDecimal getSegManuTempoparadapa() {
        return segManuTempoparadapa;
    }


    /**
     * Sets the segManuTempoparadapa value for this DwConsol.
     * 
     * @param segManuTempoparadapa
     */
    public void setSegManuTempoparadapa(java.math.BigDecimal segManuTempoparadapa) {
        this.segManuTempoparadapa = segManuTempoparadapa;
    }


    /**
     * Gets the segManuTempoparadapao value for this DwConsol.
     * 
     * @return segManuTempoparadapao
     */
    public java.math.BigDecimal getSegManuTempoparadapao() {
        return segManuTempoparadapao;
    }


    /**
     * Sets the segManuTempoparadapao value for this DwConsol.
     * 
     * @param segManuTempoparadapao
     */
    public void setSegManuTempoparadapao(java.math.BigDecimal segManuTempoparadapao) {
        this.segManuTempoparadapao = segManuTempoparadapao;
    }


    /**
     * Gets the segManuTempoparadapp value for this DwConsol.
     * 
     * @return segManuTempoparadapp
     */
    public java.math.BigDecimal getSegManuTempoparadapp() {
        return segManuTempoparadapp;
    }


    /**
     * Sets the segManuTempoparadapp value for this DwConsol.
     * 
     * @param segManuTempoparadapp
     */
    public void setSegManuTempoparadapp(java.math.BigDecimal segManuTempoparadapp) {
        this.segManuTempoparadapp = segManuTempoparadapp;
    }


    /**
     * Gets the segManuTempoparadaprev value for this DwConsol.
     * 
     * @return segManuTempoparadaprev
     */
    public java.math.BigDecimal getSegManuTempoparadaprev() {
        return segManuTempoparadaprev;
    }


    /**
     * Sets the segManuTempoparadaprev value for this DwConsol.
     * 
     * @param segManuTempoparadaprev
     */
    public void setSegManuTempoparadaprev(java.math.BigDecimal segManuTempoparadaprev) {
        this.segManuTempoparadaprev = segManuTempoparadaprev;
    }


    /**
     * Gets the segManuTempoparadaptp value for this DwConsol.
     * 
     * @return segManuTempoparadaptp
     */
    public java.math.BigDecimal getSegManuTempoparadaptp() {
        return segManuTempoparadaptp;
    }


    /**
     * Sets the segManuTempoparadaptp value for this DwConsol.
     * 
     * @param segManuTempoparadaptp
     */
    public void setSegManuTempoparadaptp(java.math.BigDecimal segManuTempoparadaptp) {
        this.segManuTempoparadaptp = segManuTempoparadaptp;
    }


    /**
     * Gets the segManuTempoparadaregulagem value for this DwConsol.
     * 
     * @return segManuTempoparadaregulagem
     */
    public java.math.BigDecimal getSegManuTempoparadaregulagem() {
        return segManuTempoparadaregulagem;
    }


    /**
     * Sets the segManuTempoparadaregulagem value for this DwConsol.
     * 
     * @param segManuTempoparadaregulagem
     */
    public void setSegManuTempoparadaregulagem(java.math.BigDecimal segManuTempoparadaregulagem) {
        this.segManuTempoparadaregulagem = segManuTempoparadaregulagem;
    }


    /**
     * Gets the segManuTempoparadascp value for this DwConsol.
     * 
     * @return segManuTempoparadascp
     */
    public java.math.BigDecimal getSegManuTempoparadascp() {
        return segManuTempoparadascp;
    }


    /**
     * Sets the segManuTempoparadascp value for this DwConsol.
     * 
     * @param segManuTempoparadascp
     */
    public void setSegManuTempoparadascp(java.math.BigDecimal segManuTempoparadascp) {
        this.segManuTempoparadascp = segManuTempoparadascp;
    }


    /**
     * Gets the segManuTempoprodutivo value for this DwConsol.
     * 
     * @return segManuTempoprodutivo
     */
    public java.math.BigDecimal getSegManuTempoprodutivo() {
        return segManuTempoprodutivo;
    }


    /**
     * Sets the segManuTempoprodutivo value for this DwConsol.
     * 
     * @param segManuTempoprodutivo
     */
    public void setSegManuTempoprodutivo(java.math.BigDecimal segManuTempoprodutivo) {
        this.segManuTempoprodutivo = segManuTempoprodutivo;
    }


    /**
     * Gets the segManuTemporefugadas value for this DwConsol.
     * 
     * @return segManuTemporefugadas
     */
    public java.math.BigDecimal getSegManuTemporefugadas() {
        return segManuTemporefugadas;
    }


    /**
     * Sets the segManuTemporefugadas value for this DwConsol.
     * 
     * @param segManuTemporefugadas
     */
    public void setSegManuTemporefugadas(java.math.BigDecimal segManuTemporefugadas) {
        this.segManuTemporefugadas = segManuTemporefugadas;
    }


    /**
     * Gets the segManuTempotrabalhado value for this DwConsol.
     * 
     * @return segManuTempotrabalhado
     */
    public java.math.BigDecimal getSegManuTempotrabalhado() {
        return segManuTempotrabalhado;
    }


    /**
     * Sets the segManuTempotrabalhado value for this DwConsol.
     * 
     * @param segManuTempotrabalhado
     */
    public void setSegManuTempotrabalhado(java.math.BigDecimal segManuTempotrabalhado) {
        this.segManuTempotrabalhado = segManuTempotrabalhado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsol)) return false;
        DwConsol other = (DwConsol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsolals==null && other.getDwConsolals()==null) || 
             (this.dwConsolals!=null &&
              java.util.Arrays.equals(this.dwConsolals, other.getDwConsolals()))) &&
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            ((this.dwConsollogs==null && other.getDwConsollogs()==null) || 
             (this.dwConsollogs!=null &&
              java.util.Arrays.equals(this.dwConsollogs, other.getDwConsollogs()))) &&
            ((this.dwConsolmedparams==null && other.getDwConsolmedparams()==null) || 
             (this.dwConsolmedparams!=null &&
              java.util.Arrays.equals(this.dwConsolmedparams, other.getDwConsolmedparams()))) &&
            ((this.dwConsolmos==null && other.getDwConsolmos()==null) || 
             (this.dwConsolmos!=null &&
              java.util.Arrays.equals(this.dwConsolmos, other.getDwConsolmos()))) &&
            ((this.dwConsolpas==null && other.getDwConsolpas()==null) || 
             (this.dwConsolpas!=null &&
              java.util.Arrays.equals(this.dwConsolpas, other.getDwConsolpas()))) &&
            ((this.dwConsolpemps==null && other.getDwConsolpemps()==null) || 
             (this.dwConsolpemps!=null &&
              java.util.Arrays.equals(this.dwConsolpemps, other.getDwConsolpemps()))) &&
            ((this.dwConsolprs==null && other.getDwConsolprs()==null) || 
             (this.dwConsolprs!=null &&
              java.util.Arrays.equals(this.dwConsolprs, other.getDwConsolprs()))) &&
            ((this.dwConsolres==null && other.getDwConsolres()==null) || 
             (this.dwConsolres!=null &&
              java.util.Arrays.equals(this.dwConsolres, other.getDwConsolres()))) &&
            ((this.GAutoPesoBruto==null && other.getGAutoPesoBruto()==null) || 
             (this.GAutoPesoBruto!=null &&
              this.GAutoPesoBruto.equals(other.getGAutoPesoBruto()))) &&
            ((this.GAutoPesoLiquido==null && other.getGAutoPesoLiquido()==null) || 
             (this.GAutoPesoLiquido!=null &&
              this.GAutoPesoLiquido.equals(other.getGAutoPesoLiquido()))) &&
            ((this.GManuPesoBruto==null && other.getGManuPesoBruto()==null) || 
             (this.GManuPesoBruto!=null &&
              this.GManuPesoBruto.equals(other.getGManuPesoBruto()))) &&
            ((this.GManuPesoLiquido==null && other.getGManuPesoLiquido()==null) || 
             (this.GManuPesoLiquido!=null &&
              this.GManuPesoLiquido.equals(other.getGManuPesoLiquido()))) &&
            this.idConsol == other.getIdConsol() &&
            ((this.pcsAutoCavAtivas==null && other.getPcsAutoCavAtivas()==null) || 
             (this.pcsAutoCavAtivas!=null &&
              this.pcsAutoCavAtivas.equals(other.getPcsAutoCavAtivas()))) &&
            ((this.pcsAutoCavTotal==null && other.getPcsAutoCavTotal()==null) || 
             (this.pcsAutoCavTotal!=null &&
              this.pcsAutoCavTotal.equals(other.getPcsAutoCavTotal()))) &&
            ((this.pcsAutoPerdacavidades==null && other.getPcsAutoPerdacavidades()==null) || 
             (this.pcsAutoPerdacavidades!=null &&
              this.pcsAutoPerdacavidades.equals(other.getPcsAutoPerdacavidades()))) &&
            ((this.pcsAutoPerdaciclo==null && other.getPcsAutoPerdaciclo()==null) || 
             (this.pcsAutoPerdaciclo!=null &&
              this.pcsAutoPerdaciclo.equals(other.getPcsAutoPerdaciclo()))) &&
            ((this.pcsAutoPerdaparadaCp==null && other.getPcsAutoPerdaparadaCp()==null) || 
             (this.pcsAutoPerdaparadaCp!=null &&
              this.pcsAutoPerdaparadaCp.equals(other.getPcsAutoPerdaparadaCp()))) &&
            ((this.pcsAutoPerdaparadaSp==null && other.getPcsAutoPerdaparadaSp()==null) || 
             (this.pcsAutoPerdaparadaSp!=null &&
              this.pcsAutoPerdaparadaSp.equals(other.getPcsAutoPerdaparadaSp()))) &&
            ((this.pcsAutoProducaobruta==null && other.getPcsAutoProducaobruta()==null) || 
             (this.pcsAutoProducaobruta!=null &&
              this.pcsAutoProducaobruta.equals(other.getPcsAutoProducaobruta()))) &&
            ((this.pcsAutoProducaoprevista==null && other.getPcsAutoProducaoprevista()==null) || 
             (this.pcsAutoProducaoprevista!=null &&
              this.pcsAutoProducaoprevista.equals(other.getPcsAutoProducaoprevista()))) &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuCavAtivas==null && other.getPcsManuCavAtivas()==null) || 
             (this.pcsManuCavAtivas!=null &&
              this.pcsManuCavAtivas.equals(other.getPcsManuCavAtivas()))) &&
            ((this.pcsManuCavTotal==null && other.getPcsManuCavTotal()==null) || 
             (this.pcsManuCavTotal!=null &&
              this.pcsManuCavTotal.equals(other.getPcsManuCavTotal()))) &&
            ((this.pcsManuPerdacavidades==null && other.getPcsManuPerdacavidades()==null) || 
             (this.pcsManuPerdacavidades!=null &&
              this.pcsManuPerdacavidades.equals(other.getPcsManuPerdacavidades()))) &&
            ((this.pcsManuPerdaciclo==null && other.getPcsManuPerdaciclo()==null) || 
             (this.pcsManuPerdaciclo!=null &&
              this.pcsManuPerdaciclo.equals(other.getPcsManuPerdaciclo()))) &&
            ((this.pcsManuPerdaparadaSp==null && other.getPcsManuPerdaparadaSp()==null) || 
             (this.pcsManuPerdaparadaSp!=null &&
              this.pcsManuPerdaparadaSp.equals(other.getPcsManuPerdaparadaSp()))) &&
            ((this.pcsManuProducaobruta==null && other.getPcsManuProducaobruta()==null) || 
             (this.pcsManuProducaobruta!=null &&
              this.pcsManuProducaobruta.equals(other.getPcsManuProducaobruta()))) &&
            ((this.pcsManuProducaoprevista==null && other.getPcsManuProducaoprevista()==null) || 
             (this.pcsManuProducaoprevista!=null &&
              this.pcsManuProducaoprevista.equals(other.getPcsManuProducaoprevista()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada()))) &&
            ((this.qtAutoCicloimprodutivo==null && other.getQtAutoCicloimprodutivo()==null) || 
             (this.qtAutoCicloimprodutivo!=null &&
              this.qtAutoCicloimprodutivo.equals(other.getQtAutoCicloimprodutivo()))) &&
            ((this.qtAutoCicloprodutivo==null && other.getQtAutoCicloprodutivo()==null) || 
             (this.qtAutoCicloprodutivo!=null &&
              this.qtAutoCicloprodutivo.equals(other.getQtAutoCicloprodutivo()))) &&
            ((this.qtAutoCicloregulagem==null && other.getQtAutoCicloregulagem()==null) || 
             (this.qtAutoCicloregulagem!=null &&
              this.qtAutoCicloregulagem.equals(other.getQtAutoCicloregulagem()))) &&
            ((this.qtAutoOcoparadaCp==null && other.getQtAutoOcoparadaCp()==null) || 
             (this.qtAutoOcoparadaCp!=null &&
              this.qtAutoOcoparadaCp.equals(other.getQtAutoOcoparadaCp()))) &&
            ((this.qtAutoOcoparadaCpVr==null && other.getQtAutoOcoparadaCpVr()==null) || 
             (this.qtAutoOcoparadaCpVr!=null &&
              this.qtAutoOcoparadaCpVr.equals(other.getQtAutoOcoparadaCpVr()))) &&
            ((this.qtAutoOcoparadaSp==null && other.getQtAutoOcoparadaSp()==null) || 
             (this.qtAutoOcoparadaSp!=null &&
              this.qtAutoOcoparadaSp.equals(other.getQtAutoOcoparadaSp()))) &&
            ((this.qtAutoOcoparadaSpVr==null && other.getQtAutoOcoparadaSpVr()==null) || 
             (this.qtAutoOcoparadaSpVr!=null &&
              this.qtAutoOcoparadaSpVr.equals(other.getQtAutoOcoparadaSpVr()))) &&
            ((this.qtAutoOcoparadafds==null && other.getQtAutoOcoparadafds()==null) || 
             (this.qtAutoOcoparadafds!=null &&
              this.qtAutoOcoparadafds.equals(other.getQtAutoOcoparadafds()))) &&
            ((this.qtAutoOcoparadaimprev==null && other.getQtAutoOcoparadaimprev()==null) || 
             (this.qtAutoOcoparadaimprev!=null &&
              this.qtAutoOcoparadaimprev.equals(other.getQtAutoOcoparadaimprev()))) &&
            ((this.qtAutoOcoparadamdo==null && other.getQtAutoOcoparadamdo()==null) || 
             (this.qtAutoOcoparadamdo!=null &&
              this.qtAutoOcoparadamdo.equals(other.getQtAutoOcoparadamdo()))) &&
            ((this.qtAutoOcoparadamtbf==null && other.getQtAutoOcoparadamtbf()==null) || 
             (this.qtAutoOcoparadamtbf!=null &&
              this.qtAutoOcoparadamtbf.equals(other.getQtAutoOcoparadamtbf()))) &&
            ((this.qtAutoOcoparadamttr==null && other.getQtAutoOcoparadamttr()==null) || 
             (this.qtAutoOcoparadamttr!=null &&
              this.qtAutoOcoparadamttr.equals(other.getQtAutoOcoparadamttr()))) &&
            ((this.qtAutoOcoparadapa==null && other.getQtAutoOcoparadapa()==null) || 
             (this.qtAutoOcoparadapa!=null &&
              this.qtAutoOcoparadapa.equals(other.getQtAutoOcoparadapa()))) &&
            ((this.qtAutoOcoparadapao==null && other.getQtAutoOcoparadapao()==null) || 
             (this.qtAutoOcoparadapao!=null &&
              this.qtAutoOcoparadapao.equals(other.getQtAutoOcoparadapao()))) &&
            ((this.qtAutoOcoparadapp==null && other.getQtAutoOcoparadapp()==null) || 
             (this.qtAutoOcoparadapp!=null &&
              this.qtAutoOcoparadapp.equals(other.getQtAutoOcoparadapp()))) &&
            ((this.qtAutoOcoparadaprev==null && other.getQtAutoOcoparadaprev()==null) || 
             (this.qtAutoOcoparadaprev!=null &&
              this.qtAutoOcoparadaprev.equals(other.getQtAutoOcoparadaprev()))) &&
            ((this.qtAutoOcoparadaptp==null && other.getQtAutoOcoparadaptp()==null) || 
             (this.qtAutoOcoparadaptp!=null &&
              this.qtAutoOcoparadaptp.equals(other.getQtAutoOcoparadaptp()))) &&
            ((this.qtAutoOcoparadaregulagem==null && other.getQtAutoOcoparadaregulagem()==null) || 
             (this.qtAutoOcoparadaregulagem!=null &&
              this.qtAutoOcoparadaregulagem.equals(other.getQtAutoOcoparadaregulagem()))) &&
            ((this.qtAutoOcoparadascp==null && other.getQtAutoOcoparadascp()==null) || 
             (this.qtAutoOcoparadascp!=null &&
              this.qtAutoOcoparadascp.equals(other.getQtAutoOcoparadascp()))) &&
            ((this.qtAutoTempoparadaDefault==null && other.getQtAutoTempoparadaDefault()==null) || 
             (this.qtAutoTempoparadaDefault!=null &&
              this.qtAutoTempoparadaDefault.equals(other.getQtAutoTempoparadaDefault()))) &&
            ((this.qtAutoTempoparadaSemCnx==null && other.getQtAutoTempoparadaSemCnx()==null) || 
             (this.qtAutoTempoparadaSemCnx!=null &&
              this.qtAutoTempoparadaSemCnx.equals(other.getQtAutoTempoparadaSemCnx()))) &&
            ((this.qtAutoTempoparadaSemEvt==null && other.getQtAutoTempoparadaSemEvt()==null) || 
             (this.qtAutoTempoparadaSemEvt!=null &&
              this.qtAutoTempoparadaSemEvt.equals(other.getQtAutoTempoparadaSemEvt()))) &&
            ((this.qtAutoTempoparadaSemOp==null && other.getQtAutoTempoparadaSemOp()==null) || 
             (this.qtAutoTempoparadaSemOp!=null &&
              this.qtAutoTempoparadaSemOp.equals(other.getQtAutoTempoparadaSemOp()))) &&
            ((this.qtManuCicloimprodutivo==null && other.getQtManuCicloimprodutivo()==null) || 
             (this.qtManuCicloimprodutivo!=null &&
              this.qtManuCicloimprodutivo.equals(other.getQtManuCicloimprodutivo()))) &&
            ((this.qtManuCicloprodutivo==null && other.getQtManuCicloprodutivo()==null) || 
             (this.qtManuCicloprodutivo!=null &&
              this.qtManuCicloprodutivo.equals(other.getQtManuCicloprodutivo()))) &&
            ((this.qtManuCicloregulagem==null && other.getQtManuCicloregulagem()==null) || 
             (this.qtManuCicloregulagem!=null &&
              this.qtManuCicloregulagem.equals(other.getQtManuCicloregulagem()))) &&
            ((this.qtManuOcoparadaCp==null && other.getQtManuOcoparadaCp()==null) || 
             (this.qtManuOcoparadaCp!=null &&
              this.qtManuOcoparadaCp.equals(other.getQtManuOcoparadaCp()))) &&
            ((this.qtManuOcoparadaCpVr==null && other.getQtManuOcoparadaCpVr()==null) || 
             (this.qtManuOcoparadaCpVr!=null &&
              this.qtManuOcoparadaCpVr.equals(other.getQtManuOcoparadaCpVr()))) &&
            ((this.qtManuOcoparadaSp==null && other.getQtManuOcoparadaSp()==null) || 
             (this.qtManuOcoparadaSp!=null &&
              this.qtManuOcoparadaSp.equals(other.getQtManuOcoparadaSp()))) &&
            ((this.qtManuOcoparadaSpVr==null && other.getQtManuOcoparadaSpVr()==null) || 
             (this.qtManuOcoparadaSpVr!=null &&
              this.qtManuOcoparadaSpVr.equals(other.getQtManuOcoparadaSpVr()))) &&
            ((this.qtManuOcoparadafds==null && other.getQtManuOcoparadafds()==null) || 
             (this.qtManuOcoparadafds!=null &&
              this.qtManuOcoparadafds.equals(other.getQtManuOcoparadafds()))) &&
            ((this.qtManuOcoparadaimprev==null && other.getQtManuOcoparadaimprev()==null) || 
             (this.qtManuOcoparadaimprev!=null &&
              this.qtManuOcoparadaimprev.equals(other.getQtManuOcoparadaimprev()))) &&
            ((this.qtManuOcoparadamdo==null && other.getQtManuOcoparadamdo()==null) || 
             (this.qtManuOcoparadamdo!=null &&
              this.qtManuOcoparadamdo.equals(other.getQtManuOcoparadamdo()))) &&
            ((this.qtManuOcoparadamtbf==null && other.getQtManuOcoparadamtbf()==null) || 
             (this.qtManuOcoparadamtbf!=null &&
              this.qtManuOcoparadamtbf.equals(other.getQtManuOcoparadamtbf()))) &&
            ((this.qtManuOcoparadamttr==null && other.getQtManuOcoparadamttr()==null) || 
             (this.qtManuOcoparadamttr!=null &&
              this.qtManuOcoparadamttr.equals(other.getQtManuOcoparadamttr()))) &&
            ((this.qtManuOcoparadapa==null && other.getQtManuOcoparadapa()==null) || 
             (this.qtManuOcoparadapa!=null &&
              this.qtManuOcoparadapa.equals(other.getQtManuOcoparadapa()))) &&
            ((this.qtManuOcoparadapao==null && other.getQtManuOcoparadapao()==null) || 
             (this.qtManuOcoparadapao!=null &&
              this.qtManuOcoparadapao.equals(other.getQtManuOcoparadapao()))) &&
            ((this.qtManuOcoparadapp==null && other.getQtManuOcoparadapp()==null) || 
             (this.qtManuOcoparadapp!=null &&
              this.qtManuOcoparadapp.equals(other.getQtManuOcoparadapp()))) &&
            ((this.qtManuOcoparadaprev==null && other.getQtManuOcoparadaprev()==null) || 
             (this.qtManuOcoparadaprev!=null &&
              this.qtManuOcoparadaprev.equals(other.getQtManuOcoparadaprev()))) &&
            ((this.qtManuOcoparadaptp==null && other.getQtManuOcoparadaptp()==null) || 
             (this.qtManuOcoparadaptp!=null &&
              this.qtManuOcoparadaptp.equals(other.getQtManuOcoparadaptp()))) &&
            ((this.qtManuOcoparadaregulagem==null && other.getQtManuOcoparadaregulagem()==null) || 
             (this.qtManuOcoparadaregulagem!=null &&
              this.qtManuOcoparadaregulagem.equals(other.getQtManuOcoparadaregulagem()))) &&
            ((this.qtManuOcoparadascp==null && other.getQtManuOcoparadascp()==null) || 
             (this.qtManuOcoparadascp!=null &&
              this.qtManuOcoparadascp.equals(other.getQtManuOcoparadascp()))) &&
            ((this.qtManuTempoparadaDefault==null && other.getQtManuTempoparadaDefault()==null) || 
             (this.qtManuTempoparadaDefault!=null &&
              this.qtManuTempoparadaDefault.equals(other.getQtManuTempoparadaDefault()))) &&
            ((this.qtManuTempoparadaSemCnx==null && other.getQtManuTempoparadaSemCnx()==null) || 
             (this.qtManuTempoparadaSemCnx!=null &&
              this.qtManuTempoparadaSemCnx.equals(other.getQtManuTempoparadaSemCnx()))) &&
            ((this.qtManuTempoparadaSemEvt==null && other.getQtManuTempoparadaSemEvt()==null) || 
             (this.qtManuTempoparadaSemEvt!=null &&
              this.qtManuTempoparadaSemEvt.equals(other.getQtManuTempoparadaSemEvt()))) &&
            ((this.qtManuTempoparadaSemOp==null && other.getQtManuTempoparadaSemOp()==null) || 
             (this.qtManuTempoparadaSemOp!=null &&
              this.qtManuTempoparadaSemOp.equals(other.getQtManuTempoparadaSemOp()))) &&
            ((this.segAutoBoas==null && other.getSegAutoBoas()==null) || 
             (this.segAutoBoas!=null &&
              this.segAutoBoas.equals(other.getSegAutoBoas()))) &&
            ((this.segAutoCicloimprodutivo==null && other.getSegAutoCicloimprodutivo()==null) || 
             (this.segAutoCicloimprodutivo!=null &&
              this.segAutoCicloimprodutivo.equals(other.getSegAutoCicloimprodutivo()))) &&
            ((this.segAutoCicloimprodutivoCta==null && other.getSegAutoCicloimprodutivoCta()==null) || 
             (this.segAutoCicloimprodutivoCta!=null &&
              this.segAutoCicloimprodutivoCta.equals(other.getSegAutoCicloimprodutivoCta()))) &&
            ((this.segAutoCiclomedio==null && other.getSegAutoCiclomedio()==null) || 
             (this.segAutoCiclomedio!=null &&
              this.segAutoCiclomedio.equals(other.getSegAutoCiclomedio()))) &&
            ((this.segAutoCiclopadrao==null && other.getSegAutoCiclopadrao()==null) || 
             (this.segAutoCiclopadrao!=null &&
              this.segAutoCiclopadrao.equals(other.getSegAutoCiclopadrao()))) &&
            ((this.segAutoCicloprodutivo==null && other.getSegAutoCicloprodutivo()==null) || 
             (this.segAutoCicloprodutivo!=null &&
              this.segAutoCicloprodutivo.equals(other.getSegAutoCicloprodutivo()))) &&
            ((this.segAutoCicloprodutivoCta==null && other.getSegAutoCicloprodutivoCta()==null) || 
             (this.segAutoCicloprodutivoCta!=null &&
              this.segAutoCicloprodutivoCta.equals(other.getSegAutoCicloprodutivoCta()))) &&
            ((this.segAutoCta==null && other.getSegAutoCta()==null) || 
             (this.segAutoCta!=null &&
              this.segAutoCta.equals(other.getSegAutoCta()))) &&
            ((this.segAutoPerdacav==null && other.getSegAutoPerdacav()==null) || 
             (this.segAutoPerdacav!=null &&
              this.segAutoPerdacav.equals(other.getSegAutoPerdacav()))) &&
            ((this.segAutoPerdaciclo==null && other.getSegAutoPerdaciclo()==null) || 
             (this.segAutoPerdaciclo!=null &&
              this.segAutoPerdaciclo.equals(other.getSegAutoPerdaciclo()))) &&
            ((this.segAutoRitmo==null && other.getSegAutoRitmo()==null) || 
             (this.segAutoRitmo!=null &&
              this.segAutoRitmo.equals(other.getSegAutoRitmo()))) &&
            ((this.segAutoTempoalerta==null && other.getSegAutoTempoalerta()==null) || 
             (this.segAutoTempoalerta!=null &&
              this.segAutoTempoalerta.equals(other.getSegAutoTempoalerta()))) &&
            ((this.segAutoTempoativo==null && other.getSegAutoTempoativo()==null) || 
             (this.segAutoTempoativo!=null &&
              this.segAutoTempoativo.equals(other.getSegAutoTempoativo()))) &&
            ((this.segAutoTempocalendario==null && other.getSegAutoTempocalendario()==null) || 
             (this.segAutoTempocalendario!=null &&
              this.segAutoTempocalendario.equals(other.getSegAutoTempocalendario()))) &&
            ((this.segAutoTempocalsempeso==null && other.getSegAutoTempocalsempeso()==null) || 
             (this.segAutoTempocalsempeso!=null &&
              this.segAutoTempocalsempeso.equals(other.getSegAutoTempocalsempeso()))) &&
            ((this.segAutoTempoparadaAb==null && other.getSegAutoTempoparadaAb()==null) || 
             (this.segAutoTempoparadaAb!=null &&
              this.segAutoTempoparadaAb.equals(other.getSegAutoTempoparadaAb()))) &&
            ((this.segAutoTempoparadaCp==null && other.getSegAutoTempoparadaCp()==null) || 
             (this.segAutoTempoparadaCp!=null &&
              this.segAutoTempoparadaCp.equals(other.getSegAutoTempoparadaCp()))) &&
            ((this.segAutoTempoparadaCpVr==null && other.getSegAutoTempoparadaCpVr()==null) || 
             (this.segAutoTempoparadaCpVr!=null &&
              this.segAutoTempoparadaCpVr.equals(other.getSegAutoTempoparadaCpVr()))) &&
            ((this.segAutoTempoparadaDefault==null && other.getSegAutoTempoparadaDefault()==null) || 
             (this.segAutoTempoparadaDefault!=null &&
              this.segAutoTempoparadaDefault.equals(other.getSegAutoTempoparadaDefault()))) &&
            ((this.segAutoTempoparadaSemCnx==null && other.getSegAutoTempoparadaSemCnx()==null) || 
             (this.segAutoTempoparadaSemCnx!=null &&
              this.segAutoTempoparadaSemCnx.equals(other.getSegAutoTempoparadaSemCnx()))) &&
            ((this.segAutoTempoparadaSemEvt==null && other.getSegAutoTempoparadaSemEvt()==null) || 
             (this.segAutoTempoparadaSemEvt!=null &&
              this.segAutoTempoparadaSemEvt.equals(other.getSegAutoTempoparadaSemEvt()))) &&
            ((this.segAutoTempoparadaSemOp==null && other.getSegAutoTempoparadaSemOp()==null) || 
             (this.segAutoTempoparadaSemOp!=null &&
              this.segAutoTempoparadaSemOp.equals(other.getSegAutoTempoparadaSemOp()))) &&
            ((this.segAutoTempoparadaSp==null && other.getSegAutoTempoparadaSp()==null) || 
             (this.segAutoTempoparadaSp!=null &&
              this.segAutoTempoparadaSp.equals(other.getSegAutoTempoparadaSp()))) &&
            ((this.segAutoTempoparadaSpVr==null && other.getSegAutoTempoparadaSpVr()==null) || 
             (this.segAutoTempoparadaSpVr!=null &&
              this.segAutoTempoparadaSpVr.equals(other.getSegAutoTempoparadaSpVr()))) &&
            ((this.segAutoTempoparadafds==null && other.getSegAutoTempoparadafds()==null) || 
             (this.segAutoTempoparadafds!=null &&
              this.segAutoTempoparadafds.equals(other.getSegAutoTempoparadafds()))) &&
            ((this.segAutoTempoparadaimprev==null && other.getSegAutoTempoparadaimprev()==null) || 
             (this.segAutoTempoparadaimprev!=null &&
              this.segAutoTempoparadaimprev.equals(other.getSegAutoTempoparadaimprev()))) &&
            ((this.segAutoTempoparadamdo==null && other.getSegAutoTempoparadamdo()==null) || 
             (this.segAutoTempoparadamdo!=null &&
              this.segAutoTempoparadamdo.equals(other.getSegAutoTempoparadamdo()))) &&
            ((this.segAutoTempoparadamtbf==null && other.getSegAutoTempoparadamtbf()==null) || 
             (this.segAutoTempoparadamtbf!=null &&
              this.segAutoTempoparadamtbf.equals(other.getSegAutoTempoparadamtbf()))) &&
            ((this.segAutoTempoparadamttr==null && other.getSegAutoTempoparadamttr()==null) || 
             (this.segAutoTempoparadamttr!=null &&
              this.segAutoTempoparadamttr.equals(other.getSegAutoTempoparadamttr()))) &&
            ((this.segAutoTempoparadapa==null && other.getSegAutoTempoparadapa()==null) || 
             (this.segAutoTempoparadapa!=null &&
              this.segAutoTempoparadapa.equals(other.getSegAutoTempoparadapa()))) &&
            ((this.segAutoTempoparadapao==null && other.getSegAutoTempoparadapao()==null) || 
             (this.segAutoTempoparadapao!=null &&
              this.segAutoTempoparadapao.equals(other.getSegAutoTempoparadapao()))) &&
            ((this.segAutoTempoparadapp==null && other.getSegAutoTempoparadapp()==null) || 
             (this.segAutoTempoparadapp!=null &&
              this.segAutoTempoparadapp.equals(other.getSegAutoTempoparadapp()))) &&
            ((this.segAutoTempoparadaprev==null && other.getSegAutoTempoparadaprev()==null) || 
             (this.segAutoTempoparadaprev!=null &&
              this.segAutoTempoparadaprev.equals(other.getSegAutoTempoparadaprev()))) &&
            ((this.segAutoTempoparadaptp==null && other.getSegAutoTempoparadaptp()==null) || 
             (this.segAutoTempoparadaptp!=null &&
              this.segAutoTempoparadaptp.equals(other.getSegAutoTempoparadaptp()))) &&
            ((this.segAutoTempoparadaregulagem==null && other.getSegAutoTempoparadaregulagem()==null) || 
             (this.segAutoTempoparadaregulagem!=null &&
              this.segAutoTempoparadaregulagem.equals(other.getSegAutoTempoparadaregulagem()))) &&
            ((this.segAutoTempoparadascp==null && other.getSegAutoTempoparadascp()==null) || 
             (this.segAutoTempoparadascp!=null &&
              this.segAutoTempoparadascp.equals(other.getSegAutoTempoparadascp()))) &&
            ((this.segAutoTempoprodutivo==null && other.getSegAutoTempoprodutivo()==null) || 
             (this.segAutoTempoprodutivo!=null &&
              this.segAutoTempoprodutivo.equals(other.getSegAutoTempoprodutivo()))) &&
            ((this.segAutoTemporefugadas==null && other.getSegAutoTemporefugadas()==null) || 
             (this.segAutoTemporefugadas!=null &&
              this.segAutoTemporefugadas.equals(other.getSegAutoTemporefugadas()))) &&
            ((this.segAutoTempotrabalhado==null && other.getSegAutoTempotrabalhado()==null) || 
             (this.segAutoTempotrabalhado!=null &&
              this.segAutoTempotrabalhado.equals(other.getSegAutoTempotrabalhado()))) &&
            ((this.segManuBoas==null && other.getSegManuBoas()==null) || 
             (this.segManuBoas!=null &&
              this.segManuBoas.equals(other.getSegManuBoas()))) &&
            ((this.segManuCicloimprodutivo==null && other.getSegManuCicloimprodutivo()==null) || 
             (this.segManuCicloimprodutivo!=null &&
              this.segManuCicloimprodutivo.equals(other.getSegManuCicloimprodutivo()))) &&
            ((this.segManuCicloimprodutivoCta==null && other.getSegManuCicloimprodutivoCta()==null) || 
             (this.segManuCicloimprodutivoCta!=null &&
              this.segManuCicloimprodutivoCta.equals(other.getSegManuCicloimprodutivoCta()))) &&
            ((this.segManuCiclomedio==null && other.getSegManuCiclomedio()==null) || 
             (this.segManuCiclomedio!=null &&
              this.segManuCiclomedio.equals(other.getSegManuCiclomedio()))) &&
            ((this.segManuCiclopadrao==null && other.getSegManuCiclopadrao()==null) || 
             (this.segManuCiclopadrao!=null &&
              this.segManuCiclopadrao.equals(other.getSegManuCiclopadrao()))) &&
            ((this.segManuCicloprodutivo==null && other.getSegManuCicloprodutivo()==null) || 
             (this.segManuCicloprodutivo!=null &&
              this.segManuCicloprodutivo.equals(other.getSegManuCicloprodutivo()))) &&
            ((this.segManuCicloprodutivoCta==null && other.getSegManuCicloprodutivoCta()==null) || 
             (this.segManuCicloprodutivoCta!=null &&
              this.segManuCicloprodutivoCta.equals(other.getSegManuCicloprodutivoCta()))) &&
            ((this.segManuCicloregulagem==null && other.getSegManuCicloregulagem()==null) || 
             (this.segManuCicloregulagem!=null &&
              this.segManuCicloregulagem.equals(other.getSegManuCicloregulagem()))) &&
            ((this.segManuCta==null && other.getSegManuCta()==null) || 
             (this.segManuCta!=null &&
              this.segManuCta.equals(other.getSegManuCta()))) &&
            ((this.segManuPerdacav==null && other.getSegManuPerdacav()==null) || 
             (this.segManuPerdacav!=null &&
              this.segManuPerdacav.equals(other.getSegManuPerdacav()))) &&
            ((this.segManuPerdaciclo==null && other.getSegManuPerdaciclo()==null) || 
             (this.segManuPerdaciclo!=null &&
              this.segManuPerdaciclo.equals(other.getSegManuPerdaciclo()))) &&
            ((this.segManuRitmo==null && other.getSegManuRitmo()==null) || 
             (this.segManuRitmo!=null &&
              this.segManuRitmo.equals(other.getSegManuRitmo()))) &&
            ((this.segManuTempoalerta==null && other.getSegManuTempoalerta()==null) || 
             (this.segManuTempoalerta!=null &&
              this.segManuTempoalerta.equals(other.getSegManuTempoalerta()))) &&
            ((this.segManuTempoativo==null && other.getSegManuTempoativo()==null) || 
             (this.segManuTempoativo!=null &&
              this.segManuTempoativo.equals(other.getSegManuTempoativo()))) &&
            ((this.segManuTempocalendario==null && other.getSegManuTempocalendario()==null) || 
             (this.segManuTempocalendario!=null &&
              this.segManuTempocalendario.equals(other.getSegManuTempocalendario()))) &&
            ((this.segManuTempocalsempeso==null && other.getSegManuTempocalsempeso()==null) || 
             (this.segManuTempocalsempeso!=null &&
              this.segManuTempocalsempeso.equals(other.getSegManuTempocalsempeso()))) &&
            ((this.segManuTempoparadaCp==null && other.getSegManuTempoparadaCp()==null) || 
             (this.segManuTempoparadaCp!=null &&
              this.segManuTempoparadaCp.equals(other.getSegManuTempoparadaCp()))) &&
            ((this.segManuTempoparadaCpVr==null && other.getSegManuTempoparadaCpVr()==null) || 
             (this.segManuTempoparadaCpVr!=null &&
              this.segManuTempoparadaCpVr.equals(other.getSegManuTempoparadaCpVr()))) &&
            ((this.segManuTempoparadaDefault==null && other.getSegManuTempoparadaDefault()==null) || 
             (this.segManuTempoparadaDefault!=null &&
              this.segManuTempoparadaDefault.equals(other.getSegManuTempoparadaDefault()))) &&
            ((this.segManuTempoparadaSemCnx==null && other.getSegManuTempoparadaSemCnx()==null) || 
             (this.segManuTempoparadaSemCnx!=null &&
              this.segManuTempoparadaSemCnx.equals(other.getSegManuTempoparadaSemCnx()))) &&
            ((this.segManuTempoparadaSemEvt==null && other.getSegManuTempoparadaSemEvt()==null) || 
             (this.segManuTempoparadaSemEvt!=null &&
              this.segManuTempoparadaSemEvt.equals(other.getSegManuTempoparadaSemEvt()))) &&
            ((this.segManuTempoparadaSemOp==null && other.getSegManuTempoparadaSemOp()==null) || 
             (this.segManuTempoparadaSemOp!=null &&
              this.segManuTempoparadaSemOp.equals(other.getSegManuTempoparadaSemOp()))) &&
            ((this.segManuTempoparadaSp==null && other.getSegManuTempoparadaSp()==null) || 
             (this.segManuTempoparadaSp!=null &&
              this.segManuTempoparadaSp.equals(other.getSegManuTempoparadaSp()))) &&
            ((this.segManuTempoparadaSpVr==null && other.getSegManuTempoparadaSpVr()==null) || 
             (this.segManuTempoparadaSpVr!=null &&
              this.segManuTempoparadaSpVr.equals(other.getSegManuTempoparadaSpVr()))) &&
            ((this.segManuTempoparadafds==null && other.getSegManuTempoparadafds()==null) || 
             (this.segManuTempoparadafds!=null &&
              this.segManuTempoparadafds.equals(other.getSegManuTempoparadafds()))) &&
            ((this.segManuTempoparadaimprev==null && other.getSegManuTempoparadaimprev()==null) || 
             (this.segManuTempoparadaimprev!=null &&
              this.segManuTempoparadaimprev.equals(other.getSegManuTempoparadaimprev()))) &&
            ((this.segManuTempoparadamdo==null && other.getSegManuTempoparadamdo()==null) || 
             (this.segManuTempoparadamdo!=null &&
              this.segManuTempoparadamdo.equals(other.getSegManuTempoparadamdo()))) &&
            ((this.segManuTempoparadamtbf==null && other.getSegManuTempoparadamtbf()==null) || 
             (this.segManuTempoparadamtbf!=null &&
              this.segManuTempoparadamtbf.equals(other.getSegManuTempoparadamtbf()))) &&
            ((this.segManuTempoparadamttr==null && other.getSegManuTempoparadamttr()==null) || 
             (this.segManuTempoparadamttr!=null &&
              this.segManuTempoparadamttr.equals(other.getSegManuTempoparadamttr()))) &&
            ((this.segManuTempoparadapa==null && other.getSegManuTempoparadapa()==null) || 
             (this.segManuTempoparadapa!=null &&
              this.segManuTempoparadapa.equals(other.getSegManuTempoparadapa()))) &&
            ((this.segManuTempoparadapao==null && other.getSegManuTempoparadapao()==null) || 
             (this.segManuTempoparadapao!=null &&
              this.segManuTempoparadapao.equals(other.getSegManuTempoparadapao()))) &&
            ((this.segManuTempoparadapp==null && other.getSegManuTempoparadapp()==null) || 
             (this.segManuTempoparadapp!=null &&
              this.segManuTempoparadapp.equals(other.getSegManuTempoparadapp()))) &&
            ((this.segManuTempoparadaprev==null && other.getSegManuTempoparadaprev()==null) || 
             (this.segManuTempoparadaprev!=null &&
              this.segManuTempoparadaprev.equals(other.getSegManuTempoparadaprev()))) &&
            ((this.segManuTempoparadaptp==null && other.getSegManuTempoparadaptp()==null) || 
             (this.segManuTempoparadaptp!=null &&
              this.segManuTempoparadaptp.equals(other.getSegManuTempoparadaptp()))) &&
            ((this.segManuTempoparadaregulagem==null && other.getSegManuTempoparadaregulagem()==null) || 
             (this.segManuTempoparadaregulagem!=null &&
              this.segManuTempoparadaregulagem.equals(other.getSegManuTempoparadaregulagem()))) &&
            ((this.segManuTempoparadascp==null && other.getSegManuTempoparadascp()==null) || 
             (this.segManuTempoparadascp!=null &&
              this.segManuTempoparadascp.equals(other.getSegManuTempoparadascp()))) &&
            ((this.segManuTempoprodutivo==null && other.getSegManuTempoprodutivo()==null) || 
             (this.segManuTempoprodutivo!=null &&
              this.segManuTempoprodutivo.equals(other.getSegManuTempoprodutivo()))) &&
            ((this.segManuTemporefugadas==null && other.getSegManuTemporefugadas()==null) || 
             (this.segManuTemporefugadas!=null &&
              this.segManuTemporefugadas.equals(other.getSegManuTemporefugadas()))) &&
            ((this.segManuTempotrabalhado==null && other.getSegManuTempotrabalhado()==null) || 
             (this.segManuTempotrabalhado!=null &&
              this.segManuTempotrabalhado.equals(other.getSegManuTempotrabalhado())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDwConsolals() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolals());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolals(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        if (getDwConsollogs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsollogs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsollogs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmedparams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmedparams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmedparams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolpemps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolpemps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolpemps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolprs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolprs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolprs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolres() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolres());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolres(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGAutoPesoBruto() != null) {
            _hashCode += getGAutoPesoBruto().hashCode();
        }
        if (getGAutoPesoLiquido() != null) {
            _hashCode += getGAutoPesoLiquido().hashCode();
        }
        if (getGManuPesoBruto() != null) {
            _hashCode += getGManuPesoBruto().hashCode();
        }
        if (getGManuPesoLiquido() != null) {
            _hashCode += getGManuPesoLiquido().hashCode();
        }
        _hashCode += new Long(getIdConsol()).hashCode();
        if (getPcsAutoCavAtivas() != null) {
            _hashCode += getPcsAutoCavAtivas().hashCode();
        }
        if (getPcsAutoCavTotal() != null) {
            _hashCode += getPcsAutoCavTotal().hashCode();
        }
        if (getPcsAutoPerdacavidades() != null) {
            _hashCode += getPcsAutoPerdacavidades().hashCode();
        }
        if (getPcsAutoPerdaciclo() != null) {
            _hashCode += getPcsAutoPerdaciclo().hashCode();
        }
        if (getPcsAutoPerdaparadaCp() != null) {
            _hashCode += getPcsAutoPerdaparadaCp().hashCode();
        }
        if (getPcsAutoPerdaparadaSp() != null) {
            _hashCode += getPcsAutoPerdaparadaSp().hashCode();
        }
        if (getPcsAutoProducaobruta() != null) {
            _hashCode += getPcsAutoProducaobruta().hashCode();
        }
        if (getPcsAutoProducaoprevista() != null) {
            _hashCode += getPcsAutoProducaoprevista().hashCode();
        }
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuCavAtivas() != null) {
            _hashCode += getPcsManuCavAtivas().hashCode();
        }
        if (getPcsManuCavTotal() != null) {
            _hashCode += getPcsManuCavTotal().hashCode();
        }
        if (getPcsManuPerdacavidades() != null) {
            _hashCode += getPcsManuPerdacavidades().hashCode();
        }
        if (getPcsManuPerdaciclo() != null) {
            _hashCode += getPcsManuPerdaciclo().hashCode();
        }
        if (getPcsManuPerdaparadaSp() != null) {
            _hashCode += getPcsManuPerdaparadaSp().hashCode();
        }
        if (getPcsManuProducaobruta() != null) {
            _hashCode += getPcsManuProducaobruta().hashCode();
        }
        if (getPcsManuProducaoprevista() != null) {
            _hashCode += getPcsManuProducaoprevista().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        if (getQtAutoCicloimprodutivo() != null) {
            _hashCode += getQtAutoCicloimprodutivo().hashCode();
        }
        if (getQtAutoCicloprodutivo() != null) {
            _hashCode += getQtAutoCicloprodutivo().hashCode();
        }
        if (getQtAutoCicloregulagem() != null) {
            _hashCode += getQtAutoCicloregulagem().hashCode();
        }
        if (getQtAutoOcoparadaCp() != null) {
            _hashCode += getQtAutoOcoparadaCp().hashCode();
        }
        if (getQtAutoOcoparadaCpVr() != null) {
            _hashCode += getQtAutoOcoparadaCpVr().hashCode();
        }
        if (getQtAutoOcoparadaSp() != null) {
            _hashCode += getQtAutoOcoparadaSp().hashCode();
        }
        if (getQtAutoOcoparadaSpVr() != null) {
            _hashCode += getQtAutoOcoparadaSpVr().hashCode();
        }
        if (getQtAutoOcoparadafds() != null) {
            _hashCode += getQtAutoOcoparadafds().hashCode();
        }
        if (getQtAutoOcoparadaimprev() != null) {
            _hashCode += getQtAutoOcoparadaimprev().hashCode();
        }
        if (getQtAutoOcoparadamdo() != null) {
            _hashCode += getQtAutoOcoparadamdo().hashCode();
        }
        if (getQtAutoOcoparadamtbf() != null) {
            _hashCode += getQtAutoOcoparadamtbf().hashCode();
        }
        if (getQtAutoOcoparadamttr() != null) {
            _hashCode += getQtAutoOcoparadamttr().hashCode();
        }
        if (getQtAutoOcoparadapa() != null) {
            _hashCode += getQtAutoOcoparadapa().hashCode();
        }
        if (getQtAutoOcoparadapao() != null) {
            _hashCode += getQtAutoOcoparadapao().hashCode();
        }
        if (getQtAutoOcoparadapp() != null) {
            _hashCode += getQtAutoOcoparadapp().hashCode();
        }
        if (getQtAutoOcoparadaprev() != null) {
            _hashCode += getQtAutoOcoparadaprev().hashCode();
        }
        if (getQtAutoOcoparadaptp() != null) {
            _hashCode += getQtAutoOcoparadaptp().hashCode();
        }
        if (getQtAutoOcoparadaregulagem() != null) {
            _hashCode += getQtAutoOcoparadaregulagem().hashCode();
        }
        if (getQtAutoOcoparadascp() != null) {
            _hashCode += getQtAutoOcoparadascp().hashCode();
        }
        if (getQtAutoTempoparadaDefault() != null) {
            _hashCode += getQtAutoTempoparadaDefault().hashCode();
        }
        if (getQtAutoTempoparadaSemCnx() != null) {
            _hashCode += getQtAutoTempoparadaSemCnx().hashCode();
        }
        if (getQtAutoTempoparadaSemEvt() != null) {
            _hashCode += getQtAutoTempoparadaSemEvt().hashCode();
        }
        if (getQtAutoTempoparadaSemOp() != null) {
            _hashCode += getQtAutoTempoparadaSemOp().hashCode();
        }
        if (getQtManuCicloimprodutivo() != null) {
            _hashCode += getQtManuCicloimprodutivo().hashCode();
        }
        if (getQtManuCicloprodutivo() != null) {
            _hashCode += getQtManuCicloprodutivo().hashCode();
        }
        if (getQtManuCicloregulagem() != null) {
            _hashCode += getQtManuCicloregulagem().hashCode();
        }
        if (getQtManuOcoparadaCp() != null) {
            _hashCode += getQtManuOcoparadaCp().hashCode();
        }
        if (getQtManuOcoparadaCpVr() != null) {
            _hashCode += getQtManuOcoparadaCpVr().hashCode();
        }
        if (getQtManuOcoparadaSp() != null) {
            _hashCode += getQtManuOcoparadaSp().hashCode();
        }
        if (getQtManuOcoparadaSpVr() != null) {
            _hashCode += getQtManuOcoparadaSpVr().hashCode();
        }
        if (getQtManuOcoparadafds() != null) {
            _hashCode += getQtManuOcoparadafds().hashCode();
        }
        if (getQtManuOcoparadaimprev() != null) {
            _hashCode += getQtManuOcoparadaimprev().hashCode();
        }
        if (getQtManuOcoparadamdo() != null) {
            _hashCode += getQtManuOcoparadamdo().hashCode();
        }
        if (getQtManuOcoparadamtbf() != null) {
            _hashCode += getQtManuOcoparadamtbf().hashCode();
        }
        if (getQtManuOcoparadamttr() != null) {
            _hashCode += getQtManuOcoparadamttr().hashCode();
        }
        if (getQtManuOcoparadapa() != null) {
            _hashCode += getQtManuOcoparadapa().hashCode();
        }
        if (getQtManuOcoparadapao() != null) {
            _hashCode += getQtManuOcoparadapao().hashCode();
        }
        if (getQtManuOcoparadapp() != null) {
            _hashCode += getQtManuOcoparadapp().hashCode();
        }
        if (getQtManuOcoparadaprev() != null) {
            _hashCode += getQtManuOcoparadaprev().hashCode();
        }
        if (getQtManuOcoparadaptp() != null) {
            _hashCode += getQtManuOcoparadaptp().hashCode();
        }
        if (getQtManuOcoparadaregulagem() != null) {
            _hashCode += getQtManuOcoparadaregulagem().hashCode();
        }
        if (getQtManuOcoparadascp() != null) {
            _hashCode += getQtManuOcoparadascp().hashCode();
        }
        if (getQtManuTempoparadaDefault() != null) {
            _hashCode += getQtManuTempoparadaDefault().hashCode();
        }
        if (getQtManuTempoparadaSemCnx() != null) {
            _hashCode += getQtManuTempoparadaSemCnx().hashCode();
        }
        if (getQtManuTempoparadaSemEvt() != null) {
            _hashCode += getQtManuTempoparadaSemEvt().hashCode();
        }
        if (getQtManuTempoparadaSemOp() != null) {
            _hashCode += getQtManuTempoparadaSemOp().hashCode();
        }
        if (getSegAutoBoas() != null) {
            _hashCode += getSegAutoBoas().hashCode();
        }
        if (getSegAutoCicloimprodutivo() != null) {
            _hashCode += getSegAutoCicloimprodutivo().hashCode();
        }
        if (getSegAutoCicloimprodutivoCta() != null) {
            _hashCode += getSegAutoCicloimprodutivoCta().hashCode();
        }
        if (getSegAutoCiclomedio() != null) {
            _hashCode += getSegAutoCiclomedio().hashCode();
        }
        if (getSegAutoCiclopadrao() != null) {
            _hashCode += getSegAutoCiclopadrao().hashCode();
        }
        if (getSegAutoCicloprodutivo() != null) {
            _hashCode += getSegAutoCicloprodutivo().hashCode();
        }
        if (getSegAutoCicloprodutivoCta() != null) {
            _hashCode += getSegAutoCicloprodutivoCta().hashCode();
        }
        if (getSegAutoCta() != null) {
            _hashCode += getSegAutoCta().hashCode();
        }
        if (getSegAutoPerdacav() != null) {
            _hashCode += getSegAutoPerdacav().hashCode();
        }
        if (getSegAutoPerdaciclo() != null) {
            _hashCode += getSegAutoPerdaciclo().hashCode();
        }
        if (getSegAutoRitmo() != null) {
            _hashCode += getSegAutoRitmo().hashCode();
        }
        if (getSegAutoTempoalerta() != null) {
            _hashCode += getSegAutoTempoalerta().hashCode();
        }
        if (getSegAutoTempoativo() != null) {
            _hashCode += getSegAutoTempoativo().hashCode();
        }
        if (getSegAutoTempocalendario() != null) {
            _hashCode += getSegAutoTempocalendario().hashCode();
        }
        if (getSegAutoTempocalsempeso() != null) {
            _hashCode += getSegAutoTempocalsempeso().hashCode();
        }
        if (getSegAutoTempoparadaAb() != null) {
            _hashCode += getSegAutoTempoparadaAb().hashCode();
        }
        if (getSegAutoTempoparadaCp() != null) {
            _hashCode += getSegAutoTempoparadaCp().hashCode();
        }
        if (getSegAutoTempoparadaCpVr() != null) {
            _hashCode += getSegAutoTempoparadaCpVr().hashCode();
        }
        if (getSegAutoTempoparadaDefault() != null) {
            _hashCode += getSegAutoTempoparadaDefault().hashCode();
        }
        if (getSegAutoTempoparadaSemCnx() != null) {
            _hashCode += getSegAutoTempoparadaSemCnx().hashCode();
        }
        if (getSegAutoTempoparadaSemEvt() != null) {
            _hashCode += getSegAutoTempoparadaSemEvt().hashCode();
        }
        if (getSegAutoTempoparadaSemOp() != null) {
            _hashCode += getSegAutoTempoparadaSemOp().hashCode();
        }
        if (getSegAutoTempoparadaSp() != null) {
            _hashCode += getSegAutoTempoparadaSp().hashCode();
        }
        if (getSegAutoTempoparadaSpVr() != null) {
            _hashCode += getSegAutoTempoparadaSpVr().hashCode();
        }
        if (getSegAutoTempoparadafds() != null) {
            _hashCode += getSegAutoTempoparadafds().hashCode();
        }
        if (getSegAutoTempoparadaimprev() != null) {
            _hashCode += getSegAutoTempoparadaimprev().hashCode();
        }
        if (getSegAutoTempoparadamdo() != null) {
            _hashCode += getSegAutoTempoparadamdo().hashCode();
        }
        if (getSegAutoTempoparadamtbf() != null) {
            _hashCode += getSegAutoTempoparadamtbf().hashCode();
        }
        if (getSegAutoTempoparadamttr() != null) {
            _hashCode += getSegAutoTempoparadamttr().hashCode();
        }
        if (getSegAutoTempoparadapa() != null) {
            _hashCode += getSegAutoTempoparadapa().hashCode();
        }
        if (getSegAutoTempoparadapao() != null) {
            _hashCode += getSegAutoTempoparadapao().hashCode();
        }
        if (getSegAutoTempoparadapp() != null) {
            _hashCode += getSegAutoTempoparadapp().hashCode();
        }
        if (getSegAutoTempoparadaprev() != null) {
            _hashCode += getSegAutoTempoparadaprev().hashCode();
        }
        if (getSegAutoTempoparadaptp() != null) {
            _hashCode += getSegAutoTempoparadaptp().hashCode();
        }
        if (getSegAutoTempoparadaregulagem() != null) {
            _hashCode += getSegAutoTempoparadaregulagem().hashCode();
        }
        if (getSegAutoTempoparadascp() != null) {
            _hashCode += getSegAutoTempoparadascp().hashCode();
        }
        if (getSegAutoTempoprodutivo() != null) {
            _hashCode += getSegAutoTempoprodutivo().hashCode();
        }
        if (getSegAutoTemporefugadas() != null) {
            _hashCode += getSegAutoTemporefugadas().hashCode();
        }
        if (getSegAutoTempotrabalhado() != null) {
            _hashCode += getSegAutoTempotrabalhado().hashCode();
        }
        if (getSegManuBoas() != null) {
            _hashCode += getSegManuBoas().hashCode();
        }
        if (getSegManuCicloimprodutivo() != null) {
            _hashCode += getSegManuCicloimprodutivo().hashCode();
        }
        if (getSegManuCicloimprodutivoCta() != null) {
            _hashCode += getSegManuCicloimprodutivoCta().hashCode();
        }
        if (getSegManuCiclomedio() != null) {
            _hashCode += getSegManuCiclomedio().hashCode();
        }
        if (getSegManuCiclopadrao() != null) {
            _hashCode += getSegManuCiclopadrao().hashCode();
        }
        if (getSegManuCicloprodutivo() != null) {
            _hashCode += getSegManuCicloprodutivo().hashCode();
        }
        if (getSegManuCicloprodutivoCta() != null) {
            _hashCode += getSegManuCicloprodutivoCta().hashCode();
        }
        if (getSegManuCicloregulagem() != null) {
            _hashCode += getSegManuCicloregulagem().hashCode();
        }
        if (getSegManuCta() != null) {
            _hashCode += getSegManuCta().hashCode();
        }
        if (getSegManuPerdacav() != null) {
            _hashCode += getSegManuPerdacav().hashCode();
        }
        if (getSegManuPerdaciclo() != null) {
            _hashCode += getSegManuPerdaciclo().hashCode();
        }
        if (getSegManuRitmo() != null) {
            _hashCode += getSegManuRitmo().hashCode();
        }
        if (getSegManuTempoalerta() != null) {
            _hashCode += getSegManuTempoalerta().hashCode();
        }
        if (getSegManuTempoativo() != null) {
            _hashCode += getSegManuTempoativo().hashCode();
        }
        if (getSegManuTempocalendario() != null) {
            _hashCode += getSegManuTempocalendario().hashCode();
        }
        if (getSegManuTempocalsempeso() != null) {
            _hashCode += getSegManuTempocalsempeso().hashCode();
        }
        if (getSegManuTempoparadaCp() != null) {
            _hashCode += getSegManuTempoparadaCp().hashCode();
        }
        if (getSegManuTempoparadaCpVr() != null) {
            _hashCode += getSegManuTempoparadaCpVr().hashCode();
        }
        if (getSegManuTempoparadaDefault() != null) {
            _hashCode += getSegManuTempoparadaDefault().hashCode();
        }
        if (getSegManuTempoparadaSemCnx() != null) {
            _hashCode += getSegManuTempoparadaSemCnx().hashCode();
        }
        if (getSegManuTempoparadaSemEvt() != null) {
            _hashCode += getSegManuTempoparadaSemEvt().hashCode();
        }
        if (getSegManuTempoparadaSemOp() != null) {
            _hashCode += getSegManuTempoparadaSemOp().hashCode();
        }
        if (getSegManuTempoparadaSp() != null) {
            _hashCode += getSegManuTempoparadaSp().hashCode();
        }
        if (getSegManuTempoparadaSpVr() != null) {
            _hashCode += getSegManuTempoparadaSpVr().hashCode();
        }
        if (getSegManuTempoparadafds() != null) {
            _hashCode += getSegManuTempoparadafds().hashCode();
        }
        if (getSegManuTempoparadaimprev() != null) {
            _hashCode += getSegManuTempoparadaimprev().hashCode();
        }
        if (getSegManuTempoparadamdo() != null) {
            _hashCode += getSegManuTempoparadamdo().hashCode();
        }
        if (getSegManuTempoparadamtbf() != null) {
            _hashCode += getSegManuTempoparadamtbf().hashCode();
        }
        if (getSegManuTempoparadamttr() != null) {
            _hashCode += getSegManuTempoparadamttr().hashCode();
        }
        if (getSegManuTempoparadapa() != null) {
            _hashCode += getSegManuTempoparadapa().hashCode();
        }
        if (getSegManuTempoparadapao() != null) {
            _hashCode += getSegManuTempoparadapao().hashCode();
        }
        if (getSegManuTempoparadapp() != null) {
            _hashCode += getSegManuTempoparadapp().hashCode();
        }
        if (getSegManuTempoparadaprev() != null) {
            _hashCode += getSegManuTempoparadaprev().hashCode();
        }
        if (getSegManuTempoparadaptp() != null) {
            _hashCode += getSegManuTempoparadaptp().hashCode();
        }
        if (getSegManuTempoparadaregulagem() != null) {
            _hashCode += getSegManuTempoparadaregulagem().hashCode();
        }
        if (getSegManuTempoparadascp() != null) {
            _hashCode += getSegManuTempoparadascp().hashCode();
        }
        if (getSegManuTempoprodutivo() != null) {
            _hashCode += getSegManuTempoprodutivo().hashCode();
        }
        if (getSegManuTemporefugadas() != null) {
            _hashCode += getSegManuTemporefugadas().hashCode();
        }
        if (getSegManuTempotrabalhado() != null) {
            _hashCode += getSegManuTempotrabalhado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolals");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolals"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsollogs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsollogs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsollog"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmedparams");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmedparams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmedparam"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolpemps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolpemps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpemp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolprs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolprs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolre"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GAutoPesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GAutoPesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GAutoPesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GAutoPesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GManuPesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GManuPesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GManuPesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GManuPesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoCavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoCavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoCavTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoCavTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoPerdacavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoPerdacavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoPerdaparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoPerdaparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoPerdaparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoPerdaparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuCavAtivas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuCavAtivas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuCavTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuCavTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuPerdacavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuPerdacavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuPerdaparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuPerdaparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadafds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadafds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaimprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaimprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadamdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadamdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadamtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadamtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadamttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadamttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadapao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadapao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadapp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadapp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadaregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadaregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoOcoparadascp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoOcoparadascp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAutoTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadafds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadafds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaimprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaimprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadamdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadamdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadamtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadamtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadamttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadamttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadapao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadapao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadapp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadapp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadaregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadaregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuOcoparadascp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuOcoparadascp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtManuTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloimprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloimprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCiclomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCiclomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCiclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCicloprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCicloprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoPerdacav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoPerdacav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempocalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempocalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempocalsempeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempocalsempeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaAb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaAb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadafds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadafds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaimprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaimprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadamdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadamdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadamtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadamtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadamttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadamttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadapao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadapao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadapp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadapp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadascp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadascp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTemporefugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTemporefugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempotrabalhado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempotrabalhado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuBoas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuBoas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloimprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloimprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloimprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloimprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCiclomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCiclomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCiclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCiclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloprodutivoCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloprodutivoCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCicloregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCicloregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuCta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuCta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuPerdacav");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuPerdacav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuPerdaciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuPerdaciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuRitmo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuRitmo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempocalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempocalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempocalsempeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempocalsempeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaCpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaCpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemCnx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemCnx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemEvt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemEvt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSemOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSemOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaSpVr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaSpVr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadafds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadafds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaimprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaimprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadamdo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadamdo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadamtbf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadamtbf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadamttr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadamttr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadapao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadapao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadapp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadapp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaprev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaprev"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaptp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaptp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadaregulagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadaregulagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoparadascp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoparadascp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempoprodutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempoprodutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTemporefugadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTemporefugadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segManuTempotrabalhado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segManuTempotrabalhado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
