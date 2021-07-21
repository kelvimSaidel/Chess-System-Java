package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	private int turn;
	private Color currentPlayer;

	public ChessMatch() {
		board = new Board(8,8);
		turn = 1;
		currentPlayer = Color.White;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source); 
		validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece)capturedPiece; 
	}
	
	
	private void validateSourcePosition(Position position) {
	    	if (!board.thereIsAPiece(position)) {
	    		throw new ChessException("There is no piece on soucer position"); 
	    	}
	    	
	    	if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
				throw new ChessException("The chosen piece is not yours");
			}
	    	
	    	if (!board.piece(position).isThereAnyPossibleMove()) {
				throw new ChessException("There is no possible moves for the chosen piece");
			} 
	    }
	
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
	    Piece capturedPiece = board.removePiece(target);
	    board.PlacePiece(p, target);
	    return capturedPiece;
	} 
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.White) ? Color.Black : Color.White;
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
