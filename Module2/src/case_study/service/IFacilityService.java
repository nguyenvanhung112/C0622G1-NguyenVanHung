package case_study.service;

import java.io.IOException;

public interface IFacilityService {
    void displayListFacilitys() throws IOException;

    void addNewFacility() throws IOException;

    void displayListFacilitysMaintenance() throws IOException;

    void facilityMaintenance() throws IOException;
}
