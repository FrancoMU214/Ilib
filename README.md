# Ilib
Proyecto Final para la Materia de Topicos Avanzados de Programacion
# Clase Database
Esta clase maneja la conexión a la base de datos para nuestro proyecto. Aquí tenemos un resumen de cómo funciona:

Atributos
•	conexion: Guarda el objeto Connection que usamos para interactuar con la base de datos.

•	JDBC_DRIVER: La cadena que identifica el driver JDBC que necesitamos para conectar con MySQL. En este caso, es "com.mysql.jdbc.Driver".

•	DB_URL: La URL de la base de datos a la que nos conectamos. Aquí está configurada para conectar con una base de datos llamada ilib en localhost.

•	USER: El nombre de usuario para acceder a la base de datos, que en este caso es "root".

•	PASS: La contraseña del usuario, aquí es "1234abc".

Métodos
•	Conectar(): Este método intenta establecer la conexión con la base de datos. Usa DriverManager.getConnection para obtener la conexión y Class.forName para asegurarse de que el driver JDBC está disponible. Si hay algún problema al conectar, se captura la excepción SQLException y se registra.

•	Cerrar(): Cierra la conexión a la base de datos si está abierta. Chequea primero si la conexión no es nula y si está abierta antes de cerrarla para evitar errores.
Uso típico

1.	Conexión: Primero, creamos una instancia de Database y llamamos al método Conectar() para iniciar la conexión.
2.	Operaciones: Realizamos las operaciones que necesitemos con la base de datos.
3.	Cierre: Llamamos al método Cerrar() para cerrar la conexión cuando hayamos terminado.
4.	Este enfoque asegura que la conexión se maneje de manera segura y eficiente, evitando fugas de recursos.

# Clase DAOBooksImpl
Esta clase es una implementación del interfaz DAOBooks, extendiendo la clase Database para manejar operaciones específicas con libros en la base de datos. Aquí tienen un desglose de los métodos utilizamos:

Métodos
• Registrar(Books book): Registra un nuevo libro en la base de datos. Prepara y ejecuta una instrucción SQL INSERT con todos los detalles del libro como título, autor, categoría, etc.

• Modificar(Books book): Actualiza los detalles de un libro existente identificado por su ID. Usa una instrucción SQL UPDATE para modificar los campos del libro en la base de datos.

• Eliminar(int bookId): Elimina un libro de la base de datos usando su ID. Ejecuta una instrucción SQL DELETE.

• Listar(String title): Retorna una lista de libros que coincidan con el título proporcionado. Si no se proporciona un título, retorna todos los libros. Usa SELECT para buscar en la base de datos.

• ListarId(String id): Funciona de manera similar a listar, pero filtra los libros por ID.

• GetBookById(int bookId): Obtiene los detalles de un solo libro basado en su ID. Útil para operaciones específicas en un libro determinado.

Uso Típico

1. Conexión y Operaciones: Primero se conecta a la base de datos, realiza operaciones como registrar, modificar o eliminar, y luego cierra la conexión para liberar recursos.
2. Manejo de Excepciones: Todos los métodos están diseñados para manejar excepciones y asegurar que la conexión se cierra correctamente, independientemente de si la operación fue exitosa o no.

Buenas Prácticas

1. Manejo de Recursos: Usa bloques try-with-resources para asegurar que todos los recursos de la base de datos se cierran adecuadamente.
2. Seguridad: Evitar la inyección SQL utilizando PreparedStatement y parámetros.
3. Este diseño ayuda a mantener el código organizado, facilita la reutilización y mejora la mantenibilidad al separar la lógica de acceso a datos del resto de la aplicación.

# Clase DAOLendingsImpl
Esta clase gestiona las operaciones de base de datos relacionadas con los préstamos de libros en la biblioteca. A continuación, les detallamos los métodos implementados en esta clase, que extiende la clase Database:

Métodos

• Registrar(Lendings lending): Registra un nuevo préstamo en la base de datos. Se introducen los IDs de usuario y libro, así como la fecha de salida del libro, utilizando un PreparedStatement para evitar inyecciones SQL.

• Modificar(Lendings lending): Actualiza la información de un préstamo existente, incluyendo el usuario, el libro, la fecha de salida y la fecha de retorno. Esto permite actualizar los registros cuando un libro es devuelto.

