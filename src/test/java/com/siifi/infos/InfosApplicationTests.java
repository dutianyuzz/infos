package com.siifi.infos;

import com.siifi.infos.entity.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfosApplicationTests {
    @Test
    public void contextLoads() {
    /*  intern方法会首先检查字符串池中是否有”xx”这个字符串，
		如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
		new String("计算机")，采用new新创建的字符串对象不进入字符串池 ,不直接返回这个字符串的引用 	 */
        String str = new String("计算机");
        System.out.println(str == str.intern());		 //false
    /*  静态字符串的结果会添加到常量池
		当str1调用intern的时候，会检查字符串池中是否含有该字符串。定义的str1已经进入字符串池中，会直接得到字符串的引用。 */
        String str1 = "aa123a";
        System.out.println(str1 == str1.intern());	    //true
        //这好像用上面的解释不通了，以下求解释
        String str3 = new String("杜") + new String("天雨");
        System.out.println(str3 == str3.intern());   //true

        String str4 = new StringBuilder("aaaaaaaaaaa").toString();
        System.out.println(str4 == str4.intern());    //false

        String str5 = new StringBuilder("aaa").append("ccc").toString(  );
        System.out.println(str5 == str5.intern());        //true

        String str6=new StringBuilder("ja").append("va").toString();
        System.out.println(str6.intern()==str6);         //false

        String str7=new StringBuilder("jd").append("k").toString();
        System.out.println(str7.intern()==str7);         //true

        Store store=null;
        System.out.println(store);
        String str8=null;
        System.out.println(str8);
        Integer i= null;
        System.out.println(i);

        String a="a"+"b";
        System.out.println(a);

        String aa=new StringBuilder("a").append("b").toString();
        System.out.println(aa==a);

        String m="hello world";
        String n="hello world";
        System.out.println(m==n);
        String u = new String(m);
        String v = new String("hello,world");
    }
}