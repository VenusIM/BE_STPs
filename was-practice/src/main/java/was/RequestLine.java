package was;

import java.util.Objects;
import java.util.StringTokenizer;

// GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
public class RequestLine {
    private final String method; // GET
    private final String urlPath; // /calculate
    private QueryStrings queryStrings; // operand1=11&operator=*&operand2=55

    public RequestLine(String requestLine) {
        StringTokenizer stringTokenizer = new StringTokenizer(requestLine, " ");
        this.method = stringTokenizer.nextToken(); 

        stringTokenizer = new StringTokenizer(stringTokenizer.nextToken(),"\\?");
        this.urlPath = stringTokenizer.nextToken();

        if(stringTokenizer.hasMoreTokens()) {
            this.queryStrings = new QueryStrings(stringTokenizer.nextToken());
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    public boolean isGetRequest() {
        return "GET".equals(method);
    }


    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }
}
