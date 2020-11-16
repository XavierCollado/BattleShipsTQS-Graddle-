package BattleShip_WithCoverage;



import java.util.Scanner;

import BattleShip_WithCoverage.CellConstants;

/**
 * 
 * @author xavier
 * @version 6.0
 *
 */
public class Game {

	public PlayerHUM player1;
	public PlayerCPU player2;
	private boolean playerHUMTurn;
	private int screen;
	private boolean isPlaying;
	private String screenMessageTop;
	private String screenMessageDown;
	private Scanner inpuntScanner;
	private int boatInsertId;
	
	public Game() {
		this.player1 = new PlayerHUM();
		this.player2 = new PlayerCPU();
		this.playerHUMTurn = true;
		this.screen = 0;
		this.isPlaying = true;
		this.screenMessageTop = "║ Select a valid option                              ║\n";
		this.screenMessageDown = "║                                                    ║\n";
		this.inpuntScanner = new Scanner(System.in);
		this.boatInsertId = 0;
	}
	
	public int getScreen() {
		return this.screen;
	}
	
	public void printScreen(int screenId) {
		switch(screenId) {
			case 0:
				this.printMenuScreen();
				break;				
			case 1:
				this.printSelectionScreen();
				break;
			case 2:
				this.printBoardScreen();
				break;
			default:
		}
	}

	public String readInput() {
		String input ="";
		if(!((this.screen == 2) && (!this.playerHUMTurn))) {
			input = inpuntScanner.nextLine();
		}
		return input;
	}
	
	public void applyAction(String input) {
		String response = input;
		
		//Last Screen Winner
		if(this.screen == 3) {
			winnerScreenACtion();
		}	
		
		//Actions for BoardScreen
		if(this.screen == 2) {
			boardScreenAction(response);
		}		
		
		//Actions for SelectionScreen
		if(this.screen == 1) {
			selectionScreenAction(response);
		}
		
		// Actions for MenuScreen
		if(this.screen == 0) {
			menuScreenAction(response);
		}
	}
	
	public boolean isPlaying() {
		return this.isPlaying;
	}
	
	public int getBoatInsertId() {
		return boatInsertId;
	}
	
	private void endGame() {
		this.isPlaying = false;
	}
	
	private void printMenuScreen() {
		System.out.println("╔════════════════════════════════════════════════════╗\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                   BATTLESHIPS                      ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "╠════════════════════════════════════════════════════╣\n"
				+ "║                                                    ║\n"
				+ "║  1) Single Player                                  ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║                                                    ║\n"
				+ "║  2) Exit Game                                      ║\n"
				+ "║                                                    ║\n"
				+ "╠════════════════════════════════════════════════════╣\n"
				+ this.screenMessageTop
				+ this.screenMessageDown
				+ "╚════════════════════════════════════════════════════╝\n"
				+ "");
	}
	
	private void printSelectionScreen() {
		System.out.println("╔════════════════════════════════════════════════════╗\n"
				+ "║ <RULES>                                            ║\n"
				+ "║                                                    ║\n"
				+ "║ · Now you need to setUp your boats starting with   ║\n"
				+ "║   the Carrier until the Destroyer                  ║\n"
				+ "║ · This selection will be done by 3 inputs:         ║\n"
				+ "║   [posX] [posY] [horientation]                     ║\n"
				+ "║ · The boat will be set from left to wright (H) or  ║\n"
				+ "║   from up to down (V)                              ║\n"
				+ "║ · A boat cannot touch another boat                 ║\n"
				+ "║                                                    ║\n"
				+ "║   Valid input example: 2 3 H   or   4 3 V          ║\n"
				+ "╠═══════════════════════════════════╦════════════════╣\n"
				+ "║     1  2  3  4  5  6  7  8  9  10 ║                ║\n"
				+ "║ 1  "+getSelectionRow(0)+" ║                ║\n"
				+ "║ 2  "+getSelectionRow(1)+" ║                ║\n"
				+ "║ 3  "+getSelectionRow(2)+" ║ Carrier (5)    ║\n"
				+ "║ 4  "+getSelectionRow(3)+" ║ Battleship (4) ║\n"
				+ "║ 5  "+getSelectionRow(4)+" ║ Cruiser (3)    ║\n"
				+ "║ 6  "+getSelectionRow(5)+" ║ Submarine (2)  ║\n"
				+ "║ 7  "+getSelectionRow(6)+" ║ Destroyer (2)  ║\n"
				+ "║ 8  "+getSelectionRow(7)+" ║                ║\n"
				+ "║ 9  "+getSelectionRow(8)+" ║                ║\n"
				+ "║ 10 "+getSelectionRow(9)+" ║                ║\n"
				+ "╠═══════════════════════════════════╩════════════════╣\n"
				+ this.screenMessageTop
				+ this.screenMessageDown
				+ "╚════════════════════════════════════════════════════╝");
		
	}
	
