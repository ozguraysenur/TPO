package Filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomResponseWrapper extends HttpServletResponseWrapper {
    //we can apply changes to the response even it has closed by servlet

    private StringWriter stringWriter = null;

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if(stringWriter == null) {
            stringWriter = new StringWriter();
        }
        return new PrintWriter(stringWriter);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        throw new IllegalStateException("getOutputStream() not allowed for CustomResponseWrapper");
    }

    public String getContent() {
        return stringWriter.toString();
    }

    public StringWriter getStringWriter() {
        return stringWriter;
    }
}