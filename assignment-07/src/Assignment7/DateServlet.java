package Assignment7;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/date")
public class DateServlet extends HttpServlet {

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd MM:mm:ss");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(getLocalDateTime());
    }

    private static String getLocalDateTime(){
        Date date =new Date();
        return FORMAT.format(date);
    }

}