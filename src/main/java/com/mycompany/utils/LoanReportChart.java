/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

/**
 *
 * @author 52951
 */
import com.mycompany.ilib.DAOBooksImpl;
import com.mycompany.ilib.DAOLendingsImpl;
import com.mycompany.ilib.DAOUsersImpl;
import com.mycompany.interfaces.DAOBooks;
import com.mycompany.interfaces.DAOLendings;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Lendings;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LoanReportChart extends ApplicationFrame {

    public LoanReportChart(String title) throws Exception {
        super(title);

        // Crear un dataset
        CategoryDataset dataset = createDataset();

        // Crear un gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "Reportes de préstamos",
                "Categoría",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Personalizar el gráfico
        chart.setBackgroundPaint(Color.white);

        // Personalizar el plot del gráfico
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);

        // Crear una paleta de colores azul cielo
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        Color[] colors = new Color[]{
            new Color(135, 206, 250), // Azul cielo claro
            new Color(0, 191, 255), // Azul cielo medio
            new Color(70, 130, 180), // Azul acero
            new Color(25, 25, 112) // Azul medianoche
        };
        for (int i = 0; i < colors.length; i++) {
            renderer.setSeriesPaint(i, colors[i]);
        }

        // Crear un panel de gráficos
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
        
        
    }

    private CategoryDataset createDataset() throws Exception {
        try{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DAOLendings dao = new DAOLendingsImpl();
        List<Lendings> lendings = dao.listar();
        Map<Integer, Integer> userLoanCounts = new HashMap<>();
        Map<Integer, Integer> bookLoanCounts = new HashMap<>();

        for (Lendings report : lendings) {
            userLoanCounts.put(report.getUser_id(), userLoanCounts.getOrDefault(report.getUser_id(), 0) + 1);
            bookLoanCounts.put(report.getBook_id(), bookLoanCounts.getOrDefault(report.getBook_id(), 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> sortedUsers = userLoanCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        List<Map.Entry<Integer, Integer>> sortedBooks = bookLoanCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        int mostLoansUserId = sortedUsers.get(0).getKey();
        int mostLoansUserCount = sortedUsers.get(0).getValue();
        int secondMostLoansUserId = sortedUsers.size() > 1 ? sortedUsers.get(1).getKey() : -1;
        int secondMostLoansUserCount = sortedUsers.size() > 1 ? sortedUsers.get(1).getValue() : -1;

        int leastLoansUserId = sortedUsers.get(sortedUsers.size() - 1).getKey();
        int leastLoansUserCount = sortedUsers.get(sortedUsers.size() - 1).getValue();
        int secondLeastLoansUserId = sortedUsers.size() > 1 ? sortedUsers.get(sortedUsers.size() - 2).getKey() : -1;
        int secondLeastLoansUserCount = sortedUsers.size() > 1 ? sortedUsers.get(sortedUsers.size() - 2).getValue() : -1;

        int mostLoansBookId = sortedBooks.get(0).getKey();
        int mostLoansBookCount = sortedBooks.get(0).getValue();
        int secondMostLoansBookId = sortedBooks.size() > 1 ? sortedBooks.get(1).getKey() : -1;
        int secondMostLoansBookCount = sortedBooks.size() > 1 ? sortedBooks.get(1).getValue() : -1;

        int leastLoansBookId = sortedBooks.get(sortedBooks.size() - 1).getKey();
        int leastLoansBookCount = sortedBooks.get(sortedBooks.size() - 1).getValue();
        int secondLeastLoansBookId = sortedBooks.size() > 1 ? sortedBooks.get(sortedBooks.size() - 2).getKey() : -1;
        int secondLeastLoansBookCount = sortedBooks.size() > 1 ? sortedBooks.get(sortedBooks.size() - 2).getValue() : -1;
        DAOBooks daoBook = new DAOBooksImpl();
        DAOUsers daoUser = new DAOUsersImpl();

        //com.mycompany.models.Users user = daoUser.listarId(folioTxt.getText()).get(0);
        //com.mycompany.models.Books book = daoBook.listarId(libroIdTxt.getText()).get(0);

        // Datos de libros más prestados
        dataset.addValue(mostLoansBookCount, "Libros más prestados", daoBook.listarId(mostLoansBookId+"").get(0).getTitle());
        dataset.addValue(secondMostLoansBookCount, "Libros más prestados", daoBook.listarId(secondMostLoansBookId+"").get(0).getTitle());

        // Datos de usuarios con más préstamos
        dataset.addValue(mostLoansUserCount, "Usuarios con más préstamos", daoUser.listarId(mostLoansUserId+"").get(0).getName());
        dataset.addValue(secondMostLoansUserCount, "Usuarios con más préstamos", daoUser.listarId(secondMostLoansUserId+"").get(0).getName());

        // Datos de libros menos prestados
        dataset.addValue(leastLoansBookCount, "Libros menos prestados", daoBook.listarId(leastLoansBookId+"").get(0).getTitle());
        dataset.addValue(secondLeastLoansBookCount, "Libros menos prestados", daoBook.listarId(secondLeastLoansBookId+"").get(0).getTitle());

        // Datos de usuarios con menos préstamos
        dataset.addValue(leastLoansUserCount, "Usuarios con menos préstamos", daoUser.listarId(leastLoansUserId+"").get(0).getName());
        dataset.addValue(secondLeastLoansUserCount, "Usuarios con menos préstamos", daoUser.listarId(secondLeastLoansUserId+"").get(0).getName());

        return dataset;
        }catch( NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void mostrarGrafica() {
        SwingUtilities.invokeLater(() -> {
            LoanReportChart example = null;
            try {
                example = new LoanReportChart("Graficas de prestamos Biblioteca Trinity");
                example.setSize(800, 600);
                example.setLocationRelativeTo(null);
                example.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
                example.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(LoanReportChart.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }
}
