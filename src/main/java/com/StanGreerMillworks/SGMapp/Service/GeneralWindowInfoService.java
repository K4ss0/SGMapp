package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import com.StanGreerMillworks.SGMapp.repository.GeneralWindowInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralWindowInfoService {
    @Autowired
    GeneralWindowInfoRepository generalWindowInfoRepository;

    public List<GeneralWindowInfo> getAllGeneralWindowInfo() {
        return generalWindowInfoRepository.findAll();
    }

    public GeneralWindowInfo saveGeneralWindowInfo(GeneralWindowInfo generalWindowInfo) {
        return generalWindowInfo.save(generalWindowInfo);
    }
}
