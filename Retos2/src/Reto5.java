import java.util.Scanner;

public class Reto5 {
    public static void main(String[] args) {
        boolean exit = false;
        int fila1 = 0, fila2 = 0, columna1 = 0, columna2 = 0, aciertos=6;
        String palabraElegida, palabraElegida2;
        String[][] emparejar = {
            {"Perro", "Gato", "Oveja", "Elefante", "Cebra", "Jirafa"},
            {"Jirafa", "Elefante", "Gato", "Oveja", "Perro", "Cebra"}
        };
        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL JUEGO DE CONCENTRESE");
        System.out.println("El juego consiste en lograr emparejar las palabras (animales) de su mismo tipo");
        System.out.println("Las palabras a encontrar su pareja son:");
        for (int i = 0; i < emparejar.length - 1; i++) {
            for (int j = 0; j < emparejar[i].length; j++) {
                System.out.print(emparejar[i][j] + " \t");
            }
            System.out.println();
        }


        do {
            int totalFilas = emparejar.length;
            int totalColumnas = emparejar[0].length;
            boolean[][] descubiertas = new boolean[totalFilas][totalColumnas];
            for (int i = 0; i < totalFilas; i++) {
                for (int j = 0; j < totalColumnas; j++) {
                    System.out.print("[?]\t");
                }
                System.out.println();
            }
    
            do {
                System.out.println("Ingrese la fila de la primera palabra");
                fila1 = entrada.nextInt();
                System.out.println("Ingrese la columna de la primera palabra");
                columna1 = entrada.nextInt();
                while (descubiertas[fila1][columna1]) {
                    System.out.println("Ha elegido una posición ya descubierta. Escoge otra.");
                    System.out.println("Ingrese la fila de la primera palabra");
                    fila1 = entrada.nextInt();
                    System.out.println("Ingrese la columna de la primera palabra");
                    columna1 = entrada.nextInt();
                }
                palabraElegida = emparejar[fila1][columna1];
                descubiertas[fila1][columna1] = true;
                

                for (int i = 0; i < totalFilas; i++) {
                    for (int j = 0; j < totalColumnas; j++) {
                        if (descubiertas[i][j]) {
                            System.out.print("[" + emparejar[i][j] + "]\t");
                        } else {
                            System.out.print("[?]\t");
                        }
                    }
                    System.out.println();
                }

                System.out.println("Ingrese la fila de la segunda palabra");
                fila2 = entrada.nextInt();
                System.out.println("Ingrese la columna de la segunda palabra");
                columna2 = entrada.nextInt();
                while (descubiertas[fila2][columna2]) {
                    System.out.println("Ha elegido una posición ya descubierta. Escoge otra.");
                    System.out.println("Ingrese la fila de la segunda palabra");
                    fila2 = entrada.nextInt();
                    System.out.println("Ingrese la columna de la segunda palabra");
                    columna2 |= entrada.nextInt();
                }

                palabraElegida2 = emparejar[fila2][columna2];
                descubiertas[fila2][columna2] = true;

                for (int i = 0; i < totalFilas; i++) {
                    for (int j = 0; j < totalColumnas; j++) {
                        if (descubiertas[i][j]) {
                            System.out.print("[" + emparejar[i][j] + "]\t");
                        } else {
                            System.out.print("[?]\t");
                        }
                    }
                    System.out.println();
                }

                if (palabraElegida.equalsIgnoreCase(palabraElegida2)) {
                    System.out.println("Bien hecho, ha encontrado la pareja");
                    aciertos--;
                } else {
                    System.out.println("Las palabras no son pareja.");
                    descubiertas[fila1][columna1] = false;
                    descubiertas[fila2][columna2] = false;
                }

            } while (aciertos>0);

            System.out.println("¿Desea jugar de nuevo? (S/N)");
            String opcion = entrada.next();
            if (opcion.equalsIgnoreCase("N")) {
                exit = true;
            }

        } while (!exit);

        System.out.println("Has terminado");
        entrada.close();

    }
}