• GetLending(Users user, Books book): Busca el préstamo más reciente de un libro específico por un usuario que aún no ha sido devuelto. Esto es útil para rastrear préstamos activos.
listar(): Devuelve una lista de todos los préstamos registrados en la base de datos, ordenados de manera descendente por ID. Esto proporciona una visión general rápida de todos los préstamos.

Uso Típico

1. Conexión a la Base de Datos: Antes de cualquier operación, se conecta a la base de datos.
2. Ejecución de Operaciones: Dependiendo de la necesidad, se registran nuevos préstamos, se modifican préstamos existentes, o se buscan préstamos específicos.
3. Cierre de la Conexión: Después de realizar las operaciones necesarias, se cierra la conexión para optimizar los recursos.

Consideraciones de Diseño

1. Seguridad de Datos: Utiliza PreparedStatement para proteger contra inyecciones SQL.
2. Manejo de Excepciones: Cada método incluye manejo de excepciones para capturar y tratar errores de forma adecuada.
3. Cierre de Recursos: Implementa un bloque finally en cada método para asegurarse de que la conexión a la base de datos se cierre correctamente, incluso si ocurre una excepción.
4. Esta clase es un componente crucial para manejar la lógica de negocios relacionada con los préstamos de libros, asegurando que la base de datos se mantenga actualizada y consistente.

# Clase DAOUsersImpl
Esta clase gestiona las operaciones de base de datos relacionadas con los usuarios en el sistema. Implementa la interfaz DAOUsers y extiende la clase Database para utilizar la conexión a la base de datos. A continuación, se detallan los métodos que ofrece esta clase:

Métodos

•	registrar(Users user): Añade un nuevo usuario a la base de datos. Inserta los detalles del usuario como nombre, apellidos, domicilio y teléfono usando un PreparedStatement.

•	modificar(Users user): Actualiza la información de un usuario existente en la base de datos. Permite cambiar detalles como el nombre, apellidos, domicilio, y teléfono.

•	eliminar(int userId): Elimina un usuario de la base de datos utilizando su ID. Ejecuta un DELETE para remover completamente el registro del usuario.

•	listar(String name): Devuelve una lista de usuarios que coincidan con el nombre dado. Si no se proporciona un nombre, devuelve todos los usuarios. Utiliza un SELECT para obtener los datos.

•	listarId(String id): Similar al método listar, pero filtra los usuarios por su ID.

•	getUserById(int userId): Obtiene la información de un solo usuario por su ID. Es útil para operaciones específicas en un usuario determinado.

•	sancionar(Users user): Actualiza el estado de sanción de un usuario, ajustando el número de sanciones y la cantidad monetaria de las sanciones en la base de datos.

Uso Típico

•	Conexión a la Base de Datos: Se conecta a la base de datos antes de cualquier operación.

•	Ejecución de Operaciones: Se pueden realizar operaciones como registrar, modificar, eliminar, o sancionar usuarios.

•	Cierre de la Conexión: Se cierra la conexión después de realizar las operaciones necesarias para optimizar los recursos.

Consideraciones de Diseño

•	Seguridad de Datos: Utiliza PreparedStatement para proteger contra inyecciones SQL.

•	Manejo de Excepciones: Cada método está diseñado para manejar excepciones adecuadamente, asegurando que los errores se traten de manera efectiva.

•	Cierre de Recursos: Implementa un bloque finally en cada método para garantizar que la conexión se cierre correctamente.

Esta clase es crucial para manejar la lógica de acceso a datos relacionada con los usuarios, facilitando la gestión de usuarios y asegurando que la base de datos se mantenga actualizada y segura.

# Clase Dashboard
Esta clase, Dashboard, básicamente configura y maneja el panel principal de nuestra aplicación. Como podrás ver, hereda de javax.swing.JFrame, lo que significa que es una ventana de nuestra GUI. Aquí te contamos cómo le dimos forma:
Constructor

•	Dashboard(): En el constructor, llamamos a initComponents() que se supone que NetBeans autogenera para inicializar los componentes de la GUI. Luego, ponemos nuestro propio estilo con InitStyles(), establecemos la fecha actual con SetDate(), y finalmente preparamos el contenido inicial con InitContent().

