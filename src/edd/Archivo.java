/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mxsrxm
 */
public class Archivo implements Serializable
{
    
    private Nodo raiz = null;
    private ArbolBinario arbol = new ArbolBinario();

    public static Archivo leer()
    {
        Archivo info = null;
        
        try
        {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("archivo.dat"));
            info = (Archivo) file.readObject();
            file.close();
        } catch (ClassNotFoundException ex)
        {
            System.out.println("La clase no existe o diferente");
        } catch (IOException e)
        {
            System.out.println("No existe el archivo");
        }
        return info;
    }
    
    public static void guardar(Archivo info)
    {
        try
        {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("archivo.dat"));
            file.writeObject(info);
            file.close();
        } catch (IOException ex)
        {
            System.out.println("No se encontro archivo");
        }
    }
    
    public void insertaMultilista(Nodo aux, String[] etiqueta)
    {
        raiz = Multilistas.inserta(raiz, aux, 0, etiqueta);
    }
    
    public void insertaArbol(NodoArbol nuevo)
    {
        arbol.setR(arbol.inserta(arbol.getR(), nuevo));
    }
    
    public Nodo getRaiz()
    {
        return raiz;
    }
    
}
