package org.cana.game.service.dtos;

import java.util.HashMap;

public class GameStatus {
    public static final String DELETED = "DELETED";
    public static final String INPROGRESS = "INPROGRESS";
    public static final String COMPLETED = "COMPLETED";
    public static final String CREATED = "CREATED";
    public static final String SETUP = "SETUP";

    protected static final HashMap<String, String> gameAllStatus = new HashMap<String, String>()
    {
        private static final long serialVersionUID = -4274739196433099162L;
        {
            put(DELETED, DELETED);
            put(INPROGRESS, INPROGRESS);
            put(COMPLETED, COMPLETED);
            put(CREATED, CREATED);
            put(SETUP, SETUP);
        }};

    private String gameStatusValue;

    public GameStatus(String status) {
        this.gameStatusValue = status;
    }

    public static boolean isValid(String status) {
        return gameAllStatus.containsKey(status);
    }

    public String getValue() {
        return gameAllStatus.get(gameStatusValue);
    }
}
