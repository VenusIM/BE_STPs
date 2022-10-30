import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init");

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("service");
    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
