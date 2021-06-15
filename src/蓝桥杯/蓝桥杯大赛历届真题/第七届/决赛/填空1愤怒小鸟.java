package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

public class 填空1愤怒小鸟 {
    /***
     "C:\Program Files\Java\jdk1.8.0_201\bin\java.exe" -javaagent:D:\Coding\IDEA_java\lib\idea_rt.jar=12609:D:\Coding\IDEA_java\bin -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_201\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_201\jre\lib\rt.jar;E:\java\ACMTemp\ACMTemp\out\production\ACMTemp;D:\Coding\java\maven_repository\junit\junit\4.12\junit-4.12.jar;D:\Coding\java\maven_repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;E:\java\ACMTemp\ACMTemp\src\ACM\ACM_20201116江西师大校选拔赛\ACM\lib\com.springsource.javax.mail-1.4.0.jar" 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛.填空1愤怒小鸟
     666.6666666666666
     444.4444444444444
     296.2962962962963
     197.5308641975309
     131.6872427983539
     87.7914951989026
     58.52766346593506
     39.01844231062338
     26.012294873748917
     17.34152991583261
     11.561019943888406
     7.707346629258938
     5.138231086172625
     3.4254873907817496
     2.2836582605211664
     1.5224388403474443
     1.0149592268982963
     0.6766394845988641
     18
     * @param args //9
     */
    public static void main(String[] args) {
        int count = 0;
        double length = 1000;
        double trainSpeed = 10;
        double birdSpeed = 50;

        boolean tranToB = true;
        while (true){
            length -= (length/60.0)*20.0;
            if (length>1){
                if (tranToB){
                    count++;
                    tranToB = !tranToB;
                }else {
                    tranToB = !tranToB;
                }
            }else {
                break;
            }

            System.out.println(length);
        }

        System.out.println(count);

    }
}
