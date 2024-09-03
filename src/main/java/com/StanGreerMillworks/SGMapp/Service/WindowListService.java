package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.DTO.WindowListDTO;
import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import com.StanGreerMillworks.SGMapp.domain.SpecificWindowInfo;
import com.StanGreerMillworks.SGMapp.repository.GeneralWindowInfoRepository;
import com.StanGreerMillworks.SGMapp.repository.SpecificWindowInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WindowListService {

    @Autowired
    private GeneralWindowInfoRepository generalWindowInfoRepository;

    @Autowired
    private SpecificWindowInfoRepository specificWindowInfoRepository;

    public List<WindowListDTO> getWindowList(){
        List<GeneralWindowInfo> generalInfoList = generalWindowInfoRepository.findAll();
        List<SpecificWindowInfo> specificInfoList = specificWindowInfoRepository.findAll();

        List<WindowListDTO> winddowList = new ArrayList<>();

        for (GeneralWindowInfo generalInfo : generalInfoList) {
            for (SpecificWindowInfo specificInfo : specificInfoList) {
                if (generalInfo.getId().equals(specificInfo.getGeneralWindowInfoId())){
                    WindowListDTO item = new WindowListDTO();
                    item.setBrand(generalInfo.getBrand());
                    item.setSeriesType(generalInfo.getSeriesType());
                    item.setColor(generalInfo.getColor());
                    // add additional items for window list here
                    windowList.add(item)
                }
            }
        }
        return winddowList;
    }
}
