package com.siifi.infos;

import com.siifi.infos.entity.*;
import com.siifi.infos.service.column.ColumnService;
import com.siifi.infos.service.maney.ManeyImagesService;
import com.siifi.infos.service.maneyiamge.ManeyImageService;
import com.siifi.infos.service.media.MediaService;
import com.siifi.infos.service.user.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void test1() {
        String str = "my name is dutianyu" + "is very good";
        String str2 = ".*dutianyu.*";
        boolean isMatch = Pattern.matches(str2, str);
        System.out.println("字符串中是否包含了 'dutianyu' 子字符串? " + isMatch);
    }

    @org.junit.Test
    public void test2() {
        String str1 = new String();
        String str2 = str1;
        User user = new User();
        user.setUserName("dty");
        String name = user.getUserName();
        System.out.println(name);
        double a=1+2*3%4/5;
        System.out.println("+++++++++++"+a);
    }

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void test3() {
        String userName = "admin";
        User user = userService.getUser(userName);
        System.out.println(user);
    }
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @org.junit.Test
    public void tests(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
/*        ops.set("name", "张三");*/
        String name = ops.get("name");
        System.out.println(name);
        System.out.println("测试以下");
        System.out.println(redisTemplate.hasKey("name"));
    }
    @org.junit.Test
    public void test4() {
        //相对于commons-httpclient 3.1这里采用接口的方式来获取httpclient了
        HttpClient httpClient = HttpClients.createDefault();
        //声明请求方式
        HttpGet httpGet = new HttpGet("https://xinjia.cxtech360.com/xinjia_wechat_app/api/selClientQRCode?clientId=526");
        HttpResponse httpResponse;
        String result;
        try {
            //获取相应数据，这里可以获取相应的数据
            httpResponse = httpClient.execute(httpGet);
            //拿到实体
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                result = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            httpGet.releaseConnection();
        }
    }

    @org.junit.Test
    public void test5() throws Exception {
        //相对于commons-httpclient 3.1这里采用接口的方式来获取httpclient了
        HttpClient httpClients = HttpClients.createDefault();
        //声明请求方式
        String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
        HttpPost httpPost = new HttpPost(url);
        //装填参数
        List<NameValuePair> valuePairs = new ArrayList<>();
        valuePairs.add(new BasicNameValuePair("mobileCode", "18630639516"));
        valuePairs.add(new BasicNameValuePair("userID", ""));
        httpPost.setEntity(new UrlEncodedFormEntity(valuePairs, Charset.defaultCharset()));
        HttpResponse execute = httpClients.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        if (entity != null) {
            String s = EntityUtils.toString(entity, Charset.defaultCharset());
            System.out.println(s);
        }
    }

    @Autowired
    private ColumnService columnService;

    @org.junit.Test
    public void test6() {
        Column column = new Column();
        column.setColumnId(6);
        column.setColumnName("测试3");
        column.setShou("说明3");
        columnService.editColumn(column);
    }

    @org.junit.Test
    public void test7() {
        outer:
        for (int i = 0; i < 3; i++)
            inner:for (int j = 0; j < 2; j++) {
                if (j == 1) continue outer;
                System.out.println(j + "and " + i + ";");
            }
    }

    @Autowired
    private ManeyImagesService maneyImagesService;

    @org.junit.Test
    public void test8() {
        ManeysImage maneysImage = new ManeysImage();
        maneysImage.setName("杜天雨");
        maneyImagesService.saveManey(maneysImage);
    }

    @Autowired
    private ManeyImageService maneyImageService;

    @org.junit.Test
    public void test9() {
        List<ManeyImage> list=new ArrayList<>();
        ManeyImage maneyImage = new ManeyImage();
        maneyImage.setManeyId("2");
        maneyImage.setTid("dasdasd");
        list.add(maneyImage);
        ManeyImage maneyImages = new ManeyImage();
        maneyImages.setManeyId("3");
        maneyImages.setTid("wwwwwwwww");
        list.add(maneyImages);
        maneyImageService.saveRelativityManey(list);
    }

    @Resource
    private MediaService mediaService;
    @org.junit.Test
    public void test10(){
        List<Media> media=mediaService.getMedia();
        for(Media media1 :media){
            System.out.println(media1.getMediaName());
        }
        media.forEach(media1 -> System.out.println(media1.getMediaName()));

    }
    @org.junit.Test
    public void test11(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(f1 -> System.out.println(f1));
;
    }
    @org.junit.Test
    public void test12(){
        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表: " +strings);
        long count = getCountEmptyStringUsingJava7(strings);

        System.out.println("空字符数量为: " + count);
        count = getCountLength3UsingJava7(strings);

        System.out.println("字符串长度为 3 的数量为: " + count);

        // 删除空字符串
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println("筛选后的列表: " + filtered);

        // 删除空字符串，并使用逗号把它们合并起来
        String mergedString = getMergedStringUsingJava7(strings,", ");
        System.out.println("合并字符串: " + mergedString);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取列表元素平方数
        List<Integer> squaresList = getSquares(numbers);
        System.out.println("平方数列表: " + squaresList);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        System.out.println("列表: " +integers);
        System.out.println("列表中最大的数 : " + getMax(integers));
        System.out.println("列表中最小的数 : " + getMin(integers));
        System.out.println("所有数之和 : " + getSum(integers));
        System.out.println("平均数 : " + getAverage(integers));
        System.out.println("随机数: ");

        // 输出10个随机数
        Random random = new Random();

        for(int i=0; i < 10; i++){
            System.out.println(random.nextInt());
        }

        System.out.println("使用 Java 8: ");
        System.out.println("列表: " +strings);

        count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("列表: " +integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");

        random.ints().limit(10).sorted().forEach(System.out::println);

        // 并行处理
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为: " + count);
    }

    private static int getCountEmptyStringUsingJava7(List<String> strings){
        int count = 0;

        for(String string: strings){

            if(string.isEmpty()){
                count++;
            }
        }
        return count;
    }

    private static int getCountLength3UsingJava7(List<String> strings){
        int count = 0;

        for(String string: strings){

            if(string.length() == 3){
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
        List<String> filteredList = new ArrayList<String>();

        for(String string: strings){

            if(!string.isEmpty()){
                filteredList.add(string);
            }
        }
        return filteredList;
    }

    private static String getMergedStringUsingJava7(List<String> strings, String separator){
        StringBuilder stringBuilder = new StringBuilder();

        for(String string: strings){

            if(!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-2);
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        List<Integer> squaresList = new ArrayList<Integer>();

        for(Integer number: numbers){
            Integer square = new Integer(number.intValue() * number.intValue());

            if(!squaresList.contains(square)){
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    private static int getMax(List<Integer> numbers){
        int max = numbers.get(0);

        for(int i=1;i < numbers.size();i++){

            Integer number = numbers.get(i);

            if(number.intValue() > max){
                max = number.intValue();
            }
        }
        return max;
    }

    private static int getMin(List<Integer> numbers){
        int min = numbers.get(0);

        for(int i=1;i < numbers.size();i++){
            Integer number = numbers.get(i);

            if(number.intValue() < min){
                min = number.intValue();
            }
        }
        return min;
    }

    private static int getSum(List numbers){
        int sum = (int)(numbers.get(0));

        for(int i=1;i < numbers.size();i++){
            sum += (int)numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers){
        return getSum(numbers) / numbers.size();
    }

    @org.junit.Test
    public void test20(){
        Map<String,String> map=new HashMap<>();
        map.put("陈玄风","梅超风");
        map.put("杨康","穆念慈");
        map.put("郭靖","黄蓉");
        map.put("杨过","小龙女");
        Set<String> set=map.keySet();
        for (String key : set){
            String value= map.get(key);
            System.out.println(key+value);
        }
    }
    @org.junit.Test
    public void test21(){
        User user1=new User();
        user1.setUserName("admin");
        user1.setPassWord("zwgj.6783");
        userService.editUser(user1);
    }

}
