package com.smn.apivendas.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.smn.apivendas.models.Produto;
import com.smn.apivendas.models.VendaItem;
import com.smn.apivendas.services.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class VendaItemDeserialize extends JsonDeserializer<VendaItem> {

    @Autowired
    private ProdutoServiceImpl produtoService;


    @Override
    public VendaItem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = p.readValueAsTree();
        VendaItem vendaItem = new VendaItem();
        Produto produto = null;
        if(node.hasNonNull("produto_id")) {
            Long produtoId = node.get("produto_id").asLong();
            produto = (produtoId > 0) ? produtoService.find(produtoId) : null;
        }

        if(node.hasNonNull("valor_unitario"))
            vendaItem.setValor_unitario(node.get("valor_unitario").asDouble());
        if(node.hasNonNull("quantidade"))
            vendaItem.setQuantidade(node.get("quantidade").asDouble());
        if(node.hasNonNull("quantidade_devolvido"))
            vendaItem.setQuantidade_devolvido(node.get("quantidade_devolvido").asDouble());
        if(node.hasNonNull("valor_desconto"))
            vendaItem.setValor_desconto(node.get("valor_desconto").asDouble());
        if(node.hasNonNull("valor_total"))
            vendaItem.setValor_total(node.get("valor_total").asDouble());
        if(node.hasNonNull("devolvido"))
            vendaItem.setDevolvido(node.get("devolvido").asBoolean());

        if (produto != null)
            vendaItem.setProdutoId(produto);

        return vendaItem;

    }
}
