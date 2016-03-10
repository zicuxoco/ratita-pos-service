package com.ratita.pos.resources;

import java.util.Locale;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
public class PosRequest {
    final int permission;
    final Locale locale;
    final boolean mobile;

    public PosRequest(int permission, Locale locale, boolean mobile) {
        this.permission = permission;
        this.locale = locale;
        this.mobile = mobile;
    }

    public int getPermission() {
        return permission;
    }

    public Locale getLocale() {
        return locale;
    }

    public boolean isMobile() {
        return mobile;
    }
}
