package cn.moonify.utils;

public class ThreadLocalUtil {
    private static final ThreadLocal<String> THREAD_LOCAL_USERNAME = new ThreadLocal<>();

    public static String getUsername() {
        return THREAD_LOCAL_USERNAME.get();
    }

    public static void setUsername(String value) {
        THREAD_LOCAL_USERNAME.set(value);
    }

    public static void removeAll(){
        THREAD_LOCAL_USERNAME.remove();
    }

}
