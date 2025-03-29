package assembler;

import entity.RegionEntity;
import pojos.region.Region;

public class LocationAssembler {

    public static RegionEntity assemble(Region region) {
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setId(region.getId());
        regionEntity.setName(region.getLocalizedName());

        return regionEntity;
    }

}
