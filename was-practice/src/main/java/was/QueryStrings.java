package was;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 일급 컬렉션
public class QueryStrings {

    private List<QueryString> queryStrings = new ArrayList<>();
    // operand1=11&operator=*&operand2=55
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if(values.length == 1) {
                        throw new IllegalArgumentException("키 밖에 없음");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
