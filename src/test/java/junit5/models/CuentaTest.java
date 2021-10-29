package junit5.models;

import junit5.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//TestInstance -- Crea una sola instancia por clase.ß
//Es mala practica(ya que estamos acoplando los metodos) crear esta instancia,
//se crea una sola vez y no por cada test
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class CuentaTest {

    Cuenta cuenta;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @BeforeEach
    void initMetodoTest() {
        this.cuenta = new Cuenta("Fabrizzio", new BigDecimal("1000.12345"));
        System.out.println("iniciando el metodo");
    }

    @AfterEach
    void tearDown() {
        System.out.println("finalizando el metodo de prueba");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando test");
    }

    @Nested
    @DisplayName("Probando atributos de la cuenta corriente")
    class CuentaTestNombreSaldo {
        @Test
        @DisplayName("El nombre")
        void testNombreCuenta() {

            String esperado = "Fabrizzio";
            String real = cuenta.getPersona();
            assertNotNull(real, () -> "La cuenta no puede ser nula");
            assertEquals(esperado, real, () -> "El nombre de la cuenta no es la que se esperaba. Se esperaba:"
                    + esperado + "sin embargo fue:" + real);
            assertTrue(real.equals("Fabrizzio"), () -> "Esperado debe ser igual a la real");
        }

        @Test
        @DisplayName("El saldo")
        void testSaldoCuenta() {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("Probrando referencias que sean iguales con el metodo equals")
        void testReferenciaCuenta() {
            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.1223"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.1223"));

            //Comparacion por referencia
//        assertNotEquals(cuenta2, cuenta);
            //Comparar por valor
            assertEquals(cuenta2, cuenta);
        }
    }

    @Nested
    class CuentaOperacionesTest {
        @Test
        @DisplayName("Pruebando debito de cuenta")
        void testDebitoCuenta() {
            cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Test
        @DisplayName("Probando credito de cuenta")
        void testCreditoCuenta() {
            cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Test
        @DisplayName("Probando transferencia de dinero de las cuentas")
        void testTransferirDineroCuentas() {
            Cuenta cuenta1 = new Cuenta("Roxana", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Fabrizzio", new BigDecimal("800.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco dee estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal("500"));
            assertEquals("300.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());
        }
    }


    @Test
    @DisplayName("Probando dinero insuficiente con la clase dinero insuficiente")
    void testDineroInsuficienteExceptionCuenta() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal("1001"));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado, actual);
    }


    @Test
    @Disabled
    @DisplayName("Probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas() {

        Cuenta cuenta1 = new Cuenta("Roxana", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Fabrizzio", new BigDecimal("800.8989"));

        Banco banco = new Banco();

        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal("500"));

        assertAll(() -> assertEquals("300.8989", cuenta2.getSaldo().toPlainString()),

                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString()),

                () -> assertEquals(2, banco.getCuentas().size()),

                () -> assertEquals("Banco del estado", cuenta1.getBanco().getNombre()),

                () -> assertEquals("Fabrizzio", banco.getCuentas()
                        .stream()
                        .filter(c -> c.getPersona().equals("Fabrizzio"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas()
                        .stream()
                        .filter(c -> c.getPersona().equals("Fabrizzio"))
                        .findFirst()
                        .isPresent()),
                () ->
                        //Forma simplificada
                        assertTrue(banco.getCuentas()
                                .stream()
                                .anyMatch(c -> c.getPersona().equals("Fabrizzio")))
        );

    }

    @Nested
    class SistemaOperativoTest {

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {

        }

        @Test
        @EnabledOnOs({OS.MAC, OS.LINUX})
        void testSoloLinuxMac() {

        }

        @Test
        @DisabledOnOs(OS.MAC)
        void testNoWindows() {
        }

    }

    @Nested
    class JavaVersionTest {

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_12)
        void soloJdk12() {
        }

    }

    @Nested
    class SistemPropertiesTest {
        //Habilitar si existe cierta propiedad del sistema
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "12.0.2")
        void testJavaVersion() {
        }

        @Test
        @EnabledOnOs(OS.WINDOWS)
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testSolo64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "fabrizzioruiz")
        void testUserName() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {
        }

    }

    @Nested
    class VariablesAmbienteTest {

        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });
        }

        //EN mac no aparece...

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-15.0.1.*")
        void testJavaHome() {
        }

        //En mac no funciona
        //Nos permitira ejecutar pruebas unitarias bien pesadas que necesiten
        //cierta cantidad de n de procesarores
        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "12")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testEnv() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "prod")
        void testEnvDisabled() {
        }

    }


    //Se ejecutara solo cuando el ambiente sea de desarrollo
    @Test
    //@DisplayName("Probando el saldo de la cuenta")
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            //Dentro de esta expresion lamda colocamos lo que queremos habilitar o desabilitar
            //Si falla aqui adentro falla el metodo entero
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    //Se utiliza cuando tenemos cierta aletoridad, parametro cambiante
    @DisplayName("Probando debito Cuenta Repetir")
    @RepeatedTest(value=5, name="{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if(info.getCurrentRepetition() == 3) {
            System.out.println("Estoy en la repeticion " + info.getCurrentRepetition());
        }
        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }


}