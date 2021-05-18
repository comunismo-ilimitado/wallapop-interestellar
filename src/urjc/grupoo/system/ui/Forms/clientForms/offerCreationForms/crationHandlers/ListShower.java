package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.crationHandlers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import urjc.grupoo.data.shipsData.DefenceSystem;
import urjc.grupoo.data.shipsData.PropulsionType;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shipsData.Weapon;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.buttons.ShowShipButton;
import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class ListShower {

    private final SystemSession session;

    public ListShower(SystemSession session) {
        this.session = session;
    }

    private void addEntry(String text, JPanel displayList) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayList.add(panel, gbc, 0);
    }

    private void addShipButton(Spaceship ship, JPanel displayList) {
        JPanel panel = new JPanel();
        panel.add(new ShowShipButton(session, ship));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayList.add(panel, gbc, 0);
    }

    public void addPropulsions(JScrollPane panel, PropulsionType prop1, PropulsionType prop2) {
        JPanel propulsionList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        propulsionList.add(new JPanel(), gbc);
        panel.setViewportView(propulsionList);

        addEntry(prop1.getName(), propulsionList);
        addEntry(prop2.getName(), propulsionList);
    }

    public void addDefences(JScrollPane panel, ArrayList<DefenceSystem> list) {
        JPanel defencesList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        defencesList.add(new JPanel(), gbc);
        panel.setViewportView(defencesList);

        if (list != null) {
            list.forEach((defence) -> {
                addEntry(defence.getDefenceType() + " " + defence.getDamageAllowed() + " GJ", defencesList);
            });
        }
    }

    public void addWeapons(JScrollPane panel, ArrayList<Weapon> list) {
        JPanel weaponsList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        weaponsList.add(new JPanel(), gbc);
        panel.setViewportView(weaponsList);

        if (list != null) {
            list.forEach((weapon) -> {
                addEntry(weapon.getName() + " " + weapon.getPower() + " GJ", weaponsList);
            });
        }
    }

    public void addShips(JScrollPane panel, ArrayList<Spaceship> list) {
        JPanel shipsList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        shipsList.add(new JPanel(), gbc);
        panel.setViewportView(shipsList);

        if (list != null) {
            list.forEach((ship) -> {
                addEntry(ship.getType(), shipsList);
                addShipButton(ship, shipsList);
            });
        }
    }
}
