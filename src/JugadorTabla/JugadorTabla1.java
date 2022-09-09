package JugadorTabla;

import java.util.Random;

public class JugadorTabla1 {
    private String tabla[][] = new String [10][10];
    private String nombre;
    private int tamanio;
    private int direccion;
    private int corX;
    private int corY;
    private int BuqueAnadido1 = 0;
    private String Correcto1;
    private String Acerto1;

    public JugadorTabla1(String nombre) {
        this.nombre = nombre;
        this.tabla = new String [10][10];
    }
    public void ubicarBuqueUsuario(int X, int Y, int T, int D){
        this.corX = X;
        this.corY = Y;
        this.direccion = D;
        this.tamanio = T;
        int contador1 = 0;
        if (this.direccion == 1){
            for(int i = corX-1; i < corX+tamanio-1; i++){
                if (tabla[corY-1][i] == "[a]"){
                    contador1=contador1 + 1;
                }
            }
        }else{
            for(int i = corY-1; i < corY+tamanio-1; i++){
                if (tabla[i][corX-1] == "[a]"){
                    contador1=contador1 + 1;
                }
            }
        }
        if (this.direccion == 1 && contador1 == 0){
            for(int i = corX-1; i < corX+tamanio-1; i++){
                tabla[corY-1][i] = "[a]";
                BuqueAnadido1 = BuqueAnadido1 + 1;
            }
        }else if (this.direccion == 2 && contador1 == 0){
            for(int i = corY-1; i < corY+tamanio-1; i++){
                tabla[i][corX-1] = "[a]";
                BuqueAnadido1 = BuqueAnadido1 + 1;
            }
        }else{
            System.out.println("Buque mal ubicado, intentar denuevo");
        }
    }
    public int getBuqueAnadido1(){
        return BuqueAnadido1;
    }
    public void mostrarTabla(){
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla[i][j]+"  ");
            }
            System.out.println( "" );
        }
        System.out.println("[B]=Disparo Acertado; [*]=Disparo Fallido; ");
    }
    public void dispararRandom(){
        Random xx = new Random();
        Random yy = new Random();
        this.corX = xx.nextInt(9);
        this.corY = yy.nextInt(9);

        if (tabla[corY][corX] == "[ ]"){
            tabla[corY][corX] = "[*]";
            Correcto1 = "No";

        }else if (tabla[corY][corX] == "[a]"){
            tabla[corY][corX] = "[B]";

            Correcto1 = "Si";
            Acerto1 = "Si";
        }else  if (tabla[corY][corX] == "[B]" || tabla[corY][corX] == "[*]"){
            Correcto1 = "Si";
            Acerto1 = "No";
        }
    }
    public void llenarTabla (){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabla[i][j] = "[ ]";
            }
        }
    }
    public String getAciertos1 (){
        return Acerto1;
    }
    public String getCorrecto1 () {
        return Correcto1;
    }
    public String getNombre () {
        return nombre;
    }
}
