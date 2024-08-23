package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.DTO.TakeoffDTO;
import org.springframework.stereotype.Service;

@Service
public class TakeoffService {

    public String saveTakeoff(TakeoffDTO takeoff){
        //method to generate unique takeoff number
        String takeoffNumber = generateTakeoffNumber();

        //save takeoff data to database
        return takeoffNumber;
    }

    private String generateTakeoffNumber(){
        // logic to generate unique take off number
        return "TKF" + System.currentTimeMillis();
    }
}
