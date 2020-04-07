package com.bademo.equator;

import com.bademo.equator.sources.Equator;
import com.bademo.equator.sources.FieldBaseEquator;
import com.bademo.equator.sources.FieldInfo;
import com.bademo.equator.sources.GetterBaseEquator;

import java.util.List;

/**
 * @auther: Bin.L
 * @date: 2020/04/07 11:10
 * @Description: 用于比较两个对象的属性是否相等，并且可以获取所有不相等的属性的比对器
 */
public class EquatorTest {

    public static void main(String[] args) {

        Equator equator = new GetterBaseEquator();
        WorkVO[] construct = Construct();

        System.out.println(equator.isEquals(construct[0], construct[1]));

        // 基于get方法比较器
        List<FieldInfo> diffFields = equator.getDiffFields(construct[0], construct[1]);
        System.out.println(diffFields);

        // 基于属性比较器
        Equator equatorField = new FieldBaseEquator();
        System.out.println(equatorField.getDiffFields(construct[0], construct[1]));
    }


    private static WorkVO[] Construct() {

        WorkVO workA = new WorkVO();
        workA.setId("work-1111-2222");
        workA.setAppId("work-test-a");
        workA.setMpAppId("as");
        workA.setAgentId("bc");
        workA.setTxtId("8sfad-dfsd");
        workA.setTplName("号人");
        workA.setMsgType("一个小小");
        workA.setAgentName("好好学习");
        workA.setContent("说好的友谊那去啦");
        workA.setTplStatus("开始");


        WorkVO workB = new WorkVO();
        workB.setId("work-1111-2222");
        workB.setAppId("work-test-a");
        workB.setMpAppId("id-123");
        workB.setAgentId("cs-1232");
        workB.setTxtId("09123tx");
        workB.setTplName("雷神");
        workB.setMsgType("大大");
        workB.setAgentName("你猜");
        workB.setContent("说好的友谊那去啦");
        workB.setTplStatus("结束");

        return new WorkVO[]{workA, workB};
    }
}
