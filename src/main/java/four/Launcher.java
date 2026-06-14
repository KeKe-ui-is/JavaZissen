package four;
import java.lang.reflect.*;
public class Launcher {
    public static void main(String[] args){
        String fqcn = args[0];
        String sw = args[1];
        System.out.println("sw : " + sw);
        showMemory();
        try {
            Class<?> clazz = Class.forName(fqcn);
            listMethods(clazz);
            if (sw.equals("E")){
                launchExternal(clazz);
            }else if (sw.equals("I")){
                launchInternal(clazz);
            }else {
                throw new IllegalArgumentException("起動方法の指定が不正です");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(670);
        }
        showMemory();
        System.exit(0);
    }

    public static void listMethods(Class<?> clazz){
        System.out.println("メソッドの一覧を返します");
        Method[] methods = clazz.getDeclaredMethods();
        int i = 0;
        for (Method m : methods){
            System.out.println(i + ":" + m.getName());
            i++;
        }
    }

    public static void launchExternal(Class<?> clazz) throws Exception{
        ProcessBuilder pb = new ProcessBuilder("java" ,clazz.getName());
        Process proc = pb.start();
        proc.waitFor();
    }

    public static void launchInternal(Class<?> clazz) throws Exception{
        Method m = clazz.getMethod("main" , String[].class);
        String[] args = {};
        m.invoke(null,(Object)args);
    }

    public static void showMemory(){
        long free = Runtime.getRuntime().freeMemory();
        long total = Runtime.getRuntime().totalMemory();
        long usage = (total - free) / 1024 / 1024;
        System.out.println("現在のメモリ使用量:" + usage + "MB");
    }
}
