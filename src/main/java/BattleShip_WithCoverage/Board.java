package BattleShip_WithCoverage;

/**
 * @autor desirée & xavier
 * @version 1.2
 */
public class Board{
  private Cell cells[][];
  
  public Board() {
    this.cells = new Cell[10][10];
    this.initializeEmptyBoard();
  }

  private void initializeEmptyBoard() {
	  for(int i = 0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  this.cells[i][j] = new Cell(i,j,CellConstants.WATER_TYPE);
		  }
	  }
  }
  
  public Cell getCell(int posX,int posY) {
    return cells[posX][posY];
  }
  
  public void updateCell(int posX,int posY, Cell c) {
	cells[posX][posY] = c;
  }
}