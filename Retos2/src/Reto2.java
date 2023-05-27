import java.util.Scanner;
public class Reto2 {
    public static void main(String[] args){
        int numCompetidores, ganador=0;
        boolean noGanador=false;
        double tiempoGanador;
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese el numero de competidores que participarán en la comoetencia");
        numCompetidores = entrada.nextInt();
        String nombresComp[] = new String [numCompetidores];
        double tiempos [] = new double [numCompetidores];
        for (int i = 0; i < numCompetidores; i++) {
                System.out.println("Ingrese el nombre del competidor N°"+(i+1));
                nombresComp[i] = entrada.next().toUpperCase();
            
            
        }
        for (int j = 0;  j<numCompetidores; j++) {
                System.out.println("Ingrese el tiempo del competidor N°"+(j+1));
                tiempos[j] = entrada.nextDouble();
        }

        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("COMPETIDOR N°:"+(i+1)+"."+nombresComp[i]);
            System.out.println("TIEMPO: "+tiempos[i]);
        }

        tiempoGanador = tiempos[0];
        ganador = 0;
        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < tiempoGanador) {
                tiempoGanador = tiempos[i];
                ganador = i;
            }
            if (tiempos[i]==tiempoGanador) {
                noGanador=true;
            }
        }
        if (noGanador) {
            System.out.println("No hubo ganador por que hubo un empate");
        }else{
            System.out.println("El ganador es el participante " + (ganador + 1) + " con un tiempo de " + tiempoGanador + " segundos.");
        }
        entrada.close();
    }
}
