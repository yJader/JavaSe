package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author yJade
 * @Date 2022-08-04 20:29
 * @Package proxy
 * 动态代理
 */

interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*
想要实现动态代理, 需要解决的问题
1. 如何根据加载到内存中的被代理类, 动态的创建一个代理类及其对象
2. 当通过代理类的对象调用方法时, 如何动态的去调用被代理类中的同名方法
 */

class ProxyFactory {
    public static Object getProxyInstance(Object obj) { //obj: 被代理的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {//每一个动态代理类都必须要实现InvocationHandler这个接口

    private Object obj; //需要使用被代理类的对象进行复制

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象, 调用方法a时, 会自动调用invoke()
    //将被代理类需要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method: 即为代理类对象调用的方法, 此方法也就作为了被代理类对象要调用的方法
        //obj: 被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值即为当前类中的invoke()的返回值
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法是, 会自动地调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("薯条");

        System.out.println("--------------------");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.productCloth();
    }
}