Métodos

•	InitStyles(): Aquí personalizamos un poco los estilos de los componentes de texto como mensaje, navText, dateText, y appName usando propiedades del tema FlatLaf. Por ejemplo, ajustamos el tipo de fuente 
y el color, asegurando que todo tenga un look consistente y elegante.

•	SetDate(): Usamos la fecha actual y la formateamos al estilo español. Esto se muestra en dateText, donde podrías ver algo como "Hoy es viernes 05 de mayo de 2023". Usamos DateTimeFormatter con un patrón específico y la localización para España.

•	InitContent(): Este método simplemente establece el panel inicial que se mostrará en la zona de contenido de nuestra ventana. Llama a ShowJPanel(new Principal()) que es un método estático para cambiar el contenido del panel principal.
Método Estático

•	ShowJPanel(JPanel p): Este método es bastante útil porque permite cambiar el contenido del content panel de nuestro Dashboard. Ajusta el tamaño y la posición del panel que recibe y luego lo agrega al content. Limpia lo que haya antes, lo añade, y luego asegura que la GUI se actualice correctamente con revalidate() y repaint().

Uso y Consideraciones

•	Personalización y estilos: La personalización de los componentes es clave para mantener un estilo uniforme que se alinee con el tema visual de nuestra aplicación.
•	Manejo de fechas: Es crucial cuando la app tiene que presentar o usar fechas, especialmente en formatos localizados.
•	Flexibilidad: El método ShowJPanel ofrece una manera flexible de cambiar entre diferentes pantallas o paneles de nuestra aplicación, manteniendo la transición suave y sin complicaciones.

# INTERFACES

# Interfaz DAOBooks
Esta interfaz define las operaciones esenciales que cualquier implementación de DAOBooks debería tener. Es como el contrato que asegura que quien lo implemente pueda manejar todas las funciones básicas relacionadas con libros en nuestra base de datos. Aquí te explicamos cada método que debe tener:

Métodos

•	registrar(Books book) throws Exception: Se encarga de añadir un nuevo libro a la base de datos. Necesita un objeto Books con toda la info del libro que se va a registrar.

•	modificar(Books book) throws Exception: Actualiza la información de un libro ya existente. Esto es útil cuando hay cambios en los detalles del libro, como el título, autor, o incluso la cantidad en stock.

•	eliminar(int bookId) throws Exception: Remueve un libro de la base de datos usando su ID. Este método es crucial para mantener la base de datos limpia de registros que ya no se necesitan.

•	listar(String title) throws Exception: Devuelve una lista de libros que coinciden con el título proporcionado. Si se pasa una cadena vacía o nula, debería retornar todos los libros disponibles.

•	listarId(String id) throws Exception: Similar al método listar, pero en este caso se busca por ID del libro. Ideal para cuando necesitas detalles específicos de un libro sin tener que cargar toda la lista.

•	getBookById(int bookId) throws Exception: Este método es para obtener un libro específico por su ID. Es súper útil cuando solo necesitas la información de un libro en particular, sin más complicaciones.
Consideraciones Generales

•	Manejo de Excepciones: Todos los métodos pueden lanzar Exception, lo que sugiere que cualquier implementación debe manejar posibles errores durante la interacción con la base de datos. Esto es vital para una app robusta y confiable.

•	Flexibilidad en la Búsqueda: Los métodos listar y listarId ofrecen mucha flexibilidad para obtener libros, ya sea por título o por ID, lo que hace que la interfaz sea bastante útil en diferentes contextos de uso.

Uso Típico

Cualquier clase que implemente esta interfaz será responsable de definir cómo se conecta a la base de datos, cómo ejecuta las consultas SQL, y cómo maneja los resultados y errores. Esto asegura que el resto de nuestra aplicación pueda usar estos métodos sabiendo exactamente qué esperar, sin preocuparse por los detalles de la implementación.

# Interfaz DAOLendings
Esta interfaz define los métodos esenciales que cualquier implementación de manejo de préstamos de libros debe tener. Funciona como una guía que asegura que las clases que la implementen puedan manejar todas las operaciones relacionadas con los préstamos en la biblioteca. Aquí te detallamos cada uno de los métodos que incluye:

