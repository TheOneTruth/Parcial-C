public class Inventario {

   
    public static int contarProductosAgotados(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int cantidad : fila) {
                if (cantidad == 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    
    public static double promedioInventarioBajo(int[][] matriz) {
        int suma = 0, contador = 0;
        for (int[] fila : matriz) {
            for (int cantidad : fila) {
                if (cantidad < 20) {
                    suma += cantidad;
                    contador++;
                }
            }
        }
        return contador == 0 ? 0 : (double) suma / contador;
    }

    
    public static void imprimirInventarioCritico(int[][] matriz) {
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int colu = 0; colu < matriz[filas].length; colu++) {
                if (matriz[filas][colu] <= 5) {
                    System.out.println("Inventario critico en [" + filas + "][" + colu + "]: " + matriz[filas][colu] + " unidades");
                }
            }
        }
    }

    
    public static int[] posicionMayorInventario(int[][] matriz) {
        int maxCantidad = Integer.MIN_VALUE;
        int[] posicion = {-1, -1};
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int colu= 0; colu < matriz[filas].length; colu++) {
                if (matriz[filas][colu] > maxCantidad) {
                    maxCantidad = matriz[filas][colu];
                    posicion[0] = filas;
                    posicion[1] = colu;
                }
            }
        }
        return posicion;
    }

    

    public static void main(String[] args) {
        
        int[][] inventario = {
            {10, 0, 52, 5},
            {18, 100, 9, 15},
            {3, 20, 7, 29}
        };

        System.out.println("Productos agotados: " + contarProductosAgotados(inventario));
        System.out.println("Promedio de inventario bajo: " + promedioInventarioBajo(inventario));
        imprimirInventarioCritico(inventario);
        int[] mayor = posicionMayorInventario(inventario);
        System.out.println("Mayor inventario en: [" + mayor[0] + "][" + mayor[1] + "]");
    }
}
