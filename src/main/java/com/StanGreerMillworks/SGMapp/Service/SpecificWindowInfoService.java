package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.domain.SpecificWindowInfo;
import com.StanGreerMillworks.SGMapp.repository.SpecificWindowInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificWindowInfoService {

    @Autowired
    private SpecificWindowInfoRepository specificWindowInfoRepository;

    public List<SpecificWindowInfo> getAllSpecificWindowInfo(){
        return specificWindowInfoRepository.findAll();
    }

    public SpecificWindowInfo saveSpecificWindowInfo(SpecificWindowInfo specificWindowInfo){
        return specificWindowInfoRepository.save(specificWindowInfo);
    }
}
