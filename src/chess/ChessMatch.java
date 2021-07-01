package chess;

import boardgame.Board;
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.White));
        placeNewPiece('c', 2, new Rook(board, Color.White));
        placeNewPiece('d', 2, new Rook(board, Color.White));
        placeNewPiece('e', 2, new Rook(board, Color.White));
        placeNewPiece('e', 1, new Rook(board, Color.White));
        placeNewPiece('d', 1, new King(board, Color.White));

        placeNewPiece('c', 7, new Rook(board, Color.Black));
        placeNewPiece('c', 8, new Rook(board, Color.Black));
        placeNewPiece('d', 7, new Rook(board, Color.Black));
        placeNewPiece('e', 7, new Rook(board, Color.Black));
        placeNewPiece('e', 8, new Rook(board, Color.Black));
        placeNewPiece('d', 8, new King(board, Color.Black));
	}
}
