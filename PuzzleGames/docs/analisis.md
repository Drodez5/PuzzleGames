# Análisis

#### *Descripción general de la aplicación.*



**PuzzleGames** es una apilcación de entretenimiento en la cual podrá jugar un jugador en local con la meta de completar los puzzles propuestos en una cierta cantidad de tiempo e intentar batir los records de otros usuarios, ya que cualquiera que juegue, sus datos se subirán a un marcador en la nube.



#### *Opciones de Partida*

El jugador pondrá su nombre/alias, el número de rompecabezas a resolver, dificultad (número de piezas del puzzle), el tiempo para resolver cada puzzle y el modo de juego. Además el jugador podrá personalizar el juego subiendo sus propias imágenes, como piezas del puzzle. Ninguno de los campos podrá ser nulo y si no se selecciona ninguna carpeta de imágenes, se utilizarán las propuestas por la aplicación.



#### *Partida en juego*

Según el modo de juego que se haya seleccionado:

**PuzzlePieces**

El jugador deberá de montar el puzzle mediante la colocación correcta de los fragmentos de la imagen resultado. Todas las piezas se podrán mover, al resolver un puzzle, pasará al siguiente puzzle automáticamente una vez resuelto (y si es el último puzzle aparecerá un resumen con los datos de la partida). Cuando todas las piezas estén colocadas, el tiempo se detendrá y su puntuación se guardará.

Al completar todos los puzzles propuestos, la puntuación total se sumará y su puntuación se guardará en el marcador en la nube. Si por alguna razón, el jugador desiste del rompecabezas pulsando el botón "Abandonar", su puntuación será evaluada dependiendo del número de puzzles resueltos hasta el momento y saldrá directamente a la pantalla de inicio.



**Bejeweled (Enjoyados)**

El principal próposito de este tipo de puzzle es unir las piezas iguales intentando conseguir la máxima puntuación en una cantidad de tiempo determinado, puedes echar tantas partidas como se haya especificado en la opciones de partida. Si el jugador decide abandonar, su puntuación será evaluada dependiendo del número de puzzles que haya resuelto hasta el momento. Tras haber finalizado este modo de juego, aparecerá un resumen con los datos de la partida y su puntuación se almacenará en un base de datos en la nube.



**MatchPuzzle**

El principal objetivo de este tipo de puzzle es encontrar todas las parejas posibles, en el tiempo en el menor tiempo posible, para así poder conseguir una alta puntuación y intentar ser el primero en el top de jugadores, de este modo de juego. Si el jugador decide abandonar, su puntuación será evaluada dependiendo del número de puzzles que haya resuelto hasta el momento. Tras haber finalizado este modo de juego, aparecerá un resumen con los datos de la partida y su puntuación se almacenará en un base de datos en la nube.





#### *Marcador* y sistema de puntuación

Aquí se mostrarán las diez mejores puntuaciones obtenidas por la comunidad. 



El sistema de puntuación es el siguiente:

- Cada puzzle tiene una puntuación:
  - Fácil (10).
  - Medio (25).
  - Difícil (50).

- Resolverlo, sumará dicho número (PR)

- No acabarlo, será igual a no (NF)(NP)

- El abandono según el número de puzzles resueltos y su dicicultad (AB)

- El tiempo sobrante de cada puzzle (en segundos) se sumará (PR)

  **Leyenda**

  (PR)=>PREMIA

  (NF)=>NO FINALIZADO

  (NP)=>NO PUNTUA

  (AB)=>ABANDONO

  ​



### *Conclusión*

El objetivo final de esta aplicación es fomentar la agilidad mental y competividad de los jugadores gracias al sistema de puntuaciones globales.