package com.ratita.pos.custom;

import com.ratita.pos.domain.PosPermissions;

import org.apache.commons.lang3.StringUtils;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
public interface OfferCustomClient {

    String PACKAGE_RATE_PERMISSIONS_TYPE = "PACKAGE_RATE_PERMISSIONS_TYPE";
    String ATLANTIS_MOBILE_RATES = "ATLANTIS_MOBILE_RATES";
    String DIRECT_AGENCY_ACCESS_LEVEL = "DIRECT_AGENCY_ACCESS_LEVEL";

    int getPosPermissions(String posKey);

    boolean getMobileDealsAllowed(String posKey);

    boolean getDirectAgencyAllowed(String posKey);

    static OfferCustomClient get(CustomClient client) {
        final String direct = "DIRECT";
        return new OfferCustomClient() {
            @Override
            public int getPosPermissions(String posKey) {
                return PosPermissions
                    .getByValue(client.getAttribute(posKey, PACKAGE_RATE_PERMISSIONS_TYPE))
                    .ordinal();
            }

            @Override
            public boolean getMobileDealsAllowed(String posKey) {
                return Boolean
                    .parseBoolean(client.getAttribute(posKey, ATLANTIS_MOBILE_RATES));
            }

            @Override
            public boolean getDirectAgencyAllowed(String posKey) {
                return StringUtils.containsIgnoreCase(client.getAttribute(posKey, DIRECT_AGENCY_ACCESS_LEVEL), direct);
            }
        };
    }
}
