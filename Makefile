# Variables
JAVAC=javac
JAVA=java
SRC=src/pck
BIN=bin

SOURCES=$(wildcard $(SRC)/*.java)

all: compile run

compile:
	@mkdir -p $(BIN)
	$(JAVAC) -Xlint:unchecked -d $(BIN) $(SOURCES)

run:
	$(JAVA) -cp $(BIN) pck.Menu

clean:
	rm -f $(BIN)/*.class
