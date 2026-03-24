public class OOPS4 {
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves();
    }

    interface Chessplayer{    // Interface for chess players
        void moves();
    }

    static class Queen implements Chessplayer{
        public void moves(){
            System.out.println("Queen can move in any direction");
        }
    }

    class Rook implements Chessplayer{
        public void moves(){
            System.out.println("Rook can move in straight lines");
        }
    }
}
