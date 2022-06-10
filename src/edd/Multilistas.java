/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author mxsrxm
 */
public class Multilistas implements Serializable
{
    public static Nodo inserta(Nodo r, Nodo n, int nivel, String etiqueta[])
    {
        if (nivel == etiqueta.length - 1)
        {
            LSL ls = new LSL();
            ls.setR(r);
            ls.inserta(n);
            r = ls.getR();
            return r;
        } else
        {
            Nodo aux = busca(r, etiqueta[nivel]);
            if (aux != null)
            {
                aux.setAbj(inserta(aux.getAbj(), n, nivel + 1, etiqueta));
            } else
            {
                JOptionPane.showMessageDialog(null, "No se encontro el dato", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            }
            return r;
        }
    }
    
    public static Nodo busca(Nodo r, String etq)
    {
        Nodo aux = null;
        while (r != null)
        {
            if (r.getEtiqueta().equals(etq))
            {
                return r;
            } else
            {
                r = r.getSig();
            }
        }
        return aux;
    }
    
}
