package proxy;

/**
 * @Author yJade
 * @Date 2022-08-04 20:09
 * @Package proxy
 *
 * 静态代理举例
 */
interface ClothFactory{
    void productCloth();
}

//代理类
class ProxyClothFactory  implements ClothFactory{

    private ClothFactory factory; //用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.productCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }


}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.productCloth();
    }
}