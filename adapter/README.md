# 适配器模式

很常用的结构型设计模式，用做两个不兼容的接口之间的桥梁，结合了两个独立接口的功能。

经常看到有人滥用，并且会和**策略模式**、**桥接模式**混淆，这里主要结合例子说明下，如何恰当的引入的适配器模式，过度使用造成的问题后面也会提到。

## 使用场景
#### 一、需求
中国标准电压是 220V，电器也是支持 220V的，代码实现使用电器的逻辑。
创建电器类：
```
public class ChinaDevice {

    /**
     * 使用电器
     *
     * @param voltage 输入电压
     */
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (voltage == 220) {
            System.out.println("中国电器正常运行");
        } else {
            System.out.println("中国电器烧毁");
        }
        System.out.println();
    }
}
```
创建电源类：
```
public class ChinaPower {
    public void run(ChinaDevice device) {
        // 使用220V电压运行
        device.use(220);
    }
}
```
使用电器：
```
public class DeviceUnitTest {

    @Test
    public void test() {
        // 创建220V电源
        ChinaPower chinaPower = new ChinaPower();
        // 运行中国电器
        chinaPower.run(new ChinaDevice());
    }
}
```
开发完成，电器正常运行起来了。
```
输入电压220V
中国电器正常运行
```

#### 二、拓展需求

产品经理拿来一个美国电器，仅支持 110V 电压，要求也要正常运行。

考虑到每个国家电器标准都不一样，需求必然会经常变更，这次我们抽离出一个接口：
```
public interface Device {

    /**
     * 使用电器
     *
     * @param voltage 输入电压
     */
    void use(int voltage);
}
```
创建美国电器类：
```
public class USADevice implements Device {

    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (voltage == 110) {
            System.out.println("美国电器正常运行");
        } else {
            System.out.println("美国电器烧毁");
        }
        System.out.println();
    }
}
```

美国电器使用 220V 必然烧毁，那么应该如何解决呢？

很简单，创建一个美国电源类就可以了：
```
public class USAPower {
    public void run(Device device) {
        device.use(110);
    }
}
```

这种方式当然没有问题，但是随着国家的增多，电源类也会越来越多。

从实际生活的角度看，我们也不可能拥有多个电压的电源，只能借助变压器（适配器）来解决该问题。

#### 三、引入适配器模式

创建一个 220V 的适配器：
```
public class ChinaAdapter implements Device {

    private final Device mDevice;

    /**
     * 默认中国电器
     */
    public ChinaAdapter() {
        mDevice = new ChinaDevice();
    }

    /**
     * 适配各国电器
     */
    public ChinaAdapter(Device device) {
        this.mDevice = device;
    }

    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (mDevice instanceof ChinaDevice) {// 默认中国电器
            if (voltage == 220) {
                System.out.println("中国电器正常运行");
            } else {
                System.out.println("中国电器烧毁");
            }
        } else if (mDevice instanceof USADevice) {// 适配美国电器
            if (voltage == 110) {
                System.out.println("美国电器正常运行");
            } else {
                System.out.println("适配器工作...进行变压");
                System.out.println("美国电器在" + voltage + "V正常运行");
            }
        } else {
            throw new IllegalArgumentException(mDevice + "未知电器");
        }
        System.out.println();
    }
}
```

仔细对比 `ChinaAdapter` 和 `ChinaDevice`，可以发现，这个适配器只是扩展了 `ChinaDevice`，使其支持 `USADevice` 美国电器甚至各国电器。

* **无参构造** 创建的是中国电器，在 `use` 方法中，仅支持 220V。
* **带参构造** 创建的是各国电器，在 `use` 方法中，将 220V 转为 110V。

使用适配器：
```
public class DeviceUnitTest {

    @Test
    public void test() {
        // 创建220V电源
        ChinaPower chinaPower = new ChinaPower();
        // 适配器
        Device device = new ChinaAdapter(new USADevice());
        chinaPower.run(device);
        // 默认构造，就是支持220V的中国电器
        chinaPower.run(new ChinaAdapter());
    }
}
```

#### 四、优势
在这种模式下，电源不需要知道是哪种电器，只要提供 220V 电压即可，具体操作的什么类，由适配器决定。

适配器模式具有以下优势：
1. 可以让任何两个没有关联的类一起运行。 
2. 提高了类的复用。 
3. 灵活性好。

## 总结
* **意图**：将一个类的接口转换成另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
* **主要解决**：常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
* **如何解决**：继承类或实现接口（推荐）。
* **关键代码**：适配器继承已有的对象，实现想要的目标接口。
* **缺点**：过多地使用适配器，会使代码非常凌乱。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，如果太多出现这种情况，无异于一场灾难。因此**如果不是很有必要，可以不使用适配器，而是直接进行重构**。
* **注意事项**：适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。

## 参考
[设计模式-适配器](https://www.bilibili.com/video/BV17f4y1E7zU?p=3)
[适配器模式](https://www.runoob.com/design-pattern/adapter-pattern.html)  
[适配器和策略模式的联系与区别](https://www.cnblogs.com/ivy-xu/p/6638663.html)  
[Retrofit--网络通讯框架](https://www.jianshu.com/p/dd3dca4de6c0)