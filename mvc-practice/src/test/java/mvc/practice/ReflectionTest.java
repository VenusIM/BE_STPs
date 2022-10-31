package mvc.practice;

import mvc.practice.annotation.Controller;
import mvc.practice.annotation.Service;
import mvc.practice.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class)); // ctrl + alt + M method로 추출

        log.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> userClass = User.class;
        log.debug(userClass.getName());

        log.debug("User all declared fields: [{}]", Arrays.stream(userClass.getDeclaredFields()).collect(Collectors.toList()));
        log.debug("User all declared constructor: [{}]", Arrays.stream(userClass.getDeclaredConstructors()).collect(Collectors.toList()));
        log.debug("User all declared methods: [{}]", Arrays.stream(userClass.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        // Heap 영역에 로드 되어 있는 Class 객체를 가져올 수 있는 방법

        // 1
        Class<User> userClass1 = User.class;

        //2
        User user =  new User("test", "테스트");
        Class<? extends User> userClass2 = user.getClass();

        //3
        Class<?> userClass3 = Class.forName("mvc.practice.model.User");

        log.debug("userClass: [{}]", List.of(userClass1, userClass2, userClass3));

        assertThat(userClass1 == userClass2).isTrue();
        assertThat(userClass2 == userClass3).isTrue();
        assertThat(userClass3 == userClass1).isTrue();
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("mvc.practice");

        Set<Class<?>> beans = new HashSet<>();
        // mvc.practice 하위에 있는 Controller, Service Annotation을 모두 담는다.

        /*
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        */

        // re-factoring
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
