# Taller 1 - Juan David Bravo

### Clase Main

#### **Atributos**
* **app:PApplet**
* **log:Logica**

#### **Métodos:**
* **main(String[])**
* **settings()**
* **setup()**
* **draw()**
* **mousePressed()**
* **keyPressed()**

### Clase Logica

#### **Atributos**

* **app:PApplet**
* **etapa:int** - Determina en cuál de las etapas de interacción se encuentra el usuario.
* **etapas:Etapa[]** - Crea cada una de las etapas de interacción.
* **texto:String[]** - Carga el texto a partir del que se trabajará.

#### **Métodos**

* **Logica(PApplet)**
* **dibujar()** - Este método ejecutará todas aquellas acciones que suceden cada frame.
* **click()** - Este método ejecutará las acciones que suceden cuando el usuario da un click.
* **clickMan()** - Este método ejecutará las acciones que suceden cuando el usuario mantiene el click.
* **tecla()** - Este método ejecutará las acciones que suceden cuando el usuario presiona un tecla.

### Etapa

#### **Atributos**

* **app:PApplet**
* **x:float** - Posición en eje x de referencia a partir del cúal se pintarán todos los objetos en pantalla.
* **y:float** - Posición en eje y de referencia a partir del cúal se pintarán todos los objetos en pantalla.

#### **Métodos**

* **Etapa(PApplet)**
* **pintar()** - Método abstract.
* **sigEtapa()** - Retorna booleano para saber si se debe pasar a la siguiente etapa.

### Negacion
Hereda de Etapa.

#### **Atributos**

* **opacidad:int** - Cambia la opacidad de algunos elementos gráficos.

#### **Métodos**

* **Negacion(PApplet)**
* **pintar** - Pinta todas las piezas gráficas que se mostrarán en pantalla.
* **tecla()** - Realiza la interacción presionando una tecla.

### Negociacion
Hereda de Etapa.

#### **Atributos**

#### **Métodos**

* **Negociacion(PApplet)**
* **pintar()** - Pinta todas las piezas gráficas que se mostrarán en pantalla.
* **click()** - Realiza las interacciones relacionadas con el mouse. Implementa los métodos moverIzq() y moverDer().
* **moverIzq()** - Interacción cuando el usuario presiona click izquierdo.
* **moverDer()** - Interacción cuando el usuario presiona click derecho.

### Ira
Hereda de Etapa

#### **Atributos**

* **clic:int** - Cuenta cuántos clicks a dado el usuario en esta Etapa, para saber qué elementos debe mostrar.

#### **Métodos**

* **Ira(PApplet)**
* **pintar()** - Pinta los elementos gráficos de esta etapa, dependiendo de cuántos clicks haya dado el usuario cambiarán los elementos.
* **click()** - Interacciones realizadas con el click izquierdo.

### Lagrima

#### **Atributos**

* **app:PApplet**
* **x:float** - Posición en eje X de la lágrima.
* **y:float** - Posición en eje Y de la lágrima.

#### **Métodos**

* **Lagrima(PApplet)**
* **pintar()** - Pinta un par de lágrimas en pantalla.
* **mover()** - Hace que las lágrimas caigan.
* **borrar()** - Retorna un boolean, determina si las lágrimas están fuera de pantalla y deben ser eliminadas.

### Depresion
Hereda de Etapa

#### **Atributos**

* **lagrimas:LinkedList<Lagrima>** - Guarda objetos tipo Lagrima.

#### **Métodos**

* **Depresion(PApplet)**
* **pintar()** - Pinta los elementos en pantalla.
* **crearLagrima()** - Crea un nuevo objeto de la clase Lagrima en lagrimas.
* **borrarLagrima()** - Ejecuta el método borrar() de la clase Lagrima.
* **click()** - Interacciones con el mouse.
* **tecla()** - Interacciones con el teclado.

### Esfera

#### **Atributos**

* **app:PApplet**
* **x:float** - Posición en eje X de la esfera.
* **y:float** - Posición en eje Y de la esfera.

#### **Métodos**

* **Esfera(PApplet)**
* **pintar()** - Pinta la esfera
* **validarClick()** - Retorna booleano, determina si se ha dado click dentro de la esfera

### Aceptacion
Hereda de Etapa

#### **Atributos**

* **esferas:LinkedList<Esfera>**

#### **Métodos**

* **Aceptacion(PApplet)**
* **pintar()** - Pinta todos los elementos gráficos.
* **click()** - Ejecuta las interacciones que suceden cuando el usuario da click.