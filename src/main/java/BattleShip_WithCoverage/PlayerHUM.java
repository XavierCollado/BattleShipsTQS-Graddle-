package BattleShip_WithCoverage;

import java.util.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.lang.String;

/**
 * @author desirée & xavier
 * @version 1.3
 */

public class PlayerHUM implements Player{
  private Board board, enemyBoard;
  private int boatsCount;
  private boolean aliveCarrier;
  private boolean aliveBattleship;
  private boolean aliveCruiser;
  private boolean aliveSubmarine;
  private boolean aliveDestroyer;
  private boolean isWin;
  
  public PlayerHUM(){
    this.board = new Board();
    this.enemyBoard = new Board();
    this.boatsCount = 0;
    this.aliveCarrier = true;
    this.aliveBattleship = true;
    this.aliveCruiser = true;
    this.aliveSubmarine = true;
    this.aliveDestroyer = true;
  }
  public Board getBoard() {
    return board;
  }
  
  public Board getEnemyBoard() {
	  return this.enemyBoard;
  }
  
  public void playTurn(int posX,int posY) {
	  enemyBoard.getCell(posX,posY).hit();
  }
  
  public void updateBoardCell(int posX,int posY,Cell cell) {
    board.updateCell(posX, posY, cell);
  }
  
  public boolean checkWinCondition() {
	    
	    return (!isEnemyCarrierAlive() && !isEnemyBattleshipAlive() && !isEnemyCruiserAlive() && !isEnemySubmarineAlive() && !isEnemyDestroyerAlive());
	  }

	  public boolean isEnemyCarrierAlive(){
			boolean isAlive = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(!(this.getEnemyBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.CARRIER_TYPE)) {
						isAlive = true;
					}
				}
			}
		    return isAlive;
	  }
	  public boolean isEnemyBattleshipAlive(){
		  boolean isAlive = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(!(this.getEnemyBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.BATTLESHIP_TYPE)) {
						isAlive = true;
					}
				}
			}
		    return isAlive;
	  }
	  public boolean isEnemyCruiserAlive(){
		  boolean isAlive = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(!(this.getEnemyBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.CRUISER_TYPE)) {
						isAlive = true;
					}
				}
			}
		    return isAlive;
	  }
	  public boolean isEnemySubmarineAlive(){
		  boolean isAlive = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(!(this.getEnemyBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.SUBMARINE_TYPE)) {
						isAlive = true;
					}
				}
			}
		    return isAlive;
	  }
	  public boolean isEnemyDestroyerAlive(){
		  boolean isAlive = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					if(!(this.getEnemyBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.DESTROYER_TYPE)) {
						isAlive = true;
					}
				}
			}
		    return isAlive;
	  }
  public boolean isCarrierAlive(){
		boolean isAlive = false;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!(this.getBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.CARRIER_TYPE)) {
					isAlive = true;
				}
			}
		}
	    return isAlive;
  }
  public boolean isBattleshipAlive(){
	  boolean isAlive = false;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!(this.getBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.BATTLESHIP_TYPE)) {
					isAlive = true;
				}
			}
		}
	    return isAlive;
  }
  public boolean isCruiserAlive(){
	  boolean isAlive = false;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!(this.getBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.CRUISER_TYPE)) {
					isAlive = true;
				}
			}
		}
	    return isAlive;
  }
  public boolean isSubmarineAlive(){
	  boolean isAlive = false;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!(this.getBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.SUBMARINE_TYPE)) {
					isAlive = true;
				}
			}
		}
	    return isAlive;
  }
  public boolean isDestroyerAlive(){
	  boolean isAlive = false;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!(this.getBoard().getCell(i, j).ishit()) && (this.getCellType(i, j)==CellConstants.DESTROYER_TYPE)) {
					isAlive = true;
				}
			}
		}
	    return isAlive;
  }

  public String getCellType(int posX, int posY) {
	return board.getCell(posX, posY).getType();
  }
  
  public boolean isCellHit(int posX, int posY) {
	  return board.getCell(posX, posY).ishit();
  }
  
  public void setEnemyBoard(Board newEnemyBoard) {
	  this.enemyBoard = newEnemyBoard;
  }
}