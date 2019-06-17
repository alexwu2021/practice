package CommonUtils;

import java.util.Iterator;
import java.util.List;

public class ConvertIntegerListToString {

    public static String convert2String(List<Integer> list){
        StringBuilder strbul  = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext())
        {
            strbul.append(iter.next());
            if(iter.hasNext()){
                strbul.append(",");
            }
        }
        return strbul.toString();
    }
}
