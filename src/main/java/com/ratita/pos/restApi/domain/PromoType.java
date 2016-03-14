package com.ratita.pos.restApi.domain;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
public enum PromoType {
    ABSOLUTE("2"),
    PERCENTAGE("3");

    private final int promoType;

    PromoType(String type) throws NumberFormatException {
        promoType = Integer.parseInt(type);
    }

    public int getValue() { return promoType; }

    public String getBaseValue() {
        if (promoType == 2) {
            return "2";
        } else {
            return "3";
        }
    }

    public static PromoType getByValue(String type) {
        if ("2".equals(type)) {
            return ABSOLUTE;
        } else if ("3".equals(type)) {
            return PERCENTAGE;
        }
        throw new IllegalArgumentException("Valid promotion type values are [2, 3]");
    }
}
