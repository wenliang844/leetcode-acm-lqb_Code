package ACM.每日一题leecode.第二波.leetcode.model;

import io.terminus.cwl.test.func.test.SurveyAnswerExport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈文亮
 * @date 2022/8/15 13:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    // 省略构造函数、Getter&Setter方法

    public static void main(String[] args) {
//        extracted();
        List<SurveyAnswerExport> sheetData = new ArrayList<>();
        sheetData.add(new SurveyAnswerExport());
        sheetData.add(new SurveyAnswerExport());
        List<SurveyAnswerExport> collect = sheetData.stream().map(surveyAnswerBO -> copyProperties(surveyAnswerBO)).collect(Collectors.toList());
        System.out.println(collect);
        List<SurveyAnswerExport> collect2 = sheetData.stream().map(Person::copyProperties).collect(Collectors.toList());
        System.out.println(collect2);
        List<SurveyAnswerExport> collect3 = new ArrayList<>();
        for (SurveyAnswerExport surveyAnswerBO : collect2) {
            SurveyAnswerExport surveyAnswerExport = copyProperties(surveyAnswerBO);
            collect3.add(surveyAnswerExport);
        }
        System.out.println(collect3);

    }

    private static SurveyAnswerExport copyProperties(SurveyAnswerExport surveyAnswerBO) {
        surveyAnswerBO.setMobile(surveyAnswerBO.getMobile()+"123");
        return surveyAnswerBO;
    }

    private static void extracted() {
        Person xiaoZhang = new Person();
        Person xiaoLi = new Person("p2");
        swap(xiaoZhang, xiaoLi);
        System.out.println("p1:" + xiaoZhang.getName());
        System.out.println("p2:" + xiaoLi.getName());

        Person p1 = new Person("===");
        getP(p1);
        System.out.println(p1);
    }

    public static void getP(Person p) {
        Person temp = new Person("---");
        p.setName(temp.getName());

    }
    public static void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;


        Person temp1 = new Person("ppp");
        person1 = temp1;

        System.out.println(temp);
        System.out.println(person1);
        System.out.println(person2);
    }
}
