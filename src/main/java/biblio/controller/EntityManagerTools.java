package biblio.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerTools {
	
	private static EntityManagerTools instance;

    private static final String PERSISTENCE_UNIT_NAME = "CDA_BIBLI";
    
    private final EntityManager em;

    private EntityManagerTools() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    private static EntityManagerTools getInstance() {
        if (instance == null) {
        	synchronized (PERSISTENCE_UNIT_NAME) {
        		if(instance == null) {
        			instance = new EntityManagerTools();
        		}
			}
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        return getInstance().em;
    }
}
