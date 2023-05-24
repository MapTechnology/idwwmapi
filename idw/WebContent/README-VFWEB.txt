Subir vf-web no tomcat

1 - 'npm install'
2 - 'ng build --prod'
3 - Substituir 'idw\WebContent\vf-web.html' por 'vf-web\dist\index.html'
4 - Substituir a pasta 'idw\WebContent\vf-web' por 'vf-web\dist'
5 - Depois de substituida as pastas ir em 'idw\WebContent\vf-web' e remover o 'index.html'
6 - Ir no 'idw\WebContent\vf-web.html' e trocar a seguinte tag '<base href="/">' por '<base href="/idw/vf-web/">'