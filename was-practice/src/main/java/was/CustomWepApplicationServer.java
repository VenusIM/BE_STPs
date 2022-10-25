package was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWepApplicationServer {

    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
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
                 * 단일 메인 쓰레드에서 처리, 다중 처리 불가
                 */
                /*
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
                  }
                */

                /**
                 * Step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 * 요청이 많아 질수록 계속해서 쓰레드를 생성하여 자원을 많이 소모한다.
                 * CPU 컨텍스트 스위칭 횟수, 메모리 사용량, 서버 리소스 초과 등의 문제가 발생할 수 있다.
                 */
                // new Thread(new ClientRequestHandler(clientSocket)).start();

                /**
                 * Step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                 */
                executorService.execute(new Thread(new ClientRequestHandler(clientSocket)));
            }
        }
    }
}
