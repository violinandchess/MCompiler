/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import Models.LexicalUnit;
import Models.TokenSets;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vibhavi
 */
public class LexicalAnalyser {

    private final String FileName;
    private final String LeximeRegEx[] = {"Start", "\\{", "\\}", "\\(", "\\)", ";",
        "=", "<", "[+]{2,2}", "[+]{1,1}", "int", "\\d+(?:\\.\\d+|)",
        "float", "for", "[a-z|A-z|_][A-z|a-z|0-9]*"};

    private final ArrayList<LexicalUnit> Leximes;

    public String getFileName() {
        return FileName;
    }

    public LexicalAnalyser(String FileName) {
        this.FileName = FileName;
        Leximes = new ArrayList<>();

    }

    public void StartLexicalAnalyser() {

        try (InputStream is = new FileInputStream(FileName)) {
            int size = is.available();

            String rawString = "";
            for (int i = 0; i < size; i++) {
                rawString += (char) is.read();
            }
            //System.out.println("" + rawString);
            GenarateLexicalUnits(rawString);
        } catch (IOException exception) {
            System.out.println("Compiler Error File found");
        }
    }

    public void GenarateLexicalUnits(String rawString) {

        try {

            String copy = rawString;
            for (int i = 0; i < LeximeRegEx.length; i++) {
                String expression = LeximeRegEx[i];
                Pattern p = Pattern.compile(expression);
                Matcher m = p.matcher(copy);

                while (m.find()) {
                    int pattenold = m.start();
                    int pattenend = m.end();
                    switch (i) {
                        case 8:
                            String ch = copy.charAt(pattenend) + "";
                            String ch2 = copy.charAt(pattenold - 1) + "";
                            String d = m.group();
                            boolean t = ch.equals("+");
                            if (!ch.equals("+") && !ch2.equals("+")) {
                                LexicalUnit unit = new LexicalUnit(m.group(), m.start());
                                unit.setToken(TokenSets.PP);
                                Leximes.add(unit);
                                
                            }   break;
                        case 14:
                            String check = copy.substring(pattenold, pattenend);
                            boolean found = false;
                            for (LexicalUnit temp : Leximes) {
                                if (temp.getUnitName().equals(check)) {
                                    found = true;
                                }
                                
                            }   if (found == false) {
                                
                                LexicalUnit unit = new LexicalUnit(m.group(), m.start());
                                unit.setToken(TokenSets.Identifier);
                                Leximes.add(unit);
                                
                            }   break;
                        default:
                            LexicalUnit unit = new LexicalUnit(m.group(), m.start());
                            switch (i) {
                                case 0:
                                    unit.setToken(TokenSets.Begin);
                                    break;
                                case 1:
                                    unit.setToken(TokenSets.StartCB);
                                    break;
                                case 2:
                                    unit.setToken(TokenSets.EndCB);
                                    break;
                                case 3:
                                    unit.setToken(TokenSets.StartB);
                                    break;
                                case 4:
                                    unit.setToken(TokenSets.EndB);
                                    break;
                                case 5:
                                    unit.setToken(TokenSets.SemiC);
                                    break;
                                case 6:
                                    unit.setToken(TokenSets.Equal);
                                    break;
                                case 7:
                                    unit.setToken(TokenSets.LessT);
                                    break;
                                case 9:
                                    unit.setToken(TokenSets.Plus);
                                    break;
                                    
                                    
                                case 11:
                                    unit.setToken(TokenSets.Values);
                                    break;
                                case 10:
                                case 12:
                                case 13:
                                    unit.setToken(TokenSets.DataType);
                                    break;
                                case 14: unit.setToken(TokenSets.Identifier);
                                break;
                                
                                
                                
                            }   Leximes.add(unit);
                            break;
                    }

                }

            }
        } catch (Exception ex) {
            System.out.println("ex" + ex.getMessage());
        }

        PrintTokens();
    }

    public void PrintTokens() {

        Collections.sort(Leximes);


        Leximes.forEach((x) -> {
            System.out.println(" " + x.getUnitName()+ " "+x.getToken());
        });
    }

    public ArrayList<LexicalUnit> getLeximes() {
        return Leximes;
    }
    

}
