# YWidget

## About

A simple Java widget to display images from a personal feed.

Related project: [Collaginator](https://github.com/andreburto/Collaginator).

## Build

1. Change to the project root directory.
2. Compile the `*.java` files: `find . -name *.java | xargs javac`
3. Create a jar file: `jar -c -f YWidget.jar -e xyz.yvonneshow.ywidget.YWidget .`
4. Run the jar file: `java -jar YWidget.jar`

The `build.sh` file will accomplish the above tasks.

## To Do

* Create build pipeline.
* Auto-resize frame based on image size.

## Update Log

*2023-01-22:* Refactored the project to be a library.
Fixed project to use a better namespace for the package.
Created the `build.sh` script to automate builds.

*2023-01-01:* Added build instructions in README file.

*2016-08-11:* Started project with initial, working code.
