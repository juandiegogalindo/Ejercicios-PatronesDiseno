# Ejercicios - Patrones de Diseño
 
## 1. Nombre del Proyecto
 
**PatronesDiseno-Proyectos**
 
Conjunto de ejercicios en **Java** que implementan 5 patrones de diseño de software (Decorador, Singleton, Observador, Plantilla de Método y Proxy), aplicados sobre un mismo caso de negocio: **el procesamiento de pagos**. Cada patrón se trabajó de forma básica, con un ejercicio pequeño que muestra el problema que resuelve y cómo se resuelve.
 
## 2. Estructura del repositorio
 
```
src/
├── PatronDecorador/         # Cálculo de costo de un pago con tarifas adicionales
├── PatronSingleton/         # Gestor único de procesamiento de pagos
├── PatronObservador/        # Notificación a clientes cuando se procesa un pago
├── PatronPlantillaMetodo/   # Flujo fijo de pago con tarjeta (Visa / MasterCard)
└── PatronProxy/             # Control de acceso a la anulación de un descuento
```
 
Cada carpeta es independiente y tiene su propia clase `Main` para ejecutarse por separado.
 
## 3. Requisitos e instalación
 
1. **Java JDK 8 o superior**.
2. **Git** para clonar el repositorio.
3. IDE recomendado: **NetBeans** (el proyecto ya trae configuración de NetBeans), aunque también funciona en Eclipse o IntelliJ.
```bash
git clone https://github.com/juandiegogalindo/PatronesDiseno-Proyectos.git
```
 
Para compilar y ejecutar un patrón puntual desde consola (ejemplo con Decorador):
 
```bash
cd src
javac PatronDecorador/*.java
java PatronDecorador.Main
```
 
## 4. Tecnologías utilizadas
 
- **Java** — Lenguaje principal.
- **NetBeans (Ant)** — Gestión y build del proyecto (`build.xml`, `nbproject/`).
- **Git / GitHub** — Control de versiones.
## 5. Los patrones
 
### 5.1 Patrón Decorador (`PatronDecorador`)
 
**Problema que resuelve:** agregar funcionalidades o costos extra a un objeto (en este caso, un pago) sin modificar su clase original ni crear una subclase por cada combinación posible de tarifas.
 
**Ejercicio:** se parte de un `PagoBasico` (interfaz Pago, con los métodos costo() y descripcion()). Sobre ese pago se van "envolviendo" decoradores:
 
- TarifaTransaccion añade un cargo fijo por transacción.
- TarifaConversion añade un cargo fijo por conversión de moneda.
Ambos extienden PagoDecorator, una clase abstracta que guarda una referencia al `Pago` que decora y delega en él (super.costo(), super.descripcion()) antes de sumar su propia tarifa. El Main va envolviendo el pago capa por capa y mostrando cómo el costo total crece en cada paso.

### 5.2 Patrón Singleton (`PatronSingleton`)
 
**Problema que resuelve:** garantizar que exista una sola instancia de una clase en toda la aplicación (por ejemplo, un gestor de pagos que centraliza el procesamiento) y dar un punto de acceso global a esa instancia.
 
**Ejercicio:** la clase Gestor tiene:
 
- Un atributo estático privado instanciaUnica.
- Un constructor **privado**, para que nadie pueda hacer new Gestor() desde fuera.
- Un método estático getInstancia() que crea el objeto la primera vez que se pide (creación perezosa o *lazy*) y luego siempre devuelve esa misma referencia.
En el Main se piden dos instancias con Gestor.getInstancia() y se comparan con `==` para comprobar que efectivamente son el mismo objeto en memoria.
 
### 5.3 Patrón Observador (`PatronObservador`)
 
**Problema que resuelve:** notificar automáticamente a varios objetos interesados (observadores) cuando cambia el estado de otro objeto (sujeto), sin que el sujeto necesite conocer los detalles de cada observador.
 
**Ejercicio:**
 
- Subject es una clase abstracta que mantiene una lista de Observer y sabe agregarlos, quitarlos y notificarlos (notificarObservadores).
- Gestor extiende Subject: cuando procesa un pago (`procesarPago`), notifica a todos los observadores registrados.
- Cliente implementa Observer: su método actualizar(monto) define qué hace cada cliente al recibir la notificación (imprime que fue avisado del pago).
En el Main se registran dos clientes (Juan y Diego) al Gestor; al procesar un pago, ambos reciben la notificación automáticamente.
 
### 5.4 Patrón Plantilla de Método (`PatronPlantillaMetodo`)
 
**Problema que resuelve:** definir el esqueleto fijo de un algoritmo en una clase base, dejando que las subclases solo redefinan ciertos pasos puntuales, sin poder alterar el orden general del proceso.
 
**Ejercicio:** la clase abstracta PagoConTarjeta define el método procesarPago() como final (no se puede sobrescribir), y ese método llama en orden fijo a: validarTarjeta() → verificarFondos() → realizarCobro() → confirmarTransaccion().
 
- validarTarjeta() es abstracto: cada subclase está obligada a implementarlo.
- calcularCargosAdicionales() es un método gancho (hook): tiene una implementación por defecto (sin cargos) que las subclases pueden sobrescribir si quieren, pero no es obligatorio.
- `PagoConVisa` y `PagoConMasterCard` solo implementan la validación y el cálculo de su propio cargo (2% y 1.5% respectivamente); el resto del flujo (verificar fondos, cobrar, confirmar) ya está resuelto en la clase base y es igual para ambas.

### 5.5 Patrón Proxy (`PatronProxy`)
 
**Problema que resuelve:** controlar el acceso a un objeto "real" interponiendo un intermediario (proxy) que puede validar permisos, retrasar la creación del objeto real, o agregar lógica adicional antes de delegarle la llamada.
 
**Ejercicio:** la interfaz AnularDescuento define solicitarAnulacion(monto). SolicitudAnulacion es la clase real que hace la anulación. Proxy también implementa AnularDescuento, pero:
 
- Recibe en el constructor si el usuario tiene permiso o no.
- Si tiene permiso, crea (solo la primera vez que se necesita) una instancia de SolicitudAnulacion y le delega la llamada.
- Si no tiene permiso, rechaza la operación sin siquiera llegar a crear el objeto real.
El Main le pregunta al usuario si tiene permisos y así decide si el Proxy deja pasar la solicitud o la bloquea.
 
## 6. Resumen rápido de los 5 patrones
 
| Patrón | Categoría | Qué resuelve en este proyecto |
|---|---|---|
| Decorador | Estructural | Sumar tarifas al costo de un pago sin heredar por cada combinación |
| Singleton | Creacional | Un único gestor de pagos accesible desde cualquier parte |
| Observador | Comportamiento | Avisar a varios clientes cuando se procesa un pago |
| Plantilla de Método | Comportamiento | Fijar el flujo de pago con tarjeta y variar solo la validación y el cargo |
| Proxy | Estructural | Bloquear o permitir la anulación de un descuento según permisos |

## 7. 👤 Autor
 
**Juan Diego Galindo**
Estudiante de Ingeniería de Sistemas - Cuarto Semestre
 
- GitHub: [@tu-usuario](https://github.com/juandiegogalindo)
- LinkedIn: [tu-perfil](https://linkedin.com/in/jdgalindo6)
