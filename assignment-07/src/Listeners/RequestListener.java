package Listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class RequestListener implements ServletRequestListener {
    private final static Logger logger;

    static {
        logger = Logger.getLogger("ServerLogger");
        logger.setLevel(Level.FINE);
    }
    public void requestDestroyed(ServletRequestEvent event) {
        logger.severe("Request destroyed!");
    }

    public void requestInitialized(ServletRequestEvent event) {
        //logger.severe("Request initialized :  " + event.toString());

        /*StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = event.getServletRequest().getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = buffer.toString();
        */

        Map<String, String[]> map = event.getServletRequest().getParameterMap();
        //for GET && POST Method
        StringBuilder requestContent = new StringBuilder();
        for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);

            for(String valueOfParam:paramValues) {
                //Output the Values
                //System.out.println("Value of Param with Name "+paramName+": "+valueOfParam);
                requestContent.append(paramName).append("=").append(valueOfParam);
            }
        }
        logger.severe("Request initialized : " + requestContent );
    }
}