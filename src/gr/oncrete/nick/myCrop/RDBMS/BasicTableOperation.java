/*
myBill, bills tracking program
Copyright (C) 2010  Nick Apostolakis

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * EmptyConstantTables.java
 *
 * Created on 8 Ιούλιος 2005, 10:53 πμ
 */
package gr.oncrete.nick.myCrop.RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import gr.oncrete.nick.myCrop.BusinessLogic.Config;

/**
 *
 * @author nickapos
 */
public class BasicTableOperation {
    //Config cfg = new Config ();
    //to format gia to inprocess connection einai file:path/database
    //DatabaseConnection d; not needed anymore since the databaseconnection has been made singleton
    //DatabaseConnection d= new DatabaseConnection ("hsql://localhost/");

    /** Creates a new instance of EmptyCOnstantTables */
    public BasicTableOperation() {
        //String databaseDir =cfg.getDataDirName ();
        //String databaseName = cfg.getDatabaseName ();
        //String fileSeparator = cfg.getFileSeparator ();
        //String connectString = "file:"+databaseDir+fileSeparator+databaseName;
        //String connectString = "file:"+"mydb";//for deployment purposes
        //String connectString="hsql://localhost/xdb";//for development purposes
        //DatabaseConnection.instance(connectString);
        this.initiateDBConnection();
    }

    protected void initiateDBConnection() {
        //String connectString="hsql://localhost/xdb";//for development purposes
        String connectString = "file:" + "mydb";//for deployment purposes
        DatabaseConnection.instance(connectString);
    }

    /**
     * A method that when called will terminate the database connection after commiting all changes
     *
     */
    public void closeConnection() {
        DatabaseConnection.commitTransaction();
        DatabaseConnection.shutdown();
    }
}
