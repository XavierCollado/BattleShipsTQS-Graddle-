package BattleShip_WithCoverage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BattleShip_WithCoverage.Game;

import BattleShip_WithCoverage.CellConstants;

/**
 * 
 * @author xavier 
 * @version 4.0
 */
class GameTest {

	@Test
	void applyAction_MenuScreen_WhenWeSelectOption1InMenuScreenTheScreenIdIsSetToSelectionScreen() {
		// Given
		Game game = new Game();
		int selectionScreenId = 1;
		
		// When
		game.applyAction("1");
		
		// Then
		assertEquals(selectionScreenId, game.getScreen());
	}
	
	@Test
	void applyAction_MenuScreen_WhenWeSelectOption2InMenuScreenWeEndTheGame() {
		// Given
		Game game = new Game();
		
		// When
		game.applyAction("2");
		
		// Then
		assertFalse(game.isPlaying());
	}
	
	@Test
	void applyAction_MenuScreen_WhenWeGetAnInvalidStringInputNothingHappens() {
		// Given
		Game game = new Game();
		int menuScreenId = 0;
		
		// When
		game.applyAction("1afsf");
	
		
		// Then
		assertTrue(game.isPlaying());
		assertEquals(menuScreenId, game.getScreen());
	}

	// This test checks what happens when I enter an input with a posX over the Boards limits
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithPosXOverBoardLimits() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		
		// When
		game.applyAction("11 2 V");
		
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a posX under the Boards limits
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithPosXUnderBoardLimits() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
				
		// When
		game.applyAction("-1 2 V");
				
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a posY over the Boards limits
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithPosYOverBoardLimits() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
			
