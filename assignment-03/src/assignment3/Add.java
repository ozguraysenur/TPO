package assignment3;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;


@WebServlet("/add")
public class Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceRequest(req, resp);
    }

    private void serviceRequest(HttpServletRequest req,
                                HttpServletResponse resp)
            throws IOException
    {
        PrintWriter out = resp.getWriter();
        out.println("<h3>METHOD:<br>\"" + req.getMethod()+"\"</h3>");
        out.println();
        out.println("<h3>QUERY:<br>\""+ req.getQueryString()+"\"</h3>");
        out.println();

        Enumeration pnams = req.getParameterNames();
        int sum=0,num;
        while (pnams.hasMoreElements()) {
            String name = (String) pnams.nextElement();
            try {
                String value = req.getParameter(name);
                if(value.equals("")) {
                   num=0;
                }else{
                    num = Integer.parseInt(value);
                }
                sum+=num;
            }catch (Exception e){
                out.println("please enter a valid integer!");
            }

        }
        out.println("<h3>SUM:<br>\"" + sum + "\"</h3>");
       //out.println("SUM  : " + sum);


        out.close();
    }
}
