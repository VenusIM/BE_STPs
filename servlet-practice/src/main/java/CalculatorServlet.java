import calculate.NewCalculator;
import calculate.PositiveNumber;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
//public class CalculatorServlet implements Servlet {
//public class CalculatorServlet extends GenericServlet {
public class CalculatorServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

   /*
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("init");
        this.servletConfig = servletConfig;
    }
    */

//    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = NewCalculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /* GenericServlet을 통해 필요한 메서드만 오버라이딩하여 사용
    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    */
}
