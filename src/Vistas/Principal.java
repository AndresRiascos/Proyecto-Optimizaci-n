package Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import LectorTexto.LectorArchivos;
import Logica.*;


public class Principal extends JFrame{
	
	// Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leerTexto;
    private javax.swing.JLabel logoU;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre3;
    private javax.swing.JTextArea solucion;
    private javax.swing.JButton solucionar;
    private javax.swing.JLabel titulo;
    // End of variables declaration  
    
    LectorArchivos lA = new LectorArchivos();
    
    public Principal() {
        initComponents();
        setSize(760, 580);  //damos el tamaño a la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Proyecto Optimización");
    }
    
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        leerTexto = new javax.swing.JButton();
        logoU = new javax.swing.JLabel();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        solucionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        solucion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Poor Richard", 0, 28)); // NOI18N
        titulo.setText("Proyecto    Optimización");

        leerTexto.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        leerTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logotxt.png"))); // NOI18N
        leerTexto.setText("Leer Texto");
        leerTexto.setToolTipText("");
        leerTexto.setMaximumSize(new java.awt.Dimension(147, 47));
        leerTexto.setMinimumSize(new java.awt.Dimension(147, 47));
        leerTexto.setPreferredSize(new java.awt.Dimension(147, 47));
        leerTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	leerTextoActionPerformed(evt);
            }
        });

        logoU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoU2.png"))); // NOI18N

        nombre1.setFont(new java.awt.Font("Poor Richard", 0, 16)); // NOI18N
        nombre1.setText("Héctor  Fabio  Ocampo  Arbelaez  -  1355858");

        nombre2.setFont(new java.awt.Font("Poor Richard", 0, 16)); // NOI18N
        nombre2.setText("Carlos  Andrés  Riascos  Pareja  -  1356541");

        nombre3.setFont(new java.awt.Font("Poor Richard", 0, 16)); // NOI18N
        nombre3.setText("Luis  Fernando  Quintero  Castaño  -  1663714");

        solucionar.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        solucionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoSolucion.png"))); // NOI18N
        solucionar.setText("Solucionar");
        solucionar.setToolTipText("");
        solucionar.setEnabled(false);
        solucionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solucionarActionPerformed(evt);
            }
        });

        solucion.setColumns(20);
        solucion.setFont(new java.awt.Font("Poor Richard", 0, 14)); // NOI18N
        solucion.setRows(5);
        solucion.setEnabled(false);
        solucion.setDisabledTextColor(Color.BLACK);
        jScrollPane1.setViewportView(solucion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre2)
                            .addComponent(nombre1)
                            .addComponent(nombre3))
                        .addGap(18, 18, 18)
                        .addComponent(logoU)
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(solucionar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leerTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(leerTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(solucionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoU)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombre3)))
                .addGap(24, 24, 24))
        );

        pack();
    }

  //oyente para leer archivo de texto
    private void leerTextoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	solucion.setText("");
    	lA.leerArchivo();
    	ArrayList<String[]> ciudades = lA.getCiudades();
    	solucion.append("Tamaño del cuadrado:  " + lA.getTamanoCuadrado()+"\n");
    	solucion.append("Número de ciudades:  " + lA.getNumeroCiudades()+"\n");
    	for (int j = 0; j < ciudades.size(); j++) {
            String[] value = ciudades.get(j);
            solucion.append(Arrays.toString(value)+"\n");
        }
    	solucionar.setEnabled(true);
    }
    
  //oyente para el boton solucionar
    private void solucionarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	solucion.append("\n ... Solucionando .... \n");
		SolucionModelo sM = new SolucionModelo();
		solucion.append("La solución es: \n");
		solucion.append(sM.solucionar(lA));
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
	}

}
