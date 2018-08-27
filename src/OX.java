public class OX {
    private String[][] table ;
    private String Player ;
    private int countx = 0;
    private int counto = 0;
    private int countDraw = 0;
    int row = 3 ;
    int col = 3 ;
    static int Round = 0;
    OX(){
        Player = "x" ;
        table = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[i][j]="-";
            }
        }
    }
    public String PrintScore(){
        return "Score x : "+countx+"\n"+"Score o : "+counto+"\n"+"Draw : "+countDraw;
//        System.out.println("Score x : "+countx);
//        System.out.println("Score o : "+counto);
//        System.out.println("Draw : "+countDraw);
    }

    public String GetTableString (){
        String table1 ="  0 1 2\n" ;

        for (int i = 0; i < row ; i++) {

            table1 += i+" ";
            for (int j = 0; j < col ; j++) {
               if(j!=2){
                   table1 += table[i][j] +" ";
               }else {
                   table1 += table[i][j];
               }
            }
            if(i!=2){
                table1+="\n";
            }
        }
    return table1;
    }

    public void SwitchPlayer(){
        if(Player.equals("x")){
            Player = "o";
        }else Player ="x";
    }

    public String get (int row , int col ){
        return table[row][col];
    }

    public boolean put (int row , int col){
        try{
            if(table[row][col]=="-"){
                table[row][col] = Player;
                Round++;
                return true;
            }else {
                System.out.println("ช่องนี้ไม่ว่าง");
                return false;
            }
        }catch (Exception e){
            System.out.println("กรุณากาให้ลงตาราง");
            return false;
        }
    }

    public String GetPlayerCurrent(){
        return Player;
    }

    public int getCountx (){
        return countx;
    }

    public int getCounto (){
        return counto;
    }

    public int getCountDraw (){
        return countDraw;
    }

    public void ResetTable(){

        Round = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[i][j] = "-";
            }
        }

    }

    public boolean CheckWin(){

        if(table[0][0]==table[0][1]&&table[0][2]==table[0][1]&&!table[0][0].equals("-")){ // xxx --- ---
            if(table[0][0]=="x") {
                countx++;
            }else counto++;
            return true;
        }else if(table[2][0]==table[2][1]&&table[2][1]==table[2][2]&&!table[2][0].equals("-")){//--- --- xxx
            if(table[2][0]=="x") {
                countx++;
            }else counto++;
            return true;

        }else if(table[1][0]==table[1][1]&&table[1][1]==table[1][2]&&!table[1][0].equals("-")){//--- xxx ---
            if(table[1][0]=="x") {
                countx++;
            }else counto++;
            return true;

        }else if(table[0][1]==table[1][1]&&table[1][1]==table[2][1]&&!table[0][1].equals("-")){// -x- -x- -x-
            if(table[0][1]=="x") {
                countx++;
            }else counto++;
            return true;

        }else if(table[0][0]==table[1][0]&&table[1][0]==table[2][0]&&!table[0][0].equals("-")){// x-- x-- x--
            if(table[0][0]=="x") {
                countx++;
            }else counto++;
              return true;

        }else if(table[0][2]==table[1][2]&&table[1][2]==table[2][2]&&!table[0][2].equals("-")){// --x --x --x
            if(table[0][2]=="x") {
                countx++;
            }else counto++;
            return true;
        }else if(table[0][0]==table[1][1]&&table[1][1]==table[2][2]&&!table[2][2].equals("-")){// x-- -x- --x
            if(table[0][0]=="x") {
                countx++;
            }else counto++;
            return true;

        }else if(table[2][0]==table[1][1]&&table[1][1]==table[0][2]&&!table[1][1].equals("-")){// --x -x- x--
            if(table[2][0]=="x") {
                countx++;
            }else counto++;
            return true;

        }else {
            if(Round==9){
                countDraw++;
                return true;
            }else {
                return false;
            }
        }

    }

}
