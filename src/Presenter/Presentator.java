package Presenter;

import Model.Soup;
import Views.View;

import java.util.Scanner;

public class Presentator {
    public Scanner sc = new Scanner(System.in);
    public View view = new View();
    public static Soup soup;
    public void menu() {
        int option;

        soup= new Soup();
        soup.wordsPutter();
        soup.filler();
        do {
            if (soup.getWordsFound() == soup.constants.getWORDS().length) {
                view.showMessage("Felicidades, has encontrado todas las palabras");
                return;
            }

            view.showMessage(" 1. Ver sopa de letras\n 2. Encontrar palabra\n 3. Volver\n");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    view.showMessage(soup.toString());
                }
                case 2 -> {

                    view.showMessage("Ingrese la posicion(Filas y columnas) de la primera letra de la palabra a buscar: ");
                    int x = view.askInfo();
                    int y = view.askInfo();
                    view.showMessage("Ingrese la posicion(Filas y columnas) de la ultima letra de la palabra a buscar: ");
                    int x2 = view.askInfo();
                    int y2 = view.askInfo();
                    isFound(soup.wordFound(x, y, x2, y2));

                }
                case 3 -> {
                    view.showMessage("Gracias por jugar");
                }
                default -> {
                    view.showMessage("Opción no válida");
                }
            }

        } while (option != 3);
    }

    public void isFound(Boolean found){
        if (found){
            view.showMessage("Palabra encontrada");
        }else{
            view.showMessage("Palabra no encontrada");
        }
    }

    public void initGame() {
        int option;

        do {
            view.showMessage("Bienvenido a la sopa de letras\n 1. Jugar\n 2. Salir\n");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    menu();
                }
                case 2 -> {
                    view.showMessage("Gracias por jugar");
                }
                default -> {
                    view.showMessage("Opción no válida");
                    return;
                }
            }

        } while (option != 2);
    }

    public static void main(String[] args) {
        Presentator presentator = new Presentator();
        presentator.initGame();
    }

}
