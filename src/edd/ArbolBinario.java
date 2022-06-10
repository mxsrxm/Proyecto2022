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
public class ArbolBinario implements Serializable
{

    private NodoArbol r = null;

    public NodoArbol inserta(NodoArbol r, NodoArbol n)
    {
        if (r == null)
        {
            return n;
        } else
        {
            if (r.getEtiqueta().compareTo(n.getEtiqueta()) > 0)
            {
                r.setIzq(inserta(r.getIzq(), n));
            } else
            {
                r.setDer(inserta(r.getDer(), n));
            }
            r = balancear(r);
            return r;
        }
    }

    public void elimina(NodoArbol r, String etq, NodoArbol arr[])
    {
        if (r == null)
        {
            arr[0] = null;
            arr[1] = r;
        } else
        {
            if (r.getEtiqueta().equals(etq))
            {
                arr[0] = r;
                if (r.getDer() == null && r.getIzq() == null)
                {
                    arr[1] = null;
                } else
                {
                    if (!(r.getDer() != null && r.getIzq() != null))
                    {
                        if (r.getDer() != null)
                        {
                            arr[1] = r.getDer();
                        } else
                        {
                            arr[1] = r.getIzq();
                        }
                        arr[1] = balancear(arr[1]);
                    } else
                    {
                        if (r.getDer().getIzq() == null)
                        {
                            arr[1] = r.getDer();
                            r.getDer().setIzq(r.getIzq());
                        } else
                        {
                            NodoArbol se = sucesorE(r);
                            arr[1] = se.getIzq();
                            se.setIzq(arr[1].getDer());
                            arr[1].setDer(r.getDer());
                            arr[1].setIzq(r.getIzq());
                        }
                        arr[1] = balancear(arr[1]);
                        r.setDer(null);
                        r.setIzq(null);
                    }
                }
            } else
            {
                if (r.getEtiqueta().compareTo(etq) > 0)
                {
                    elimina(r.getIzq(), etq, arr);
                    r.setIzq(arr[1]);
                } else
                {
                    elimina(r.getDer(), etq, arr);
                    r.setDer(arr[1]);
                }
                arr[1] = r;
            }
        }
    }

    public NodoArbol busqueda(NodoArbol r, String etq)
    {
        NodoArbol encontrado = null;
        if (r != null)
        {
            if (r.getEtiqueta().compareToIgnoreCase(etq) == 0)
            {
                encontrado = r;
            } else
            {
                if (r.getEtiqueta().compareToIgnoreCase(etq) > 0)
                {
                    encontrado = busqueda(r.getIzq(), etq);
                } else
                {
                    encontrado = busqueda(r.getDer(), etq);
                }
            }
        } else
        {
            return null;
        }
        return encontrado;
    }

    public NodoArbol sucesorE(NodoArbol r)
    {
        if (r.getIzq().getIzq() != null)
        {
            return sucesorE(r.getIzq());
        } else
        {
            return r;
        }
    }

    /**
     * @return the r
     */
    public NodoArbol getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r)
    {
        this.r = r;
    }

    public String enOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += enOrden(r.getIzq()) + " ";
            s += r.getEtiqueta() + " ";
            s += enOrden(r.getDer()) + " ";
        }
        return s;
    }

    public String preOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += r.getEtiqueta() + " ";
            s += preOrden(r.getIzq()) + " ";
            s += preOrden(r.getDer()) + " ";
        }
        return s;
    }

    public String postOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += postOrden(r.getIzq());
            s += postOrden(r.getDer());
            s += r.getEtiqueta();
        }
        return s;
    }

    public NodoArbol balancear(NodoArbol r)
    {
        if (r != null)
        {
            if (altura(r.getIzq(), 0) - altura(r.getDer(), 0) == 2)
            {
                if (altura(r.getIzq().getIzq(), 0) >= altura(r.getIzq().getDer(), 0))
                {
                    r = rotar_s(r, true);
                } else
                {
                    r = rotar_d(r, true);
                }
            } else if (altura(r.getDer(), 0) - altura(r.getIzq(), 0) == 2)
            {
                if (altura(r.getDer().getDer(), 0) >= altura(r.getDer().getIzq(), 0))
                {
                    r = rotar_s(r, false);
                } else
                {
                    r = rotar_d(r, false);
                }
            }
        }
        return r;
    }

    public NodoArbol rotar_d(NodoArbol r, boolean izq)
    {
        if (izq)
        {
            r.setIzq(rotar_s(r.getIzq(), false));
            r = rotar_s(r, true);
        } else
        {
            r.setDer(rotar_s(r.getDer(), true));
            r = rotar_s(r, false);
        }

        return r;
    }

    public NodoArbol rotar_s(NodoArbol r, boolean izq)
    {
        NodoArbol tmp;
        if (izq)
        {
            tmp = r.getIzq();
            r.setIzq(tmp.getDer());
            tmp.setDer(r);
        } else
        {
            tmp = r.getDer();
            r.setDer(tmp.getIzq());
            tmp.setIzq(r);
        }
        return tmp;
    }

    public int altura(NodoArbol r, int a)
    {
        if (r == null)
        {
            return a;
        } else
        {
            return max(altura(r.getIzq(), a + 1), altura(r.getDer(), a + 1));
        }

    }

    public int max(int a, int b)
    {
        return a > b ? a : b;
    }

}