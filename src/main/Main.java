package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        System.out.print("0) ");
        // Escribe el código que devuelva una cadena al revés. Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".

        System.out.println("Al revés es: " + reverse("hola mundo"));

        String[] nombres = new String[3];
        nombres[0] = "Dmitri";
        nombres[1] = "Iván";
        nombres[2] = "Rubén";

        System.out.print("1) El nombres es: ");
        // Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.

        for (String nombre : nombres) {
            System.out.print(nombre + " ");
        }

        System.out.println("");
        int[][] bid = new int[2][2];
        bid[0][0] = 1;
        bid[0][1] = 2;
        bid[1][0] = 3;
        bid[1][1] = 4;

        System.out.println("2) ");
        // Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.

        for (int i = 0; i < bid.length; i++) {
            for (int j = 0; j < bid[i].length; j++) {
                System.out.println("Estoy en i = " + i + ", j = " + j + " con el valor = " + bid[i][j]);
            }
        }

        System.out.println("3) ");
        // Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.
        Vector<Integer> miVector = new Vector<>();
        miVector.add(5);
        miVector.add(10); // borrar
        miVector.add(17); // borrar
        miVector.add(24);
        miVector.add(30);

        miVector.remove(1);
        miVector.remove(1);

        for (int i = 0; i < miVector.size(); i++) {
            System.out.println("Mi vector es: " + miVector.get(i));
        }

        System.out.println("4) ");
        // Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.

        // Por defecto es 10, pues entonces va a ir añadiendo (multiplicando por 2) hasta que llega a 1 000
        // entonces es mejor declararla la capacidad como 1 000 al principio si ya sabemos que hay 1 000

        System.out.println("5) ");
        // Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.
        ArrayList<String> miArrayList = new ArrayList<>();
        miArrayList.add("Invierno");
        miArrayList.add("Primavera");
        miArrayList.add("Verano");
        miArrayList.add("Otoño");
        LinkedList<String> miLinkedList = new LinkedList<>(miArrayList);

        for (Object objeto : miArrayList.toArray()){
            System.out.println(objeto.toString());
        }
        for (Object objeto : miLinkedList.toArray()){
            System.out.println(objeto.toString());
        }

        System.out.println("6) ");
        // Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los números pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        ArrayList<Integer> miSegundoAL = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            miSegundoAL.add(i+1);
        }

        for (Object objeto : miSegundoAL.toArray()){
            System.out.println(objeto);
        }

        // primera forma
        for (int i = 0; i < miSegundoAL.size(); i++){
            if (miSegundoAL.get(i) % 2 == 0) {
                miSegundoAL.remove(i);
                i--;
                continue;
            }
            System.out.println(miSegundoAL.get(i));
        }

        // segunda forma
        for (int i = 0; i < miSegundoAL.size(); i++) {
            System.out.println(miSegundoAL.get(i));
        }

        System.out.println("7) ");
        // Crea una función DividePorCero.
        // Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException
        // que será capturada por su llamante (desde "main", por ejemplo).
        // Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        // Finalmente, mostraremos en cualquier caso: "Demo de código".

        try {
            int res = DividePorCero(5,0);
            System.out.println("Dividir por cero: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de código");
        }

        System.out.println("8) ");
        // Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
        // "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero dado en el parámetro
        // "fileIn" al fichero dado en "fileOut".

        copiarFicheros("example.txt","example2.txt");

        System.out.println("9) ");
        // Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones,
        // un HashMap y un ArrayList, LinkedList o array.

        // Multiplicar por 2 un número desde el fichero, imprimir en el fichero
        try {
            InputStream in = new FileInputStream("num.txt");
            try {
                byte[] datos = in.readAllBytes();
                in.close();

                String datos2 = "";
                for (byte dato : datos) {
                    datos2+= (char) dato;
                }

                int miNumero = Integer.parseInt(datos2);
                miNumero*= 2;
                //datos2 = Integer.toString(miNumero);

                PrintStream out = new PrintStream("res.txt");
                out.print(miNumero);
                out.close();

                System.out.println("Mira al fichero");

            } catch (IOException e) {
                System.out.println("No puedo leer el fichero: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oye, que el programa da error: " + e.getMessage());
        }

    }

    public static String reverse(String texto) {

        int contador = texto.length() - 1;
        String nuevaOracion = "";

        while (contador >= 0){
            nuevaOracion += texto.charAt(contador);
            contador--;
        }

        return nuevaOracion;
    }

    public static int DividePorCero(int numero1, int numero2) throws ArithmeticException {
        int resultado;
        try {
            resultado = numero1 / numero2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        return resultado;
    }

    public static void copiarFicheros(String path1, String path2) {

        try {
            InputStream in = new FileInputStream(path1);
            try {
                byte[] datos = in.readAllBytes();
                PrintStream out = new PrintStream(path2);
                out.write(datos);
                System.out.println("¡Copia hecha!");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra: " + e.getMessage());
        }

    }
}
