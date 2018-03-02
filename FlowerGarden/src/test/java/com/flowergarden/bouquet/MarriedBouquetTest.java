package com.flowergarden.bouquet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;

import com.flowergarden.flowers.GeneralFlower;

public class MarriedBouquetTest {

	private MarriedBouquet bouquet = new MarriedBouquet();
	
	@Test
	public void emptyBouquetGetPriceShouldReturnAssemblePrice() {
		assertEquals(120.0, bouquet.getPrice(), 0.0);
	}

	@Test
	public void nonEmptyBouquetGetPriceShouldReturnMoreThanAssemblePrice(){
		GeneralFlower flower = mock(GeneralFlower.class);
		when(flower.getPrice()).thenReturn((float) 10.0);
		bouquet.addFlower(flower);
		
		assertEquals(130.0, bouquet.getPrice(), 0.0);
	}
	
	@Test
	public void nonEmptyBouquetContainsFlowersMatchingSearchFlowersByLength(){
		GeneralFlower flower = mock(GeneralFlower.class);
		GeneralFlower matchingFlower1 = mock(GeneralFlower.class);
		GeneralFlower matchingFlower2 = mock(GeneralFlower.class);
		when(flower.getLenght()).thenReturn(2);
		when(matchingFlower1.getLenght()).thenReturn(6);
		when(matchingFlower2.getLenght()).thenReturn(9);
		
		bouquet.addFlower(flower);
		bouquet.addFlower(matchingFlower1);
		bouquet.addFlower(matchingFlower1);

		assertEquals(2, bouquet.searchFlowersByLenght(3, 10).size());
	}
	
	@Test
	public void nonEmptyBouquetDoesNotContainsFlowersMatchingSearchFlowersByLength(){
		GeneralFlower flower = mock(GeneralFlower.class);
		GeneralFlower matchingFlower1 = mock(GeneralFlower.class);
		GeneralFlower matchingFlower2 = mock(GeneralFlower.class);
		when(flower.getLenght()).thenReturn(2);
		when(matchingFlower1.getLenght()).thenReturn(1);
		when(matchingFlower2.getLenght()).thenReturn(12);
		
		bouquet.addFlower(flower);
		bouquet.addFlower(matchingFlower1);
		bouquet.addFlower(matchingFlower1);

		assertEquals(0, bouquet.searchFlowersByLenght(3, 10).size());
	}
	
	@Test(expected=Exception.class)
	@Ignore("Not running because exception handling is not implemented yet.")
	public void notValidParametersOrderShouldThrowException() {
		assertEquals(0, bouquet.searchFlowersByLenght(30, 10).size());
	}
	
	
}
