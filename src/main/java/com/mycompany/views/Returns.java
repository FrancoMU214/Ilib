package com.mycompany.views;

import com.mycompany.ilib.DAOBooksImpl;
import com.mycompany.ilib.DAOLendingsImpl;
import com.mycompany.ilib.DAOUsersImpl;
import com.mycompany.interfaces.DAOBooks;
import com.mycompany.interfaces.DAOLendings;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.utils.Utils;
import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Returns extends javax.swing.JPanel {

    private final int MAX_DAYS_RETURN = 5;
    private final int COST_DAY_SANC = 10;

    public Returns() {
        initComponents();
        InitStyles();
        setVisibleLabels(false);
    }

    private void setVisibleLabels(boolean visible) {

        lblTitle.setVisible(visible);
        lblTitleBook.setVisible(visible);
        lblDate.setVisible(visible);
        lblAuthor.setVisible(visible);
        lblCategory.setVisible(visible);
        lblEdit.setVisible(visible);
        lblLang.setVisible(visible);
        lblPags.setVisible(visible);
        lblTitleB.setVisible(visible);
        lblDateB.setVisible(visible);
        lblAuthorB.setVisible(visible);
        lblCategoryB.setVisible(visible);
        lblEditB.setVisible(visible);
        lblLangB.setVisible(visible);
        lblPagsB.setVisible(visible);
        lblDescription.setVisible(visible);
        cbtRun.setVisible(visible);
        cbtRun.setSelected(!visible);

    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        title.setForeground(Color.black);
        folioLbl.putClientProperty("FlatLaf.styleClass", "large");
        folioLbl.setForeground(Color.black);
        libroIdLbl.putClientProperty("FlatLaf.styleClass", "large");
        libroIdLbl.setForeground(Color.black);
        folioTxt.putClientProperty("JTextField.placeholderText", "Ingrese el folio del usuario.");
        libroIdTxt.putClientProperty("JTextField.placeholderText", "Ingrese el ID del Libro a devolver.");

        lblTitleBook.putClientProperty("FlatLaf.styleClass", "large");
        lblTitleBook.setForeground(Color.black);
        lblDate.putClientProperty("FlatLaf.styleClass", "large");
        lblDate.setForeground(Color.black);
        lblAuthor.putClientProperty("FlatLaf.styleClass", "large");
        lblAuthor.setForeground(Color.black);
        lblCategory.putClientProperty("FlatLaf.styleClass", "large");
        lblCategory.setForeground(Color.black);
        lblEdit.putClientProperty("FlatLaf.styleClass", "large");
        lblEdit.setForeground(Color.black);
        lblLang.putClientProperty("FlatLaf.styleClass", "large");
        lblLang.setForeground(Color.black);
        lblPags.putClientProperty("FlatLaf.styleClass", "large");
        lblPags.setForeground(Color.black);

        lblTitleB.putClientProperty("FlatLaf.styleClass", "large");
        lblTitleB.setForeground(Color.black);
        lblDateB.putClientProperty("FlatLaf.styleClass", "large");
        lblDateB.setForeground(Color.black);
        lblAuthorB.putClientProperty("FlatLaf.styleClass", "large");
        lblAuthorB.setForeground(Color.black);
        lblCategoryB.putClientProperty("FlatLaf.styleClass", "large");
        lblCategoryB.setForeground(Color.black);
        lblEditB.putClientProperty("FlatLaf.styleClass", "large");
        lblEditB.setForeground(Color.black);
        lblLangB.putClientProperty("FlatLaf.styleClass", "large");
        lblLangB.setForeground(Color.black);
        lblPagsB.putClientProperty("FlatLaf.styleClass", "large");
        lblPagsB.setForeground(Color.black);
        lblDescription.putClientProperty("FlatLaf.styleClass", "large");
        lblDescription.setForeground(Color.black);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        folioLbl = new javax.swing.JLabel();
        folioTxt = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        libroIdTxt = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblLang = new javax.swing.JLabel();
        cbtRun = new javax.swing.JRadioButton();
        lblPags = new javax.swing.JLabel();
        lblTitleB = new javax.swing.JLabel();
        lblDateB = new javax.swing.JLabel();
        lblAuthorB = new javax.swing.JLabel();
        lblTitleBook = new javax.swing.JLabel();
        lblCategoryB = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblEditB = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblLangB = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblPagsB = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        title.setText("Devolución de Libro");

        folioLbl.setText("Folio Usuario");

        folioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                folioTxtKeyTyped(evt);
            }
        });

        libroIdLbl.setText("Libro ID");

        libroIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                libroIdTxtKeyTyped(evt);
            }
        });

        button.setBackground(new java.awt.Color(18, 90, 173));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Devolver");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblLang.setText("Idioma");

        cbtRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtRunActionPerformed(evt);
            }
        });

        lblPags.setText("Paginas");

        lblTitleB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDateB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblAuthorB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblTitleBook.setText("Titulo");

        lblCategoryB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDate.setText("Fecha de Pub");

        lblEditB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblTitle.setText("Datos del Libro");

        lblLangB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblAuthor.setText("Autor");

        lblPagsB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblCategory.setText("Categoria");

        lblEdit.setText("Edicion");

        lblDescription.setText("Selecciona si es el libro que buscas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPags, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitleB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAuthorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCategoryB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEditB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLangB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPagsB, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescription)
                        .addGap(96, 96, 96)
                        .addComponent(cbtRun))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitleBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitleB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDateB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAuthorB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCategoryB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEditB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLangB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagsB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPags))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescription)
                    .addComponent(cbtRun))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(199, 199, 199))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(167, 167, 167))
                    .addComponent(folioTxt)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(223, 223, 223))
                    .addComponent(libroIdTxt)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63)
                                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(folioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(libroIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGap(69, 69, 69))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        String folio = folioTxt.getText();
        String bookId = libroIdTxt.getText();

        // Validaciones para los campos
        if (folio.isEmpty() || bookId.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        } else if (!Utils.isNumeric(folio) || !Utils.isNumeric(bookId)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Los campos Folio y el ID del libro deben ser números enteros. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        } else if (Integer.parseInt(folio) <= 0 || Integer.parseInt(bookId) <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Los campos Folio y el ID del libro deben ser mayor que 0. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        }

        try {
            DAOUsers daoUsers = new DAOUsersImpl();

            // Validamos existencia del usuario
            com.mycompany.models.Users currentUser = daoUsers.getUserById(Integer.parseInt(folio));
            if (currentUser == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún usuario con ese folio. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                folioTxt.requestFocus();
                return;
            }

            DAOBooks daoBooks = new DAOBooksImpl();

            // Validamos existencia del libro
            com.mycompany.models.Books currentBook = daoBooks.getBookById(Integer.parseInt(bookId));
            if (currentBook == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún libro con ese ID. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                libroIdTxt.requestFocus();
                return;
            }

            DAOLendings daoLendings = new DAOLendingsImpl();

            // Validamos que el usuario tenga ese libro prestado.
            com.mycompany.models.Lendings currentLending = daoLendings.getLending(currentUser, currentBook);
            if (currentLending == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se ha podido encontrar el préstamo correspiendote a los datos ingresados. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                libroIdTxt.requestFocus();
                return;
            }
            if (cbtRun.isSelected() && cbtRun.isVisible()) {
                // Todo OK: Devolvemos libro.
                currentLending.setDate_return(Utils.getFechaActual());
                daoLendings.modificar(currentLending);

                // Modificamos el libro sumandole 1 en disponibilidad.
                currentBook.setAvailable(currentBook.getAvailable() + 1);
                daoBooks.modificar(currentBook);

                javax.swing.JOptionPane.showMessageDialog(this, "Libro ID: " + currentBook.getId() + " devuelto exitosamente por " + currentUser.getName() + ".\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                folioTxt.setText("");
                libroIdTxt.setText("");

                // Verificamos sanciones
                int days = Utils.diferenciasDeFechas(Utils.stringToDate(currentLending.getDate_out()), new Date());
                if (days > MAX_DAYS_RETURN) {
                    int daysDelayed = days - MAX_DAYS_RETURN;
                    int sancMoney = daysDelayed * COST_DAY_SANC;

                    // Aumentamos sanción del usuario y en dinero.
                    currentUser.setSanctions(currentUser.getSanctions() + 1);
                    currentUser.setSanc_money(currentUser.getSanc_money() + sancMoney);
                    daoUsers.sancionar(currentUser);
                    javax.swing.JOptionPane.showMessageDialog(this, "¡USUARIO SANCIONADO POR ENTREGA A DESTIEMPO! ($" + sancMoney + ") \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                }
                folioTxt.setText("");
                libroIdTxt.setText("");
                setVisibleLabels(false);
                lblTitleB.setText("");
                lblDateB.setText("");
                lblAuthorB.setText("");
                lblCategoryB.setText("");
                lblEditB.setText("");
                lblLangB.setText("");
                lblPagsB.setText("");
                setVisibleLabels(false);
            } else {
                setVisibleLabels(true);

                try {

                    currentLending = daoLendings.getLending(currentUser, currentBook);
                    if (currentLending == null) {
                        javax.swing.JOptionPane.showMessageDialog(this, "No se ha podido encontrar el préstamo correspiendote a los datos ingresados. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                        libroIdTxt.requestFocus();
                        return;
                    }

                    lblTitleB.setText(currentBook.getTitle());
                    lblDateB.setText(currentBook.getDate());
                    lblAuthorB.setText(currentBook.getAuthor());
                    lblCategoryB.setText(currentBook.getCategory());
                    lblEditB.setText(currentBook.getEdit());
                    lblLangB.setText(currentBook.getLang());
                    lblPagsB.setText(currentBook.getPages());

                } catch (Exception ex) {
                    Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al prestar el libro. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_buttonActionPerformed

    private void cbtRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtRunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtRunActionPerformed

    private void folioTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_folioTxtKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignorar la entrada de caracteres no deseados
        }
    }//GEN-LAST:event_folioTxtKeyTyped

    private void libroIdTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_libroIdTxtKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignorar la entrada de caracteres no deseados
        }
    }//GEN-LAST:event_libroIdTxtKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JRadioButton cbtRun;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JTextField folioTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblAuthorB;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryB;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateB;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblEditB;
    private javax.swing.JLabel lblLang;
    private javax.swing.JLabel lblLangB;
    private javax.swing.JLabel lblPags;
    private javax.swing.JLabel lblPagsB;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleB;
    private javax.swing.JLabel lblTitleBook;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JTextField libroIdTxt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}