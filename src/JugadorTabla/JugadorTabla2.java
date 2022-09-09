package JugadorTabla;

import java.util.Random;

public class JugadorTabla2 {
    private String nombre;
    private String tabla1[][] = new String [10][10];
    private String tabla2[][] = new String [10][10];
    private int tam;
    private boolean dir;
    private int corX;
    private int corY;
    private int BuqueAnadido2 = 0;
    private String Correcto2;
    private String Acerto2;

    public JugadorTabla2(String nombre) {
        this.nombre = nombre;
        this.tabla1 = new String [10][10];
        this.tabla2 = new String [10][10];
    }
    public void ubicarBuqueRandom(int tam){
        int contador2 = 0;
        Random x = new Random();
        Random y = new Random();
        Random d = new Random();
        this.tam = tam;
        this.dir = d.nextBoolean();
        int posX = x.nextInt(6);
        int posY = y.nextInt(6);
        while (posX + tam < 5){
            posX = x.nextInt(7);
        }
        while (posY + tam < 5){
            posY = y.nextInt(7);
        }
        if (this.dir){
            for(int i = 0; i < tam; i++){
                if (tabla1[posY][posX+i] == "[a]"){
                    contador2=contador2 + 1;
                }
            }
        }else{
            for(int i = 0; i < tam; i++){
                if (tabla1[posY+i][posX] == "[a]"){
                    contador2=contador2 + 1;
                }
            }
        }
        if (this.dir == true && contador2 == 0){
            for(int i = 0; i < tam; i++){
                tabla1[posY][posX+i] = "[a]";
                BuqueAnadido2 = BuqueAnadido2 + 1;
            }
        }else if (this.dir == false && contador2 == 0){
            for(int i = 0; i < tam; i++){
                tabla1[posY+i][posX] = "[a]";
                BuqueAnadido2 = BuqueAnadido2 + 1;
            }
        }
    }
    public int getBuqueAnadido2(){
        return BuqueAnadido2;
    }
    public void mostrarTabla(){
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla2[i][j]+"  ");
            }
            System.out.println( "" );
        }
        System.out.println("[B]=Disparo Acertado; [*]=Disparo Fallido; ");
    }
    public void mostrarTablaLlena(){
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla1[i][j]+"  ");
            }
            System.out.println( "" );
        }
    }
    public void dispararUsuario(int X, int Y){
        this.corX = X;
        this.corY = Y;

        if (tabla1[corY-1][corX-1] == "[ ]"){
            tabla2[corY-1][corX-1] = "[*]";
            tabla1[corY-1][corX-1] = "[*]";
            System.out.println("No acerto");
            Correcto2 = "No";
        }else if (tabla1[corY-1][corX-1] == "[a]"){
            tabla2[corY-1][corX-1] = "[B]";
            tabla1[corY-1][corX-1] = "[B]";
            System.out.println("Acerto: Nuevo tiro");
            Correcto2 = "Si";
            Acerto2 = "Si";
        }else  if (tabla2[corY-1][corX-1] == "[*]" || tabla2[corY-1][corX-1] == "[B]"){
            System.out.println("Ya disparo a esa posicion, intante nuevamente");
            Correcto2 = "Si";
            Acerto2 = "No";
        }
    }
    public void llenarTabla (){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabla2[i][j] = "[ ]";
                tabla1[i][j] = "[ ]";
            }
        }
    }
    public String getAciertos2 (){
        return Acerto2;
    }
    public String getCorrecto2 () {
        return Correcto2;
    }
    public String getNombre () {
        return nombre;
    }
}
