import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws Exception {
        // 내장 톰캣
        String webappDirLocation = "servlet-practice/src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(80);
        tomcat.getConnector();

        tomcat.addWebapp("/",new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: {}", new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
