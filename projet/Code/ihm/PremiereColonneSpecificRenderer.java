package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


// Fourni: ne rien changer.
class PremiereColonneSpecificRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    Color couleur;

    public PremiereColonneSpecificRenderer(Color couleur) {
        super();
        this.couleur = couleur;
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBackground(couleur);

        return cell;
    }
}
