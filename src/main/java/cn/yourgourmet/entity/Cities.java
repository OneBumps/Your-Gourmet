package cn.yourgourmet.entity;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

public class Cities {

    public static String getCityList(String proId) {
        List<String> cityList = new ArrayList<String>();
        if (proId.equals("1")) {
            cityList.add("北京市");
        }
        if (proId.equals("2")) {
            cityList.add("天津市");
        }
        if (proId.equals("3")) {
            cityList.add("石家庄市");
            cityList.add("唐山市");
            cityList.add("秦皇岛市");
            cityList.add("邯郸市");
            cityList.add("邢台市");
            cityList.add("保定市");
            cityList.add("张家口市");
            cityList.add("承德市");
            cityList.add("沧州市");
            cityList.add("廊坊市");
            cityList.add("衡水市");
        }
        if (proId.equals("4")) {
            cityList.add("太原市");
            cityList.add("大同市");
            cityList.add("阳泉市");
            cityList.add("长治市");
            cityList.add("晋城市");
            cityList.add("朔州市");
            cityList.add("晋中市");
            cityList.add("运城市");
            cityList.add("忻州市");
            cityList.add("临汾市");
            cityList.add("吕梁市");
        }
        if (proId.equals("5")) {
            cityList.add("呼和浩特市");
            cityList.add("包头市");
            cityList.add("乌海市");
            cityList.add("赤峰市");
            cityList.add("通辽市");
            cityList.add("鄂尔多斯市");
            cityList.add("呼伦贝尔市");
            cityList.add("巴彦淖尔市");
            cityList.add("乌兰察布市");
            cityList.add("兴安盟");
            cityList.add("锡林郭勒盟");
            cityList.add("阿拉善盟");
        }
        if (proId.equals("6")) {
            cityList.add("沈阳市");
            cityList.add("大连市");
            cityList.add("鞍山市");
            cityList.add("抚顺市");
            cityList.add("本溪市");
            cityList.add("丹东市");
            cityList.add("锦州市");
            cityList.add("营口市");
            cityList.add("阜新市");
            cityList.add("辽阳市");
            cityList.add("盘锦市");
            cityList.add("铁岭市");
            cityList.add("朝阳市");
            cityList.add("葫芦岛市");
        }
        if (proId.equals("7")) {
            cityList.add("长春市");
            cityList.add("吉林市");
            cityList.add("四平市");
            cityList.add("辽源市");
            cityList.add("通化市");
            cityList.add("白山市");
            cityList.add("松原市");
            cityList.add("白城市");
            cityList.add("延边朝鲜族自治州");
        }
        if (proId.equals("8")) {
            cityList.add("哈尔滨市");
            cityList.add("齐齐哈尔市");
            cityList.add("鸡西市");
            cityList.add("鹤岗市");
            cityList.add("双鸭山市");
            cityList.add("大庆市");
            cityList.add("伊春市");
            cityList.add("佳木斯市");
            cityList.add("七台河市");
            cityList.add("牡丹江市");
            cityList.add("黑河市");
            cityList.add("绥化市");
            cityList.add("大兴安岭地区");
        }
        if (proId.equals("9")) {
            cityList.add("上海市");
        }
        if (proId.equals("10")) {
            cityList.add("南京市");
            cityList.add("无锡市");
            cityList.add("徐州市");
            cityList.add("常州市");
            cityList.add("苏州市");
            cityList.add("南通市");
            cityList.add("连云港市");
            cityList.add("淮安市");
            cityList.add("盐城市");
            cityList.add("扬州市");
            cityList.add("镇江市");
            cityList.add("泰州市");
            cityList.add("宿迁市");
        }
        if (proId.equals("11")) {
            cityList.add("杭州市");
            cityList.add("宁波市");
            cityList.add("温州市");
            cityList.add("嘉兴市");
            cityList.add("湖州市");
            cityList.add("绍兴市");
            cityList.add("金华市");
            cityList.add("衢州市");
            cityList.add("舟山市");
            cityList.add("台州市");
            cityList.add("丽水市");
        }
        if (proId.equals("12")) {
            cityList.add("合肥市");
            cityList.add("芜湖市");
            cityList.add("蚌埠市");
            cityList.add("淮南市");
            cityList.add("马鞍山市");
            cityList.add("淮北市");
            cityList.add("铜陵市");
            cityList.add("安庆市");
            cityList.add("黄山市");
            cityList.add("滁州市");
            cityList.add("阜阳市");
            cityList.add("宿州市");
            cityList.add("巢湖市");
            cityList.add("六安市");
            cityList.add("亳州市");
            cityList.add("池州市");
            cityList.add("宣城市");
        }
        if (proId.equals("13")) {
            cityList.add("福州市");
            cityList.add("厦门市");
            cityList.add("莆田市");
            cityList.add("三明市");
            cityList.add("泉州市");
            cityList.add("漳州市");
            cityList.add("南平市");
            cityList.add("龙岩市");
            cityList.add("宁德市");
        }
        if (proId.equals("14")) {
            cityList.add("南昌市");
            cityList.add("景德镇市");
            cityList.add("萍乡市");
            cityList.add("九江市");
            cityList.add("新余市");
            cityList.add("鹰潭市");
            cityList.add("赣州市");
            cityList.add("吉安市");
            cityList.add("宜春市");
            cityList.add("抚州市");
            cityList.add("上饶市");
        }
        if (proId.equals("15")) {
            cityList.add("济南市");
            cityList.add("青岛市");
            cityList.add("淄博市");
            cityList.add("枣庄市");
            cityList.add("东营市");
            cityList.add("烟台市");
            cityList.add("潍坊市");
            cityList.add("济宁市");
            cityList.add("泰安市");
            cityList.add("威海市");
            cityList.add("日照市");
            cityList.add("莱芜市");
            cityList.add("临沂市");
            cityList.add("德州市");
            cityList.add("聊城市");
            cityList.add("滨州市");
            cityList.add("菏泽市");
        }
        if (proId.equals("16")) {
            cityList.add("郑州市");
            cityList.add("开封市");
            cityList.add("洛阳市");
            cityList.add("平顶山市");
            cityList.add("安阳市");
            cityList.add("鹤壁市");
            cityList.add("新乡市");
            cityList.add("焦作市");
            cityList.add("濮阳市");
            cityList.add("许昌市");
            cityList.add("漯河市");
            cityList.add("三门峡市");
            cityList.add("南阳市");
            cityList.add("商丘市");
            cityList.add("信阳市");
            cityList.add("周口市");
            cityList.add("驻马店市");
            cityList.add("省直辖县级行政区划");
        }
        if (proId.equals("17")) {
            cityList.add("武汉市");
            cityList.add("黄石市");
            cityList.add("十堰市");
            cityList.add("宜昌市");
            cityList.add("襄阳市");
            cityList.add("鄂州市");
            cityList.add("荆门市");
            cityList.add("孝感市");
            cityList.add("荆州市");
            cityList.add("黄冈市");
            cityList.add("咸宁市");
            cityList.add("随州市");
            cityList.add("恩施土家族苗族自治州");
            cityList.add("省直辖县级行政区划");
        }
        if (proId.equals("18")) {
            cityList.add("长沙市");
            cityList.add("株洲市");
            cityList.add("湘潭市");
            cityList.add("衡阳市");
            cityList.add("邵阳市");
            cityList.add("岳阳市");
            cityList.add("常德市");
            cityList.add("张家界市");
            cityList.add("益阳市");
            cityList.add("郴州市");
            cityList.add("永州市");
            cityList.add("怀化市");
            cityList.add("娄底市");
            cityList.add("湘西土家族苗族自治州");
        }
        if (proId.equals("19")) {
            cityList.add("广州市");
            cityList.add("韶关市");
            cityList.add("深圳市");
            cityList.add("珠海市");
            cityList.add("汕头市");
            cityList.add("佛山市");
            cityList.add("江门市");
            cityList.add("湛江市");
            cityList.add("茂名市");
            cityList.add("肇庆市");
            cityList.add("惠州市");
            cityList.add("梅州市");
            cityList.add("汕尾市");
            cityList.add("河源市");
            cityList.add("阳江市");
            cityList.add("清远市");
            cityList.add("东莞市");
            cityList.add("中山市");
            cityList.add("潮州市");
            cityList.add("揭阳市");
            cityList.add("云浮市");
        }
        if (proId.equals("21")) {
            cityList.add("南宁市");
            cityList.add("柳州市");
            cityList.add("桂林市");
            cityList.add("梧州市");
            cityList.add("北海市");
            cityList.add("防城港市");
            cityList.add("钦州市");
            cityList.add("贵港市");
            cityList.add("玉林市");
            cityList.add("百色市");
            cityList.add("贺州市");
            cityList.add("河池市");
            cityList.add("来宾市");
            cityList.add("崇左市");
        }
        if (proId.equals("20")) {
            cityList.add("海口市");
            cityList.add("三亚市");
            cityList.add("三沙市");
            cityList.add("儋州市");
            cityList.add("省直辖县级行政区划");
        }
        if (proId.equals("27")) {
            cityList.add("重庆市");
        }
        if (proId.equals("28")) {
            cityList.add("成都市");
            cityList.add("自贡市");
            cityList.add("攀枝花市");
            cityList.add("泸州市");
            cityList.add("德阳市");
            cityList.add("绵阳市");
            cityList.add("广元市");
            cityList.add("遂宁市");
            cityList.add("内江市");
            cityList.add("乐山市");
            cityList.add("南充市");
            cityList.add("眉山市");
            cityList.add("宜宾市");
            cityList.add("广安市");
            cityList.add("达州市");
            cityList.add("雅安市");
            cityList.add("巴中市");
            cityList.add("资阳市");
            cityList.add("阿坝藏族羌族自治州");
            cityList.add("甘孜藏族自治州");
            cityList.add("凉山彝族自治州");
        }
        if (proId.equals("29")) {
            cityList.add("贵阳市");
            cityList.add("六盘水市");
            cityList.add("遵义市");
            cityList.add("安顺市");
            cityList.add("毕节市");
            cityList.add("铜仁市");
            cityList.add("黔西南布依族苗族自治州");
            cityList.add("黔东南苗族侗族自治州");
            cityList.add("黔南布依族苗族自治州");
        }
        if (proId.equals("30")) {
            cityList.add("昆明市");
            cityList.add("曲靖市");
            cityList.add("玉溪市");
            cityList.add("保山市");
            cityList.add("昭通市");
            cityList.add("丽江市");
            cityList.add("普洱市");
            cityList.add("临沧市");
            cityList.add("楚雄彝族自治州");
            cityList.add("红河哈尼族彝族自治州");
            cityList.add("文山壮族苗族自治州");
            cityList.add("西双版纳傣族自治州");
            cityList.add("大理白族自治州");
            cityList.add("德宏傣族景颇族自治州");
            cityList.add("怒江傈僳族自治州");
            cityList.add("迪庆藏族自治州");
        }
        if (proId.equals("31")) {
            cityList.add("拉萨市");
            cityList.add("日喀则市");
            cityList.add("昌都市");
            cityList.add("林芝市");
            cityList.add("山南市");
            cityList.add("那曲地区");
            cityList.add("阿里地区");
        }
        if (proId.equals("23")) {
            cityList.add("西安市");
            cityList.add("铜川市");
            cityList.add("宝鸡市");
            cityList.add("咸阳市");
            cityList.add("渭南市");
            cityList.add("延安市");
            cityList.add("汉中市");
            cityList.add("榆林市");
            cityList.add("安康市");
            cityList.add("商洛市");
        }
        if (proId.equals("22")) {
            cityList.add("兰州市");
            cityList.add("嘉峪关市");
            cityList.add("金昌市");
            cityList.add("白银市");
            cityList.add("天水市");
            cityList.add("武威市");
            cityList.add("张掖市");
            cityList.add("平凉市");
            cityList.add("酒泉市");
            cityList.add("庆阳市");
            cityList.add("定西市");
            cityList.add("陇南市");
            cityList.add("临夏回族自治州");
            cityList.add("甘南藏族自治州");
        }
        if (proId.equals("25")) {
            cityList.add("西宁市");
            cityList.add("海东市");
            cityList.add("海北藏族自治州");
            cityList.add("黄南藏族自治州");
            cityList.add("海南藏族自治州");
            cityList.add("果洛藏族自治州");
            cityList.add("玉树藏族自治州");
            cityList.add("海西蒙古族藏族自治州");
        }
        if (proId.equals("26")) {
            cityList.add("银川市");
            cityList.add("石嘴山市");
            cityList.add("吴忠市");
            cityList.add("固原市");
            cityList.add("中卫市");
        }
        if (proId.equals("24")) {
            cityList.add("乌鲁木齐市");
            cityList.add("克拉玛依市");
            cityList.add("吐鲁番市");
            cityList.add("哈密市");
            cityList.add("昌吉回族自治州");
            cityList.add("博尔塔拉蒙古自治州");
            cityList.add("巴音郭楞蒙古自治州");
            cityList.add("阿克苏地区");
            cityList.add("克孜勒苏柯尔克孜自治州");
            cityList.add("喀什地区");
            cityList.add("和田地区");
            cityList.add("伊犁哈萨克自治州");
            cityList.add("塔城地区");
            cityList.add("阿勒泰地区");
        }
        if (proId.equals("32")) {
            cityList.add("台北市");
            cityList.add("高雄市");
            cityList.add("基隆市");
            cityList.add("台中市");
            cityList.add("台南市");
            cityList.add("新竹市");
            cityList.add("嘉义市");
            cityList.add("台北县");
            cityList.add("宜兰县");
            cityList.add("桃园县");
            cityList.add("新竹县");
            cityList.add("苗栗县");
            cityList.add("台中县");
            cityList.add("彰化县");
            cityList.add("南投县");
            cityList.add("云林县");
            cityList.add("嘉义县");
            cityList.add("台南县");
            cityList.add("高雄县");
            cityList.add("屏东县");
            cityList.add("澎湖县");
            cityList.add("台东县");
            cityList.add("花莲县");
        }
        if (proId.equals("34")) {
            cityList.add("香港特别行政区");
        }
        if (proId.equals("33")) {
            cityList.add("澳门特别行政区");
        }
        return JSON.toJSONString(cityList);
    }
}
