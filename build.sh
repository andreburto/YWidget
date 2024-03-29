#!/bin/bash
cd $(dirname $0)

APP_NAME="YWidget.jar"
BASE_DIR=$(pwd)

# Clean the previous build.
rm $BASE_DIR/$APP_NAME || echo "No such file."
find . -name *.class | xargs -I {} rm -f {}

# Compile class files.
find . -name *.java | xargs -I {} javac -verbose {}

# Create the Jar file.
jar -vcf $BASE_DIR/$APP_NAME -e xyz.yvonneshow.ywidget.YWidget .