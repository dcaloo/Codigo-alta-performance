package arvores;

public class ABBint {
    private class NO{
        int dado;
        NO esq, dir;
    }

    public NO root = null;

    public NO inserir(NO p, int info){
        if(p == null){
            p = new NO();
            p.dado = info;
            p.esq = null;
            p.dir = null;
        } else if(info < p.dado){
            p.esq = inserir(p.esq, info);
        } else {
            p.dir = inserir(p.dir,info);
        }
        return p;
    }

    public void show(NO p){
        if(p != null){
            show(p.esq);
            System.out.println(p.dado);
            show(p.dir);
        }
    }

    public int contaNos(NO p, int cont){
        if(p != null){
            cont++;
            cont = contaNos(p.esq, cont);
            cont = contaNos(p.dir, cont);
        }
        return cont;
    }

    public boolean achou(NO p,int valor){
        if(p != null) {
                if (p.dado == valor) {
                    return true;
                } else {
                    if (p.dado > valor) {
                       return achou(p.esq, valor);
                    } else {
                       return achou(p.dir, valor);
                    }
                }
        } else {
            return false;
        }
    }

    public int contaAchou(NO p,int valor, int contador){
        if(p != null) {
            contador++;
            if (p.dado == valor) {
                return contador;
            } else {
                if (p.dado > valor) {
                    return contaAchou(p.esq, valor,contador);
                } else {
                    return contaAchou(p.dir, valor,contador);
                }
            }
        } else {
            return contador;
        }
    }

    public  NO removeValor (NO p, int info) {
        if (p!=null){
            if(info == p.dado){
                if (p.esq == null && p.dir==null)   //nó a ser removido é nó folha
                    return null;
                if (p.esq==null){ //se não há sub-árvore esquerda o ponteiro passa apontar para a sub-árvore direita
                    return  p.dir;
                }
                else{
                    if (p.dir==null){   //se não há sub-árvore direita  o ponteiro passa apontar para a sub-árvore esquerda
                        return p.esq;
                    }
                    else{  /*o nó a ser retirado possui sub-arvore esquerda e direita, então o nó que
           será retirado deve-se encontrar o menor valor na sub-árvore á direita */
                        NO aux, ref;
                        ref = p.dir;
                        aux = p.dir;
                        while (aux.esq != null)
                            aux = aux.esq;
                        aux.esq = p.esq;
                        return ref;
                    }
                }
            }
            else{   //procura dado a ser removido na ABB
                if(info<p.dado)
                    p.esq = removeValor(p.esq,info);
                else
                    p.dir = removeValor(p.dir,info);
            }
        }
        return p;
    }

    public int maximo(){
        NO aux = root;
        while (aux.dir != null){
            aux = aux.dir;
        }
        return aux.dado;
    }

    public Integer minimo(){
        NO aux = root;
        while (aux.esq != null){
            aux = aux.esq;
        }
        return aux.dado;
    }


}
