# Swing Sistema Cajero Automatico (ATM) 

## Description

Este proyecto implementa un sencillo sistema de cajero automatico, utilizando Java Swing para su implementación. El cliente se conecta con un servidor (Flask) por medio de solicitudes HTTP.

## Examples:
**Screenshot:**



## Code Examples:
```java
private final Toaster toaster = new Toaster(mainJPanel);

toaster.error("An error event!!", "Or multiple at once");
toaster.warn("A warning event!", "Or multiple at once");
toaster.info("An informational event.", "Or multiple at once");
toaster.success("A successful event!", "Or multiple at once");
```

## Instrucciones para implementación:
1. `git clone https://github.com/ProductOfAmerica/LoginGUI.git`
2. Cambie el archivo `diamond_dogs_ch.png` bajo `/resources` por su propio logo.
3. Adapte todos sus botones sobreescribiendo el metodo `btnHandler` en cada view, use la propiedad `operacion` para identificar cada botón.
4. Agregue o modifique sus operaciones agregando el metodo correspondiente en la clase `Transaction`
5. Compile con `javac ATMClient.java`
6. Run with `java ATMClient.class`


## Diagramas:
**Diagrama de flujo:**
![FlowDiagram](.github/algorithm_flowchart_sistema_bancario.png)

**Diagrama de uso de caso:**
![FlowDiagram](.github/use_case_diagram_sistema_bancario.png)
