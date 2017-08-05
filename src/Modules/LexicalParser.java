package Modules;

import Models.LexicalUnit;
import Models.TokenSets;
import java.util.ArrayList;
import java.util.Stack;

public class LexicalParser {

    ArrayList<LexicalUnit> Tokens;

    public LexicalParser(ArrayList<LexicalUnit> Tokens) {
        this.Tokens = Tokens;
    }

    public boolean ValidateSyntax() {

        if (Tokens.get(0).getToken() == TokenSets.Begin) {
            
            if (Tokens.get(Tokens.size() - 1).getToken() == TokenSets.EndB) {

                for(int i=1;i<Tokens.size()-1;i++)
                {
                    
                }
                return true;
            } else {
                System.out.println("The Program Should end with Start");
                return false;
            }
        } else {
            System.out.println("The Program Should begin with Start");
            return false;
        }

    }

}
