# DaoGen Quickstart #  

Refer to [changelog](changelog.md) for feature update.

Sample applications to lear usage of DaoGen framework.  

Index : 
1. Run the project
2. Configuration notes
3. DaoGen tutorial
4. Maven Plugin
5. Support for websphere liberty


## 1. Run the project ##

1. Add to a server (tested with tomcat9 / jdk9).  
2. Open one of the rest URL http://localhost:8080/fj-daogen-quickstart/jax-rs/person/load/deep/id/3  

NOTE: index page fj-daogen-quickstart contains a few api links  


## 2. Configuration notes ##

The project use an hqsldb in memory DB, so it doesn't require any further configuration.  

*2.1 Data base sample configuration*

DB configuration is in folder:  
src/main/resources/quickstart_db  
&nbsp;&nbsp; +quickstart-db-conn.properties   [contains database jdbc connection properties]  
&nbsp;&nbsp; +hsqldb  [contains database init script to work in (all files in this folder will be loaded to init db at startup]  
&nbsp;&nbsp;&nbsp;&nbsp;	+100_db_setup.sql [contains create schema, sequences etc]  
&nbsp;&nbsp;&nbsp;&nbsp;	+200_sample_db.sql [contains starting entity and relations, plus some records]  

*2.2 DaoGen configuration file

DaoGen configuration is in path :    
src/main/resources/daogen/daogen-config.xml   
The root element contains all the basic properties of generation.    
They are all set for this project, but you need to update some of them if you need to configure for another project (especially package name and source folder).  


## 3. DaoGen tutorial ##

Quick tutorial to add one entity to the project.  
All the files of this tutorial are, as an example, in folder src/test/resources/tutorial  

*3.1 Add entity configuration script*

For instance we will add an equipment table (src/main/resources/quickstart_db/hsqldb/300_equipment.sql) :   

```
CREATE TABLE daogen_quickstart.equipment (
	id BIGINT NOT NULL,
	id_owner BIGINT,
	id_creator BIGINT,
	creation_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NOT NULL,
	description VARCHAR(1024) NOT NULL,
	state BIGINT NOT NULL
);

ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_pk PRIMARY KEY ( id );
ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_fk1 FOREIGN KEY ( id_owner ) REFERENCES person ( id );
ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_fk2 FOREIGN KEY ( id_creator ) REFERENCES person ( id );

COMMENT ON TABLE daogen_quickstart.equipment IS 'equipments meta informations';
COMMENT ON COLUMN daogen_quickstart.equipment.id_owner IS 'Reference to owner';
COMMENT ON COLUMN daogen_quickstart.equipment.id_creator IS 'Reference to creator';
COMMENT ON COLUMN daogen_quickstart.equipment.creation_date IS 'equipment creation time';
COMMENT ON COLUMN daogen_quickstart.equipment.update_date IS 'equipment update time';
COMMENT ON COLUMN daogen_quickstart.equipment.description IS 'equipments description';
COMMENT ON COLUMN daogen_quickstart.equipment.state IS 'equipment state';

INSERT INTO daogen_quickstart.equipment VALUES ( 20, 1, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );
INSERT INTO daogen_quickstart.equipment VALUES ( 21, 2, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );
INSERT INTO daogen_quickstart.equipment VALUES ( 22, 3, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );
```

*3.2 Dump the configuration*

Run the main class src/main/test : 

`test.org.fugerit.java.daogen.quickstart.tools.DaogenDump`

This will dump the configuration, you can then copy paste from output the configuration of the new entity ( src/main/resources/daogen/daogen-config.xml from section 2.2 ) : 

```
  <entity catalog="PUBLIC" comments="equipments meta informations" foreignKeys="PUBLIC.DAOGEN_QUICKSTART.PERSON,PUBLIC.DAOGEN_QUICKSTART.PERSON" id="PUBLIC.DAOGEN_QUICKSTART.EQUIPMENT" name="EQUIPMENT" primaryKey="ID" schema="DAOGEN_QUICKSTART">
    <field comments="" id="ID" javaType="java.lang.Long" nullable="no" size="0" sqlType="-5" sqlTypeName="BIGINT"/>
    <field comments="Reference to owner" id="ID_OWNER" javaType="java.lang.Long" nullable="yes" size="0" sqlType="-5" sqlTypeName="BIGINT"/>
    <field comments="Reference to creator" id="ID_CREATOR" javaType="java.lang.Long" nullable="yes" size="0" sqlType="-5" sqlTypeName="BIGINT"/>
    <field comments="equipment creation time" id="CREATION_DATE" javaType="java.sql.Timestamp" nullable="no" size="0" sqlType="93" sqlTypeName="TIMESTAMP"/>
    <field comments="equipment update time" id="UPDATE_DATE" javaType="java.sql.Timestamp" nullable="no" size="0" sqlType="93" sqlTypeName="TIMESTAMP"/>
    <field comments="equipments description" id="DESCRIPTION" javaType="java.lang.String" nullable="no" size="1024" sqlType="12" sqlTypeName="VARCHAR"/>
    <field comments="equipment state" id="STATE" javaType="java.lang.Long" nullable="no" size="0" sqlType="-5" sqlTypeName="BIGINT"/>
  </entity>
```


*3.3 Code generation*

Run the main class src/test/java :

`test.org.fugerit.java.daogen.quickstart.tools.DaogenRun`

This will create all the files in the correct packages (es. ModelEquipment the model interface, LoadEquiment the REST service stup, and so on)  


package org.fugerit.java.daogen.quickstart.config;

import java.util.HashSet;
import java.util.Set;

*3.4 Add rest service configuration*

Add the newly built REST service LoadEquipment to jaxrs application : 

org.fugerit.java.daogen.quickstart.config.DaogenQuickstart  

```
public class DaogenQuickstart extends javax.ws.rs.core.Application {

	   public Set<Class<?>> getClasses() {
		      Set<Class<?>> s = new HashSet<Class<?>>();
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadPerson.class);
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadDocument.class);
		      s.add(org.fugerit.java.daogen.quickstart.impl.rest.load.LoadEquipment.class);
		      return s;
		}
	
}
```

*3.5 Test result*  

Start the application and test the service :   

http://localhost:8080/fj-daogen-quickstart/jax-rs/equipment/load/id/21    


## 4. Maven Plugin ##

Since version 0.1.7 is possibile to use the maven plugin to generate code.  

The activation happen with the 'fj-daogen:generate' goal :   

mvn clean install fj-daogen:generate  

Here is an example code :   

```
					<plugin>
						<groupId>org.fugerit.java</groupId>
						<artifactId>fj-daogen-maven-plugin</artifactId>
						<configuration>
							<daogen.config>${project.basedir}/src/main/resources/daogen/daogen-config.xml</daogen.config>
						</configuration>						
						<executions>
							<execution>
								<phase>compile</phase>
								<goals>
									<goal>generate</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
```
			
			
## 5. Support for websphere liberty ##

Is now possibile to run the quickstart on a standalone websphere liberty application server, activating the profile 'wlp'

To start the server : 
`mvn clean install liberty:run -P wlp`

To stop the server
`mvn liberty:stop -P wlp`

After starting the server, you can access the webapp at link [http://localhost:8080/fj-daogen-quickstart/](http://localhost:8080/fj-daogen-quickstart/)

The template for this profile is based on the sample websphere liberty project : 
[websphere liberty profile sample project](https://gitlab.com/fugerit-org/fj-sample-wlp)

The server configuration template is here : [src/main/freemarker/template/server_ftl.xml](src/main/freemarker/template/server_ftl.xml)  

NOTE: the template has been configured to use port 8080.
