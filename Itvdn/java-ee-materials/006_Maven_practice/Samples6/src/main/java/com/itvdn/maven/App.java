package com.itvdn.maven;


import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(StringEscapeUtils.escapeHtml4("<p>Hello World!</p>"));
    }

}
