/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author vibhavi
 */
public class LexicalUnit implements Comparable<LexicalUnit> {

    private String UnitName;
    private int Position;
    private TokenSets Token;

    public TokenSets getToken() {
        return Token;
    }

    public void setToken(TokenSets Token) {
        this.Token = Token;
    }

    public LexicalUnit(String UnitName, int Position) {
        this.UnitName = UnitName;
        this.Position = Position;
    }

    public String getUnitName() {
        return UnitName;
    }

    public int getPosition() {
        return Position;
    }

   
    @Override
    public int compareTo(LexicalUnit o1) {
        if (this.getPosition()>o1.getPosition()) {
            return 1;
        } else {
            return -1;
        }
    }
}
