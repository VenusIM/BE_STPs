package was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import was.calculate.NewCalculator;
import was.calculate.PositiveNumber;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWepApplicationServer {

    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWepApplicationServer.class);

    public CustomWepApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWepApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWepApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWepApplicationServer] client connected!");

                /**
                 * Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
                try (InputStream inputStream = clientSocket.getInputStream(); OutputStream outputStream = clientSocket.getOutputStream()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                    /*
                    String line;
                    while((line = bufferedReader.readLine()) != "") {
                        System.out.println(line);
                        *//**
                         * line Http Protocol
                         * GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
                         * Host: localhost:8080
                         * Connection: Keep-Alive
                         * User-Agent: Apache-HttpClient/4.5.13 (Java/11.0.13)
                         * Accept-Encoding: gzip,deflate
                         *
                         * HttpRequest
                         *  - RequestLine (GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1)
                         *      - HttpMethod
                         *      - path
                         *      - queryString
                         *  - Header
                         *  - BlankLine
                         *  - Body
                         *//*
                    }
                    */

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

                }
            }
        }
    }
}
