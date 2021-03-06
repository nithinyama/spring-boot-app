/**
 * 
 */
package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
/**
 * @author swathi cheela
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository repo;
	
	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = repo.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
