import JugadorTabla.JugadorTabla1;
import JugadorTabla.JugadorTabla2;

import java.util.Scanner;

public class BatallaNaval {
    public static void main(String[] args) {
        //Creamos las diferentes variables a utilizar.
        Scanner txt = new Scanner(System.in);
        Scanner numb = new Scanner(System.in);
        int dific;
        int bombas;
        int bombasR;
        int corX;
        int corY;
        int tamanio;
        int direccion;
        /*
        Creamos dos Objetos de la clase Tablero, para proporcionarle
        una Tabla bidimensional a cada jugador
         */
        //Damos un Nombre para cada Jugador, en el caso del Jugador 1 lo introduce por teclado.
        System.out.println("Ingrese su nombre: ");
        JugadorTabla1 tablaJug1 = new JugadorTabla1(txt.nextLine());
        JugadorTabla2 tablaJug2 = new JugadorTabla2("Computadora");
        tablaJug1.llenarTabla();//llenamos la tabla del jugador 1
        tablaJug2.llenarTabla();//llenamos la tabla del jugador 2

        System.out.println("Elegir Dificultad: 1 Facil, 2 Medio, 3 Dificil");
        //Asiganmos una dificultad, para el otorgamiento de las bombas
        dific = numb.nextInt();
        if (dific == 1){
            bombas = 50;
            bombasR = 50;
        }else if(dific == 2){
            bombas = 35;
            bombasR = 35;
        }else{
            bombas = 22;
            bombasR = 22;
        }
        //Empezamos a ubicar los Buques del Jugador 1 a traves de datos por teclado
        int cont1 = 5; /* trabajando con un contador, para que a travez
        de este nos aseguremos su ubicacion de forma correcta*/
        while (cont1 > 4){
            System.out.println("Ubicar Destructor");
            System.out.println("Columna");
            corX = numb.nextInt();
            System.out.println("Fila");
            corY = numb.nextInt();
            System.out.println("Horizontal=1, Vertical=2");
            direccion = numb.nextInt();
            tablaJug1.ubicarBuqueUsuario(corX, corY, cont1, direccion);
            if (tablaJug1.getBuqueAnadido1() == 5){
                cont1 = cont1-1;
            }
        }
        while (cont1 > 3){
            System.out.println("Ubicar Acorazado");
            System.out.println("Columna");
            corX = numb.nextInt();
            System.out.println("Fila");
            corY = numb.nextInt();
            System.out.println("Horizontal=1, Vertical=2");
            direccion = numb.nextInt();
            tablaJug1.ubicarBuqueUsuario(corX, corY,cont1, direccion);
            if (tablaJug1.getBuqueAnadido1() == 9){
                cont1 = cont1-1;
            }
        }
        while (cont1 > 2){
            System.out.println("Ubicar Fragata");
            System.out.println("Columna");
            corX = numb.nextInt();
            System.out.println("Fila");
            corY = numb.nextInt();
            System.out.println("Horizontal=1, Vertical=2");
            direccion = numb.nextInt();
            tablaJug1.ubicarBuqueUsuario(corX, corY, cont1, direccion);
            if (tablaJug1.getBuqueAnadido1() == 12){
                cont1 = cont1-1;
            }
        }
        while (cont1 > 1){
            System.out.println("Ubicar Primer MOnitor");
            System.out.println("Columna");
            corX = numb.nextInt();
            System.out.println("Fila");
            corY = numb.nextInt();
            System.out.println("Horizontal=1, Vertical=2");
            direccion = numb.nextInt();
            tablaJug1.ubicarBuqueUsuario(corX, corY, cont1, direccion);
            if (tablaJug1.getBuqueAnadido1() == 14){
                cont1 = cont1-1;
            }
        }
        while (cont1 > 0){
            System.out.println("Ubicar Segundo MOnitor");
            System.out.println("Columna");
            corX = numb.nextInt();
            System.out.println("Fila");
            corY = numb.nextInt();
            System.out.println("Horizontal=1, Vertical=2");
            direccion = numb.nextInt();
            tablaJug1.ubicarBuqueUsuario(corX, corY, 2, direccion);
            if (tablaJug1.getBuqueAnadido1() == 16){
                cont1 = cont1-1;
            }
        }
        //Empezamos a ubicar los Buques del Jugador 2 de forma Random
        int cont2 = 5;
        while (cont2 > 4){
            tablaJug2.ubicarBuqueRandom(5);
            if (tablaJug2.getBuqueAnadido2() == 5){
                cont2 = cont2-1;
            }
        }
        while (cont2 > 3){
            tablaJug2.ubicarBuqueRandom(4);
            if (tablaJug2.getBuqueAnadido2() == 9){
                cont2 = cont2-1;
            }
        }
        while (cont2 > 2){
            tablaJug2.ubicarBuqueRandom(3);
            if (tablaJug2.getBuqueAnadido2() == 12){
                cont2 = cont2-1;
            }
        }
        while (cont2 > 1){
            tablaJug2.ubicarBuqueRandom(2);
            if (tablaJug2.getBuqueAnadido2() == 14){
                cont2 = cont2-1;
            }
        }
        while (cont2 > 0){
            tablaJug2.ubicarBuqueRandom(2);
            if (tablaJug2.getBuqueAnadido2() == 16){
                cont2 = cont2-1;
            }
        }
        // Mostramos los Arreglos
        tablaJug1.mostrarTabla();
        tablaJug2.mostrarTabla();

        //Comenzamos con el Juego
        String turno = "JUG1";
        int acer1 = 0;
        int acer2 = 0;
        while (bombas>0 && bombasR>0 && acer1 < 16 && acer2 < 16){
            if (turno == "JUG1"){
                System.out.println("Dame nro de columna");
                corX = numb.nextInt();
                System.out.println("Dame nro de fila");
                corY = numb.nextInt();
                tablaJug2.dispararUsuario(corX,corY);
                if (tablaJug2.getCorrecto2() == "No"){
                    turno = "JUG2";
                    bombas -= 1;
                }else if (tablaJug2.getAciertos2() == "Si"){
                        bombas -= 1;
                        acer1 += 1;
                }
                System.out.println("Cantidad de Aciertos: " + acer1);
                System.out.println("Bombas Restantes: " + bombas);
                tablaJug2.mostrarTabla();
            }else {
                tablaJug1.dispararRandom();
                if (tablaJug1.getCorrecto1() == "No"){
                    turno = "JUG1";
                    bombasR -= 1;
                }else if (tablaJug1.getAciertos1() == "Si"){
                    acer2 += 1;
                    bombasR -= 1;
                }
                System.out.println("Cantidad de Aciertos: " + acer2);
                System.out.println("Bombas Restantes: " + bombasR);
                tablaJug1.mostrarTabla();
            }
        }
        if (acer1 == 16){
            System.out.println("el ganador es: " + tablaJug1.getNombre());
            tablaJug1.mostrarTabla();
            tablaJug2.mostrarTablaLlena();
        }else {
            System.out.println("el ganador es: " + tablaJug2.getNombre());
            tablaJug1.mostrarTabla();
            tablaJug2.mostrarTablaLlena();
        }
    }
    //integrantes
    //Facundo Gonzalez
    //Axel Araya Spies
    //Matias Almiron
}
