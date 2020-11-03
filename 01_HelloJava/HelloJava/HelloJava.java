/* 
    java规范的三种注释方式
    1、单行注释
    2、多行注释
    3、文档注释
    重点：文档注释的内容可以被jdk提供的工具javadoc所解析，生成一套以网页文件形式体现的该程序的说明文档
*/
/**
 * @author yaowenzhou@foxmail.com
 * @version v 0.01 这是一个文档注释，格式开头为 “/**” 构成首行 尾行和多行注释相同
 */

public class HelloJava {
    /*
     * 如下的main方法时程序的入口 main 方法的格式是固定的，这是一个多行注释
     */
    public static void main(String[] args) {
        // 这是单行注释，如下的语句表示输出到控制台
        System.out.println("Hello Java!");
    }
}