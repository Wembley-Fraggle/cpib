@echo off
set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;lib/antlr4-annotations-4.3.jar
set CLASSPATH=%CLASSPATH%;lib/antlr4-runtime-4.3.jar
set CLASSPATH=%CLASSPATH%;lib/org.abego.treelayout.core-1.0.1.jar
set CLASSPATH=%CLASSPATH%;lib/vm.jar
set CODE_SIZE=1000
set STORE_SIZE=1000
set MAIN_CLASS=ch.fhnw.lederer.virtualmachine.TestVM
set FILENAME=%1

set CMD=java -cp %CLASSPATH%
set CMD=%CMD% %MAIN_CLASS%
REM set CMD=%CMD% --codeSize %CODE_SIZE%
REM set CMD=%CMD% --storeSize %STORE_SIZE%
set CMD=%CMD% %FILENAME%
%cmd%