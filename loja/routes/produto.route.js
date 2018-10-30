const express = require('express');
const router = express.Router();

const produto_controller = require('../controllers/produto.controller');

// retorna todos os registros do banco
router.get('/registros', produto_controller.registros);
// pesquisa os dados do registro passado por ID
router.get('/buscar/:id', produto_controller.buscar);
// cria um produto através dos parametros passados no formato json
router.post('/criar', produto_controller.criar);
// atualiza os dados do produto através do ID
router.put('/atualizar/:id', produto_controller.atualizar);
// exclui o produto da ID informada
router.delete('/excluir/:id', produto_controller.excluir);
// comprar um produto passando seu NOME e QUANT (quantidade do produto)
router.get('/compra/:nome/:quant', produto_controller.compra);

module.exports = router;