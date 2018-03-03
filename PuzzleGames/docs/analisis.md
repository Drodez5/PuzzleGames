# Análisis

### Descripción general de la aplicación.



**PuzzleGames** , variante del proyecto inicial **PuzzlePic**.  Es una aplicación que presenta un conjunto de juegos de puzzles, competitivos. **PuzzleGames**, tiene tres modos de juegos: **Puzzle Pieces, Match Puzzle y Sliding Puzzle.**



#### Puzzle Pieces

Este formato de juego, ofrece al jugador la posibilidad de seleccionar su propia fuente de imágenes y de resolverlas como puzzles. La imagen se troceará en *"piezas"* y el jugador deberá montar la imágen correctamente sobre el tablero en el tiempo establecido. *(Drag an drop)*



#### Match Puzzle

En este modo de juego, el jugador deberá encontrar las parejas que existen en el tablero en el tiempo establecido, las imágenes vienen preconfiguradas, de forma que el jugador no tiene que preocuparse en buscar las imágenes.



#### Sliding Puzzle

En este formato de juego, el jugador deberá rodar las piezas intentando recrear la imagen original en el tiempo establecido. El jugador deberá seleccionar la carpeta de imágenes, de las cuales se va a proveer este juego.



### Modos de dificultad

**PuzzleGames**, cuenta con tres modos de dificultad, dependiendo del modo de dificultad que se haya seleccionado podemos apreciar lo siguiente:

#### **Modo fácil**

El modo fácil, cuenta con un *tablero de 3x3* y un tiempo preestablecido de *3 minutos.*

#### **Modo medio**

El modo medio, cuenta con un *tablero de 4x4* y un tiempo preestablecido de *1 minuto*.

#### **Modo difícil**

El modo difícil, cuenta con un *tablero de 5x5* y un tiempo preestablecido de *30 segundos.*

La complejidad también vendrá dada por el tipo de imágen que seleccione el jugador.

### **Marcador y sistema de puntuación**

En el marcador, dependiendo el modo de juego que seleccionemos y de la dificultad, nos cargará los datos de los jugadores ordenadas  de mayor a menor puntuación.

El programa solo registrará las puntuaciones en la base de datos, siempre y cuando el usuario acepte enviar la información.

La información solo se enviará, si el jugador logra resolver los puzzles de forma correcta y en el tiempo establecido, de resto se descartará.

Al finalizar cada partida, aparecerá una ventana resumen con los datos de la partida realizada por el jugador.




### Objetivos y finalidad

Este juego tiene como objetivo, fomentar la rapidez y la agilidad mental mediante la resolución de puzzles, además de fomentar una competividad sana entre los distintos jugadores que utilizen la aplicación.