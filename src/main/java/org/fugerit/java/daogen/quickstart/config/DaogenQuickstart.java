package org.fugerit.java.daogen.quickstart.config;

import java.util.HashSet;
import java.util.Set;

public class DaogenQuickstart extends javax.ws.rs.core.Application {

	   public Set<Class<?>> getClasses() {
		      Set<Class<?>> s = new HashSet<Class<?>>();
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadPerson.class);
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadDocument.class);
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadMappedTable.class);
		      return s;
		}
	
}
