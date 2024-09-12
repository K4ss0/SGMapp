package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class GeneralWindowInfoRepositoryTest {

    @Autowired
    private GeneralWindowInfoRepository generalWindowInfoRepository;

    @Test
    public void testSaveGeneralWindowInfo() {
        GeneralWindowInfo generalWindowInfo = new GeneralWindowInfo();
        generalWindowInfo.setBrand("Andersen");
        generalWindowInfo.setSeries("100");
        generalWindowInfo.setColorExterior("Terratone");
        generalWindowInfo.setColorInterior("White");
        generalWindowInfo.setFrameType("Block");

        GeneralWindowInfo savedGeneralWindowInfo = generalWindowInfoRepository.save(generalWindowInfo);

        Optional<GeneralWindowInfo> foundGeneralWindowInfo = generalWindowInfoRepository.findById(savedGeneralWindowInfo.getGeneralWindowInfoId());

        assertTrue(foundGeneralWindowInfo.isPresent(),"General window info should be found in repository");
        assertEquals("Andersen", foundGeneralWindowInfo.get().getBrand());
        assertEquals("100", foundGeneralWindowInfo.get().getSeries());
        assertEquals("Terratone", foundGeneralWindowInfo.get().getColorExterior());
        assertEquals("White", foundGeneralWindowInfo.get().getColorInterior());
        assertEquals("Block", foundGeneralWindowInfo.get().getFrameType());
    }
}
