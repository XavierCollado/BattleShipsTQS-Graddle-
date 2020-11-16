package BattleShip_WithCoverage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BattleShip_WithCoverage.Cell;
import BattleShip_WithCoverage.CellConstants;

import BattleShip_WithCoverage.PlayerHUM;

/**
 *
 * @author desirée
 * @version 1.4
 *
 */
class PlayerTestHUM {
  @Test
  void TestCheckWinPositivePlayer2(){
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int boatsCount = 5;

    //When
    boolean winner =  playerHUM.checkWinCondition();
    //Then
    assertEquals(true,winner);
  }

  @Test
  void TestCheckWinNegativePlayer2(){
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int boatsCount = 2;

    //When
    boolean winner = playerHUM.checkWinCondition();
    //Then
    assertEquals(false,winner);
  }

  @Test
  void TestCheckWinNegativePlayer2BiggerValue(){
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int boatsCount = 2;

    //When
    boolean winner = playerHUM.checkWinCondition();
    //Then
    assertEquals(false,winner);
  }
  @Test
  void updateBoardCell_ChangeCorrectlyTheCellPlayer2() {
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int posX = 4;
    int posY = 5;
    Cell newCell = new Cell(4, 5, CellConstants.BATTLESHIP_TYPE);

    //When
    playerHUM.updateBoardCell(posX, posY, newCell);

    //Then
    assertEquals(newCell, playerHUM.getBoard().getCell(posX, posY));
  }

  @Test
  void updateBoardCell_ChangeCorrectlyTheCellAndDontHitTheNewCellPlayer2() {
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int posX = 4;
    int posY = 5;
    Cell newCell = new Cell(4, 5, CellConstants.BATTLESHIP_TYPE);

    //When
    playerHUM.updateBoardCell(posX, posY, newCell);

    //Then
    assertEquals(false, playerHUM.isCellHit(posX, posY));
  }
  @Test
  void TestUpdateBoardCelliHitAtFirstPlayer2() {
    //Given
    PlayerHUM playerHUM = new PlayerHUM();

    int posX = 4;
    int posY = 5;

    //When
    playerHUM.getBoard().getCell(posX, posY).hit();
    playerHUM.updateBoardCell(posX, posY, playerHUM.getBoard().getCell(posX, posY));
    //Then
    assertEquals(true,playerHUM.getBoard().getCell(posX, posY).ishit());
  }
  
  @Test
  void TestPlayTurnNotHitPlayer2() {
    //Given

    int posX = 3;
    int posY = 5;

    PlayerHUM playerHUM = new PlayerHUM();
    //When
    playerHUM.playTurn(posX, posY);
    //Then
    assertEquals(true,playerHUM.getEnemyBoard().getCell(posX,posY).ishit());
  }

  @Test
  void TestPlayTurnHitPlayer2() {
    //Given
    PlayerHUM playerHUM = new PlayerHUM();
    int posX = 3;
    int posY = 4;

    //When
    playerHUM.getBoard().getCell(posX, posY).hit();
    playerHUM.playTurn(posX, posY);

    //Then
    assertEquals(true,playerHUM.getEnemyBoard().getCell(posX,posY).ishit());
  }
}