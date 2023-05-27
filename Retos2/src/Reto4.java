import java.util.Scanner;
public class Reto4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int contadorProductos=0;
        String [][] productos = new String [4][4];

        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos.length; j++) {
                contadorProductos++;
                System.out.println("Ingrese el nombre del producto "+(contadorProductos));
                String nomProduc = entrada.nextLine();
                System.out.println("Ingrese el precio del producto "+(contadorProductos));
                int precioProduc = entrada.nextInt(); 
                entrada.nextLine();
                productos[i][j] = "["+nomProduc+"]"+"[$"+precioProduc+"]";   
            }

        }

        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos.length; j++) {
                System.out.print(i+""+j+" "+productos[i][j]+" \t");
            }
            System.out.println();
        }
        entrada.close();
    }
}