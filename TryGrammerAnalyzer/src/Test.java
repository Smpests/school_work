import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qingsong
 * created at 2018/5/25
 */
public class Test {
    public static void main(String[] args) {
        Map<Character,Map<Character,String>> analyse = new HashMap<>();
        Map<Character,String> select1 = new HashMap<>();
        Map<Character,String> select2 = new HashMap<>();
        Map<Character,String> select3 = new HashMap<>();
        Map<Character,String> select4 = new HashMap<>();
        Map<Character,String> select5 = new HashMap<>();
        select1.put('i',"TK");
        select1.put('(',"TK");
        analyse.put('E',select1);
        select2.put('+',"+TK");
        select2.put(')',"ε");
        select2.put('#',"ε");
        analyse.put('K',select2);
        select3.put('i',"FL");
        select3.put('(',"FL");
        analyse.put('T',select3);
        select4.put('+',"ε");
        select4.put('*',"*FL");
        select4.put(')',"ε");
        select4.put('#',"ε");
        analyse.put('L',select4);
        select5.put('i',"i");
        select5.put('(',"(E)");
        analyse.put('F',select5);

        Analyzer analyzer = new Analyzer(analyse);
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入串(以'#'结束):");
        String input = scanner.nextLine().trim();
        analyzer.setStr(input);
        analyzer.setStartChar('E');
        analyzer.analyze();
        List<Production> analyzeProcess= analyzer.getAnalyzeProcess();
        System.out.println("序号\t分析栈\t  剩余字符串\t查表\t\t动作");
        for (Production p:analyzeProcess
             ) {
            System.out.printf("%-2s\t\t%-8s\t%-10s\t%-10s\t%-5s\n",p.getIndex(),p.getAnalyzeStackStr(),p.getStr(),p.getUseExpStr(),p.getAction());
        }
        if (analyzer.getBadNews()) {
            System.out.println("该输入串不是当前文法的一个句子");
        } else
            System.out.println("该输入串是当前文法的一个句子");
    }
}
