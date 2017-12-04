/**
 * 
 */
package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

/**
 * @author swathi cheela
 *
 */
public class ShipwreckControllerTest {
	
	@InjectMocks
	ShipwreckController sc;
	
	@Mock
	ShipwreckRepository swRepo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet(){
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(swRepo.findOne(Mockito.anyLong())).thenReturn(sw);

		Shipwreck wreck = sc.get(1L);
		assertEquals(1l, wreck.getId().longValue());
		assertThat(1l, is(1L));
		
		Mockito.verify(swRepo).findOne(1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testForIncorrectInput() {
		sc.get(null);
		Assert.assertNotNull(sc);
	}
	
}
