import java.util.*;
public class GAME_0089 {
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        OX oxtable = new OX();
        while (true){
            System.out.print(oxtable.GetTableString());
            System.out.println();
            System.out.print("Turn "+oxtable.GetPlayerCurrent().toUpperCase()+" row : ");
            int row = kb.nextInt();
            System.out.print("Turn "+oxtable.GetPlayerCurrent().toUpperCase()+" col : ");
            int col = kb.nextInt();
            if(oxtable.put(row,col)){
               oxtable.SwitchPlayer();
            }
            if(oxtable.CheckWin()){
                System.out.println(oxtable.GetTableString());
                System.out.println("________________________");
                oxtable.ResetTable();
                System.out.println(oxtable.PrintScore());

            }
        }
    }
}
