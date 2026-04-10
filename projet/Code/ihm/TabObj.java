package ihm;
import lib.*;

import java.io.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;



public class TabObj extends JPanel {

	private static final long serialVersionUID = 1L;

    public TabObj(Grille g) {
        super(new GridLayout(1, 0));

        // modele de donnees
        MyTableModel tableModel = new MyTableModel(g);

        // la JTable et ses parametres
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);

        // on ajoute un scroll
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // parametrage de la 1ere ligne = noms des colonnes
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        // parametrage de la 1ere colonne consacree a la numerotation des lignes
        TableColumn tm = table.getColumnModel().getColumn(0);
        tm.setPreferredWidth(tm.getPreferredWidth() * 2 / 3);
        tm.setCellRenderer(new PremiereColonneSpecificRenderer(Color.LIGHT_GRAY));

    }
}
