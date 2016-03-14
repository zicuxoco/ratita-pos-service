package com.ratita.pos.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author z.martinez.ramirez on 12/03/2016.
 *
 * Represents configuration for the Pos Service as configured by environment variables.
 *
 */
public class OfferServiceEndpoint {
    private static final String DEFAULT_POS_PATH = "/pos";
    private static final String DEFAULT_POS_CACHE_PATH = "/tasks/posCacheStats";
    private static final String DEFAULT_SORT_CACHE_PATH = "/tasks/sortCacheStats";

    private final String host;
    private final String path;
    private final String posCachePath;
    private final String sortCachePath;

    private final int port;
    private final int httpsPort;
    private final int adminPort;

    /**
     * Instantiates a new Deals service endpoint.
     */
    public OfferServiceEndpoint() {
        host = getEnvironmentString(System.getenv("SERVICE_POS_HOST"), "");
        path = getEnvironmentString(System.getenv("SERVICE_POS_PATH"), DEFAULT_POS_PATH);
        posCachePath = getEnvironmentString(System.getenv("SERVICE_POS_CACHE_PATH"), DEFAULT_POS_CACHE_PATH);
        sortCachePath = getEnvironmentString(System.getenv("SERVICE_SORT_CACHE_PATH"), DEFAULT_SORT_CACHE_PATH);

        port = getEnvironmentInt(System.getenv("SERVICE_POS_PORT"), 0);
        httpsPort = getEnvironmentInt(System.getenv("SERVICE_POS_HTTPS_PORT"), 0);
        adminPort = getEnvironmentInt(System.getenv("SERVICE_POS_ADMIN_PORT"), 0);
    }

    private static String getEnvironmentString(String environmentVal, String defaultVal) {
        return StringUtils.isBlank(environmentVal) ? defaultVal : environmentVal;
    }

    private static int getEnvironmentInt(String environmentVal, int defaultVal) {
        return NumberUtils.isNumber(environmentVal) ? Integer.valueOf(environmentVal) : defaultVal;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getPosCachePath() {
        return posCachePath;
    }

    public int getPort() {
        return port;
    }

    public String getSortCachePath() {
        return sortCachePath;
    }

    public int getHttpsPort() {
        return httpsPort;
    }

    public int getAdminPort() {
        return adminPort;
    }
}
