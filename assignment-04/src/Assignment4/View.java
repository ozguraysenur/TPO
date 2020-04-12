package Assignment4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view")
public class View extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceReq(req,resp);
    }

    private void serviceReq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<h3>METHOD:<br>\"" + request.getMethod()+"\"</h3>"); // presentation
        out.println();
        out.println("<h3>QUERY:<br>\""+ request.getQueryString()+"\"</h3>");  // presentation
        out.println();


        // extract model from request as it has been passed by Controller
        //takes the attribute from the req which is forwarded
        Model attributeModel = (Model) request.getAttribute("Model");
        HttpSession session = request.getSession();
        Model sessionModel = (Model) session.getAttribute("Model");

        if (attributeModel == null || sessionModel == null) {
            out.println("</body></html>");
            out.close();
            return;
        }

        //out.println("atribute result:" + attributeModel.getSum());

        //out.println("session result:" + sessionModel.getSum());

        out.println("<h3>SUM:<br>\"" + attributeModel.getSum() + "\"</h3>");  // presentation
        out.close();





    }
}
