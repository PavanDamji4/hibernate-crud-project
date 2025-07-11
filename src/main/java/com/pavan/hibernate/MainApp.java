package com.pavan.hibernate;

import com.pavan.hibernate.dao.RegionDAO;
import com.pavan.hibernate.model.Region;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        RegionDAO regionDAO = new RegionDAO();

        // Create and save a new region
        Region r1 = new Region();
        r1.setRegionName("Asia");
        regionDAO.saveRegion(r1);

        // Retrieve all regions
        List<Region> regions = regionDAO.getAllRegions();
        System.out.println("Regions in DB:");
        for (Region r : regions) {
            System.out.println(r.getRegionId() + " - " + r.getRegionName());
        }
    }
}
