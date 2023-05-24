@echo off
rem Batch para criar uma tag no subversion, usando a revisão da pasta atual


if "%1" == "" goto errorNoVersion
set URL_FROM=svn://srvmap01/desenvolvimento/sistemas/idw/trunk/fontes
set URL_TO=svn://srvmap01/desenvolvimento/sistemas/idw/tags/%1

rem comando "svn info --show-item=revision" só funciona a partir da versao 1.9 
rem https://stackoverflow.com/a/32115507/3009869
for /f %%i in ('svn info --show-item=revision') do set REVISION=%%i

rem Caso não esteja nesta versão 1.9 a revisão pode ser pega assim
rem for /f "delims=: tokens=1,2" %%a in ('svn info') do (
rem   if "%%a"=="Revision" (
rem     set /a RELEASE_REVISION=%%b
rem   )
rem )

echo Tag from %URL_FROM% r%REVISION% to %URL_TO%

@echo on
svn copy -r%REVISION% %URL_FROM% %URL_TO% -m "Create tag %1 from %URL_FROM% r%REVISION%"
@echo off
if %ERRORLEVEL% = 0 goto errorSvnCopy
pause

goto end

:errorNoVersion
echo.
echo Versao nao informada!
echo.
echo Rode como no exemplo:
echo     tag.bat 0.129.90
echo.
exit /B 1

:errorSvnCopy
echo.
echo Copia do svn falhou!!
echo.
exit /B 1

:end
@echo on