	private void printBoardScreen() {
		System.out.println("╔═══════════════════════════════════╦════════════════╗\n"
				+ "║     1  2  3  4  5  6  7  8  9  10 ║                ║\n"
				+ "║ 1  "+getBoardPlayerCPURow(0)+" ║ ENEMY BOARD    ║\n"
				+ "║ 2  "+getBoardPlayerCPURow(1)+" ║                ║\n"
				+ "║ 3  "+getBoardPlayerCPURow(2)+" ║ Carrier ("+getBoatsStatusInfo_Carrier(2)+")    ║\n"
				+ "║ 4  "+getBoardPlayerCPURow(3)+" ║ Battleship ("+getBoatsStatusInfo_Battleship(2)+") ║\n"
				+ "║ 5  "+getBoardPlayerCPURow(4)+" ║ Cruiser ("+getBoatsStatusInfo_Cruiser(2)+")    ║\n"
				+ "║ 6  "+getBoardPlayerCPURow(5)+" ║ Submarine ("+getBoatsStatusInfo_Submarine(2)+")  ║\n"
				+ "║ 7  "+getBoardPlayerCPURow(6)+" ║ Destroyer ("+getBoatsStatusInfo_Destroyer(2)+")  ║\n"
				+ "║ 8  "+getBoardPlayerCPURow(7)+" ║                ║\n"
				+ "║ 9  "+getBoardPlayerCPURow(8)+" ║                ║\n"
				+ "║ 10 "+getBoardPlayerCPURow(9)+" ║                ║\n"
				+ "╠═══════════════════════════════════╬════════════════╣\n"
				+ "║     1  2  3  4  5  6  7  8  9  10 ║                ║\n"
				+ "║ 1  "+getBoardPlayerHUMRow(0)+" ║ PLAYER BOARD   ║\n"
				+ "║ 2  "+getBoardPlayerHUMRow(1)+" ║                ║\n"
				+ "║ 3  "+getBoardPlayerHUMRow(2)+" ║ Carrier ("+getBoatsStatusInfo_Carrier(1)+")    ║\n"
				+ "║ 4  "+getBoardPlayerHUMRow(3)+" ║ Battleship ("+getBoatsStatusInfo_Battleship(1)+") ║\n"
				+ "║ 5  "+getBoardPlayerHUMRow(4)+" ║ Cruiser ("+getBoatsStatusInfo_Cruiser(1)+")    ║\n"
				+ "║ 6  "+getBoardPlayerHUMRow(5)+" ║ Submarine ("+getBoatsStatusInfo_Submarine(1)+")  ║\n"
				+ "║ 7  "+getBoardPlayerHUMRow(6)+" ║ Destroyer ("+getBoatsStatusInfo_Destroyer(1)+")  ║\n"
				+ "║ 8  "+getBoardPlayerHUMRow(7)+" ║                ║\n"
				+ "║ 9  "+getBoardPlayerHUMRow(8)+" ║                ║\n"
				+ "║ 10 "+getBoardPlayerHUMRow(9)+" ║                ║\n"
				+ "╠═══════════════════════════════════╩════════════════╣\n"
				+ "║ Enter a valid option                               ║\n"
				+ "║                                                    ║\n"
				+ "╚════════════════════════════════════════════════════╝");
	}
	
	private void setMenuScreen() {
		this.screen = 0;
	}
	
	private void setSelectionScreen() {
		this.screen = 1;
	}
	
	private void setBoardScreen() {
		this.screen = 2;
	}
	
	private void setWinnersScreen() {
		this.screen = 3;
	}
	
