package tpo5;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

import javax.jws.WebParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private final Logic _logic = new Logic();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceReq(req,resp);
    }

    private void serviceReq (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String first=req.getParameter("number1");
        String second= req.getParameter("number2");

        Model model=_logic.add(first,second);

        // pass model to view (we can either pass attributes or session)
        req.setAttribute("tpo5.Model",model);
        HttpSession session = req.getSession();
        session.setAttribute("Model", model);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/view");

        // pass modified request and response to view
        //forward modified req to another servlet
        dispatcher.forward(req, resp);

    }
}
