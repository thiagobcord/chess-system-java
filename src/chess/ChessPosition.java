package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// converte a ChessPosition para o Position normal (em vez de passar a posicao como numero da matriz(0,1),(2,3), colocamos a letra com o numero, igual no tabuleiro por ex: a1,b2
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	// aqui faz o inverso do metodo de cima
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	public String toString() {
		return "" + column + row;
 	}
}
