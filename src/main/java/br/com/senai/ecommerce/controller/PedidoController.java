package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.entities.Pedido;
import br.com.senai.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setAndares(pedidoAtualizado.getAndares());
                    pedido.setCor1(pedidoAtualizado.getCor1());
                    pedido.setCor2(pedidoAtualizado.getCor2());
                    pedido.setCor3(pedidoAtualizado.getCor3());
                    pedido.setDesenho1(pedidoAtualizado.getDesenho1());
                    pedido.setDesenho2(pedidoAtualizado.getDesenho2());
                    pedido.setDesenho3(pedidoAtualizado.getDesenho3());
                    Pedido pedidoSalvo = pedidoRepository.save(pedido);
                    return ResponseEntity.ok(pedidoSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
