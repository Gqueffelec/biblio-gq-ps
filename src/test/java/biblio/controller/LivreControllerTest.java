package biblio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import biblio.dao.LivreDAO;
import biblio.model.Categorie;
import biblio.model.Livre;

@TestMethodOrder(OrderAnnotation.class)
class LivreControllerTest {

	private static LivreDAO controller;
	private static int testId;
	private static int listeSize;

	@BeforeAll
	public static void startUp() {
		controller = new LivreDAO();
	}

	@Test
	@Order(1)
	void test_create() {
		listeSize = controller.getAll().size();
		Livre livre = Livre.builder().titre("Le petit Poucet").categorie(Categorie.builder().id(1).build()).label("ROM1PTIPC").prix(29.99).stock(5)
				.date_edition(Date.valueOf(LocalDate.of(1697, 1, 1))).build();
		Livre test = controller.create(livre);
		testId = test.getId();
		assertTrue(test.getId() != 0);
		assertEquals("Le petit Poucet", test.getTitre());
	}

	@Test
	@Order(2)
	public void test_get() {
		Livre o = controller.getById(testId);
		assertEquals("Le petit Poucet", o.getTitre());
		assertEquals("ROM1PTIPC", o.getLabel());
		assertEquals(Date.valueOf(LocalDate.of(1697, 1, 1)), o.getDate_edition());
	}

	@Test
	@Order(3)
	public void test_update() {
		Livre livre = Livre.builder().titre("Le petit Poucet").categorie(Categorie.builder().id(1).build()).label("ROM1PTIPC").prix(29.99).stock(1)
				.date_edition(Date.valueOf(LocalDate.of(1997, 1, 1))).id(testId).build();
		boolean test = controller.update(livre);
		livre = controller.getById(testId);
		assertTrue(test);
		assertEquals(1, livre.getStock());
		assertEquals(Date.valueOf(LocalDate.of(1997, 1, 1)), livre.getDate_edition());
	}

	@Test
	@Order(4)
	public void test_get_all() {
		assertEquals(listeSize + 1, controller.getAll().size());
	}

	@Test
	@Order(5)
	void test_remove() {
		boolean test = controller.remove(testId);
		assertTrue(test);
	}
}
