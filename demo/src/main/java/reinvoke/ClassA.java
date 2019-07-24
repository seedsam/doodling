package reinvoke;

public class ClassA {

    public void a() {
	System.out.println(" method a ");
    }

    // 回调函数,这个函数就是对外暴露的,自己不会用到
    public void callback() {
	System.out.println(" method callback ");
    }

}
