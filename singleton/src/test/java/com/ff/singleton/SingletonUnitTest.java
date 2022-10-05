package com.ff.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SingletonUnitTest {

    /**
     * 测试线程安全
     */
    @Test
    public void test_thread() throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(11, () -> System.out.println("over"));
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Singleton08.INSTANCE);
                try {
                    barrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 将主线程加入到CyclicBarrier，保证主线程等待子线程结束
        barrier.await();
    }

    /**
     * 测试反射
     */
    @Test
    public void test_reflection() throws Exception {
        System.out.println(Singleton06.getInstance());
        Constructor<Singleton06> declaredConstructor = Singleton06.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton06 instance = declaredConstructor.newInstance();
        System.out.println(instance);
    }
}