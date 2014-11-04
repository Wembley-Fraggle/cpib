package ch.fhnw.cpib.parsing.tools;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.ITerminal;

public final class ParserTable {
    private List<INonTerminal> rowIndex;
    private List<IProductionNode> colIndex;
    private List<List<IProduction>> data;

    public ParserTable() {
        rowIndex = new LinkedList<>();
        colIndex = new LinkedList<>();
        data = new LinkedList<>();
    }

    public void addColumn(IProductionNode col) {
        colIndex.add(col);
    }

    public void addRow(INonTerminal row) {
        rowIndex.add(row);
        data.add(newRow());
    }

    public void addRow(IProductionNode col) {
        colIndex.add(col);
        normalizeRows();
    }

    public void  add(INonTerminal row, IProductionNode column,
            IProduction value) throws ParserException{
        int ri = rowIndex.indexOf(row);
        int ci = colIndex.indexOf(column);

        if (ri < 0) {
            throw new IllegalArgumentException("Unknown row: " + row.toString());
        }
        List<IProduction> theRow = data.get(ri);

        if (ci < 0) {
            throw new IllegalArgumentException("Unknown colum: "
                    + column.toString());
        }
        IProduction currentValue = theRow.get(ci);
        if(currentValue != null) {
            StringBuilder msg = new StringBuilder();
            msg.append("Ambigous entry. Duplicate entry in cell ");
            msg.append(row.getName()).append(column.getName());
            msg.append(". Existing value is ");
            msg.append(currentValue);
            throw new ParserException(msg.toString());
        }
        theRow.add(ci, value); 
    }

    public IProduction get(INonTerminal row, IProductionNode column) {
        int ri = rowIndex.indexOf(row);
        int ci = colIndex.indexOf(column);
        if (ri < 0) {
            throw new IllegalArgumentException("Unknown row: " + row.toString());
        }

        if (ci < 0) {
            throw new IllegalArgumentException("Unknown colum: "
                    + column.toString());
        }

        List<IProduction> dataRow = data.get(ri);
        return dataRow.get(ci);
    }

    private List<IProduction> newRow() {
        List<IProduction> result = new LinkedList<>();
        for (int i = 0; i < colIndex.size(); i++) {
            result.add(null);
        }
        return result;
    }

    private void normalizeRows() {
        for (List<IProduction> row : data) {
            while (row.size() < colIndex.size()) {
                row.add(null);
            }
        }
    }
}
