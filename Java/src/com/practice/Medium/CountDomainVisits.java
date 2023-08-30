package com.practice.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDomainVisits {
    /*

You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com", // "mail.yahoo.com", "yahoo.com", and "com"
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "5,com.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1345
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
com.com:                 5
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)


*/


    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        calculateClicksByDomain(counts);
    }

    static void calculateClicksByDomain(String[] counts) {
        List<String>domains = new ArrayList<>();
        Map<String, Integer>mp = new HashMap<>();
        for(String c: counts){
            String[] sa = c.split(",");
            Integer val = Integer.valueOf(sa[0]);
            String key = sa[1];
            domains.add(key);
            mp.put(key, val);
        }

        Map<String, List<String>>prefix2Domain = new HashMap<>();
        for(String d: domains){
            String[] sa = d.split("\\.");
            String pre = "";
            for(int i = sa.length-1; i>0;  i--){
                pre = sa[i] + ((pre.length() > 1) ? "." + pre : "");
                if(!prefix2Domain.containsKey(pre)){
                    List<String>lst = new ArrayList<>();
                    lst.add(d);
                    prefix2Domain.put(pre, lst);
                }else{
                    prefix2Domain.get(pre).add(d);
                }
            }
        }

        Map<String, Integer>allCounts = new HashMap<>();
        for(Map.Entry<String, Integer> ent: mp.entrySet()){
            allCounts.put(ent.getKey(), ent.getValue());
        }
        for(Map.Entry<String, List<String>> ent: prefix2Domain.entrySet()){
            List<String> valAsKeys = ent.getValue();
            for(String vk : valAsKeys){
                allCounts.put(ent.getKey(), allCounts.getOrDefault(ent.getKey(), 0) + mp.get(vk)) ;
            }
        }

        for(Map.Entry<String, Integer>ent:  allCounts.entrySet()){
            System.out.printf("%-25s %7d\n", ent.getKey(), ent.getValue());
        }
    }

    /*
    "C:\Program Files\Java\jdk1.8.0_201\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.4\lib\idea_rt.jar=1160:C:\Program Files\JetBrains\IntelliJ IDEA 2020.2.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_201\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\rt.jar;D:\git\practice\practice\Java\target\classes;C:\Users\AlexWu\.m2\repository\com\alibaba\fastjson\1.2.54\fastjson-1.2.54.jar;C:\Users\AlexWu\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.10.1\jackson-core-2.10.1.jar;C:\Users\AlexWu\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.13.0\jackson-databind-2.13.0.jar;C:\Users\AlexWu\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.13.0\jackson-annotations-2.13.0.jar;C:\Users\AlexWu\.m2\repository\junit\junit\4.11\junit-4.11.jar;C:\Users\AlexWu\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\AlexWu\.m2\repository\com\google\guava\guava\21.0\guava-21.0.jar;C:\Users\AlexWu\.m2\repository\org\jetbrains\annotations\22.0.0\annotations-22.0.0.jar" Medium.CountDomainVisits
stackoverflow.com              10
com                          1345
sports.yahoo.com               50
google.com                    900
sports                          1
org                             3
wikipedia.org                   3
mobile.sports                   1
mail.yahoo.com                 60
en.wikipedia.org                2
mobile.sports.yahoo.com        10
uk                              1
yahoo.com                     410
com.com                         5
m.wikipedia.org                 1
google.co.uk                    1
co.uk                           1
overflow.com                   20

Process finished with exit code 0

     */
}
