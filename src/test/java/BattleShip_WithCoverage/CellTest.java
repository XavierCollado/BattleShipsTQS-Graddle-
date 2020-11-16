package BattleShip_WithCoverage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BattleShip_WithCoverage.Cell;

/**
 * 
 * @author xavier
 * @version 1.0
 *
 */
class CellTest {

	@Test
	void hit_whenANotHitCellIsHitIsTrue() {
		// Given
		Cell cell = new Cell(1,1,"");
		
		// When
		cell.hit();
		
		// Then
		assertEquals(true, cell.ishit());
	}
	
	@Test
	void hit_whenAHitCellIsHitIsTrue() {
		// Given
		Cell cell = new Cell(1,1,"");
		cell.hit();
		
		// When
		cell.hit();
		
		// Then
		assertEquals(true, cell.ishit());
	}

}