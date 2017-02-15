package ifpb.ads.exemplo.stateful;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/02/2017, 07:25:40
 */
@Stateful
public class CarrinhoDeCompra implements Carrinho {

    private final List<String> produtos = new ArrayList<>();
    @Override
    public void adicionar(String novoProduto) {
        this.produtos.add(novoProduto);
    }
    @Override
    public void remover(String novoProduto) {
        this.produtos.remove(novoProduto);
    }
    @Override
    public List<String> listarTodos() {
        return Collections.unmodifiableList(produtos);
    }
    
    @Remove
    @Override
    public void finalizarCarrinho(){
        this.produtos.forEach(System.out::println);
    }

}
