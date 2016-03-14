package com.ratita.pos.resources;

import com.ratita.pos.categories.Unit;
import com.ratita.pos.domain.Offer;
import com.ratita.pos.restApi.domain.SiteType;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
@Category(Unit.class)
public class RatitaBuilderTest {

    @Test
    public void test_setSiteTypesForMobileSite() {
        Set<Integer> siteType = Collections.singleton(2);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 2 is passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForMobileApp() {
        Set<Integer> siteType = Collections.singleton(3);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 3 is passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForBrowser() {
        Set<Integer> siteType = Collections.singleton(1);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType null when 1 is passed",
            offer.getSiteType(), is(nullValue()));
    }

    @Test
    public void test_setSiteTypesForJunk() {
        Set<Integer> siteType = Collections.singleton(5);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Null when 5(outside valid range) is passed",
            offer.getSiteType(), is(nullValue()));
    }

    @Test
    public void test_setSiteTypesForNegativeNumber() {
        Set<Integer> siteType = Collections.singleton(-2);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Null when -2 is passed",
            offer.getSiteType(), is(nullValue()));
    }

    @Test
    public void test_setSiteTypesForBrowserAndMobileSite() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(1, 2));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 1 & 2 are passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForBrowserAndMobileApp() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(1, 3));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 1 & 3 are passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForMobileSiteAndMobileApp() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(2, 3));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 2 & 3 are passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForNull() {
        Set<Integer> siteType = Collections.singleton(null);
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType null when null is passed",
            offer.getSiteType(), is(nullValue()));
    }

    @Test
    public void test_setSiteTypesForMobileAppAndJunk() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(3, 5));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 3 & 5(outside valid range) are passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForMobileSiteAndJunk() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(2, 5));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 2 & 5(outside valid range) are passed",
            offer.getSiteType(), is(SiteType.Mobile));
    }

    @Test
    public void test_setSiteTypesForBrowserAndJunk() {
        Set<Integer> siteType = new HashSet<>(Arrays.asList(1, 5));
        Offer offer = new RatitaOfferBuilder().setSiteTypesFromInt(siteType).createRatitaOffer();

        assertThat("setSiteTypesFromInt should return siteType Mobile when 1 & 5(outside valid range) are passed",
            offer.getSiteType(), is(nullValue()));
    }

    @Test
    public void test_DirectAgency_Null_RatePlans() {
        assertFalse(
            "Null rate plans should not mark a offer as DA only.",
            new RatitaOfferBuilder().setDirectAgencyOnly(null).createRatitaOffer().isDirectAgencyOnly());
    }

    @Test
    public void test_DirectAgency_Empty_RatePlans() {
        assertFalse(
            "Empty rate plans should not mark a offer as DA only.",
            new RatitaOfferBuilder()
                .setDirectAgencyOnly(new Map[0])
                .createRatitaOffer()
                .isDirectAgencyOnly());
    }

    @Test
    public void test_DirectAgency_AllDA_RatePlans() {
        Map<String, String>[] ratePlans = new Map[]{
            Collections.singletonMap("RatePlanBusinessModelMask", "2")
        };

        assertTrue(
            "All DA rate plans should mark a offer as DA only.",
            new RatitaOfferBuilder()
                .setDirectAgencyOnly(ratePlans)
                .createRatitaOffer()
                .isDirectAgencyOnly());
    }

    @Test
    public void test_DirectAgency_SomeDA_RatePlans() {
        Map<String, String>[] ratePlans = new Map[]{
            Collections.singletonMap("RatePlanBusinessModelMask", "2"),
            Collections.singletonMap("RatePlanBusinessModelMask", "3"),
            Collections.singletonMap("RatePlanBusinessModelMask", "1")
        };

        assertFalse(
            "Some DA rate plans should not mark a offer as DA only.",
            new RatitaOfferBuilder()
                .setDirectAgencyOnly(ratePlans)
                .createRatitaOffer()
                .isDirectAgencyOnly());
    }

    @Test
    public void test_DirectAgency_NoDA_RatePlans() {
        Map<String, String>[] ratePlans = new Map[]{
            Collections.singletonMap("RatePlanBusinessModelMask", "1"),
            Collections.singletonMap("RatePlanBusinessModelMask", "3"),
            Collections.singletonMap("RatePlanBusinessModelMask", "1")
        };

        assertFalse(
            "No DA rate plans should not mark a offer as DA only.",
            new RatitaOfferBuilder()
                .setDirectAgencyOnly(ratePlans)
                .createRatitaOffer()
                .isDirectAgencyOnly());
    }
}


