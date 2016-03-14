package com.ratita.pos.filters;

import com.ratita.pos.categories.Unit;
import com.ratita.pos.resources.RatitaOfferBuilder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
@Category(Unit.class)
public class SiteTypeFilterTest {

    @Test
    public void test_Mobile_Site_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(2);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(2);
        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(3);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(3);
        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Browser_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(1);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Browser_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(1);
        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Junk_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(5);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Junk_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(5);
        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Negative_Number_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(-3);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Negative_Number_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(-4);
        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Mobile_Site_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(3);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Mobile_Site_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(3);
        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Null_Site_Type_Offer_With_MobileOfferAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(null);
        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Null_Site_Type_Offer_With_MobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = Collections.singleton(null);

        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_And_Browser_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(1);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Browser_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(3);
        siteTypeIds.add(1);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_And_Browser_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(1);

        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Browser_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(3);
        siteTypeIds.add(1);

        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_And_Junk_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(9);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_And_Junk_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(99);

        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Junk_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(3);
        siteTypeIds.add(35);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Junk_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(3);
        siteTypeIds.add(72);

        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Browser_And_Junk_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(1);
        siteTypeIds.add(57);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Browser_And_Junk_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(1);
        siteTypeIds.add(87);

        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }



    @Test
    public void test_Agent_And_Junk_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(4);
        siteTypeIds.add(75);

        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

   @Test
    public void test_Browser_And_Negative_Number_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(1);
        siteTypeIds.add(-75);

        assertTrue(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_Site_And_Negative_Number_withMobileOfferAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(2);
        siteTypeIds.add(-43);

        assertTrue(
            new SiteTypeFilter(true).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }

    @Test
    public void test_Mobile_App_And_Negative_Number_withMobileOfferNotAllowed() {

        Set<Integer> siteTypeIds = new HashSet<>();
        siteTypeIds.add(3);
        siteTypeIds.add(-75);

        assertFalse(
            new SiteTypeFilter(false).test(new RatitaOfferBuilder()
                .setSiteTypesFromInt(siteTypeIds).createRatitaOffer()));
    }


}
