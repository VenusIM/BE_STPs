package mvc.real;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}