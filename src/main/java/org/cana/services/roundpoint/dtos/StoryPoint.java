package org.cana.services.roundpoint.dtos;

import java.util.HashMap;

public class StoryPoint {
    public static final String ZERO = "0";
    public static final String HALF = ".5";
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FIVE = "5";
    public static final String EIGHT = "8";
    public static final String THIRTEEN = "13";
    public static final String TWENTY = "20";
    public static final String FORTY = "40";
    public static final String HUNDRED = "100";
    public static final String QUESTION = "?";

    protected static final HashMap<String, String> gameAllStatus = new HashMap<String, String>() {
        private static final long serialVersionUID = -4274739196433099162L;

        {
            put(ZERO, ZERO);
            put(HALF, HALF);
            put(ONE, ONE);
            put(TWO, TWO);
            put(THREE, THREE);
            put(FIVE, FIVE);
            put(EIGHT, EIGHT);
            put(THIRTEEN, THIRTEEN);
            put(TWENTY, TWENTY);
            put(FORTY, FORTY);
            put(HUNDRED, HUNDRED);
            put(QUESTION, QUESTION);
        }
    };

    private String point;

    public StoryPoint(String point) {
        this.point = point;
    }

    public static boolean isValid(String point) {
        return gameAllStatus.containsKey(point);
    }

    public String getValue() {
        return gameAllStatus.get(point);
    }
}
