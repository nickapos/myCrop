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
 * TransactionOperations.java
 *
 * Created on 12 Ιούλιος 2005, 11:27 πμ
 */

package gr.oncrete.nick.myCrop.RDBMS;
import java.sql.SQLException;
import java.util.ArrayList;
import gr.oncrete.nick.myCrop.UserInterface.PopupMessageFrame;
/**
 *
 * @author nickapos
 *
 *
 *This class is used when we want to execute a block of SQL
 *commands as a transaction block. We execute the commands using
 *the query and update methods and then the transactional methods
 *to commit or rollback.
 */
public class TransactionSQLOperations extends BasicTableOperation
{
   
   /** Creates a new instance of TransactionOperations */
   public TransactionSQLOperations ()
   {
       super.initiateDBConnection();
      this.setAutoCommitOff ();//begin a transactional block.
   }
   
   public void executeUpdate (String update)
   {
      try
      {
         DatabaseConnection.update (update);
      }
      catch (SQLException sqle)
      {
         this.rollbackTransaction ();
         PopupMessageFrame mes = new PopupMessageFrame();
         String warning = "Empty during update. Possible conflict with existing values.";
         mes.setWarning (warning);
         sqle.printStackTrace ();
         System.exit(1);//since we had a conflict exit
      }
   }
   
   public ArrayList executeQuery(String query)
   {
      ArrayList list = null;
      try
      {
         list = DatabaseConnection.queryReturnResult (query);
      }
      catch (SQLException sqle)
      {
         this.rollbackTransaction ();
         sqle.printStackTrace ();
      }
      return list;
   }
   
   public void setAutoCommitOff ()
   {
      DatabaseConnection.setAutoCommitOff ();
   }
   
   public void commitTransaction ()
   {
      DatabaseConnection.commitTransaction ();
   }
   
   public void rollbackTransaction ()
   {
      DatabaseConnection.rollbackTransaction ();
   }
   
}
