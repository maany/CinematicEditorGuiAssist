/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic;

import com.jme3.gde.cinematic.core.CinematicClip;
import com.jme3.gde.cinematic.gui.Rule;
import com.jme3.gde.cinematic.gui.TableSplitter;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author MAYANK
 */
public class ATopComponent extends javax.swing.JFrame {

    private JTable layerContainer = null;
    private CinematicClip cinematicClip = null;
    
    /**
     * Creates new form ATopComponent
     */
    public ATopComponent() {
        initComponents();
        initCinematicEditor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredPane = new javax.swing.JLayeredPane();
        timeSlider = new javax.swing.JPanel();
        timeSliderDEL = new javax.swing.JLabel();
        topContainer = new javax.swing.JScrollPane();
        timeline = new javax.swing.JTable();
        navigator = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout timeSliderLayout = new javax.swing.GroupLayout(timeSlider);
        timeSlider.setLayout(timeSliderLayout);
        timeSliderLayout.setHorizontalGroup(
            timeSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        timeSliderLayout.setVerticalGroup(
            timeSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        timeSlider.setBounds(110, 20, 10, 100);
        layeredPane.add(timeSlider, javax.swing.JLayeredPane.DEFAULT_LAYER);

        timeSliderDEL.setText("jLabel1");
        timeSliderDEL.setBounds(170, 10, 40, 126);
        layeredPane.add(timeSliderDEL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        timeline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        timeline.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        timeline.setAutoscrolls(false);
        topContainer.setViewportView(timeline);

        topContainer.setBounds(60, 20, 450, 110);
        layeredPane.add(topContainer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        navigator.setText("navigator");
        navigator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                navigatorMouseReleased(evt);
            }
        });
        navigator.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                navigatorMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(navigator)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(navigator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navigatorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigatorMouseDragged
        navigator.setLocation(evt.getXOnScreen(), navigator.getLocation().y);
        // navigator.setText(new Integer(evt.getXOnScreen()).toString());
    }//GEN-LAST:event_navigatorMouseDragged

    private void navigatorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigatorMouseReleased
        navigator.setText(new Integer(evt.getXOnScreen()).toString());
    }//GEN-LAST:event_navigatorMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Aqua".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATopComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATopComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATopComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATopComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATopComponent().setVisible(true);
            }
        });
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JLabel navigator;
    private javax.swing.JPanel timeSlider;
    private javax.swing.JLabel timeSliderDEL;
    private javax.swing.JTable timeline;
    private javax.swing.JScrollPane topContainer;
    // End of variables declaration//GEN-END:variables

    /**
     * This method loads the different renderer's, and splits the main JTable into layerContainer and timeline
     */
    
    private void initCinematicEditor() {
        
       // cinematicClip = new CinematicClip();
        System.out.println("before split width : " + timeline.getWidth() + " cOLUMN Count :" + timeline.getColumnCount());
        initTimeline();
         System.out.println("after timeline init  width : " + timeline.getWidth() + " cOLUMN Count :" + timeline.getColumnCount());
        TableSplitter tableSplitter = new TableSplitter(1,topContainer);
        layerContainer = tableSplitter.getLayerContainer(); 
        layerContainer.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         System.out.println("after split width : " + timeline.getWidth() + " cOLUMN Count :" + timeline.getColumnCount());
         System.out.println("First Header Value :" + timeline.getColumnModel().getColumn(0).getHeaderValue().toString());
          System.out.println("Layer Container First header value : " + layerContainer.getColumnModel().getColumnCount() );
        // Now, the variable timeline refers to table on RHS, while layerContainer refers to table on LHS
        initLayerContainer();
        initTimeSlider();
    }

    private void initTimeline() {
        double durationValue = cinematicClip.getDuration();
        DefaultTableModel model = (DefaultTableModel) timeline.getModel();
        model.setColumnCount((int) durationValue);
        int cols = model.getColumnCount();
        System.out.println("ColumnCount during initTimeline : " + cols);
        TableColumnModel columnModel = timeline.getColumnModel();
        
        TableColumn layersColumn = columnModel.getColumn(0);
        layersColumn.setHeaderValue("Layers");
        layersColumn.setMinWidth(80);
        layersColumn.setPreferredWidth(80);
        
        for(int i=1;i<cols;i++)
        {
            TableColumn column =  columnModel.getColumn(i);
            column.setHeaderValue(i);
            System.out.println("running for " + i);
            column.setMinWidth(30);
            // column.setMaxWidth(30);
            column.setPreferredWidth(30);
            column.setMaxWidth(30);
        }
        System.out.println("success");
        timeline.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }

    private void initLayerContainer() {
        //Frame showHide = new Frame();
        //layerContainer.addColumn(showHide);
        
    }
    private void initTimeSlider() {
        System.out.println("count : " + layeredPane.getComponentCount());
        // BUGGED - overlapping occurs. try changing cell renderers
        //  layeredPane.setLayer(topContainer,0);
        //layeredPane.setLayer(timeSlider,100);
        //layeredPane.setComponentZOrder(topContainer,0);
        timeSlider.setBackground(Color.red);
        timeSlider.setOpaque(true);
        //Rectangle cellRect = timeline.getCellRect(0,1, false);
        
        
        for(int i=0;i<timeline.getColumnCount();i++)
        {
            System.out.println("Col "+ (i+1) + ":" + timeline.getCellRect(0,i,false).getMaxX());
        }
        //timeSlider.setLocation(cellRect.x,timeSlider.getLocation().y);
       // timeSlider.setLocation((renderer.getX() + timeline.getCellRect(0, 2,false).x)/2,timeSlider.getLocation().y);
    
        timeline.setValueAt("This is it",0, 0);
        //DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)timeline.getCellRenderer(0, 0);
        //System.out.println("Renderer X : "+ renderer.getX());
        
        //Rectangle bounds = topContainer.getBounds();
        //System.out.println("Height : " + bounds.height + " width :" + bounds.width + " x :" + bounds.x + " y :" + bounds.y );
        //int location = (bounds.x + bounds.width) - 111;//(timeline.getColumnModel().getTotalColumnWidth()/3);
        //System.out.println("Location : " + location);
        //timeSlider.setLocation(location,20);
        //System.out.println("layerContainer Column Width : " + layerContainer.getColumnModel().getTotalColumnWidth() + "timeline " + timeline.getColumnModel().getTotalColumnWidth());
        
        System.out.println(timeline.getBounds());
        System.out.println(layerContainer.getBounds());
        System.out.println(topContainer.getBounds());
        for(int i=0;i<layerContainer.getColumnCount();i++)
            System.out.println("location : " + layerContainer.getColumnModel().getColumn(i).getHeaderValue() + " position : " + layerContainer.getColumnModel().getColumn(i).getWidth());
        
        for(int i=0;i<timeline.getColumnCount();i++)
            System.out.println("location : " + timeline.getColumnModel().getColumn(i).getHeaderValue() + " width : " + timeline.getColumnModel().getColumn(i).getWidth());
        
        
        System.out.println("Lyer container width :" + layerContainer.getWidth() + "timeline" + timeline.getWidth() + " timeline column count : " + timeline.getColumnCount());
        int startPoint = topContainer.getBounds().x ;
        for(int i=0;i<layerContainer.getColumnCount();i++)
        {
            startPoint+= layerContainer.getColumnModel().getColumn(i).getWidth() + layerContainer.getColumnModel().getColumnMargin();
            System.out.println("Adding " + layerContainer.getColumnModel().getColumn(i).getWidth());
        }
        startPoint+= 2*timeline.getColumnModel().getColumn(0).getWidth();
        timeSlider.setLocation(startPoint,20);
        
        topContainer.setColumnHeaderView(new Rule(Rule.HORIZONTAL, true));
        
        topContainer.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                
            }
        });
        
    }
}
