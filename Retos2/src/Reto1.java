import java.util.Scanner;
public class Reto1 {
    public static void main(String[] args) throws Exception {
        // Declarar variables
        int numNotas;
        float promedio=0, sumNotas=0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de notas");
        numNotas = entrada.nextInt();
        float [] valorNotas = new float[numNotas];
        for(int i=0; i<numNotas; i++){
            System.out.println("Ingrese el valor correspondiente a la nota N°"+(i+1));
            valorNotas[i] = entrada.nextFloat();
            sumNotas+=valorNotas[i];
        }
        promedio = sumNotas/numNotas;
        System.out.println("El promedio de la notas y la nota final es:  "+promedio);
        if (promedio<3) {
            System.out.println("Has reprobado");
        } else if(promedio>=3 && promedio<=4){
            System.out.println("Pasaste raspando");
        } else{
            System.out.println("Aprobaste con buenos resultados");
        }
        entrada.close();
    }
}

