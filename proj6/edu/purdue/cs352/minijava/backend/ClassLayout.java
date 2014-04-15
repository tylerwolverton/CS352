package edu.purdue.cs352.minijava.backend;

import java.util.*;

import edu.purdue.cs352.minijava.ssa.*;

public class ClassLayout {
	
	static List<String> totalFieldList = new ArrayList<String>();
	
    // get the number of fields in an instance of this object
    public static int objectFields(SSAProgram prog, SSAClass cl) {
        // FILLIN
		
		while(cl != null)
		{
			Map<String, SSAField> fields = cl.getFields();
			
			for(Map.Entry<String, SSAField> field : fields.entrySet())
			{
				if(!totalFieldList.contains(field.getKey()))
				{
					totalFieldList.add(field.getKey());	
				}				
			}
			
			cl = cl.superclass(prog);
		}
		
		return totalFieldList.size();
    }

    // get the size of an object (its number of fields plus one for the vtable)
    public static int objectSize(SSAProgram prog, SSAClass cl) {
        // FILLIN
		return objectFields(prog, cl) + 1;
    }

    // get the offset of a field within an object
    public static int fieldOffset(SSAProgram prog, SSAClass cl, String field) {
        // FILLIN
		return totalFieldList.indexOf(field) + 1;
    }

    // a vtable
    public static class Vtable {
        public final List<String> methods;
        public final Map<String, Integer> methodOffsets;

        public Vtable(List<String> methods) {
            this.methods = methods;

            methodOffsets = new HashMap<String, Integer>();
            int off = 0;
            for (String m : methods)
                methodOffsets.put(m, off++);
        }
    }

    // get the complete vtable layout for this class
    public static Vtable getVtable(SSAProgram prog, SSAClass cl) {
        // FILLIN
    }

    // get the size of the vtable for a class
    public static int vtableSize(SSAProgram prog, SSAClass cl) {
        // FILLIN
    }

    // for a given method, get the implementing class
    public SSAClass getImplementor(SSAProgram prog, SSAClass cl, String method) {
        // FILLIN
    }
}
