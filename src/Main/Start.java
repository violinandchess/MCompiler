/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modules.LexicalAnalyser;
import Modules.LexicalParser;

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
            LexicalAnalyser la = new LexicalAnalyser(args[0]);
            la.StartLexicalAnalyser();
            LexicalParser parser=new LexicalParser(la.getLeximes());
            boolean status=parser.ValidateSyntax();
            if(status)
            {
                System.out.println("Parsed SuccessFully No Erros");
            }else
            {
                System.out.println("Parsing Errors");
            }

        }
    }

}
