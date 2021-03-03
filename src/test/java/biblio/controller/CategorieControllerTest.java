package biblio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import biblio.model.Categorie;

@TestMethodOrder(OrderAnnotation.class)
class CategorieControllerTest {

	private static CategorieController controller;
	private static int testId;

	@BeforeAll
	public static void startUp() {
		HibernateController.start();
		controller = new CategorieController();
	}

	@AfterAll
	public static void finish() {
		HibernateController.close();
	}

	@Test
	@Order(1)
	void test_create() {
		Categorie categorie = Categorie.builder().nom("Bande dessinée").label("BD").information_technique("aucune")
				.build();
		Categorie test = controller.create(categorie);
		testId = test.getId();
		assertTrue(test.getId() != 0);
		assertEquals("Bande dessinée", test.getNom());
	}

	@Test
	@Order(2)
	public void test_get() {
		Categorie o = controller.getById(testId);
		assertEquals("Bande dessinée", o.getNom());
		assertEquals("BD", o.getLabel());
	}

	@Test
	@Order(3)
	public void test_update() {
		Categorie categorie = Categorie.builder().nom("Bande dessinée").label("BD").information_technique("Test")
				.id(testId).build();
		boolean test = controller.update(categorie);
		categorie = controller.getById(testId);
		assertEquals("Test", categorie.getInformation_technique());
		assertTrue(test);
	}

	@Test
	@Order(4)
	void test_remove() {
		boolean test = controller.remove(testId);
		assertTrue(test);
	}

}
