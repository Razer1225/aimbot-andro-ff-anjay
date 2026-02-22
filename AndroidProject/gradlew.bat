@rem Gradle wrapper batch script for Windows
@rem Downloads gradle-wrapper.jar if missing, then runs Gradle

@if "%DEBUG%"=="" @echo off

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
cd /d "%DIRNAME%"

set WRAPPER_JAR=gradle\wrapper\gradle-wrapper.jar
set WRAPPER_URL=https://raw.githubusercontent.com/gradle/gradle/v8.2.0/gradle/wrapper/gradle-wrapper.jar

if not exist "%WRAPPER_JAR%" (
    echo Downloading gradle-wrapper.jar...
    powershell -NoProfile -ExecutionPolicy Bypass -Command "& {[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; Invoke-WebRequest -Uri '%WRAPPER_URL%' -OutFile '%WRAPPER_JAR%' -UseBasicParsing}"
    if errorlevel 1 (
        echo Failed to download gradle-wrapper.jar
        exit /b 1
    )
    echo Download complete.
)

set JAVA_EXE=java
where %JAVA_EXE% >nul 2>nul
if errorlevel 1 (
    echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
    exit /b 1
)

"%JAVA_EXE%" -Dorg.gradle.appname=gradlew -jar "%WRAPPER_JAR%" %*
