package com.StanGreerMillworks.SGMapp.service;

import com.StanGreerMillworks.SGMapp.Service.GeneralWindowInfoService;
import com.StanGreerMillworks.SGMapp.repository.GeneralWindowInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GeneralWindowInfoServiceTest {

    @Autowired
    private GeneralWindowInfoService generalWindowInfoService;
}
