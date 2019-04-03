/**
 * copyRight
 */
package java8.function_interface;

import com.liuz.java8.function.inter.MyConsumer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/3/29
 * Time: 16:17
 */
public class MapReader {
    public static void readerMap(Map<String,String> map, ProcessMapReader reader){

        Set<String> keySet = map.keySet();
        for (String key:keySet) {
            reader.mapReader(map.get(key));
        }
    }
    public void readerMapForRefCons(Map<String,String> map, ProcessMapReader reader){

        Set<String> keySet = map.keySet();
        for (String key:keySet) {
            reader.mapReader(map.get(key));
        }
    }

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("aaa","test1");
        map.put("bbb","test2");
        map.put("ccc","test3");
        /*函数式接口输出*/
        readerMap(map,(key)-> System.out.println(key));
        /*方法引用输出*/
        System.out.println("方法引用输出");
        readerMap(map,System.out::println);

        /*构造函数引用*/
        System.out.println("构造函数引用");
        Supplier<MapReader> c1 = MapReader::new;
        MapReader mapReader = c1.get();
        mapReader.readerMapForRefCons(map,System.out::println);
        //Comparator::comparing("")
    }
}
