
package tic_tac_toe;

/**
 *
 * @author Kevin Czaja, Chris Schäpsmeier
 */
import java.util.Scanner;

public class Tic_tac_toe {
    private int counter;
    private   char posn[]=new char[10];
    private   char Spieler;

    
    public static void main(String[] args) {
        String ch;
        Tic_tac_toe Toe=new Tic_tac_toe();  //neues Spiel generieren
        do{
            Toe.neuesSpielbrett();
            Toe.play();
            Scanner in =new Scanner(System.in);
            ch=in.nextLine();
        }while (ch.equals(" "));
        
        
    }
    public  void neuesSpielbrett()
    {
        //Neues leeres Spielbrett generieren
        char posndef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        counter = 0;
        Spieler = 'X'; //Spieler X als erstes Festlegen
        for (i=1; i<10; i++) posn[i]=posndef[i];
        aktuellesSB();
        
        
    }
    public  String aktuellesSB()
    {
        System.out.println(  "\t\t" + posn [1] + "   | " +posn [2]+ "  | " +posn [3]);
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\t\t" +posn [4]+ "   | " +posn [5]+ "  | " +posn [6]);
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\t\t" +posn [7]+ "   | " +posn [8]+ "  | " +posn [9]);
        System.out.println(  " \t\t    |    |   " );
        return "aktuellesSB";
    }
    
    public  void play()
    {
        int spot;
        char blank = ' ';               
        do {                        
            System.out.println(  "\n\n Spieler " + getSpieler() +" wählen sie eine Zahl aus" );
            
            boolean posTaken = true; 
            while (posTaken) {
                Scanner in =new Scanner (System.in);
                spot=in.nextInt();
                posTaken = checkPosn(spot);
                if(posTaken==false)
                posn[spot]=getSpieler();
            }
                        
            aktuellesSB();              // aktuelles Spielbrett ausgeben
            
            nextSpieler();
        }while ( checkWinner() == blank );
        
    }
    
    public  char checkWinner()
    {
        char Winner = ' ';
        
        // Spieler X gewinnt
        if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X') Winner = 'X';
        if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X') Winner = 'X';
        if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X') Winner = 'X';
        if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X') Winner = 'X';
        if (Winner == 'X' )
        {System.out.println("Spieler X gewinnt!!." );
            return Winner;
        }
        
        // Check 0 gewinnt
        if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O') Winner = 'O';
        if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O') Winner = 'O';
        if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O') Winner = 'O';
        if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O') Winner = 'O';
        if (Winner == 'O' )
        {
            System.out.println( "Spieler O gewinnt!!" );
        return Winner; }
        
        // Gleichstand?
        for(int i=1;i<10;i++)
        {
            if(posn[i]=='X' || posn[i]=='O')
            {
                if(i==9)
                {
                    char Draw='D';
                    System.out.println(" Keiner gewinnt ");
                    return Draw;
                }
                continue;
            }
            else
            break;
            
        }
        
        return Winner;
    }
    
    public  boolean checkPosn(int spot)
    {
        
        
        if (posn[spot] == 'X' || posn[spot] == 'O')
        {
            System.out.println("Die Zahl ist schon vorher gewählt worden");
            System.out.println("Bitte eine neue Zahl eingeben");
            return true;
        }
        else {
            return false;
        }
        
        
    }
    
    
    
    public  void nextSpieler()
    {
        if (Spieler == 'X')
        Spieler = 'O';
        else Spieler = 'X';
        
    }
    
    public  char getSpieler()
    {
        return Spieler;
    }
        
}
    