	private String getSelectionRow(int matrixPosY) {
		char cellChar;
		String cellRow = "";
		for(int i = 0; i<10; i++) {
			if(player1.getCellType(i, matrixPosY) == CellConstants.WATER_TYPE) {
				cellChar = CellConstants.WATER_CHAR;
			} else {
				cellChar = CellConstants.BOAT_CHAR;
			}
			cellRow = cellRow + "["+cellChar+"]";
		}
		return cellRow;
	}
	
	private String getBoardPlayerCPURow(int matrixPosY) {
		char cellChar;
		String cellRow = "";
		for(int i = 0; i<10; i++) {
			cellChar='_';
			if((player2.getCellType(i, matrixPosY) == CellConstants.WATER_TYPE) && (player2.isCellHit(i, matrixPosY))) {
				cellChar = CellConstants.WATER_CHAR;
			} else if((player2.getCellType(i, matrixPosY) != CellConstants.WATER_TYPE) && (player2.isCellHit(i, matrixPosY))){
				cellChar = CellConstants.BOAT_CHAR;
			}
			
			cellRow = cellRow + "["+cellChar+"]";
		}
		return cellRow;
	}
	
	private String getBoardPlayerHUMRow(int matrixPosY) {
		char cellChar;
		String cellRow = "";
		for(int i = 0; i<10; i++) {
			cellChar='_';
			if((player1.getCellType(i, matrixPosY) == CellConstants.WATER_TYPE) && (player1.isCellHit(i, matrixPosY))) {
				cellChar = CellConstants.WATER_CHAR;
			} else if((player1.getCellType(i, matrixPosY) != CellConstants.WATER_TYPE) && !(player1.isCellHit(i, matrixPosY))) {
				cellChar = CellConstants.BOAT_CHAR;
			} else if((player1.getCellType(i, matrixPosY) != CellConstants.WATER_TYPE) && (player1.isCellHit(i, matrixPosY))){
				cellChar = CellConstants.HIT_CHAR;
			}
			
			cellRow = cellRow + "["+cellChar+"]";
		}
		return cellRow;
	}
	
	private void menuScreenAction(String input) {
		if(input.equals("1")) {
			setSelectionScreen();
			this.screenMessageTop = "║ Select a valid option                              ║\n";
			this.screenMessageDown = "║                                                    ║\n";
		} else if (input.equals("2")) {
			this.screenMessageTop = "║ BYE BYE :)                                         ║\n";
			this.screenMessageDown = "║                                                    ║\n";
			endGame();
		}
		else {
			this.screenMessageTop = "║ Please add a valid option (just the number)        ║\n";
			this.screenMessageDown = "║                                                    ║\n";
		}
	}
	
	private void selectionScreenAction(String input) {
		selectedShipInfo(this.boatInsertId);
		String[] params = input.split(" ", 3);
		int tempPosX, tempPosY, validatePosX = 0, validatePosY = 0;
		char validateOrientation = '-', firstCharPos;
		
		//Validate posX
		firstCharPos = params[0].charAt(0);
		
		//params[0] = removeAllNonNumericCharacters(params[0]);
		tempPosX = Integer.parseInt(params[0]);
		if((tempPosX > 10) || (firstCharPos=='-')) {
			this.screenMessageDown = "║ INVALID POS_X: Please enter a number from 1 to 10  ║\n";
		} else {
			validatePosX = tempPosX;
		}
		//Validate posY
		if(params.length>1) {
			firstCharPos = params[0].charAt(0);
			//params[1] = removeAllNonNumericCharacters(params[1]);
			tempPosY = Integer.parseInt(params[1]);
			if((tempPosY > 10) || (firstCharPos == '-')) {
				this.screenMessageDown = "║ INVALID POS_Y: Please enter a number from 1 to 10  ║\n";
			} else {
				validatePosY = tempPosY;
			}
		}
		//Validate orientation
		if(params.length>2) {
			if(params[2].charAt(0)=='H') {
				validateOrientation = params[2].charAt(0);
			} else if(params[2].charAt(0)=='V') {
				validateOrientation = params[2].charAt(0);	
			} else {
				this.screenMessageDown = "║ INVALID ORIENTATION: Please enter H or V           ║\n";
			}			
		}
		
		//We try to insert he ship with the validate input
		insertShipSelectionScreen(validatePosX, validatePosY, validateOrientation, this.boatInsertId);
		if(this.screen == 1) {
			selectedShipInfo(this.boatInsertId);
		} 
	}
	
