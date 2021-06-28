package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;

	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
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
	
	private void initialSetup() {
		board.PlacePiece(new Rook(board, Color.White), new Position(2, 1));
	    board.PlacePiece(new King(board, Color.Black), new Position(0, 4));
	    board.PlacePiece(new King(board, Color.White), new Position(7, 4));
	}
}
