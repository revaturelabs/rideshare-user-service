package com.revature.services.impl;

import com.revature.services.InfoService;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author May Love
 */
@Service
public class InfoServiceImpl implements InfoService {

    // Place key GOOGLE_MAPS_API_KEY and its value (provided on Slack) into your
    // environment variables, so it will not be uploaded to the GitHub repository
    @Override
    public String getGoogleMapsApiKey() {
                Map<String, String> env = System.getenv();
        for (Map.Entry <String, String> entry: env.entrySet()) {
            if(entry.getKey().equalsIgnoreCase("GOOGLE_MAPS_API_KEY")) {
                return entry.getValue();
            }
        }
        return null;
        }
    
}
