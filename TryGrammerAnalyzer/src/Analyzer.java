import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qingsong
 * created at 2018/5/25
 */
public class Analyzer {
    //存放预测分析表
    private Map<Character,Map<Character,String>> table;
    public Analyzer(Map<Character,Map<Character,String>> table) {
        super();
        analyzeStatck = new Stack<Character>();
        //分析栈开始符
        analyzeStatck.push('#');
        this.table = table;
    }
    //存放每一步分析结果
    private ArrayList<Production> analyzeProcess;
    //文法开始符
    private Character startChar;
    //分析栈
    private Stack<Character> analyzeStatck;
    //剩余输入串
    private String str;
    //查表结果
    private String useExp;
    //分析过程中是否产生错误
    private boolean badNews;


    public ArrayList<Production> getAnalyzeProcess() {
        return analyzeProcess;
    }

    public void setAnalyzeProcess(ArrayList<Production> analyzeProduces) {
        this.analyzeProcess = analyzeProduces;
    }

    public Character getStartChar() {
        return startChar;
    }

    public void setStartChar(Character startChar) {
        this.startChar = startChar;
    }

    public Stack<Character> getAnalyzeStatck() {
        return analyzeStatck;
    }

    public void setAnalyzeStatck(Stack<Character> analyzeStatck) {
        this.analyzeStatck = analyzeStatck;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getUseExp() {
        return useExp;
    }

    public void setUseExp(String useExp) {
        this.useExp = useExp;
    }

    public boolean getBadNews() {
        return badNews;
    }

    public void setBadNews(boolean badNews) {
        this.badNews = badNews;
    }

    /*
     *  主要分析程序
     * */
    public void analyze() {
        badNews = false;
        analyzeProcess = new ArrayList<Production>();
        analyzeStatck.push(startChar);
        System.out.println("开始符:" + startChar);
        int index = 0;
        //分析栈不为空时循环
        while(!analyzeStatck.empty()) {
            index++;
            if(analyzeStatck.peek() != str.charAt(0)) {
                Production process = new Production();
                String nowUseExpStr = null;
                //预防空指针异常
                if (table.get(analyzeStatck.peek()) !=null )
                    nowUseExpStr = table.get(analyzeStatck.peek()).get(str.charAt(0));
                process.setIndex(index);
                //格式化输出栈内数据
                String[] strings = analyzeStatck.toString().split("[\\]\\[,]");
                StringBuffer stackStr = new StringBuffer(strings[0]);
                for (int i = 1;i < strings.length;i++)
                    if (!strings[i].equals(""))
                        stackStr.append(strings[i].trim());
                process.setAnalyzeStackStr(stackStr.toString());
                process.setStr(str);
                process.setAction("压栈");
                //null，未在表内查找对应产生式
                if (nowUseExpStr == null) {
                    process.setUseExpStr("false");
                    badNews = true;
                } else {
                    process.setUseExpStr(analyzeStatck.peek() + "->" + nowUseExpStr);
                }
                analyzeProcess.add(process);
                //栈顶出栈，查表结果反向入栈
                analyzeStatck.pop();
                if (nowUseExpStr != null && nowUseExpStr.charAt(0) != 'ε') {
                    for (int j = nowUseExpStr.length() - 1; j >= 0; j--) {
                        char currentChar = nowUseExpStr.charAt(j);
                        analyzeStatck.push(currentChar);
                    }
                }
            } else {
                //分析栈栈顶和输入串首位字符匹配
                Production process = new Production();
                process.setIndex(index);
                //格式化输出分析栈数据
                String[] strings = analyzeStatck.toString().split("[\\]\\[,]");
                StringBuffer stackStr = new StringBuffer(strings[0]);
                for (int i = 1;i < strings.length;i++)
                    if (!strings[i].equals(""))
                        stackStr.append(strings[i].trim());
                process.setAnalyzeStackStr(stackStr.toString());
                process.setStr(str);
                process.setAction("匹配");
                process.setUseExpStr("\"" + str.charAt(0) + "\"");
                analyzeProcess.add(process);
                //归约，移除分析栈栈顶和输入串首字符
                analyzeStatck.pop();
                str = str.substring(1);
            }
        }
    }
}
