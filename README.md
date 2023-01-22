# YWidget

## About

A simple Java widget to display images from a personal feed.

Related project: [Collaginator](https://github.com/andreburto/Collaginator).

## Build

1. Change to the project root directory.
2. Compile the `*.java` files: `find . -name *.java | xargs javac`
3. Create a jar file: `jar -c -f YWidget.jar -e xyz.yvonneshow.ywidget.YWidget .`
4. Run the jar file: `java -jar YWidget.jar`

## To Do

* Create build pipeline.
* Auto-resize frame based on image size.

## Update Log

*2023-01-01:* Added build instructions in README file.

*2016-08-11:* Started project with initial, working code.