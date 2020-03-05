package com.amdc;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

import static com.amdc.Main.*;
import static java.awt.Color.DARK_GRAY;

public class CreatePanel extends JPanel {
        public CreatePanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 1, 0.33,
                    GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0);
            add(new SourcePane(), gbc);
            add(new DatabasePane(), gbc);
            add(new SystemDatabasePane(), gbc);
            add(new ActionPane(), new GridBagConstraints(1, 0, 1, GridBagConstraints.REMAINDER, 0, 1,
                    GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0,0));
        }

    public static class SourcePane extends JPanel {
        public SourcePane() {
            btnGroup.add(jRBAll);
            btnGroup.add(jRBOnly);
            jRBAll.setSelected(true);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 0, 0,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
            add(hostJL, gbc);
            add(jLabel2, gbc);
            add(jLabel3, gbc);
            add(jLabel4, gbc);
            add(jRBAll, gbc);
            gbc.gridx++;
            gbc.gridwidth = 3;
            add(hostJTF, gbc);
            add(startPort, gbc);
            add(endPort, gbc);
            add(timeOut, gbc);
            gbc.gridwidth = 1;
            add(jRBOnly, gbc);
            gbc.gridx = 2;
            gbc.gridy = 4;
            add(portJLabel, gbc);
            gbc.gridx = 3;
            add(portView, gbc);
        }
    }

    public static class DatabasePane extends JPanel {
        public DatabasePane() {
            setLayout(new GridBagLayout());
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Data from scanner", 0, 0, null, DARK_GRAY));
            GridBagConstraints gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 0, 4, 1, 0.25, 1,
                    GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0);
            add(new JScrollPane(jta), gbc); // Область текста
            DefaultCaret caret = (DefaultCaret)jta.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            jta.setLineWrap(true); // автоматически на новую строку после заполнения
            gbc.gridwidth = 1; // по одной "клетке"
            gbc.gridy++; // с новой строки
            gbc.fill = GridBagConstraints.HORIZONTAL; // заполнение по горизонтали
            add(btnStart, gbc);
            add(btnStop, gbc);
            add(btnColor, gbc);
            add(btnClear, gbc);
            btnClear.addActionListener(e-> jta.setText(""));
        }
    }

    public static class SystemDatabasePane extends JPanel {
        public SystemDatabasePane() {
            setLayout(new GridBagLayout());
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "System Database", 0, 0, null, DARK_GRAY));
            GridBagConstraints gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 0, 1, 1, 1, 0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0);
            ButtonGroup buttonGroup = new ButtonGroup();
            add(jrbNone, gbc);
            buttonGroup.add(jrbNone);
            add(jrbDB, gbc);
            jrbDB.setSelected(true);
            buttonGroup.add(jrbDB);
            add(btnSysBaseRead, gbc);
            add(btnSysBaseSave, gbc);
            jrbNone.addActionListener(e -> { btnSysBaseRead.setEnabled(false); btnSysBaseSave.setEnabled(false); });
            jrbDB.addActionListener(e -> { btnSysBaseRead.setEnabled(true); btnSysBaseSave.setEnabled(true); });
        }
    }

    public static class ActionPane extends JPanel {
        public ActionPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(0, GridBagConstraints.RELATIVE, GridBagConstraints.REMAINDER, 1, 1, 0,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
            add(btnOk, gbc);
            btnOk.setMnemonic('O');
            add(btnCancel, gbc);
            btnCancel.setMnemonic('C');
            add(btnHelp, gbc);
            btnHelp.setMnemonic('H');
            add(btnAdv, gbc);
            btnAdv.setMnemonic('A');
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.SOUTH;
            add(btnOptions, gbc);
            btnOptions.setMnemonic('p');
        }
    }
}
