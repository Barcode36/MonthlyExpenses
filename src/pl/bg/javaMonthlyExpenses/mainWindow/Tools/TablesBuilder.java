package pl.bg.javaMonthlyExpenses.mainWindow.Tools;

import javafx.scene.control.TableView;
import pl.bg.javaMonthlyExpenses.holder.Record;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.bg.javaMonthlyExpenses.mainWindow.functionInterfaces.ColumnsCreator;


import java.util.List;

class Tables <T,V> {

    private static String columnName;
    private static String field;


    public Tables(String columnName, String field) {

        this.columnName=columnName;
        this.field=field;
    }

    private void  columnsCreator  (ColumnsCreator columnsCreator) {

        TableColumn<T, V> column = new TableColumn<>(columnName);

        column.setCellValueFactory(new PropertyValueFactory<>(field));
        columnsCreator.columnsCreator(column);

    }

    public static void setTableView(Tables tables, TableView tableView) {

        tables.columnsCreator((newColumn)->tableView.getColumns().add(newColumn));

    }


    public static void buildTable(Tables tables, TableView tableView) {

        setTableView(getObject(tables),tableView);
    }

    public static Tables getObject(Tables tables) {


        return tables;
    }

    @Override
    public String toString() {
        return "column names " + columnName + " pole "  + field ;
    }
}



public class TablesBuilder {

    public static void buildMain(TableView tableView) {

        Tables.buildTable(new Tables<String, Record>("ID","main_id"),tableView);
        Tables.buildTable(new Tables<String, Record>("Konto","accountName"),tableView);
        Tables.buildTable(new Tables<Double,Record>("Kwota","amount"),tableView);
        Tables.buildTable(new Tables<String,Record>("Data","date"),tableView);
        Tables.buildTable(new Tables<String,Record>("Kategoria","categoryName"),tableView);
        Tables.buildTable(new Tables<String,Record>("Sklep","shopName"),tableView);
        Tables.buildTable(new Tables<String,Record>("Wspolne?","isCommon"),tableView);
    }
    public static void buildBalance(TableView tableView) {

        Tables.buildTable(new Tables<String,Record>("Konto","accountName"),tableView);
        Tables.buildTable(new Tables<Double,Record>("Wydano","balance"),tableView);
        Tables.buildTable(new Tables<Double,Record>("DlugoWspolne","debt"),tableView);
        Tables.buildTable(new Tables<Double,Record>("DlugDoOddania","finalResult"),tableView);
    }
    public static void buildDog(TableView tableView) {

        Tables.buildTable(new Tables<String,Record>("Konto","accountName"),tableView);
        Tables.buildTable(new Tables<Double,Record>("WydanoNaPsa","dogExpense"),tableView);
    }
    public static void buildMainWithoutId(TableView tableView) {

        Tables.buildTable(new Tables<String, Record>("Konto","accountName"),tableView);
        Tables.buildTable(new Tables<Double,Record>("Kwota","amount"),tableView);
        Tables.buildTable(new Tables<String,Record>("Data","date"),tableView);
        Tables.buildTable(new Tables<String,Record>("Kategoria","categoryName"),tableView);
        Tables.buildTable(new Tables<String,Record>("Sklep","shopName"),tableView);
        Tables.buildTable(new Tables<String,Record>("Wspolne?","isCommon"),tableView);
    }
    public static void buildExpenseAdd(TableView tableView) {
        Tables.buildTable(new Tables<String,Record>("Kategoria","categoryName"),tableView);
        Tables.buildTable(new Tables<Double,Record>("Wydano","amount"),tableView);
    }
}
