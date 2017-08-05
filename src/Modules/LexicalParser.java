package Modules;

import Models.LexicalUnit;
import Models.TokenSets;
import java.util.ArrayList;

public class LexicalParser {

    ArrayList<LexicalUnit> Tokens;

    public LexicalParser(ArrayList<LexicalUnit> Tokens) {
        this.Tokens = Tokens;
    }

    public boolean ValidateSyntax() {

        if (Tokens.get(0).getToken() == TokenSets.Begin) {

            if (Tokens.get(Tokens.size() - 1).getToken() == TokenSets.EndCB) {

                for (int i = 1; i < Tokens.size() - 1; i++) {

                    if (Tokens.get(i).getToken() == TokenSets.DataType) {
                        if (Tokens.get(i + 4).getToken() == TokenSets.SemiC) {

                            if (Tokens.get(i + 2).getToken() != TokenSets.Equal) {

                                System.out.println("Assignment Operator Missing Near" + Tokens.get(i).getUnitName());
                            } else if (Tokens.get(i + 3).getToken() != TokenSets.Values) {
                                if (Tokens.get(i + 3).getToken() == TokenSets.Identifier) {
                                    boolean validin = false;
                                    for (int j = 0; j < (i + 3); j++) {
                                        if (Tokens.get(j).getUnitName().equals(Tokens.get(i + 3).getUnitName())) {
                                            validin = true;
                                        }
                                    }
                                    if (!validin) {
                                        System.out.println("Error not initialized");
                                    }
                                } else {

                                }
                            }
                        } else {
                            System.out.println("Missing SemiColon Near " + Tokens.get(i).getUnitName());
                        }

                    } else {
                      
                    }

                }
                return true;
            } else {
                System.out.println("The Program Should end with an }");
                return false;
            }
        } else {
            System.out.println("The Program Should begin with Start");
            return false;
        }

    }

}
