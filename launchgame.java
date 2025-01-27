package launchgame;
import java.util.Random;
import java.util.Scanner;

class TicTacToe{
	static char[][] board;
	public TicTacToe() {
		board=new char[3][3];
		initBoard();
	}

	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}

	static void dispBoard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
                 System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

    static void mark(int row,int column,char mark) {
    	if(row>=0 && row<=2 && column>=0 && column<=2){
    		board[row][column]=mark;
    	}
    	else {
    		System.out.println("Position is Inavlid!!!Enter Valid position...");
    	}
    }

    static boolean colwin() {
    	for(int j=0;j<=2;j++) {
    		if(board[0][j]  !=' ' &&           
    				board[0][j]==board[1][j] && board[1][j]==board[2][j] ){
               return true;
               }
    	}
    	return false;
    }

    static boolean rowwin() {
    	for(int i=0;i<=2;i++) {
    		if(board[i][0] != ' ' &&
    				board[i][0]==board[i][1] && board[i][1]==board[i][2] ){
               return true;
               }
    	}
    	return false;
    }
	
    static boolean diagwin() {
    	if(board[0][0] !=' ' &&
    			board[0][0]==board[1][1] && board[1][1]== board[2][2] ||
    					board[0][2] !=' ' &&
    			board[0][2]==board[1][1] && board[1][1]== board[2][0]) {
    		return true;
    	}
    return false;
}
}

class player{
	String name;
	char mark;
	void mMove() {
	}
	boolean isvalid(int row,int column) {
		if(row>=0 && row<=2 && column>=0 && column<=2) {
			if(TicTacToe.board[row][column]==' ') {
				return true;
			}
		}
			return false;
	}
}

class humplay extends player{
	humplay(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	void mMove() {
		Scanner scan=new Scanner(System.in);
		int row;
		int column;
		do {
			System.out.println("Enter row and Column:");
			row=scan.nextInt();
			column=scan.nextInt();
		}while(!isvalid(row,column));
		TicTacToe.mark(row, column, mark);
	}
}

class AIplay extends player{
	AIplay(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	void mMove() {
		Scanner scan=new Scanner(System.in);
		int row;
		int column ;
		do {
			Random r=new Random();
			row=r.nextInt(3);
			column=r.nextInt(3);
		}while(!isvalid(row,column));
		TicTacToe.mark(row, column, mark);
	}
}
public class launchgame {
public static void main(String[] args) {
	TicTacToe t=new TicTacToe();
    Scanner s=new Scanner(System.in);
	System.out.println("Welcome to TicTacToe Game...");
	System.out.println("Enter your choice: 1 or 2");
	System.out.println("1. Player 1(x) vs Player 2(o)");
	System.out.println("2. Player vs AI");
	String choice = s.nextLine().toLowerCase();

	humplay p1=new humplay("Player 1",'x');
	player cp,p2;
	if(choice.equals("1")){
         p2=new humplay("Player 2", 'O');
	}
	else if(choice.equals("2")){
		p2=new AIplay("AI", 'O');
	}
	else{
		System.out.println("Invalid choice!Default to Player vs AI ");
		p2=new AIplay("AI", 'O');
	}
	cp=p1;
	while(true) {
		System.out.println(cp.name+" Turn");
		cp.mMove();
		TicTacToe.dispBoard();
		if(TicTacToe.colwin() || TicTacToe.rowwin() || TicTacToe.diagwin()) {
			System.out.println(cp.name+" won this game!!");
			break;
		}else{
		
			if (cp == p1) {
				cp = p2;  
			} 
			else {
				cp = p1; 
			}
	}}	
}
}

