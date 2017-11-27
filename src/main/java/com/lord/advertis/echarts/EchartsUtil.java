package com.lord.advertis.echarts;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.lord.advertis.domain.Browse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creatrd by Lord on 2017/11/27 0027.<br>
 */
public class EchartsUtil {

    public static String dataToBarOption(List<Browse> list){
        Option option = new Option();
        option.legend().data("访问量");
        option.toolbox().show(true).feature(Tool.dataView, Tool.saveAsImage, Tool.restore, Tool.magicType).right(110);
        option.tooltip().trigger(Trigger.item);
        option.xAxis(new CategoryAxis().data("星期一","星期二","星期三","星期四","星期五","星期六","星期日"));
        option.yAxis(new ValueAxis().boundaryGap(new Double[]{0.1, 0.1}).splitNumber(10));

        Bar bar = new Bar();
        List<Integer> dataList  = new ArrayList<Integer>();
        for (Browse browse: list){
            dataList.add(browse.getNumber());
        }

        bar.name("访问量").setData(dataList);
        option.series(bar);

        return GsonUtil.prettyFormat(option);
    }
}
