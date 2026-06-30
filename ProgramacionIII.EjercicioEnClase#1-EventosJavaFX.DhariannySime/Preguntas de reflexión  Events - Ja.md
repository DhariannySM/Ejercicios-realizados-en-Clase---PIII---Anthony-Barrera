###### **Preguntas de reflexión / Events - JavaFX:**



**1- ¿Cuál es la diferencia entre ActionEvent, MouseEvent y KeyEvent?**

La diferencia principal radica en la naturaleza del estímulo que recibe la interfaz. El ActionEvent es un evento de alto nivel que representa la culminación de una interacción lógica; se dispara cuando un usuario realiza la "acción principal" de un componente, como hacer clic en un botón o presionar Enter en un campo de texto, ignorando los detalles técnicos del dispositivo físico. Por otro lado, el MouseEvent es un evento de bajo nivel que se genera específicamente por las coordenadas y acciones del cursor, permitiendo detectar clics, movimientos, arrastres o la entrada y salida del ratón sobre un área. Finalmente, el KeyEvent se centra exclusivamente en el teclado, registrando qué tecla específica fue presionada, mantenida o liberada mientras un elemento mantiene el foco, siendo esencial para juegos o entradas de datos complejas.



**2- ¿Por qué es mejor separar la vista en FXML y la lógica en el Controller?** Esta estructura permite que el código sea mucho más legible y mantenible, ya que el archivo FXML se encarga únicamente de declarar la jerarquía y disposición de los elementos visuales, mientras que el Controller contiene exclusivamente las instrucciones de comportamiento. Esto facilita enormemente el trabajo en equipo, permitiendo que diseñadores se enfoquen en el layout y programadores en la funcionalidad de manera independiente.





**3- ¿Qué función cumple @FXML?** La anotación @FXML desempeña un papel de puente fundamental en la comunicación entre el archivo de diseño y el código Java. Cuando el cargador de FXML procesa el archivo de interfaz, utiliza esta anotación para inyectar las referencias de los objetos de la interfaz en los campos correspondientes del archivo Controller. Es decir, le indica explícitamente a la máquina virtual que un componente declarado en la vista debe ser enlazado con la variable o el método privado del Controller, garantizando que el código Java pueda manipular los elementos visuales de forma segura y directa.





**4- ¿Qué ocurre si el nombre del método en el FXML no coincide con el método del Controller?** Si el nombre de un método declarado en el archivo FXML no coincide exactamente con el definido en el archivo Controller, la aplicación fallará inmediatamente al intentar cargarse. Debido a que JavaFX utiliza reflexión para realizar el enlace entre la vista y la lógica, el sistema lanzará una excepción, comúnmente una LoadException causada por un NoSuchMethodException. El programa es incapaz de completar la inicialización de la interfaz porque no puede encontrar el "gancho" que debería conectar la interacción del usuario con la función programada, deteniendo así la ejecución del proceso.





**5- ¿Por qué es recomendable usar CSS en lugar de colocar estilos directamente en Java?** El uso de CSS en lugar de definir estilos directamente en Java es una decisión estratégica para la escalabilidad del proyecto. Al utilizar archivos CSS externos, se logra una separación total entre la estructura de la aplicación y su apariencia visual, permitiendo modificar colores, fuentes o márgenes sin necesidad de recompilar el código fuente. Esto garantiza una consistencia visual en todo el sistema, donde un único archivo de estilo puede dictar el aspecto de múltiples ventanas, facilitando enormemente el mantenimiento y permitiendo cambios de diseño rápidos que no afectan en absoluto la lógica funcional del software.
