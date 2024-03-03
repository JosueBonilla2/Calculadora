/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

/**
 *
 * @author Papubonilla
 */
public class Frame01 extends javax.swing.JFrame implements ActionListener{
    
    JTextArea pantalla;
    
    JButton uno;
    JButton dos;
    JButton tres;
    JButton cuatro;
    JButton cinco;
    JButton seis;
    JButton siete;
    JButton ocho;
    JButton nueve;
    JButton cero;
    JButton punto;
    
    JButton mas;
    JButton menos;
    JButton multiplicacion;
    JButton divicion;
    JButton modulo;
    JButton potencia;
    JButton borrar;
    JButton eliminar;
    JButton igual;
    
    public Frame01(){
        setTitle("Calculadora");
        setSize(360, 415);
        getContentPane().setBackground(Color.BLACK);
        
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        Color colorBarra = new Color(0, 0, 0);
        getRootPane().setForeground(colorBarra);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        pantalla = new JTextArea();
        pantalla.setBounds(5, 5, 330, 90);
        pantalla.setBackground(Color.BLACK);
        pantalla.setForeground(Color.YELLOW);
        pantalla.setFont(new Font("Arial", Font.PLAIN, 20));
        pantalla.setAlignmentX(Component.CENTER_ALIGNMENT);
        pantalla.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(pantalla);
        
        modulo = new JButton("%");
        modulo.setBounds(5, 100, 80, 50);
        modulo.addActionListener(this);
        add(modulo);
        
        potencia = new JButton("^");
        potencia.setBounds(90, 100, 80, 50);
        potencia.addActionListener(this);
        add(potencia);
        
        borrar = new JButton("DEL");
        borrar.setBounds(175, 100, 80, 50);
        borrar.addActionListener(this);
        add(borrar);
        
        eliminar = new JButton("AC");
        eliminar.setBounds(260, 100, 80, 50);
        eliminar.addActionListener(this);
        add(eliminar);
        
        uno = new JButton("1");
        uno.setBounds(5, 155, 80, 50);
        atributosButton(uno);
        uno.addActionListener(this);
        add(uno);
        
        dos = new JButton("2");
        dos.setBounds(90, 155, 80, 50);
        atributosButton(dos);
        dos.addActionListener(this);
        add(dos);
        
        tres = new JButton("3");
        tres.setBounds(175, 155, 80, 50);
        atributosButton(tres);
        tres.addActionListener(this);
        add(tres);
        
        mas = new JButton("+");
        mas.setBounds(260, 155, 80, 50);
        mas.addActionListener(this);
        add(mas);
        
        cuatro = new JButton("4");
        cuatro.setBounds(5, 210, 80, 50);
        atributosButton(cuatro);
        cuatro.addActionListener(this);
        add(cuatro);
        
        cinco = new JButton("5");
        cinco.setBounds(90, 210, 80, 50);
        atributosButton(cinco);
        cinco.addActionListener(this);
        add(cinco);
        
        seis = new JButton("6");
        seis.setBounds(175, 210, 80, 50);
        atributosButton(seis);
        seis.addActionListener(this);
        add(seis);
        
        menos = new JButton("-");
        menos.setBounds(260, 210, 80, 50);
        menos.addActionListener(this);
        add(menos);
        
        siete = new JButton("7");
        siete.setBounds(5, 265, 80, 50);
        atributosButton(siete);
        siete.addActionListener(this);
        add(siete);
        
        ocho = new JButton("8");
        ocho.setBounds(90, 265, 80, 50);
        atributosButton(ocho);
        ocho.addActionListener(this);
        add(ocho);
        
        nueve = new JButton("9");
        nueve.setBounds(175, 265, 80, 50);
        atributosButton(nueve);
        nueve.addActionListener(this);
        add(nueve);
        
        menos = new JButton("*");
        menos.setBounds(260, 265, 80, 50);
        menos.addActionListener(this);
        add(menos);
        
        punto = new JButton(".");
        punto.setBounds(5, 320, 80, 50);
        punto.addActionListener(this);
        add(punto);
        
        cero = new JButton("0");
        cero.setBounds(90, 320, 80, 50);
        atributosButton(cero);
        cero.addActionListener(this);
        add(cero);
        
        igual = new JButton("=");
        igual.setBounds(175, 320, 80, 50);
        igual.addActionListener(this);
        add(igual);
        
        punto = new JButton("/");
        punto.setBounds(260, 320, 80, 50);
        punto.addActionListener(this);
        add(punto);
        
        setVisible(true);
    }
    
    public void atributosButton(JButton boton){
        boton.setBackground(new Color(255, 215, 0));
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(boton.getBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        boton.setBorder(BorderFactory.createLineBorder(new Color(71, 58, 6)));
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String textoBoton = ((JButton) e.getSource()).getText();
        if (e.getSource() == eliminar) {
            pantalla.setText("");
        } else if (e.getSource() == borrar) {
            String textoActual = pantalla.getText();
            if (!textoActual.isEmpty()) {
                String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                pantalla.setText(nuevoTexto);
            }
        } else if (e.getSource() == igual) {
            String expresion = pantalla.getText();
            double resultado = evaluarExpresion(expresion);
            String res = String.valueOf(resultado);
            pantalla.setText(res);
        } else {
            pantalla.append(textoBoton);
        }
    }

    private double evaluarExpresion(String expresion) {
        Operaciones op = new Operaciones();
        double resultado = 0.0;
        String[] partes = expresion.split("(?<=[-+*/%^])|(?=[-+*/%^])");
        double num1 = Double.parseDouble(partes[0]);
        double num2 = Double.parseDouble(partes[2]);
        switch (partes[1]) {
            case "+":
                resultado = op.sumar(num1, num2);     
                break;
            case "-":
                resultado = op.restar(num1, num2);
                break;
            case "*":
                resultado = op.multiplicar(num1, num2);
                break;
            case "/":
                resultado = op.dividir(num1, num2);
                break;
            case "%":
                resultado = op.calcularModulo(num1, num2);
                break;
            case "^":
                resultado = op.calcularPotencia(num1, num2);
                break;
            default:
                throw new ArithmeticException("Operador no válido");
        }
        return resultado;
    }
}
