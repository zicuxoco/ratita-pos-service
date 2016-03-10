package com.ratita.pos.domain;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 *         <p/>
 *         Defines the Permissions for Package Rates.
 */
public enum PosPermissions {
    NO_ACCESS,
    POS_PRICE_ONLY,
    POS_AND_PRICES_MODIFICATION,
    STANDALONE_PRICES_ONLY;

    /**
     * Default value for Pos price permission type: {@value}.
     */
    public static final PosPermissions DEFAULT = STANDALONE_PRICES_ONLY;
    private final String type = String.valueOf(ordinal());

    /**
     * Returns the pos permission type.
     */
    @Override
    public String toString() {
        return type;
    }

    /**
     * Returns the proper enum from the String passed in.
     *
     * @param permissions The string representation of the package name used to find the value.
     * @return the appropriate ENUM value.
     */

    public static PosPermissions getByValue(final String permissions) {
        if (permissions == null) {
            return DEFAULT;
        }
        switch (permissions) {
            case "0":
                return NO_ACCESS;
            case "1":
                return POS_PRICE_ONLY;
            case "2":
                return POS_AND_PRICES_MODIFICATION;
            default:
                //3 is implied.
                return DEFAULT;
        }
    }

}
