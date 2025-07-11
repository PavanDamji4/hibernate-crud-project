package com.pavan.hibernate;

import com.pavan.hibernate.dao.CountryDAO;
import com.pavan.hibernate.dao.RegionDAO;
import com.pavan.hibernate.model.Country;
import com.pavan.hibernate.model.Region;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // REGION CRUD
        RegionDAO regionDAO = new RegionDAO();
        Region asia = new Region();
        asia.setRegionName("Asia");
        regionDAO.addRegion(asia);

        List<Region> regions = regionDAO.listRegions();
        System.out.println("Regions in DB:");
        for (Region r : regions) {
            System.out.println(r);
        }


        // COUNTRY CRUD
        CountryDAO countryDAO = new CountryDAO();
        Country india = new Country();
        india.setCountryId("IN");
        india.setCountryName("India");
        india.setRegionId(regions.get(0).getRegionId()); // Assume region exists

        countryDAO.addCountry(india);

        List<Country> countries = countryDAO.listCountries();
        System.out.println("\nCountries in DB:");
        for (Country c : countries) {
            System.out.println(c);
        }

        // Uncomment to test update and delete
        // countryDAO.updateCountry("IN", "Bharat");
        // countryDAO.deleteCountry("IN");
    }
}
