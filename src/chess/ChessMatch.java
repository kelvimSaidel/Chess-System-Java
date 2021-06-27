package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;

	public ChessMatch() {
		board = new Board(8,8);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			for (int y=0; y<board.getColumns();y++) {
				mat[i][y] = (ChessPiece) board.piece(i, y);
		    }
		
	    }
		
		return mat;
		
	}	

}
