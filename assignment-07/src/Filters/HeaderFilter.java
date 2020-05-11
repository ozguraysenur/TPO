package Filters;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName="header",
        urlPatterns = { "*.servlet", "*.html" },
        dispatcherTypes = { DispatcherType.REQUEST }
        )
public class HeaderFilter implements Filter {

    public static final String HEADER = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\"\n" +
            "          content=\"text/html; charset=windows-1250\">\n" +
            "    <title>Test</title>\n" +
            "    <script src=\"/scripts/jquery-3.4.1.js\"></script>\n" +
            " <link rel='stylesheet' type='text/css' href='index.css'>"+
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "<center>";

    public static final String headerContent="<h3> Enter Numbers </h3>";

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.write(HEADER);
        writer.write(headerContent);
        filterChain.doFilter(servletRequest, servletResponse); //invoke next filter
    }

    @Override
    public void destroy() {}
}