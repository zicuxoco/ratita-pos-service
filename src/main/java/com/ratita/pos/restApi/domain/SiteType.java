package com.ratita.pos.restApi.domain;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
public enum SiteType {
    Browser(1),
    Mobile(2),
    Agent(4);

    private int siteTypeId;

    private SiteType(int siteTypeId) {
        this.siteTypeId = siteTypeId;
    }

    public static SiteType valueOf(int id) {

        switch (id) {
            case 1:
                return Browser;
            case 2:
                return Mobile;
            case 3:
                return Mobile;
            case 4:
                return Agent;
            default:
                return null;
        }
    }
}
