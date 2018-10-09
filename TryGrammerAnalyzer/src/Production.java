import java.io.Serializable;

/**
 * @author qingsong
 * created at 2018/5/25
 */
public class Production implements Serializable{
    private static final long serialVersionUID = 10L;
    //分析过程序号
    private Integer index;
    //分析栈数据
    private String analyzeStackStr;
    //剩余字符串
    private String str;
    //查表内容
    private String useExpStr;
    //动作
    private String action;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getAnalyzeStackStr() {
        return analyzeStackStr;
    }

    public void setAnalyzeStackStr(String analyzeStackStr) {
        this.analyzeStackStr = analyzeStackStr;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getUseExpStr() {
        return useExpStr;
    }

    public void setUseExpStr(String useExpStr) {
        this.useExpStr = useExpStr;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