		// When
		game.applyAction("2 11 V");
			
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
	}
		
	// This test checks what happens when I enter an input with a posY under the Boards limits
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithPosYUnderBoardLimits() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
				
		// When
		game.applyAction("2 -1 V");
				
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with an invalid orientation
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithAndInvalidOrientation() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
				
		// When
		game.applyAction("2 3 F");
				
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
		assertEquals(CellConstants.WATER_TYPE, game.player1.getCellType(1, 2));
	}
	
	// This test checks what happens when I enter an input with an invalid format (not following the expected "[posX] [posY] [orientation]"
	@Test
	void applyAction_SelctionScreen_WhenWeEnterAInputWithAndInvalidFormat() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
				
		// When
		game.applyAction("23V");
				
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation - (Carrier)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingBattleship = 1;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
				
		// When
		game.applyAction("2 2 V");
				
		// Then
		assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId()); 
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 1));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 2));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 3));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 4));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 5));
		
	}
	
	// This test checks what happens when I enter an input with a valid format and horizontal Orientation - (Carrier)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientation() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingBattleship = 1;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
					
		// When
		game.applyAction("2 2 H");
					
		// Then
		assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId()); 
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(1, 1));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(2, 1));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(3, 1));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(4, 1));
		assertEquals(CellConstants.CARRIER_TYPE, game.player1.getCellType(5, 1));
	}
	
	// Testing Ships selection //
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship get out of borders - (Carrier)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientationButCarrierDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
					
		// When
		game.applyAction("3 7 V");
					
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId()); 
			
	}
		
	// This test checks what happens when I enter an input with a valid format and horizontal orientation but the ship go out of borders - (Carrier)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientationButCarrierDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCarrier = 0;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
						
		// When
		game.applyAction("7 2 H");
						
		// Then
		assertEquals(boatInsertId_InsertingCarrier, game.getBoatInsertId()); 
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is over other ship - (Battleship)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_BattleshipIsOverOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingBattleship = 1;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		
		// When
		game.applyAction("1 3 V");
				
		// Then
		assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is next to another ship - (Battleship)
		@Test
		void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_BattleshipIsNextToOtherShip() {
			// Given
			Game game = new Game();
			String selectStartGame = "1";
			int boatInsertId_InsertingBattleship = 1;
			game.applyAction(selectStartGame); //We go to the SelectionScreen
			game.applyAction("1 1 V");		
			
			// When
			game.applyAction("2 3 V");
					
			// Then
			assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId());
		}

		// This test checks what happens when I enter an input with a valid format and horizontal Orientation - (Battleship)
		@Test
		void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientation_Battleship() {
			// Given
			Game game = new Game();
			String selectStartGame = "1";
			int boatInsertId_InsertingCruisser = 2;
			game.applyAction(selectStartGame); //We go to the SelectionScreen
			game.applyAction("1 1 H");
			
			// When
			game.applyAction("2 3 H");
						
			// Then
			assertEquals(boatInsertId_InsertingCruisser, game.getBoatInsertId()); 
			assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(1, 2));
			assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(2, 2));
			assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(3, 2));
			assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(4, 2));
		}
		
	// This test checks what happens when I enter an input with a valid format and vertical Orientation - (Battleship)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticallOrientation_Battleship() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCruisser = 2;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		
		// When
		game.applyAction("3 2 V");
					
		// Then
		assertEquals(boatInsertId_InsertingCruisser, game.getBoatInsertId()); 
		assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(2, 1));
		assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(2, 2));
		assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(2, 3));
		assertEquals(CellConstants.BATTLESHIP_TYPE, game.player1.getCellType(2, 4));
	}
	
	// Testing Ships selection //
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship get out of borders - (Battleship)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientationButBattleshipDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingBattleship = 1;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		
		// When
		game.applyAction("3 8 V");
					
		// Then
		assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId()); 
			
	}
		
	// This test checks what happens when I enter an input with a valid format and horizontal orientation but the ship go out of borders - (Battleship)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientationButBattleshipDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingBattleship = 1;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");				
		
		// When
		game.applyAction("8 8 H");
						
		// Then
		assertEquals(boatInsertId_InsertingBattleship, game.getBoatInsertId()); 
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is over other ship - (Cruiser)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_CruiserIsOverOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCruiser = 2;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		game.applyAction("3 4 V");
		
		// When
		game.applyAction("3 6 V");
				
		// Then
		assertEquals(boatInsertId_InsertingCruiser, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is next to another ship - (Cruiser)
		@Test
		void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_CruiserIsNextToOtherShip() {
			// Given
			Game game = new Game();
			String selectStartGame = "1";
			int boatInsertId_InsertingCruiser = 2;
			game.applyAction(selectStartGame); //We go to the SelectionScreen
			game.applyAction("1 1 V");		
			game.applyAction("3 4 V");	
			
			// When
			game.applyAction("2 3 V");
					
			// Then
			assertEquals(boatInsertId_InsertingCruiser, game.getBoatInsertId());
		}

		// This test checks what happens when I enter an input with a valid format and horizontal Orientation - (Cruiser)
		@Test
		void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientation_Cruiser() {
			// Given
			Game game = new Game();
			String selectStartGame = "1";
			int boatInsertId_InsertingSubmarine = 3;
			game.applyAction(selectStartGame); //We go to the SelectionScreen
			game.applyAction("1 1 H");
			game.applyAction("2 3 H");
			
			// When
			game.applyAction("2 5 H");
						
			// Then
			assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId()); 
			assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(1, 4));
			assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(2, 4));
			assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(2, 4));
		}
		
	// This test checks what happens when I enter an input with a valid format and vertical Orientation - (Cruiser)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticallOrientation_Cruiser() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingSubmarine = 3;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		
		// When
		game.applyAction("5 1 V");
					
		// Then
		assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId()); 
		assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(4, 0));
		assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(4, 1));
		assertEquals(CellConstants.CRUISER_TYPE, game.player1.getCellType(4, 2));
	}
	
	// Testing Ships selection //
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship get out of borders - (Cruiser)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientationButCruiserDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCruiser = 2;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		
		// When
		game.applyAction("8 10 V");
					
		// Then
		assertEquals(boatInsertId_InsertingCruiser, game.getBoatInsertId()); 
			
	}
		
	// This test checks what happens when I enter an input with a valid format and horizontal orientation but the ship go out of borders - (Cruiser)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientationButCruiserDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingCruiser = 2;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");
		game.applyAction("2 3 H");
		
		// When
		game.applyAction("9 5 H");
						
		// Then
		assertEquals(boatInsertId_InsertingCruiser, game.getBoatInsertId()); 
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is over other ship - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_SubmarineIsOverOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingSubmarine = 3;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		game.applyAction("3 4 V");		
		game.applyAction("5 3 V");
		
		// When
		game.applyAction("3 7 V");
				
		// Then
		assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is next to another ship - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_SubmarineIsNextToOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingSubmarine = 3;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		game.applyAction("3 4 V");		
		game.applyAction("5 3 V");	
			
		// When
		game.applyAction("4 4 V");
					
		// Then
		assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId());
	}

	// This test checks what happens when I enter an input with a valid format and horizontal Orientation - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientation_Submarine() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");
		game.applyAction("2 3 H");
		game.applyAction("2 5 H");
			
		// When
		game.applyAction("3 7 H");
						
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId()); 
		assertEquals(CellConstants.SUBMARINE_TYPE, game.player1.getCellType(2, 6));
		assertEquals(CellConstants.SUBMARINE_TYPE, game.player1.getCellType(3, 6));
	}
		
	// This test checks what happens when I enter an input with a valid format and vertical Orientation - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticallOrientation_Submarine() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		game.applyAction("5 3 V");
		
		// When
		game.applyAction("7 4 V");
					
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId()); 
		assertEquals(CellConstants.SUBMARINE_TYPE, game.player1.getCellType(6, 3));
		assertEquals(CellConstants.SUBMARINE_TYPE, game.player1.getCellType(6, 4));
	}
	
	// Testing Ships selection //
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship get out of borders - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientationButSubmarineDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingSubmarine = 3;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		game.applyAction("5 3 V");
		
		// When
		game.applyAction("8 10 V");
					
		// Then
		assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId()); 
			
	}
		
	// This test checks what happens when I enter an input with a valid format and horizontal orientation but the ship go out of borders - (Submarine)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientationButSubmarineDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingSubmarine = 3;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");
		game.applyAction("2 3 H");
		game.applyAction("2 5 H");
		
		// When
		game.applyAction("10 5 H");
						
		// Then
		assertEquals(boatInsertId_InsertingSubmarine, game.getBoatInsertId()); 
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is over other ship - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_DestroyerIsOverOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		game.applyAction("3 4 V");		
		game.applyAction("5 3 V");		
		game.applyAction("7 4 V");
		
		// When
		game.applyAction("3 3 V");
				
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship is next to another ship - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientation_DestroyerIsNextToOtherShip() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");		
		game.applyAction("3 4 V");		
		game.applyAction("5 3 V");		
		game.applyAction("7 4 V");	
			
		// When
		game.applyAction("6 4 V");
					
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId());
	}
	
	// This test checks what happens when I enter an input with a valid format and horizontal Orientation - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientation_Destroyer() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boardScreenId = 3;
		int boatInsertId_AllInserted = 5;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");
		game.applyAction("2 3 H");
		game.applyAction("2 5 H");
		game.applyAction("3 7 H");
			
		// When
		game.applyAction("9 9 H");
						
		// Then
		assertEquals(boatInsertId_AllInserted, game.getBoatInsertId()); 
		assertEquals(CellConstants.DESTROYER_TYPE, game.player1.getCellType(8, 8));
		assertEquals(CellConstants.DESTROYER_TYPE, game.player1.getCellType(9, 8));
		assertEquals(boardScreenId, game.getScreen()); //As we insert all the ships we go to the BoardScreen
	}
		
	// This test checks what happens when I enter an input with a valid format and vertical Orientation - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticallOrientation_Destroyer() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boardScreenId = 3;
		int boatInsertId_AllInserted = 5;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		game.applyAction("5 3 V");
		game.applyAction("7 4 V");
		
		// When
		game.applyAction("9 9 V");
					
		// Then
		assertEquals(boatInsertId_AllInserted, game.getBoatInsertId()); 
		assertEquals(CellConstants.DESTROYER_TYPE, game.player1.getCellType(8, 8));
		assertEquals(CellConstants.DESTROYER_TYPE, game.player1.getCellType(8, 9));
		assertEquals(boardScreenId, game.getScreen()); //As we insert all the ships we go to the BoardScreen
	}
	
	// Testing Ships selection //
	// This test checks what happens when I enter an input with a valid format and vertical orientation but the ship get out of borders - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithVerticalOrientationButDestroyerDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 V");
		game.applyAction("3 4 V");
		game.applyAction("5 3 V");
		game.applyAction("7 4 V");
		
		// When
		game.applyAction("10 10 V");
					
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId()); 
			
	}
		
	// This test checks what happens when I enter an input with a valid format and horizontal orientation but the ship go out of borders - (Destroyer)
	@Test
	void applyAction_SelctionScreen_WhenWeEnterValidInputWithHorizontalOrientationButDestroyerDontFeetinTheBoard() {
		// Given
		Game game = new Game();
		String selectStartGame = "1";
		int boatInsertId_InsertingDestroyer = 4;
		game.applyAction(selectStartGame); //We go to the SelectionScreen
		game.applyAction("1 1 H");
		game.applyAction("2 3 H");
		game.applyAction("2 5 H");
		game.applyAction("3 7 H");
		
		// When
		game.applyAction("10 10 H");
						
		// Then
		assertEquals(boatInsertId_InsertingDestroyer, game.getBoatInsertId()); 
	}
}
