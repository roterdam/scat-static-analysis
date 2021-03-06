package conversion.nodes;

import java.util.Collections;
import java.util.List;

import phpParser.*;
import conversion.Variable;


// *********************************************************************************
// CfgNodeExit *********************************************************************
// *********************************************************************************


// don't assign any transfer function other than ID to this node!
public class CfgNodeExit
extends CfgNode {

// CONSTRUCTORS ********************************************************************    

    public CfgNodeExit() {
        super();
    }

    public CfgNodeExit(ParseNode node) {
        super(node);
    }

// SET *****************************************************************************
    
    
// GET *****************************************************************************

    public List<Variable> getVariables() {
        return Collections.emptyList();
    }
    
//  SET ****************************************************************************

    public void replaceVariable(int index, Variable replacement) {
        // do nothing
    }

}