Métodos

•	registrar(Lendings lending) throws Exception: Este método está diseñado para añadir un nuevo préstamo a la base de datos. Necesitarás pasarle un objeto Lendings que contiene toda la información del 
préstamo, como quién toma el libro, qué libro es, y la fecha de salida.

•	modificar(Lendings lending) throws Exception: Utilizado para actualizar la información de un préstamo existente, por ejemplo, cuando un libro es devuelto y necesitas registrar la fecha de devolución.

•	getLending(Users user, Books book) throws Exception: Este método busca el préstamo activo más reciente para un libro específico por un usuario determinado, muy útil para controlar los préstamos que no han sido devueltos aún.

•	listar() throws Exception: Devuelve una lista con todos los préstamos registrados en la base de datos. Este método es esencial para obtener una visión general de todos los préstamos, lo cual es crucial para el manejo de inventarios y el seguimiento de los libros.

Consideraciones Generales

•	Manejo de Excepciones: Al igual que otras interfaces de acceso a datos, todos los métodos de DAOLendings pueden lanzar excepciones, lo que implica que las implementaciones deben ser capaces de manejar fallos en la interacción con la base de datos.

•	Flexibilidad y Rastreo: El método getLending añade una capa de flexibilidad y control permitiendo rastrear préstamos específicos, lo cual es vital para evitar pérdidas o malentendidos sobre el estado de los libros prestados.

Uso Típico
1. Las clases que implementen esta interfaz serán responsables de conectar con la base de datos, realizar las consultas necesarias y manejar los resultados y posibles errores. Esto garantiza que el manejo 2. de los préstamos sea transparente y eficiente para el resto de la aplicación, manteniendo la integridad y la disponibilidad de los datos.

# Interfaz DAOUsers
Esta interfaz es crucial porque establece los métodos que cualquier implementación debe tener para manejar las operaciones relacionadas con los usuarios en nuestra base de datos. Es una parte fundamental para asegurar que gestionamos adecuadamente los datos de los usuarios, desde su registro hasta la administración de sanciones. Aquí te explicamos cada uno de los métodos:

Métodos

•	registrar(Users user) throws Exception: Este método es para añadir un nuevo usuario a la base de datos. Necesita toda la información del usuario para poder hacer el registro correctamente.

•	modificar(Users user) throws Exception: Actualiza la información de un usuario ya existente. Esto es útil para corregir datos o actualizar información relevante del usuario.

•	sancionar(Users user) throws Exception: Aplica o actualiza sanciones a un usuario, lo cual es fundamental para gestionar el cumplimiento de las normas dentro de la biblioteca o cualquier sistema que implemente esta interfaz.

•	eliminar(int userId) throws Exception: Remueve a un usuario de la base de datos utilizando su ID. Este método es importante para mantener la base de datos limpia de usuarios que ya no necesitan estar registrados.

•	listar(String name) throws Exception: Devuelve una lista de usuarios que coinciden con el nombre proporcionado. Si no se proporciona un nombre, podría configurarse para retornar todos los usuarios.

•	listarId(String id) throws Exception: Similar al método listar, pero busca y lista usuarios basándose en su ID.

•	getUserById(int userId) throws Exception: Retorna un usuario específico basado en su ID. Es crucial para obtener detalles completos de un usuario sin necesidad de buscar a través de toda la base de datos.
Consideraciones Generales

•	Manejo de Excepciones: Todos los métodos pueden lanzar excepciones, lo que indica que las implementaciones deben ser capaces de manejar posibles errores de interacción con la base de datos de manera eficiente.

•	Flexibilidad y Seguridad: Proporcionar métodos para listar, modificar y eliminar asegura que la interfaz pueda adaptarse a varios escenarios de uso, al tiempo que mantiene la seguridad y la integridad de los datos del usuario.

Uso Típico
1. Cualquier clase que implemente esta interfaz se encargará de definir cómo se realizan las conexiones a la base de datos, cómo se ejecutan las consultas y cómo se manejan los resultados y los errores.
2. Esto garantiza que las operaciones relacionadas con los usuarios sean transparentes y eficaces, facilitando la gestión de los mismos dentro de la aplicación.
