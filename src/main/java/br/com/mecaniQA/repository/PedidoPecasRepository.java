package br.com.mecaniQA.repository;

import br.com.mecaniQA.model.ItemPedidoPecas;
import br.com.mecaniQA.model.PedidoPecas;
import br.com.mecaniQA.model.StatusPedidoPecas;

import java.util.ArrayList;
import java.util.List;

public class PedidoPecasRepository {

    private static PedidoPecasRepository instance;

    private List<PedidoPecas> pedidosPecas;
    private Long proximoCodigo = 1L;

    private PedidoPecasRepository() {
        pedidosPecas = new ArrayList<>();
    }

    public static PedidoPecasRepository getInstance() {
        if (instance == null) {
            instance = new PedidoPecasRepository();
        }

        return instance;
    }

    public PedidoPecas cadastrar(PedidoPecas pedidoPecas) {
        pedidoPecas.setCodigo(proximoCodigo);
        proximoCodigo++;

        pedidosPecas.add(pedidoPecas);

        return pedidoPecas;
    }

    public List<PedidoPecas> listar() {
        return pedidosPecas;
    }

    public PedidoPecas buscarPorCodigo(Long codigo) {
        for (PedidoPecas pedidoPecas : pedidosPecas) {
            if (pedidoPecas.getCodigo().equals(codigo)) {
                return pedidoPecas;
            }
        }

        return null;
    }

    public PedidoPecas atualizarStatus(
            Long codigo,
            StatusPedidoPecas status) {

        PedidoPecas pedidoPecas = buscarPorCodigo(codigo);

        if (pedidoPecas == null) {
            return null;
        }

        pedidoPecas.setStatus(status);

        return pedidoPecas;
    }

    public PedidoPecas adicionarItem(
            Long codigoPedido,
            ItemPedidoPecas item) {

        PedidoPecas pedidoPecas = buscarPorCodigo(codigoPedido);

        if (pedidoPecas == null) {
            return null;
        }

        pedidoPecas.adicionarItem(item);

        return pedidoPecas;
    }

    public boolean excluir(Long codigo) {
        PedidoPecas pedidoPecas = buscarPorCodigo(codigo);

        if (pedidoPecas == null) {
            return false;
        }

        pedidosPecas.remove(pedidoPecas);

        return true;
    }
}