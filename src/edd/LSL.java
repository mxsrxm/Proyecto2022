/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.io.Serializable;

/**
 *
 * @author mxsrxm
 */
public class LSL implements Serializable
{
    private Nodo r = null;

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }

    public boolean inserta(Nodo n)
    {
        if (n == null)
        {
            return false;
        } else
        {
            if (r == null)
            {
                r = n;
            } else
            {
                if (n.getEtiqueta().compareTo(r.getEtiqueta()) < 0)
                {
                    n.setSig(r);
                    r = n;
                } else
                {
                    Nodo aux = r;
                    boolean bool = true;
                    while (aux.getSig() != null && bool)
                    {
                        if (n.getEtiqueta().compareTo(aux.getSig().getEtiqueta()) < 0)
                        {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            bool = false;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                    if (bool)
                    {
                        aux.setSig(n);
                    }
                }
            }
            return true;
        }
    }

    public Nodo eliminar(String etq)
    {
        if (r == null)
        {
            return null;
        } else
        {
            Nodo aux = null;
            if (etq.compareTo(r.getEtiqueta()) >= 0)
            {
                if (r.getEtiqueta().equals(etq))
                {
                    aux = r;
                    if (r.getSig() == null)
                    {
                        r = null;
                    } else
                    {
                        r = r.getSig();
                    }
                    aux.setSig(null);
                } else
                {
                    Nodo aux2 = r;
                    boolean b = true;
                    while (aux2.getSig() != null && b)
                    {
                        if (aux2.getSig().getEtiqueta().equals(etq))
                        {
                            aux = aux2.getSig();
                            aux2.setSig(aux.getSig());
                            aux.setSig(null);
                            b = false;
                        } else
                        {
                            aux2 = aux2.getSig();
                        }
                    }
                }
            }
            return aux;
        }
    }

    public String desp(Nodo r)
    {
        String s = "";
        while (r != null)
        {
            s += r.getEtiqueta();
            r = r.getSig();
        }
        return s;
    }

    public static LSL etiquetas(Nodo r)
    {
        LSL lista = new LSL();
        Nodo aux = r;
        while (aux != null)
        {
            Nodo tm = new Nodo(null, aux.getEtiqueta());
            lista.inserta(tm);
            aux = aux.getSig();
        }
        return lista;
    }

}