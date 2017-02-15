package ifpb.ads.exemplo.stateful;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/02/2017, 07:28:19
 */
@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

    @Inject
//    @EJB
    private CarrinhoDeCompra carrinho;
    private String produto;

    public String finalizarCarrinho() {
//        this.carrinho = new CarrinhoDeCompra();
        this.carrinho.finalizarCarrinho();
        this.produto = "";
        logout();
        return null;
    }

    public String remover(String produto) {
        this.carrinho.remover(produto);
        return null;
    }

    public String adicionar() {
        this.carrinho.adicionar(produto);
        this.produto = "";
        return null;
    }

    public List<String> getProdutos() {
        return this.carrinho.listarTodos();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    private void logout() {
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        HttpSession session = (HttpSession) context.getSession(true);
        session.invalidate();
        try {
            context.redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControladorDeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
