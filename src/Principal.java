import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversionDeDivisa consulta = new ConversionDeDivisa();
        Divisa divisa;
        var tipoDeMonedaOrigen = "";
        var tipoDeMonedaDestino = "";
        var monto = 0.0;

        int opc = 0;

        try {
            while (opc != 3){
                System.out.println("*****************************************************");
                System.out.println("   Bienvenido el sistema de conversion de divisas");
                System.out.println("   Ingresa una opcion para continuar");
                System.out.println("   1. Intrucciones de funcionamiento ");
                System.out.println("   2. Conversion de divisas");
                System.out.println("   3. Salir");
                System.out.println("*****************************************************");
                opc = Integer.parseInt(lectura.nextLine());
                switch (opc){
                    case 1:
                        System.out.println("Bienvenido al sistema de conversion de divisas\n" +
                                "Si deseas convertir algun monto, debes ingresar\n " +
                                "el codigo de la moneda en que tienes tu dinero \n" +
                                "asi como el de la moneda al que deseas convertir,\n " +
                                "por ultimo ingresar el monto por ejemplo: \n" +
                                "           USD - MXN - 50.");
                        break;
                    case 2:
                        try{
                            System.out.println("""
                                    Monedas ejemplo: 
                                        MXN - Peso mexicano
                                        EUR - Euro
                                        ARS - Peso argentino
                                        BOB - Boliviano boliviano
                                        BRL - Real brasileño
                                        CLP - Peso chileno
                                        COP - Peso colombiano
                                        USD - Dólar estadounidense
                                    -------------------------------
                                    
                                    """);
                            System.out.println("Escribe la moneda que deseas cambiar:");
                            tipoDeMonedaOrigen = lectura.nextLine();
                            System.out.println("Escribe la moneda a la que deseas convertir:");
                            tipoDeMonedaDestino = lectura.nextLine();
                            System.out.println("Escribe la moneda que deseas convertir:");
                            monto = Double.parseDouble(lectura.nextLine());

                            divisa = consulta.retornaInformacionDivisa(tipoDeMonedaOrigen, tipoDeMonedaDestino, monto);
                            System.out.println(divisa);
                            GeneradorDeArchivo generador = new GeneradorDeArchivo();
                            generador.guardarJson(divisa, monto);
                        } catch (NumberFormatException e){
                            System.out.println("Monto no convertible "+e.getMessage());
                        } catch (RuntimeException | IOException e){
                            System.out.println(e.getMessage());
                            System.out.println("Finalizando la aplicación.");
                        }
                        break;
                    default:
                        System.out.println("Ingresa una opcion del menu");
                        System.out.println("*****************************************************");
                        break;
                }
            }
            System.out.println("Ejecucion finalizada");
            System.out.println("Gracias por usar nuestro sistema");
        } catch (NumberFormatException e) {
            System.out.println("Ingresa un numero");
            System.out.println("Gracias por usar nuestro sistema");
        }
    }
}
