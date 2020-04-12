package Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;



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
                                HttpServletResponse resp)throws IOException
    {
        PrintWriter out = resp.getWriter();
        out.println("<h3>METHOD:<br>\"" + req.getMethod()+"\"</h3>"); // presentation
        out.println();
        out.println("<h3>QUERY:<br>\""+ req.getQueryString()+"\"</h3>");  // presentation
        out.println();

       // Enumeration pnams = req.getParameterNames();
        int sum=0,num;
        /*
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

        }*/

        String first=req.getParameter("FirstNumber");  //get parameter
        String second= req.getParameter("SecondNumber");  //get parameter
        if(first.equals("")){
            first="0";
        }
        if (second.equals("")){
            second="0";
        }

        try {
            sum = Integer.parseInt(first)+Integer.parseInt(second);  //logic

        }catch (Exception e){
            out.println("please enter a valid integer!");
        }


        out.println("<h3>SUM:<br>\"" + sum + "\"</h3>");  // presentation


        out.close();
    }
}
