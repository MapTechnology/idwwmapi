webpackJsonp([2],{0:function(l,n,u){l.exports=u("cDNt")},"6eWT":function(l,n,u){"use strict";u.d(n,"a",function(){return r});var t=u("p5Ee"),o=u("XKz0"),e=u("M+vG"),r=function(){function l(l){this.http=l}return l.prototype.getProducaoGt=function(l){if(t.a.mock)return this.http.get("/assets/mock/producao.json");var n=(new o.g).set("cdGt",l);return this.http.get(e.a.PRODUCAO_ENDPOINT,{params:n})},l.ctorParameters=function(){return[{type:o.c}]},l}()},Jyyi:function(l,n,u){"use strict";u.d(n,"a",function(){return r});var t=u("BkNc"),o=u("VWpA"),e=u("iM9F"),r=(u.n(e),function(){function l(l,n,u,t){this.gtService=l,this.producaoService=n,this.router=u,this.route=t}return l.prototype.ngOnInit=function(){var l=this;this.gtService.getAll().subscribe(function(n){l.lstGts=n},function(l){var n=$("<span> Erro na conex\xe3o! </span>").add($('<button class="btn-flat toast-action" onclick="Materialize.Toast.removeAll()">x</button>'));e.toast(n,1e4,"red darken-3")}),this.routeSubscribe=this.route.params.subscribe(function(n){n.gt&&l.router.navigate([n.gt,"0"])})},l.prototype.ngOnDestroy=function(){this.routeSubscribe.unsubscribe()},l.prototype.cdGtonClick=function(l){var n=this;this.producaoService.getProducaoGt(l).subscribe(function(u){sessionStorage.setItem("producao",JSON.stringify(u)),n.router.navigate([l,0])},function(l){var n=$("<span> Erro na conex\xe3o! </span>").add($('<button class="btn-flat toast-action" onclick="Materialize.Toast.removeAll()">x</button>'));e.toast(n,1e4,"red darken-3")})},Object.defineProperty(l.prototype,"_lstGts",{get:function(){return this.lstGts},enumerable:!0,configurable:!0}),l.ctorParameters=function(){return[{type:o.a},{type:o.b},{type:t.k},{type:t.a}]},l}())},"M+vG":function(l,n,u){"use strict";u.d(n,"a",function(){return o});var t=u("p5Ee"),o=function(){function l(){}return l}();o.API_ENDPOINT=t.a.server+"/idw/rest",o.GTS_ENDPOINT=o.API_ENDPOINT+"/gts",o.PRODUCAO_ENDPOINT=o.API_ENDPOINT+"/dashboard/flex/producao"},NeLg:function(l,n,u){"use strict";u.d(n,"a",function(){return t});var t=function(){function l(){}return l}()},V5NV:function(l,n,u){"use strict";u.d(n,"a",function(){return o});var t=u("/oeL"),o=function(){function l(){this._mudarTela=new t.p}return Object.defineProperty(l.prototype,"mudarTela",{get:function(){return this._mudarTela},enumerable:!0,configurable:!0}),l.ctorParameters=function(){return[]},l}()},VWpA:function(l,n,u){"use strict";var t=u("kOAl");u.d(n,"a",function(){return t.a});var o=u("6eWT");u.d(n,"b",function(){return o.a})},cDNt:function(l,n,u){"use strict";function t(l){return e._28(0,[(l()(),e._15(0,16777216,null,null,2,"router-outlet",[],null,null,null,null,null)),e._13(1,212992,null,0,p.m,[p.b,e.Y,e.k,[8,null],e.i],null,null),(l()(),e._27(-1,null,["\n"]))],function(l,n){l(n,1,0)},null)}function o(l){return e._28(0,[(l()(),e._15(0,0,null,null,1,"app-root",[],null,null,null,t,f)),e._13(1,49152,null,0,i,[],null,null)],null,null)}Object.defineProperty(n,"__esModule",{value:!0});var e=u("/oeL"),r=u("p5Ee"),a=(u("rgUS"),u("S4Bb"),u("iM9F"),function(){function l(){}return l}()),i=function(){function l(){this.title="app"}return l}(),c=u("rlws"),s=u("z42Y"),d=[".square[_ngcontent-%COMP%]{border:2.5px solid #fff;color:#fff;text-transform:uppercase;font-size:180%}"],p=u("BkNc"),_=[d],f=e._12({encapsulation:0,styles:_,data:{}}),g=e._10("app-root",i,o,{},{},[]),h=u("qbdv"),m=u("fc+i"),v=u("XKz0"),P=u("kOAl"),b=u("6eWT"),y=u("V5NV"),O=function(){function l(){}return l}(),w=u("Jyyi"),x=u("v1uu"),I=u("NeLg"),k=u("ejh0"),C=e._11(a,[i],function(l){return e._24([e._25(512,e.k,e._7,[[8,[c.a,s.a,g]],[3,e.k],e.E]),e._25(5120,e.A,e._23,[[3,e.A]]),e._25(4608,h.k,h.j,[e.A]),e._25(5120,e.c,e._16,[]),e._25(5120,e.y,e._21,[]),e._25(5120,e.z,e._22,[]),e._25(4608,m.b,m.s,[h.c]),e._25(6144,e.Q,null,[m.b]),e._25(4608,m.e,m.f,[]),e._25(5120,m.c,function(l,n,u,t){return[new m.k(l),new m.o(n),new m.n(u,t)]},[h.c,h.c,h.c,m.e]),e._25(4608,m.d,m.d,[m.c,e.G]),e._25(135680,m.m,m.m,[h.c]),e._25(4608,m.l,m.l,[m.d,m.m]),e._25(6144,e.O,null,[m.l]),e._25(6144,m.p,null,[m.m]),e._25(4608,e.W,e.W,[e.G]),e._25(4608,m.g,m.g,[h.c]),e._25(4608,m.i,m.i,[h.c]),e._25(4608,v.i,v.n,[h.c,e.J,v.l]),e._25(4608,v.o,v.o,[v.i,v.m]),e._25(5120,v.a,function(l){return[l]},[v.o]),e._25(4608,v.k,v.k,[]),e._25(6144,v.j,null,[v.k]),e._25(4608,v.h,v.h,[v.j]),e._25(6144,v.b,null,[v.h]),e._25(5120,v.f,v.p,[v.b,[2,v.a]]),e._25(4608,v.c,v.c,[v.f]),e._25(4608,P.a,P.a,[v.c]),e._25(4608,b.a,b.a,[v.c]),e._25(4608,y.a,y.a,[]),e._25(5120,p.a,p.v,[p.k]),e._25(4608,p.d,p.d,[]),e._25(6144,p.f,null,[p.d]),e._25(135680,p.n,p.n,[p.k,e.D,e.j,e.w,p.f]),e._25(4608,p.e,p.e,[]),e._25(5120,p.h,p.y,[p.w]),e._25(5120,e.b,function(l){return[l]},[p.h]),e._25(512,h.b,h.b,[]),e._25(1024,e.o,m.q,[]),e._25(1024,e.F,function(){return[p.r()]},[]),e._25(512,p.w,p.w,[e.w]),e._25(1024,e.d,function(l,n,u){return[m.r(l,n),p.x(u)]},[[2,m.h],[2,e.F],p.w]),e._25(512,e.e,e.e,[[2,e.d]]),e._25(131584,e._14,e._14,[e.G,e._8,e.w,e.o,e.k,e.e]),e._25(2048,e.g,null,[e._14]),e._25(512,e.f,e.f,[e.g]),e._25(512,m.a,m.a,[[3,m.a]]),e._25(512,v.e,v.e,[]),e._25(512,v.d,v.d,[]),e._25(512,O,O,[]),e._25(1024,p.q,p.t,[[3,p.k]]),e._25(512,p.p,p.c,[]),e._25(512,p.b,p.b,[]),e._25(256,p.g,{},[]),e._25(1024,h.g,p.s,[h.m,[2,h.a],p.g]),e._25(512,h.f,h.f,[h.g]),e._25(512,e.j,e.j,[]),e._25(512,e.D,e.T,[e.j,[2,e.U]]),e._25(1024,p.i,function(){return[[{path:"",component:w.a},{path:":gt/:index",component:x.a},{path:":gt",component:w.a}],[{path:"",loadChildren:"./pages/pages.module#PagesModule"},{path:"**",redirectTo:""}]]},[]),e._25(1024,p.k,p.u,[e.g,p.p,p.b,h.f,e.w,e.D,e.j,p.i,p.g,[2,p.o],[2,p.j]]),e._25(512,p.l,p.l,[[2,p.q],[2,p.k]]),e._25(512,I.a,I.a,[]),e._25(512,k.a,k.a,[]),e._25(512,a,a,[]),e._25(256,v.l,"XSRF-TOKEN",[]),e._25(256,v.m,"X-XSRF-TOKEN",[])])});r.a.production&&Object(e._2)(),Object(m.j)().bootstrapModuleFactory(C).catch(function(l){return console.log(l)})},ejh0:function(l,n,u){"use strict";u.d(n,"a",function(){return t});var t=function(){function l(){}return l}()},gFIY:function(l,n,u){function t(l){var n=o[l];return n?u.e(n[1]).then(function(){return u(n[0])}):Promise.reject(new Error("Cannot find module '"+l+"'."))}var o={"./pages/pages.module.ngfactory":["wzMD",0]};t.keys=function(){return Object.keys(o)},t.id="gFIY",l.exports=t},kOAl:function(l,n,u){"use strict";u.d(n,"a",function(){return r});var t=u("p5Ee"),o=u("M+vG"),e=u("XKz0"),r=function(){function l(l){this.http=l}return l.prototype.getAll=function(){return t.a.mock?this.http.get("/assets/mock/gts.json"):this.http.get(o.a.GTS_ENDPOINT)},l.prototype.setGT=function(l){localStorage.setItem("gt",l)},l.prototype.getGT=function(){return localStorage.getItem("gt")},l.ctorParameters=function(){return[{type:e.c}]},l}()},p5Ee:function(l,n,u){"use strict";u.d(n,"a",function(){return t});var t={production:!0,server:window.location.origin,mock:!1}},rlws:function(l,n,u){"use strict";function t(l){return a._28(0,[(l()(),a._15(0,0,null,null,7,"div",[["class","card blue accent-4"],["id","grupo-de-trabalho"]],null,[[null,"click"]],function(l,n,u){var t=!0,o=l.component;if("click"===n){t=!1!==o.cdGtonClick(l.context.$implicit.cdGt)&&t}return t},null,null)),(l()(),a._27(-1,null,["\n            "])),(l()(),a._15(2,0,null,null,4,"div",[["class","card-content white-text"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n                "])),(l()(),a._15(4,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),a._27(5,null,[" "," "])),(l()(),a._27(-1,null,["\n            "])),(l()(),a._27(-1,null,["\n        "]))],null,function(l,n){l(n,5,0,n.context.$implicit.cdGt)})}function o(l){return a._28(0,[(l()(),a._15(0,0,null,null,26,"div",[["class","row"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n    "])),(l()(),a._15(2,0,null,null,10,"div",[["class","row"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n        "])),(l()(),a._15(4,0,null,null,7,"nav",[["class","white"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n            "])),(l()(),a._15(6,0,null,null,4,"div",[["class","nav-wrapper"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n                "])),(l()(),a._15(8,0,null,null,1,"a",[["class","brand-logo center grey-text text-darken-3"],["href","/"]],null,null,null,null,null)),(l()(),a._27(-1,null,["Dashboard"])),(l()(),a._27(-1,null,["\n            "])),(l()(),a._27(-1,null,["\n        "])),(l()(),a._27(-1,null,["\n    "])),(l()(),a._27(-1,null,["\n    "])),(l()(),a._15(14,0,null,null,11,"div",[["class","center-align row"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n        "])),(l()(),a._15(16,0,null,null,5,"div",[["class","col l8 offset-l2 white blue-text text-lighten-1"],["id","pn-aviso-info"]],null,null,null,null,null)),(l()(),a._27(-1,null,["\n            "])),(l()(),a._15(18,0,null,null,2,"p",[],null,null,null,null,null)),(l()(),a._15(19,0,null,null,1,"b",[],null,null,null,null,null)),(l()(),a._27(-1,null,["Escolha um grupo de trabalho! "])),(l()(),a._27(-1,null,["\n        "])),(l()(),a._27(-1,null,["\n        "])),(l()(),a._9(16777216,null,null,1,null,t)),a._13(24,802816,null,0,i.h,[a.Y,a.V,a.y],{ngForOf:[0,"ngForOf"]},null),(l()(),a._27(-1,null,["\n    "])),(l()(),a._27(-1,null,["\n"]))],function(l,n){var u=n.component;l(n,24,0,null==u._lstGts?null:u._lstGts.gts)},null)}function e(l){return a._28(0,[(l()(),a._15(0,0,null,null,1,"app-posto-trabalho",[],null,null,null,o,f)),a._13(1,245760,null,0,c.a,[s.a,d.a,p.k,p.a],null,null)],function(l,n){l(n,1,0)},null)}var r=["body[_ngcontent-%COMP%]{background-color:#e6e6e6}.content[_ngcontent-%COMP%]{padding:15px;padding-bottom:0}.outter-square[_ngcontent-%COMP%]{margin:0!important}.inner-square[_ngcontent-%COMP%]{position:relative;height:2.5em;color:#fff;font-size:4rem}.inner-square[_ngcontent-%COMP%], .square-body[_ngcontent-%COMP%]{border:2.5px solid #fff;text-transform:uppercase}.square-body[_ngcontent-%COMP%]{color:#000;font-size:3rem;font-weight:bolder;margin:0 10px!important;margin-bottom:10px!important}div#grupo-de-trabalho[_ngcontent-%COMP%], div#pn-aviso-info[_ngcontent-%COMP%]{border-radius:10px}div#pn-aviso-info[_ngcontent-%COMP%]{border:1px solid #ffab00;font-size:3rem;height:2.5em;padding:20px;margin-bottom:1em}div#pn-aviso-info[_ngcontent-%COMP%]   p[_ngcontent-%COMP%]{margin:0}div#grupo-de-trabalho[_ngcontent-%COMP%]{width:55em;display:inline-block;margin:1em 1em}div#grupo-de-trabalho[_ngcontent-%COMP%]   div.card-content.white-text[_ngcontent-%COMP%]{width:100%;height:100%;text-align:center;font-size:3.5rem}div#grupo-de-trabalho[_ngcontent-%COMP%]:hover{cursor:pointer;box-shadow:5px 5px 5px grey;-webkit-animation-name:little-jump;animation-name:little-jump;animation-duration:1s;animation-delay:1s;animation-iteration-count:infinite;-webkit-animation:little-jump;-webkit-animation-duration:1s;-webkit-animation-delay:1s;-webkit-animation-iteration-count:infinite;-moz-animation:little-jump;-moz-animation-duration:1s;-moz-animation-delay:1s;-moz-animation-iteration-count:infinite}@-webkit-keyframes little-jump{0%{transform:translateY(-2px);-webkit-transform:translateY(-2px);-moz-transform:translateY(-2px)}50%{transform:translate(0);-webkit-transform:translate(0);-moz-transform:translate(0)}to{transform:translateY(2px);-webkit-transform:translateY(2px);-moz-transform:translateY(2px)}}@keyframes little-jump{0%{transform:translateY(-2px);-webkit-transform:translateY(-2px);-moz-transform:translateY(-2px)}50%{transform:translate(0);-webkit-transform:translate(0);-moz-transform:translate(0)}to{transform:translateY(2px);-webkit-transform:translateY(2px);-moz-transform:translateY(2px)}}nav.white[_ngcontent-%COMP%]{height:7em;padding:15px}a.brand-logo[_ngcontent-%COMP%]{font-size:5rem;font-weight:bolder}"],a=u("/oeL"),i=u("qbdv"),c=u("Jyyi"),s=u("kOAl"),d=u("6eWT"),p=u("BkNc");u.d(n,"a",function(){return g});var _=[r],f=a._12({encapsulation:0,styles:_,data:{}}),g=a._10("app-posto-trabalho",c.a,e,{},{},[])},v1uu:function(l,n,u){"use strict";u.d(n,"a",function(){return r});var t=u("BkNc"),o=u("VWpA"),e=u("V5NV"),r=function(){function l(l,n,u,t){this.producaoService=l,this.route=n,this.router=u,this.telaPrincipalService=t,this.isDisplayed=!0}return l.prototype.ngOnInit=function(){var l=this;this.routesSubscribe=this.route.params.subscribe(function(n){l.gtSelecionado=n.gt,l.opsProdutoIndice=n.index||0}),this.producaoGt=JSON.parse(sessionStorage.getItem("producao")),this.telaPrincipalService.mudarTela.subscribe(function(n){var u=l;!0===n.hasOwnProperty("flag")&&!0===n.hasOwnProperty("component")&&("producao-horas"===n.component?(window.location.reload(),u.isDisplayed=n.flag):setTimeout(function(){u.isDisplayed=n.flag},5e3))},function(l){console.log(l)})},l.prototype.ngOnDestroy=function(){this.routesSubscribe.unsubscribe(),this.getProducaoGtSubscribe.unsubscribe(),this.telaPrincipalService.mudarTela.unsubscribe()},Object.defineProperty(l.prototype,"_producaoGt",{get:function(){return this.producaoGt},enumerable:!0,configurable:!0}),Object.defineProperty(l.prototype,"_opsProdutoIndice",{get:function(){return this.opsProdutoIndice<this.producaoGt.opsProdutos.length?this.opsProdutoIndice:(this.router.navigate([this.producaoGt.cdGt,0]),window.location.reload(),0)},enumerable:!0,configurable:!0}),l.ctorParameters=function(){return[{type:o.b},{type:t.a},{type:t.k},{type:e.a}]},l}()},z42Y:function(l,n,u){"use strict";function t(l){return h._28(0,[(l()(),h._15(0,0,null,null,61,"div",[["class","row blue accent-4"],["id","header"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(2,0,null,null,13,"div",[["class","row col l6 outter-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(4,0,null,null,10,"div",[["class","card transparent col l12 inner-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(6,0,null,null,1,"span",[["class","card-title col"]],null,null,null,null,null)),(l()(),h._27(-1,null,["Cliente"])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(9,0,null,null,4,"div",[["class","card-content white-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(11,0,null,null,1,"p",[["class","center-align"]],null,null,null,null,null)),(l()(),h._27(12,null,[" "," "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(17,0,null,null,13,"div",[["class","row col l6 outter-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(19,0,null,null,10,"div",[["class","card transparent col l12 inner-square modelo"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(21,0,null,null,1,"span",[["class","card-title col"]],null,null,null,null,null)),(l()(),h._27(-1,null,["Modelo"])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(24,0,null,null,4,"div",[["class","card-content white-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(26,0,null,null,1,"p",[["class","center-align"]],null,null,null,null,null)),(l()(),h._27(27,null,[" "," "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(32,0,null,null,13,"div",[["class","row col l6 outter-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(34,0,null,null,10,"div",[["class","card transparent col l12 inner-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(36,0,null,null,1,"span",[["class","card-title col"]],null,null,null,null,null)),(l()(),h._27(-1,null,["Linha"])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(39,0,null,null,4,"div",[["class","card-content white-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(41,0,null,null,1,"p",[["class","center-align"]],null,null,null,null,null)),(l()(),h._27(42,null,[" "," "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(47,0,null,null,13,"div",[["class","row col l6 outter-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(49,0,null,null,10,"div",[["class","card transparent col l12 inner-square"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(51,0,null,null,1,"span",[["class","card-title col"]],null,null,null,null,null)),(l()(),h._27(-1,null,["For"])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(54,0,null,null,4,"div",[["class","card-content white-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(56,0,null,null,1,"p",[["class","center-align"]],null,null,null,null,null)),(l()(),h._27(57,null,[" "," "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n"]))],null,function(l,n){var u=n.component;l(n,12,0,u.opsProdutos[u.opsProdutoIndice].cliente),l(n,27,0,u.opsProdutos[u.opsProdutoIndice].modelo),l(n,42,0,u.cadastroGt),l(n,57,0,u.opsProdutos[u.opsProdutoIndice].indiceDefeito)})}function o(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-cabecalho",[],null,null,null,t,b)),h._13(1,114688,null,0,v,[],null,null)],function(l,n){l(n,1,0)},null)}function e(l){return h._28(0,[(l()(),h._15(0,0,null,null,64,"div",[["class","row square-body center-align content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(2,0,null,null,1,"div",[["class","row title"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        Dados\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(5,0,null,null,25,"div",[["class","row"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(7,0,null,null,10,"div",[["class","row col l6"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(9,0,null,null,7,"div",[["class","card col l12"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(11,0,null,null,4,"div",[["class","card-content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                    "])),(l()(),h._15(13,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(14,null,[" Data: "," "])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(19,0,null,null,10,"div",[["class","row col l6"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(21,0,null,null,7,"div",[["class","card col l12"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(23,0,null,null,4,"div",[["class","card-content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                    "])),(l()(),h._15(25,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(26,null,[" Hora: "," "])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(32,0,null,null,4,"div",[["class","row"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(34,0,null,null,1,"div",[["class","card col l12 teal darken-1"]],null,null,null,null,null)),(l()(),h._27(35,null,[" Meta do dia: "," "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(38,0,null,null,25,"div",[["class","row"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(40,0,null,null,10,"div",[["class","row col l6"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(42,0,null,null,7,"div",[["class","card col l12 red lighten-1 white-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(44,0,null,null,4,"div",[["class","card-content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                    "])),(l()(),h._15(46,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(47,null,[" Produzido: "," "])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(52,0,null,null,10,"div",[["class","row col l6"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(54,0,null,null,7,"div",[["class","card col l12"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(56,0,null,null,4,"div",[["class","card-content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                    "])),(l()(),h._15(58,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(59,null,[" For real(%): "," "])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n"])),(l()(),h._27(-1,null,["\n"]))],null,function(l,n){var u=n.component;l(n,14,0,u.gtData),l(n,26,0,u.gtHora),l(n,35,0,u.opsProdutos[u.opsProdutoIndice].metaDia),l(n,47,0,u.opsProdutos[u.opsProdutoIndice].produzidos),l(n,59,0,u.opsProdutos[u.opsProdutoIndice].indiceDefeitoReal)})}function r(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-producao-resumo",[],null,null,null,e,C)),h._13(1,8503296,null,0,I,[x.a,h.n],null,null)],function(l,n){l(n,1,0)},null)}function a(l){return h._28(0,[(l()(),h._15(0,0,null,null,7,"div",[["class","row col l2 horas"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(2,0,null,null,4,"div",[["class","card col l12 white black-text"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(4,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(5,null,[""," - ",""])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "]))],null,function(l,n){var u=n.component;l(n,5,0,n.context.$implicit.hora,n.context.$implicit[u.CURR_DETALHE_FLAG])})}function i(l){return h._28(0,[(l()(),h._15(0,0,null,null,34,"div",[["class","row square-body center-align content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(2,0,null,null,1,"div",[["class","row title"]],null,null,null,null,null)),(l()(),h._27(3,null,["\n        ","\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(5,0,null,null,4,"div",[["class","row"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._9(16777216,null,null,1,null,a)),h._13(8,802816,null,0,y.h,[h.Y,h.V,h.y],{ngForOf:[0,"ngForOf"]},null),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._15(11,0,null,null,22,"div",[["class","row"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(13,0,null,null,4,"div",[],[[8,"className",0]],null,null,null,null)),(l()(),h._27(-1,null,[" \n            "])),(l()(),h._15(15,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(16,null,[" "," "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._15(19,0,null,null,13,"div",[["class","col l4"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n            "])),(l()(),h._15(21,0,null,null,10,"div",[["class","card black-text total"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(23,0,null,null,1,"span",[["class","card-title col"]],null,null,null,null,null)),(l()(),h._27(-1,null,["Total"])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._15(26,0,null,null,4,"div",[["class","card-content"]],null,null,null,null,null)),(l()(),h._27(-1,null,["\n                    "])),(l()(),h._15(28,0,null,null,1,"p",[],null,null,null,null,null)),(l()(),h._27(29,null,[" "," "])),(l()(),h._27(-1,null,["\n                "])),(l()(),h._27(-1,null,["\n            "])),(l()(),h._27(-1,null,["\n        "])),(l()(),h._27(-1,null,["\n    "])),(l()(),h._27(-1,null,["\n"]))],function(l,n){var u=n.component;l(n,8,0,u.opsProdutos[u.opsProdutoIndice].horas)},function(l,n){var u=n.component;l(n,3,0,u.CURR_DETALHE_TITULO),l(n,13,0,u.opsProdutos[u.opsProdutoIndice].statusProducao>0?"card col l8 white status status-many":"card col l8 red lighten-1 status status-zero"),l(n,16,0,u.opsProdutos[u.opsProdutoIndice].statusProducaoDescricao),l(n,29,0,u.opsProdutos[u.opsProdutoIndice][u.CURR_DETALHE_FLAG])})}function c(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-producao-horas",[],null,null,null,i,j)),h._13(1,770048,null,0,S,[x.a,z.a,h.n,M.k,M.a],null,null)],function(l,n){l(n,1,0)},null)}function s(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-producao-resumo",[],[[4,"display",null]],null,null,e,C)),h._13(1,8503296,null,0,I,[x.a,h.n],{gtData:[0,"gtData"],gtHora:[1,"gtHora"],opsProdutos:[2,"opsProdutos"],opsProdutoIndice:[3,"opsProdutoIndice"]},null),(l()(),h._27(-1,null,["\n"])),(l()(),h._15(3,0,null,null,1,"app-producao-horas",[],[[4,"display",null]],null,null,i,j)),h._13(4,770048,null,0,S,[x.a,z.a,h.n,M.k,M.a],{opsProdutos:[0,"opsProdutos"],opsProdutoIndice:[1,"opsProdutoIndice"],cdGt:[2,"cdGt"]},null)],function(l,n){var u=n.component;l(n,1,0,u.producaoGt.data,u.producaoGt.hora,u.producaoGt.opsProdutos,u.opsProdutoIndice),l(n,4,0,u.producaoGt.opsProdutos,u.opsProdutoIndice,u.producaoGt.cdGt)},function(l,n){var u=n.component;l(n,0,0,u.isDisplayed?"block":"none"),l(n,3,0,u.isDisplayed?"none":"block")})}function d(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-producao",[],null,null,null,s,q)),h._13(1,114688,null,0,A,[],null,null)],function(l,n){l(n,1,0)},null)}function p(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-cabecalho",[],null,null,null,t,b)),h._13(1,114688,null,0,v,[],{opsProdutos:[0,"opsProdutos"],opsProdutoIndice:[1,"opsProdutoIndice"],cadastroGt:[2,"cadastroGt"]},null)],function(l,n){var u=n.component;l(n,1,0,u._producaoGt.opsProdutos,u._opsProdutoIndice,u._producaoGt.cdGt)},null)}function _(l){return h._28(0,[(l()(),h._9(16777216,null,null,1,null,p)),h._13(1,16384,null,0,y.i,[h.Y,h.V],{ngIf:[0,"ngIf"]},null),(l()(),h._27(-1,null,["\n\n    "])),(l()(),h._27(-1,null,["\n"])),(l()(),h._15(4,0,null,null,1,"app-producao",[],null,null,null,s,q)),h._13(5,114688,null,0,A,[],{opsProdutoIndice:[0,"opsProdutoIndice"],producaoGt:[1,"producaoGt"],isDisplayed:[2,"isDisplayed"]},null)],function(l,n){var u=n.component;l(n,1,0,u._producaoGt),l(n,5,0,u._opsProdutoIndice,u._producaoGt,u.isDisplayed)},null)}function f(l){return h._28(0,[(l()(),h._15(0,0,null,null,1,"app-tela-principal",[],null,null,null,_,R)),h._13(1,245760,null,0,F.a,[z.a,M.a,M.k,x.a],null,null)],function(l,n){l(n,1,0)},null)}var g=[""],h=u("/oeL"),m=[".card[_ngcontent-%COMP%]{overflow-x:auto}.card[_ngcontent-%COMP%]   span[_ngcontent-%COMP%]{padding:0;font-size:2.5rem}label[_ngcontent-%COMP%], p[_ngcontent-%COMP%]{position:relative}"],v=function(){function l(){}return l.prototype.ngOnInit=function(){},l.ctorParameters=function(){return[]},l}(),P=[m],b=h._12({encapsulation:0,styles:P,data:{}}),y=(h._10("app-cabecalho",v,o,{opsProdutos:"opsProdutos",opsProdutoIndice:"opsProdutoIndice",cadastroGt:"cadastroGt"},{},[]),u("qbdv")),O=[""],w=["div.row.col.l6[_ngcontent-%COMP%]:first-child{margin:0;padding:0;padding-right:10px}div.row.col.l6[_ngcontent-%COMP%]:first-child   div[_ngcontent-%COMP%]{height:4em;padding:25px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(2){margin:0;padding:0;padding-left:10px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(2)   div[_ngcontent-%COMP%]{height:4em;padding:25px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(3){margin:0;padding:0;padding-right:10px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(3)   div[_ngcontent-%COMP%]{height:4em;padding:25px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(4){margin:0;padding:0;padding-left:10px}div.row.col.l6[_ngcontent-%COMP%]:nth-child(4)   div[_ngcontent-%COMP%]{height:4em;padding:25px}"],x=u("V5NV"),I=function(){function l(l,n){this.telaPrincipalService=l,this.elementRef=n}return l.prototype.ngOnInit=function(){},l.prototype.ngAfterViewChecked=function(){"none"!==getComputedStyle(this.elementRef.nativeElement).display&&this.telaPrincipalService.mudarTela.emit({flag:!1,component:"producao-resumo"})},Object.defineProperty(l.prototype,"_opsProdutoIndice",{get:function(){return this.opsProdutoIndice},enumerable:!0,configurable:!0}),l.ctorParameters=function(){return[{type:x.a},{type:h.n}]},l}(),k=[w],C=h._12({encapsulation:0,styles:k,data:{}}),G=(h._10("app-producao-resumo",I,r,{gtData:"gtData",gtHora:"gtHora",opsProdutos:"opsProdutos",opsProdutoIndice:"opsProdutoIndice"},{},[]),[".horas[_ngcontent-%COMP%]{padding:5px;margin:0}.horas[_ngcontent-%COMP%]   div[_ngcontent-%COMP%]{margin:0!important}.status[_ngcontent-%COMP%]{position:relative;font-size:2.7rem;font-weight:bolder}.status-zero[_ngcontent-%COMP%]{color:#fff}.status-many[_ngcontent-%COMP%]{color:#000}.total[_ngcontent-%COMP%]{height:3.2em;background-color:#fff}.total[_ngcontent-%COMP%]   span.card-title[_ngcontent-%COMP%]{font-size:2rem;font-weight:bolder}.total[_ngcontent-%COMP%]   div.card-content[_ngcontent-%COMP%]{font-size:4.6rem!important}"]),M=u("BkNc"),T=u("VWpA"),D=u("iM9F"),S=function(){function l(l,n,u,t,o){this.telaPrincipalService=l,this.producaoService=n,this.elementRef=u,this.router=t,this.route=o,this.detalhesTipo=["produzidos","defeitos","scraps"]}return l.prototype.ngOnInit=function(){},l.prototype.ngOnChanges=function(l){var n=this;n.detalhesTipoIndex=0,this.interval=setInterval(function(){n.detalhesTipoIndex===n.detalhesTipo.length?(n.telaPrincipalService.mudarTela.emit({flag:!0,component:"producao-horas"}),n.routeSubscribe=n.route.params.subscribe(function(l){n.detalhesTipoIndex=parseInt(l.index,10)}),n.detalhesTipoIndex=n.detalhesTipoIndex<n.opsProdutos.length-1?n.detalhesTipoIndex:-1,n.producaoServiceSubscribe=n.producaoService.getProducaoGt(n.cdGt).subscribe(function(l){sessionStorage.clear(),sessionStorage.setItem("producao",JSON.stringify(l)),n.detalhesTipoIndex+1===0?n.router.navigate([n.cdGt,0]):n.router.navigate([n.cdGt,n.detalhesTipoIndex+1])},function(l){var u=$("<span> Erro na conex\xe3o </span>").add($('<button class="btn-flat toast-action" onclick="Materialize.Toast.removeAll()">x</button>'));D.toast(u,1e4,"red darken-3"),n.detalhesTipoIndex+1===0?n.router.navigate([n.cdGt,0]):n.router.navigate([n.cdGt,n.detalhesTipoIndex+1])}),clearInterval(n.interval)):(n.currentDetalheFlag=n.detalhesTipo[n.detalhesTipoIndex],n.currentDetalheTitulo=n.detalhesTipo[n.detalhesTipoIndex].charAt(0).toUpperCase()+n.detalhesTipo[n.detalhesTipoIndex].slice(1),n.detalhesTipoIndex++)},5e3)},l.prototype.ngOnDestroy=function(){this.routeSubscribe.unsubscribe(),this.producaoServiceSubscribe.unsubscribe()},Object.defineProperty(l.prototype,"CURR_DETALHE_FLAG",{get:function(){return this.currentDetalheFlag},enumerable:!0,configurable:!0}),Object.defineProperty(l.prototype,"CURR_DETALHE_TITULO",{get:function(){return this.currentDetalheTitulo},enumerable:!0,configurable:!0}),l.ctorParameters=function(){return[{type:x.a},{type:T.b},{type:h.n},{type:M.k},{type:M.a}]},l}(),z=u("6eWT"),N=[G],j=h._12({encapsulation:0,styles:N,data:{}}),A=(h._10("app-producao-horas",S,c,{opsProdutos:"opsProdutos",opsProdutoIndice:"opsProdutoIndice",cdGt:"cdGt"},{},[]),function(){function l(){}return l.prototype.ngOnInit=function(){},l.ctorParameters=function(){return[]},l}()),E=[O],q=h._12({encapsulation:0,styles:E,data:{}}),F=(h._10("app-producao",A,d,{opsProdutoIndice:"opsProdutoIndice",producaoGt:"producaoGt",isDisplayed:"isDisplayed"},{},[]),u("v1uu"));u.d(n,"a",function(){return L});var Y=[g],R=h._12({encapsulation:0,styles:Y,data:{}}),L=h._10("app-tela-principal",F.a,f,{},{},[])}},[0]);