/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modules.LexicalAnalyser;

/**
 *
 * @author vibhavi
 */
public class Start {

    public static void main(String[] args) {

        if (args.length == 0 || args[0].isEmpty()) {
            System.out.println("Compiler Error File not Given");
        } else if (args.length > 1) {
            System.out.println("Usage java -jar Mcompiler.jar filename.m");
        } else {
            LexicalAnalyser la = new LexicalAnalyser("D:\\MCompiler\\run\\hello.m");
            la.StartLexicalAnalyser();

        }
    }

}
