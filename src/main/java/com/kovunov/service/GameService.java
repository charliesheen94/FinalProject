package com.kovunov.service;

import com.kovunov.entity.Console;
import com.kovunov.entity.Games;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class GameService {

    static Logger logger = Logger.getLogger(GameService.class.getName());

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "playerPersistenceUnit";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    public List<Games> getAll() {
        return getEntityManager().createNamedQuery("findAllGames", Games.class).getResultList();
    }

    public List<Console> getAllConsole() {
        return getEntityManager().createNamedQuery("findAllConsole", Console.class).getResultList();
    }

    @Transactional
    public Boolean saveConsole(Console console) {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(console);
            manager.getTransaction().commit();
            return Boolean.TRUE;
        }catch (Exception ex){
            logger.warning("Console Can't Add Successful due to "+ex.getMessage());
            return Boolean.FALSE;
        }
    }

    public Games findById(long id) {
        EntityManager manager = getEntityManager();
        return manager.find(Games.class, id);
    }

    @Transactional
    public Boolean update(Games games) {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(games);
            manager.getTransaction().commit();
            return Boolean.TRUE;
        }catch (Exception ex){
            logger.warning("Games Details Can't Update Successful");
            return Boolean.FALSE;
        }
    }

    @Transactional
    public Boolean create(Games games) {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(games);
            manager.getTransaction().commit();
            return Boolean.TRUE;
        }catch (Exception ex){
            logger.warning("Games Details Can't Create Successful");
            return Boolean.FALSE;
        }
    }

    @Transactional
    public Boolean delete(Games games) {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            if (!manager.contains(games)) {
                games = manager.merge(games);
            }
            manager.remove(games);
            manager.getTransaction().commit();
            return Boolean.TRUE;
        }catch (Exception ex){
            logger.warning("Games Details Can't Delete Successful");
            return Boolean.FALSE;
        }
    }
}
