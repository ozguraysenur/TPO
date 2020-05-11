package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@WebFilter(filterName = "footer",
        urlPatterns = { "*.servlet", "*.html" },
        dispatcherTypes = { DispatcherType.REQUEST }
)
public class FooterFilter implements Filter {


    private static final String footer="<tr>\n" +
            "               <td>\n" +
            "                   <div id=\"date\"></div>\n" +
            "               </td>\n" +
            "            </tr>\n" +
            "        </table>\n" +
            "    </form>\n" +
            "    <script src=\"/scripts/index.js\"></script>\n" +
            "</center>\n" +
            "</body>\n" +
            "</html>";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {


        CustomResponseWrapper wrapper = new CustomResponseWrapper((HttpServletResponse) resp);
        filterChain.doFilter(servletRequest, wrapper);

        PrintWriter out = resp.getWriter();
        String content = wrapper.getStringWriter().toString();
        out.write(content);
        out.println(footer);

        out.close();

    }

    @Override
    public void destroy() {}
}