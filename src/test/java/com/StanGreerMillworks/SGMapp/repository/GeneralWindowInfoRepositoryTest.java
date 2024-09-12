package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import com.StanGreerMillworks.SGMapp.domain.TakeoffForm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class GeneralWindowInfoRepositoryTest {

    @Autowired
    private GeneralWindowInfoRepository generalWindowInfoRepository;

    @Autowired
    private TakeoffFormRepository takeoffFormRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test

    public void testSaveGeneralWindowInfoWithTakeOff() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setFirstName("John");
        customerInfo.setLastName("Doe");
        customerInfo.setPhone1("123-456-7890");
        customerInfo.setPhone2("987-456-7890");
        customerInfo.setEmail("john.doe@example.com");
        customerInfo.setAddressLine1("123 Main St");
        customerInfo.setAddressLine2("Unit 123");
        customerInfo.setCity("San Francisco");
        customerInfo.setState("CA");
        customerInfo.setZip("12345");
        CustomerInfo savedCustomerInfo = customerRepository.save(customerInfo);

        TakeoffForm takeoffForm = new TakeoffForm();
        takeoffForm.setCustomer(savedCustomerInfo);
        takeoffForm.setCreatedAt(LocalDateTime.now());
        takeoffForm.setFormType("Window Takeoff");

        GeneralWindowInfo generalWindowInfo = new GeneralWindowInfo();
        generalWindowInfo.setBrand("Andersen");
        generalWindowInfo.setSeries("100");
        generalWindowInfo.setColorExterior("Terratone");
        generalWindowInfo.setColorInterior("White");
        generalWindowInfo.setFrameType("Block");
        generalWindowInfo.setHardwareFinish("Brushed Nickel");

        generalWindowInfo.setTakeoffForm(takeoffForm);

        takeoffForm.setGeneralWindowInfo(generalWindowInfo);

        TakeoffForm savedTakeoffForm = takeoffFormRepository.save(takeoffForm);

        assertNotNull(savedTakeoffForm.getTakeoffId(), "TakeoffForm ID should be generated and not null");
        assertNotNull(savedTakeoffForm.getGeneralWindowInfo(), "GeneralWindowInfo should be associated with TakeoffForm");

        Optional<GeneralWindowInfo> foundGeneralWindowInfo = generalWindowInfoRepository.findById(savedTakeoffForm.getGeneralWindowInfo().getGeneralWindowInfoId());
        assertTrue(foundGeneralWindowInfo.isPresent(), "GeneralWindowInfo should be found in the repository");

        assertEquals("Andersen", foundGeneralWindowInfo.get().getBrand());
        assertEquals("100", foundGeneralWindowInfo.get().getSeries());
        assertEquals("Terratone", foundGeneralWindowInfo.get().getColorExterior());
        assertEquals("White", foundGeneralWindowInfo.get().getColorInterior());
        assertEquals("Block", foundGeneralWindowInfo.get().getFrameType());
        assertEquals("Brushed Nickel", foundGeneralWindowInfo.get().getHardwareFinish());

        assertEquals("John", savedTakeoffForm.getCustomer().getFirstName(), "Customer name should match");
        assertEquals("Doe", savedTakeoffForm.getCustomer().getLastName());
    }
}
