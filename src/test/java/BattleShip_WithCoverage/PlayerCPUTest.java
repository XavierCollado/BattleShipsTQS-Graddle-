package BattleShip_WithCoverage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import BattleShip_WithCoverage.PlayerCPU;
import BattleShip_WithCoverage.Board;
import BattleShip_WithCoverage.Cell;
import BattleShip_WithCoverage.CellConstants;
/**
 *
 * @author desirée & xavier
 * @version 1.6
 *
 */
class PlayerTestCPU {

  @Test
  void TestPlayTurnNotHit() {
    //Given

    int posX = 3;
    int posY = 5;

    PlayerCPU playerCPU = new PlayerCPU();
    //When
    playerCPU.playTurn(posX, posY);
    //Then
    assertEquals(true,playerCPU.getEnemyBoard().getCell(posX,posY).ishit());
  }

  @Test
  void TestPlayTurnHit() {
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int posX = 3;
    int posY = 4;

    //When
    playerCPU.playTurn(posX, posY);

    //Then
    assertEquals(true,playerCPU.getEnemyBoard().getCell(posX,posY).ishit());
  }
  
  @Test
  void updateBoardCell_ChangeCorrectlyTheCell() {
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int posX = 4;
    int posY = 5;
    Cell newCell = new Cell(4, 5, CellConstants.BATTLESHIP_TYPE);

    //When
    playerCPU.updateBoardCell(posX, posY, newCell);

    //Then
    assertEquals(newCell, playerCPU.getBoard().getCell(posX, posY));
  }
  
  @Test
  void updateBoardCell_ChangeCorrectlyTheCellAndDontHitTheNewCell() {
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int posX = 4;
    int posY = 5;
    Cell newCell = new Cell(4, 5, CellConstants.BATTLESHIP_TYPE);

    //When
    playerCPU.updateBoardCell(posX, posY, newCell);

    //Then
    assertEquals(false, playerCPU.isCellHit(posX, posY));
  }
  
  @Test
  void TestUpdateBoardCelliHitAtFirst() {
    //Given
    PlayerCPU playerCPU = new PlayerCPU();

    int posX = 4;
    int posY = 5;

    //When
    playerCPU.getBoard().getCell(posX, posY).hit();
    playerCPU.updateBoardCell(posX, posY, playerCPU.getBoard().getCell(posX, posY));
    //Then
    assertEquals(true,playerCPU.getBoard().getCell(posX, posY).ishit());
  }
  @Test
  void TestCheckWinPositive(){
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int boatsCount = 5;

    //When
    boolean winner =  playerCPU.checkWinCondition();
    //Then
    assertEquals(true,winner);
  }

  @Test
  void TestCheckWinNegative(){
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int boatsCount = 2;

    //When
    boolean winner = playerCPU.checkWinCondition();
    //Then
    assertEquals(false,winner);
  }
  @Test
  void TestCheckWinNegativeBiggerValue(){
    //Given
    PlayerCPU playerCPU = new PlayerCPU();
    int boatsCount = 7;

    //When
    boolean winner = playerCPU.checkWinCondition();
    //Then
    assertEquals(false,winner);
  }
  
  @Test
  void initializeBoard_CreatesCarrier() {
	  //Given
	  PlayerCPU player = new PlayerCPU();
	  int expectedCarrierTypeCells = 5, count=0;
	  
	  //When
	  player.initializeCPUBoard();
	  for(int i=0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  if(player.getCellType(i, j) == CellConstants.CARRIER_TYPE) {
				  count++;
			  }
		  }
	  }
	  
	  //Then
	  assertEquals(expectedCarrierTypeCells, count);
	  
  }
  
  @Test
  void initializeBoard_CreatesBattleship() {
	  //Given
	  PlayerCPU player = new PlayerCPU();
	  int expectedBattleshipTypeCells = 4, count=0;
	  
	  //When
	  player.initializeCPUBoard();
	  for(int i=0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  if(player.getCellType(i, j) == CellConstants.BATTLESHIP_TYPE) {
				  count++;
			  }
		  }
	  }
	  
	  //Then
	  assertEquals(expectedBattleshipTypeCells, count);
  }
  
  @Test
  void initializeBoard_CreatesCruiser() {
	  //Given
	  PlayerCPU player = new PlayerCPU();
	  int expectedCruiserTypeCells = 3, count=0;
	  
	  //When
	  player.initializeCPUBoard();
	  for(int i=0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  if(player.getCellType(i, j) == CellConstants.CRUISER_TYPE) {
				  count++;
			  }
		  }
	  }
	  
	  //Then
	  assertEquals(expectedCruiserTypeCells, count);
  }
  
  @Test
  void initializeBoard_CreatesSubmarine() {
	  //Given
	  PlayerCPU player = new PlayerCPU();
	  int expectedSubmarineTypeCells = 2, count=0;
	  
	  //When
	  player.initializeCPUBoard();
	  for(int i=0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  if(player.getCellType(i, j) == CellConstants.SUBMARINE_TYPE) {
				  count++;
			  }
		  }
	  }
	  
	  //Then
	  assertEquals(expectedSubmarineTypeCells, count);
  }
  
  @Test
  void initializeBoard_CreatesDestroyer() {
	  //Given
	  PlayerCPU player = new PlayerCPU();
	  int expectedDestroyerTypeCells = 2, count=0;
	  
	  //When
	  player.initializeCPUBoard();
	  for(int i=0; i<10; i++) {
		  for(int j=0; j<10; j++) {
			  if(player.getCellType(i, j) == CellConstants.DESTROYER_TYPE) {
				  count++;
			  }
		  }
	  }
	  
	  //Then
	  assertEquals(expectedDestroyerTypeCells, count);
  }

}