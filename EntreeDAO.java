package restaurantsoftware;

/**
 *
 * @author kiran_000
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kiran_000
 */
public class EntreeDAO  {

    Connection connection;

    public EntreeDAO() throws SQLException {
        connection = DBConnector.getConnection();

        if (connection == null) {
            System.out.println("ItemDAO: Connection to DB Failed");
            System.exit(1);
        }
    }

    public Item searchItem(String Item) throws SQLException, ClassNotFoundException {
        //declare PreparedStatement & ResultSet
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Declare a SELECT statement
        String selectQuery = "SELECT ITEM_NAME,PRICE,time_req  from `menu`.`entree` where id =" + Item;

        //Execute SELECT statement
        try {
            //initializing PreparedStatement
            preparedStatement = connection.prepareStatement(selectQuery);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            //Send ResultSet to the getSalesDataFromResultSet method and get Item object
            Item item = getItemFromResultSet(resultSet);

            //Return Item object
            return item;
        } catch (Exception e) {
            System.out.println("While searching an Item with " + Item + " id, an error occurred: " + e);
            //Return exception
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    //Use ResultSet from DB as parameter and set Item ObjecSalesDatat's attributes and return Item object.
    private Item getItemFromResultSet(ResultSet resultSet) throws SQLException {
        //sets data to ObservableList based on columns from database
        Item item = new Item();
        //sales table
        item.setName(resultSet.getString(2));

        item.setPrice(resultSet.getString(3));
        //item.setId(resultSet.getString(1));

        item.setTime(resultSet.getString(4));

        return item;
    }

    //*******************************
    //SELECT Item
    //*******************************
    public ObservableList<Item> searchItem() throws SQLException, ClassNotFoundException {
        //declare PreparedStatement & ResultSet
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Declare a SELECT statement
        String selectQuery = "SELECT ITEM_NAME , PRICE , time_req from entree ";

        //Execute SELECT statement
        try {
            //initializing PreparedStatement
            preparedStatement = connection.prepareStatement(selectQuery);
            //initializing ResultSet via SqliteConnection method
            resultSet = preparedStatement.executeQuery();

            //Send ResultSet to the getItemsList method and get Item object
            ObservableList<Item> ItemList = getItemsList(resultSet);

            //Return Item object
            return ItemList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    //Select * from Item operation
    private static ObservableList<Item> getItemsList(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Item objects
        ObservableList<Item> items_listDatas = FXCollections.observableArrayList();

        while (resultSet.next()) {
            Item item = new Item();
            //sales table
            //item.setId(resultSet.getString("id"));
            item.setName(resultSet.getString("ITEM_NAME"));
            item.setPrice(resultSet.getString("PRICE"));
            item.setTime(resultSet.getString("time_req"));

            items_listDatas.add(item);
        }
        //return item_List (ObservableList of Item)
        return items_listDatas;
    }

    //*************************************
    //UPDATE Item 
    //*************************************
    public void updateItem(Item item) throws SQLException, ClassNotFoundException {
        //declare PreparedStatement & ResultSet
        PreparedStatement preparedStatement = null;

        //Declare a UPDATE statement
        String updateQuery
                = " UPDATE item set \n"
              //  + " id = ?, \n "
                + " ITEM_NAME = ?, \n"
                + " PRICE = ?, \n "
                + " time_req = ?, \n";

        //Execute UPDATE operation
        try {
            preparedStatement = connection.prepareStatement(updateQuery);

         //   preparedStatement.setString(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getPrice());
            preparedStatement.setString(4, item.getTime());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //*************************************
    //DELETE a Item
    //*************************************
    public void deleteItemWithId(Item item) throws SQLException, ClassNotFoundException {
        //initializing PreparedStatement
        PreparedStatement preparedStatement = null;
        //Declare a DELETE Item
        String updateQuery
                = "   DELETE FROM entree \n"
                + "   WHERE id = ?";

        //Execute UPDATE operation
        try {
            preparedStatement = connection.prepareStatement(updateQuery);

           // preparedStatement.setString(1, item.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //*************************************
    //INSERT Item
    //*************************************
    public void insertItem(Item item) throws SQLException, ClassNotFoundException {
        //initializing PreparedStatement
        PreparedStatement preparedStatement = null;
        //Declare a DELETE Item
        String updateQuery
                = "INSERT INTO entree \n"
                + "( ITEM_NAME, PRICE,time_req) values (? ,?,? ,?  )";

        //Execute DELETE operation
        try {
            preparedStatement = connection.prepareStatement(updateQuery);

            //preparedStatement.setString(1, salesData.getDate());
           // preparedStatement.setString(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getPrice());
            preparedStatement.setString(4, item.getTime());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Item getItem = new Item();
//            System.out.println("getItem.size()  " + getItem.size());
            //getItem.setId("KOKOKOKOKO");
            //getItem.setPRICE(3733.9999);
            new EntreeDAO().insertItem(getItem);

        } catch (SQLException ex) {
            Logger.getLogger(EntreeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntreeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}