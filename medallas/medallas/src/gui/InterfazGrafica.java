package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestion.Medalleria;
import gestion.Medallista;
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


public class InterfazGrafica extends JFrame {

    private Medalleria medalleria;

    public InterfazGrafica() {
        medalleria = new Medalleria();

        setTitle("Sistema de Medallería");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cambiar el fondo y el color del panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(0, 2, 10, 10));
        panelFormulario.setBackground(Color.LIGHT_GRAY);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField campoPais = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoDisciplina = new JTextField();
        JTextField campoCategoria = new JTextField();
        JTextField campoSubcategoria = new JTextField();
        JTextField campoTipoMedalla = new JTextField();
        JTextField campoAño = new JTextField();
        JTextField campoEdad = new JTextField();

        // Configuración de las etiquetas con fuente más grande y negrita
        JLabel labelPais = new JLabel("País:");
        labelPais.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelDisciplina = new JLabel("Disciplina:");
        labelDisciplina.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelCategoria = new JLabel("Categoría:");
        labelCategoria.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelSubcategoria = new JLabel("Subcategoría:");
        labelSubcategoria.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelTipoMedalla = new JLabel("Tipo de Medalla:");
        labelTipoMedalla.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelAño = new JLabel("Año:");
        labelAño.setFont(new Font("Sans Serif", Font.BOLD, 14));
        JLabel labelEdad = new JLabel("Edad:");
        labelEdad.setFont(new Font("Sans Serif", Font.BOLD, 14));

        // Añadir las etiquetas y campos al formulario
        panelFormulario.add(labelPais);
        panelFormulario.add(campoPais);
        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(labelDisciplina);
        panelFormulario.add(campoDisciplina);
        panelFormulario.add(labelCategoria);
        panelFormulario.add(campoCategoria);
        panelFormulario.add(labelSubcategoria);
        panelFormulario.add(campoSubcategoria);
        panelFormulario.add(labelTipoMedalla);
        panelFormulario.add(campoTipoMedalla);
        panelFormulario.add(labelAño);
        panelFormulario.add(campoAño);
        panelFormulario.add(labelEdad);
        panelFormulario.add(campoEdad);

        // Crear y estilizar los botones
        JButton botonAgregar = new JButton("Agregar Medallista");
        botonAgregar.setBackground(new Color(34, 139, 34));
        botonAgregar.setForeground(Color.WHITE);
        botonAgregar.setFont(new Font("Sans Serif", Font.BOLD, 12));
        botonAgregar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        botonAgregar.setFocusPainted(false);

        JButton botonListar = new JButton("Listar Medallistas");
        botonListar.setBackground(new Color(30, 144, 255));
        botonListar.setForeground(Color.WHITE);
        botonListar.setFont(new Font("Sans Serif", Font.BOLD, 12));
        botonListar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        botonListar.setFocusPainted(false);

        JButton botonFiltrarPais = new JButton("Filtrar por País");
        botonFiltrarPais.setBackground(new Color(255, 165, 0));
        botonFiltrarPais.setForeground(Color.WHITE);
        botonFiltrarPais.setFont(new Font("Sans Serif", Font.BOLD, 12));
        botonFiltrarPais.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        botonFiltrarPais.setFocusPainted(false);

        JButton botonFiltrarMedalla = new JButton("Filtrar por Medalla");
        botonFiltrarMedalla.setBackground(new Color(255, 69, 0));
        botonFiltrarMedalla.setForeground(Color.WHITE);
        botonFiltrarMedalla.setFont(new Font("Sans Serif", Font.BOLD, 12));
        botonFiltrarMedalla.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        botonFiltrarMedalla.setFocusPainted(false);

        // Añadir funcionalidad a los botones
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medallista medallista = new Medallista(
                        campoPais.getText(),
                        campoNombre.getText(),
                        campoDisciplina.getText(),
                        campoCategoria.getText(),
                        campoSubcategoria.getText(),
                        campoTipoMedalla.getText(),
                        Integer.parseInt(campoAño.getText()),
                        Integer.parseInt(campoEdad.getText())
                );
                medalleria.agregarMedallista(medallista);
                JOptionPane.showMessageDialog(null, "Medallista agregado con éxito.");
            }
        });

        botonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea areaTexto = new JTextArea();
                for (Medallista m : medalleria.listarMedallistas()) {
                    areaTexto.append(m.toString() + "\n");
                }
                JOptionPane.showMessageDialog(null, new JScrollPane(areaTexto), "Listado de Medallistas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonFiltrarPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pais = JOptionPane.showInputDialog("Ingrese el país:");
                JTextArea areaTexto = new JTextArea();
                for (Medallista m : medalleria.listarMedallistasPorPais(pais)) {
                    areaTexto.append(m.toString() + "\n");
                }
                JOptionPane.showMessageDialog(null, new JScrollPane(areaTexto), "Medallistas de " + pais, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonFiltrarMedalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoMedalla = JOptionPane.showInputDialog("Ingrese el tipo de medalla (Oro, Plata, Bronce):");
                JTextArea areaTexto = new JTextArea();
                for (Medallista m : medalleria.listarMedallistasPorMedalla(tipoMedalla)) {
                    areaTexto.append(m.toString() + "\n");
                }
                JOptionPane.showMessageDialog(null, new JScrollPane(areaTexto), "Medallistas con Medalla de " + tipoMedalla, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Crear panel para botones con espacio y estilo
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        panelBotones.add(botonAgregar);
        panelBotones.add(botonListar);
        panelBotones.add(botonFiltrarPais);
        panelBotones.add(botonFiltrarMedalla);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfaz = new InterfazGrafica();
            interfaz.setVisible(true);
        });
    }
}