	private void boardScreenAction(String input) {
		String[] params = input.split(" ", 2);
		int posX=0, posY=0;
		boolean validShoot=false;
		
		if(this.playerHUMTurn) {
			posX = Integer.parseInt(params[0])-1;
			posY = Integer.parseInt(params[1])-1;
			if(!player2.getEnemyBoard().getCell(posX, posY).ishit()) {
				player1.playTurn(posX, posY);
				if(player1.checkWinCondition()){
					setWinnersScreen();
				}
				this.playerHUMTurn = false;
			}
		} else {
			while(!validShoot) {
				posX = player2.randomX("");
				posY = player2.randomY();
				if(!player2.getEnemyBoard().getCell(posX, posY).ishit()){
					validShoot = true;
				}
			}
			player2.playTurn(posX, posY);
			if(player2.checkWinCondition()){
				setWinnersScreen();
			}
			this.playerHUMTurn = true;
		}
	}
	
	private void winnerScreenACtion() {
		String winner = "";
		if(player1.checkWinCondition()) {
			winner =  "║                     YOU WIN!                       ║\n";
		}
		if(player2.checkWinCondition()) {
			winner =  "║                    YOU LOSE!                       ║\n";
		}
		
		System.out.println("╔════════════════════════════════════════════════════╗\n"
				+ "║                                                    ║\n"
				+ winner
				+ "║                                                    ║\n"
				+ "╚════════════════════════════════════════════════════╝");
		this.endGame();
	}
	
