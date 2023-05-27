
import java.util.Scanner;
public class Reto3 {
    public static void main(String[] args) {
        int cantPalabras;
        boolean aciertoLetra, aciertoPalabra, exit = false;
        String letra, letrasAcertadas="";
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cuántas palabras quieres agregar?");
        cantPalabras = entrada.nextInt();
        String palabras[] = new String[cantPalabras];
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Ingrese la palabra a agregar");
            palabras[i] = entrada.next().toUpperCase();
        }

        System.out.println("Bienvenido al juego del ahorcado");

        while(!exit){
            int aleatorio = (int) (Math.random() * palabras.length);
            String palabraAleatoria = palabras[aleatorio];
            aciertoPalabra = false;
            int vidas = palabraAleatoria.length() + 4;
            StringBuilder palabraMostrada = new StringBuilder(palabraAleatoria.length());
            for (int j = 0; j < palabraAleatoria.length(); j++) {
                palabraMostrada.append("_");
            }
            do {
                System.out.println("La palabra secreta tiene " + palabraAleatoria.length() + " letras.");
                System.out.println("Vidas restantes: " + vidas);
                System.out.println("Palabra: " + palabraMostrada.toString());
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Ingrese una letra: ");
                letra = entrada.next().toUpperCase();
                aciertoLetra = false;
                if (letrasAcertadas.contains(letra)) {
                    System.out.println("Ya has acertado la letra " + letra + " antes.");
                    vidas--;
                }
                if (letra.length() == 1) {
                    if (palabraAleatoria.contains(letra)) {
                        for (int j = 0; j < palabraAleatoria.length(); j++) {
                            if (palabraAleatoria.charAt(j) == letra.charAt(0)) {
                                palabraMostrada.setCharAt(j, letra.charAt(0));
                                aciertoLetra = true;
                            }
                        }
                        if (aciertoLetra) {
                            letrasAcertadas += letra;
                        }
                        if (palabraMostrada.indexOf("_") == -1) {
                            aciertoPalabra = true;
                        }
                    } else {
                        System.out.println("No has adivinado la letra.");
                        vidas--;
                    }
                } else {
                    System.out.println("Debe ingresar una sola letra.");
                    vidas--;

                }
            } while (!aciertoPalabra && vidas > 0);

            if (aciertoPalabra) {
                System.out.println("Palabra: " + palabraMostrada.toString());
                System.out.println("¡Has adivinado la palabra!");

            } else {
                System.out.println("Has perdido. La palabra era: " + palabraAleatoria);
            }

            System.out.print("¿Quieres seguir jugando? (SI/NO): ");
            String respuesta = entrada.next().toUpperCase();

            if (respuesta.equals("NO")) {
                exit = true;
            }

        }

        System.out.println("Fin del juego.");
        entrada.close();
    }
}

