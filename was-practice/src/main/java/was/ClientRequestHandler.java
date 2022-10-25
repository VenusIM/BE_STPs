package was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import was.calculate.NewCalculator;
import was.calculate.PositiveNumber;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);
    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        /**
         * Step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
         */
        logger.info("[ClientRequestHandler] new client {} started",Thread.currentThread().getName());
        try (InputStream inputStream = clientSocket.getInputStream(); OutputStream outputStream = clientSocket.getOutputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            HttpRequest httpRequest = new HttpRequest(bufferedReader);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operend1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int opernad2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = NewCalculator.calculate(new PositiveNumber(operend1), operator, new PositiveNumber(opernad2));
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse httpResponse =  new HttpResponse(dataOutputStream);
                httpResponse.response200Header("application/json", body.length);
                httpResponse.responseBody(body);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