	private void insertShipSelectionScreen(int boardPosX, int boardPosY, char orientation, int boatCountId) {
		int shipLenght;
		int matrixPosX = boardPosX-1, matrixPosY = boardPosY-1;
		switch(boatCountId) {
			// Carrier
			case 0:
				shipLenght = 5;
				if((orientation == 'H') && (boardPosX <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(i+matrixPosX, matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.CARRIER_TYPE));
							this.boatInsertId = 1;
						}
					}
				} else if((orientation == 'V') && (boardPosY <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(matrixPosX, i+matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.CARRIER_TYPE));
							this.boatInsertId = 1;
						}
					}
				}
				break;
			//Battleship
			case 1:
				shipLenght = 4;
				if((orientation == 'H') && (boardPosX <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(i+matrixPosX, matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.BATTLESHIP_TYPE));
							this.boatInsertId = 2;
						}
					}
				} else if((orientation == 'V') && (boardPosY <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(matrixPosX, i+matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.BATTLESHIP_TYPE));
							this.boatInsertId = 2;
						}
					}
				}
				break;
			//Cruiser
			case 2:
				shipLenght = 3;
				if((orientation == 'H') && (boardPosX <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(i+matrixPosX, matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.CRUISER_TYPE));
							this.boatInsertId = 3;
						}
					}
				} else if((orientation == 'V') && (boardPosY <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(matrixPosX, i+matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.CRUISER_TYPE));
							this.boatInsertId = 3;
						}
					}
				}
				break;
			//Submarine
			case 3:
				shipLenght = 2;
				if((orientation == 'H') && (boardPosX <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(i+matrixPosX, matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.SUBMARINE_TYPE));
							this.boatInsertId = 4;
						}
					}
				} else if((orientation == 'V') && (boardPosY <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(matrixPosX, i+matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.SUBMARINE_TYPE));
							this.boatInsertId = 4;
						}
					}
				}
				break;
			//Destroyer
			case 4:
				shipLenght = 2;
				if((orientation == 'H') && (boardPosX <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(i+matrixPosX, matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.DESTROYER_TYPE));
							this.boatInsertId = 5;
						}
						setBoardScreen();
						while(player2.getBoatsSelectionId() < 5) {
							player2.initializeCPUBoard();
						}
						player2.setEnemyBoard(player1.getBoard());
						player1.setEnemyBoard(player2.getBoard());
					}
				} else if((orientation == 'V') && (boardPosY <= (10 - shipLenght))) {
					if(isAValidPosition(matrixPosX, matrixPosY, orientation, shipLenght)) {
						for(int i=0; i<shipLenght; i++) {
							player1.updateBoardCell(matrixPosX, i+matrixPosY, new Cell(matrixPosX, matrixPosY, CellConstants.DESTROYER_TYPE));
							this.boatInsertId = 5;
							setBoardScreen();
							player2.initializeCPUBoard();
							player2.setEnemyBoard(player1.getBoard());
							player1.setEnemyBoard(player2.getBoard());
						}
					}
				}
				break;
			// All ships setup
			case 5:
				
				break;
			default:
				break;
		}
	}
	
	private boolean isAValidPosition(int matrixPosX, int matrixPosY, char orientation, int lenght) {
		boolean valid = true;
		if(orientation == 'H') {
			for(int tempMatrixPosX=matrixPosX-1; tempMatrixPosX<lenght+2; tempMatrixPosX++) {
				for(int tempMatrixPosY=matrixPosY-1; tempMatrixPosY<matrixPosY+2; tempMatrixPosY++) {
					if((tempMatrixPosX < 10) && (tempMatrixPosY < 10) && (tempMatrixPosX >= 0) && (tempMatrixPosY >= 0)) {
						if(player1.getCellType(tempMatrixPosX, tempMatrixPosY) != CellConstants.WATER_TYPE) {
							valid = false;
						}
					}
				}
			}
		} else if(orientation == 'V') {
			for(int tempMatrixPosX=matrixPosX-1; tempMatrixPosX<matrixPosX+2; tempMatrixPosX++) {
				for(int tempMatrixPosY=matrixPosY-1; tempMatrixPosY<lenght+2; tempMatrixPosY++) {
					if((tempMatrixPosX < 10) && (tempMatrixPosY < 10) && (tempMatrixPosX >= 0) && (tempMatrixPosY >= 0)) {
						if(player1.getCellType(tempMatrixPosX, tempMatrixPosY) != CellConstants.WATER_TYPE) {
							valid = false;
						}
					}
				}
			}
		}
		return valid;
	}
	
	private void selectedShipInfo(int boatCountId) {
		switch(boatCountId) {
			case 0:
				this.screenMessageTop = "║ Select Carrier position                            ║\n";
				break;
			case 1:
				this.screenMessageTop = "║ Select Battleship position                         ║\n";
				break;
			case 2:
				this.screenMessageTop = "║ Select Cruiser position                            ║\n";
				break;
			case 3:
				this.screenMessageTop = "║ Select Submarine position                          ║\n";
				break;
			case 4:
				this.screenMessageTop = "║ Select Destroyer position                          ║\n";
				break;
			default:
				break;
		}
	}
	
	private char getBoatsStatusInfo_Carrier(int player) {
		char boatState = 'X';
		if(player == 1) {
			if(player1.isCarrierAlive()) {
				boatState = '5';
			} 
		} else {
			if(player2.isCarrierAlive()) {
				boatState = '5';
			}
		}
		return boatState;
	}
	
	private char getBoatsStatusInfo_Battleship(int player) {
		char boatState = 'X';
		if(player == 1) {
			if(player1.isBattleshipAlive()) {
				boatState = '4';
			} 
		} else {
			if(player2.isBattleshipAlive()) {
				boatState = '4';
			}
		}
		return boatState;
	}
	
	private char getBoatsStatusInfo_Cruiser(int player) {
		char boatState = 'X';
		if(player == 1) {
			if(player1.isCruiserAlive()) {
				boatState = '3';
			} 
		} else {
			if(player2.isCruiserAlive()) {
				boatState = '3';
			}
		}
		return boatState;
	}
	
	private char getBoatsStatusInfo_Submarine(int player) {
		char boatState = 'X';
		if(player == 1) {
			if(player1.isSubmarineAlive()) {
				boatState = '2';
			} 
		} else {
			if(player2.isSubmarineAlive()) {
				boatState = '2';
			}
		}
		return boatState;
	}
	
	private char getBoatsStatusInfo_Destroyer(int player) {
		char boatState = '2';
		if(player == 1) {
			if(player1.isDestroyerAlive()) {
				boatState = '2';
			} 
		} else {
			if(player2.isDestroyerAlive()) {
				boatState = '2';
			}
		}
		return boatState;
	}
}