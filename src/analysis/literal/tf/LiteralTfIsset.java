package analysis.literal.tf;

import java.util.*;

import analysis.LatticeElement;
import analysis.TransferFunction;
import analysis.literal.LiteralLatticeElement;
import conversion.Literal;
import conversion.TacPlace;
import conversion.Variable;

// transfer function for "isset" tests
// LATER: make it intelligent
public class LiteralTfIsset 
extends TransferFunction{
    
    private Variable setMe;
    private TacPlace testMe;
    
// *********************************************************************************    
// CONSTRUCTORS ********************************************************************
// *********************************************************************************     

    public LiteralTfIsset(TacPlace setMe, TacPlace testMe) {
        this.setMe = (Variable) setMe;  // must be a variable
        this.testMe = testMe;
    }

// *********************************************************************************    
// OTHER ***************************************************************************
// *********************************************************************************  

    public LatticeElement transfer(LatticeElement inX) {

        // System.out.println("transfer method: " + setMe + " = " + setTo);
        LiteralLatticeElement in = (LiteralLatticeElement) inX;
        LiteralLatticeElement out = new LiteralLatticeElement(in);

        if (!setMe.isTemp()) {
            throw new RuntimeException("SNH");
        }
        
        // not so intelligent, but sound;
        // "setMe" is a temporary variable, which has no aliases
        Set<Variable> mustAliases = new HashSet<Variable>();
        mustAliases.add(setMe);
        Set mayAliases = Collections.EMPTY_SET;
        out.assignSimple(setMe, Literal.TOP, mustAliases, mayAliases);
        
        return out;
    }
}
