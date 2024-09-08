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

    public List<WindowListDTO> getWindowList() {
        List<GeneralWindowInfo> generalInfoList = generalWindowInfoRepository.findAll();
        List<WindowListDTO> windowList = new ArrayList<>();

        for (GeneralWindowInfo generalInfo : generalInfoList) {
            List<SpecificWindowInfo> specificWindowInfoList = specificWindowInfoRepository.findByGeneralWindowInfo(generalInfo);
            for (SpecificWindowInfo specificInfo : specificWindowInfoList) {
                WindowListDTO item = new WindowListDTO();
                item.setBrand(generalInfo.getBrand());
                item.setSeries(generalInfo.getSeries());
                item.setColorInterior(generalInfo.getColorInterior());
                // add additional items for window list here
                item.setQuantity(specificInfo.getQuantity());
                item.setSize(specificInfo.getSize());
                item.setWindowType(specificInfo.getWindowType());
                item.setWindowLocation(specificInfo.getWindowLocation());
                item.setGrids(specificInfo.isGrids());
                item.setClear(specificInfo.isClear());
                item.setLowE(specificInfo.isLowE());
                item.setTempered(specificInfo.isTempered());
                item.setObscured(specificInfo.isObscured());
                item.setTinted(specificInfo.isTinted());
                item.setArgon(specificInfo.isArgon());
                windowList.add(item);
            }
        }
        return windowList;
    }

}
