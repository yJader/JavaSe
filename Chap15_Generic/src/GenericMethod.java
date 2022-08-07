public class GenericMethod {
    public static void main(String[] args) {

    }
}

//普通类
class Car{
    public void run(){
        System.out.println("car run");
    }

    public <T, R> void fly(String name, T t){
        System.out.println(t.getClass());
        R r;
        //System.out.println(r.getClass());
        //error: 变量 'r' 可能尚未初始化
    }
}
