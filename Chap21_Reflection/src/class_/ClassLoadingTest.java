package class_;

/**
 * @Author yJade
 * @Date 2022-08-02 20:57
 * @Package class_
 */
public class ClassLoadingTest{
    public static void main (String [] args){
        System.out.println(test.m);
    }
}

class test{
    static {
        m = 300;
    }
    static int m = 100;
}
//第一步：加载
//第二步：链接结束后m=0
//第三步：初始化结束后，m的值由<clinit>()方法执行决定
/*
这个test构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生，类似于
<clinit>(){
m = 300;
m = 100;
}
*/