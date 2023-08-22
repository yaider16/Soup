package Views;

import java.util.Scanner;

public class View {

    public void showMessage(String message){
        System.out.println(message);
    }

    public int askInfo(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
