package connect4;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 8;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private  static int row;
    private  static int column;     
    private static boolean player1;
    private static boolean player2;
        private static boolean done1;
           private static boolean done2;
        public static boolean player1(){
        if (player1)
            return true;
        return false;
        }
        public static boolean player2(){
        if (player2)
            return true;
        return false;
        }
       
          public static void Animate(){
               done1 = false;
           board[row][column] = null;
            int half = (NUM_ROWS/2)-1;
            int quarter = half+2;
             if(row < NUM_ROWS-1 && (board[row+1][column] == null) && (row !=half && row !=quarter) ){
                     row++;
              board[row][column] = new Piece(Color.BLACK);
              done1 = true;
             }
           //  faster drop
             board[row][column] = null;
             if((row == half || row == quarter)&& (board[row+2][column] == null)){
                     row++;
              board[row][column] = new Piece(Color.BLACK);
                board[row][column] = null;
                  row++;
              board[row][column] = new Piece(Color.BLACK);
             }
             board[row][column] = new Piece(Color.BLACK);
          }
          public static void Animate2(){
               done2 = true;
           board[row][column] = null;
           int half = (NUM_ROWS/2)-1;
            int quarter = half+2;
             if(row < NUM_ROWS-1 && (board[row+1][column] == null)  && (row !=half && row !=quarter)){
                     row++;
              board[row][column] = new Piece(Color.RED);
                done2 = false;
             }
          //   faster drop
                  board[row][column] = null;
                    if((row == half || row == quarter)&& (board[row+2][column] == null)){
                     row++;
              board[row][column] = new Piece(Color.BLACK);
               board[row][column] = null;
                row++;
              board[row][column] = new Piece(Color.BLACK);

             }
             board[row][column] = new Piece(Color.RED);
              
          }
public static void AddPiece(int xPixel, int yPixel){
 if(!done2 || done1)
        return;
    column = xPixel / 75;
    row = yPixel / 67;
    if (player1 == true && board[row][column] == null) {
             board[row][column] = new Piece(Color.BLACK);
    
    player1 = false;
    player2 = true;
             
    
    }
     if (player2 == true && board[row][column] == null ){
    board[row][column] = new Piece(Color.RED);
      player2 = false;
       player1 = true;
     }
    
}
    public static void Reset() {
//clear the board.
  player1 = true;
         done1 = false;
         done2 = true;
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;     
      
    }

    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS; //height of sqaure
        int xdelta = Window.getWidth2()/NUM_COLUMNS; // width of sqaure
 
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
            }
        }        
        
    }
}