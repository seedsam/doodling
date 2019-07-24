package reinvoke;

public class ClassB {

    // 方法持有对ClassA的依赖
    public void b(ClassA a) {
	System.out.println(" method b ");
	a.a();
	// 为什么不在ClassA a()方法中直接调用callback()方法呢?
	// 这就是回调方法的意义所在
	// 这是它的应用场景,自己想去吧
	a.callback();
    }

}
