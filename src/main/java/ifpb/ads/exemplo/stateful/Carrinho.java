/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.exemplo.stateful;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/02/2017, 08:12:31
 */
public interface Carrinho {

    void adicionar(String novoProduto);

    void finalizarCarrinho();

    List<String> listarTodos();

    void remover(String novoProduto);
    
}
